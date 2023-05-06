package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import dao.AlunoDAO;
import model.Aluno;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.text.ParseException;
import java.awt.event.InputEvent;
import javax.swing.JSeparator;
import javax.swing.JToggleButton;
import javax.swing.JTabbedPane;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import java.awt.BorderLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.SpringLayout;
import javax.swing.JFormattedTextField;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class Tela extends JFrame {
	private JPanel contentPane;
	private JPanel contentPane2;
	private JLabel labelRgm;
	private JFormattedTextField txtRgm;
	private JTextField txtRgmNotasFaltas;
	private JLabel labelRgmNotas;
	private JLabel labelNome;
	private JFormattedTextField txtNome;
	private JLabel labelEmail;
	private JFormattedTextField txtEmail;
	private JLabel labelEndereco;
	private JFormattedTextField txtEndereco;
	private JFormattedTextField txtMunicipio;
	private JLabel labelMunicipio;
	private JLabel labelUf;
	private JFormattedTextField txtDtNascimento;
	private JLabel labelDtNascimento;
	private JFormattedTextField txtCelular;
	private JLabel labelCelular;
	private JFormattedTextField txtCpf;
	private JLabel labelCpf;
	private JButton btLimpar;
	private JButton btSalvar;
	private JButton btConsultar;
	private JButton btAlterar;
	private JButton btExcluir;
	private JButton btSair;
	private JMenuBar menuBar;
	private JMenu mnNewMenu;
	private JMenu mnNewMenu_1;
	private JMenu mnNewMenu_2;
	private JMenuItem mntmNewMenuItem;
	private JMenuItem mntmNewMenuItem_1;
	private JMenuItem mntmNewMenuItem_2;
	private JMenuItem mntmNewMenuItem_3;
	private JMenuItem mntmNewMenuItem_4;
	private JMenuItem mntmNewMenuItem_5;
	private JMenuItem mntmNewMenuItem_6;
	private JMenuItem mntmNewMenuItem_7;
	private JMenuItem mntmNewMenuItem_8;
	private JMenuItem mntmNewMenuItem_9;
	private JSeparator separator;
	private JPanel panel_Curso;
	private JPanel panel_Notas_E_Faltas;
	private JPanel panel_Boletim;
	private JLabel lblNewLabel;
	private JComboBox comboBoxCurso;
	private JLabel lblNewLabel_1;
	private JComboBox comboBoxCampus;
	private JLabel lblNewLabel_2;
	private MaskFormatter formatterCpf;
	private MaskFormatter formatterDtNascimento;
	private JComboBox comboBoxDisciplina;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JComboBox comboBox_4;
	private JLabel lblNewLabel_5;
	private JComboBox comboBox_5;
	private JLabel lblNewLabel_6;
	private JTextField textField;
	private JTextField nomeNotasFaltas;
	private JTextField cursoNotasFaltas;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setTitle("Projeto MVC");
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	// "Design" da tela é feito no próprio construtor
	public Tela() throws Exception {

		// FVG 24/05 - Panel da aplicação
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 775, 314);

		menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		mnNewMenu = new JMenu("Aluno");

		mntmNewMenuItem = new JMenuItem("Salvar");
		mntmNewMenuItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));

		mntmNewMenuItem_1 = new JMenuItem("Alterar");

		mntmNewMenuItem_2 = new JMenuItem("Consultar");

		mntmNewMenuItem_3 = new JMenuItem("Excluir");

		separator = new JSeparator();

		mntmNewMenuItem_4 = new JMenuItem("Sair");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		mntmNewMenuItem_4.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.SHIFT_DOWN_MASK));

		mnNewMenu_1 = new JMenu("Notas e Faltas");

		mntmNewMenuItem_6 = new JMenuItem("Salvar");

		mntmNewMenuItem_7 = new JMenuItem("Alterar");

		mntmNewMenuItem_9 = new JMenuItem("Consultar");

		mntmNewMenuItem_8 = new JMenuItem("Excluir ");

		mnNewMenu_2 = new JMenu("Ajuda");

		mntmNewMenuItem_5 = new JMenuItem("Sobre");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Informações do Menu");
			}
		});

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setBackground(Color.lightGray);
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		// --------------- Painel Dados Pessoais --------------------

		JPanel panel_Dados_Pessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, panel_Dados_Pessoais, null);
		panel_Dados_Pessoais.setLayout(null);

		// FVG 02/05 - Toda definição de campos como labels, campos de texto e botões

		// -------------- Labels -------------------



		// --------------- Botões -------------------


		// --------------- Eventos nos botões -------------


		JComboBox comboBoxUf = new JComboBox();
		comboBoxUf.setModel(new DefaultComboBoxModel(new String[] { "SP" }));
		comboBoxUf.setBounds(333, 100, 91, 22);



		// ------------ Campos de Texto ----------------



		// -------------------------------------------------------------

		panel_Curso = new JPanel();
		tabbedPane.addTab("Curso", null, panel_Curso, null);
		GridBagLayout gbl_panel_Curso = new GridBagLayout();
		gbl_panel_Curso.columnWidths = new int[] { 41, 67, 77, 67, 0 };
		gbl_panel_Curso.rowHeights = new int[] { 27, 22, 23, 0 };
		gbl_panel_Curso.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_Curso.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_Curso.setLayout(gbl_panel_Curso);

		comboBoxCurso = new JComboBox();
		comboBoxCurso.setModel(new DefaultComboBoxModel(new String[] { "Analise e Desenvolvimento de Sistemas" }));
		GridBagConstraints gbc_comboBoxCurso = new GridBagConstraints();
		gbc_comboBoxCurso.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCurso.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCurso.gridwidth = 3;
		gbc_comboBoxCurso.gridx = 1;
		gbc_comboBoxCurso.gridy = 0;

		comboBoxCampus = new JComboBox();
		comboBoxCampus.setModel(new DefaultComboBoxModel(new String[] { "Tatuapé" }));
		GridBagConstraints gbc_comboBoxCampus = new GridBagConstraints();
		gbc_comboBoxCampus.anchor = GridBagConstraints.NORTH;
		gbc_comboBoxCampus.fill = GridBagConstraints.HORIZONTAL;
		gbc_comboBoxCampus.insets = new Insets(0, 0, 5, 0);
		gbc_comboBoxCampus.gridwidth = 3;
		gbc_comboBoxCampus.gridx = 1;
		gbc_comboBoxCampus.gridy = 1;


		JRadioButton rdbtnNewRadioButton = new JRadioButton("Matutino");
		GridBagConstraints gbc_rdbtnNewRadioButton = new GridBagConstraints();
		gbc_rdbtnNewRadioButton.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton.gridx = 1;
		gbc_rdbtnNewRadioButton.gridy = 2;

		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("Vespertino");
		GridBagConstraints gbc_rdbtnNewRadioButton_1 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_1.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnNewRadioButton_1.insets = new Insets(0, 0, 0, 5);
		gbc_rdbtnNewRadioButton_1.gridx = 2;
		gbc_rdbtnNewRadioButton_1.gridy = 2;

		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("Noturno");
		GridBagConstraints gbc_rdbtnNewRadioButton_2 = new GridBagConstraints();
		gbc_rdbtnNewRadioButton_2.anchor = GridBagConstraints.NORTH;
		gbc_rdbtnNewRadioButton_2.fill = GridBagConstraints.HORIZONTAL;
		gbc_rdbtnNewRadioButton_2.gridx = 3;
		gbc_rdbtnNewRadioButton_2.gridy = 2;

		panel_Notas_E_Faltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, panel_Notas_E_Faltas, null);

		panel_Boletim = new JPanel();
		tabbedPane.addTab("Boletim", null, panel_Boletim, null);
		panel_Notas_E_Faltas.setLayout(null);

		comboBoxDisciplina = new JComboBox();
		comboBoxDisciplina.setModel(
				new DefaultComboBoxModel(new String[] { "Programação Orientada a Obetos", "Estrutura de Dados " }));
		comboBoxDisciplina.setBounds(66, 70, 309, 22);

		lblNewLabel_3 = new JLabel("Disciplina");
		lblNewLabel_3.setBounds(10, 74, 46, 14);

		lblNewLabel_4 = new JLabel("Semestre");
		lblNewLabel_4.setBounds(10, 115, 46, 14);

		comboBox_4 = new JComboBox();
		comboBox_4.setModel(new DefaultComboBoxModel(new String[] { "2023 - 1", "2023 - 2" }));
		comboBox_4.setBounds(66, 111, 77, 22);

		lblNewLabel_5 = new JLabel("Nota");
		lblNewLabel_5.setBounds(167, 115, 46, 14);

		comboBox_5 = new JComboBox();
		comboBox_5.setModel(new DefaultComboBoxModel(new String[] { "0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0",
				"3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10" }));
		comboBox_5.setBounds(212, 111, 51, 22);

		lblNewLabel_6 = new JLabel("Faltas");
		lblNewLabel_6.setBounds(273, 115, 46, 14);
		
		
		
		
		
		
		
		

	    //---------------JLabel-----------------------
        //Painel Dados Pessoasi
 		labelRgmNotas = new JLabel("RGM");
 		labelRgmNotas.setBounds(10, 8, 28, 14);
 		
 		//Labels
 		labelRgm = new JLabel("RGM");
        labelRgm.setBounds(0, 3, 27, 14);
        labelNome = new JLabel("Nome");
        labelNome.setBounds(339, 3, 42, 14);
        labelDtNascimento = new JLabel("Data de nascimento");
        labelDtNascimento.setBounds(0, 28, 125, 14);
        labelCpf = new JLabel("CPF");
        labelCpf.setBounds(339, 28, 27, 14);
        labelEmail = new JLabel("E-mail");
        labelEmail.setBounds(0, 53, 40, 14);
        labelEndereco = new JLabel("Endereço");
        labelEndereco.setBounds(0, 78, 54, 14);
        labelMunicipio = new JLabel("Município");
        labelMunicipio.setBounds(0, 104, 54, 14);
        labelUf = new JLabel("UF");
        labelUf.setBounds(306, 104, 22, 14);
        labelCelular = new JLabel("Celular");
        labelCelular.setBounds(445, 104, 42, 14);
        
        //JX
        lblNewLabel = new JLabel("Curso");
        GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
        gbc_lblNewLabel.anchor = GridBagConstraints.WEST;
        gbc_lblNewLabel.fill = GridBagConstraints.VERTICAL;
        gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel.gridx = 0;
        gbc_lblNewLabel.gridy = 0;

        lblNewLabel_1 = new JLabel("Campus");
        GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
        gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
        gbc_lblNewLabel_1.gridx = 0;
        gbc_lblNewLabel_1.gridy = 1;

        lblNewLabel_2 = new JLabel("Período");
        GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
        gbc_lblNewLabel_2.fill = GridBagConstraints.HORIZONTAL;
        gbc_lblNewLabel_2.insets = new Insets(0, 0, 0, 5);
        gbc_lblNewLabel_2.gridx = 0;
        gbc_lblNewLabel_2.gridy = 2;

        lblNewLabel_3 = new JLabel("Disciplina");
        lblNewLabel_3.setBounds(10, 74, 46, 14);

        lblNewLabel_4 = new JLabel("Semestre");
        lblNewLabel_4.setBounds(10, 115, 46, 14);

        lblNewLabel_5 = new JLabel("Nota");
        lblNewLabel_5.setBounds(167, 115, 46, 14);

        lblNewLabel_6 = new JLabel("Faltas");
        lblNewLabel_6.setBounds(273, 115, 46, 14);
        
        
		
		
      //---------------JText-----------------------
        
        
        //Labels
        txtRgm = new JFormattedTextField(new MaskFormatter("####################"));
  		txtRgm.setBounds(60, 0, 193, 20);

  		txtNome = new JFormattedTextField(new MaskFormatter("########################################"));
  		txtNome.setBounds(376, 0, 320, 20);
  		txtDtNascimento = new JFormattedTextField(new MaskFormatter("##/##/####"));
  		txtDtNascimento.setBounds(135, 25, 118, 20);

  		txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
  		txtCpf.setBounds(363, 25, 333, 20);
        txtEndereco = new JFormattedTextField(new MaskFormatter("########################################"));
  		txtEndereco.setBounds(60, 75, 636, 20);
  		
  		txtEmail = new JFormattedTextField(new MaskFormatter("########################################"));
		txtEmail.setBounds(60, 50, 636, 20);

  		txtMunicipio = new JFormattedTextField(new MaskFormatter("####################"));
  		txtMunicipio.setBounds(60, 101, 166, 20);

          //Evento nos botoes
        txtCelular = new JFormattedTextField(new MaskFormatter("(##)#####-####"));
  		txtCelular.setBounds(497, 100, 199, 20);

          //Campo de texto
        txtRgmNotasFaltas = new JTextField();
  		txtRgmNotasFaltas.setBounds(48, 5, 327, 20);

          //JX
        textField = new JTextField();
  		textField.setBounds(318, 112, 57, 20);
  		textField.setColumns(10);

        nomeNotasFaltas = new JTextField();
  		nomeNotasFaltas.setBounds(385, 5, 327, 20);
  		nomeNotasFaltas.setColumns(10);

  		cursoNotasFaltas = new JTextField();
  		cursoNotasFaltas.setBounds(10, 33, 365, 20);
  		cursoNotasFaltas.setColumns(10);
  		
  		
        //---------------Button-----------------------     
        
       btSair = new JButton("");
		btSair.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/sair.png")));
		btSair.setBounds(601, 147, 95, 54);

		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});
		
		btSair = new JButton("");
		btSair.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/sair.png")));
		btSair.setBounds(601, 147, 95, 54);

		btSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Aplicação será fechada!");
				System.exit(0);
			}
		});    

		btLimpar = new JButton("");
		btLimpar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/limpar.png")));
		btLimpar.setBounds(496, 147, 95, 54);
		
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// FVG 02/05 - Evento para limpar todos os dados da tela
				txtNome.setText(null);
				txtEmail.setText(null);
				txtDtNascimento.setValue(null);
				txtRgm.setText(null);
				txtMunicipio.setText(null);
				txtCelular.setText(null);
				txtCpf.setValue(null);
				// txtIdade.setText(null);
				txtEndereco.setText(null);
			}
		});		

		btSalvar = new JButton("");
		btSalvar.setBounds(76, 147, 95, 54);
		btSalvar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/adicionar.png")));

		btSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aluno aluno = new Aluno();
				aluno.setRgm(txtRgm.getText());
				aluno.setCpf(txtCpf.getText());
				aluno.setNome(txtNome.getText());
				aluno.setEmail(txtEmail.getText());
				aluno.setCelular(txtCelular.getText());
				aluno.setEndereco(txtEndereco.getText());
				aluno.setDtNascimento(txtDtNascimento.getText());
				aluno.setUf(comboBoxUf.getSelectedItem().toString());
				aluno.setMunicipio(txtMunicipio.getText());
				try {
					AlunoDAO dao = new AlunoDAO();
					dao.salvar(aluno);
					JOptionPane.showMessageDialog(null, "Dados Pessoais aluno: Salvo!");
				} catch (Exception f) {
					JOptionPane.showMessageDialog(null, f);

				}
			}
		});

		btAlterar = new JButton("");
		btAlterar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/editar.png")));
		btAlterar.setBounds(286, 147, 95, 54);

		btAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});

		btConsultar = new JButton("");
		btConsultar.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/consultar.png")));
		btConsultar.setBounds(181, 147, 95, 54);

		btConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno alunoRgm = new Aluno();
					alunoRgm.setRgm(txtRgm.getText());
					AlunoDAO dao = new AlunoDAO();
					Aluno aluno = dao.consultar(alunoRgm);
					// preencher a tela
					if (aluno == null) {
						JOptionPane.showMessageDialog(null, "Aluno não encontrado");
					}
					txtNome.setText(aluno.getNome());
					txtDtNascimento.setText(aluno.getDtNascimento());
					txtCpf.setText(aluno.getCpf());
					txtEmail.setText(aluno.getEmail());
					txtEndereco.setText(aluno.getEndereco());
				} catch (Exception e2) {
					JOptionPane.showMessageDialog(null, "consulta" + e2);
				}
			}
		});

		btExcluir = new JButton("");
		btExcluir.setIcon(new ImageIcon(Tela.class.getResource("/view/imgs/excluir.png")));
		btExcluir.setBounds(391, 147, 95, 54);

		btExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
  		
        
        //---------------add.-----------------------
			//Painel de Aplicação
			 menuBar.add(mnNewMenu);
			 mnNewMenu.add(mntmNewMenuItem);
	         mnNewMenu.add(mntmNewMenuItem_1);
	         mnNewMenu.add(mntmNewMenuItem_2);
	         mnNewMenu.add(mntmNewMenuItem_3);
	         mnNewMenu.add(separator);
	         mnNewMenu.add(mntmNewMenuItem_4);
	         menuBar.add(mnNewMenu_1);
	         mnNewMenu_1.add(mntmNewMenuItem_6);
	         mnNewMenu_1.add(mntmNewMenuItem_7);
	         mnNewMenu_1.add(mntmNewMenuItem_9);
	         mnNewMenu_1.add(mntmNewMenuItem_8);
	         menuBar.add(mnNewMenu_2);
	         mnNewMenu_2.add(mntmNewMenuItem_5);
	         contentPane.add(tabbedPane);
	        //Labels
	         panel_Dados_Pessoais.add(labelRgm);
             panel_Dados_Pessoais.add(txtRgm);
             panel_Dados_Pessoais.add(labelNome);
             panel_Dados_Pessoais.add(txtNome);
             panel_Dados_Pessoais.add(labelDtNascimento);
             panel_Dados_Pessoais.add(txtDtNascimento);
             panel_Dados_Pessoais.add(labelCpf);
             panel_Dados_Pessoais.add(txtCpf);
             panel_Dados_Pessoais.add(labelEmail);
             panel_Dados_Pessoais.add(txtEmail);
             panel_Dados_Pessoais.add(labelEndereco);
             panel_Dados_Pessoais.add(txtEndereco);
             panel_Dados_Pessoais.add(labelMunicipio);
             panel_Dados_Pessoais.add(txtMunicipio);
             panel_Dados_Pessoais.add(labelUf);
            //Evento nos Botão
             panel_Dados_Pessoais.add(comboBoxUf);
             panel_Dados_Pessoais.add(labelCelular);
             panel_Dados_Pessoais.add(txtCelular);
             panel_Dados_Pessoais.add(btSalvar);
             panel_Dados_Pessoais.add(btConsultar);
             panel_Dados_Pessoais.add(btAlterar);
             panel_Dados_Pessoais.add(btExcluir);
             panel_Dados_Pessoais.add(btLimpar);
             panel_Dados_Pessoais.add(btSair);
            //JX 
             panel_Curso.add(lblNewLabel, gbc_lblNewLabel);
             panel_Curso.add(comboBoxCurso, gbc_comboBoxCurso);
             panel_Curso.add(lblNewLabel_1, gbc_lblNewLabel_1);
             panel_Curso.add(comboBoxCampus, gbc_comboBoxCampus);
             panel_Curso.add(lblNewLabel_2, gbc_lblNewLabel_2);
             panel_Curso.add(rdbtnNewRadioButton, gbc_rdbtnNewRadioButton);
             panel_Curso.add(rdbtnNewRadioButton_1, gbc_rdbtnNewRadioButton_1);
             panel_Curso.add(rdbtnNewRadioButton_2, gbc_rdbtnNewRadioButton_2);
             panel_Notas_E_Faltas.add(labelRgmNotas);
             panel_Notas_E_Faltas.add(txtRgmNotasFaltas);
             panel_Notas_E_Faltas.add(comboBoxDisciplina);
             panel_Notas_E_Faltas.add(lblNewLabel_3);
             panel_Notas_E_Faltas.add(lblNewLabel_4);
             panel_Notas_E_Faltas.add(comboBox_4);
             panel_Notas_E_Faltas.add(lblNewLabel_5);
             panel_Notas_E_Faltas.add(comboBox_5);
             panel_Notas_E_Faltas.add(lblNewLabel_6);
             panel_Notas_E_Faltas.add(textField);
             panel_Notas_E_Faltas.add(nomeNotasFaltas);
             panel_Notas_E_Faltas.add(cursoNotasFaltas);
    		
	}
}
