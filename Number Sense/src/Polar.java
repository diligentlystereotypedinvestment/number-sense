import java.lang.Math;
import java.util.Random;
import java.util.ArrayList;

public class Polar{
	private Frac angle; //in terms of pi
	private Trig magnitude; //auto-adjusted for the problem
	private Trig x;
	private Trig y;
	private boolean askX;
	public static Random rand = new Random();

	public Polar(Frac angle, Trig magnitude, boolean askX){
		x = Trig.getCos(Trig.angle[Frac.indexOf(Trig.angle, angle)]);
		y = Trig.sin[Frac.indexOf(Trig.angle, angle)];
		this.angle = angle;
		this.askX = askX;
		this.magnitude = magnitude;
		Trig.rationalize(this.x, this.y, this.magnitude, askX);
	}

	public Trig getX(){
		return x;
	}

	public Trig getY(){
		return y;
	}

	public Trig getMagnitude(){
		return magnitude;
	}

	public Frac getAngle(){
		return angle;
	}

	public String getRectangular(){
		return "(" + x + ", " + y + ")";
	}

	public String toString(){
		return "(" + angle + "\\pi, " + magnitude + ")";
	}

	public static void gen(ArrayList<String> questions, ArrayList<String> answers, int i){
		boolean askPolar = rand.nextBoolean();
		int m = rand.nextInt(10) + 1;
		boolean askX = rand.nextBoolean();
		while(m == 3 || m ==6 || m == 9 || m == 7){
			m = rand.nextInt(10) + 1;
		}
		Polar polar = new Polar(Trig.angle[rand.nextInt(Trig.angle.length)], new Trig(m,1,false,false), askX);
		if(askPolar){
			if(askX){
				questions.add("(" + i + ") If the polar coordinates $" + polar + "$ is $(h, k)$, what is $h$?");
				answers.add(polar.getX().toString());
			} else{
				questions.add("(" + i + ") If the polar coordinates $" + polar + "$ is $(h, k)$, what is $k$?");
				answers.add(polar.getY().toString());
			}
		} else {
			if(askX){
				questions.add("(" + i + ") If the rectangular coordinates $" + polar.getRectangular() + "$ is $(h, k)$ in the polar coordinate system, what is $h$?");
				answers.add(polar.getAngle().toString());
			} else{
				questions.add("(" + i + ") If the polar coordinates $" + polar + "$ is $(h, k)$, what is $k$?");
				answers.add(polar.getMagnitude().toString());
			}
		}
	}
}
