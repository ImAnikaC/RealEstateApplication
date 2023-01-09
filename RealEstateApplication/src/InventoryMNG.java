
public interface InventoryMNG {
	
	public void Add(House h);
	
	public void Edit(int id, double price);
	
	public int Delete (int id);
	
	public House[] HousesBellowPrice(double p);
	
	public int findMin();
	
	public House[] DuplicatePrice();

}
