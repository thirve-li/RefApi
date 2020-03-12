package com.liri.reference.common.utils;

import org.springframework.lang.Nullable;
import org.springframework.util.ObjectUtils;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 集合工具类
 *
 * @author William
 * @date 2019/8/20
 */
public class CollectionUtil {

    /**
     * 如果提供的集合是{@code null}或空，则返回{@code true}。否则，返回{@code false}。
     *
     * @param collection 要检查的集合
     * @return 给定集合是否为空
     */
    public static boolean isEmpty(@Nullable Collection<?> collection) {
        return (collection == null || collection.isEmpty());
    }

    /**
     * 如果提供的Map是{@code null}或空，则返回{@code true}。否则，返回{@code false}。
     *
     * @param map 要检查的Map
     * @return 给定的Map是否为空
     */
    public static boolean isEmpty(@Nullable Map<?, ?> map) {
        return (map == null || map.isEmpty());
    }

    /**
     * 如果提供的集合不是{@code null}或空，则返回{@code true}。否则，返回{@code false}。
     *
     * @param collection 要检查的集合
     * @return 给定集合是否为空
     */
    public static boolean isNotEmpty(@Nullable Collection<?> collection) {
        return !CollectionUtil.isEmpty(collection);
    }

    /**
     * 如果提供的Map不是{@code null}或空，则返回{@code true}。否则，返回{@code false}。
     *
     * @param map 要检查的Map
     * @return 给定的Map是否为空
     */
    public static boolean isNotEmpty(@Nullable Map<?, ?> map) {
        return !CollectionUtil.isEmpty(map);
    }

    /**
     * 将提供的数组(Array)转换为列表(List)
     *
     * @param source 数组(array)
     * @return the converted List result 转换后的列表(List)结果
     */
    @SuppressWarnings("rawtypes")
    public static List arrayToList(@Nullable Object source) {
        return Arrays.asList(ObjectUtils.toObjectArray(source));
    }


}
