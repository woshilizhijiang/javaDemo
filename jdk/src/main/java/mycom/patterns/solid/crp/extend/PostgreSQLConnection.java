package mycom.patterns.solid.crp.extend;

/**
 * Created by 20013649 on 2020/7/3.
 */
public class PostgreSQLConnection extends DBconnection {
    @Override
    public String getConnection() {
        return "PostgreSQL数据库连接";
    }
}
