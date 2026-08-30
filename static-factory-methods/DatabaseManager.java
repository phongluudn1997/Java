import java.sql.Connection;
import java.sql.SQLException;
import com.zaxxer.hikari.HikariDataSource;

class DatabaseManager {
    private static final HikariDataSource dataSource = new HikariDataSource();

    static {
        dataSource.setJdbcurl("jdbc:mysql://localhost:3306/prod_db");
        dataSource.setUsername("admin");
        dataSource.setPassword("secret");
        dataSource.setMaximumPoolSize(10);
    }

    // Recycles connection instead of allocating new TCP socket
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
