import java.security.Permissions;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverPropertyInfo;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.sql.Statement;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;

class DriverManager {
    private static final List<Driver> registeredDrivers = new CopyOnWriteArrayList<>();

    public static void registerDriver(Driver driver) {
        registeredDrivers.add(driver);
    }

    public static Connection getConnection(String url, Properties properties) throws SQLException {
        for (Driver driver : registeredDrivers) {
            if (driver.acceptsURL(url)) {
                return driver.connect(url, properties);
            }
        }
        throw new IllegalArgumentException("No suitable driver found for: " + url);
    }

    public static Connection getConnection(String url, String user, String password) throws SQLException {
        Properties info = new Properties();
        if (user != null)
            info.setProperty("user", user);
        if (password != null)
            info.setProperty("password", password);
        return getConnection(url, info);
    }
}

// Vendor implementation
class MySqlDriver implements Driver {

    @Override
    public boolean acceptsURL(String url) throws SQLException {
        return url != null && url.startsWith("jdbc:mysql:");
    }

}

class Client {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/app", "root", "secret");
        Statement statement = connection.createStatement();
        ResultSet result = statement.executeQuery("SELECT * FROM users");
        while (result.next()) {
            System.out.println("User ID" + result.getInt("id"));
        }
    }
}