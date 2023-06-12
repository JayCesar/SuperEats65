package aplicacao;

import java.util.ArrayList;
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
				break;
				
			case "tela-de-pedidos":
				System.out.println(Cores.TEXT_YELLOW + "\n\tPEDIDOS EM PREPARO: " + Cores.TEXT_RESET);
				for (Pedido p : pedidos) {
					if (p.getStatus().equals(StatusPedido.valueOf("PAGO"))){
						System.out.println(p.mostraPedidos());
					}
				}
				
				System.out.println(Cores.TEXT_YELLOW + "\n\tPEDIDOS EM ENVIO: " + Cores.TEXT_RESET);
				for (Pedido p : pedidos) {
					if (p.getStatus().equals(StatusPedido.valueOf("ENVIANDO"))){
						System.out.println(p);
					}
				}
				break;
				
			case "entregador":
				if(pedidos.isEmpty()) {
					System.out.println("\n\tNão há nenhum pedido para enviar");
				}else {
					System.out.print("\tDigite seu nome: ");
					String nome = ler.nextLine();
					System.out.print("\tDigite sua senha: ");
					String senha = ler.nextLine();
					while(UI.loginEntregador(nome, senha, entregadores) == false) {
						System.out.println("\tEntregador não encontrado! Digite novamente: ");
						System.out.print("\tNome:");
						nome = ler.nextLine();
						System.out.print("\tSenha: ");
						senha = ler.nextLine();
					}
					UI.verificaPedidos(nome, entregadores, pedidos, pedidosEmEnvio, pedidosEntregues, empresas);
				}
				break;
			case "empresa":
				System.out.println("\n\tLanchonete da Gen" + lanchoneteGen);
				System.out.println("\n\tLanchonete do Yuri" + lanchoneteYuri);
				ler.nextLine();
			}
			
			controle = UI.menuInicial();	
		}
		System.out.println("\tPrograma finalizado");

	}
	
}
