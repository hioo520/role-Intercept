package top.hihuzi.test;

import top.hihuzi.Application;
import top.hihuzi.bean.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilterManager;

import java.util.Date;


/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:47
 */
public class test {

    public static void main(String[] args) {

        RoleFilterManager.scanRoleRule(Application.class);

        RoleRuleImpl roleRule = new RoleRule(new Object[]{new Date()});
        System.out.println(RoleFilterManager.excute(roleRule));

        System.out.println("___________________________________1__________________________________________");

        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/first"}, null)).cache().hashCode());

        System.out.println("____________________________________2_________________________________________");

        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/second", "你好师姐!"}, "true")).cache().hashCode());


        RoleRuleImpl excute99 = RoleFilterManager.excute(new RoleRule(new Object[]{"/second", "你好师姐!"}, "true"));
        Boolean permission99 = excute99.isPermission(new Object[]{"/second", "你好师姐!"});
        System.out.println("&&&&&&&&&" + permission99);
        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/second", "你好师姐!"}, "1")).cache().hashCode());

        System.out.println("_____________________________________3________________________________________");

        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/three"}, "1", "2", "3")).cache().hashCode());

        System.out.println("_____________________________________4________________________________________");

        RoleRuleImpl excute2 = RoleFilterManager.excute(new RoleRule(new Object[]{new Date()}, "1", "2", "3"));
        Object permission = excute2.isPermission(new Object[]{"/second", "你好师姐!"});
        System.out.println(permission);
        System.out.println(excute2.cache());
        if (true) {
            System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/second", "你好师姐!"}, "true")).cache().hashCode());
            System.out.println(new RoleRule().isPermission(new Object[]{"/second", "你好师姐!"}));

        }
    }

}
