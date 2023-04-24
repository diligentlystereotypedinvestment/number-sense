import java.util.Scanner;
import java.util.ArrayList;
import java.util.Random;

public class DomainAndRange {
    public static void genQuestion(ArrayList<String> questions, ArrayList<String> answers, int i) {
	Random rand = new Random();
	boolean isRange = rand.nextBoolean();

	/*
	0. range of quadratic
	1. range of sqrt
	*/
	if(isRange){
	    int type = rand.nextInt(2);

	    boolean concaveUp = rand.nextBoolean();
	    String interval;
	    String sFunction = "";
	    if(concaveUp){
		interval = "$[a,\\infty)$";
	    } else{
		interval = "$(-\\infty,a]$";
	    }
	    Function xPart = new Function(1, true);
	    String d = String.valueOf(rand.nextInt(20) - 10);
	    if(d.equals("0")){
		d = "";
	    }
	    if(type == 0){
		Function square = xPart.multiply(xPart);
		int xVertex = -1 * xPart.getCoef(0);
		int dValue = 0;
		if(d.equals("")){
		    dValue = 0;
		}
		if(concaveUp){
		    dValue = Integer.valueOf(d);
		    square.changeCoef(2,square.getCoef(0) + dValue);
		} else{
		    for(int j = 0; j < 3; j++){
			square.changeCoef(j, square.getCoef(j) * -1);
		    }
		    square.changeCoef(2,square.getCoef(0) + dValue);
		}
		sFunction = square.toString();
		answers.add(String.valueOf(square.eval(xVertex)));
	    } else if(type == 1){
		//a here is different from a in the question string
	        String a = String.valueOf(rand.nextInt(20) + 1);
		if(a.equals("1")){
		    a = "";
		}
		if(!concaveUp){
		    sFunction += "-";
		}
		sFunction = a + "\\sqrt{" + xPart.toString() + "}" + d;
		answers.add(d);
	    }
	    questions.add("(" + i + ") The range of $" + sFunction + "$ is " + interval + ", $a=$");
	} else{

	    /*
	       0. trig + period as denom
	       1. quad + lin in denom
	       2. lower bound of sqrt
	       3. cancellation
	       */
	    int type = rand.nextInt(4);

	    if(type == 0){
		Function num = new Function();
		//in terms of pi
		Frac angle = Trig.angle[rand.nextInt(Trig.angle.length)];
		String function;
		boolean isSin = rand.nextBoolean();
		int frequency = rand.nextInt(5) + 1;
		Trig output;
		String a = String.valueOf(rand.nextInt(5) + 1);
		if(a.equals("1")){
		    a = "";
		}
		if(isSin){
		    function = "\\sin(" + a + "x)";
		    output = Trig.sin[Frac.indexOf(Trig.angle,angle)];
		} else {
		    function = "\\cos(" + a + "x)";
		    output = Trig.getCos(angle);
		}
		boolean askPeriod = rand.nextBoolean();
		if(askPeriod){
		    questions.add("(" + i + ") The domain of $\\frac{" + num.toString() + "}{" + function + "-" + output.toString() + "}$ is $\\mathbb{R}\\\\{a + 2c \\pi n, \\forall n\\in\\mathbb{N}\\}$ what is $c$?");
		    if(a.equals("")){
			answers.add((new Frac(1,1)).toString());
		    } else {
			answers.add((new Frac(1,Integer.valueOf(a))).toString());
		    }
		} else{
		    questions.add("(" + i + ") The domain of $\\frac{" + num.toString() + "}{" + function + "-" + output.toString() + "}$ is $\\mathbb{R}\\\\{a\\pi + 2c \\pi n, \\forall n \\in\\mathbb{N}\\}$ what is $a$");
		    int aValue = 0;
		    if(a.equals("")){
		        aValue = 1;
		    }
		    aValue = Integer.valueOf(a);
		    answers.add((Frac.fracMult(angle,new Frac(1,aValue))).toString());
		}
	    } else if(type == 1){
		Function num = new Function(2);
		Function denom = new Function(1);
		Frac discontinuity = new Frac(-1 * denom.getCoef(0), denom.getCoef(1));
		questions.add("(" + i + ") The domain of $\\frac{" + num.toString() + "}{" + denom.toString() + "}$ is $(-\\infty, \\ell) \\bigcup (\\ell, \\infty)$. $\\ell = ?$");
		answers.add(discontinuity.toString());
	    } else if(type == 2){
		Function xPart = new Function(1, true);
		String d = String.valueOf(rand.nextInt(20) - 10);
		if(d.equals("0")){
		    d = "";
		}
		String a = String.valueOf(rand.nextInt(20) - 10);
		if(a.equals("1")){
		    a = "";
		}
		questions.add("(" + i + ") The domain of $" + a + "\\sqrt{" + xPart.toString() + "} + " + d + "$ is $[a, \\infty)$, $a=$");
		answers.add(String.valueOf(-1 * xPart.getCoef(0)));
	    } else if(type == 3){
		Function sharedRoot = new Function(1, true);
		int hole = -1 * sharedRoot.getCoef(0);
		Function num = new Function(1);
		questions.add("(" + i + ") The domain of $\\frac{" + (num.multiply(sharedRoot)).toString() + "}{" + sharedRoot.toString() + "}$ is $(-\\infty, \\ell) \\bigcup (\\ell, \\infty)$. $\\ell = ?$");
		answers.add(String.valueOf(hole));
	    }
	}
    }

    public static void main(String[] args) {
        ArrayList<String> questions = new ArrayList<String>();
        ArrayList<String> answers = new ArrayList<String>();
	genQuestion(questions,answers,1);
	System.out.println(questions);
	System.out.println("\n" + answers);
    }
}
