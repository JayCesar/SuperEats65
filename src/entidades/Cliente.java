package entidades;

import java.time.LocalDate;
import java.util.Scanner;

public class Cliente extends Pessoa{
	private String cpf;
	private String bairro;
	private String rua;
	private String cep;
	private String numero;

	public Cliente() {}
	
	public Cliente(Integer id, String nome, String email, LocalDate dataDeNascimento, String senha, String cpf, String bairro, String rua, String cep, String numero) {
		super(id, nome, email, dataDeNascimento, senha);
		this.cpf = cpf;
		this.bairro = bairro;
		this.rua = rua;
		this.cep = cep;
		this.numero = numero;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	
	public Double efetuarPagamento(double totalPedido) {
		Scanner ler = new Scanner(System.in);
		System.out.println("\tPor gentileza, efetue o pagamento de R$" + String.format("%.2f", totalPedido));
		System.out.print("\tDigite o valor exato total a pagar: ");
		double pagamento = ler.nextDouble();
		Double troco = null;
		while (pagamento < totalPedido) {
			System.out.println("\n\tValor inferior ao total\n");
			System.out.print("\tDigite o valor exato total a pagar: ");
			pagamento = ler.nextDouble();
			troco = (pagamento > totalPedido) ? pagamento - totalPedido : null;
		}
		if (troco != null) {
			return troco;
		}else {
		return troco;
		}
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
	    sb.append("\tNome do cliente: ");
	    sb.append(this.getNome());
	return sb.toString();
	}
}