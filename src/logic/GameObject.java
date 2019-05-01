package logic;
import javafx.scene.image.Image;

public class GameObject extends Image {

	public double x,y,w,h;

	public GameObject(String url, double x, double y, double w, double h) {
		super(url);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	

}
