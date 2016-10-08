package week2;

public class DangerZone {
	public static java.util.Scanner scanner = new java.util.Scanner(System.in);
	private static boolean isRunning = true;
	static Pilot g = new Pilot("Goose", Rank.SENIOR_AIRMAN, 34);
	static Pilot i = new Pilot("Iceman", Rank.SENIOR_AIRMAN, 32);
	static Pilot f = new Pilot("Frank", Rank.AIRMAN, 29);
	static Pilot j = new Pilot("Jim", Rank.CAPTAIN, 42);
	static Pilot t = new Pilot("Tim", Rank.FIRST_LIEUTENANT, 39);
	static Pilot[] assigned = {g, i, f, j, t};
	//public Pilot(String name, Rank rank, int age){
	static Jet j1 = new Jet("F-35", 1200, 1379, 180000000, i);
	static Jet j2 = new Jet("B-21", 600, 6000, 550000000, g);
	static Jet j3 = new Jet("F-36", 1227, 1200, 98000000, f);
	static Jet j4 = new Jet("747", 600, 8350, 350000000, j);
	static Jet j5 = new Jet("F-22", 1500, 1840, 150000000, t);
	static Jet[] fleet = {j1, j2, j3, j4, j5};
	//	public Jet(String model, float speed, float range, float price, Pilot pilot) {
	static Pilot[] barracks = new Pilot[0];
	

	public static void main(String[] args) {
		
		while(isRunning){
			listOptions();
		}
		System.out.println("Program terminated.");
		scanner.close();
	}

	public static void listOptions() {
		System.out.println("OPTIONS:");
		System.out.println("  1) LIST FLEET");
		System.out.println("  2) VIEW FASTEST JET");
		System.out.println("  3) VIEW JET WITH LONGEST RANGE");
		System.out.println("  4) ADD JET TO FLEET");
		System.out.println("  5) SELL JET");
		System.out.println("  6) LIST PILOTS");
		System.out.println("  7) HIRE PILOT");
		System.out.println("  8) FIRE PILOT");
		System.out.println("  9) QUIT");
		System.out.print("INPUT: ");

		int input = scanner.nextInt();
		System.out.println("\n");
		switch (input) {
		case 1:
			listJets();
			break;
		case 2:
			viewFastest();
			break;
		case 3:
			viewLongest();
			break;
		case 4:
			addJet();
			break;
		case 5:
			sellJet();
			break;
		case 6:
			listPilots();
			break;
		case 7:
			hirePilot();
			break;
		case 8:
			firePilot();
			break;
		case 9:
			isRunning = false;
			break;
		default:
				System.out.println("Command not recognized.\n");
		}

	}

	public static void listJets() {

		for (int i = 0 ; i < fleet.length; i++) {
			System.out.println("JET "+(i+1)+")");
			fleet[i].displayJet();
		}

	}

	public static void viewFastest() {
		Jet f = new Jet();
		for (Jet j : fleet) {
			if (j.getSpeed() > f.getSpeed()) {
				f = j;
			}
		}
		System.out.println("\nFASTEST JET:");
		f.displayJet();
	}

	public static void viewLongest() {
		Jet l = new Jet();
		for (Jet j : fleet) {
			if (j.getRange() > l.getRange()) {
				l = j;
			}
		}
		System.out.println("\nLONGEST RANGED JET:");
		l.displayJet();
	}

	public static void addJet() {
		Jet[] biggerFleet = new Jet[fleet.length + 1];
		Pilot pilot = new Pilot();
		for (int i = 0; i < fleet.length; i++) {
			biggerFleet[i] = fleet[i];
		}

		System.out.println("INPUT JET INFORMATION:");
		System.out.print("1) MODEL:\t");
		String model = scanner.next();
		System.out.print("2) SPEED:\t");
		float speed = scanner.nextFloat();
		System.out.print("3) RANGE:\t");
		float range = scanner.nextFloat();
		System.out.print("4) PRICE:\t");
		long price = scanner.nextLong();
		
		if(barracks.length==0){
			hirePilot();
			pilot = assignPilot();
		}else{
			pilot = assignPilot();
		}
		
		biggerFleet[fleet.length] = new Jet(model, speed, range, price, pilot);
		fleet = biggerFleet;

		System.out.println("\nUPDATED FLEET:\n");
		listJets();

		// public Jet(String model, float speed, float range, float price, Pilot
		// pilot) {

	}

