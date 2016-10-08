package week2;

public class Jet {

	private String model;
	private float speed;
	private float range;
	private long price;
	private Pilot pilot;

	public Jet() {
		this("", 0.0F, 0.0F, 0, null);
	}

	public Jet(String model) {
		this(model, 0.0F, 0.0F, 0, null);
	}

	public Jet(String model, float speed) {
		this(model, speed, 0.0F, 0, null);
	}

	public Jet(String model, float speed, float range) {
		this(model, speed, range, 0, null);
	}

	public Jet(String model, float speed, float range, long price) {
		this(model, speed, range, price, null);
		this.pilot = new Pilot();
	}

	public Jet(String model, float speed, float range, long price, Pilot pilot) {
		this.model = model;
		this.speed = speed;
		this.range = range;
		this.price = price;
		this.pilot = pilot;
	}
	
	public void displayJet(){
		System.out.println("  Model-\t"+this.getModel());
		System.out.println("  Speed-\tMach "+this.getSpeed());
		System.out.println("  Range-\t"+this.getRange()+" miles");
		int inMil = (int)(this.getPrice()/1000000);
		System.out.println("  Price-\t$"+inMil+" million");
		System.out.println("PILOT:");
		this.pilot.displayPilot();
		
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public float getSpeed() {
		return speed * 0.00130332F;
	}

	public void setSpeed(float speed) {
		this.speed = speed;
	}

	public float getRange() {
		return range;
	}

	public void setRange(float range) {
		this.range = range;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(long price) {
		this.price = price;
	}

	public Pilot getPilot() {
		return pilot;
	}

	public void setPilot(Pilot pilot) {
		this.pilot = pilot;
	}

}
