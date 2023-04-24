public class Trig{
	public static final Frac[] angle = {
	    new Frac("0/1"),
	    new Frac("1/6"),
	    new Frac("1/4"),
	    new Frac("1/3"),
	    new Frac("1/2"),
	    new Frac("2/3"),
	    new Frac("3/4"),
	    new Frac("5/6"),
	    new Frac("1/1"),
	    new Frac("7/6"),
	    new Frac("5/4"),
	    new Frac("4/3"),
	    new Frac("3/2"),
	    new Frac("5/3"),
	    new Frac("7/4"),
	    new Frac("11/6"),
	    new Frac("2/1")};
	public static final Trig[] sin = {
	    new Trig(0,1, false, false),//0/1
	    new Trig(1,2, false, false),//1/6
	    new Trig(1,2, false, true),//1/4
	    new Trig(1,2, true, false),//1/3
	    new Trig(1,1, false, false),//1/2
	    new Trig(1,2, true, false),//2/3
	    new Trig(1,2, false, true),//3/4
	    new Trig(1,2, false, false),//5/6
	    new Trig(0,1, false, false),//1/1
	    new Trig(-1,2, false, false),//7/6
	    new Trig(-1,2, false, true),//5/4
	    new Trig(-1,2, true, false),//4/3
	    new Trig(-1,1, false, false),//3/2
	    new Trig(-1,2, true, false),//5/3
	    new Trig(-1,2, false, false),//7/4
	    new Trig(-1,2, false, false),//11/6
	    new Trig(0,1, false, false)};//2/1
	public Frac magnitude;
	public boolean isRoot3;
	public boolean isRoot2;

	public Trig(int num, int denom, boolean isRoot3, boolean isRoot2){
		magnitude = new Frac(num + "/" + denom);
		this.isRoot3 = isRoot3;
		this.isRoot2 = isRoot2;
	}

	public static Trig getCos(Frac angleMeasure){
		Frac equivSinAngle = Frac.fracAdd(angleMeasure, new Frac(-1,2));
		int index = Frac.indexOf(angle, equivSinAngle);
		return sin[index];
	}

	public void multiply(Frac multiplicand){
		magnitude = new Frac(Frac.verifyFrac(Frac.mult(magnitude.toString(false), multiplicand.toString(false))));
	}

	public String toString(){
		if(isRoot3){
			return magnitude.toString() + "$\\sqrt{3}$";
		} else if(isRoot2){
			return magnitude.toString() + "$\\sqrt{2}$";
		}
		return magnitude.toString();
	}

	public boolean rational(){
		return !(isRoot3 || isRoot2);
	}

	public void multRoot2(){
		if(isRoot2){
			multiply(new Frac("2/1"));
		} else {
			isRoot2 = true;
		}
	}

	public void multRoot3(){
		if(isRoot3){
			multiply(new Frac("3/1"));
		} else {
			isRoot3 = true;
		}
	}

	public static void rationalize(Trig a, Trig b, Trig c, boolean isX){
		boolean multRoot2 = false;
		if(isX && a.rational()){
		} else if (isX && !a.rational()){
			if(a.isRoot2){
				multRoot2 = true;
			}
		} else if(!isX && b.rational()){
		} else if(!isX && !b.rational()){
			if(b.isRoot2){
				multRoot2 = true;
			}
		}
		if(multRoot2){
			a.multRoot2();
			b.multRoot2();
			c.multRoot2();
		} else{
			a.multRoot3();
			b.multRoot3();
			c.multRoot3();
		}
	}

	@Override
	public boolean equals(Object o){
	    if( (o == this)){
	        return true;
	    }

	    if(o instanceof Trig){
		Trig t = (Trig) o;
	        return this.magnitude.equals(t.magnitude) && (this.isRoot3 == t.isRoot3) && (this.isRoot2 == t.isRoot2);
	    }

	    return false;
	}
}
