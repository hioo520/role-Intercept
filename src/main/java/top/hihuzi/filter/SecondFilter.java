package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.Filter;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:24
 */
@RoleRules
public class SecondFilter implements Filter {

    @Override
    public Rule execute(Rule rule) {

        if ((String.valueOf(rule.getKey()[0])).equals("/second") && (String.valueOf(rule.getKey()[1])).equals("你好师姐!")) {
            rule.cache().put("/second你好师姐!", rule.getValue()[0]);
            System.out.println("我是第二个!!!");
        }
        return rule;

    }

}
