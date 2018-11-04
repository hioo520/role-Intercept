package top.hihuzi.croe;

import top.hihuzi.bean.RoleRuleImpl;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 9:26
 */
public interface RoleFilter {

    void execute(RoleRuleImpl roleRule);

}
