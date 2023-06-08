package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		

		System.out.println("Digite o seu nome: ");
		String nome = ler.nextLine();
		System.out.println("Digite o seu E-mail: ");
		String email = ler.nextLine();
		System.out.println("Digite sua data nascimento (dd/mm/yyyy): ");
		String dataDeNascimento = ler.nextLine();
		System.out.println("Cria uma senha de 8 caracteres: ");
		String senha = ler.nextLine();
		System.out.println("Digite seu CPF: ");
		String cpf = ler.nextLine();
		System.out.println("Digite seu telefone ");
		String telefone = ler.nextLine();
		LocalDate DataCadastro = LocalDate.now();
		
		Cliente cliente00 = new Cliente(1, nome, email, LocalDate.parse(dataDeNascimento, fmt), senha, cpf, telefone, DataCadastro);
		
		Pedido pedido = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente00);
		
		for (int i = 0; i <= 50; i++) System.out.print("*");
			System.out.println("\n");
			System.out.println("\tLANCHES: \n");
			System.out.println("\t1 - Hotdog do Júlio: R$ 15.00 ");
			System.out.println("\t2 - Hamburguer Apolinário: R$ 47.00");
			System.out.println("\t4 - Batata frita da Cintia: R$ 14.00");
			System.out.println("\n\tBEBIDAS: \n");
			System.out.println("\t1 - Refrigerante: R$ 10.00");
			System.out.println("\t2 - Suco natural: R$ 8.00");
			System.out.println("\t4 - Água com gás: R$ 6.00");
			System.out.println("\t5 - Água sem gás: R$ 4.00");
			System.out.println("\n\tSOBREMESAS: \n");
			System.out.println("\t1 - Pudim: R$ 15.00");
			System.out.println("\t2 - Pedaço de Bolo: R$ 10.00");
			System.out.println("\t4 - Sorvete: R$ 20.00");
			System.out.println("");
		for (int i = 0; i <= 50; i++) System.out.print("*");
		
		System.out.println("\n" + cliente00.getNome() + ", O quê você deseja comprar? \n");
		/*int nItems = ler.nextInt();

		for (int i = 1; i <= nItems; i++) {
			System.out.println("Digite os dados do produto #" + i + ": ");
			System.out.print("Nome: ");
			ler.nextLine();
			String produtoNome = ler.nextLine();
			System.out.print("Preço do produto: ");
			double produtoPreco = ler.nextDouble();
			System.out.print("Breve descrição: ");
			ler.nextLine();
			String breveDescrição = ler.nextLine();
			System.out.print("Tipo: ");
			String tipo = ler.nextLine();

			Produto produto1 = new Produto(i, produtoNome, breveDescrição, produtoPreco, tipo);

			System.out.print("Quantidade: ");
			int quantidade = ler.nextInt();

			ItemPedido itemPedido = new ItemPedido(quantidade, produto1);

			pedido.adicionarItem(itemPedido);
		}*/
		
		/*Cliente cliente = new Cliente(
				2, // ID
				"Júlio", // Nome
				"batistajulio@gmail.com", // Email
				LocalDate.parse("10/03/2000", fmt), // Data de nascimento
				"123456", // Senha
				"4532214478-9", // CPF
				"2456879", // Telefone
				LocalDate.parse("10/03/2023", fmt)); // Data de cadastro
		
		Produto produto = new Produto(2, "ProdutoX", "É bom", 20.0);
		
		ItemPedido itemPedido = new ItemPedido(1, produto, "bebida");
	
		Pedido pedido = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
	
		System.out.println("Item pedido (com imposto): " + itemPedido.getPreco()); // Com imposto
		System.out.println("Produto (sem imposto): " + produto.getPreco()); // Sem imposto*/
		
		

		
		
		/*System.out.println("Bem vindo ao seu cadastro!!");
		System.out.println("Digite o seu nome: ");
		String nome = ler.nextLine();
		System.out.println("Digite o seu E-mail: ");
		String email = ler.nextLine();
		System.out.println("Digite sua data nascimento (dd/mm/yyyy): ");
		String dataDeNascimento = ler.nextLine();
		System.out.println("Cria uma senha de 8 caracteres: ");
		String senha = ler.nextLine();
		System.out.println("Digite seu CPF: ");
		String cpf = ler.nextLine();
		System.out.println("Digite seu telefone ");
		String telefone = ler.nextLine();
		LocalDate DataCadastro = LocalDate.now();

		Cliente cliente1 = new Cliente(1, nome, email, LocalDate.parse(dataDeNascimento, fmt), senha, cpf, telefone,
				DataCadastro);

		Pedido pedido = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente1);*/

		/*System.out.print("Quantos produtos você deseja? ");
		int nItems = ler.nextInt();*/

		/*for (int i = 1; i <= nItems; i++) {
			System.out.println("Digite os dados do produto #" + i + ": ");
			System.out.print("Nome: ");
			ler.nextLine();
			String produtoNome = ler.nextLine();
			System.out.print("Preço do produto: ");
			double produtoPreco = ler.nextDouble();
			System.out.print("Breve descrição: ");
			ler.nextLine();
			String breveDescrição = ler.nextLine();
			System.out.print("Tipo: ");
			String tipo = ler.nextLine();

			Produto produto1 = new Produto(i, produtoNome, breveDescrição, produtoPreco, tipo);

			System.out.print("Quantidade: ");
			int quantidade = ler.nextInt();

			ItemPedido itemPedido = new ItemPedido(quantidade, produto1);

			pedido.adicionarItem(itemPedido);
		}*/
		
	}

}





