package com.liri.reference.common.utils;

/**
 * 字符工具类
 *
 * @author William
 * @date 2019/8/20
 */
public class StringUtil {

    private StringUtil() {

    }

    /**
     * 空字符串 {@code ""}.
     */
    public static final String EMPTY = "";

    /**
     * <p>检查CharSequence是空的("")或者null.</p>
     *
     * <pre>
     * StringUtil.isEmpty(null)      = true
     * StringUtil.isEmpty("")        = true
     * StringUtil.isEmpty(" ")       = false
     * StringUtil.isEmpty("bob")     = false
     * StringUtil.isEmpty("  bob  ") = false
     * </pre>
     *
     * @param cs 要检查的CharSequence可能为null
     * @return {@code true} 如果CharSequence为空或null
     */
    public static boolean isEmpty(final CharSequence cs) {
        return cs == null || cs.length() == 0;
    }

    /**
     * <p>检查CharSequence不为空("")且不为null.</p>
     *
     * <pre>
     * StringUtil.isNotEmpty(null)      = false
     * StringUtil.isNotEmpty("")        = false
     * StringUtil.isNotEmpty(" ")       = true
     * StringUtil.isNotEmpty("bob")     = true
     * StringUtil.isNotEmpty("  bob  ") = true
     * </pre>
     *
     * @param cs 要检查的CharSequence可能为null
     * @return {@code true} 如果CharSequence不是空且不为null
     */
    public static boolean isNotEmpty(final CharSequence cs) {
        return !StringUtil.isEmpty(cs);
    }

    /**
     * <p>检查CharSequence是否为空格、空("")或null.</p>
     *
     * <pre>
     * StringUtil.isBlank(null)      = true
     * StringUtil.isBlank("")        = true
     * StringUtil.isBlank(" ")       = true
     * StringUtil.isBlank("bob")     = false
     * StringUtil.isBlank("  bob  ") = false
     * </pre>
     *
     * @param cs 要检查的CharSequence可能为null
     * @return {@code true} 如果CharSequence为空格、空("")或null
     */
    public static boolean isBlank(final CharSequence cs) {
        int strLen;
        if (cs == null || (strLen = cs.length()) == 0) {
            return true;
        }
        for (int i = 0; i < strLen; i++) {
            if (Character.isWhitespace(cs.charAt(i)) == false) {
                return false;
            }
        }
        return true;
    }


    /**
     * <p>检查CharSequence是否不为空("")，不为null，也不只是空格.</p>
     *
     * <pre>
     * StringUtil.isNotBlank(null)      = false
     * StringUtil.isNotBlank("")        = false
     * StringUtil.isNotBlank(" ")       = false
     * StringUtil.isNotBlank("bob")     = true
     * StringUtil.isNotBlank("  bob  ") = true
     * </pre>
     *
     * @param cs 要检查的CharSequence可能为null
     * @return {@code true} 如果CharSequence不是空的，不是null，也不是空格
     */
    public static boolean isNotBlank(final CharSequence cs) {
        return !StringUtil.isBlank(cs);
    }


    /**
     * <p>Removes control characters (char &lt;= 32) from both
     * ends of this String, handling {@code null} by returning
     * {@code null}.</p>
     *
     *
     * <pre>
     * StringUtil.trim(null)          = null
     * StringUtil.trim("")            = ""
     * StringUtil.trim("     ")       = ""
     * StringUtil.trim("abc")         = "abc"
     * StringUtil.trim("    abc    ") = "abc"
     * </pre>
     *
     * @param str 要修剪的字符串可以为null
     * @return the trimmed string, {@code null} 如果空字符串输入
     */
    public static String trim(final String str) {
        return str == null ? null : str.trim();
    }


    /**
     * <p> 从字符串的两端删除空字符(char &lt;= 32)，如果字符串在修剪后为空("")，或者如果字符串为{@code null}，则返回一个空字符串("").
     *
     * <pre>
     * StringUtil.trimToEmpty(null)          = ""
     * StringUtil.trimToEmpty("")            = ""
     * StringUtil.trimToEmpty("     ")       = ""
     * StringUtil.trimToEmpty("abc")         = "abc"
     * StringUtil.trimToEmpty("    abc    ") = "abc"
     * </pre>
     *
     * @param str 要修剪的字符串可以为null
     * @return 如果{@code null}输入，则为一个空字符串
     */
    public static String trimToEmpty(final String str) {
        return str == null ? EMPTY : str.trim();
    }

    /**
     * <p>从指定字符串获取子字符串，以避免异常.</p>
     *
     * <pre>
     * StringUtil.substring(null, *)   = null
     * StringUtil.substring("", *)     = ""
     * StringUtil.substring("abc", 0)  = "abc"
     * StringUtil.substring("abc", 2)  = "c"
     * StringUtil.substring("abc", 4)  = ""
     * StringUtil.substring("abc", -2) = "bc"
     * StringUtil.substring("abc", -4) = "abc"
     * </pre>
     *
     * @param str   要从中获取子字符串的字符串可以为null
     * @param start 开始的位置，负数表示从字符串的末尾开始倒数字符位置
     * @return 起始位置的子字符串，{@code null}如果输入为null,返回null
     */
    public static String substring(final String str, int start) {
        if (str == null) {
            return null;
        }

        // handle negatives, which means last n characters
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        if (start < 0) {
            start = 0;
        }
        if (start > str.length()) {
            return EMPTY;
        }

        return str.substring(start);
    }

    /**
     * <p>从指定字符串获取子字符串，以避免异常.</p>
     *
     * <p>可以使用负的起始位置从字符串的末尾开始/结束{@code n}字符.</p>
     *
     * <p>返回的子字符串以{@code start}位置中的字符开始，以{@code end}位置前的字符结束。
     * 所有的位置计算都是从零开始的。
     * 若要从字符串的开头开始，请使用{@code start = 0}。
     * 负的起始和结束位置可用于指定相对于字符串末尾的偏移量。</p>
     *
     * <pre>
     * StringUtil.substring(null, *, *)    = null
     * StringUtil.substring("", * ,  *)    = "";
     * StringUtil.substring("abc", 0, 2)   = "ab"
     * StringUtil.substring("abc", 2, 0)   = ""
     * StringUtil.substring("abc", 2, 4)   = "c"
     * StringUtil.substring("abc", 4, 6)   = ""
     * StringUtil.substring("abc", 2, 2)   = ""
     * StringUtil.substring("abc", -2, -1) = "b"
     * StringUtil.substring("abc", -4, 2)  = "ab"
     * </pre>
     *
     * @param str   要从中获取子字符串的字符串可以为null the String to get the substring from, may be null
     * @param start 开始的位置，负数表示从字符串的末尾开始倒数字符位置
     * @param end   结束的位置 如果为负数，表示从字符串的末尾开始倒数字符
     * @return 子字符串从起始位置到结束位置，{@code null}如果输入为null
     */
    public static String substring(final String str, int start, int end) {
        if (str == null) {
            return null;
        }

        // handle negatives
        if (end < 0) {
            end = str.length() + end; // remember end is negative
        }
        if (start < 0) {
            start = str.length() + start; // remember start is negative
        }

        // check length next
        if (end > str.length()) {
            end = str.length();
        }

        // if start is greater than end, return ""
        if (start > end) {
            return EMPTY;
        }

        if (start < 0) {
            start = 0;
        }
        if (end < 0) {
            end = 0;
        }

        return str.substring(start, end);
    }
}
