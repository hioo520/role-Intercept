package top.hihuzi.croe;

import top.hihuzi.bean.Rule;

/**
 * tips    过滤器
 *
 * @author: hihuzi 2018/11/4 9:26
 */
public interface Filter {

    Rule execute(Rule rule);

}
