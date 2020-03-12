package com.liri.reference.service.impl;

import com.liri.reference.common.constants.Constants;
import com.liri.reference.common.utils.CollectionUtil;
import com.liri.reference.common.utils.StringUtil;
import com.liri.reference.dao.DictItemDao;
import com.liri.reference.dao.WalletTypeDao;
import com.liri.reference.model.DictItemDto;
import com.liri.reference.model.WalletTypeDto;
import com.liri.reference.service.CacheService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 缓存：数据使用频繁并且很少修改
 *
 * @author William
 * @date 2019/8/19
 */
@Service
public class CacheServiceImpl implements CacheService {

    private static final Logger logger = LoggerFactory.getLogger(CacheService.class);

    @Autowired
    private WalletTypeDao walletTypeDao;

    @Autowired
    private DictItemDao dictItemDao;

    /**
     * 周期时间(单位:毫秒)
     * <p>
     * 定时刷新为10分钟 = 10 * 60 * 1000
     */
    private static long PERIOD_TIME = 10 * 60 * 1000;

    /**
     * 上一周期时间(单位:毫秒)
     */
    private static long LAST_TIME = 0L;

    /**
     * 获取所有可用的WalletType
     */
    private static List<WalletTypeDto> cacheWalletTypeList = new ArrayList<>();

    /**
     * 获取可用可用的DicItem
     */
    private static Map<String, List<DictItemDto>> cacheDicItemMap = new HashMap<>();

    @Override
    public WalletTypeDto getWalletTypeByCode(String walletTypeCode) {
        if (StringUtil.isBlank(walletTypeCode)) {
            return null;
        }

        if (CollectionUtil.isNotEmpty(cacheWalletTypeList)) {
            for (WalletTypeDto walletType : cacheWalletTypeList) {
                if (walletTypeCode.equals(walletType.getWalletTypeCode())) {
                    return walletType;
                }
            }
        }

        return null;
    }

    @Override
    public WalletTypeDto getWalletTypeBySchema(String WalletTypeSchema) {

        if (StringUtil.isBlank(WalletTypeSchema)) {
            return null;
        }

        if (CollectionUtil.isNotEmpty(cacheWalletTypeList)) {
            for (WalletTypeDto walletType : cacheWalletTypeList) {
                if (WalletTypeSchema.equals(walletType.getWalletTypeSchema())) {
                    return walletType;
                }
            }
        }

        return null;
    }

    @Override
    public List<WalletTypeDto> getWalletTypeList() {
        return cacheWalletTypeList;
    }

    @Override
    public DictItemDto getDicItemByItemCode(String dictClassCode, String dictItemCode, String walletTypeCode) {

        if (StringUtil.isBlank(dictClassCode) || StringUtil.isBlank(dictItemCode)) {
            return null;
        }

        WalletTypeDto walletType = getWalletTypeByCode(walletTypeCode);

        if (CollectionUtil.isEmpty(cacheDicItemMap)) {
            return null;
        }

        List<DictItemDto> dicItemList = cacheDicItemMap.get(dictClassCode);
        if (CollectionUtil.isNotEmpty(dicItemList)) {
            for (DictItemDto dicItem : dicItemList) {
                if (dictItemCode.equals(dicItem.getDictItemCode())
                        && (walletType == null ||
                        ( dicItem != null  && dicItem.getWalletTypeId().equals(walletType.getWalletTypeID())))) {

                    return dicItem;
                }
            }
        }

        return null;
    }

    @Override
    public List<DictItemDto> getDicItemByClassCodeList(String dictClassCode) {

        if (CollectionUtil.isEmpty(cacheDicItemMap)) {
            return null;
        }

        return cacheDicItemMap.get(dictClassCode);
    }


    /**
     * 重新加载数据
     */
    @Override
    public void reload() {

        if (timeSwitch()) {
            long startTime = System.currentTimeMillis();
            logger.info(">>>>>> The begin of the method reload time:" + startTime);

            loadWalletType();

            loadDictItem();

            long endTime = System.currentTimeMillis();
            logger.info(">>>>>> The spend time for end of method reload:" + (endTime - startTime));
        }

    }

    /**
     * 加载所有可用的WalletType
     */
    private void loadWalletType() {
        WalletTypeDto walletTypeDto = new WalletTypeDto();
        walletTypeDto.setIsDelete(0);
        List<WalletTypeDto> walletTypeList = walletTypeDao.select(walletTypeDto);

        if (CollectionUtil.isNotEmpty(walletTypeList)) {
            cacheWalletTypeList = walletTypeList;
        } else {
            logger.warn(">>>>>> WalletType is empty!");
        }
    }

    /**
     * 加载所有可用的DictItem
     */
    private void loadDictItem() {

        DictItemDto condition = new DictItemDto();
        condition.setIsDelete(0);
        List<DictItemDto> dicItemList = dictItemDao.select(condition);

        if (CollectionUtil.isNotEmpty(dicItemList)) {

            Map<String, List<DictItemDto>> dicItemMap = new HashMap<>();

            List<DictItemDto> dtoList;

            for (DictItemDto dicItem : dicItemList) {

                if (Constants.DICT_CLASS_REF.equals(dicItem.getDictClassCode())
                        && Constants.DICT_ITEM_CACHE_TIMER_PERIOD.equals(dicItem.getDictItemCode())) {

                    try {
                        PERIOD_TIME = Long.parseLong(dicItem.getDictItemValue());
                    } catch (NumberFormatException e) {
                        logger.error(">>>>>> timer period value:" + dicItem.getDictItemValue() + ", Error:", e);
                    }
                }

                if (dicItemMap.containsKey(dicItem.getDictClassCode())) {
                    dtoList = dicItemMap.get(dicItem.getDictClassCode());
                } else {
                    dtoList = new ArrayList<>();
                }
                dtoList.add(dicItem);
                dicItemMap.put(dicItem.getDictClassCode(), dtoList);
            }

            cacheDicItemMap = dicItemMap;
        } else {
            logger.warn(">>>>>> DicItem is empty!");
        }

    }


    /**
     * 定时自动开关(单位:毫秒)
     *
     * @return 超过周期返回true，反之false
     */
    private boolean timeSwitch() {

        // LAST_TIME为0时，表示第一次加载
        if ((LAST_TIME > 0L) && ((LAST_TIME + PERIOD_TIME) > System.currentTimeMillis())) {
            return false;
        }

        LAST_TIME = System.currentTimeMillis();

        return true;
    }
}
