package top.hihuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.bean.RuleSimple;
import top.hihuzi.croe.FilterManager;

@SpringBootApplication
@ScanRoleConfig("top.hihuzi.test")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        FilterManager.scanRoleRule(Application.class);
        System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/first"}, null)));
    }

}