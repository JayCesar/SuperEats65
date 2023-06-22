package entidades;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import entidades.enums.StatusPedido;

public class Pedido {
	
	DateTimeFormatter fmt = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	private LocalDateTime dataPedido;
	private StatusPedido status;
	private Integer id;
	private String empresa;
	
	// Relação de associação
	List<ItemPedido> ItensList = new ArrayList<>();
	private Cliente cliente;

	public Pedido(Integer id, LocalDateTime dataPedido, StatusPedido status, Cliente cliente, String empresa) {
		this.id = id;
		this.dataPedido = dataPedido;
		this.status = status;
		this.cliente = cliente;
		this.empresa = empresa;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public LocalDateTime getDataPedido() {
		return dataPedido;
	}

	public void setDataPedido(LocalDateTime dataPedido) {
		this.dataPedido = dataPedido;
	}

	public StatusPedido getStatus() {
		return status;
	}

	public void setStatus(StatusPedido status) {
		this.status = status;
	}

	public List<ItemPedido> getItensList() {
		return ItensList;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public void adicionarItem(ItemPedido item) {
		ItensList.add(item);
	}
	
	public void removerItem(ItemPedido item) {
		ItensList.remove(item);
	}

	public Double total() {
		double sum = 0.0;
		for(ItemPedido item : ItensList) {
			sum += item.subTotal();
		}
		return sum;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		    sb.append(Cores.TEXT_YELLOW + "\n\tId do pedido: " + Cores.TEXT_RESET);
		    sb.append(Cores.TEXT_CYAN + this.getId() + "\n" + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tMomento do pedido: " + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_WHITE + dataPedido.format(fmt) + "\n"+ Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tStatus do pedido: " + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_WHITE + this.getStatus() + "\n"+ Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tEmpresa: " );
			sb.append(Cores.TEXT_WHITE + this.getEmpresa() + "\n" + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tPedido: \n" + Cores.TEXT_RESET);
				for (ItemPedido item : ItensList) {
					sb.append(item + "\n");
				}
			sb.append(Cores.TEXT_YELLOW + "\t\tTotal a pagar: "  + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_CYAN + "R$" + String.format("%.2f", total()) + Cores.TEXT_RESET);
		return sb.toString();
	}
	
	public String mostraPedidos() {
		StringBuilder sb = new StringBuilder();
			sb.append(Cores.TEXT_YELLOW + "\n\tId do pedido: " + Cores.TEXT_RESET);
		    sb.append(Cores.TEXT_CYAN + this.getId() + "\n" + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tMomento do pedido: " + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_WHITE + dataPedido.format(fmt) + "\n"+ Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tStatus do pedido: " + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_WHITE + this.getStatus() + "\n"+ Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tEmpresa: " );
			sb.append(Cores.TEXT_WHITE + this.getEmpresa() + "\n" + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tCliente: " + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_CYAN + this.getCliente().getNome() + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_YELLOW + "\t\tPedido: \n" + Cores.TEXT_RESET);
				for (ItemPedido item : ItensList) {
					sb.append(item + "\n");
				}
			sb.append(Cores.TEXT_YELLOW + "\t\tTotal pago: "  + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_CYAN + "R$" + String.format("%.2f", total()) + Cores.TEXT_RESET);
			sb.append(Cores.TEXT_CYAN + "\n\n\t*********************************************************\r\n" + Cores.TEXT_RESET);
		return sb.toString();
	}
	
	
	
	
	
}

