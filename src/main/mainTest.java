package main;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import logic.bgHandler;
import logic.gameObject;
import render.render;

public class mainTest extends Application {
	
	public static final double SCREEN_WIDTH = 500, SCREEN_HEIGHT = 250;
	public static double SPEED = -3;
	
	List<gameObject> bgList;
	bgHandler bgHandle;
	render rend;
	Label bgLabel;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		Canvas canvas = new Canvas(SCREEN_WIDTH, SCREEN_HEIGHT);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		StackPane root = new StackPane(canvas);
		bgLabel = new Label();
		HBox hbox = new HBox(bgLabel);
		hbox.setAlignment(Pos.TOP_CENTER);
		hbox.setPadding(new Insets(20));
		bgLabel.setFont(new Font(15));
		root.getChildren().add(hbox);
		Scene scene = new Scene(root);
		setUp(gc);
		loop(gc);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void initializeList() {
		bgList = new ArrayList<gameObject>();
	}
	
	public void setUp(GraphicsContext gc) {		
		bgHandle = new bgHandler();
		rend = new render();
		bgHandle.generateInitialBG();
	}
	
	public void loop(GraphicsContext gc) {
		new AnimationTimer() {
			int timer = 0;			
			@Override
			public void handle(long arg0) {
				// bgLabel update
				bgLabel.setText("bgEntitiesCount:"+bgHandler.bgEntities.size());
				/*if(timer % 500 == 0) {
					bgHandle.generateBG();
				}*/
				bgHandle.update();
				rend.rendering(gc);
				timer++;
			}
		}.start();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
