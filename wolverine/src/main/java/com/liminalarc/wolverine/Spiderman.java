package com.liminalarc.wolverine;

public class Spiderman {

	private int energy;
	private int webFluid;
	private String name;
	private int age;

	public Spiderman(int energy, int webFluid, String name, int age) {
		if (name == null || name.isBlank())
			throw new IllegalArgumentException("Name cannot be empty.");
		if (energy <= 0)
			throw new IllegalArgumentException("Energy must be positive.");
		if (webFluid < 0)
			throw new IllegalArgumentException("Web fluid level cannot be negative.");
		this.energy = energy;
		this.webFluid = webFluid;
		this.name = name;
		this.age = age;
	}

	public Spiderman() {
		this(100, 100, "Peter Parker", 16);
	}

	public int getEnergy() {
		return energy;
	}

	public int getWebFluid() {
		return webFluid;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public boolean hasEnergyLeft() {
		return energy >= 1;
	}

	public void shootWeb() {
		if (webFluid < 12)
			throw new IllegalStateException("Not enough web fluid to shoot.");
		webFluid -= 12;
	}

	public void lexLutherInterceptsWebUsingSuperGirlsDogYo() {
		System.out.println("Bark");
		webFluid -= 50;
		energy = webFluid;
	}

	public void swing() {
		if (!hasEnergyLeft())
			throw new IllegalStateException("Spiderman has no energy left.");
		if (webFluid <= 0)
			throw new IllegalStateException("Spiderman has been defeated!");
		shootWeb();
		System.out.println("Weeeee!");
	}

	public void loseEnergy(int amount) {
        if (amount <= 0)
            throw new IllegalArgumentException("Energy loss must be positive.");

        energy = Math.max(0, energy - amount);
    }

}
