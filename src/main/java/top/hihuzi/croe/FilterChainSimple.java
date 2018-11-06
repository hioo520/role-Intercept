package top.hihuzi.croe;

import top.hihuzi.bean.Rule;
import top.hihuzi.bean.RuleSimple;

import java.util.ArrayList;
import java.util.List;

/**
 * tips  过滤器链式处理器
 *
 * @notice: 采用内部类懒加载
 * @author: hihuzi 2018/11/5 9:16
 */
class FilterChainSimple implements FilterChain {

    /**
     * tips 单例对象
     **/

    private static FilterChainSimple ROLE_FILTER_CHAIN = null;

    /**
     * tips 所有过滤器的容器
     *
     * @author: hihuzi  2018/11/6 11:15
     */
    private static List<Filter> fillters;

    static {
        fillters = new ArrayList<>();
    }

    /**
     * tips 加入过滤器
     *
     * @author: hihuzi 2018/11/6 11:19
     */
    public FilterChainSimple addRoleFilter(Filter filter) {


        fillters.add(filter);
        return this;
    }

    /**
     * tips 执行过滤器链式调用
     *
     * @notice: 支持一次缓存校验
     * @author: hihuzi 2018/11/6 11:13
     */
    public Rule excute(Rule rule) {

        if (!new RuleSimple().isPermission(rule.getKey())) {

            for (Filter fillter : fillters) {
                rule = fillter.execute(rule);
            }
        }
        return rule;
    }

    /**
     * tips 静态内部类 用于懒加载
     *
     * @author: hihuzi 2018/11/6 11:11
     */
    private static class Create {

        private static final FilterChainSimple ROLE_FILTER_CHAIN = new FilterChainSimple();

    }

    /**
     * tips 单例 创建对象
     *
     * @author: hihuzi 2018/11/6 11:23
     */
    static FilterChainSimple create() {


        if (null == ROLE_FILTER_CHAIN) {
            return Create.ROLE_FILTER_CHAIN;
        } else {
            return ROLE_FILTER_CHAIN;
        }

    }

}