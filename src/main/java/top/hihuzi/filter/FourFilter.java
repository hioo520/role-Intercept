package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.Filter;

import java.util.Arrays;
import java.util.Date;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:48
 */
@RoleRules
public class FourFilter implements Filter {

    @Override
    public Rule execute(Rule rule) {

        if ((rule.getKey()[0]) instanceof Date)
            rule.cache().put(rule.getKey()[0], rule.getValue() == null ? null : Arrays.asList(rule.getValue()));
        System.out.println("我是老四");
        return rule;
    }

}
