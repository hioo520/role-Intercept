package top.hihuzi.bean;

import top.hihuzi.utils.StrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * tips   过滤器中传递的对象
 *
 * @author: hihuzi 2018/11/4 13:55
 */
public class RoleRule<T> implements RoleRuleImpl {

    private T[] t;

    private String[] args;

    public static Map<Object, Object> caches;

    public static Map<Object, Boolean> cache;

    static {
        cache = new HashMap<>();
        caches = new HashMap<>();
    }

    public RoleRule() {

    }

    public RoleRule(Object[] obj, String... args) {

        this.t = (T[]) obj;
        this.args = args;

    }

    @Override
    public Object isPermissions(Object[] obj, String... args) {

        return caches().get(StrUtils.objectToString(obj));
    }

    @Override
    public Boolean isPermission(Object[] obj, String... args) {

        return Boolean.valueOf(String.valueOf(cache().get(StrUtils.objectToString(obj))));
    }

    @Override
    public T[] getT() {

        return t;
    }

    @Override
    public void setT(Object[] obj) {

        this.t = (T[]) obj;
    }

    @Override
    public String[] getArgs() {

        return args;
    }

    @Override
    public void setArgs(String[] args) {

        this.args = args;
    }

    @Override
    public Map<Object, Object> caches() {

        return caches;
    }

    @Override
    public Map<Object, Boolean> cache() {

        return cache;
    }

}
