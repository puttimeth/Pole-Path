package character;

import logic.InteractiveGameObjectType;

public class Penguin extends Character {
		
	public Penguin(String url, double x, double y, double w, double h) {
		super(url, x, y, w, h, InteractiveGameObjectType.PENGUIN);
	}

	@Override
	public void abilityHandler() {
		
	}

}
