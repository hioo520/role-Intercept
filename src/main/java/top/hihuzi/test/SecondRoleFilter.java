package top.hihuzi.test;

import top.hihuzi.annotation.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilter;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:24
 */
@RoleRule
public class SecondRoleFilter implements RoleFilter {

    @Override
    public void execute(RoleRuleImpl roleRule) {

        if (roleRule.get().equals("2") )
            System.out.println("我是第二个!!!");
    }

}
