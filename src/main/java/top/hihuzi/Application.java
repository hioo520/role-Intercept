package top.hihuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.bean.RoleRule;
import top.hihuzi.bean.RoleRuleImpl;
import top.hihuzi.croe.RoleFilterManager;

import java.util.Date;

@SpringBootApplication
@ScanRoleConfig("top.hihuzi.test")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        RoleFilterManager.scanRoleRule(Application.class);
        System.out.println(RoleFilterManager.excute(new RoleRule(new Object[]{"/first"}, null)));
    }

}
