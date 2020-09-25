package org.minbox.framework.bulldog.storage.database;

import org.minbox.framework.bulldog.storage.LogStorage;
import org.minbox.framework.bulldog.storage.LogStorageException;
import org.minbox.framework.bulldog.storage.database.executor.service.ServiceInsertDataExecutor;
import org.minbox.framework.bulldog.storage.database.executor.variable.ParameterVariable;
import org.minbox.framework.fulldog.core.pojo.LogDetails;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * database way to implement {@link LogStorage}
 *
 * @author 恒宇少年
 */
public class DatabaseLogStorage implements LogStorage {
    private DataSource dataSource;

    public DatabaseLogStorage(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Override
    public String save(LogDetails logDetails) throws LogStorageException {
        try {
            Connection connection = dataSource.getConnection();

            // 保存ServiceDetails
            ServiceInsertDataExecutor serviceInsertDataExecutor = new ServiceInsertDataExecutor();
            ParameterVariable variable = new ParameterVariable();
            serviceInsertDataExecutor.execute(connection, variable);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
