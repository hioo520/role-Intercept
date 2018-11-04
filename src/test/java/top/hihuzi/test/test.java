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

        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/second"}, null)).cache().hashCode());

        System.out.println("_____________________________________3________________________________________");

        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/three"}, "1", "2", "3")).cache().hashCode());

        System.out.println("_____________________________________4________________________________________");

        RoleRuleImpl excute2 = RoleFilterManager.excute(new RoleRule(new Object[]{new Date()}, "1", "2", "3"));
        System.out.println(excute2.cache());
    }

}
