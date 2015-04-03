import java.util.Random;


public class Machine {
	
	private int population;
	private int countDead;
	private int countInfected;
	private int countDays;
	private String[] cities;
	private Node[] all;
	
	public Machine(){
		cities = new String[5];
		cities[0] = "Detroit";
		cities[1] = "Ann Arbor";
		cities[2] = "Lansing";
		cities[3] = "Grand Rapids";
		cities[4] = "Kalamazoo";
		cities[5] = "Traverse City";
		all = new Node[population];
		randomNodes();
		all[0].setInfected(true);
		while (countDead < population){
			infect(all[0]);
			//update infected GUI
			unnavigate();
			kill(all[0]);
			//update dead GUI
			unnavigate();
			countDays++;
		}
	}

	public void infect(Node n){
		if(n.getInfected() == false){
			//if(resistance < algorithm1){
				n.setInfected(true);
				countInfected++;
			//}	
		}
		else if(n.getDead() == false){
			for(int i = 0; i < n.getRelated().size(); i++){
				if(n.getNavigated() == false){
					n.setNavigated(true);
					infect(all[n.getRelated().get(i)]);
				}
			}
		}
	}
	
	public void kill(Node n){
		if(n.getInfected() == true){
			if(n.getHealth() <= 0){
				n.setInfected(false);
				n.setDead();
				countDead++;
			}
			else{
				n.setHealth(n.getHealth() /* - algorithm2*/);
			}
			for(int i = 0; i < n.getRelated().size(); i++){
				if(n.getNavigated() == false){
					n.setNavigated(true);
					kill(all[n.getRelated().get(i)]);
				}
			}
		}
		
	}
	
	public void randomNodes(){
		for (int z = 0; z <= population; z++){
			Random random = new Random();
			int h = random.nextInt(10 - 1) + 1; //change numbers
			int x = random.nextInt(10 - 1) + 1; //change numbers
			int y = random.nextInt(10 - 1) + 1; //change numbers
			int i = random.nextInt(10 - 1) + 1; //change numbers
			String c = whereAmI(x, y);
			all[z] =  new Node(h, x, y, i, c);
		}
	}
	
	public void relationships(){
		for(int i = 0; i < population; i++){
			for(int j = 0; j < population; j++){
				if(/*algorithm3 && */ all[i].getRelated().contains(j) == false && i != j){
					all[i].addRelated(j);
					all[j].addRelated(i);
				}
			}
		}
	}
	
	public void unnavigate(){
		for(int i = 0; i < population; i++)
			all[i].setNavigated(false);
	}
	
	public String whereAmI(int x, int y){
		//if(city x and y){
		//	return city;
		//}
		return "";
	}

	public int getCountInfected() {
		return countInfected;
	}

	public int getCountDays() {
		return countDays;
	}
}
