package mycom.patterns.solid.crp.extend;

/**
 * Created by 20013649 on 2020/7/3.
 */
public class ProductDao{
    private DBconnection dBconnection;

    public void setdBconnection(DBconnection dBconnection) {
        this.dBconnection = dBconnection;
    }

    public void addProduct(){
        String conn = dBconnection.getConnection();
        System.out.println("使用" + conn + "增加产品。");
    }
}
