package qunzer.dbutils;

import org.apache.commons.pool2.BasePooledObjectFactory;
import org.apache.commons.pool2.PooledObject;
import org.apache.commons.pool2.impl.DefaultPooledObject;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by yrq on 2016/2/24.
 */
public class JdbcConnectionPool extends BasePooledObjectFactory<Connection> {

    /**
     * Creates an object instance, to be wrapped in a {@link PooledObject}.
     * <p>This method <strong>must</strong> support concurrent, multi-threaded
     * activation.</p>
     *
     * @return an instance to be served by the pool
     * @throws Exception if there is a problem creating a new instance,
     *                   this will be propagated to the code requesting an object.
     */
    @Override
    public Connection create() throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
        return DriverManager.getConnection("url", "user", "password");
    }

    /**
     * Wrap the provided instance with an implementation of
     * {@link PooledObject}.
     *
     * @param obj the instance to wrap
     * @return The provided instance, wrapped by a {@link PooledObject}
     */
    @Override
    public PooledObject<Connection> wrap(Connection obj) {
        return new DefaultPooledObject<Connection>(obj);
    }
}
