import java.util.Random;
import java.util.ArrayList;

public class Function {
	private int degree;
	private int[] coef;
	private Frac[] iCoef;
	private static Random rand = new Random();

	public void integrate(){
		int index = 0;
		for(int i = degree; i >= 0; i--){
			iCoef[index] = Simp.getFrac(new Frac(coef[index] + "/" + (i + 1)));
		}
	}

	public Frac evalIntegral(int x){
		Frac sum = new Frac(Frac.verifyFrac(Frac.mult((int)Math.pow(x, degree + 1) + "/" + 1, iCoef[0].toString(false))));
		int tempDegree = degree;
		for(int i = 1; i < coef.length; i++){
			sum = new Frac(Frac.verifyFrac(Frac.add(sum.toString(false), Frac.mult((int)Math.pow(x, tempDegree) + "/" + 1, iCoef[i].toString(false)))));
			tempDegree--;
		}
		return sum;
	}

	public Frac evalDef(int upper, int lower){
		integrate();
		return new Frac(Frac.verifyFrac(Frac.sub(evalIntegral(upper).toString(false), evalIntegral(lower).toString(false))));
	}

	public Function derivative(){
		int[] derivative = new int[degree];
		int index = 0;
		for(int i = derivative.length - 1; i > 0; i++){
			derivative[index] = coef[index] * i;
		}
		return new Function(derivative);
	}

	public Function(){
		degree = rand.nextInt(2) + 1;
		this.coef = new int[degree + 1];
		for(int i = 0; i <= degree; i++){
			// if(degree == 3){
			// 	continue;
			// }
			do{
				this.coef[i] = rand.nextInt(11) - 5;
			} while(this.coef[i] == 0);
		}
	}

	public Function(int degree){
		this.coef = new int[degree + 1];
		this.degree = degree;
		do{
		    this.coef[degree] = rand.nextInt(11) - 5;
		} while(this.coef[degree] == 0);
		for(int i = 0; i < degree; i++){
			//idk why this is here
			// if(degree == 3){
			// 	continue;
			// }
			this.coef[i] = rand.nextInt(11) - 5;
		}
	}

	public Function(int degree, boolean firstCoefIsOne){
		this.coef = new int[degree + 1];
		this.degree = degree;
		if(firstCoefIsOne){
		    this.coef[degree] = 1;
		} else{
			this.coef[degree] = rand.nextInt(11) - 5;
		}
		for(int i = 0; i < degree; i++){
			//idk why this is here
			// if(degree == 3){
			// 	continue;
			// }
			this.coef[i] = rand.nextInt(11) - 5;
		}
	}

	public Function(int[] coef){
		this.coef = coef;
		this.degree = coef.length - 1;
	}

	public String toString(){
		String written = "";
		if(coef[degree] != 1)
		    written += coef[degree];
		written += "x^{" + degree + "}";
		for(int i = degree - 1; i > 0; i--){
		    if(i==1){
			if(coef[i] > 0){
			    written += "+" + coef[i] + "x";
			} else if(coef[i] < 0){
			    written += coef[i] + "x";
			}
		    }
		    if(coef[i] > 0){
			written += "+" + coef[i] + "x^{" + i + "}";
		    } else if(coef[i] < 0){
			written += coef[i] + "x^{" + i + "}";
		    }
		}
		if(coef[0] > 0){
			written += "+" + coef[0];
		} else if(coef[0] != 0){
			written += coef[0];
		}
		return written;
	}

	public int getCoef(int index){
		return coef[index];
	}

	public int[] getCoefs(){
		return coef;
	}

	public int getDeg(){
		return degree;
	}

	public void changeCoef(int index, int element){
		coef[index] = element;
	}

	public int eval(int x){
		int answer = 0;
		for(int i = degree; i > 0; i--){
			answer += (int)Math.pow(x, i) * coef[i];
		}
		return answer + coef[coef.length - 1];
	}

