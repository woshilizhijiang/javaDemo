package mycom.patterns.objectaction.template.mytemplate;

/**
 * Created by 20013649 on 2020/6/30.
 */
public abstract class TemplateShopping {
    public final void shoppingTemplate(){
        withdrawMoney();
        driveCar();
        shopping();
    }
    private final void withdrawMoney(){
        System.out.println("取钱");
    }
    private final void driveCar(){
        System.out.println("开车去超市");
    }
    public abstract void shopping();

}
