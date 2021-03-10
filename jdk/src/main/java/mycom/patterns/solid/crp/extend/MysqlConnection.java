package mycom.patterns.solid.crp.extend;

/**
 * Created by 20013649 on 2020/7/3.
 */
public class MysqlConnection extends DBconnection {
    @Override
    public String getConnection() {
        return "Mysql数据库连接";
    }
}
