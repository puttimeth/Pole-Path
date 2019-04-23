import java.util.Random;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class test extends Application {
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		/*Button player = new Button();
		ImageView player_image = new ImageView(ClassLoader.getSystemResource("square.png").toString());
		player.setGraphic(player_image);
		GridPane root = new GridPane();
		root.add(player_image,0,0);
		Scene scene = new Scene(root,500,500);
		primaryStage.setScene(scene);
		primaryStage.show();*/
		StackPane root = new StackPane();
		Button b1 = new Button("b1");
		Button b2 = new Button("b2");
		b2.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				root.getChildren().remove(b2);
			}
		});
		root.getChildren().addAll(b1,b2);
		primaryStage.setScene(new Scene(root));
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		for(int i=0;i<10;i++) {
			System.out.println(new Random().nextInt());
		}
	}

}
