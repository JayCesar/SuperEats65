package entidades;

import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import entidades.enums.StatusPedido;

public class Entregador  {
	private String nome;
	private double Salario;
	private String senha;
	private Pedido pedidoEmEntrega;
	
	public Entregador(String nome, String senha) {
		this.nome = nome;
		this.senha = senha;
	}
	

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public double getSalario() {
		return Salario;
	}

	public void setSalario(double salario) {
		Salario = salario;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}


	public Pedido getPedidoEmEntrega() {
		return pedidoEmEntrega;
	}

	public void comecarEntregaPedido(Integer id, Queue<Pedido> filaPedidos, List<Pedido> pedidosEmEnvio) {
		Scanner ler = new Scanner(System.in);
		while(verificaIdPedido(id, filaPedidos) == false) {
			System.out.print(Cores.TEXT_YELLOW + "\n\tSelecione um " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "ID existente " + Cores.TEXT_RESET + Cores.TEXT_YELLOW + "e sem o status " + Cores.TEXT_RESET + Cores.TEXT_CYAN + "'Enviando': " + Cores.TEXT_RESET);
			id = ler.nextInt();
		}
		pedidosEmEnvio.add(pedidoEmEntrega);
		
	}

	public void entregarPedido(Pedido pedidoEmEntrega, Queue<Pedido> filaPedidos, List<Pedido> pedidosEmEnvio, List<Pedido> pedidosEntregue, List<Empresa> empresas) {
		
		// Adiciona o produto na empresa
		if (pedidoEmEntrega.getEmpresa().equals("Lanchonete da Gen")) {
			Empresa lanchoneteDaGen = empresas.stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);
			lanchoneteDaGen.addPedido(pedidoEmEntrega);
		}else {
			Empresa lanchoneteDoYuri = empresas.stream().filter(x -> x.getId().equals(1)).findFirst().orElse(null);
			lanchoneteDoYuri.addPedido(pedidoEmEntrega);
		}

		// Atualiza o sistema de pedido
		for (Pedido p : filaPedidos) {
			if (p.getId() == pedidoEmEntrega.getId()) {
				p.setStatus(StatusPedido.valueOf("ENTREGUE"));
				pedidosEntregue.add(p);
				pedidosEmEnvio.remove(p);
				filaPedidos.remove(p);
			}
		}
		pedidoEmEntrega = null;
	}
	
	public boolean verificaIdPedido(Integer id, Queue<Pedido> filaPedidos) {
		boolean possivel = false;
		for (Pedido p : filaPedidos) {
			if (p.getId() == id && p.getStatus() != StatusPedido.valueOf("ENVIANDO")){
				p.setStatus(StatusPedido.valueOf("ENVIANDO"));
				pedidoEmEntrega = p;
				possivel = true;
				break;
			}
		}
		return possivel;
	}
}


