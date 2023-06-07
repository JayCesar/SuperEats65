package cadastro;

import java.util.Scanner;

	public class CadastroFuncionario {

		private String nome;
		private String CPF;
		private String email;
		private String pis;
		private int telefone;
		private int dataDeNascimento;
		private int contratacao;
		private int cracha;

		public static void main(String[] args) {
			Scanner ler = new Scanner(System.in);

			CadastroFuncionario cadastro = new CadastroFuncionario();

			System.out.println("\tBem vindo ao seu cadastro!!");
			System.out.println("\n\tDigite o seu Nome Completo: ");
			cadastro.setNome(ler.next());
			System.out.println("\n\tDigite o seu CPF: ");
			cadastro.setCPF(ler.next());
			System.out.println("\n\tDigite o seu E-mail: ");
			cadastro.setEmail(ler.next());
			System.out.println("\n\tDigite o seu PIS/PASEP: ");
			cadastro.setPis(ler.next());
			System.out.println("\n\tDigite o seu telefone: ");
			cadastro.setTelefone(ler.nextInt());
			System.out.println("\n\tDigite o sua Data de Nascimento: ");
			cadastro.setDataDeNascimento(ler.nextInt());
			System.out.println("\n\tDigite a Data de Contratação: ");
			cadastro.setContratacao(ler.nextInt());
			System.out.println("\n\tDigite o Numero da Sua identificação: ");
			cadastro.setCracha(ler.nextInt());

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
