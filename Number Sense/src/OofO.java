import java.util.Random;
import java.util.ArrayList;

public class OofO {
	private String question;
	private String answer;
	public double outsolution = 0;

	public String fstringmess() {
		Random rand = new Random();
		int Operations = rand.nextInt(3) + 2;
		double[] operands = new double[Operations];
		double solution = 0;
		for (int i = 0; i < Operations; i++) {
			operands[i] = rand.nextInt(15) + 1;
		}
		int mathsign = rand.nextInt(4) + 1;
		String firstmess = "";
		if (operands.length >= 2) {
			if (mathsign == 1) {
				firstmess = ("(" + String.valueOf(operands[0]) + "+" + String.valueOf(operands[1]) + ")");
				solution = operands[0] + operands[1];
			}
			if (mathsign == 2) {
				firstmess = ("(" + String.valueOf(operands[0]) + "-" + String.valueOf(operands[1]) + ")");
				solution = operands[0] - operands[1];
			}
			if (mathsign == 3) {
				firstmess = ("(" + String.valueOf(operands[0]) + "\\cdot" + String.valueOf(operands[1]) + ")");
				solution = operands[0] * operands[1];
			}
			if (mathsign == 4) {
				firstmess = ("(" + String.valueOf(operands[0]) + "\\div" + String.valueOf(operands[1]) + ")");
				solution = operands[0] / operands[1];
			}
		}
		String secondmess = "";
		mathsign = rand.nextInt(4) + 1;
		if (operands.length >= 3) {
			if (mathsign == 1) {
				secondmess = ("(" + firstmess + "+" + String.valueOf(operands[2]) + ")");
				solution = solution + operands[2];
			}
			if (mathsign == 2) {
				secondmess = ("(" + firstmess + "-" + String.valueOf(operands[2]) + ")");
				solution = solution - operands[2];
			}
			if (mathsign == 3) {
				secondmess = ("(" + firstmess + "\\cdot" + String.valueOf(operands[2]) + ")");
				solution = solution * operands[2];
			}
			if (mathsign == 4) {
				secondmess = ("(" + firstmess + "\\div" + String.valueOf(operands[2]) + ")");
				solution = solution / operands[2];
			}
		}
		String thirdmess = "";
		mathsign = rand.nextInt(4) + 1;
		int length = 3;
		if (operands.length >= (length + 1)) {
			if (mathsign == 1) {
				thirdmess = ("(" + secondmess + "+" + String.valueOf(operands[length]) + ")");
				solution = solution + operands[length];
			}
			if (mathsign == 2) {
				thirdmess = ("(" + secondmess + "-" + String.valueOf(operands[length]) + ")");
				solution = solution - operands[length];
			}
			if (mathsign == 3) {
				thirdmess = ("(" + secondmess + "\\cdot" + String.valueOf(operands[length]) + ")");
				solution = solution * operands[length];
			}
			if (mathsign == 4) {
				thirdmess = ("(" + secondmess + "\\div" + String.valueOf(operands[length]) + ")");
				solution = solution / operands[length];
			}
		}
		String fourthmess = "";
		mathsign = rand.nextInt(4) + 1;
		length = 4;
		if (operands.length >= (length + 1)) {
			if (mathsign == 1) {
				fourthmess = ("(" + secondmess + "+" + String.valueOf(operands[length]) + ")");
				solution = solution + operands[length];
			}
			if (mathsign == 2) {
				fourthmess = ("(" + secondmess + "-" + String.valueOf(operands[length]) + ")");
				solution = solution - operands[length];
			}
			if (mathsign == 3) {
				fourthmess = ("(" + secondmess + "\\cdot" + String.valueOf(operands[length]) + ")");
				solution = solution * operands[length];
			}
			if (mathsign == 4) {
				fourthmess = ("(" + secondmess + "\\div" + String.valueOf(operands[length]) + ")");
				solution = solution / operands[length];
			}
		}
		outsolution = solution;
		if (operands.length == 2) {
			return ("$" + String.valueOf(firstmess) + "$");
		}
		if (operands.length == 3) {
			return ("$" + String.valueOf(secondmess) + "$");
		}
		if (operands.length == 4) {
			return ("$" + String.valueOf(thirdmess) + "$");
		}
		if (operands.length == 5) {
			return ("$" + String.valueOf(fourthmess) + "$");
		}
		return "";
	}

