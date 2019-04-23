import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class endlessRunTest extends Application {
	
	List<gameObject> goList;
	Random rd;
	gameObject player;
	Label overlapLabel;
	
	static double SPEED = -3, SCREEN_WIDTH = 500, SCREEN_HEIGHT = 500;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		goList = new ArrayList<gameObject>();
		rd = new Random();
		StackPane root = new StackPane();
		overlapLabel = new Label("overlap:");
		BorderPane info = new BorderPane(overlapLabel);
		BorderPane.setAlignment(overlapLabel, Pos.TOP_CENTER);
		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas,info);
		generatePlayer();
		Scene scene = new Scene(root);
		loop(gc);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void loop(GraphicsContext gc) {
		
		new AnimationTimer() {
			int time = 0, time_mod = 1;
			@Override
			public void handle(long now) {
				time++;
				if(time % time_mod == 0) {
					generateGameObject();
					// re Timer
					time = 0;
					//time_mod = 10000;
					time_mod = (int) (rd.nextDouble() * 50) + 40;
				}
				updatePos();
				updateGraphic(gc);
			}
		}.start();;
	}
	
	public void updatePos() {
		for(gameObject e: goList) {
			e.x += SPEED;
		}
	}
	
	public void updateGraphic(GraphicsContext gc) {
		int overlapCount = 0;
		gc.clearRect(0, 0, SCREEN_WIDTH, SCREEN_HEIGHT);
		for(gameObject e : goList) {
			gc.drawImage(e, e.x, e.y);
			if(isCollide(e, player))	{
				overlapCount++;
			}
		}
		gc.drawImage(player, player.x, player.y);
		overlapLabel.setText("overlap:"+overlapCount);
	}
	
	public void generateGameObject() {
		String name[] = {"red.png","green.png","blue.png"};
		int index = rd.nextInt(name.length);
		String url = ClassLoader.getSystemResource(name[index]).toString();
		gameObject go = new gameObject(url,500,rd.nextDouble() * 300 + 100,50,50);
		goList.add(go);
	}
	
	public void generatePlayer() {
		player = new gameObject(ClassLoader.getSystemResource("blue.png").toString(), 20, 225, 50, 50);
	}
	
	public boolean isCollide(gameObject o1, gameObject o2) {
		boolean isOverlapX = false, isOverlapY = false;
		if(		o1.x 		>= o2.x && o1.x 		<= o2.x + o2.w)	isOverlapX = true;
		if(o1.x + o1.w >= o2.x && o1.x + o1.w 	<= o2.x + o2.w) isOverlapX = true;
		if(o1.y 		>= o2.y && o1.y 		<= o2.y + o2.h) isOverlapY = true;
		if(o1.y + o1.h >= o2.y && o1.y + o1.h 	<= o2.y + o2.h) isOverlapY = true;
		return isOverlapX && isOverlapY;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}

class gameObject extends Image {

	public double x,y,w,h;
	
	public gameObject(String url) {
		super(url);
		this.x = 0;
		this.y = 0;
		this.w = 50;
		this.h = 50;
	}
	
	public gameObject(String url, double x, double y) {
		super(url);
		this.x = x;
		this.y = y;
		this.w = 50;
		this.h = 50;
	}

	public gameObject(String url, double x, double y, double w, double h) {
		super(url);
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
	}
	

}
