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

        if ((String.valueOf(roleRule.getT()[0])).equals("/second")&&(String.valueOf(roleRule.getT()[1])).equals("你好师姐!")) {
            roleRule.cache().put("/second你好师姐!", roleRule.getArgs()[0]);
            System.out.println("我是第二个!!!");
        }
        return roleRule;

    }

}
