package top.hihuzi.test;

import top.hihuzi.Application;
import top.hihuzi.bean.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilterManager;

import javax.sound.midi.SoundbankResource;
import java.util.Date;


/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:47
 */
public class test {

    public static void main(String[] args) {

        RoleFilterManager.scanRoleRule(Application.class);
        RoleRuleImpl roleRule=new RoleRule(new Object[]{new Date()});
        roleRule = RoleFilterManager.excute(roleRule);
        System.out.println(roleRule);

        System.out.println("_____________________________________________________________________________");
        System.out.println("_____________________________________________________________________________");

        RoleRuleImpl excute0 = RoleFilterManager.excute(new RoleRule(new Object[]{"/first"}, null));
        System.out.println(excute0);

        System.out.println("_____________________________________________________________________________");
        System.out.println("_____________________________________________________________________________");

        RoleRuleImpl excute1 = RoleFilterManager.excute(new RoleRule(new Object[]{"/second"}, null));
        System.out.println(excute0);

        System.out.println("_____________________________________________________________________________");
        System.out.println("_____________________________________________________________________________");

        RoleRuleImpl excute2 = RoleFilterManager.excute(new RoleRule(new Object[]{"/three"}, "1", "2", "3"));
        System.out.println(excute2.cache());
    }

}
