package top.hihuzi.croe;

import top.hihuzi.bean.Rule;

/**
 * tips 过滤器链式处理器
 *
 * @author: hihuzi  18-11-6 下午9:19
 */
public interface FilterChain {

    FilterChain addFilter(Filter filter);

    Rule excute(Rule rule);

}
