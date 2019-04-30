package logic;
import javafx.scene.image.Image;

public class gameObject extends Image {

	public double x,y,w,h;

	public gameObject(String url, double x, double y, double w, double h) {
		super(url);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	

}
