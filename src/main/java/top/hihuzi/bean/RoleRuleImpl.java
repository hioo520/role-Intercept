package top.hihuzi.bean;

import java.util.Map;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:50
 */
public interface RoleRuleImpl<T> {

    Boolean isPermission(T[] t, String... args);

    T[] getT();

    void setT(T[] t);

    String[] getArgs();

    void setArgs(String[] args);

    Map<Object, Boolean> cache();

}
