package top.hihuzi.test;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:22
 */
@RoleRule
public class FirstRoleFilter implements RoleFilter {

    @Override
    public RoleRuleImpl execute(RoleRuleImpl roleRule) {

        if (roleRule.get().equals("1")) {
            roleRule.set("2");
            System.out.println("我是第一个!!!!");
        }
        return roleRule;
    }

}
