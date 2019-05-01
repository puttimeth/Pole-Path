package logic;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.input.KeyEvent;

public class EventHandler {
	
	public static EventHandler instance;
	public static List<KeyEvent> events;
	
	public static EventHandler getInstance() {
		if(instance == null) {
			instance = new EventHandler();
			events = new ArrayList<KeyEvent>();
			return instance;
		}
		return instance;
	}

}
