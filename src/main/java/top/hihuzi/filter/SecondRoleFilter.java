package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:24
 */
@RoleRule
public class SecondRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if ((String.valueOf(roleRule.getT()[0])).equals("/second")) {
            roleRule.cache().put("/second", roleRule.getArgs() == null ? null : Arrays.asList(roleRule.getArgs()));
            System.out.println("我是第二个!!!");
        }
        return roleRule;

    }

}
