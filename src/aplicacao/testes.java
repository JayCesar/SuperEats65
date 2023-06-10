package aplicacao;

import java.time.LocalDate;

import entidades.Funcionario;
import entidades.ItemPedido;
import entidades.Produto;

public class testes {

	public static void main(String[] args) {

		
		while(controle != null) {
			switch(controle) {
			case "pedido":
				System.out.println("\n\tÉ necessário fazer o cadastro antes do pedido: \n");
				mostraTelaCliente(controle, pedidos);
				controle = menuInicial(ler);
			case "funcionario":
				System.out.println("Tela do funcionário");
				controle = null;
				break;
			default:
				controle = null;
			}
		}
		
		/*Produto produto1 = new Produto("ProdutoX", 20.0);
		ItemPedido itemPedido1 = new ItemPedido(2, produto1, "lanche");
		Pedido pedido1 = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
		pedido1.adicionarItem(itemPedido1);
		pedidos.add(pedido1);*/
		
		//while(menuEscolha) {
		switch (escolha) {
		case "l1":
			adicionarOpcao(pedidos, pedido, quantidade, itemPedido, produto, "l1");
			System.out.println("Deseja continuar adicionando items ao pedido? ");
			char resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
			} else if (resposta == 's') {
				
			}
			break;
		default:
			System.out.println("a");
			break;
		}
	//}
		
		
		// fluxo
				/*Cliente cliente = new Cliente(2, "Julio", "julio@gmail.com", LocalDate.parse("10/03/2000", fmt), "2222");

				Produto produto1 = new Produto("ProdutoX", 20.0);

				ItemPedido itemPedido1 = new ItemPedido(2, produto1, "lanche");

				Pedido pedido1 = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
				pedido1.adicionarItem(itemPedido1);
				pedidos.add(pedido1);

				System.out.println("Item pedido (com imposto): " + itemPedido1.getPreco());
				System.out.println("Produto (sem imposto): " + produto1.getPreco());
				System.out.println("Pedido total: " + pedido1.total());*/

				// Instanciação dos funcionários
				Funcionario apolinario = new Funcionario(1, "Apolinário", "apolinario@gmail.com", LocalDate.parse("28/01/1998", fmt), "123456", 15000.00, "Estágiário", LocalDate.parse("15/05/2023", fmt));
				Funcionario maria = new Funcionario(2, "Maria", "maria@gmail.com", LocalDate.parse("17/05/1999", fmt), "123456", 15000.00, "Estágiário", LocalDate.parse("15/05/2023", fmt));
		
		
		/*case "l2":
		System.out.println("Hamburguer Apolinário - R$ 47.00");
		System.out.print("Quantidade? ");
		quantidade = ler.nextInt();
		produto = new Produto("Hamburguer Apolinário", 47.00);
		itemPedido = new ItemPedido(quantidade, produto, "lanche");
		pedido.adicionarItem(itemPedido);
		pedidos.add(pedido);
		break;*/
		
		/*for (Pedido p : pedidos) {
			System.out.println(p);
		}*/
		
		/*
		 * public ItemPedido(Integer quantidade, Produto produto) { this.quantidade =
		 * quantidade; this.preco = produto.getPreco(); this.produto = produto; }
		 */

		/*
		 * System.out.println("1 - Fazer pedido?");
		 * System.out.println("2 - Entrar como funcionário");
		 */

		/*
		 * enrar como como funcionario? acesso aos pedidos e finalizar os pedidos
		 * 
		 * fazer pedido? colocar dos dados de cliente e fazer o pedido (efetuar o
		 * pagamento)
		 */

		/*
		 * System.out.println("Cadastro do cliente");
		 * 
		 * System.out.println("2 - Entrar como funcionário");
		 * 
		 * System.out.println("Pedido1, pedido2");
		 */

		/*
		 * System.out.println("Digite o seu nome: "); String nome = ler.nextLine();
		 * System.out.println("Digite o seu E-mail: "); String email = ler.nextLine();
		 * System.out.println("Digite sua data nascimento (dd/mm/yyyy): "); String
		 * dataDeNascimento = ler.nextLine();
		 * System.out.println("Cria uma senha de 8 caracteres: "); String senha =
		 * ler.nextLine(); System.out.println("Digite seu CPF: "); String cpf =
		 * ler.nextLine(); System.out.println("Digite seu telefone "); String telefone =
		 * ler.nextLine(); LocalDate DataCadastro = LocalDate.now();
		 * 
		 * Cliente cliente00 = new Cliente(1, nome, email,
		 * LocalDate.parse(dataDeNascimento, fmt), senha, cpf, telefone, DataCadastro);
		 * 
		 * Pedido pedido = new Pedido(LocalDate.now(),
		 * StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente00);
		 */

