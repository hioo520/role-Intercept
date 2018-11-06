# 设计模式-过滤器-权限过滤

#### 基于过滤器-宽泛的权限过滤器  
##1.工具说明
>技术:注解+(设计模式)(单例-内部类懒加载,责任链,工厂模式)+自动扫包
>优点:
>>1.非侵入式插件(可以很容易添加到你的SpringBoot项目)
>>2.易学习
>>3.可以针对不同机构 不同角色 不同请求进行 过滤授权
>>4.增加缓存机制可以提供过滤效率
>>5.支持自定义规则
##2.使用方法
>1.在SpringBoot启动器添加扫描注解并配置待扫描的自定义过滤器包
```

@SpringBootApplication
@ScanRoleConfig("top.hihuzi.test")
public class Application {

    public static void main(String[] args) {

        SpringApplication.run(Application.class, args);
        FilterManager.scanRoleRule(Application.class);
        /** 下面这句用于测试 **/
        //System.out.println(FilterManager.excute(new RuleSimple(new Object[]{"/first"}, null)));
    }

}
```
>2.自定义一个或者多个过滤器(可以为每个公司每个角色进行配置一个过滤器)具体代码如下:
```
package top.hihuzi.filter;

import top.hihuzi.annotation.RoleRules;
import top.hihuzi.bean.Rule;
import top.hihuzi.croe.Filter;

import java.util.Arrays;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 10:22
 */
@RoleRules
public class FirstFilter implements Filter {

    @Override
    public Rule execute(Rule rule) {

        if ((String.valueOf(rule.getKey()[0])).equals("/first")) {
// cache: 是一个缓存  用户自己去校验  cache是一个Map  可以定义唯一的 Key value可以定义为 boolean(true,false)
            rule.cache().put("/first", rule.getValue() == null ? null : Arrays.asList(rule.getValue()));
            System.out.println("我是第一个!!!!");
        }
        return rule;
    }

}

```
>3.具体到自己需要进行筛选权限的接口地方如下调用
```
// 先传一些值 用于过滤器 校验规则  

FilterManager.excute(new RuleSimple(new Object[]{"/first"}, null));
Object permission = excute2.isPermission(new Object[]{"/second", "你好师姐!"});
```
##3.readme
也是第二次在这里发点东西,希望有梦想盆友多多指点
                                                            ---hihuzi 2018-11-6 晚
##4.下载地址
>>>https://github.com/hioo520/role-Intercept.git