package character;

import logic.InteractiveGameObject;
import logic.InteractiveGameObjectType;

public abstract class Character extends InteractiveGameObject implements Ability{
	
	private boolean useAbility, isGround, isSquat;

	public Character(String url, double x, double y, double w, double h, InteractiveGameObjectType type) {
		super(url, x, y, w, h, type);
	}
	
	public void updateCharacter() {
		if(useAbility)	abilityHandler();
		else normalHandler();
	}
	
	public void normalHandler() {
		// move
	}
	
	public void abilityHandler() {
		// ability
	}
	
	public boolean useAbility() {
		return useAbility;
	}

	public boolean isGround() {
		return isGround;
	}

	public boolean isSquat() {
		return isSquat;
	}
	
}
