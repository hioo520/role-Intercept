package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.Filter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:48
 */
@RoleRules
public class ThreeFilter implements Filter {

    @Override
    public Rule execute(Rule rule) {

        if ((String.valueOf(rule.getKey()[0])).equals("/three")) {
            rule.cache().put("/three", rule.getValue() == null ? null : Arrays.asList(rule.getValue()));
            System.out.println("我是老三");
        }
        return rule;
    }

}
