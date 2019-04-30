package logic;

public abstract class character extends gameObject {
	
	private double xc, yc, wc, hc;

	public character(String url, double x, double y, double w, double h) {
		super(url, x, y, w, h);
	}
	
}
