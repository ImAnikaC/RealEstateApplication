import java.util.ArrayList;
import java.util.Scanner; 

public class HouseInventory implements InventoryMNG {
	Scanner input = new Scanner (System.in);
	
	//creating arraylist for all houses
	private ArrayList<House> allHouses = new ArrayList<House>();

	//methods
	@Override
	public void Add(House h) {
		allHouses.add(h);
		
	}
	
	@Override
	public void Edit(int id, double price) {
		//checking to see if entered id matched 
		for (int i = 0; i<allHouses.size(); i++) {
			if (allHouses.get(i).getId()==id) {
				//the id is a match
				//setting the price
				System.out.println("Entered ID is a match. Changing price now.");
				allHouses.get(i).setPrice(price);
				System.out.println("Is the house available for sale?");
				boolean status = input.nextBoolean();
				
				//changing the status 
				allHouses.get(i).setStatus(status);
				break;
			}
		}
		
	}

	@Override
	public int Delete(int id) {
		//delete house if id matches – returns zero if the house was not deleted (not found)

        // return 1 if the house was deleted.
		int result = 0;
		for (int i = 0; i<allHouses.size(); i++) {
			if (allHouses.get(i).getId()==id) {
				//ids match
				//removes it
				allHouses.remove(i);
				result = 1;
				break;
			}

		}

		return result;
	}

	@Override
	public House[] HousesBellowPrice(double p) {
		//returns an array of houses that are below a price p.

		//in case there are none – then you need to return an empty array.

		//once this method called in the main, you will need to print the array being return by 
		
		//the method to the screen. 

		ArrayList<House> belowPrice = new ArrayList<House>();
		int count = 0;

		for (int i = 0; i<allHouses.size(); i++) {
			if (allHouses.get(i).getPrice()<p) {
				//its below the price so add to the empty arraylist
				belowPrice.add(allHouses.get(i));
				count++;
				
			}
		}

		//copying elements from bellowPrice to bellowArray bc we have to return House[] variable
		House [] belowArray = new House [count];
		for (int i = 0; i<belowPrice.size(); i++) {
			belowArray[i] = belowPrice.get(i);
		}
		
		return belowArray;
	}
	
	
	@Override
	public House[] DuplicatePrice() {
		
		ArrayList<House> duplicate = new ArrayList<House>();
		
		//finding the duplicate
		for (int i = 0; i<allHouses.size(); i++) {
			for (int j = i+1; j<allHouses.size(); j++) {
				//they are duplicates
				if (allHouses.get(i).getPrice()==allHouses.get(j).getPrice()) {
					//copying the duplicate id to a new arraylist
					
					duplicate.add(allHouses.get(i));
					duplicate.add(allHouses.get(j));
						
					}
					
					
				}
		}
		
		House [] d2 = new House [duplicate.size()];
		
		//getting the id from arrays copied 
		for (int i = 0; i<duplicate.size(); i++) {
			d2[i]= duplicate.get(i);
		}
		
		return d2;
	}
	
	
	
}
