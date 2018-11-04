package top.hihuzi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import top.hihuzi.annotation.ScanRoleConfig;
import top.hihuzi.croe.RoleFilterManager;

@SpringBootApplication
@ScanRoleConfig("top.hihuzi.test")
public class Application {

    public static void main(String[] args) {

        RoleFilterManager.scanRoleRule(Application.class);
        SpringApplication.run(Application.class, args);
    }

}
