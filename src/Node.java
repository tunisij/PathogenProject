import java.util.ArrayList;
import java.util.List;


public class Node {

	private int health;
	private int xLocation;
	private int yLocation;
	private int income;
	private boolean infected = false;
	private boolean dead = false;
	private boolean navigated = false;
	private String city;
	private List<Integer> related = new ArrayList<>();
		
	public Node(int h, int x, int y, int i, String c){
		health = h;
		xLocation = x;
		yLocation = y;
		income = i;
		city = c;
	}
	
	public int getHealth(){
		return health;
	}
	
	public int getxLocation(){
		return xLocation;
	}
	
	public int getyLocation(){
		return yLocation;
	}
	
	public int getincome(){
		return income;
	}
	
	public boolean getInfected(){
		return infected;
	}
	
	public boolean getDead(){
		return dead;
	}
	
	public boolean getNavigated(){
		return navigated;
	}
	
	public String getCity(){
		return city;
	}
	
	public List<Integer> getRelated(){
		return related;
	}
	
	public void setHealth(int i){
		health = i;
	}
	
	public void setInfected(boolean b){
		infected = b;
	}
	
	public void setNavigated(boolean b){
		navigated = b;
	}
	
	public void setDead(){
		dead = true;
	}
	
	public void addRelated(int i){
		related.add(i);
	}
	
}
