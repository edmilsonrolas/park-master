/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package parkmaster.dao;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Esta classe representa uma conexão a uma base de dados SQLite.
 * 
 * A classe fornece métodos para obter e fechar uma conexão com a base de dados.
 * 
 * Certifique-se de ajustar o URL JDBC e o local da base de dados conforme necessário.
 * 
 * @author rolas
 */
public class SQLiteDBConnection {
    private static Connection connection;

    /**
     * Obtém uma conexão com a base de dados SQLite.
     *
     * @return A conexão com a base de dados.
     * @throws SQLException Se ocorrer um erro ao estabelecer a conexão.
     */
    public static Connection getConnection() throws SQLException {
        if (connection == null || connection.isClosed()) {
            try {
                Class.forName("org.sqlite.JDBC");
                connection = DriverManager.getConnection("jdbc:sqlite:G-CreditDataBase.db");
                
                // Chama os métodos para criar as tabelas, se elas ainda não existirem
                createTopupsTable();
                createClientsTable();
                createUsersTable();
            } catch (ClassNotFoundException e) {
                throw new SQLException("Driver JDBC SQLite não encontrado.", e);
            } catch (SQLException e) {
                throw new SQLException("Erro ao estabelecer a conexão com a base de dados.", e);
            }
        }
        return connection;
    }

    /**
     * Fecha a conexão com a base de dados.
     * 
     * @throws SQLException Se ocorrer um erro ao fechar a conexão.
     */
    public static void closeConnection() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new SQLException("Erro ao fechar a conexão com a base de dados.", e);
            }
        }
    }
    
    /**
     * Cria a tabela 'topups' na base de dados, se ela ainda não existir.
     *
     * @throws SQLException Se ocorrer um erro durante a criação da tabela.
     */
    public static void createTopupsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS topups ("
                + "id TEXT PRIMARY KEY,"
                + "value INTEGER,"
                + "operator TEXT,"
                + "stock_quantity INTEGER"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    /**
     * Cria a tabela 'clients' na base de dados, se ela ainda não existir.
     *
     * @throws SQLException Se ocorrer um erro durante a criação da tabela.
     */
    public static void createClientsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS clients ("
                + "customerID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "firstName TEXT,"
                + "lastName TEXT,"
                + "email TEXT,"
                + "phone TEXT,"
                + "address TEXT"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public static void addAutoIncrementToCustomerID() throws SQLException {
//        String sql = "CREATE TABLE IF NOT EXISTS clients_temp AS SELECT * FROM clients;";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        }

        String sql = "DROP TABLE IF EXISTS clients;";
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }

//        sql = "CREATE TABLE IF NOT EXISTS clients ("
//            + "customerID INTEGER PRIMARY KEY AUTOINCREMENT,"
//            + "firstName TEXT,"
//            + "lastName TEXT,"
//            + "dateOfBirth TEXT,"
//            + "email TEXT,"
//            + "phone TEXT,"
//            + "address TEXT,"
//            + "membershipStatus TEXT,"
//            + "loyaltyPoints INTEGER"
//            + ")";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        }

//        sql = "INSERT INTO clients SELECT NULL, firstName, lastName, dateOfBirth, email, phone, address, membershipStatus, loyaltyPoints FROM clients_temp;";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        }

//        sql = "DROP TABLE IF EXISTS clients_temp;";
//        try (Statement statement = connection.createStatement()) {
//            statement.execute(sql);
//        }
    }    
    
    /**
     * Cria a tabela 'users' na base de dados, se ela ainda não existir.
     *
     * @throws SQLException Se ocorrer um erro durante a criação da tabela.
     */
    public static void createUsersTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS users ("
                + "userID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "firstName TEXT,"
                + "lastName TEXT,"
                + "dateOfBirth TEXT,"
                + "email TEXT,"
                + "phone TEXT,"
                + "address TEXT,"
                + "position TEXT,"
                + "salary REAL"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
    
    /**
     * Cria a tabela 'sales' na base de dados, se ela ainda não existir.
     * A tabela 'sales' armazenará informações sobre vendas, incluindo IDs de venda, data de venda, cliente, utilizador e outras informações relacionadas a vendas.
     *
     * @throws SQLException Se ocorrer um erro durante a criação da tabela.
     */
    public static void createSalesTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS sales ("
                + "saleID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "saleDate TEXT,"
                + "userID INTEGER,"
                + "clientID INTEGER,"
                + "totalAmount REAL,"
                + "totalPrice REAL,"
                + "profit REAL,"
                + "FOREIGN KEY (userID) REFERENCES users(userID),"
                + "FOREIGN KEY (clientID) REFERENCES clients(customerID)"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
    
    /**
     * Cria a tabela 'saleTopups' na base de dados, se ela ainda não existir.
     *
     * @throws SQLException Se ocorrer um erro durante a criação da tabela.
     */
    public static void createSaleTopupsTable() throws SQLException {
        String sql = "CREATE TABLE IF NOT EXISTS saleTopups ("
                + "saleTopupID INTEGER PRIMARY KEY AUTOINCREMENT,"
                + "topupID TEXT,"
                + "quantity INTEGER,"
                + "saleID INTEGER"
                + ")";

        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }
    

}

