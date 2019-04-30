package logic;

public class interactiveGameObject extends gameObject {
	
	private double xc, yc, wc, hc;
	private interactiveGameObjectType type;

	public interactiveGameObject(String url, double x, double y, double w, double h, interactiveGameObjectType type) {
		super(url, x, y, w, h);
		this.type = type;
	}
	
	private void setCollider() {
	}
	
}
