
public class ManagementCompany {
	static final int MGMT_DEPTH = 10;
	static final int MGMT_WIDTH = 10;
	static final int MAX_PROPERTY = 5;
	
	private String name;
	private String taxID;
	private double fee;
	private Plot plot;
	private Property array[] = new Property[MAX_PROPERTY];
	int count = 0;
	
	public ManagementCompany() {
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	}
	public ManagementCompany(String name, String taxID, double fee) {
		this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
	}
	public ManagementCompany(String name, String taxID, double fee, int x, int y, int width, int depth) {
		this.plot = new Plot(x, y, width, depth);
		this.name = name;
		this.taxID = taxID;
		this.fee = fee;
	}
	public ManagementCompany(ManagementCompany x) {
		this.name = x.name;
		this.taxID = x.taxID;
		this.fee = x.fee;
		this.array = x.array;
		this.plot = new Plot(x.plot.getX(), x.plot.getY(), x.plot.getWidth(), x.plot.getDepth());
	}
	
	//methods
	
	public int addProperty(String name, String city, double rent, String owner) {
		Property prop = new Property(name, city, rent, owner);
		if (count > 4) {
			return -1;
		}if (prop == null) 
			return -2;
		
		if (this.plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}for (int i = 0; i < count; i++) {
			if (array[i].getPlot().overlaps(prop.getPlot()) == true) {
				return -4;
			}
		}array[count] = prop;
		count++;
		return count - 1;
	}
		
	public int addProperty(String name, String city, double rent, String owner, int x, int y, int width, int depth) {
		Property prop = new Property(name, city, rent, owner, x, y, width, depth);
		
		if (this.count > 4) {
			return -1;
		}if (prop == null) {
			return -2;
		}if (this.plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}for (int i = 0; i < this.count; i++) {
			if (array[i].getPlot().overlaps(prop.getPlot())) {
				return -4;
			}
		}array[this.count] = prop;
		this.count++;
		return this.count - 1;
	}
	
	
	
	
	
	public int addProperty(Property property) {
		Property prop = new Property(property);
		
		if (this.count > 4) {
			return -1;
		}if (prop == null) {
			return -2;
		}if (this.plot.encompasses(prop.getPlot()) == false) {
			return -3;
		}for (int i = 0; i < this.count; i++) {
			if (array[i].getPlot().overlaps(prop.getPlot())) {
				return -4;
			}
		}array[this.count] = prop;
		this.count++;
		return this.count - 1;
	}
	
	
	
	
	
	public void removeLastProperty() {
		array[this.count] = null;
		this.count--;
	}
	
	public boolean isPropertiesFull() {
		if (this.count == 4) {
			return true;
		}return false;
	}
	

	public int getPropertiesCount() {
		return this.count;
	}
	
	public double getTotalRent() {
		double r = 0;
		for (int i = 0; i< this.count; i++) {
			r += array[i].getRentAmount();
		}return r;
	}
	public Property getHighestRentPropperty() {
		int n = -1;
		double m = -1.0;
		for (int i = 0; i < this.count; i++) {
			if (array[i].getRentAmount() > m) {
				n = i;
				m = array[i].getRentAmount();
			}
		}return array[n];
	}
	
	
	
	public boolean isMangementFeeValid() {
		if (this.getMgmFeePer() > 100 || this.getMgmFeePer() < 0) {
			return false;
		}return true;
	}
	
	public String getName() {
		return this.name;
	}

	public String getTaxID() {
		return this.taxID;
	}
	
	public Property[] getProperties() {
		return this.array;
	}
	
	public double getMgmFeePer() {
		return this.fee;
	}
	
	public Plot getPlot() {
		return this.plot;
	}
	
	public String toString() {
		String s = new String();
		s+= this.name+","+this.taxID;
		for (int i = 0; i < this.count; i++) {
			s+= array[i].toString();
			if (i < this.count) {
				s+=",";
			}
		}return s;
	}
	

}
