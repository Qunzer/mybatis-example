package qunzer.dbutils;

import org.apache.commons.pool2.impl.GenericObjectPool;

import java.sql.Connection;

/**
 * Created by yrq on 2016/2/24.
 */
public class JdbcConnectionUtils {
    private static final JdbcConnectionUtils instance = new JdbcConnectionUtils();
    private static final GenericObjectPool<Connection> genericObjectPool = new GenericObjectPool<Connection>(new JdbcConnectionPool());

    public static JdbcConnectionUtils getInstance() {
        return instance;
    }

    private JdbcConnectionUtils() {
    }

    public Connection getConnection() throws Exception {
        return genericObjectPool.borrowObject();

    }

    public void closeConnection(Connection connection) {
        genericObjectPool.returnObject(connection);
    }
}
