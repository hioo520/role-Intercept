package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.Filter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:22
 */
@RoleRules
public class FirstFilter implements Filter {

    @Override
    public Rule execute(Rule rule) {

        if ((String.valueOf(rule.getKey()[0])).equals("/first")) {
            rule.cache().put("/first", rule.getValue() == null ? null : Arrays.asList(rule.getValue()));
            System.out.println("我是第一个!!!!");
        }
        return rule;
    }

}
