package es.dynamic.dynamiccore.functions;

import es.dynamic.dynamiccore.Variables;

import java.sql.*;

public class MngSql {

    private Connection connection;
    private Statement statement;
    private String host, database, username, password;
    private int port;
    public MngSql () throws SQLException, ClassNotFoundException {
        this.host = (String) Variables.configSql.get("host");
        this.port = (int) Variables.configSql.get("port");
        this.database = (String) Variables.configSql.get("database");
        this.username = (String) Variables.configSql.get("username");
        this.password = (String) Variables.configSql.get("password");
        this.openConnection();
    }

    public Connection getConnection() {
        return this.connection;
    }
    public Statement getStatement() {
        return this.statement;
    }

    private void openConnection() throws SQLException, ClassNotFoundException {
        if (this.connection != null && !this.connection.isClosed()) {
            return;
        }

        synchronized (this) {
            if (this.connection != null && !this.connection.isClosed()) {
                return;
            }
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection("jdbc:mysql://" + this.host+ ":" + this.port + "/" + this.database, this.username, this.password);
            this.statement = this.connection.createStatement();
        }
    }

    public void initDatabase() throws SQLException {
        String queryInitial = "CREATE TABLE IF NOT EXISTS `players` (\n" +
                "  `id` bigint NOT NULL AUTO_INCREMENT PRIMARY KEY,\n" +
                "  `uuid` int NOT NULL,\n" +
                "  `username` int NOT NULL,\n" +
                "  `status` int NOT NULL,\n" +
                "  `pvp` int NOT NULL,\n" +
                "  `role` varchar(50) NOT NULL,\n" +
                "  `lastTime` datetime NOT NULL,\n" +
                "  `timeOnline` int NOT NULL\n" +
                "  `balance` float NOT NULL \n" +
                ") ENGINE='InnoDB';";
        this.update(queryInitial);
    }

    public ResultSet query(String query) throws SQLException {

        return this.getStatement().executeQuery(query);
    }

    public int update(String query) throws SQLException {
        return this.getStatement().executeUpdate(query);
    }

}
