// Read the name, class, level and HP to create an RPG character. Then return
// the attributes
package ex02RPGCharacter;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {

		boolean isMenuOpen;
		int menuOption;

		Scanner input = new Scanner(System.in);

		// Create a Lv 1 character
		RPGCharacter character = new RPGCharacter(1);

		System.out.println("-- Criação de Personagem --\n");

		isMenuOpen = true;

		while(isMenuOpen) {
			System.out.print("Olá, como o seu personagem vai se chamar? ");
			character.setName(input.nextLine());

			do {
				System.out.println("Escolha a classe do seu personagem:");
				for (int i = 1; i <= character.getClassList().length; i++) {
					System.out.printf("| %d | - %s\n", i,
						character.getClassList(i));
				}
				character.setChosenClass(input.nextInt());
			} while (!character.getIsValidClass());

			do {
				System.out.print("Qual será o nível inicial do seu "
					+ "personagem ( >= 1 ) ? ");
				character.setLevel(input.nextInt());
			} while(!character.getIsValidLevel());

			do {
				System.out.print("Qual será o HP inicial do seu personagem "
					+ "( >= 0 - 100 <= ) ? ");
				character.setHp(input.nextInt());
			} while(!character.getIsValidHp());

			System.out.printf("\nNome do personagem: %s\n"
				+ "Classe: %s\n"
				+ "Nível inicial: Lv %d\n"
				+ "HP inicial: %d HP\n", character.getName(),
				character.getChosenClass(), character.getLevel(),
				character.getHp());

			if (character.getHp() == 0) {
				System.out.println("O seu personagem tá morto, foi de base, "
					+ "não tankou, virou lost media");
			}

			do {
				System.out.println("\nComo deseja continuar?\n"
					+ "| 1 | - Concluir personagem\n"
					+ "| 2 | - Atualizar personagem");
				menuOption = input.nextInt();

				switch (menuOption) {
					case 1:
						System.out.println("Personagem criado!");
						System.out.println("Saindo da criação de "
							+ "personagem...");
						isMenuOpen = false;
						break;
					case 2:

						// Reset attributes
						character.setName("");
						character.setIsValidClass(false);
						character.setIsValidLevel(false);
						character.setIsValidHp(false);

						// Clear buffer
						input.nextLine();
						break;
					default:
						System.out.printf("%d não é uma opção aceita\n",
							menuOption);
						break;
				}
			} while(menuOption < 1 || menuOption > 2);

		}

		input.close();
	}
}
