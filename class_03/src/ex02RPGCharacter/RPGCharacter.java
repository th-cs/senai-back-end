// This class describes the character's attributes
package ex02RPGCharacter;

public class RPGCharacter {

	// Attributes
	private String name;
	private String chosenClass;
	private String[] classList = {"Guerreiro", "Mago", "Arqueiro", "Ladino",
		"Bardo", "Cavaleiro", "Clérigo", "Druída"};
	private int level;
	private int hp;
	private boolean isValidClass;
	private boolean isValidLevel;
	private boolean isValidHp;

	// Constructor
	public RPGCharacter(int level) {
		this.level = level;
	}

	// Getters
	public String getName() {
		return name;
	}

	public String getChosenClass() {
		return chosenClass;
	}

	public String[] getClassList() {
		return classList;
	}

	// Return a specific element
	public String getClassList(int i) {
		return classList[i - 1];
	}

	public int getLevel() {
		return level;
	}

	public int getHp() {
		return hp;
	}

	public boolean getIsValidClass() {
		return isValidClass;
	}

	public boolean getIsValidLevel() {
		return isValidLevel;
	}

	public boolean getIsValidHp() {
		return isValidHp;
	}

	// Setters
	public void setName(String name) {
		this.name = name;
	}

	public void setChosenClass(int i) {
		if (i >= 1 && i <= this.classList.length) {
			this.isValidClass = true;
			this.chosenClass = this.classList[i - 1];
		} else {
			System.out.println("Escolha uma das classes disponíveis");
		}
	}

	public void setLevel(int level) {
		if (level >= 1) {
			this.isValidLevel = true;
			this.level = level;
		} else {
			System.out.println("O nível do personagem deve ser maior ou igual "
				+ "a 1");
		}
	}

	public void setHp(int hp) {
		if (hp >= 0 && hp <= 100) {
			this.isValidHp = true;
			this.hp = hp;
		} else {
			System.out.println("A vida do personagem deve ser um valor entre "
				+ "0 e 100");
		}
	}

	public void setIsValidClass(boolean isValidClass) {
		this.isValidClass = isValidClass;
	}

	public void setIsValidLevel(boolean isValidLevel) {
		this.isValidLevel = isValidLevel;
	}

	public void setIsValidHp(boolean isValidHp) {
		this.isValidHp = isValidHp;
	}

}
