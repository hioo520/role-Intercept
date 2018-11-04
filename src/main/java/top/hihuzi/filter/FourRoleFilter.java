package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

import java.util.Arrays;
import java.util.Date;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:48
 */
@RoleRule
public class FourRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if ((roleRule.getT()[0]) instanceof Date)
            roleRule.cache().put(roleRule.getT()[0], roleRule.getArgs() == null ? null : Arrays.asList(roleRule.getArgs()));
        System.out.println("我是老四");
        return roleRule;
    }

}