	public String remainder() {
		Random rand = new Random();
		int Operations = 3;
		int[] operands = new int[Operations];
		double solution = 0;
		for (int i = 0; i < Operations; i++) {
			operands[i] = rand.nextInt(15);
		}
		int mathsign = rand.nextInt(4) + 1;
		String firstmess = "";
		if (operands.length >= 2) {
			if (mathsign == 1) {
				firstmess = ("(" + String.valueOf(operands[0]) + "+" + String.valueOf(operands[1]) + ")");
				solution = operands[0] + operands[1];
			}
			if (mathsign == 2) {
				firstmess = ("(" + String.valueOf(operands[0]) + "-" + String.valueOf(operands[1]) + ")");
				solution = operands[0] - operands[1];
			}
			if (mathsign == 3) {
				firstmess = ("(" + String.valueOf(operands[0]) + "\\cdot" + String.valueOf(operands[1]) + ")");
				solution = operands[0] * operands[1];
			}
			if (mathsign == 4) {
				firstmess = ("(" + String.valueOf(operands[0]) + "\\div" + String.valueOf(operands[1]) + ")");
				solution = operands[0] / operands[1];
			}
		}
		String secondmess = "";
		mathsign = rand.nextInt(4) + 1;
		if (operands.length >= 3) {
			if (mathsign == 1) {
				secondmess = ("(" + firstmess + "+" + String.valueOf(operands[2]) + ")");
				solution = solution + operands[2];
			}
			if (mathsign == 2) {
				secondmess = ("(" + firstmess + "-" + String.valueOf(operands[2]) + ")");
				solution = solution - operands[2];
			}
			if (mathsign == 3) {
				secondmess = ("(" + firstmess + "\\cdot" + String.valueOf(operands[2]) + ")");
				solution = solution * operands[2];
			}
			if (mathsign == 4) {
				secondmess = ("(" + firstmess + "\\div" + String.valueOf(operands[2]) + ")");
				solution = solution / operands[2];
			}
		}
		String thirdmess = "";
		mathsign = rand.nextInt(4) + 1;
		int length = 3;
		if (operands.length >= (length + 1)) {
			if (mathsign == 1) {
				thirdmess = ("(" + secondmess + "+" + String.valueOf(operands[length]) + ")");
				solution = solution + operands[length];
			}
			if (mathsign == 2) {
				thirdmess = ("(" + secondmess + "-" + String.valueOf(operands[length]) + ")");
				solution = solution - operands[length];
			}
			if (mathsign == 3) {
				thirdmess = ("(" + secondmess + "\\cdot" + String.valueOf(operands[length]) + ")");
				solution = solution * operands[length];
			}
			if (mathsign == 4) {
				thirdmess = ("(" + secondmess + "\\div" + String.valueOf(operands[length]) + ")");
				solution = solution / operands[length];
			}
		}
		String fourthmess = "";
		mathsign = rand.nextInt(4) + 1;
		length = 4;
		if (operands.length >= (length + 1)) {
			if (mathsign == 1) {
				fourthmess = ("(" + secondmess + "+" + String.valueOf(operands[length]) + ")");
				solution = solution + operands[length];
			}
			if (mathsign == 2) {
				fourthmess = ("(" + secondmess + "-" + String.valueOf(operands[length]) + ")");
				solution = solution - operands[length];
			}
			if (mathsign == 3) {
				fourthmess = ("(" + secondmess + "\\cdot" + String.valueOf(operands[length]) + ")");
				solution = solution * operands[length];
			}
			if (mathsign == 4) {
				fourthmess = ("(" + secondmess + "\\div" + String.valueOf(operands[length]) + ")");
				solution = solution / operands[length];
			}
		}
		outsolution = solution;
		if (operands.length == 2) {
			return ("$" + String.valueOf(firstmess) + "$");
		}
		if (operands.length == 3) {
			return ("$" + String.valueOf(secondmess) + "$");
		}
		if (operands.length == 4) {
			return ("$" + String.valueOf(thirdmess) + "$");
		}
		if (operands.length == 5) {
			return ("$" + String.valueOf(fourthmess) + "$");
		}
		return "";
	}

