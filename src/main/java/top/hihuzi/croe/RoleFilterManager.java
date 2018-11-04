package top.hihuzi.croe;

import top.hihuzi.Application;
import top.hihuzi.annotation.RoleRule;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.utils.FileUtils;

import java.lang.annotation.Annotation;
import java.util.List;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:04
 */
public class RoleFilterManager {

    static RoleFilterChain roleFilterChain = RoleFilterChain.create();

    public static void setRoleFilterChain(RoleFilter roleFilter) {

        roleFilterChain.addRoleFilter(roleFilter);
    }

    public static RoleRuleImpl excute(RoleRuleImpl roleRule) {

        roleFilterChain.excute(roleRule);
        return roleRule;
    }

    public static void scanRoleRule(Class<?> primarySource) {

        Annotation[] annotations = primarySource.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation.annotationType().equals(ScanRoleConfig.class)) {
                String value = ((ScanRoleConfig) annotation).value().split("\\.")[0];
                List<Class<?>> allClass = FileUtils.getAllClass(value);
                for (Class<?> aClass : allClass) {
                    RoleRule roleRule = aClass.getAnnotation(RoleRule.class);
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
