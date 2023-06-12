package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

import entidades.Cliente;
import entidades.Cores;
import entidades.Empresa;
import entidades.Entregador;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class UI {
	
	public static String menuInicial() {
		Scanner ler = new Scanner(System.in);
		System.out.println();
		System.out.println(Cores.TEXT_CYAN + "\t*********************************************************");
		System.out.println("\t\t\t1 - Fazer pedido");
		System.out.println("\t\t\t2 - Acessar tela de pedidos");
		System.out.println("\t\t\t3 - Acessar como empresa");
		System.out.println("\t\t\t4 - Acessar como entregador");
		System.out.println("\t\t\t5 - Finalizar programa");
		System.out.println("\t*********************************************************");
		System.out.print("\n\tEntre com a opcao desejada: " + Cores.TEXT_RESET);
		Integer input = ler.nextInt();
		while(input != 1 && input != 2 && input != 3 && input != 4 && input != 5) {
			System.out.print("\tDigite o numero corretamente: ");
			input = ler.nextInt();
		}
		if (input == 1) {
			return "pedido";
		}else if(input == 2){
			return "tela-de-pedidos";
		}else if(input == 3) {
			return "empresa";
		}else if(input == 4) {
			return "entregador";
		}else {
			return null;
		}
	}
	
	public static void mostraTelaCliente(String controle, Queue<Pedido> pedidos, Integer id) {
		Scanner ler = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		

		// Instanciacoes fazias
		int quantidade = 0;
		Produto produto = new Produto();
		ItemPedido itemPedido = new ItemPedido();

		System.out.print(Cores.TEXT_CYAN + "\tDigite o seu nome: " + Cores.TEXT_RESET);
		String nome = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite o seu E-mail: " + Cores.TEXT_RESET);
		String email = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite sua data nascimento (dd/mm/yyyy): " + Cores.TEXT_RESET);
		String dataDeNascimento = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tCrie uma senha de pedido: " + Cores.TEXT_RESET);
		String senha = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite seu CPF: " + Cores.TEXT_RESET);
		String cpf = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite o nome do seu bairro: " + Cores.TEXT_RESET);
		String bairro = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite o nome da sua rua: " + Cores.TEXT_RESET);
		String rua = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite seu CEP: " + Cores.TEXT_RESET);
		String cep = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\tDigite o numero da sua Casa/Apt: " + Cores.TEXT_RESET);
		String casaNumero = ler.nextLine();
		
		clearScreen();
		
		System.out.println(Cores.TEXT_YELLOW + "\n\tOla, " + nome + "! Seu cadastrado foi efetuado com sucesso!" + Cores.TEXT_RESET);
		
		id += 1;
		
		Cliente cliente = new Cliente(id, nome, email, LocalDate.parse(dataDeNascimento, fmt), senha, cpf, bairro, rua, cep, casaNumero);
		
		String empresa = selecionaEmpresa(ler);
		
		Pedido pedido = new Pedido(id, LocalDateTime.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente, empresa);

		boolean menuEscolha = true;
		String escolha;

		while (menuEscolha) {
			escolha = mostrarMenu(empresa);
			menuEscolha = validaEscolha(escolha, pedido, pedidos, quantidade, itemPedido, produto);
		}

		for (Pedido p : pedidos) {
			System.out.println(p);
		}

		System.out.println();

		// Pagamento
		Double troco = cliente.efetuarPagamento(pedido.total());

		System.out.println(Cores.TEXT_YELLOW + "\n\tPagamento realizado com sucesso!" + Cores.TEXT_RESET);
		pedido.setStatus(StatusPedido.valueOf("PAGO"));
		if (troco != null) {
			System.out.println("\tSeu troco: R$" + String.format("%.2f", troco));
		}
	}
	
	// Escolhe empresa
	public static String selecionaEmpresa(Scanner ler) {
		String empresa = null;
		System.out.println(Cores.TEXT_CYAN + "\n\t*********************************************************" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_YELLOW + "\n\tDe qual lanchonete voce gostaria de comprar: " + Cores.TEXT_RESET);
		System.out.println("\n\t"       + Cores.TEXT_WHITE + "1 - " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "Lanchonete da Gen" + Cores.TEXT_RESET);
		System.out.println("\n\t"       + Cores.TEXT_WHITE + "2 - " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "Lanchonete do Yuri" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_CYAN + "\n\t*********************************************************" + Cores.TEXT_RESET);
		System.out.print(Cores.TEXT_YELLOW + "\n\tEscolha uma opcao: "  + Cores.TEXT_RESET);
		Integer empresaSelecionada = ler.nextInt();
		
		while(empresaSelecionada != 1 && empresaSelecionada != 2) {
			System.out.print(Cores.TEXT_RED + "\tEscolha somente uma das opcoes: " + Cores.TEXT_RESET);
			empresaSelecionada = ler.nextInt();
		}
		
		if (empresaSelecionada == 1) {
			empresa = "Lanchonete da Gen";
		}else {
			empresa = "Lanchonete do Yuri";
		}
		return empresa;
	}

	// Mostra menu
	public static boolean validaEscolha(String escolha, Pedido pedido, Queue<Pedido> pedidos, int quantidade,
			ItemPedido itemPedido, Produto produto) {
		Scanner ler = new Scanner(System.in);
		boolean menuEscolha = true;
		char resposta;
		switch (escolha) {
		case "l1":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Hotdog do Julio", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "l2":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Hamburguer Apolinario", 47.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "l3":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Batata frita da Cintia", 14.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b1":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Suco natural", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b2":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Suco natural", 8.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b3":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Água com gás", 6.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b4":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Agua sem gas", 4.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s1":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Pudim", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s2":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Pedaco de bolo", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s3":
			System.out.println(Cores.TEXT_YELLOW + "\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Sorvete", 20.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		default:
			System.out.println("erro");
			break;
		}
		return menuEscolha;
	}

	public static boolean validaResposta(Scanner ler) {
		System.out.print(Cores.TEXT_YELLOW + "\tAdicionar mais itens ao pedido? " + Cores.TEXT_RESET + Cores.TEXT_WHITE + "(n/s): " + Cores.TEXT_RESET);
		char resposta = ler.next().toLowerCase().charAt(0);
		while (resposta != 'n' && resposta != 's') {
			System.out.print(Cores.TEXT_RED + "\tDigite 's' para Sim ou 'n' para nao: " + Cores.TEXT_RESET);
			resposta = ler.next().toLowerCase().charAt(0);
		}
		if (resposta == 'n') {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean validaRespostaEntregador(char resposta, Scanner ler) {
		while (resposta != 'n' && resposta != 's') {
			System.out.print(Cores.TEXT_RED + "\tDigite 's' para Sim ou 'n' para nao: " + Cores.TEXT_RESET);
			resposta = ler.next().toLowerCase().charAt(0);;
		}
		if (resposta == 'n') {
			return false;
		} else {
			return true;
		}
	}
	
	public static boolean loginEntregador(String nome, String senha, List<Entregador> entregadores) {
		Scanner ler = new Scanner(System.in);
		boolean login = false;
		for (Entregador e : entregadores) {
			if (e.getNome().equals(nome) && e.getSenha().equals(senha)) {
				login = true;
				break;
			}
		}
		return login;
	}

	// Imrime o menu
	public static String mostrarMenu(String empresa) {
		Scanner ler = new Scanner(System.in);
		System.out.println();
		System.out.println(Cores.TEXT_CYAN + "\t*********************************************************");
		System.out.println("\t                                                         ");
		System.out.println("\t\t           " + Cores.TEXT_YELLOW + empresa + Cores.TEXT_RESET + " ");
		System.out.println("\t                                                         ");
		System.out.println(Cores.TEXT_CYAN + "\t*********************************************************" + Cores.TEXT_RESET);
		System.out.println(Cores.TEXT_YELLOW + "\t\n        O que voce desejar comprar?\n" + Cores.TEXT_RESET);
		System.out.println("\tL1 - " + Cores.TEXT_CYAN + "Digite L1 para Hotdog do Julio.............." + Cores.TEXT_RESET + "R$ 15.00");
		System.out.println("\tL2 - " + Cores.TEXT_CYAN + "Digite L2 para Hamburguer Apolinario........" + Cores.TEXT_RESET + "R$ 47.00");
		System.out.println("\tL3 - " + Cores.TEXT_CYAN + "Digite L3 para Batata frita da Cintia......." + Cores.TEXT_RESET + "R$ 14.00\n");
		System.out.println("\tB1 - " + Cores.TEXT_CYAN + "Digite B1 para Refrigerante................." + Cores.TEXT_RESET + "R$ 10.00");
		System.out.println("\tB2 - " + Cores.TEXT_CYAN + "Digite B2 para Suco natura.................." + Cores.TEXT_RESET + "R$ 8.00");
		System.out.println("\tB3 - " + Cores.TEXT_CYAN + "Digite B3 para Agua com gas................." + Cores.TEXT_RESET + "R$ 6.00");
		System.out.println("\tB4 - " + Cores.TEXT_CYAN + "Digite B4 para Agua sem gas................." + Cores.TEXT_RESET + "R$ 4.00\n");
		System.out.println("\tS1 - " + Cores.TEXT_CYAN + "Digite S1 para Pudim........................" + Cores.TEXT_RESET + "R$ 10.00");
		System.out.println("\tS2 - " + Cores.TEXT_CYAN + "Digite S2 para Pedaco de Bolo..............." + Cores.TEXT_RESET + "R$ 15.00");
		System.out.println("\tS3 - " + Cores.TEXT_CYAN + "Digite S3 para Sorvete......................" + Cores.TEXT_RESET + "R$ 20.00\n");
		System.out.print(Cores.TEXT_YELLOW + "\tEscolha um: " + Cores.TEXT_RESET);
		String resposta = ler.nextLine().toLowerCase();
		while(validaOpcaoMenu(resposta) == false) {
			System.out.println();
			System.out.print(Cores.TEXT_RED + "\tOpcão invalida! " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "\n\tPor favor, selecione corretamente um item do menu: "+ Cores.TEXT_RESET);
			resposta = ler.nextLine().toLowerCase();
		}
		return resposta;
	}

	// Verifica o menu
	public static boolean validaOpcaoMenu(String resposta) {
	    String[] opcoes = {"l1", "l2", "l3", "b1", "b2", "b3", "b4", "s1", "s2", "s3"};
		boolean tem = false;
		for (int i = 0; i <= opcoes.length - 1; i++) {
			if (resposta.equals(opcoes[i])) {
				tem = true;
				break;
			}
		}
		return tem;
	}
	
	
	public static void verificaPedidos(String nome, List<Entregador> entregadores, Queue<Pedido> filapedidos, List<Pedido> pedidosEmEnvio, List<Pedido> pedidosEntregues, List<Empresa> empresas) {
		Scanner ler = new Scanner(System.in);
		
		Entregador e = entregadores.stream().filter(x -> x.getNome().equals(nome)).findFirst().orElse(null);
		
		if(e.getPedidoEmEntrega() != null) {
			System.out.print("\t" + e.getNome() + " você já finalizou a entrega do cliente " + e.getPedidoEmEntrega().getCliente().getNome() + " ?");
			char resposta = ler.next().toLowerCase().charAt(0);
			if (UI.validaRespostaEntregador(resposta, ler) == false) {
				System.out.println("\n\tPor favor, finalize o pedido do cliente " + e.getPedidoEmEntrega().getCliente().getNome());
				System.out.println("\tAperte enter para continuar...");
				ler.nextLine();
			}else {
				e.entregarPedido(e.getPedidoEmEntrega(), filapedidos, pedidosEmEnvio, pedidosEntregues, empresas);
				System.out.println("\n\tPedido entregue com sucesso!");
				ler.nextLine();
			}
		}else {
			System.out.println("\n\tPEDIDOS PARA ENTREGAR: ");
			boolean temPedido = false;
			for (Pedido p : filapedidos) {
				if (p.getStatus().equals(StatusPedido.valueOf("PAGO"))){
					System.out.println(p);
					temPedido = true;
				}
			}
			if(temPedido == true) {
				System.out.print("\tQual pedido deseja entregar?(Digite apenas o id): ");
				int idPedido = ler.nextInt();
				e.comecarEntregaPedido(idPedido, filapedidos, pedidosEmEnvio);
				ler.nextLine();
			}else {
				System.out.println("\n\tNão ha nenhum pedido para entregar!");
				System.out.print("\tAperte enter para continuar... ");
				ler.nextLine();
			}
			
			
		}
	}
	
	// Limpa a tela
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	

}
