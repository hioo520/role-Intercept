package top.hihuzi.bean;

import top.hihuzi.utils.StrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * tips   过滤器中传递的对象
 *
 * @notice: "Map<Object, Boolean>" 缓存类型是  key value
 * @author: hihuzi 2018/11/4 13:55
 */
public class RuleSimple<key> implements Rule {

    private key[] key;

    private String[] value;

    public static Map<String, Boolean> cache;

    static {
        cache = new HashMap<>();
    }

    public RuleSimple() {

    }

    public RuleSimple(Object[] obj, String... args) {

        this.key = (key[]) obj;
        this.value = args;

    }

    @Override
    public Boolean isPermission(Object[] obj, String... args) {

        return Boolean.valueOf(String.valueOf(cache.get(StrUtils.objectToString(obj))));
    }

    @Override
    public key[] getKey() {

        return key;
    }


    @Override
    public String[] getValue() {

        return value;
    }


    @Override
    public Map<String, Boolean> cache() {

        return cache;
    }

}
