package top.hihuzi.utils;


import top.hihuzi.bean.Rule;

import java.util.Collection;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * tips 字符串 空值 工具
 *
 * @author:hihuzi 2018/8/2 9:51
 */
public class StrUtils {

    /**
     * 初始化 get
     */
    private static StringBuffer GET = new StringBuffer().append("get");

    /**
     * 初始化 set
     */
    private static StringBuffer SET = new StringBuffer().append("set");

    private static Pattern linePattern = Pattern.compile("_(\\w)");

    private static Pattern humpPattern = Pattern.compile("[A-Z]");


    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    public static String lineToHump(String str) {

        if (null == str || "".equals(str)) {
            return str;
        }
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);

        str = sb.toString();
        str = str.substring(0, 1).toUpperCase() + str.substring(1);

        return str;
    }

    /**
     * 驼峰转下划线,效率比上面高
     *
     * @param str
     * @return
     */
    public static String humpToLine(String str) {

        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线(简单写法，效率低于{@link #humpToLine(String)})
     *
     * @param str
     * @return
     */
    public static String humpToLine2(String str) {

        return str.replaceAll("[A-Z]", "_$0").toLowerCase();
    }

    /**
     * tips 存在一个是  "" 或"  "或 null 返回 true  原名:isNullOrEmpty
     *
     * @author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNoE(String... strs) {

        for (String str : strs) {
            if (str == null || "".equals(str) || str.trim().length() <= 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * tips 不存在  "" 或"  "或 null 返回 true  原名:isNotNullOrEmpty
     * tips 存在一个是  "" 或"  "或 null 返回 false
     *
     * @author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNNoE(String... strs) {

        return !isNoE(strs);
    }

    /**
     * tips 全都是  "" 或"  "或 null 返回 true 原名:isNullButEmpty
     *
     * @author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNbE(String... strs) {

        int i = 0;
        for (String str : strs) {
            if (str == null || "".equals(str) || str.trim().length() <= 0) {
                i++;
            }
        }
        if (strs.length == i) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * tips 存在一个是  "" 或"  "或 null 返回 true 原名:isNotNullButEmpty
     *
     * @author:hihuzi 2018/5/3 16:09
     */
    public static Boolean isNNbE(String... strs) {

        return !isNbE(strs);
    }

    /**
     * tips 存在一个是  null 或size 为0 返回 true 原名:isNullOrEmptyCollections
     *
     * @author:hihuzi 2018/5/8 15:36
     */
    public static <E> Boolean isNoEC(Collection<E>... collections) {

        for (Collection<E> c : collections) {
            if (c == null || c.size() == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * tips 全部不是  null 或size=0 返回 true  原名:isNotNullOrEmptyCollections
     * tips 存在一个是  null 或size=0 返回 false
     *
     * @author:hihuzi 2018/7/7 8:37
     */
    public static <E> Boolean isNNoEC(Collection<E>... collections) {

        return !isNoEC(collections);
    }

    /**
     * tips t 存在一个是  null  返回 true   原名:isNullOrEmptyEntrty
     *
     * @author:hihuzi 2018/5/10 15:07
     */
    public static <E> Boolean isNoEE(E... e) {

        if (e == null) {
            return true;
        }
        for (E c : e) {
            if (c == null || e.length == 0) {
                return true;
            }
        }
        return false;
    }

    /**
     * tips e 存在一个是  null  返回 flase  原名:isNotNullOrEmptyEntrty
     * e 全都不是 null 返回 true
     *
     * @author:hihuzi 2018/5/10 15:07
     */
    public static <E> Boolean isNNoEE(E... e) {

        return !isNoEE(e);
    }


    /**
     * tips 获取set + name--> setName 首字母大写
     *
     * @author:hihuzi 2018/9/14 10:36
     */
    public static String achieveSetFunction(String name) {

        return SET + name.substring(0, 1).toUpperCase() + name.substring(1);

    }


    /**
     * tips 获取get + name --> getName 首字母大写
     *
     * @author:hihuzi 2018/9/14 10:36
     */
    public static String achieveGetFunction(String str) {

        return GET + str.substring(0, 1).toUpperCase() + str.substring(1);

    }

    /**
     * tips Object[] toString
     *
     * @author: hihuzi 18-11-4 下午8:00
     */
    public static String objectToString(Object[] objects) {


        StringBuilder sb = new StringBuilder();
        if (null == objects) return null;
        for (Object object : objects) {
            sb.append(object.toString());
        }
        return sb.toString();

    }

    /**
     * tips 用于规则校验
     *
     * @author: hihuzi 2018/11/6 14:46
     */
    public static boolean roleCheck(Rule rule, String... args) {

        int j = 0;
        Object[] keys = rule.getKey();
        for (int i = 0; i < keys.length; i++) {
            if (keys[i].toString().equals(args[i])) {
                j++;
            }
        }
        if (keys.length == j) {
            return true;
        } else {
            return false;
        }
    }

}
