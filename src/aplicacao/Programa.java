package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
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
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		System.out.println("Bem vindo ao seu cadastro!!");
		System.out.println("Digite o seu nome: ");
		String nome = ler.nextLine();
		System.out.println("Digite o seu E-mail: ");
		String email = ler.nextLine();
		System.out.println("Digite sua data nascimento (dd/mm/yyyy): ");
		String dataDeNascimento = ler.nextLine();
		System.out.println("Cria uma senha de 8 caracteres: ");
		String senha = ler.nextLine();
		System.out.println("Digite seu CPF: ");
		String cpf = ler.nextLine();
		System.out.println("Digite seu telefone ");
		String telefone = ler.nextLine();
		LocalDate DataCadastro = LocalDate.now();
		
		Cliente cliente1 = new Cliente(1, nome, email, LocalDate.parse(dataDeNascimento, fmt), senha, cpf, telefone, DataCadastro);
		
		Pedido pedido = new Pedido(LocalDate.now(), StatusPedido.valueOf("AGUARDANDO_PAGAMENTO"), cliente1);
	
		System.out.print("Quantos produtos você deseja? ");
		int nItems = ler.nextInt();
		
		for (int i = 1; i <= nItems; i++) {
			System.out.println("Digite os dados do produto #" + i + ": ");
			System.out.print("Nome: ");
			ler.nextLine();
			String produtoNome = ler.nextLine();
			System.out.print("Preço do produto: ");
			double produtoPreco = ler.nextDouble();
			System.out.print("Breve descrição: ");
			ler.nextLine();
			String breveDescrição = ler.nextLine();
			System.out.print("Tipo: ");
			String tipo = ler.nextLine();
			
			Produto produto1 = new Produto(i, produtoNome, breveDescrição, produtoPreco, tipo);
			
			System.out.print("Quantidade: ");
			int quantidade = ler.nextInt(); 
	
			ItemPedido itemPedido = new ItemPedido(quantidade, produto1);
			
			pedido.adicionarItem(itemPedido);
		}
		
		pedido.getItensList().forEach(item -> System.out.println(item.getPreco()));
		
	}

}





