//this class helps ensure doubles and ints print and interact properly
public class EZ{
	private double value;

	public EZ(double value){
		this.value = value;
	}
	
	public EZ(int value){
		this.value = value;
	}
	
	public EZ multiply(int multiplicand){
		value *= multiplicand;
		return new EZ(value);
	}

	public EZ multiply(double multiplicand){
		value *= multiplicand;
		return new EZ(value);
	}

	public String toString(){
		int decimalIndex = String.valueOf(value).indexOf("\\.");
		if(Integer.valueOf(String.valueOf(value).substring(decimalIndex)) == 0){
			return String.valueOf(value).substring(0, decimalIndex);
		} else{
			return String.valueOf(value);
		}
	}
}
