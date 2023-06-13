package entidades;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class Empresa {

	private String name;
	private Integer id;
	private double saldo; 
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");
	
	// Relação de associacao
	List<Pedido> pedidos = new ArrayList<>();
	
	public Empresa(String name, Integer id) {
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}
	
	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void addPedido(Pedido pedido) {
		this.getPedidos().add(pedido);
		double localSaldo = this.getSaldo();
		this.setSaldo(localSaldo += pedido.total());
	}
	
	public void removePedido(Pedido pedido) {
		this.getPedidos().remove(pedido);
	}

	public String visualizarPedidos() {
		StringBuilder sb = new StringBuilder();
		for (Pedido p : pedidos) {
			sb.append(Cores.TEXT_CYAN + "\n\tMomento do pedido: ");
			sb.append(p.getDataPedido().format(fmt) + "\n");
			sb.append("\tStatus do pedido: ");
			sb.append(p.getStatus() + "\n");
			sb.append("\tCliete: ");
			sb.append(p.getCliente().getNome() + "\n");
			sb.append("\tTotal do pedido: ");
			sb.append("R$: " + String.format("%.2f", p.total()) + "\n" + Cores.TEXT_RESET);
		}
		return sb.toString();
	}
	
	@Override
	public String toString() {
		return  Cores.TEXT_YELLOW + "\n\tId da empresa: " + Cores.TEXT_RESET + id 
				+ Cores.TEXT_YELLOW + "\n\tSaldo do dia: " + Cores.TEXT_RESET + "R$ " + String.format("%.2f", saldo)
				+ Cores.TEXT_YELLOW + "\n\n\tPedidos entregues: " + Cores.TEXT_RESET
				+ "\n\t" + this.visualizarPedidos();
	}
	
	
}
