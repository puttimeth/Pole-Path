package render;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import logic.GameObject;

import static logic.BGHandler.bgEntities;;

public class render {
	
	public void rendering(GraphicsContext gc) {
		// bg		
		bg(gc);
		// obstacle
		// character
	}
	
	private void bg(GraphicsContext gc) {
		for(GameObject e: bgEntities) {
			gc.drawImage(e, e.x, e.y, e.w, e.h);
		}
	}
	
}
