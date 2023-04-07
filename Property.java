public class Property {
	private String propertyName;
	private String city;
	private double rentAmount;
	private String owner;
	private Plot plot;
	
	public Property() {
		this.plot = new Plot(0, 0, 1, 1);
	}
	
	public Property(String propertyName, String city, double rentAmount, String owner) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(0, 0, 1, 1);
	}
	public Property(String propertyName, String city, double rentAmount, String owner, int x, int y, int w, int d) {
		this.propertyName = propertyName;
		this.city = city;
		this.rentAmount = rentAmount;
		this.owner = owner;
		this.plot = new Plot(x, y, w, d);
	}
	public Property(Property x) {
		this.propertyName = x.propertyName;
		this.city = x.city;
		this.rentAmount = x.rentAmount;
		this.owner = x.owner;
		this.plot = new Plot(x.getPlot().getX(), x.getPlot().getY(), x.getPlot().getWidth(), x.getPlot().getDepth());
	}
	public Plot getPlot() {
		return this.plot;
	}
	
	public String getPropertyName() {
		return this.propertyName;
	}
	
	public String getCity() {
		return this.city;
	}
	
	public double getRentAmount() {
		return this.rentAmount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public String toString() {
		String s = new String();
		s = this.getPropertyName() + "," + this.getCity() + "," + this.getOwner() + "," + this.getRentAmount();
		return s;
	}
}























