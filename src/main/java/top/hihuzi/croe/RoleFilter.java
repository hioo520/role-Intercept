package top.hihuzi.croe;

import top.hihuzi.bean.RoleRuleImpl;

/**
 * tips    过滤器
 *
 * @author: hihuzi 2018/11/4 9:26
 */
public interface RoleFilter {

    RoleRuleImpl execute(RoleRuleImpl roleRule);

}