	public String exponent() {
		Random rand = new Random();
		int base = rand.nextInt(6) + 3;
		int[] exponent = new int[3];
		for (int i = 0; i < 3; i++) {
			exponent[i] = rand.nextInt(10) + 2;
		}
		String question = "$" + base + "^{" + exponent[0] + "}";
		double solution = 0;
		for (int i = 1; i < 3; i++) {
			int mathsign = rand.nextInt(2);
			if (mathsign == 0) {
				question = question + "\\times" + base + "^{" + exponent[i] + "}";
				solution = exponent[i] + solution;
			}
			if (mathsign == 1) {
				question = question + "\\div" + base + "^{" + exponent[i] + "}";
				solution = exponent[i] - solution;
			}
		}
		question = question + "$";
		outsolution = solution;
		return question;
	}

	public static void baseGen(ArrayList<String> questions, ArrayList<String> answers, int i) {
		Random rand = new Random();
		int sign = rand.nextInt(4);
		int first, second;
		int base = rand.nextInt(7) + 3;
		if (sign == 0) { // addition
			first = rand.nextInt(100) + 40;
			second = rand.nextInt(100) + 40;
			questions.add("(" + i + ") $" + baseconvert.newnum(first, base) + "_" + base + " + "
					+ baseconvert.newnum(second, base) + "_" + base + "= \\hrulefill_" + base + "$");
			answers.add(baseconvert.newnum(first + second, base));
		}
		if (sign == 1) { // subtraction
			first = rand.nextInt(100) + 40;
			second = rand.nextInt(100) + 40;
			if (second > first) {
				int temp = first;
				first = second;
				second = temp;
			}
			questions.add("(" + i + ") $" + baseconvert.newnum(first, base) + "_" + base + " - "
					+ baseconvert.newnum(second, base) + "_" + base + "= \\hrulefill_" + base + "$");
			answers.add(baseconvert.newnum(first - second, base));
		}
		if (sign == 2) { // multiplication
			first = rand.nextInt(100) + 40;
			second = base - (rand.nextInt(base - 1) + 1);
			questions.add("(" + i + ") $" + baseconvert.newnum(first, base) + "_" + base + " \\cdot "
					+ baseconvert.newnum(second, base) + "_" + base + "= \\hrulefill_" + base + "$");
			answers.add(baseconvert.newnum(first * second, base));
		}
		if (sign == 3) { // division
			second = base - (rand.nextInt(base - 1) + 1);
			first = (rand.nextInt(40) + 40) * second;
			questions.add("(" + i + ") $" + baseconvert.newnum(first, base) + "_" + base + "\\div"
					+ baseconvert.newnum(second, base) + "_" + base + "= \\hrulefill_" + base + "$");
			answers.add(baseconvert.newnum(first / second, base));
		}
	}

	public String getQuest() {
		return question;
	}

	public String getAns() {
		return String.valueOf(answer);
	}

	public void placeholder(Object add, Object mult, Object div, int length) {
		String problem = "(" + genOp(add, mult, div, true);
		for (int i = 0; i < length; i++) {
			problem = "(" + problem + genOp(add, mult, div, false);
		}
		question = problem;
	}

