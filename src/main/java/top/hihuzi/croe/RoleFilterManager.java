package top.hihuzi.croe;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.utils.FileUtils;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * tips     过滤器管理器 扫包器
 *
 * @author: hihuzi 2018/11/4 10:04
 */
public class RoleFilterManager {

    static RoleFilterChain roleFilterChain = RoleFilterChain.create();

    static Boolean RUN_ONCE = true;

    public static void setRoleFilterChain(RoleFilter roleFilter) {

        roleFilterChain.addRoleFilter(roleFilter);
    }

    public static RoleRuleImpl excute(RoleRuleImpl roleRule) {

        roleFilterChain.excute(roleRule);
        return roleRule;
    }

    public static void scanRoleRule(Class<?> primarySource) {

        if (!RUN_ONCE) {
            return;
        }
        RUN_ONCE = false;
        Annotation[] annotations = primarySource.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ScanRoleConfig.class)) {
                String value = ((ScanRoleConfig) annotation).value().split("\\.")[0];
                List<Class<?>> allClass = FileUtils.getAllClass(value);
                for (Class<?> aClass : allClass) {
                    RoleRules roleRule = aClass.getAnnotation(RoleRules.class);
                    if (null != roleRule) {
                        try {
                            setRoleFilterChain((RoleFilter) aClass.getConstructor(null).newInstance());
                        } catch (Exception e) {
                        }
                    }
                }

            }
        }
    }

}
