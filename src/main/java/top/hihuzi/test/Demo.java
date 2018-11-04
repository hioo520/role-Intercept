package top.hihuzi.test;

import top.hihuzi.Application;
import top.hihuzi.bean.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilterManager;

import javax.sound.midi.SoundbankResource;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:47
 */
public class Demo {
    public static void main(String[] args) {

        RoleFilterManager.scanRoleRule(Application.class);
        RoleRuleImpl excute = RoleFilterManager.excute(new RoleRule("1"));
        System.out.println(excute.get());
    }
}
