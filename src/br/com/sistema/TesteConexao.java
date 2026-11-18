package br.com.sistema;

import br.com.sistema.model.ConexaoBanco;
import java.sql.Connection;
import java.sql.SQLException;

public class TesteConexao {

    public static void main(String[] args) {

        try (Connection conexao = ConexaoBanco.getConexao()) {

            System.out.println("================================");
            System.out.println("CONEXAO COM MYSQL REALIZADA!");
            System.out.println("Banco: " +
                conexao.getCatalog());
            System.out.println("================================");

        } catch (SQLException e) {

            System.out.println("ERRO AO CONECTAR AO MYSQL:");
            System.out.println(e.getMessage());

        }
    }
}
