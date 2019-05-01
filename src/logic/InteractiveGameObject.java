package logic;

import java.util.List;
import java.util.ArrayList;

public class InteractiveGameObject extends GameObject {
	
	private List<Collider> colliderList;
	private InteractiveGameObjectType type;

	public InteractiveGameObject(String url, double x, double y, double w, double h, InteractiveGameObjectType type) {
		super(url, x, y, w, h);
		this.type = type;
		setCollider(this.type);
	}
	
	private void setCollider(InteractiveGameObjectType type) {
		colliderList = new ArrayList<Collider>();
		// add Collider to colliderList by type
	}
	
}
