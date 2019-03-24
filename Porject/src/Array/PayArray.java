package Array;
import java.sql.Date;

public class PayArray {
	private Date o_bd;
	private String m_name;
	private int o_price;
	private String o_size;
	private int o_count;
	private int o_amount;
	
	public PayArray(Date o_bd, String m_name, int o_price, String o_size, int o_count, int o_amount)
	{
		 this.o_bd = o_bd;
		 this.m_name = m_name;
		 this.o_price = o_price;
		 this.o_size = o_size;
		 this.o_count = o_count;
		 this.o_amount = o_amount;
		 
	}
	
	public Date geto_bd()
	{
		return this.o_bd;
	}
	
	public String getm_name()
	{
		return this.m_name;
	}
	
	public int geto_price()
	{
		return this.o_price;
	}
	
	public String geto_size()
	{
		return this.o_size;
	}
	
	public int geto_count()
	{
		return this.o_count;
	}
	
	public int geto_amount()
	{
		return this.o_amount;
	}
}
