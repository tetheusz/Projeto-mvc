package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import model.Aluno;
import connection.SqlConnection;

public class AlunoDAO {
	// conectar com o BD
		private Connection conn;
		// para rodar SQL
		private PreparedStatement ps;
		private PreparedStatement ps2;
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
						+ "endereco, municipio, uf, celular) values (?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
				ps.executeUpdate();
				
				String SQL2 = "INSERT INTO curso (rgm_aluno, curso, campus, periodo) values (?, ?, ?, ?)";
				ps2 = conn.prepareStatement(SQL2);
				ps2.setString(1, aluno.getRgm());
				ps2.setString(2, "");
				ps2.setString(3, "");
				ps2.setString(4, "");
				ps2.executeUpdate();
				
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
				String SQL = "UPDATE aluno SET nome = ?, datanascimento =?, cpf=?, email=?,"
						+ "endereco=?, municipio=?, uf=?, celular=?  WHERE rgm=?";
				ps = conn.prepareStatement(SQL);;				
				ps.setString(1, aluno.getNome());
				ps.setString(2, aluno.getDtNascimento());
				ps.setString(3, aluno.getCpf());
				ps.setString(4, aluno.getEmail());
				ps.setString(5, aluno.getEndereco());
				ps.setString(6, aluno.getMunicipio());
				ps.setString(7, aluno.getUf());
				ps.setString(8, aluno.getCelular());
				ps.setString(9, aluno.getRgm());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		// Excluir
		public Aluno excluir(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "DELETE FROM aluno WHERE rgm=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum aluno encontrado com o RGM informado");
		        }

			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}

		// Consultar
		public Aluno consultar(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {				
				String SQL = "SELECT * FROM aluno, curso WHERE rgm=?";
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
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo);
								}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		
		// Aba de cursos
		public void salvarCurso(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE curso SET campus = ?, curso = ?, periodo = ? WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getCampus());
				ps.setString(2, aluno.getCurso());
				ps.setString(3, aluno.getPeriodo());
				ps.setString(4, aluno.getRgm());
				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		
		public Aluno consultarCurso(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {				
				String SQL = "SELECT * FROM aluno,curso WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm_aluno");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");
					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo);
								}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		public Aluno excluirCurso(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "UPDATE curso SET campus = '', curso = '', periodo = '' WHERE rgm_aluno=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum curso encontrado para o aluno com o RGM informado");
		        }
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}
		
		public void salvarNotaSemestre1(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO semestre1 (rgm_aluno, curso, disciplina, nota, faltas) values (?,?,?,?,?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getRgm());				
				ps.setString(2, aluno.getCurso());
				ps.setString(3, aluno.getDisciplina());
				ps.setString(4, aluno.getNota());
				ps.setString(5, aluno.getFaltas());				
				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		public void salvarNotaSemestre2(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "INSERT INTO semestre2 (rgm_aluno, curso, disciplina, nota, faltas) values (?,?,?,?,?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, aluno.getRgm());				
				ps.setString(2, aluno.getCurso());
				ps.setString(3, aluno.getDisciplina());
				ps.setString(4, aluno.getNota());
				ps.setString(5, aluno.getFaltas());				
				ps.executeUpdate();
				
			} catch (SQLException sqle) {
				throw new Exception("Erro ao inserir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		public void atualizarSemestre1(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE semestre1 SET nota = ?, faltas =?	 WHERE rgm_aluno=? AND curso = ? AND disciplina =?";
				ps = conn.prepareStatement(SQL);;				
				ps.setString(1, aluno.getNota());
				ps.setString(2, aluno.getFaltas());
				ps.setString(3, aluno.getRgm());
				ps.setString(4, aluno.getCurso());
				ps.setString(5, aluno.getDisciplina());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		public void atualizarSemestre2(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "UPDATE semestre2 SET nota = ?, faltas =?	 WHERE rgm_aluno=? AND curso = ? AND disciplina =?";
				ps = conn.prepareStatement(SQL);;				
				ps.setString(1, aluno.getNota());
				ps.setString(2, aluno.getFaltas());
				ps.setString(3, aluno.getRgm());
				ps.setString(4, aluno.getCurso());
				ps.setString(5, aluno.getDisciplina());
				ps.executeUpdate();
			} catch (SQLException sqle) {
				throw new Exception("Erro ao atualizar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		public Aluno consultarNotaSemestre1(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "SELECT * FROM aluno,curso,semestre1 WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm_nota");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");

					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo);
					}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		public Aluno consultarNotaSemestre2(Aluno a) throws Exception {
			if (a == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
				String SQL = "SELECT * FROM aluno, curso, semestre2 WHERE rgm_aluno=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, a.getRgm());
				rs = ps.executeQuery();
				if(rs.next()) {
					String rgm = rs.getString("rgm_nota");
					String nome = rs.getString("nome");
					String email = rs.getString("email");
					String endereco = rs.getString("endereco");
					String municipio = rs.getString("municipio");
					String uf = rs.getString("uf");
					String dtNascimento = rs.getString("datanascimento");
					String celular = rs.getString("celular");
					String cpf = rs.getString("cpf");
					String curso = rs.getString("curso");
					String campus = rs.getString("campus");
					String periodo = rs.getString("periodo");

					aluno = new Aluno(nome,rgm,email,endereco,municipio,uf,dtNascimento,celular,cpf,curso,campus,periodo);
					}
				return aluno;
			} catch (SQLException sqle) {
				throw new Exception("Erro ao consultar dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
		}
		
		public Aluno excluirNotaSemestre1(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "DELETE FROM semestre1 WHERE rgm_aluno=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum curso encontrado para o aluno com o RGM informado");
		        }
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}
		
		public Aluno excluirNotaSemestre2(Aluno aluno) throws Exception {
			if (aluno == null)
				throw new Exception("O valor passado nao pode ser nulo");
			try {
		        String SQL = "DELETE FROM semestre2 WHERE rgm_aluno=?";
		        ps = conn.prepareStatement(SQL);
		        ps.setString(1, aluno.getRgm());
		        int rowsAffected = ps.executeUpdate();
		        if (rowsAffected == 0) {
		            throw new Exception("Nenhum curso encontrado para o aluno com o RGM informado");
		        }
			} catch (SQLException sqle) {
				throw new Exception("Erro ao excluir dados " + sqle);
			} finally {
				SqlConnection.closeConnection(conn, ps);
			}
			return aluno;
		}

}
