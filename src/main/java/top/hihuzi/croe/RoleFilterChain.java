package top.hihuzi.croe;

import top.hihuzi.bean.RoleRuleImpl;

import java.util.ArrayList;
import java.util.List;

public class RoleFilterChain {

    private static RoleFilterChain ROLE_FILTER_CHAIN = null;

    public List<RoleFilter> fillters = new ArrayList<>();

    public RoleFilterChain addRoleFilter(RoleFilter roleFilter) {

        fillters.add(roleFilter);
        return this;
    }

    public RoleRuleImpl excute(RoleRuleImpl roleRule) {

        for (RoleFilter fillter : fillters) {
            roleRule = fillter.execute(roleRule);
        }
        return roleRule;
    }

    public static class Create {

        private static final RoleFilterChain ROLE_FILTER_CHAIN = new RoleFilterChain();

    }

    static RoleFilterChain create() {

        if (null == ROLE_FILTER_CHAIN) {
            return Create.ROLE_FILTER_CHAIN;
        } else {
            return ROLE_FILTER_CHAIN;
        }

    }

}
