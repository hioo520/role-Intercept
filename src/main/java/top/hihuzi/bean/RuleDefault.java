package top.hihuzi.bean;

import top.hihuzi.utils.StrUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * tips   过滤器中传递的对象
 *
 * @notice: "Map<Object, Object>"缓存类型是  key value 都是Object
 * @author: hihuzi 2018/11/4 13:55
 */
public class RuleDefault<key> implements Rule {

    private key[] key;

    private String[] args;

    public static Map<Object, Object> cache;


    static {
        cache = new HashMap<>();
    }

    public RuleDefault() {

    }

    public RuleDefault(Object[] obj, String... args) {

        this.key = (key[]) obj;
        this.args = args;

    }


    @Override
    public Object isPermission(Object[] obj, String... args) {

        return cache.get(StrUtils.objectToString(obj));
    }

    @Override
    public key[] getKey() {

        return key;
    }


    @Override
    public String[] getValue() {

        return args;
    }


    @Override
    public Map<Object, Object> cache() {

        return cache;
    }

}
