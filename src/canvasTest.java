import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class canvasTest extends Application {
	
	private static double CANVAS_HEIGHT = 500, CANVAS_WIDTH = 500;
	
	Canvas canvas;
	GraphicsContext gc;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		Scene scene = new Scene(root);
		canvas = new Canvas(CANVAS_WIDTH, CANVAS_HEIGHT);
		gc = canvas.getGraphicsContext2D();
		root.getChildren().add(canvas);
		gc.drawImage(new Image(ClassLoader.getSystemResource("player.jpg").toString()), 0, 0);
		addEventHandler();
		canvas.setFocusTraversable(true);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	public void animate() {
		new AnimationTimer() {
			
			@Override
			public void handle(long arg0) {
				Image img = new Image(ClassLoader.getSystemResource("square.png").toString());
				gc.drawImage(img, new Random().nextInt((int)CANVAS_WIDTH) - (img.getWidth()/2), new Random().nextInt((int)CANVAS_HEIGHT) - (img.getHeight()/2));
			}
		}.start();
	}
	
	public void addEventHandler() {
		canvas.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				if(event.getCode() == KeyCode.W) {
					gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
					gc.translate(0, -5);
					Image img = new Image(ClassLoader.getSystemResource("square.png").toString());
					gc.drawImage(img, 0, 0);
					System.out.println("UP");
				}
				if(event.getCode() == KeyCode.A) {
					gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
					gc.translate(-5, 0);
					Image img = new Image(ClassLoader.getSystemResource("square.png").toString());
					gc.drawImage(img, 0, 0);
					System.out.println("LEFT");
				}
				if(event.getCode() == KeyCode.D) {
					gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
					gc.translate(5, 0);
					Image img = new Image(ClassLoader.getSystemResource("square.png").toString());
					gc.drawImage(img, 0, 0);
					System.out.println("RIGHT");
				}
				if(event.getCode() == KeyCode.S) {
					gc.clearRect(0, 0, CANVAS_WIDTH, CANVAS_HEIGHT);
					gc.translate(0, 5);
					Image img = new Image(ClassLoader.getSystemResource("square.png").toString());
					gc.drawImage(img, 0, 0);
					System.out.println("DOWN");
				}
				
			}
		});
	}

}