	public Function multiply(Function multicand){//Only binomial multiplication
		return new Function(new int[] {coef[0] * multicand.getCoef(0), coef[1] * multicand.getCoef(0) + coef[0] * multicand.getCoef(1), multicand.getCoef(1) * coef[1]});
	}

	public static void genInverse(ArrayList<String> questions, ArrayList<String> answers, int i){
		int random;
		do{
			random = rand.nextInt(15) - 7;
		} while(random == 0);
		Function forward = new Function(1);
		questions.add("(" + i + ")$" + random + "=" + forward + ", x = ?$");
		answers.add(String.valueOf((random - forward.getCoef(1)) / (1.0 * forward.getCoef(0))));
	}

	public static void genComposite(ArrayList<String> questions, ArrayList<String> answers, int i){
		int random = rand.nextInt(15) - 7;
		Function g = new Function(1);
		Function h = new Function(1);
		int ans = g.eval(h.eval(random));
		String order = "g(h(" + random + "))";
		if(rand.nextBoolean()){
			order = "h(g(" + random + "))";
			ans = h.eval(g.eval(random));
		}
		questions.add("(" + i + ") If $g = " + g + "$ and $h =" + h + "$, what is " + order);
		answers.add(String.valueOf(ans));
	}

	public static void genIntegral(ArrayList<String> questions, ArrayList<String> answers, int i){//integrals with C, i.e. If f'(c) = ...
		Function f = new Function();
		int upper = rand.nextInt(11) - 5;
		int lower = rand.nextInt(11) - 5;
		questions.add("(" + i + ") If $f(x) = " + f + ", $ then what is $\\int_{" + lower + "}^{" + upper + "} " + f + "dx$?");
		answers.add(f.evalDef(upper, lower).toString());
	}

	public static void genDerivative(ArrayList<String> questions, ArrayList<String> answers, int i){
		int choose = rand.nextInt(2);
		Function f = new Function();
		if(choose == 0){
			int x = rand.nextInt(11) - 5;
			questions.add("(" + i + ") If $f(x) = " + f + ", $ then what is $f'(" + x + ")?$");
			answers.add(String.valueOf(f.derivative().eval(x)));
		} else if(choose == 1){
			Function fPrime = f.derivative();
			Polynomial derivative = new Polynomial(fPrime.getCoefs());
			derivative.Gen(i);
			questions.add(derivative.getQuestion());
			answers.add(derivative.getAnswer());
		}
	}

	public static void genTangent(ArrayList<String> questions, ArrayList<String> answers, int i){//include x and y
		boolean isCircle = rand.nextBoolean();
		if(isCircle){
			int x = rand.nextInt(11) - 5;
			int y = rand.nextInt(11) - 5;
			String xPart = "(x - " + x + ")^2";
			if(x == 0){
				xPart = "x^2";
			} else if(x < 0){
				xPart = "(x + " + (-1 * x) + ")^2";
			}
			String yPart = "(y - " + x + ")^2";
			if(y == 0){
				yPart = "y^2";
			} else if(x < 0){
				yPart = "(y + " + (-1 * x) + ")^2";
			}
			questions.add("(" + i + ") What is the slope of the tangent line at $x=" + x + "$ of the equation $" + xPart + " + " + yPart + " = " + (int)Math.pow(rand.nextInt(5) + 1,2) + "$?");
			answers.add("0");
		} else{
			Function f = new Function();
			int x = rand.nextInt(11) - 5;
			questions.add("(" + i + ") What is the slope of the line tangent to $" + x + "$ for the function $" + f + "?$");
			answers.add(String.valueOf(f.derivative().eval(x)));
		}
	}

	public static void main(String[] args){
	    Function test = new Function(1,true);
	    int[] coefficients = test.getCoefs();
	    for(int e: coefficients){
		System.out.print(e + " ");
	    }
	    System.out.println(test.toString());
	    System.out.println(test.multiply(test));
	}
}
