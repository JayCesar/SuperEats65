package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

import entidades.Cliente;
import entidades.ItemPedido;
import entidades.Pedido;
import entidades.Produto;
import entidades.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);

		Queue<Pedido> pedidos = new LinkedList<>();

		String controle = null;
		
		controle = menuInicial(ler);
		
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
		System.out.println("\tPrograma finalizado");

	}
	
	public static String menuInicial(Scanner ler) {
		System.out.println("\t1 - Fazer pedido:");
		System.out.println("\t2 - Entrar como funcionário");
		System.out.println("\t3 - Finalizar programa");
		System.out.print("\n\tEntre com a opção desejada: ");
		Integer input = ler.nextInt();
		while(input != 1 && input != 2 && input != 3) {
			System.out.print("Digite o número corretamente: ");
			input = ler.nextInt();
		}
		if (input == 1) {
			return "pedido";
		}else if(input == 2){
			return "funcionario";
		}else {
			return null;
		}
	}
	
	public static void mostraTelaCliente(String controle, Queue<Pedido> pedidos) {
		Scanner ler = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Random gerador = new Random();

		// Instanciacoes fazias
		int quantidade = 0;
		Produto produto = new Produto();
		ItemPedido itemPedido = new ItemPedido();
	
		Integer id = gerador.nextInt(60);
		System.out.print("\tDigite o seu nome: "); 
		String nome = ler.nextLine();
		System.out.print("\tDigite o seu E-mail: "); 
		String email = ler.nextLine();
		System.out.print("\tDigite sua data nascimento (dd/mm/yyyy): "); 
		String dataDeNascimento = ler.nextLine();
		System.out.print("\tCria uma senha de pedido: "); 
		String senha = ler.nextLine(); 
		System.out.print("\tDigite seu CPF: "); 
		String cpf = ler.nextLine(); 

		Cliente cliente = new Cliente(id, nome, email, LocalDate.parse(dataDeNascimento, fmt), senha, cpf);
		Pedido pedido = new Pedido(LocalDateTime.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
		   
		boolean menuEscolha = true;
		String escolha;
		
		while(menuEscolha) {
			escolha = mostrarMenu();
			menuEscolha = validaEscolha(escolha, pedido, pedidos, quantidade, itemPedido, produto);
		}
		
		for (Pedido p : pedidos) {
			System.out.println(p);
		}
		
		System.out.println();
	
		boolean pagamento = cliente.efetuarPagamento(pedido.total());
		
		while (pagamento == false) {
			System.out.println("\n\tErro no pagamento:\n");
			pagamento = cliente.efetuarPagamento(pedido.total());
			if(pagamento == true) {
				pedido.setStatus(StatusPedido.valueOf("PAGO"));
				System.out.println("\tPagamento realizado com sucesso!\n");
			}
		}
	}
	
	
	public static boolean validaEscolha(String escolha, Pedido pedido, Queue<Pedido> pedidos, int quantidade, ItemPedido itemPedido, Produto produto) {
		Scanner ler = new Scanner(System.in);
		boolean menuEscolha = true;
		char resposta;
		switch (escolha) {
		case "l1":
			System.out.println("\tItem selecionado: Hotdog do Júlio - R$ 15.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Hotdog do Júlio", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "l2":
			System.out.println("\tItem selecionado: Hambúrguer Apolinário - R$ 47.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Hambúrguer Apolinário", 47.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "l3":
			System.out.println("\tItem selecionado: Batata frita da Cintia - R$ 14.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Batata frita da Cintia", 14.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b1":
			System.out.println("\tItem selecionado: Refrigerante - R$ 10.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Suco natural", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b2":
			System.out.println("\tItem selecionado: Suco natural - R$ 8.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Suco natural", 8.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b3":
			System.out.println("\tItem selecionado: Água com gás - R$ 6.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Água com gás", 6.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "b4":
			System.out.println("\tItem selecionado: Água sem gás - R$ 4.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Água sem gás", 4.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s1":
			System.out.println("\tItem selecionado: Pudim - R$ 15.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Pudim", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s2":
			System.out.println("\tItem selecionado: Pedaço de bolo - R$ 10.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Pedaço de bolo", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
				pedidos.add(pedido);
			}
			break;
		case "s3":
			System.out.println("\tItem selecionado: Sorvete - R$ 20.00");
			System.out.print("\tQuantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Sorvete", 20.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			menuEscolha = validaResposta(ler);
			if(!menuEscolha) {
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
		System.out.print("\tAdicionar mais itens ao pedido? (n/s): ");
		char resposta = ler.next().toLowerCase().charAt(0);
		while(resposta != 'n' && resposta != 's') {
			System.out.print("\tDigite 's' para Sim ou 'n' para não: ");
			resposta = ler.next().toLowerCase().charAt(0);
		}
		if (resposta == 'n') {
			return false;
		}else {
			return true;
		}
	}
    // Imrime o menu
	public static String mostrarMenu() {
		Scanner ler = new Scanner(System.in);
		System.out.println();
		System.out.println("\t*********************************************************");
		System.out.println("\t\t            Lanchonete da Gen");
		System.out.println("\t*********************************************************");
		System.out.println("\t\n        O que você desejar comprar?\n");
		System.out.println("\t1 - Digite L1 para Hotdog do Júlio..............R$ 15.00");
		System.out.println("\t2 - Digite L2 para Hambúrguer Apolinário........R$ 47.00");
		System.out.println("\t3 - Digite L3 para Batata frita da Cintia.......R$ 14.00\n");
		System.out.println("\t1 - Digite B1 para Refrigerante.................R$ 10.00");
		System.out.println("\t2 - Digite B2 para Suco natura..................R$ 8.00");
		System.out.println("\t3 - Digite B3 para Água com gás.................R$ 6.00");
		System.out.println("\t4 - Digite B4 para Água sem gás.................R$ 4.00\n");
		System.out.println("\t1 - Digite S1 para Pudim........................R$ 10.00");
		System.out.println("\t2 - Digite S2 para Pedaço de Bolo...............R$ 15.00");
		System.out.println("\t3 - Digite S3 para Sorvete......................R$ 20.00\n");
		System.out.print("\tEscolha um: ");
		String resposta = ler.nextLine().toLowerCase();	
		return resposta;
	}
	
}
