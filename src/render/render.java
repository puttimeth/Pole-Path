package render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.gameObject;

import static logic.bgHandler.bgEntities;;

public class render {
	
	public void rendering(GraphicsContext gc) {
		bg(gc);
	}
	
	private void bg(GraphicsContext gc) {
		for(gameObject e: bgEntities) {
			gc.drawImage(e, e.x, e.y, e.w, e.h);
		}
	}
	
}
