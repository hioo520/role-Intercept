package top.hihuzi.bean;

/**
 * tips
 *
 * @author: hihuzi 2018/11/4 13:55
 */
public class RoleRule implements RoleRuleImpl {

    private String name;

    public RoleRule(String name) {

        this.name = name;

    }

    @Override
    public void set(String value) {

        this.name = value;
    }

    @Override
    public String get() {

        return name;
    }

}
