package top.hihuzi.bean;

import java.util.Map;

/**
 * tips 过滤器中传递的对象
 *
 * @author: hihuzi 2018/11/4 13:50
 */
public interface RoleRuleImpl<T> {

    Object isPermission(T[] t, String... args);

    T[] getT();

    void setT(T[] t);

    String[] getArgs();

    void setArgs(String[] args);

    Map<Object, Object> cache();

}
