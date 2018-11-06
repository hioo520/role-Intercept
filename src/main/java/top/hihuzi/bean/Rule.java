package top.hihuzi.bean;

import java.util.Map;

/**
 * tips 过滤器中传递的对象
 *
 * @notice: 在不同过滤器之间传递的对象 也用于返回
 * @author: hihuzi 2018/11/4 13:50
 */
public interface Rule<T> {

    /**
     * tips 用户传递的参数 用于过滤器规则自定义 给出具体判断结果
     **/

    Object isPermission(T[] key, String... value);

    /**
     * tips 获取用户传递的 第一个参数集合 可以作为缓存的key
     **/
    T[] getKey();

    /**
     * tips 获取用户传递的 第二个参数集合 可以作为缓存的value
     **/
    String[] getValue();

    /**
     * tips 缓存
     **/

    Map<Object, Object> cache();

}
