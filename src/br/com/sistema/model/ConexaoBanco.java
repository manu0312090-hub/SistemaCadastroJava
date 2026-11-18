package br.com.sistema.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBanco {

    private static final String URL =
        "jdbc:mysql://localhost:3306/db_sistema?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";

    private static final String USUARIO = System.getenv("DB_USER");
    private static final String SENHA = System.getenv("DB_PASSWORD");

    public static Connection getConexao() throws SQLException {

        if (USUARIO == null || SENHA == null) {
            throw new SQLException(
                "Configure as variáveis DB_USER e DB_PASSWORD."
            );
        }

        return DriverManager.getConnection(URL, USUARIO, SENHA);
    }
}
