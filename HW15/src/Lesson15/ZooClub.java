package Lesson15;

import java.util.*;
import java.util.Map.Entry;

public class ZooClub {
	
	Map<Person, ArrayList<Animals>> ZC = new HashMap<Person, ArrayList<Animals>>();
	
	public void addMember( ) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the name of the zoo club member:");
		String name = sc.next();
		System.out.println("Enter the age of the zoo club member:");
		int age = sc.nextInt();
		
		Person ZCMember = new Person(name, age);
		
		ZC.put(ZCMember, new ArrayList<Animals>());
		System.out.println(ZCMember.toString()+ "successfully registered in the zoo club");	
	}

	public void addAnimal() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the name of the zoo club member:");
		String name = sc.next();
		System.out.println("Enter the age of the zoo club member:");
		int age = sc.nextInt();
		
		boolean Correct = isZooClubMemberExists(ZC, name, age);
		
		if (Correct) {
			System.out.println("Enter animal:");
			String species = sc.next();
			System.out.println("Enter the name of the animal:");
			String animalName = sc.next();
			
			Animals newAnimal = new Animals(species, animalName);
			
			Iterator<Entry<Person, ArrayList<Animals>>> it = ZC.entrySet().iterator();
			
			while(it.hasNext()) {
				Entry<Person,ArrayList<Animals>> nextMember = it.next();
				
				if(nextMember.getKey().getName().equalsIgnoreCase(name)&& nextMember.getKey().getAge() ==age) {
					ArrayList<Animals> animalsList = nextMember.getValue();
					
					animalsList.add(newAnimal);
					System.out.println("Animal " + newAnimal.toString() + " successfully added to member "
							+ nextMember.getKey());
				}
			}
		}
		else {
			System.out.println("The entered member is not a member of the zoo club");
		}
	}
	
	public void removeAnimal( ) {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the name of the zoo club member:");
		String name = sc.next();
		System.out.println("Enter the age of the zoo club member:");
		int age = sc.nextInt();
		
		boolean Correct = isZooClubMemberExists(ZC, name, age);
		
		if(Correct) {
		
		System.out.println("Enter animal:");
		String species = sc.next();
		System.out.println("Enter the name of the animal:");
		String animalName = sc.next();
		
		boolean AnimalCorrect = isZCMemberAnimalExists(ZC, name, age, species, animalName);
		
		if(AnimalCorrect) {
			Iterator<Entry<Person, ArrayList<Animals>>> it=ZC.entrySet().iterator();
			
			while(it.hasNext()) {
				Entry<Person,ArrayList<Animals>> nextMember=it.next();
				
				if(nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() ==age) {
					ArrayList<Animals> animalsList = nextMember.getValue();
					
					Iterator<Animals> it2 =animalsList.iterator();
					
					while(it2.hasNext()) {
						Animals next2 = it2.next();
						
						if(next2.getSpecies().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
							it2.remove();
							System.out.println("Animal " + next2.toString() + " successfully removed from member "+ nextMember.getKey());
							
						}
					}
				}
			}
		}
		else {
			System.out.println("Entered animal does not belong to this zoo member");
		}
		
	   }
		else {
			System.out.println("Entered member is not a member of the zoo");
		}
	}
	
	public void removeZCMember() {
		Scanner sc =new Scanner(System.in);
		System.out.println("Enter the name of the zoo club member:");
		String name = sc.next();
		System.out.println("Enter the age of the zoo club member:");
		int age = sc.nextInt();
		
		boolean Correct = isZooClubMemberExists(ZC, name, age);
		
		if(Correct) {
			Iterator<Entry<Person, ArrayList<Animals>>> it = ZC.entrySet().iterator();
			
			while(it.hasNext()) {
				Entry<Person,ArrayList<Animals>> nextMember=it.next(); 
				
				if(nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
					it.remove();
					System.out.println(nextMember.getKey().toString() + " successfully removed from the zoo club");
				}
			}
		}
		else {
			System.out.println("Entered member is not a member of the zoo club");
		}
	}
	
	public void removeAnimalsFromAllMember() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter animal:");
		String species = sc.next();
		
		Iterator<Entry<Person, ArrayList<Animals>>> it = ZC.entrySet().iterator();
		
		while(it.hasNext()) {
			Entry<Person, ArrayList<Animals>> nextMember = it.next();

			ArrayList<Animals> animaslList = nextMember.getValue();

			Iterator<Animals> it2 = animaslList.iterator();
			
			while(it2.hasNext()) {
				Animals next2 =it2.next();
				
				if(next2.getSpecies().equalsIgnoreCase(species)) {
					it2.remove();
					System.out.println("Animal " + next2.toString() + " successfully removed from member "
							+ nextMember.getKey() );
				}
			}
		}
	}
	
	public void viewZC() {
		Set<Entry<Person, ArrayList<Animals>>> ZCMembers = ZC.entrySet();
		
		System.out.println("The members of the zoo club are:");
		for (Entry<Person, ArrayList<Animals>> entry : ZCMembers) {
		System.out.println("Participant " + entry.getKey() + " has " + entry.getValue());
		}
	}
	
	static boolean isZooClubMemberExists(Map<Person, ArrayList<Animals>> ZC, String name, int age) {
		boolean flag = false;

		Set<Entry<Person, ArrayList<Animals>>> ZCMembers = ZC.entrySet();

		for (Entry<Person, ArrayList<Animals>> entry : ZCMembers) {
			if (entry.getKey().getName().equalsIgnoreCase(name) && entry.getKey().getAge() == age) {
				flag = true;
			}
		}

		return flag;
	}

	static boolean isZCMemberAnimalExists(Map<Person, ArrayList<Animals>> ZC, String name, int age,
			String species, String animalName) {
		boolean flag = false;

		Iterator<Entry<Person, ArrayList<Animals>>> it = ZC.entrySet().iterator();

		while (it.hasNext()) {
			Entry<Person, ArrayList<Animals>> nextMember = it.next();

			if (nextMember.getKey().getName().equalsIgnoreCase(name) && nextMember.getKey().getAge() == age) {
				ArrayList<Animals> animaslList = nextMember.getValue();

				Iterator<Animals> it2 = animaslList.iterator();

				while (it2.hasNext()) {
					Animals next2 = it2.next();

					if (next2.getSpecies().equalsIgnoreCase(species) && next2.getName().equalsIgnoreCase(animalName)) {
						flag = true;
					}
				}
			}
		}

		return flag;
	}
	
}
