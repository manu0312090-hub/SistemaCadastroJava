package br.com.sistema.view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionListener;

public class CadastroView extends JFrame {
    private JTextField txtNome;
    private JButton btnCadastrar;
    private JLabel lblStatus;
    private JTable tabelaUsuarios;
    private DefaultTableModel modeloTabela;

    public CadastroView() {
        setTitle("Sistema de Cadastro - Java Puro + MySQL");
        setSize(480, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout(10, 10));

        JPanel painelEntrada = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        JLabel lblNome = new JLabel("Nome:");
        txtNome = new JTextField(15);
        btnCadastrar = new JButton("Cadastrar");

        painelEntrada.add(lblNome);
        painelEntrada.add(txtNome);
        painelEntrada.add(btnCadastrar);

        modeloTabela = new DefaultTableModel();
        modeloTabela.addColumn("Nº");
        modeloTabela.addColumn("Nome Cadastrado");

        tabelaUsuarios = new JTable(modeloTabela);
        JScrollPane scrollPane = new JScrollPane(tabelaUsuarios);

        JPanel painelStatus = new JPanel(new FlowLayout(FlowLayout.LEFT));
        lblStatus = new JLabel(" ");
        painelStatus.add(lblStatus);

        add(painelEntrada, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(painelStatus, BorderLayout.SOUTH);
    }

    public String getNomeDigitado() { return txtNome.getText(); }

    public void limparCampoNome() {
        txtNome.setText("");
        txtNome.requestFocus();
    }

    public void adicionarLinhaTabela(int id, String nome) {
        modeloTabela.addRow(new Object[]{id, nome});
    }

    public void exibirMensagemSucesso(String mensagem) {
        lblStatus.setForeground(new Color(0, 128, 0));
        lblStatus.setText(mensagem);
    }

    public void exibirMensagemErro(String mensagem) {
        lblStatus.setForeground(Color.RED);
        lblStatus.setText(mensagem);
    }

    public void addCadastrarListener(ActionListener listener) {
        btnCadastrar.addActionListener(listener);
    }
}