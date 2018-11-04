package top.hihuzi.Filter;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:48
 */
@RoleRule
public class ThreeRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if ((String.valueOf(roleRule.getT()[0])).equals("/three"))
            roleRule.cache().put("/three", roleRule.getArgs() == null ? null : Arrays.asList(roleRule.getArgs()));
        System.out.println("我是老三");
        return roleRule;
    }

}
