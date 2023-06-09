package aplicacao;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

import entidades.*;

public class Menu {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);

		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		Cliente cliente = new Cliente(3, "Tester", "example@teste.com", LocalDate.parse("05/06/2023", fmt), "testando",
				"98765432-1", "9 1234-5678", LocalDate.parse("08/06/2023", fmt));

		Produto produto = new Produto(2, "ProdutoX", "É bom", 20.0);
		ItemPedido itemPedido = new ItemPedido(22, produto, "bebida");

		Scanner scanner = new Scanner(System.in);

		while (true) {
			System.out.println("\n\n\t********************************");
			System.out.println("\t* Menu:                        *");
			System.out.println("\t********************************");
			System.out.println("\t1 - Lanches");
			System.out.println("\t2 - Bebidas");
			System.out.println("\t3 - Sobremesas");
			System.out.println("\t4 - Voltar");
			System.out.print("\tEscolha uma opção: ");

			int opcao = scanner.nextInt();
			scanner.nextLine();

			if (opcao == 1) {
				while (true) {
					System.out.println("\n\n\t********************************");
					System.out.println("\t* Menu:                        *");
					System.out.println("\t********************************");
					System.out.println("\t1 - Hotdog");
					System.out.println("\t2 - Hamburguer");
					System.out.println("\t3 - Pastel");
					System.out.println("\t4 - Batata Frita");
					System.out.println("\t5 - Voltar");
					System.out.print("\tEscolha uma opção: ");

					int subOpcao = scanner.nextInt();
					scanner.nextLine();

					if (subOpcao == 1) {
						System.out.print("\nProduto: " + produto.getName() + "\nQuantidade: " + itemPedido.getQuantidade() 
						+ "\nPreço Unitário: " + itemPedido.getPreco()
						+ "\nPreço: " +	itemPedido.getQuantidade() * itemPedido.getPreco());
					} else if (subOpcao == 2) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 3) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 4) {
						System.out.print(itemPedido.getPreco());

					} else if (subOpcao == 5) {
						break;
					} else {
						System.out.println("Opção inválida.");
					}
				}

			} else if (opcao == 2) {
				while (true) {
					System.out.println("\n\n\t********************************");
					System.out.println("\t* Menu:                        *");
					System.out.println("\t********************************");
					System.out.println("\t1 - Agua");
					System.out.println("\t2 - Coca");
					System.out.println("\t3 - Suco");
					System.out.println("\t4 - sem gás");
					System.out.println("\t5 - Voltar");
					System.out.print("\tEscolha uma opção: ");

					int subOpcao = scanner.nextInt();
					scanner.nextLine();

					if (subOpcao == 1) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 2) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 3) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 4) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 5) {
						break;
					} else {
						System.out.println("Opção inválida.");
					}
				}
			} else if (opcao == 3) {
				while(true) {
					System.out.println("\n\n\t********************************");
					System.out.println("\t* Menu:                        *");
					System.out.println("\t********************************");
					System.out.println("\t1 - Sorvete");
					System.out.println("\t2 - Doce");
					System.out.println("\t3 - Bolo");
					System.out.println("\t4 - Pudim");
					System.out.println("\t5 - Voltar");
					System.out.print("\tEscolha uma opção: ");
					
					int subOpcao = scanner.nextInt();
					scanner.nextLine();

					if (subOpcao == 1) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 2) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 3) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 4) {
						System.out.print(itemPedido.getPreco());
					} else if (subOpcao == 5) {
						break;
					} else {
						System.out.println("Opção inválida.");
					}
				}
			} else if (opcao == 4) {
				break;
			} else {
				System.out.println("Opção inválida.");
			}
		}

	}
}
