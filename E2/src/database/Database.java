package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
import java.io.InputStream;

/**
 * Simple Database connection helper. Edit src/database/db.properties for credentials.
 */
public class Database {
    private static Connection conn;

    private Database() {}

    public static Connection getConnection() throws SQLException {
        if (conn == null || conn.isClosed()) {
            try (InputStream in = Database.class.getResourceAsStream("/database/db.properties")) {
                Properties p = new Properties();
                p.load(in);
                String url = p.getProperty("url");
                String user = p.getProperty("user");
                String pass = p.getProperty("password");
                conn = DriverManager.getConnection(url, user, pass);
            } catch (Exception e) {
                throw new SQLException("Failed to read DB properties or connect: " + e.getMessage(), e);
            }
        }
        return conn;
    }
}
