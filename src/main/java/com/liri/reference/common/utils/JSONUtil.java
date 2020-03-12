package com.liri.reference.common.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.MapLikeType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * JSON工具类
 *
 * @author William
 * @date 2019/8/20
 */
public class JSONUtil {

    private static final Logger logger = LoggerFactory.getLogger(JSONUtil.class);

    private static final ObjectMapper objectMapper = new ObjectMapper();

    static {
        // 设置null时候不序列化(只针对对象属性)
        objectMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);

        // 反序列化时，属性不存在的兼容处理
        objectMapper.getDeserializationConfig().withoutFeatures(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        // 单引号处理
        // objectMapper.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);

        //序列化时候统一日期格式
        // objectMapper.setDateFormat(new SimpleDateFormat(DateUtil.FORMAT_DATE_DEFAULT));
    }

    /**
     * 将Java对象转为JSON字符串
     *
     * @param obj
     * @param <T>
     * @return
     */
    public static <T> String convertObjectToJSON(T obj) {
        String jsonStr;
        try {
            jsonStr = objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            logger.error(">>>>>> Java对象转为JSON错误:", e);
            throw new RuntimeException(e);
        }

        return jsonStr;
    }

    /**
     * 将JSON字符串转为Java对象
     *
     * @param json
     * @param type
     * @param <T>
     * @return
     */
    public static <T> T convertJSONToObject(String json, Class<T> type) {
        T obj;
        try {
            obj = objectMapper.readValue(json, type);
        } catch (Exception e) {
            logger.error(">>>>>> JSON转为Java对象错误:", e);
            throw new RuntimeException(e);
        }

        return obj;
    }

    /**
     * 将JSON转成相应的List
     *
     * @param jsonStr
     * @return
     */
    public static List convertJSONToList(String jsonStr) {

        JavaType javaType = JSONUtil.objectMapper.getTypeFactory().constructCollectionType(ArrayList.class, Object.class);

        try {
            return objectMapper.readValue(jsonStr, javaType);
        } catch (IOException e) {
            logger.error(">>>>>> JSON转为相应的List错误:", e);
        }

        return null;
    }

    /**
     * 将JSON转成相应的Map
     *
     * @param jsonStr
     * @return
     */
    public static Map<String, Object> convertJSONToMap(String jsonStr) {

        MapLikeType mapLikeType = JSONUtil.objectMapper.getTypeFactory().constructMapLikeType(HashMap.class, String.class, Object.class);

        try {
            return objectMapper.readValue(jsonStr, mapLikeType);
        } catch (IOException e) {
            logger.error(">>>>>> JSON转为相应的Map错误:", e);
        }

        return null;
    }
}
