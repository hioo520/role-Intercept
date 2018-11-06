package top.hihuzi.test;

import top.hihuzi.Application;
import top.hihuzi.bean.RuleSimple;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.FilterManager;

import java.util.Date;


/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:47
 */
public class test {

    public static void main(String[] args) {

        FilterManager.scanRoleRule(Application.class);

        Rule rule = new RuleSimple(new Object[]{new Date()});
        System.out.println(FilterManager.excute(rule));

        System.out.println("___________________________________1__________________________________________");

        System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/first"}, null)).cache().hashCode());

        System.out.println("____________________________________2_________________________________________");

        System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/second", "你好师姐!"}, "true")).cache().hashCode());


        Rule excute99 = FilterManager.excute(new RuleSimple(new Object[]{"/second", "你好师姐!"}, "true"));
        Boolean permission99 = (Boolean) excute99.isPermission(new Object[]{"/second", "你好师姐!"});
        System.out.println("&&&&&&&&&" + permission99);
        System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/second", "你好师姐!"}, "1")).cache().hashCode());

        System.out.println("_____________________________________3________________________________________");

        System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/three"}, "1", "2", "3")).cache().hashCode());

        System.out.println("_____________________________________4________________________________________");

        Rule excute2 = FilterManager.excute(new RuleSimple(new Object[]{new Date()}, "1", "2", "3"));
        Object permission = excute2.isPermission(new Object[]{"/second", "你好师姐!"});
        System.out.println(permission);
        System.out.println(excute2.cache());
        if (true) {
            System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/second", "你好师姐!"}, "true")).cache().hashCode());
            System.out.println(new RuleSimple().isPermission(new Object[]{"/second", "你好师姐!"}));

        }
    }

}
