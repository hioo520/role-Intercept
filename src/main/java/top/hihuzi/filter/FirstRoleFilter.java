package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:22
 */
@RoleRule
public class FirstRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if ((String.valueOf(roleRule.getT()[0])).equals("/first")) {
            roleRule.cache().put("/first", roleRule.getArgs() == null ? null : Arrays.asList(roleRule.getArgs()));
            System.out.println("我是第一个!!!!");
        }
        return roleRule;
    }

}
