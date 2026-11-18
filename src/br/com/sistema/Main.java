package br.com.sistema;

import br.com.sistema.controller.LoginController;
import br.com.sistema.model.AutenticacaoModel;
import br.com.sistema.view.LoginView;

import javax.swing.SwingUtilities;

public class Main {

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            AutenticacaoModel authModel = new AutenticacaoModel();
            LoginView loginView = new LoginView();

            new LoginController(authModel, loginView);

            loginView.setVisible(true);
        });
    }
}
