package top.hihuzi.croe;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.bean.Rule;
import top.hihuzi.utils.FileUtils;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * tips     过滤器管理器 扫包器
 *
 * @author: hihuzi 2018/11/4 10:04
 */
public class FilterManager {


    /**
     * tips 注入哪种类型的过滤器处理器
     *
     * @notice: 1.FilterChainDefault每次调用所有过滤器都会处理一次
     * 2.FilterChainSimple每次调用会在缓存中查找一次不存在的情况才所有的过滤器执行一次中途可以只要有一个过滤器找到便返回
     * @author: hihuzi  18-11-6 下午1:36
     */
    private static FilterChain filterChain;

    private FilterChain DEFAULT = null;

    static {
        filterChain = FilterChainSimple.create();
    }

    private static Boolean RUN_ONCE = true;

    /**
     * tips 加入过滤器
     *
     * @author: hihuzi 2018/11/6 11:19
     */
    private static void add(Filter filter) {

        filterChain.addFilter(filter);
    }

    /**
     * tips 执行过滤器
     *
     * @author: hihuzi 2018/11/6 11:19
     */
    public static Rule excute(Rule rule) {

        filterChain.excute(rule);
        return rule;
    }

    /**
     * tips 配置过滤器执行器执行策略
     *
     * @author: hihuzi 2018/11/6 14:23
     */
    public static void setFilterChain(FilterChain filterChain) {

        filterChain = filterChain;
    }

    /**
     * tips 自动注入 过滤器配置
     *
     * @author: hihuzi  2018/11/6 11:18
     */
    public static void scanRoleRule(Class<?> primarySource) {

        if (!RUN_ONCE) {
            return;
        }
        RUN_ONCE = false;
        Annotation[] annotations = primarySource.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ScanRoleConfig.class)) {
                String value = ((ScanRoleConfig) annotation).value().split("\\.")[0];
                List<Class<?>> allClass = FileUtils.getAllClass(value);
                for (Class<?> aClass : allClass) {
                    RoleRules roleRule = aClass.getAnnotation(RoleRules.class);
                    if (null != roleRule) {
                        try {
                            add((Filter) aClass.getConstructor(null).newInstance());
                        } catch (Exception e) {
                        }
                    }
                }

            }
        }
    }

}