	public String genOp(Object add, Object mult, Object div, boolean first) {
		Random rand = new Random();
		int operation = rand.nextInt(4);
		if (first) {
			if (operation == 0) {
				answer = frac.fracAdd(toAns(add), toAns(add));
				return add.toString() + " + " + add.toString() + ")";
			}
			if (operation == 1) {
				answer = frac.fracSub(toAns(add), toAns(add));
				return add.toString() + " - " + add.toString() + ")";
			}
			if (operation == 2) {
				answer = frac.fracMult(toAns(mult), toAns(mult));
				return mult.toString() + " \\cdot " + mult.toString() + ")";
			}
			if (operation == 3) {
				answer = frac.fracDivide(toAns(div), toAns(div), false);
				return " \\div " + div.toString() + ")";
			}
		}
		if (operation == 0) {
			answer = frac.fracAdd(answer, toAns(add));
			return " + " + add.toString() + ")";
		}
		if (operation == 1) {
			answer = frac.fracSub(answer, toAns(add));
			return " - " + add.toString() + ")";
		}
		if (operation == 2) {
			answer = frac.fracMult(answer, toAns(mult));
			return " \\cdot " + mult.toString() + ")";
		}
		if (operation == 3) {
			answer = frac.fracDivide(answer, toAns(div), false);
			return " \\div " + div.toString() + ")";
		}
		return "";
	}

	public String toAns(Object unSolve) {
		if (unSolve instanceof log) {
			return ((log) unSolve).toAns();
		}
		if (unSolve instanceof combin) {
			return String.valueOf(((combin) unSolve).toAns());
		}
		return "";
	}
	//testing stuff below
	
	public void placeholder2(Object type, range add, range mult, range div, int length) {
		String problem = "(" + genOp2(type, add, mult, div, true);
		for (int i = 0; i < length - 2; i++) {
			problem = "(" + problem + genOp2(type, add, mult, div, false);
		}
		question = problem;
	}
	
	public Object random(Object type, range randRange) {
		if (type instanceof log) {
			return ((log) type).random();
		}
		if (type instanceof combin) {
			return ((combin) type).random(randRange);
		}
		return "";
	}
	
	public String genOp2(Object type, range add, range mult, range div, boolean first) {
		Random rand = new Random();
		int operation = rand.nextInt(4);
		if (first) {
			if (operation == 0) {
				Object operand1 = random(type, add);
				Object operand2 = random(type, add);
				answer = frac.fracAdd(toAns(operand1), toAns(operand2));
				return operand1.toString() + " + " + operand2.toString() + ")";
			}
			if (operation == 1) {
				Object operand1 = random(type, add);
				Object operand2 = random(type, add);
				answer = frac.fracSub(toAns(operand1), toAns(operand2));
				return operand1.toString() + " - " + operand2.toString() + ")";
			}
			if (operation == 2) {
				Object operand1 = random(type, mult);
				Object operand2 = random(type, mult);
				answer = frac.fracMult(toAns(operand1), toAns(operand2), false);
				return operand1.toString() + " \\cdot " + operand2.toString() + ")";
			}
			if (operation == 3) {
				Object operand1 = random(type, div);
				Object operand2 = random(type, div);
				answer = frac.fracDivide(toAns(operand1), toAns(operand2), false);
				return operand1.toString() + " \\div " + operand2.toString() + ")";
			}
		}
		if (operation == 0) {
			Object nextOperand = random(type, add);
			answer = frac.fracAdd(answer, toAns(nextOperand));
			return " + " + nextOperand.toString() + ")";
		}
		if (operation == 1) {
			Object nextOperand = random(type, add);
			answer = frac.fracSub(answer, toAns(nextOperand));
			return " - " + nextOperand.toString() + ")";
		}
		if (operation == 2) {
			Object nextOperand = random(type, mult);
			answer = frac.fracMult(answer, toAns(nextOperand));
			return " \\cdot " + nextOperand.toString() + ")";
		}
		if (operation == 3) {
			Object nextOperand = random(type, div);
			answer = frac.fracDivide(answer, toAns(nextOperand), false);
			return " \\div " + nextOperand.toString() + ")";
		}
		return "";
	}

	public static void main(String[] args) {
		OofO loga = new OofO();
		loga.placeholder2(new combin(1, 1, true), new range(1, 3), new range(1, 3), new range(1,3), 2);
		System.out.println(loga.getQuest() + ", " + loga.getAns());
	}
}
