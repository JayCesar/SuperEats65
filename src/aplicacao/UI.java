package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
		System.out.println(Cores.TEXT_CYAN + "\t       *********************************************************");
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
		String nome = "";
		String email = "";
		String dataDeNascimento = "";
		String senha = "";
		String cpf = "";
		String bairro = "";
		String rua = "";
		String cep = "";
		String casaNumero = "";

		
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite o seu nome: " + Cores.TEXT_RESET);
		nome = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite o seu E-mail: " + Cores.TEXT_RESET);
		email = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite sua data nascimento (dd/mm/yyyy): " + Cores.TEXT_RESET);
		dataDeNascimento = ler.nextLine();
		while(compilaDataNascimento(dataDeNascimento) == false) {
			System.out.print(Cores.TEXT_CYAN + "\t\tDigite sua data nascimento (dd/mm/yyyy): " + Cores.TEXT_RESET);
			dataDeNascimento = ler.nextLine();
		}
		System.out.print(Cores.TEXT_CYAN + "\t\tCrie uma senha de pedido: " + Cores.TEXT_RESET);
		senha = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite seu CPF: " + Cores.TEXT_RESET);
		cpf = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite o nome do seu bairro: " + Cores.TEXT_RESET);
		bairro = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite o nome da sua rua: " + Cores.TEXT_RESET);
		rua = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite seu CEP: " + Cores.TEXT_RESET);
		cep = ler.nextLine();
		System.out.print(Cores.TEXT_CYAN + "\t\tDigite o numero da sua Casa/Apt: " + Cores.TEXT_RESET);
		casaNumero = ler.nextLine();
		
		clearScreen();
		
		System.out.println(Cores.TEXT_YELLOW + "\n\tOla, " + nome + "! Seu cadastrado foi efetuado com sucesso!" + Cores.TEXT_RESET);
		
		System.out.print(Cores.TEXT_YELLOW + "\n\tAperte " + Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD + "enter " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "para continuar... " + Cores.TEXT_RESET);
		ler.nextLine();
		
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
		Double totalPedido = pedido.total();
		Double pagamento = cliente.efetuarPagamento(totalPedido);

		System.out.println(Cores.TEXT_GREEN + "\n\tPagamento realizado com sucesso!" + Cores.TEXT_RESET);
		pedido.setStatus(StatusPedido.valueOf("PAGO"));
		if (pagamento > totalPedido) {
			double troco = pagamento - totalPedido;
			System.out.println(Cores.TEXT_GREEN + "\n\tSeu troco: R$" + String.format("%.2f", troco) + Cores.TEXT_RESET);
		}
		
		
	}
	
	
	public static boolean compilaDataNascimento(String dataDeNascimento) {
		boolean compilado = true;
		try {
			corrigeDataNascimento(dataDeNascimento);
		} catch(DateTimeParseException e) {
			System.out.println(e.getMessage() + dataDeNascimento);
			compilado = false;
		}
		return compilado;
	}
	
	
	public static void corrigeDataNascimento(String dataDeNascimento) {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		try {
			LocalDate.parse(dataDeNascimento, fmt);
		}catch(DateTimeParseException e) {
			throw new DateTimeParseException(Cores.TEXT_YELLOW + "\n\tFormato de data de nascimento invalida: " + Cores.TEXT_RESET, dataDeNascimento, 0);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hotdog do Julio - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Hamburguer do Apolinario - R$ 47.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Batata frita da cintia - R$ 14.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Refrigerante - R$ 10.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Refrigerante", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b2":
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Suco natural - R$ 8.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Agua com gas - R$ 6.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
				}
			} while (quantidade <= 0);
			produto = new Produto("Agua com gas", 6.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if (!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b4":
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Agua sem gas - R$ 4.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Pudim - R$ 10.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Pedaco de bolo - R$ 15.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
			System.out.println(Cores.TEXT_YELLOW + "\t\tItem selecionado: " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "Sorvete - R$ 20.00" + Cores.TEXT_RESET);
			do {
				System.out.print(Cores.TEXT_YELLOW + "\t\tQuantidade? " + Cores.TEXT_RESET);
				while (!ler.hasNextInt()) {
					System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida, digite apenas numero: " + Cores.TEXT_RESET);
					ler.next();
				}
				quantidade = ler.nextInt();
				if (quantidade <= 0) {
					System.out.println(Cores.TEXT_RED + "\t\tMinimo 1 item" + Cores.TEXT_RESET);
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
		System.out.print(Cores.TEXT_YELLOW + "\t\tAdicionar mais itens ao pedido? " + Cores.TEXT_RESET + Cores.TEXT_WHITE + "(n/s): " + Cores.TEXT_RESET);
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
			System.out.print(Cores.TEXT_RED + "\t\tDigite 's' para Sim ou 'n' para nao: " + Cores.TEXT_RESET);
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
		clearScreen();
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
		System.out.println("\tB2 - " + Cores.TEXT_CYAN + "Digite B2 para Suco natural.................." + Cores.TEXT_RESET + "R$ 8.00");
		System.out.println("\tB3 - " + Cores.TEXT_CYAN + "Digite B3 para Agua com gas................." + Cores.TEXT_RESET + "R$ 6.00");
		System.out.println("\tB4 - " + Cores.TEXT_CYAN + "Digite B4 para Agua sem gas................." + Cores.TEXT_RESET + "R$ 4.00\n");
		System.out.println("\tS1 - " + Cores.TEXT_CYAN + "Digite S1 para Pudim........................" + Cores.TEXT_RESET + "R$ 10.00");
		System.out.println("\tS2 - " + Cores.TEXT_CYAN + "Digite S2 para Pedaco de Bolo..............." + Cores.TEXT_RESET + "R$ 15.00");
		System.out.println("\tS3 - " + Cores.TEXT_CYAN + "Digite S3 para Sorvete......................" + Cores.TEXT_RESET + "R$ 20.00\n");
		System.out.print(Cores.TEXT_YELLOW + "\t\tEscolha um: " + Cores.TEXT_RESET);
		String resposta = ler.nextLine().toLowerCase();
		while(validaOpcaoMenu(resposta) == false) {
			System.out.println();
			System.out.print(Cores.TEXT_RED + "\t\tOpcao invalida! " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "\n\tPor favor, selecione corretamente um item do menu: "+ Cores.TEXT_RESET);
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
			System.out.print(Cores.TEXT_YELLOW + "\t\t" + e.getNome() + " voce ja finalizou a entrega do(a) cliente " + e.getPedidoEmEntrega().getCliente().getNome() + " ?: " + Cores.TEXT_RESET);
			char resposta = ler.next().toLowerCase().charAt(0);
			if (UI.validaRespostaEntregador(resposta, ler) == false) {
				System.out.println(Cores.TEXT_YELLOW + "\n\tPor favor, finalize o pedido do(a) cliente " + e.getPedidoEmEntrega().getCliente().getNome() + Cores.TEXT_RESET);
			}else {
				e.entregarPedido(e.getPedidoEmEntrega(), filapedidos, pedidosEmEnvio, pedidosEntregues, empresas);
				System.out.println(Cores.TEXT_YELLOW + "\n\tPedido entregue com sucesso! " + Cores.TEXT_RESET);
			}
		}else {
			System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_CYAN_BACKGROUND + "\n\tPEDIDOS PARA ENTREGAR: " + Cores.TEXT_RESET);
			boolean temPedido = false;
			for (Pedido p : filapedidos) {
				if (p.getStatus().equals(StatusPedido.valueOf("PAGO"))){
					System.out.println(p);
					temPedido = true;
				}
			}
			if(temPedido == true) {
				System.out.print(Cores.TEXT_YELLOW + "\n\tQual pedido deseja entregar?" + Cores.TEXT_RESET + Cores.TEXT_CYAN + " (Digite apenas o id): " + Cores.TEXT_RESET + Cores.TEXT_RESET);
				int idPedido = ler.nextInt();
				e.comecarEntregaPedido(idPedido, filapedidos, pedidosEmEnvio);
				System.out.println(Cores.TEXT_YELLOW + "\n\tEntrega do pedido inicilizada! " + Cores.TEXT_RESET);
			}else {
				System.out.println(Cores.TEXT_YELLOW + "\n\tNao ha pedidos para entregar!" + Cores.TEXT_RESET);
			}
		}
	}
	
	// Limpa a tela
	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	

}