import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import logic.gameObject;

public class endlessRunTest extends Application {
	
	List<gameObject> goList;
	Random rd;
	gameObject player;
	HBox infoBox;
	Label overlapLabel, goCountLabel;
	
	static double SPEED = -3, SCREEN_WIDTH = 500, SCREEN_HEIGHT = 500;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		goList = new ArrayList<gameObject>();
		rd = new Random();
		StackPane root = new StackPane();
		infoBox = new HBox();
		overlapLabel = new Label();
		goCountLabel = new Label();
		infoBox.getChildren().addAll(overlapLabel,goCountLabel);
		infoBox.setAlignment(Pos.TOP_CENTER);
		infoBox.setPadding(new Insets(15));
		infoBox.setSpacing(15);
		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		root.getChildren().addAll(canvas,infoBox);
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
					//normal time_mod;
					time_mod = (int) (rd.nextDouble() * 50) + 40;
					//test time_mod
					time_mod = (int) (rd.nextDouble() * 28) + 2;
				}
				updatePos();
				updateGraphic(gc);
			}
		}.start();;
	}
	
	public void updatePos() {
		List<gameObject> removeList = new ArrayList<gameObject>();
		for(gameObject e: goList) {
			e.x += SPEED;
			if(isDestroy(e)) {
				removeList.add(e);
			}
		}
		for(gameObject e: removeList) {
			if(goList.contains(e)) {
				goList.remove(e);
			}
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
		goCountLabel.setText("gameObject count:" + goList.size());
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
	
	public boolean isDestroy(gameObject o) {
		if(o.x < 0 - o.w)	return true;
		return false;
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}