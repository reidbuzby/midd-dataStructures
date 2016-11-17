public class Temp implements Comparable<Temp>{
	
	 String month;
	 int temp;
	
	public Temp(String month, int temp) {
		this.month=month;
		this.temp=temp;
	}
	
	public int compareTo(Temp obj)
	{
		if(this.temp<obj.temp){
			return -1;
		}
		else if(this.temp>obj.temp){
			return 1;
		}
		else
			return 0;
	}
	
	public String toString()
	{
		return  month + " " + temp;
	}
	
}