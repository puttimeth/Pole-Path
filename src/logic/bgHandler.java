package logic;

import static main.mainTest.SPEED;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.mainTest;

public class bgHandler implements Renderable {
	
	public static final List<gameObject> bgEntities = new ArrayList<gameObject>();
	
	@Override
	public void update() {
		// generate new bg if need
		// move all bg in the list
		// destroy bg if need
		for(int i=bgEntities.size()-1; i >=0; i--) {
			if(isDestroy(bgEntities.get(i))) {
				bgEntities.remove(i);
				generateBG();
			}
			else {
				move(bgEntities.get(i));
			}
		}
	}
	
	private boolean isDestroy(gameObject go) {
		if(go.x < -go.w)	return true;
		return false;
	}
	
	private void move(gameObject go) {
		go.x += SPEED;
	}
	
	public void generateInitialBG() {
		for(int i=0;i<3;i++) {
			String url = ClassLoader.getSystemResource("bg"+(new Random().nextInt(3)+1)+".jpg").toString();
			gameObject bg = new gameObject(url, i * mainTest.SCREEN_WIDTH, 0, mainTest.SCREEN_WIDTH, mainTest.SCREEN_HEIGHT);
			bgEntities.add(bg);
		}
	}
	
	public void generateBG() {
		String url = ClassLoader.getSystemResource("bg"+(new Random().nextInt(3)+1)+".jpg").toString();
		gameObject bg = new gameObject(url, 2 * mainTest.SCREEN_WIDTH, 0, mainTest.SCREEN_WIDTH, mainTest.SCREEN_HEIGHT);
		bgEntities.add(bg);
	}
	
}
