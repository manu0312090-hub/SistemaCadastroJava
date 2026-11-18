package br.com.sistema.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AutenticacaoModel {

    // Verifica se o login e a senha existem no banco
    public boolean autenticar(String login, String senha) {

        if (login == null || senha == null ||
            login.trim().isEmpty() || senha.isEmpty()) {
            return false;
        }

        String sql = "SELECT id FROM autenticacao WHERE login = ? AND senha = ?";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.trim());
            stmt.setString(2, senha);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next();
            }

        } catch (SQLException e) {
            System.err.println("Erro ao autenticar: " + e.getMessage());
            return false;
        }
    }

    // Cadastra um novo acesso ao sistema
    public boolean cadastrarNovoUsuario(String login, String senha) {

        if (login == null || senha == null ||
            login.trim().isEmpty() || senha.isEmpty()) {
            return false;
        }

        String sql = "INSERT INTO autenticacao (login, senha) VALUES (?, ?)";

        try (Connection conn = ConexaoBanco.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, login.trim());
            stmt.setString(2, senha);

            stmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            System.err.println("Erro ao cadastrar login: " + e.getMessage());
            return false;
        }
    }
}
