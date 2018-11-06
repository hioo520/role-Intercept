package top.hihuzi.croe;

import top.hihuzi.bean.Rule;

public interface FilterChain {

    FilterChain addRoleFilter(Filter filter);

    Rule excute(Rule rule);

}
