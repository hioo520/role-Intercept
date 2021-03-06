package top.hihuzi.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * tips 用来扫描包
 *
 * @author: hihuzi 2018/11/4 9:22
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface ScanRoleConfig {

    String value() default "";

}
