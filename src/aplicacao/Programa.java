package aplicacao;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;
import java.util.Queue;
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

		Queue<Pedido> pedidos = new LinkedList<>();

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		// Cadastrou o cliente
		// Ai vem o fluxo
		Cliente cliente = new Cliente(2, "Julio", "julio@gmail.com", LocalDate.parse("10/03/2000", fmt), "2222");
		
		// Valores vazios
		String escolha;
		Pedido pedido = new Pedido(LocalDateTime.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente);
		int quantidade = 0;
		Produto produto = new Produto();
		ItemPedido itemPedido = new ItemPedido();
		boolean menuEscolha = true;
		
		while(menuEscolha) {
			escolha = mostrarMenu();
			menuEscolha = validaEscolha(escolha, pedido, pedidos, quantidade, itemPedido, produto);
		}

		
		for (Pedido p : pedidos) {
			System.out.println(p);
		}

	}
	
	public static boolean validaEscolha(String escolha, Pedido pedido, Queue<Pedido> pedidos, int quantidade, ItemPedido itemPedido, Produto produto) {
		Scanner ler = new Scanner(System.in);
		boolean menuEscolha = true;
		char resposta;
		switch (escolha) {
		case "l1":
			System.out.println("Item selecionado: Hotdog do Júlio - R$ 15.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Hotdog do Júlio", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "l2":
			System.out.println("Item selecionado: Hambúrguer Apolinário - R$ 47.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Hambúrguer Apolinário", 47.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "l3":
			System.out.println("Item selecionado: Batata frita da Cintia - R$ 14.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Batata frita da Cintia", 14.00);
			itemPedido = new ItemPedido(quantidade, produto, "lanche");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "b1":
			System.out.println("Item selecionado: Refrigerante - R$ 10.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Suco natural", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "b2":
			System.out.println("Item selecionado: Suco natural - R$ 8.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Suco natural", 8.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "b3":
			System.out.println("Item selecionado: Água com gás - R$ 6.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Água com gás", 6.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "b4":
			System.out.println("Item selecionado: Água sem gás - R$ 4.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Água sem gás", 4.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "s1":
			System.out.println("Item selecionado: Pudim - R$ 15.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Pudim", 15.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "s2":
			System.out.println("Item selecionado: Pedaço de bolo - R$ 10.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Pedaço de bolo", 10.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		case "s3":
			System.out.println("Item selecionado: Sorvete - R$ 20.00");
			System.out.print("Quantidade? ");
			quantidade = ler.nextInt();
			produto = new Produto("Sorvete", 20.00);
			itemPedido = new ItemPedido(quantidade, produto, "bebida");
			pedido.adicionarItem(itemPedido);
			System.out.println("Adicionar mais itens ao pedido? ");
			resposta = ler.next().toLowerCase().charAt(0);
			if (resposta == 'n') {
				menuEscolha = false;
				pedidos.add(pedido);
			}else if(resposta == 's'){
				menuEscolha = true;
			}
			break;
		default:
			System.out.println("erro");
			break;
		}
		return menuEscolha;
	}

    // Imrime o menu
	public static String mostrarMenu() {
		Scanner ler = new Scanner(System.in);
		System.out.println();
		System.out.println("\t***************************************");
		System.out.println("\t\t   Lanchonete da Gen");
		System.out.println("\t***************************************");
		System.out.println("\t(L) LANCHES: \n");
		System.out.println("\t1 - Hotdog do Júlio:..............R$ 15.00 ");
		System.out.println("\t2 - Hambúrguer Apolinário:........R$ 47.00");
		System.out.println("\t3 - Batata frita da Cintia:.......R$ 14.00");
		System.out.println("\n\t(B) BEBIDAS: \n");
		System.out.println("\t1 - Refrigerante..............R$ 10.00");
		System.out.println("\t2 - Suco natural..............R$ 8.00");
		System.out.println("\t3 - Água com gás..............R$ 6.00");
		System.out.println("\t4 - Água sem gás..............R$ 4.00");
		System.out.println("\n\t(S) SOBREMESAS: \n");
		System.out.println("\t1 - Pudim.....................R$ 15.00");
		System.out.println("\t2 - Pedaço de Bolo............R$ 10.00");
		System.out.println("\t3 - Sorvete:..................R$ 20.00");
		System.out.println();
		System.out.println("\nO que você desejar comprar?\n");
		System.out.println("Digite L1 para Hotdog do Júlio");
		System.out.println("Digite L2 para Hamburguer Apolinário");
		System.out.println("Digite L3 para Batata frita da Cintia\n");
		System.out.println("Digite B1 para Refrigerante");
		System.out.println("Digite B2 para Suco natural");
		System.out.println("Digite B3 para Água com gás");
		System.out.println("Digite B4 para Água sem gás\n");
		System.out.println("Digite S1 para Pudim");
		System.out.println("Digite S2 para Pedaço de Bolo");
		System.out.println("Digite S3 para Sorvete\n");
		System.out.print("Escolha um: ");
		return ler.nextLine().toLowerCase();
	}

	
}
