package mycom.utils.fastjson;

/**
 * Created by 20013649 on 2020/6/22.
 */
public class Man {
    private String name;
    private String pass;

    public Man(String name, String pass){
        this.name = name;
        this.pass = pass;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getPass() {
        return pass;
    }
    public void setPass(String pass) {
        this.pass = pass;
    }
}
