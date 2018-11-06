package top.hihuzi.bean;

import java.util.Map;

/**
 * tips 过滤器中传递的对象
 *
 * @author: hihuzi 2018/11/4 13:50
 */
public interface Rule<T> {

    Object isPermission(T[] key, String... value);

    T[] getKey();

    String[] getValue();

    Map<Object, Object> cache();

}
