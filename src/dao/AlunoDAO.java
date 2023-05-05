package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Aluno;
import connection.SqlConnection;

public class AlunoDAO {
	// conectar com o BD
		private Connection conn;
		// para rodar SQL
		private PreparedStatement ps;
		// tabela
		ResultSet rs;
		Aluno aluno;

		public AlunoDAO() throws Exception {
			// chama a classe ConnectionFactory e 
			//estabele uma conexão
			try {
				this.conn = SqlConnection.getConnection();
			} catch (Exception e) {
				throw new Exception("erro: \n" + e.getMessage());
			}
		}

		// método de salvar

		public void salvar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO aluno (rgm, "
						+ "nome, datanascimento, cpf, email,"
						+ "endereco, municipio, uf, celular, curso, campus, periodo, disciplina, semestre, nota, faltas) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getRgm());
				ps.setString(2, aluno.getNome());
				ps.setString(3, aluno.getDtNascimento());
				ps.setString(4, aluno.getCpf());
				ps.setString(5, aluno.getEmail());
				ps.setString(6, aluno.getEndereco());
				ps.setString(7, aluno.getMunicipio());
				ps.setString(8, aluno.getUf());
				ps.setString(9, aluno.getCelular());
				ps.setString(10, "");
				ps.setString(11, "");
				ps.setString(12, "");
				ps.setString(13, "");
				ps.setString(14, "");
				ps.setString(15, "");
				ps.setString(16, "");
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		// atualizar
		public void atualizar(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE tbAluno SET nome=?"
						+ ", email=?, datanascimento=?, "
						+ "idade=?,endereco=? WHERE rgm=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getNome());
				ps.setString(2, aluno.getEmail());
				ps.setString(3, aluno.getDtNascimento());
				ps.setString(4, aluno.getNome());
				ps.setString(5, aluno.getEndereco());
				ps.setString(6, aluno.getRgm());
				ps.setString(7, aluno.getCelular());
				ps.setString(8, aluno.getCpf());
				ps.setString(9, aluno.getMunicipio());
				ps.setString(10, aluno.getUf());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		// Excluir
		public void excluir(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "DELETE FROM tbAluno WHERE rgm=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getRgm());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}

		// Consultar
		public Aluno consultar(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				
				String SQL = "SELECT * FROM aluno WHERE rgm=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf);
				}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}

}