		/*
		 * for (int i = 0; i <= 50; i++) System.out.print("*");
		 * System.out.println("\n"); System.out.println("\t(L) LANCHES: \n");
		 * System.out.println("\t1 - Hotdog do Júlio: R$ 15.00 ");
		 * System.out.println("\t2 - Hamburguer Apolinário: R$ 47.00");
		 * System.out.println("\t3 - Batata frita da Cintia: R$ 14.00");
		 * System.out.println("\n\t(B) BEBIDAS: \n");
		 * System.out.println("\t1 - Refrigerante: R$ 10.00");
		 * System.out.println("\t2 - Suco natural: R$ 8.00");
		 * System.out.println("\t3 - Água com gás: R$ 6.00");
		 * System.out.println("\t4 - Água sem gás: R$ 4.00");
		 * System.out.println("\n\t(S) SOBREMESAS: \n");
		 * System.out.println("\t1 - Pudim: R$ 15.00");
		 * System.out.println("\t2 - Pedaço de Bolo: R$ 10.00");
		 * System.out.println("\t3 - Sorvete: R$ 20.00"); System.out.println(""); for
		 * (int i = 0; i <= 50; i++) System.out.print("*");
		 * 
		 * System.out.println();
		 * 
		 * System.out.println("Digite 'L' para lanche");
		 * System.out.println("Digite 'B' para bebida");
		 * System.out.println("Digite 'S' para sobremesa");
		 * 
		 * System.out.println("\n" + "Pessoa" + ", O quê você deseja comprar? "); char
		 * resposta = ler.next().charAt(0);
		 * 
		 * switch (resposta) {
		 * 
		 * }
		 */

		/*
		 * int nItems = ler.nextInt();
		 * 
		 * for (int i = 1; i <= nItems; i++) {
		 * System.out.println("Digite os dados do produto #" + i + ": ");
		 * System.out.print("Nome: "); ler.nextLine(); String produtoNome =
		 * ler.nextLine(); System.out.print("Preço do produto: "); double produtoPreco =
		 * ler.nextDouble(); System.out.print("Breve descrição: "); ler.nextLine();
		 * String breveDescrição = ler.nextLine(); System.out.print("Tipo: "); String
		 * tipo = ler.nextLine();
		 * 
		 * Produto produto1 = new Produto(i, produtoNome, breveDescrição, produtoPreco,
		 * tipo);
		 * 
		 * System.out.print("Quantidade: "); int quantidade = ler.nextInt();
		 * 
		 * ItemPedido itemPedido = new ItemPedido(quantidade, produto1);
		 * 
		 * pedido.adicionarItem(itemPedido); }
		 */

		/*
		 * Cliente cliente = new Cliente( 2, // ID "Júlio", // Nome
		 * "batistajulio@gmail.com", // Email LocalDate.parse("10/03/2000", fmt), //
		 * Data de nascimento "123456", // Senha "4532214478-9", // CPF "2456879", //
		 * Telefone LocalDate.parse("10/03/2023", fmt)); // Data de cadastro
		 * 
		 * Produto produto = new Produto(2, "ProdutoX", "É bom", 20.0);
		 * 
		 * ItemPedido itemPedido = new ItemPedido(1, produto, "bebida");
		 * 
		 * Pedido pedido = new Pedido(LocalDate.now(),
		 * StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
		 * 
		 * System.out.println("Item pedido (com imposto): " + itemPedido.getPreco()); //
		 * Com imposto System.out.println("Produto (sem imposto): " +
		 * produto.getPreco()); // Sem imposto
		 */

		/*
		 * System.out.println("Bem vindo ao seu cadastro!!");
		 * System.out.println("Digite o seu nome: "); String nome = ler.nextLine();
		 * System.out.println("Digite o seu E-mail: "); String email = ler.nextLine();
		 * System.out.println("Digite sua data nascimento (dd/mm/yyyy): "); String
		 * dataDeNascimento = ler.nextLine();
		 * System.out.println("Cria uma senha de 8 caracteres: "); String senha =
		 * ler.nextLine(); System.out.println("Digite seu CPF: "); String cpf =
		 * ler.nextLine(); System.out.println("Digite seu telefone "); String telefone =
		 * ler.nextLine(); LocalDate DataCadastro = LocalDate.now();
		 * 
		 * Cliente cliente1 = new Cliente(1, nome, email,
		 * LocalDate.parse(dataDeNascimento, fmt), senha, cpf, telefone, DataCadastro);
		 * 
		 * Pedido pedido = new Pedido(LocalDate.now(),
		 * StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente1);
		 */

		/*
		 * System.out.print("Quantos produtos você deseja? "); int nItems =
		 * ler.nextInt();
		 */

		/*
		 * for (int i = 1; i <= nItems; i++) {
		 * System.out.println("Digite os dados do produto #" + i + ": ");
		 * System.out.print("Nome: "); ler.nextLine(); String produtoNome =
		 * ler.nextLine(); System.out.print("Preço do produto: "); double produtoPreco =
		 * ler.nextDouble(); System.out.print("Breve descrição: "); ler.nextLine();
		 * String breveDescrição = ler.nextLine(); System.out.print("Tipo: "); String
		 * tipo = ler.nextLine();
		 * 
		 * Produto produto1 = new Produto(i, produtoNome, breveDescrição, produtoPreco,
		 * tipo);
		 * 
		 * System.out.print("Quantidade: "); int quantidade = ler.nextInt();
		 * 
		 * ItemPedido itemPedido = new ItemPedido(quantidade, produto1);
		 * 
		 * pedido.adicionarItem(itemPedido); }
		 */


	}

}
