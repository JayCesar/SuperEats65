package cadastro;

import java.util.Scanner;

public class CadastroCliente {

	private String nome;
	private String CPF;
	private String email;
	private String endereco;
	private String CEP;
	private int telefone;
	private int dataDeNascimento;

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		CadastroCliente cadastro = new CadastroCliente();

		System.out.println("\tBem vindo ao seu cadastro!!");
		System.out.println("\n\tDigite o seu Nome Completo: ");
		cadastro.setNome(ler.next());
		System.out.println("\n\tDigite o seu CPF: ");
		cadastro.setCPF(ler.next());
		System.out.println("\n\tDigite o seu E-mail: ");
		cadastro.setEmail(ler.next());
		System.out.println("\n\tDigite o seu Endereço: ");
		cadastro.setEndereco(ler.next());
		System.out.println("\n\tDigite o seu CEP: ");
		cadastro.setCEP(ler.next());
		System.out.println("\n\tDigite o seu telefone: ");
		cadastro.setTelefone(ler.nextInt());
		System.out.println("\n\tDigite o sua Data de Nascimento: ");
		cadastro.setDataDeNascimento(ler.nextInt());

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

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCEP() {
		return CEP;
	}

	public void setCEP(String CEP) {
		this.CEP = CEP;
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
	}
