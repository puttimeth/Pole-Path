package logic;

import static main.mainTest.SPEED;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import main.mainTest;

public class BGHandler implements Renderable {
	
	public static final List<GameObject> bgEntities = new ArrayList<GameObject>();
	
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
	
	private boolean isDestroy(GameObject go) {
		if(go.x < -go.w)	return true;
		return false;
	}
	
	private void move(GameObject go) {
		go.x += SPEED;
	}
	
	public void generateInitialBG() {
		for(int i=0;i<50;i++) {
			String url = ClassLoader.getSystemResource("bg"+(new Random().nextInt(4)+1)+".png").toString();
			GameObject bg = new GameObject(url, i * mainTest.SCREEN_WIDTH, 0, mainTest.SCREEN_WIDTH, mainTest.SCREEN_HEIGHT);
			bgEntities.add(bg);
		}
	}
	
	public void generateBG() {
		String url = ClassLoader.getSystemResource("bg"+(new Random().nextInt(4)+1)+".png").toString();
		GameObject bg = new GameObject(url, 49 * mainTest.SCREEN_WIDTH, 0, mainTest.SCREEN_WIDTH, mainTest.SCREEN_HEIGHT);
		bgEntities.add(bg);
	}
	
}
