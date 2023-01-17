import java.util.Scanner;
import java.util.Arrays;

public class HouseInventoryApp {
	public static void main(String[]args) {
		
		Scanner input = new Scanner (System.in);
		
		HouseInventory houseInventory = new HouseInventory();
		
		while (true) {
			System.out.println("Choose one of the options:");
			System.out.println("1. Add a house");
			System.out.println("2. Edit a House");
			System.out.println("3. Delete a house");
			System.out.println("4. Display all houses below a certain price");
			System.out.println("5. Display Houses with the Same Price (Duplicates)");
			System.out.println("6. Exit");
			int ans = input.nextInt();
			if (ans==1) {
				System.out.println("Enter ID: ");
				int id = input.nextInt();
				System.out.println("Enter price: ");
				double price = input.nextDouble();
				System.out.println("Enter status: ");
				boolean status = input.nextBoolean();
				
				//create house
				House h = new House(id, price, status);
				
				houseInventory.Add(h);
			}
			
			else if (ans==2) {
				//update price
				System.out.println("Enter ID:");
				int id = input.nextInt();
				System.out.println("Enter new price: ");
				double price = input.nextDouble();
				houseInventory.Edit(id, price);
			}
			
			else if (ans==3) {
				//delete a house by id. return 0 is not deleted, return 1 if deleted
				System.out.println("Enter ID:");
				int id = input.nextInt();
				System.out.println(houseInventory.Delete(id));
				
			}
			
			else if (ans==4) {
				//print array of house below entered price (NOT INCLUDING ENTERED PRICE)
				
				System.out.println("Enter maximum price: ");
				double price = input.nextDouble();
				
				House[] answer = houseInventory.HousesBellowPrice(price);	
				
				for (int i = 0; i< answer.length; i++) {
					System.out.println(answer[i].getPrice());
				}
			}
			
			else if (ans==5) {
				House[] dup = houseInventory.DuplicatePrice();
				
				if (dup.length==0) {
					System.out.println("The ArrayList of houses has zero duplicates");
				}
				else if (dup.length>0) {
					System.out.println("House ID's with same price are: ");
					for (int i =0; i< dup.length; i++) {
						System.out.println(dup[i].getId() + ": " + dup[i].getPrice());
						
					}
				}
				
			}
			
			else if (ans==6) {
				System.out.println("Goodbye!");
				break;
			}
			
			else {
				System.out.println("Invalid entry");
			}
		}
		
		
	}

}

