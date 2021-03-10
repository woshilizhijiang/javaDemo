package mycom.patterns.solid.crp.extend;

/**
 *  聚合has-A、组合contains-A 继承 is-A
 *
 *
 * Created by 20013649 on 2020/7/3.
 */
public class Test {
    public static void main(String[] args) {
        //声明一个产品Dao
        ProductDao productDao = new ProductDao();
        //将mysql数据库生成放入 产品Dao
        productDao.setdBconnection(new MysqlConnection());
        //增加产品
        productDao.addProduct();
    }
}
