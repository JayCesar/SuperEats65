package entidades;

import java.time.LocalDate;

public class Funcionario extends Pessoa {
	
    // Falta Herdar da clsse pessoa
	// Adicionar somente os seguintes atributos: cargo, salario, dataContratacao do tipo LocalDate
	private String nome;
	private String CPF;
	private String email;
	private String pis;
	private int telefone;
	private LocalDate dataDeNascimento;
	private int contratacao;
	private int cracha;
	
	public Funcionario(String nome, String cPF, String email, String pis, int telefone, LocalDate dataDeNascimento,
			int contratacao, int cracha) {
		super();
		this.nome = nome;
		CPF = cPF;
		this.email = email;
		this.pis = pis;
		this.telefone = telefone;
		this.dataDeNascimento = dataDeNascimento;
		this.contratacao = contratacao;
		this.cracha = cracha;
	}

	// getters e setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCPF() {
		return CPF;
	}

	public void setCPF(String CPF) {
		this.CPF = CPF;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPis() {
		return pis;
	}

	public void setPis(String pis) {
		this.pis = pis;
	}

	public int getTelefone() {
		return telefone;
	}

	public void setTelefone(int telefone) {
		this.telefone = telefone;
	}

	public LocalDate getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(LocalDate dataDeNascimento) {
		this.dataDeNascimento = dataDeNascimento;
	}

	public int getContratacao() {
		return contratacao;
	}

	public void setContratacao(int contratacao) {
		this.contratacao = contratacao;
	}

	public int getCracha() {
		return cracha;
	}

	public void setCracha(int cracha) {
		this.cracha = cracha;
	}
}
