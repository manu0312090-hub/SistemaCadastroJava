package br.com.sistema.controller;

import br.com.sistema.model.AutenticacaoModel;
import br.com.sistema.model.UsuarioModel;

import br.com.sistema.view.LoginView;
import br.com.sistema.view.CadastroView;

import java.awt.Color;

public class LoginController {

    public LoginController(
        AutenticacaoModel authModel,
        LoginView loginView
    ) {

        // Evento do botão Entrar
        loginView.addEntrarListener(evento -> {

            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.isEmpty()) {

                loginView.exibirMensagem(
                    "Preencha o login e a senha!",
                    Color.RED
                );

                return;
            }

            if (authModel.autenticar(login, senha)) {

                loginView.dispose();

                abrirTelaPrincipal();

            } else {

                loginView.exibirMensagem(
                    "Login ou senha incorretos!",
                    Color.RED
                );
            }
        });

        // Evento do botão Novo Usuário
        loginView.addCadastrarListener(evento -> {

            String login = loginView.getLogin();
            String senha = loginView.getSenha();

            if (login.trim().isEmpty() || senha.isEmpty()) {

                loginView.exibirMensagem(
                    "Preencha o login e a senha!",
                    Color.RED
                );

                return;
            }

            if (authModel.cadastrarNovoUsuario(login, senha)) {

                loginView.exibirMensagem(
                    "Login cadastrado com sucesso!",
                    new Color(0, 128, 0)
                );

                loginView.limparCampos();

            } else {

                loginView.exibirMensagem(
                    "Não foi possível cadastrar. Verifique se o login já existe.",
                    Color.RED
                );
            }
        });
    }

    // Abre a tela principal depois da autenticação
    private void abrirTelaPrincipal() {

        UsuarioModel model = new UsuarioModel();

        CadastroView view = new CadastroView();

        int i = 1;

        for (String nome : model.getUsuarios()) {
            view.adicionarLinhaTabela(i++, nome);
        }

        new CadastroController(model, view);

        view.setVisible(true);
    }
}
