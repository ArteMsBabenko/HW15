package Lesson15;

import java.util.*;

public class Main {
	
	static void menu() {
		System.out.println();
		System.out.println("Enter 1 to register a new member of the zoo club");
		System.out.println("Enter 2 to add an animal to a zoo club member");
		System.out.println("Enter 3 to remove an animal from a zoo club member");
		System.out.println("Enter 4 to remove a member from the zoo club");
		System.out.println("Enter 5 to remove the entered animal from all members of the zoo club");
		System.out.println("Enter 6 to display the zoo club");
		System.out.println("Enter 0 to exit the program");
	}
	
	public static void main(String[] args) {
		
		ZooClub ZC = new ZooClub();
		Scanner sc = new Scanner(System.in);

		while (true) {
			menu();

			switch (sc.nextInt()) {

			case 1: {
				ZC.addMember();
				break;
			}

			case 2: {
				ZC.addAnimal();
				break;
			}

			case 3: {
				ZC.removeAnimal();
				break;
			}

			case 4: {
				ZC.removeZCMember();
				break;
			}

			case 5: {
				ZC.removeAnimalsFromAllMember();
				break;
			}

			case 6: {
				ZC.viewZC();
				break;
			}

			case 0: {
				System.exit(0);
				break;
			}

			default: {
				System.out.println("Введите число от 0 до 6!");
				break;
			}
			}
		}		
		
	}

}
