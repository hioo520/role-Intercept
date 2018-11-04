package top.hihuzi.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:55
 */
public class RoleRule<T> implements RoleRuleImpl {

    private T[] t;

    private String[] args;

    public static Map<Object, Boolean> cache;

    private Boolean isPremission = true;

    private static RoleRule ROLE_RULE = null;

    static {
        cache = new HashMap<>();
    }

    public RoleRule(Object[] obj, String... args) {

        this.t = (T[]) obj;
        this.args = args;

    }

    @Override
    public Boolean isPermission(Object[] obj, String... args) {

        return isPremission;
    }

    public T[] getT() {

        return t;
    }

    @Override
    public void setT(Object[] obj) {

        this.t = (T[]) obj;
    }

    public String[] getArgs() {

        return args;
    }

    public void setArgs(String[] args) {

        this.args = args;
    }

    @Override
    public Map<Object, Boolean> cache() {

        return cache;
    }

}
