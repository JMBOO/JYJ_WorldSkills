package Array;

public class MenuArray {
	private String menu_Type;
	private String menu_Name;
	private int menu_Price;
	
	public MenuArray(String menu_Type, String menu_Name, int menu_Price)
	{
		this.menu_Type = menu_Type;
		this.menu_Name = menu_Name;
		this.menu_Price = menu_Price;
	}
	
	public String get_MenuType()
	{
		return menu_Type;
	}
	
	public String get_MenuName()
	{
		return menu_Name;
	}
	
	public int get_MenuPrice()
	{
		return menu_Price;
	}
}
