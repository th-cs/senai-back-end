// Database for searching people by ID. It's possible to add, edit, and remove
// people
package ex01PeopleDatabase;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		int menuOption;
		boolean isMenuOpen;
		int personId;
		int cacheStorage = 10;

		Scanner input = new Scanner(System.in);

		ArrayList<Person> database = new ArrayList<>();
		ArrayList<Person> cache = new ArrayList<>();

		database.add(new Person(1, "Ana", 20));
		database.add(new Person(2, "Pedro", 15));
		database.add(new Person(3, "Gabriela", 47));
		database.add(new Person(4, "Carlos", 36));
		database.add(new Person(5, "Lídia", 24));

		System.out.println("-- Banco de Dados de Pessoas --");

		isMenuOpen = true;

		while(isMenuOpen) {
			System.out.println("\nEscolha uma das seguintes opções:\n"
				+ "| 1 | - Pesquisar por ID\n-----\n"
				+ "| 2 | - Listar o banco de dados\n"
				+ "| 3 | - Listar o cache\n-----\n"
				+ "| 4 | - Adicionar uma pessoa ao banco\n"
				+ "| 5 | - Editar uma pessoa do banco\n"
				+ "| 6 | - Remover uma pessoa do banco\n-----\n"
				+ "| 7 | - Limpar o cache\n"
				+ "| 8 | - Limpar o banco de dados\n-----\n"
				+ "| 0 | - Sair do banco de dados");
			menuOption = input.nextInt();

			switch (menuOption) {
				case 0:
					System.out.println("Saindo do banco de dados...");
					isMenuOpen = false;
					break;
				case 1:
					boolean isInCache = false;
					boolean isInDatabase = false;

					System.out.print("Digite o ID que deseja pesquisar: ");
					personId = input.nextInt();

					System.out.println("Buscando no cache...");
					for (Person k : cache) {
						if (k.getId() == personId) {
							isInCache = true;
							isInDatabase = true;
							System.out.printf("\nPessoa encontrada no cache:\n"
								+ "%s \n", k);
						}
					}

					if (!isInCache) {
						System.out.println("Buscando no banco de dados...");
						for (Person k : database) {
							if (k.getId() == personId) {
								isInDatabase = true;
								if (cache.size() == cacheStorage) {
									cache.remove(cache.getFirst());
								}
								cache.add(k);
								System.out.printf("\nPessoa encontrada no "
									+ "banco de \ndados e adicionada ao "
									+ "cache: \n%s \n", k);
							}
						}
					}

					if (!isInDatabase) {
						System.out.println("Não há uma pessoa com esse ID no "
							+ "banco de dados");
					}
					break;
				case 2:
					if (!database.isEmpty()) {
						System.out.println("Pessoas no banco de dados:");
						for (Person k : database) {
							System.out.println(k);
						}
					} else {
						System.out.println("O banco de dados está vazio");
					}
					break;
				case 3:
					if (!cache.isEmpty()) {
						System.out.println("Pessoas no cache:");
						for (Person k : cache) {
							System.out.println(k);
						}
						System.out.println("\nO cache armazena as últimas 10 "
							+ "pesquisas");
					} else {
						System.out.println("O cache está vazio");
					}
					break;
				case 4:
					int peopleCount;

					System.out.print("Quantas pessoas deseja adicionar ao "
						+ "banco? ");
					peopleCount = input.nextInt();

					for (int i = 1; i <= peopleCount; i++) {
						Person newPerson = new Person();

						input.nextLine();

						System.out.printf("Digite o nome da %dª pessoa: ", i);
						newPerson.setName(input.nextLine());

						System.out.printf("Digite a idade da %dª pessoa: ", i);
						newPerson.setAge(input.nextInt());

						if (!database.isEmpty()) {
							newPerson.setId(database.getLast().getId() + 1);
						} else {
							newPerson.setId(1);
						}

						database.add(newPerson);

						System.out.printf("Pessoa adicionada ao banco com o ID "
							+ "%d\n", newPerson.getId());
					}
					break;
				case 5:
					Person updatedPerson = new Person();

					System.out.print("Digite o ID da pessoa que deseja "
						+ "editar: ");
					personId = input.nextInt();

					for (Person k : database) {
						if (k.getId() == personId) {
							System.out.println(k);

							input.nextLine();

							updatedPerson.setId(k.getId());

							System.out.print("Digite o novo nome (ou repita o "
								+ "atual): ");
							updatedPerson.setName(input.nextLine());

							System.out.print("Digite a nova idade (ou repita a "
								+ "atual): ");
							updatedPerson.setAge(input.nextInt());

							database.set(database.indexOf(k), updatedPerson);

							for (Person l : cache) {
								if (l.getId() == personId) {
									cache.set(cache.indexOf(l), updatedPerson);
								}
							}

							System.out.printf("\nPessoa atualizada: \n%s \n",
								updatedPerson);
						}
					}
					break;
				case 6:
					isInDatabase = false;

					System.out.print("Digite o ID da pessoa que deseja remover "
						+ "do banco de dados: ");
					personId = input.nextInt();

					for (Person k : database) {
						if (k.getId() == personId) {
							isInDatabase = true;
							System.out.printf("Essa pessoa será removida do "
								+ "banco: \n%s \n", k);
							database.remove(k);
							break;
						}
					}

					for (Person k : cache) {
						if (k.getId() == personId) {
							cache.remove(k);
							break;
						}
					}

					if (!isInDatabase) {
						System.out.println("Não há uma pessoa com esse ID no "
							+ "banco de dados");
					}
					break;
				case 7:
					if (!cache.isEmpty()) {
						System.out.println("Limpando o cache...");
						cache.clear();
					} else {
						System.out.println("O cache está vazio");
					}
					break;
				case 8:
					if (!database.isEmpty()) {
						System.out.println("Limpando o banco de dados...");
						database.clear();
						cache.clear();
					} else {
						System.out.println("O banco de dados está vazio");
					}
					break;
				default:
					System.out.printf("%d não é uma opção aceita\n",
						menuOption);
					break;
			}
		}

		input.close();
	}
}
