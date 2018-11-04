package top.hihuzi.test;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:48
 */
@RoleRule
public class ThreeRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if (roleRule.get().equals("3"))
            System.out.println("我是老三");
        return roleRule;
    }

}
