package week2;

public class Pilot {

	private String name;
	private Rank rank;
	private int age;
	
	public Pilot(){
		this("John Smith", Rank.AIRMAN, 25);
	}
	public Pilot(String name){
		this(name, Rank.AIRMAN, 25);
	}
	public Pilot(String name, Rank rank){
		this(name, rank, 25);
	}
	public Pilot(String name, Rank rank, int age){
		this.name = name;
		this.rank = rank;
		this.age = age;
	}
	
	public void displayPilot(){
		System.out.println("  Name-\t\t"+this.getName());
		System.out.println("  Rank-\t\t"+this.getRank());
		System.out.println("  Age-\t\t"+this.getAge());
		System.out.println();
		
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	

}
