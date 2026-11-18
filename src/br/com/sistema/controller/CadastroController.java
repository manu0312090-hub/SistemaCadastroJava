package br.com.sistema.controller;

import br.com.sistema.model.UsuarioModel;
import br.com.sistema.view.CadastroView;

public class CadastroController {

    public CadastroController(UsuarioModel model, CadastroView view) {

        view.addCadastrarListener(evento -> {

            String nome = view.getNomeDigitado();

            if (nome == null || nome.trim().isEmpty()) {
                view.exibirMensagemErro("Aviso: digite um nome!");
                return;
            }

            model.adicionarUsuario(nome);

            view.adicionarLinhaTabela(
                model.getTotalUsuarios(),
                nome.trim()
            );

            view.exibirMensagemSucesso(
                "Cadastrado com sucesso no MySQL!"
            );

            view.limparCampoNome();
        });
    }
}
