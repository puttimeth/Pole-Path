package logic;

public class Collider {
	
	private double xc, yc, wc, hc;
	
	public Collider(double xc, double yc, double wc, double hc) {
		this.xc = xc;
		this.yc = yc;
		this.wc = wc;
		this.hc = hc;
	}
	EventHandler e = new EventHandler();
	
	public static boolean isCollide(Collider c1, Collider c2) {
		boolean isCollideX = false, isCollideY = false;
		if(		c1.xc 		>= c2.xc && c1.xc 		<= c2.xc + c2.wc)	isCollideX = true;
		if(c1.xc + c1.wc >= c2.xc && c1.xc + c1.wc 	<= c2.xc + c2.wc) isCollideX = true;
		if(c1.yc 		>= c2.yc && c1.yc 		<= c2.yc + c2.hc) isCollideY = true;
		if(c1.yc + c1.hc >= c2.yc && c1.yc + c1.hc 	<= c2.yc + c2.hc) isCollideY = true;
		return isCollideX && isCollideY;
	}

}
