package model;

public class Aluno {
	private String rgm;
	private String email;
	private String endereco;
	private String municipio;
	private String uf;
	private String dtNascimento;
	private String nome;
	private String celular;
	private String cpf;
	
	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setRgm(String rgm) {
		this.rgm = rgm;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public void setMunicipio(String municipio) {
		this.municipio = municipio;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public void setDtNascimento(String dtNascimento) {
		this.dtNascimento = dtNascimento;
	}
	

	public void setCelular(String celular) {
		this.celular = celular;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	public Aluno(String nome, String rgm, String email, String endereco, String municipio, String uf, String dtNascimento, String celular, String cpf) {
		this.rgm = rgm;
		this.nome = nome;
		this.email = email;
		this.dtNascimento = dtNascimento;
		this.endereco = endereco;
		this.municipio = municipio;
		this.uf = uf;
		this.celular = celular;
		this.cpf = cpf;
	}
	
	public Aluno() {
		
	}
	
	public String getCelular() {
		return  celular;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getRgm() {
		return rgm;
	}
	
	public String getEmail() {
		return email;
	}
	public String getEndereco() {
		return endereco;
	}
	public String getMunicipio() {
		return municipio;
	}
	public String getUf() {
		return uf;
	}
	public String getDtNascimento() {
		return dtNascimento;
	}
}
