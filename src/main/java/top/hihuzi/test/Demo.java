package top.hihuzi.test;

import top.hihuzi.Application;
import top.hihuzi.bean.RoleRule;
import top.hihuzi.croe.RoleFilterManager;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:47
 */
public class Demo {
    public static void main(String[] args) {

        RoleFilterManager.scanRoleRule(Application.class);
        RoleFilterManager.excute(new RoleRule("3"));
    }
}