	public static void sellJet(){
		Jet[] smallerFleet = new Jet[fleet.length-1];
		Jet n = new Jet();
		
		listJets();
		System.out.println("\nCHOOSE JET TO SELL:");
		int input = scanner.nextInt();
		
		fleet[input-1] = n;
		int j = 0;
		for (int i = 0; i < fleet.length; i++) {
			if(fleet[i]!=n){
			smallerFleet[j] = fleet[i];
			j++;
			}
		}
		
		fleet = smallerFleet;
		
	}

	public static void listPilots(){
		
		System.out.println("\nUNASSIGNED PILOTS:");
		for(int i = 0; i<barracks.length ; i++){
			System.out.println("PILOT "+(i+1)+")");
			barracks[i].displayPilot();
		}
		System.out.println("\nASSIGNED PILOTS:");
		for(int i = 0; i<assigned.length ; i++){
			System.out.println("PILOT "+(i+1)+")");
			assigned[i].displayPilot();
		}
		
	}

	public static void hirePilot(){
		Pilot[] biggerBarracks = new Pilot[barracks.length+1];
		for (int i = 0; i < barracks.length; i++) {
			biggerBarracks[i] = barracks[i];
		}
		
		System.out.println("ENTER PILOT INFORMATION:");
		System.out.println("1) NAME:\t");
		String name = scanner.next();
		System.out.println("2) RANK:\t");
		System.out.println("  [Airman, Senior Airman, First Lieutenant, Second Lieutenant, Captain]");
		Rank rank = findRank(scanner.next());
		System.out.println("3) AGE:\t");
		int age = scanner.nextInt();
		
		biggerBarracks[barracks.length] = new Pilot( name,  rank,  age);
		barracks = biggerBarracks;
	}
	
	public static Rank findRank(String s){
		s = s.toUpperCase();
		
		if(s.startsWith("A")){
			return Rank.AIRMAN;
		}else if(s.startsWith("SEC")){
			return Rank.SECOND_LIEUTENANT;
		}else if(s.startsWith("SEN")){
			return Rank.SENIOR_AIRMAN;
		}else if(s.startsWith("F")){
			return Rank.FIRST_LIEUTENANT;
		}else if(s.startsWith("C")){
			return Rank.CAPTAIN;
		}else{
			System.err.println("Input not recognized. Default rank: AIRMAN.");
			return Rank.AIRMAN;
		}
		
	}

	public static void firePilot(){
		
		System.out.println("CHOOSE PILOT TO FIRE:\n");
		listPilots();
		int input = scanner.nextInt()-1;
		
		smallerBarracks(input);
		
	}
	
	public static void smallerBarracks(int input){
		
		Pilot[] smallerBarracks = new Pilot[barracks.length-1];
		Pilot n = new Pilot();
		
		barracks[input] = n;
		int j = 0;
		for (int i = 0; i < barracks.length; i++) {
			if(barracks[i]!=n){
			smallerBarracks[j] = barracks[i];
			j++;
			}
		}
		
		barracks = smallerBarracks;
		
	}

	public static Pilot assignPilot(){
		int pick = (int)((Math.random()*barracks.length));
		Pilot p = barracks[pick];
		Pilot [] biggerAssigned = new Pilot[assigned.length+1];
		for(int i = 0; i <assigned.length ; i++){
			biggerAssigned[i]=assigned[i];
		}
		
		biggerAssigned[assigned.length]=p;
		assigned = biggerAssigned;
		
		smallerBarracks(pick);
		
		return p;
	}
}
