package entidades;

import java.time.LocalDate;
import java.util.Scanner;

import entidades.enums.StatusPedido;

public class Cliente extends Pessoa{
	private String cpf;

	public Cliente() {}
	public Cliente(Integer id, String nome, String email, LocalDate dataDeNascimento, String senha, String cpf) {
		super(id, nome, email, dataDeNascimento, senha);
		this.cpf = cpf;
	}
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public Double efetuarPagamento(double totalPedido) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\tPor gentileza, efetue o pagamento de R$" + String.format("%.2f", totalPedido));
		System.out.print("\tDigite o valor exato total a pagar: ");
		double pagamento = sc.nextDouble();
		Double troco = null;
		while (pagamento < totalPedido) {
			System.out.println("\n\tValor inforior ao total\n");
			System.out.print("\tDigite o valor exato total a pagar: ");
			pagamento = sc.nextDouble();
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
		return getNome();
	}
}