package entidades;

public class Funcionario {
	
    // Falta Herdar da clsse pessoa
	// Adicionar somente os seguintes atributos: cargo, salario, dataContratacao do tipo LocalDate
	private String nome;
	private String CPF;
	private String email;
	private String pis;
	private int telefone;
	private int dataDeNascimento;
	private int contratacao;
	private int cracha;

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

	public int getDataDeNascimento() {
		return dataDeNascimento;
	}

	public void setDataDeNascimento(int dataDeNascimento) {
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
