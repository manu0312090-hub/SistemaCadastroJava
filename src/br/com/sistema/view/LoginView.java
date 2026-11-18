package br.com.sistema.view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionListener;

public class LoginView extends JFrame {

    private JTextField txtLogin;
    private JPasswordField txtSenha;

    private JButton btnEntrar;
    private JButton btnCadastrar;

    private JLabel lblMensagem;

    public LoginView() {

        setTitle("Acesso ao Sistema");
        setSize(420, 280);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JPanel painelPrincipal = new JPanel(new BorderLayout(10, 15));
        painelPrincipal.setBorder(new EmptyBorder(20, 25, 20, 25));

        JLabel titulo = new JLabel("Acesso ao Sistema", SwingConstants.CENTER);
        titulo.setFont(new Font("Arial", Font.BOLD, 22));

        painelPrincipal.add(titulo, BorderLayout.NORTH);

        JPanel painelCampos = new JPanel(new GridLayout(2, 2, 10, 15));

        painelCampos.add(new JLabel("Login:"));

        txtLogin = new JTextField();
        painelCampos.add(txtLogin);

        painelCampos.add(new JLabel("Senha:"));

        txtSenha = new JPasswordField();
        painelCampos.add(txtSenha);

        painelPrincipal.add(painelCampos, BorderLayout.CENTER);

        JPanel painelInferior = new JPanel(new BorderLayout(5, 10));

        JPanel painelBotoes = new JPanel(new FlowLayout());

        btnEntrar = new JButton("Entrar");
        btnCadastrar = new JButton("Novo Usuário");

        painelBotoes.add(btnEntrar);
        painelBotoes.add(btnCadastrar);

        lblMensagem = new JLabel(" ", SwingConstants.CENTER);

        painelInferior.add(painelBotoes, BorderLayout.CENTER);
        painelInferior.add(lblMensagem, BorderLayout.SOUTH);

        painelPrincipal.add(painelInferior, BorderLayout.SOUTH);

        add(painelPrincipal);

        getRootPane().setDefaultButton(btnEntrar);
    }

    public String getLogin() {
        return txtLogin.getText();
    }

    public String getSenha() {
        return new String(txtSenha.getPassword());
    }

    public void limparCampos() {
        txtLogin.setText("");
        txtSenha.setText("");
        txtLogin.requestFocus();
    }

    public void exibirMensagem(String mensagem, Color cor) {
        lblMensagem.setForeground(cor);
        lblMensagem.setText(mensagem);
    }

    public void addEntrarListener(ActionListener listener) {
        btnEntrar.addActionListener(listener);
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}
