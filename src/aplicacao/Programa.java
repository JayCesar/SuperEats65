package aplicacao;

import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Queue;
import java.util.Scanner;

import entidades.Cores;
import entidades.Empresa;
import entidades.Entregador;
import entidades.Pedido;
import entidades.enums.StatusPedido;

public class Programa {

	public static void main(String[] args) {
		Scanner ler = new Scanner(System.in);
		Locale.setDefault(Locale.US);
		
		// Registrando as duas empresas do sistema
		Empresa lanchoneteGen = new Empresa("Lanchonete da gen", 1);
		Empresa lanchoneteYuri = new Empresa("Lanchonete do Yuri", 2);
		List<Empresa> empresas = new ArrayList<>();
		empresas.add(lanchoneteGen);
		empresas.add(lanchoneteYuri);
		
		// Registrando entregadores
		List<Entregador> entregadores = new ArrayList<>();
		
		Entregador entregadorWesley = new Entregador("Wesley", "123456");
		Entregador entregadorRoberto = new Entregador("Roberto", "123456");
		Entregador entregadorGeovana = new Entregador("Geovanna", "123456");
		
		entregadores.add(entregadorWesley);
		entregadores.add(entregadorRoberto);
		entregadores.add(entregadorGeovana);
		
		// Criando listas vaziadsa dos pedidos 
		Queue<Pedido> pedidos = new LinkedList<>();
		List<Pedido> pedidosEmEnvio = new ArrayList<>();
		List<Pedido> pedidosEntregues = new ArrayList<>();
	
		Integer id = 0;
		
		String controle = null;

		// Menu inicial
		controle = UI.menuInicial();

		while (controle != null) {
			
			switch(controle) {
			
			case "pedido":
				System.out.println(Cores.TEXT_YELLOW + "\n\tE necessario fazer um breve cadastro antes do pedido: \n" + Cores.TEXT_RESET);
				UI.mostraTelaCliente(controle, pedidos, id);
				id += 1;
				System.out.print(Cores.TEXT_YELLOW + "\n\tAperte " + Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD + "enter " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "para continuar... " + Cores.TEXT_RESET);
				ler.nextLine();
				break;
				
			case "tela-de-pedidos":
				boolean temPedidoPago = false;
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_CYAN_BACKGROUND + "\n\tPEDIDOS EM PREPARO: " + Cores.TEXT_RESET);
				for (Pedido p : pedidos) {
					if (p.getStatus().equals(StatusPedido.valueOf("PAGO"))){
						System.out.println(p.mostraPedidos());
						temPedidoPago = true;
					}
				}
				if (temPedidoPago == false) System.out.println(Cores.TEXT_YELLOW + "\n\tNao ha pedidos entregues! " + Cores.TEXT_RESET);
				
				boolean temPedidoEmEnvio = false;
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_CYAN_BACKGROUND + "\n\tPEDIDOS EM ENVIO: " + Cores.TEXT_RESET);
				for (Pedido p : pedidos) {
					if (p.getStatus().equals(StatusPedido.valueOf("ENVIANDO"))){
						System.out.println(p);
						temPedidoEmEnvio = true;
					}
				}
				if (temPedidoEmEnvio == false) System.out.println(Cores.TEXT_YELLOW + "\n\tNao ha pedidos em envio! " + Cores.TEXT_RESET);
				
				System.out.print(Cores.TEXT_YELLOW + "\n\tAperte " + Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD + "enter " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "para continuar... " + Cores.TEXT_RESET);
				ler.nextLine();
				break;
				
			case "entregador":
				if(pedidos.isEmpty()) {
					System.out.println(Cores.TEXT_YELLOW + "\n\tNao ha pedidos para entregar" + Cores.TEXT_RESET);
				}else {
					System.out.print(Cores.TEXT_YELLOW + "\tDigite seu nome: " + Cores.TEXT_RESET);
					String nome = ler.nextLine();
					System.out.print(Cores.TEXT_YELLOW + "\tDigite sua senha: " + Cores.TEXT_RESET);
					String senha = ler.nextLine();
					while(UI.loginEntregador(nome, senha, entregadores) == false) {
						System.out.println(Cores.TEXT_RED + "\tEntregador nao encontrado! Digite novamente: " + Cores.TEXT_RESET);
						System.out.print(Cores.TEXT_YELLOW + "\tNome: " + Cores.TEXT_RESET);
						nome = ler.nextLine();
						System.out.print(Cores.TEXT_YELLOW + "\tSenha: " + Cores.TEXT_RESET);
						senha = ler.nextLine();
					}
					UI.verificaPedidos(nome, entregadores, pedidos, pedidosEmEnvio, pedidosEntregues, empresas);
				}
				System.out.print(Cores.TEXT_YELLOW + "\n\tAperte " + Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD + "enter " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "para continuar... " + Cores.TEXT_RESET);
				ler.nextLine();
				break;
			case "empresa":
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_CYAN_BACKGROUND + "\n\tLanchonete da Gen" + Cores.TEXT_RESET + lanchoneteGen);
				System.out.println(Cores.TEXT_WHITE_BOLD + Cores.ANSI_CYAN_BACKGROUND + "\n\tLanchonete do Yuri" + Cores.TEXT_RESET + lanchoneteYuri);
				System.out.print(Cores.TEXT_YELLOW + "\n\tAperte " + Cores.TEXT_RESET + Cores.TEXT_YELLOW_BOLD + "enter " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "para continuar... " + Cores.TEXT_RESET);
				ler.nextLine();
				break;
			}
			UI.clearScreen();
			controle = UI.menuInicial();	
		}
		System.out.println("\tPrograma finalizado");

	}
	
}