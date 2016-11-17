package com.vector_polaco.utilities;

import java.sql.*;

/**
 * Created by robil on 29/10/2016.
 */
public class ConnectionManager {
    private static Connection dbConnection;
    private static ConnectionManager instance = null;
    private static final String connectionName = "jdbc:sqlite:";
    private static final String db_name = "test.db";

    protected ConnectionManager() {
        try {
            Class.forName("org.sqlite.JDBC");
            dbConnection = DriverManager.getConnection(connectionName + db_name);
            System.out.println("Opened database successfully");
            String crear_tabla_criterios = "" +
                    "CREATE TABLE IF NOT EXISTS criterio (" +
                    "id                             INT             PRIMARY     KEY     NOT NULL," +
                    "porcentaje_deducido            INT                                 NOT NULL," +
                    "valor                          INT                                 NOT NULL" +
                    ");";
            String crear_tabla_lista_criterios = "" +
                    "CREATE TABLE IF NOT EXISTS lista_criterios (" +
                    "       id                             INT             PRIMARY     KEY     NOT NULL," +
                    "       nombre                         VARCHAR(100)                        NOT NULL," +
                    "       id_criterio_nombre_archivo     INT                                 NOT NULL," +
                    "       id_criterio_vars_ctes          INT                                 NOT NULL," +
                    "       id_criterio_espacios           INT                                 NOT NULL," +
                    "       id_criterio_comentario_inicial INT                                 NOT NULL," +
                    "       id_criterio_comentarios_funcs  INT                                 NOT NULL, " +

                    "FOREIGN KEY (id_criterio_nombre_archivo, id_criterio_vars_ctes, id_criterio_espacios, id_criterio_comentario_inicial, id_criterio_comentarios_funcs)" +
                    "       REFERENCES criterio(id, id, id, id, id)" +
                    "       ON DELETE CASCADE" +
                    ");";
            Statement stmt = dbConnection.createStatement();

            stmt.executeUpdate(crear_tabla_criterios);
            stmt.executeUpdate(crear_tabla_lista_criterios);
            stmt.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
        }
    }

    public static ConnectionManager getInstance() {
        if (instance == null) {
            instance = new ConnectionManager();
        }
        return instance;
    }

    public void execute(String query) {
        Statement stmt = null;
        try {
            stmt = dbConnection.createStatement();
            stmt.execute(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet executeQuery(String query){
        Statement stmt = null;
        ResultSet results = null;
        try {
            stmt = dbConnection.createStatement();
            results = stmt.executeQuery(query);
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }

    public int executeInsert(String query){
        Statement stmt = null;
        int generatedKey = 0;
        try {
            stmt = dbConnection.createStatement();
            stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = stmt.getGeneratedKeys();
            if(rs.next()) {
                generatedKey = rs.getInt(1);
            }
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            return generatedKey;
        }
    }
}
