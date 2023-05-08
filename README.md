<h1>Projeto MCV</h1>

Este código corresponde à classe Tela, que representa a interface gráfica do usuário (GUI) para o sistema de cadastro de alunos. A classe herda da classe JFrame, o que permite criar janelas com recursos completos de interface gráfica.

A classe Tela contém os seguintes campos:

<ul>
<li>JPanel contentPane: o painel principal da janela.</li>
<li>JLabel labelRgm: um rótulo que indica que o campo txtRgm deve ser preenchido com o RGM do aluno.</li>
<li>JTextField txtRgm: um campo de texto que deve ser preenchido com o RGM do aluno.</li>
<li>JTextField txtRgm2: um campo de texto que é usado para a consulta do RGM do aluno.</li>
<li>JLabel labelRgmNotas: um rótulo que indica que o campo txtRgm1 deve ser preenchido com o RGM do aluno para consulta de notas e faltas.</li>
<li>JLabel labelNome: um rótulo que indica que o campo txtNome deve ser preenchido com o nome do aluno.</li>
<li>JTextField txtNome: um campo de texto que deve ser preenchido com o nome do aluno.</li>
<li>JLabel labelEmail: um rótulo que indica que o campo txtEmail deve ser preenchido com o e-mail do aluno.</li>
<li>JTextField txtEmail: um campo de texto que deve ser preenchido com o e-mail do aluno.</li>
<li>JLabel labelEndereco: um rótulo que indica que o campo txtEndereco deve ser preenchido com o endereço do aluno.</li>
<li>JTextField txtEndereco: um campo de texto que deve ser preenchido com o endereço do aluno.</li>
<li>JTextField txtMunicipio: um campo de texto que deve ser preenchido com o município do aluno.</li>
<li>JLabel labelMunicipio: um rótulo que indica que o campo txtMunicipio deve ser preenchido com o município do aluno.</li>
<li>JLabel labelUf: um rótulo que indica que o campo comboBoxUf deve ser preenchido com a UF (Unidade Federativa) do aluno.</li>
<li>JFormattedTextField txtDtNascimento: um campo de texto formatado que deve ser preenchido com a data de nascimento do aluno.</li>
<li>JLabel labelDtNascimento: um rótulo que indica que o campo txtDtNascimento deve ser preenchido com a data de nascimento do aluno.</li>
<li>JFormattedTextField txtCelular: um campo de texto formatado que deve ser preenchido com o número de celular do aluno.</li>
<li>JLabel labelCelular: um rótulo que indica que o campo txtCelular deve ser preenchido com o número de celular do aluno.</li>
<li>JFormattedTextField txtCpf: um campo de texto formatado que deve ser preenchido com o CPF do aluno.</li>
<li>JLabel labelCpf: um rótulo que indica que o campo txtCpf deve ser preenchido com o CPF do aluno.</li>
<li>JButton btLimpar: um botão que permite limpar os campos de texto da janela.</li>
<li>JButton btSalvar: um botão que permite salvar os dados do aluno na base de dados.</li>
<li>JButton btConsultar: um botão que permite consultar os dados do aluno na base de dados.</li>
<li>JButton btAlterar: um botão que permite alterar os dados do aluno na base de dados.</li>
<li>JButton btExcluir: um botão que permite excluir os dados do aluno na base de dados.</li>
<li>JButton btSair: um botão que permite sair do sistema.</li>
</ul>

O DAO contém métodos para salvar, atualizar, excluir e consultar alunos no banco de dados.

O código utiliza a classe SqlConnection para estabelecer a conexão com o banco de dados e a classe Aluno para representar os dados do aluno.

o Connection é uma interface que faz parte da API JDBC (Java Database Connectivity) e é usada para estabelecer uma conexão com um banco de dados. Ele fornece métodos para conectar e desconectar do banco de dados, além de permitir a execução de consultas SQL e a atualização de dados.

Ao usar o Connection em Java, você pode se conectar a diferentes tipos de bancos de dados, como MySQL, Oracle, SQL Server, PostgreSQL, entre outros. Através do Connection, você pode realizar operações de leitura e escrita de dados, bem como executar operações de gerenciamento de transações.

Classe AlunoDAO
Atributos
conn (Connection): representa a conexão com o banco de dados.
ps (PreparedStatement): objeto para executar instruções SQL no banco de dados.
ps2 (PreparedStatement): objeto para executar instruções SQL no banco de dados.
rs (ResultSet): representa o conjunto de resultados de uma consulta SQL.
aluno (Aluno): objeto da classe Aluno.
Construtor
AlunoDAO() throws Exception: construtor da classe, responsável por estabelecer uma conexão com o banco de dados. Lança uma exceção caso ocorra algum erro na conexão.
Métodos
public void salvar(Aluno aluno) throws Exception: método para salvar um aluno no banco de dados. Recebe um objeto da classe Aluno como parâmetro e utiliza o PreparedStatement para inserir os dados do aluno no banco. Também insere um registro na tabela curso e na tabela boletim para o aluno. Lança uma exceção caso ocorra algum erro na execução da operação.

public void atualizar(Aluno aluno) throws Exception: método para atualizar um aluno no banco de dados. Recebe um objeto da classe Aluno como parâmetro e utiliza o PreparedStatement para atualizar os dados do aluno no banco. Lança uma exceção caso ocorra algum erro na execução da operação.

public Aluno excluir(Aluno aluno) throws Exception: método para excluir um aluno do banco de dados. Recebe um objeto da classe Aluno como parâmetro e utiliza o PreparedStatement para excluir o registro correspondente no banco. Também remove os registros relacionados na tabela curso e na tabela boletim para o aluno. Retorna o objeto Aluno excluído. Lança uma exceção caso ocorra algum erro na execução da operação.

public Aluno consultar(Aluno a) throws Exception: método para consultar um aluno no banco de dados. Recebe um objeto da classe Aluno como parâmetro e utiliza o PreparedStatement para executar uma consulta SQL no banco de dados. Retorna um objeto Aluno com os dados do aluno encontrado. Lança uma exceção caso ocorra algum erro na execução da operação.

