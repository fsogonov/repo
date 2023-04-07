public class Plot {
	private int x;
	private int y;
	private int depth;
	private int width;
	
	public Plot() {
		this.x = 0;
		this.y = 0;
		this.width = 1;
		this.depth = 1;
	}
	public Plot (int a, int b, int w, int d) {
		this.x = a;
		this.y = b;
		this.width = w;
		this.depth = d;
	}
	public Plot (Plot k) {
		this.x = k.x;
		this.y = k.y;
		this.width = k.width;
		this.depth = k.depth;
	}
	
	//methods
	public boolean overlaps(Plot plot) {
		if (this.x > plot.getX() + plot.getWidth() || plot.getX() > this.x + this.width)
	        return false;

	    if (this.y > plot.getY() + plot.getDepth() || plot.getY() > this.y + this.width)
	        return false;
//	    if (this.encompasses(plot) == true) 
	//    	return false;
	    
	    return true;
	}
	
	public boolean encompasses(Plot plot) {
		if (this.x <= plot.getX() && this.y <= plot.getY() && this.x + this.width >= plot.getX() + plot.getWidth() && this.y + this.depth >= plot.getY() + plot.getDepth()) {
			return true;
		}return false;
	}
	
	public void setX(int a) {
		this.x = a;
	}
	
	public void setY(int a) {
		this.y = a;
	}
	
	public void setWidth(int a) {
		this.width = a; 
	}
	
	public void setDepth(int a) {
		this.depth = a;
	}

	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public int getWidth() {
		return this.width;
	}
	
	public int getDepth() {
		return this.depth;
	}
	
	public String toString() {
		String s = new String();
		s = this.getX() + "," + this.getY() + "," + this.getWidth() + "," + this.getDepth();
		return s;
	}
	
}





















