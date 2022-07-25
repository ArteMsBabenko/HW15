package Lesson15;

import java.util.Objects;

public class Animals {
	
	private String species;
	private String name;
	
	public Animals(String species, String name) {
		this.species=species;
		this.name=name;
	}

	public String getSpecies() {
		return species;
	}

	public void setSpecies(String species) {
		this.species = species;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, species);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Animals other = (Animals) obj;
		return Objects.equals(name, other.name) && Objects.equals(species, other.species);
	}

	@Override
	public String toString() {
		return "Animals [species=" + species + ", name=" + name + "]";
	}

}
