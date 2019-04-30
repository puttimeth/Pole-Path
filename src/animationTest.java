import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class animationTest extends Application {
	
	Image player;
	Image[] playerAnim;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		StackPane root = new StackPane();
		Canvas canvas = new Canvas(500,500);
		GraphicsContext gc = canvas.getGraphicsContext2D();
		setPlayerAnim();
		String url = ClassLoader.getSystemResource("adventurer-idle-00.png").toString();
		player = new Image(url);
		root.getChildren().addAll(canvas);
		Scene scene = new Scene(root);
		loop(gc);
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	public void loop(GraphicsContext gc) {
		new AnimationTimer() {
			int index = 0, time = 0;
			@Override
			public void handle(long now) {
				if(time % 20 == 0) {
					gc.clearRect(0, 0, 500, 500);
					gc.drawImage(playerAnim[index], 200, 200, 100, 74);
					index++;
					if(index > 2)	index = 0;
				}
				time++;
			}
		}.start();;
	}
	
	public void setPlayerAnim() {
		playerAnim = new Image[3];
		for(int i=0;i<3;i++) {
			Image img = new Image(ClassLoader.getSystemResource("adventurer-idle-0"+i+".png").toString());
			playerAnim[i] = img;
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}

}
