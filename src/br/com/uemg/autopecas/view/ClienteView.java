/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package br.com.uemg.autopecas.view;

import br.com.uemg.autopecas.DAO.ClienteDAO;
import br.com.uemg.autopecas.controller.ConnectionFactory;
import br.com.uemg.autopecas.model.Cliente;
import br.com.uemg.autopecas.model.Pessoa;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author gustavo
 */
public class ClienteView extends javax.swing.JInternalFrame {

    public int transacao;

    /**
     * Creates new form Cliente
     */
    public ClienteView() {
        initComponents();
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        LabelNome = new javax.swing.JLabel();
        TextoNome = new javax.swing.JTextField();
        Painel = new javax.swing.JTabbedPane();
        PainelInformacoesPessoais = new javax.swing.JPanel();
        LabelApelido = new javax.swing.JLabel();
        TextoApelido = new javax.swing.JTextField();
        LabelTipo = new javax.swing.JLabel();
        LabelInscricao = new javax.swing.JLabel();
        LabelDataNascimento = new javax.swing.JLabel();
        ComboBoxTipo = new javax.swing.JComboBox<>();
        LabelContato = new javax.swing.JLabel();
        TextoContato = new javax.swing.JTextField();
        LabelEmail = new javax.swing.JLabel();
        TextoFormatadoNascimento = new javax.swing.JFormattedTextField();
        TextoEmail = new javax.swing.JTextField();
        TextoFormatadoInscricao = new javax.swing.JTextField();
        PainelEndereco = new javax.swing.JPanel();
        LabelCEP = new javax.swing.JLabel();
        TextoFormatadoCEP = new javax.swing.JFormattedTextField();
        LabelLogradouro = new javax.swing.JLabel();
        TextoLogradouro = new javax.swing.JTextField();
        LabelBairro = new javax.swing.JLabel();
        TextoBairro = new javax.swing.JTextField();
        TextoCidade = new javax.swing.JTextField();
        LabelCidade = new javax.swing.JLabel();
        ComboBoxUF = new javax.swing.JComboBox<>();
        LabelUF = new javax.swing.JLabel();
        BotaoGravar = new javax.swing.JButton();
        LabelCodigo = new javax.swing.JLabel();
        LabelDataCadastro = new javax.swing.JLabel();
        TextoFormatadoCadastro = new javax.swing.JFormattedTextField();
        BotaoBuscar = new javax.swing.JButton();
        TextoCodigo = new javax.swing.JTextField();
        BotaoNovo = new javax.swing.JButton();
        BotaoEditar = new javax.swing.JButton();
        BotaoCancelar = new javax.swing.JButton();
        BotaoExcluir = new javax.swing.JButton();

        setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createTitledBorder(""), "Cadastro de Clientes", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 1, 18)), "", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Liberation Sans", 1, 18))); // NOI18N
        setClosable(true);
        setForeground(java.awt.Color.white);
        setResizable(true);
        setToolTipText("");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setInputVerifier(getInputVerifier());
        setVisible(true);
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameOpened(evt);
            }
        });

        LabelNome.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelNome.setText("Nome Completo:");

        TextoNome.setEditable(false);
        TextoNome.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        Painel.setTabLayoutPolicy(javax.swing.JTabbedPane.SCROLL_TAB_LAYOUT);
        Painel.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N

        LabelApelido.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelApelido.setText("Apelido:");

        TextoApelido.setEditable(false);
        TextoApelido.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        TextoApelido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoApelidoActionPerformed(evt);
            }
        });

        LabelTipo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelTipo.setText("Tipo:");

        LabelInscricao.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelInscricao.setText("Inscrição:");

        LabelDataNascimento.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelDataNascimento.setText("Data Nascimento:");

        ComboBoxTipo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        ComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "CPF", "CNPJ" }));
        ComboBoxTipo.setEnabled(false);

        LabelContato.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelContato.setText("Contato:");

        TextoContato.setEditable(false);
        TextoContato.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        LabelEmail.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelEmail.setText("E-mail:");

        TextoFormatadoNascimento.setEditable(false);
        try {
            TextoFormatadoNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextoFormatadoNascimento.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        TextoEmail.setEditable(false);
        TextoEmail.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        TextoFormatadoInscricao.setEditable(false);
        TextoFormatadoInscricao.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        javax.swing.GroupLayout PainelInformacoesPessoaisLayout = new javax.swing.GroupLayout(PainelInformacoesPessoais);
        PainelInformacoesPessoais.setLayout(PainelInformacoesPessoaisLayout);
        PainelInformacoesPessoaisLayout.setHorizontalGroup(
            PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(TextoEmail)
                    .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                        .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                                .addComponent(LabelApelido)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(TextoApelido))
                        .addGap(18, 18, 18)
                        .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(TextoFormatadoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(LabelDataNascimento)))
                    .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                        .addComponent(LabelEmail)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                        .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelTipo)
                            .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelInscricao)
                            .addComponent(TextoFormatadoInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                                .addComponent(LabelContato)
                                .addGap(0, 241, Short.MAX_VALUE))
                            .addComponent(TextoContato))))
                .addContainerGap())
        );
        PainelInformacoesPessoaisLayout.setVerticalGroup(
            PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelInformacoesPessoaisLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelApelido)
                    .addComponent(LabelDataNascimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoApelido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoFormatadoNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelInscricao)
                    .addComponent(LabelTipo)
                    .addComponent(LabelContato))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelInformacoesPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoContato, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoFormatadoInscricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(LabelEmail)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Painel.addTab("Informações Pessoais", PainelInformacoesPessoais);

        LabelCEP.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelCEP.setText("CEP:");

        TextoFormatadoCEP.setEditable(false);
        try {
            TextoFormatadoCEP.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        TextoFormatadoCEP.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        LabelLogradouro.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelLogradouro.setText("Logradouro:");

        TextoLogradouro.setEditable(false);
        TextoLogradouro.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N
        TextoLogradouro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TextoLogradouroActionPerformed(evt);
            }
        });

        LabelBairro.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelBairro.setText("Bairro:");

        TextoBairro.setEditable(false);
        TextoBairro.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        TextoCidade.setEditable(false);
        TextoCidade.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        LabelCidade.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelCidade.setText("Cidade:");

        ComboBoxUF.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        ComboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "AC", "AL", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
        ComboBoxUF.setEnabled(false);

        LabelUF.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelUF.setText("UF:");

        javax.swing.GroupLayout PainelEnderecoLayout = new javax.swing.GroupLayout(PainelEndereco);
        PainelEndereco.setLayout(PainelEnderecoLayout);
        PainelEnderecoLayout.setHorizontalGroup(
            PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEnderecoLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(PainelEnderecoLayout.createSequentialGroup()
                        .addComponent(TextoCidade)
                        .addGap(18, 18, 18)
                        .addComponent(ComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(TextoLogradouro)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PainelEnderecoLayout.createSequentialGroup()
                        .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(PainelEnderecoLayout.createSequentialGroup()
                                .addComponent(TextoBairro)
                                .addGap(18, 18, 18))
                            .addGroup(PainelEnderecoLayout.createSequentialGroup()
                                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(LabelBairro)
                                    .addComponent(LabelLogradouro)
                                    .addComponent(LabelCidade))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 402, Short.MAX_VALUE)))
                        .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LabelUF)
                            .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(PainelEnderecoLayout.createSequentialGroup()
                                    .addComponent(LabelCEP)
                                    .addGap(79, 79, 79))
                                .addComponent(TextoFormatadoCEP, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 131, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        PainelEnderecoLayout.setVerticalGroup(
            PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PainelEnderecoLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(LabelLogradouro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(TextoLogradouro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelBairro)
                    .addComponent(LabelCEP))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoFormatadoCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCidade)
                    .addComponent(LabelUF))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(PainelEnderecoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ComboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Painel.addTab("Endereço", PainelEndereco);

        BotaoGravar.setBackground(new java.awt.Color(0, 102, 102));
        BotaoGravar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoGravar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoGravar.setText("Gravar");
        BotaoGravar.setEnabled(false);
        BotaoGravar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoGravarActionPerformed(evt);
            }
        });

        LabelCodigo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelCodigo.setText("Código");

        LabelDataCadastro.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        LabelDataCadastro.setText("Data de Cadastro");

        TextoFormatadoCadastro.setEditable(false);
        TextoFormatadoCadastro.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("y/MM/dd"))));
        TextoFormatadoCadastro.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        BotaoBuscar.setBackground(new java.awt.Color(0, 102, 102));
        BotaoBuscar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoBuscar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoBuscar.setText("...");
        BotaoBuscar.setToolTipText("");
        BotaoBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoBuscarActionPerformed(evt);
            }
        });

        TextoCodigo.setFont(new java.awt.Font("Liberation Sans", 0, 18)); // NOI18N

        BotaoNovo.setBackground(new java.awt.Color(0, 102, 102));
        BotaoNovo.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoNovo.setForeground(new java.awt.Color(255, 255, 255));
        BotaoNovo.setText("Novo");
        BotaoNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoNovoActionPerformed(evt);
            }
        });

        BotaoEditar.setBackground(new java.awt.Color(0, 0, 102));
        BotaoEditar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoEditar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoEditar.setText("Editar");
        BotaoEditar.setEnabled(false);
        BotaoEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoEditarActionPerformed(evt);
            }
        });

        BotaoCancelar.setBackground(new java.awt.Color(204, 0, 0));
        BotaoCancelar.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoCancelar.setForeground(new java.awt.Color(255, 255, 255));
        BotaoCancelar.setText("Cancelar");
        BotaoCancelar.setEnabled(false);
        BotaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoCancelarActionPerformed(evt);
            }
        });

        BotaoExcluir.setBackground(new java.awt.Color(204, 0, 0));
        BotaoExcluir.setFont(new java.awt.Font("Liberation Sans", 1, 18)); // NOI18N
        BotaoExcluir.setForeground(new java.awt.Color(255, 255, 255));
        BotaoExcluir.setText("Excluir");
        BotaoExcluir.setEnabled(false);
        BotaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BotaoExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(TextoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(TextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(BotaoBuscar))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(LabelCodigo)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(LabelNome)))
                            .addGap(18, 18, 18)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(LabelDataCadastro)
                                .addComponent(TextoFormatadoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, 653, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(BotaoNovo)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoEditar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(BotaoGravar)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LabelCodigo)
                    .addComponent(LabelNome)
                    .addComponent(LabelDataCadastro))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(TextoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BotaoBuscar)
                    .addComponent(TextoFormatadoCadastro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(TextoCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(Painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BotaoGravar)
                    .addComponent(BotaoCancelar)
                    .addComponent(BotaoEditar)
                    .addComponent(BotaoExcluir)
                    .addComponent(BotaoNovo))
                .addContainerGap())
        );

        setBounds(150, 50, 700, 525);
    }// </editor-fold>//GEN-END:initComponents

    private void TextoApelidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoApelidoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoApelidoActionPerformed

    private void TextoLogradouroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_TextoLogradouroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_TextoLogradouroActionPerformed

    private void BotaoGravarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoGravarActionPerformed

        gravar();
        TextoCodigo.setEnabled(true);
        BotaoNovo.setEnabled(true);
        BotaoEditar.setEnabled(true);
    }//GEN-LAST:event_BotaoGravarActionPerformed

    public void gravar() {
        try (Connection connection = new ConnectionFactory().getConnection()) {

            ClienteDAO cd = new ClienteDAO(connection);
            if (transacao == 0) {
                cd.create(new Cliente(
                        0, new Pessoa(
                                (String) ComboBoxTipo.getSelectedItem(),
                                TextoFormatadoInscricao.getText(),
                                TextoApelido.getText(),
                                TextoNome.getText(),
                                TextoFormatadoNascimento.getText(),
                                TextoLogradouro.getText(),
                                TextoBairro.getText(),
                                TextoCidade.getText(),
                                (String) ComboBoxUF.getSelectedItem(),
                                TextoFormatadoCEP.getText()
                        ),
                        TextoContato.getText(),
                        TextoEmail.getText()
                ));
                JOptionPane.showMessageDialog(null, "Gravado no banco de dados!");
                campos(false);
            }
            if (transacao == 1) {
                cd.update(new Cliente(
                        Integer.valueOf(TextoCodigo.getText()), new Pessoa(
                        (String) ComboBoxTipo.getSelectedItem(),
                        TextoFormatadoInscricao.getText(),
                        TextoApelido.getText(),
                        TextoNome.getText(),
                        TextoFormatadoNascimento.getText(),
                        TextoLogradouro.getText(),
                        TextoBairro.getText(),
                        TextoCidade.getText(),
                        (String) ComboBoxUF.getSelectedItem(),
                        TextoFormatadoCEP.getText()
                ),
                        TextoContato.getText(),
                        TextoEmail.getText()
                ));
                JOptionPane.showMessageDialog(null, "Gravado no banco de dados!");
                campos(false);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a solicitação");
        }
    }

    private void BotaoBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoBuscarActionPerformed
        if (TextoCodigo.getText().isEmpty()) {
            buscar(0);
        } else {
            buscar(Integer.valueOf(TextoCodigo.getText()));
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_BotaoBuscarActionPerformed

    public void buscar(Integer busca) {

        System.out.println("método buscar(): " + busca);

        try (Connection connection = new ConnectionFactory().getConnection()) {

            if (busca != 0) {

                ClienteDAO dao = new ClienteDAO(connection);

                List<Cliente> c = dao.read(busca);
                System.out.println(c);
                BotaoEditar.setEnabled(true);
                preencher(c);
                campos(false);
            } else {

                ConsultaClienteView cliente = new ConsultaClienteView();
                PrincipalView.DesktopPanePrincipal.add(cliente);
                cliente.setVisible(true);
                PrincipalView.DesktopPanePrincipal.setComponentZOrder(cliente, 0);

            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Não conseguimos recuperar esses dados");
        }
    }

    private void formInternalFrameOpened(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameOpened
        // TODO add your handling code here:
        PrincipalView.ClienteView = true;
    }//GEN-LAST:event_formInternalFrameOpened

    private void BotaoNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoNovoActionPerformed
        // TODO add your handling code here:
        transacao = 0;
        limpar();
        campos(true);
        TextoCodigo.setEnabled(false);
        TextoFormatadoCadastro.setEnabled(false);
        BotaoNovo.setEnabled(false);
    }//GEN-LAST:event_BotaoNovoActionPerformed

    private void BotaoEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoEditarActionPerformed
        // TODO add your handling code here:
        transacao = 1;
        campos(true);
        TextoCodigo.setEnabled(false);
        BotaoEditar.setEnabled(false);
        BotaoNovo.setEnabled(false);
    }//GEN-LAST:event_BotaoEditarActionPerformed

    private void BotaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoCancelarActionPerformed
        // TODO add your handling code here:
        limpar();
        campos(false);
        TextoCodigo.setEnabled(true);
        BotaoNovo.setEnabled(true);
    }//GEN-LAST:event_BotaoCancelarActionPerformed

    private void BotaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BotaoExcluirActionPerformed
        // TODO add your handling code here:
        excluir();
    }//GEN-LAST:event_BotaoExcluirActionPerformed

    public void excluir() {
        try (Connection connection = new ConnectionFactory().getConnection()) {

            if (JOptionPane.showConfirmDialog(null, "Deseja excluir o registro?", "Confirmação de exclusão!", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE) == JOptionPane.YES_OPTION) {

                ClienteDAO dao = new ClienteDAO(connection);
                Cliente c = new Cliente();

                Integer id = Integer.valueOf(
                        TextoCodigo.getText());

                c.setId(id);
                dao.delete(c);
                limpar();
            }

            JOptionPane.showMessageDialog(null, "Excluído no Banco de Dados");
            campos(false);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível concluir a solicitação");
        }
    }

    public void capturar(Cliente cliente) {

        System.out.println("function capturar(): " + cliente.getId());

        TextoCodigo.setText(String.valueOf(cliente.getId()));
        limpar();
        buscar(cliente.getId());

    }

    public void preencher(List<Cliente> cliente) {

        TextoCodigo.setText(String.valueOf(cliente.get(0).getId()));
        TextoNome.setText(cliente.get(0).getPessoa().getNome());
        //TextoFormatadoCadastro.setText(cliente.getCadastro());
        TextoApelido.setText(cliente.get(0).getPessoa().getApelido());
        ComboBoxTipo.setSelectedItem(cliente.get(0).getPessoa().getTipo());
        TextoFormatadoInscricao.setText(cliente.get(0).getPessoa().getInscricao());
        TextoFormatadoNascimento.setText(cliente.get(0).getPessoa().getNascimento());
        TextoLogradouro.setText(cliente.get(0).getPessoa().getLogradouro());
        TextoBairro.setText(cliente.get(0).getPessoa().getBairro());
        TextoCidade.setText(cliente.get(0).getPessoa().getCidade());
        ComboBoxUF.setSelectedItem(cliente.get(0).getPessoa().getUf());
    }

    public void limpar() {

        TextoCodigo.setText("");
        ComboBoxTipo.setSelectedItem(ABORT);
        TextoFormatadoInscricao.setText("");
        TextoNome.setText("");
        TextoApelido.setText("");
        TextoFormatadoNascimento.setText("");
        TextoEmail.setText("");
        TextoContato.setText("");
        TextoLogradouro.setText("");
        TextoBairro.setText("");
        TextoCidade.setText("");
        ComboBoxUF.setSelectedItem(ABORT);
        TextoFormatadoCEP.setText("");
    }

    public void campos(boolean status) {
        ComboBoxTipo.setEnabled(status);
        TextoFormatadoInscricao.setEditable(status);
        TextoFormatadoInscricao.setEditable(status);
        TextoNome.setEditable(status);
        TextoApelido.setEditable(status);
        TextoEmail.setEditable(status);
        TextoContato.setEditable(status);
        TextoFormatadoNascimento.setEditable(status);
        TextoLogradouro.setEditable(status);
        TextoBairro.setEditable(status);
        TextoCidade.setEditable(status);
        ComboBoxUF.setEnabled(status);
        TextoFormatadoCEP.setEditable(status);
        BotaoCancelar.setEnabled(status);
        BotaoGravar.setEnabled(status);
        BotaoExcluir.setEnabled(status);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BotaoBuscar;
    private javax.swing.JButton BotaoCancelar;
    private javax.swing.JButton BotaoEditar;
    private javax.swing.JButton BotaoExcluir;
    private javax.swing.JButton BotaoGravar;
    private javax.swing.JButton BotaoNovo;
    private javax.swing.JComboBox<String> ComboBoxTipo;
    private javax.swing.JComboBox<String> ComboBoxUF;
    private javax.swing.JLabel LabelApelido;
    private javax.swing.JLabel LabelBairro;
    private javax.swing.JLabel LabelCEP;
    private javax.swing.JLabel LabelCidade;
    private javax.swing.JLabel LabelCodigo;
    private javax.swing.JLabel LabelContato;
    private javax.swing.JLabel LabelDataCadastro;
    private javax.swing.JLabel LabelDataNascimento;
    private javax.swing.JLabel LabelEmail;
    private javax.swing.JLabel LabelInscricao;
    private javax.swing.JLabel LabelLogradouro;
    private javax.swing.JLabel LabelNome;
    private javax.swing.JLabel LabelTipo;
    private javax.swing.JLabel LabelUF;
    private javax.swing.JTabbedPane Painel;
    private javax.swing.JPanel PainelEndereco;
    private javax.swing.JPanel PainelInformacoesPessoais;
    private javax.swing.JTextField TextoApelido;
    private javax.swing.JTextField TextoBairro;
    private javax.swing.JTextField TextoCidade;
    public static javax.swing.JTextField TextoCodigo;
    private javax.swing.JTextField TextoContato;
    private javax.swing.JTextField TextoEmail;
    private javax.swing.JFormattedTextField TextoFormatadoCEP;
    private javax.swing.JFormattedTextField TextoFormatadoCadastro;
    private javax.swing.JTextField TextoFormatadoInscricao;
    private javax.swing.JFormattedTextField TextoFormatadoNascimento;
    private javax.swing.JTextField TextoLogradouro;
    private javax.swing.JTextField TextoNome;
    // End of variables declaration//GEN-END:variables
}
