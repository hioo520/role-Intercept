package top.hihuzi.croe;

import top.hihuzi.bean.Rule;

public interface FilterChain {

    FilterChain addFilter(Filter filter);

    Rule excute(Rule rule);

}
