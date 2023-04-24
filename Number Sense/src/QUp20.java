import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;

public class QUp20 {

	public void Gen(ArrayList<String> questions, ArrayList<String> answers, int i) {
		Random rand = new Random();
		int random = rand.nextInt(14) + 1;
		// System.out.println(random);
		// random = scan.nextInt();

		if (random == 1 || i == 1) { // addition of two integers
			int rand1_1 = rand.nextInt(19);
			if(rand1_1 == 0 || i == 1){//adding reverses
				int length = rand.nextInt(2) + 3;
				int[] digits = new int[length];
				int norm = 0;
				int reverse = 0;
				for(int a = 0; a < length; a++){
					digits[a] = rand.nextInt(9) + 1;
					norm += (int) Math.pow(10, length - a - 1) * digits[a];
					reverse += (int) Math.pow(10, a) * digits[a];
				}
				questions.add("(" + i + ") " + norm + " + " + reverse + " = ");
				answers.add(String.valueOf(norm + reverse));
			}
			if (rand1_1 == 1 || i == 1) { // addition of two integers
				Addition add1 = new Addition();
				answers.add(EliminateZero.zero(add1.sum));
				questions.add("(" + i + ") $" + add1.num1 + "+" + add1.num2 + " = $");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 2) { // addition of two mixed numbers
				Addmix addmix = new Addmix();
				answers.add(String.valueOf(addmix.summix));
				questions.add("(" + i + ") $" + addmix.addmix + Simp.getFrac(addmix.addfracn, addmix.addfracd, false) + "+" + addmix.addmix2 + Simp.getFrac(addmix.addfracn2, addmix.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 3) { // addition of two improper fractions
				AddImpro addimpro = new AddImpro();
				answers.add(addimpro.sumimpro);
				questions.add("(" + i + ") " + Simp.getFrac(addimpro.addfracn + "/" + addimpro.addfracd) + "+" + Simp.getFrac(addimpro.addfracn2 + "/" + addimpro.addfracd2) + "=");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 4) { // addition of two decimals
				AddDeci adddeci = new AddDeci();
				answers.add(String.valueOf(adddeci.sumdeci));
				questions.add("(" + i + ") $" + ((int) adddeci.adddeci / 100.0) + "+" + ((int) adddeci.adddeci2 / 100.0) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 5 || i == 1) { // subtraction of two integers
				Addition sub1 = new Addition();
				answers.add(EliminateZero.zero(sub1.d));
				questions.add("(" + i + ") $" + sub1.num1 + "-" + sub1.num2 + " = $");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 6) { // subtraction of two mixed numbers
				Addmix submix = new Addmix();
				answers.add(String.valueOf(submix.dmix));
				questions.add("(" + i + ") $" + submix.addmix + Simp.getFrac(submix.addfracn, submix.addfracd, false) + "-" + submix.addmix2 + Simp.getFrac(submix.addfracn2, submix.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 7) { // subtract two improper fractions
				AddImpro subimpro = new AddImpro();
				answers.add(subimpro.dimpro);
				questions.add("(" + i + ") $" + Simp.getFrac(subimpro.addfracn, subimpro.addfracd, false) + "-" + Simp.getFrac(subimpro.addfracn2, subimpro.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 8) { // subtract two decimals
				AddDeci subdeci = new AddDeci();
				answers.add(String.valueOf(subdeci.ddeci));
				questions.add("(" + i + ") $" + ((int) subdeci.adddeci / 100.0) + "-"+ ((int) subdeci.adddeci2 / 100.0) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 9) { // multiplication of two integers
				Addition mult1 = new Addition();
				answers.add(EliminateZero.zero(mult1.p));
				questions.add("(" + i + ") $" + mult1.num1 / 10 + "\\times" + mult1.num2 / 10 + " = $");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 10) { // multiplication of two mixed numbers
				Addmix multmix = new Addmix();
				answers.add(String.valueOf(multmix.pmix));
				questions.add("(" + i + ") $" + multmix.addmix / 1000 + Simp.getFrac(multmix.addfracn, multmix.addfracd, false) + "\\times" + multmix.addmix2 / 1000 + Simp.getFrac(multmix.addfracn2, multmix.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 11) { // multiplication of two improper fractions
				AddImpro multimpro = new AddImpro();
				answers.add(multimpro.pimpro);
				questions.add("(" + i + ") $" + Simp.getFrac(multimpro.addfracn, multimpro.addfracd, false) + "\\times" + Simp.getFrac(multimpro.addfracn2, multimpro.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 12) { // multiplication of two decimals
				AddDeci multdeci = new AddDeci();
				answers.add(String.valueOf(multdeci.pdeci));
				questions.add("(" + i + ") $" + ((int) (multdeci.adddeci / 100) / 100.0) + "\\times"+ ((int) (multdeci.adddeci2 / 100) / 100.0) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 13) { // division of two integers
				Addition div1 = new Addition();
				questions.add("(" + i + ") $" + div1.num1 / 100 + "\\div" + div1.num2 / 100 + " = $ \\hrulefill (fraction)");
				answers.add(Simp.getFrac(div1.num1 / 100 + "/" + div1.num2 / 100) + " or $" + Simp.getProper(div1.num1 / 100 + "/" + div1.num2 / 100) + "$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 14) { // division of two mixed numbers
				Addmix divmix = new Addmix();
				answers.add(String.valueOf(divmix.qmix));
				questions.add("(" + i + ") $" + divmix.addmix / 1000 + Simp.getFrac(divmix.addfracn, divmix.addfracd, false) + "\\div" + divmix.addmix2 / 1000 + Simp.getFrac(divmix.addfracn2, divmix.addfracd2, false) + "=$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 15) { // division of two improper fractions
				AddImpro divimpro = new AddImpro();
				answers.add(divimpro.qimpro);
				questions.add("(" + i + ") $" + Simp.getFrac(divimpro.addfracn, divimpro.addfracd, false) + "\\div" + Simp.getFrac(divimpro.addfracn2, divimpro.addfracd2, false) + "=" + "$");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if (rand1_1 == 16) { // division of two decimals
				AddDeci divdeci = new AddDeci();
				answers.add(String.valueOf((divdeci.adddeci / 10.0) / (divdeci.adddeci2 / 1000)));
				questions.add("(" + i + ") $" + ((int) divdeci.adddeci / 10.0) + "\\div" + (divdeci.adddeci2 / 1000) + "=$ \\hrulefill (Decimal)");
				// System.out.print(printmess);
				/*
				 * for (int q = 0; q < 60 - printmess.length(); q++) {
				 * //System.out.print("\\textunderscore"); }
				 */
				// System.out.println();
				// System.out.println();
			} else if(rand1_1 == 17){//a/b + b/a
				int a = rand.nextInt(17) + 5;
				int b;
				do{
					b = rand.nextInt(17) + 5;
				} while(a == b);
				boolean isLess = rand.nextBoolean();
				if(isLess){
					boolean isFirst = rand.nextBoolean();
					if(isFirst){
						String first = (a - b) + "/" + b;
						questions.add("(" + i + ") $" + first + " + " + Simp.getFrac(b, a, false) + "$ = ");
						answers.add(Simp.getProper(Frac.add(first, b + "/" + a)));
					} else{
						String second = (b - a) + "/" + a;
						questions.add("(" + i + ") $" + Simp.getFrac(a, b, false) + " + " + second + "$ = ");
						answers.add(Simp.getProper(Frac.add(a + "/" + b, second)));
					}
				} else{
					questions.add("(" + i + ") $" + Simp.getFrac(a, b, false) + " + " + Simp.getFrac(b, a, false) + "$ = ");
					answers.add(Simp.getProper(Frac.add(a + "/" + b, b + "/" + a)));
				}
			} else if(rand1_1 == 18){//series of fraction
				int b = rand.nextInt(3) + 2;
				int a;
				do{
					a = rand.nextInt(b - 1) + 1;
				}while(!IsPrime.prime(a));
				int length = rand.nextInt(3) + 3;
				String question = ("(" + i + ") $");
				String answer = "0";
				for(int q = b; q < length + b; q++){
					if(q == b){
						question = question + (Simp.getFrac(a, q * (q + 1), false));
						answers.add(Frac.add(answer, Simp.getFrac(a, q * (q + 1), false)));
					} else{
						question = (question + " + " + Simp.getFrac(a, q * (q + 1), false));
						answers.add(Frac.add(answer, Simp.getFrac(a, q * (q + 1), false)));
					}
				}
				questions.add(question + "$ = ");
			} else if(rand1_1 == 19){//deviating fraction
				boolean topPositive = rand.nextBoolean();
				boolean isSame = rand.nextBoolean();
				boolean isTwo = rand.nextBoolean();
				int a = rand.nextInt(9) + 1;
				int b;
				do{
					b = rand.nextInt(9) + 1;
				}while(b==a);
				Frac frac2;
				if(isTwo){
					frac2 = new Frac(2 * a, 2 * b);
				} else{
					frac2 = new Frac(a, b);
				}
				Frac frac1 = new Frac(a, b);
				if(topPositive){
					if(isSame){
						questions.add(frac1 + " - " + (new Frac(frac2.getNum() + 1, frac2.getDenom() + 1)) + "$ = ");
						answers.add(Frac.sub(frac1.toString(true), new Frac(frac2.getNum() + 1, frac2.getDenom() + 1).toString(true)));
					} else{
						questions.add(frac1 + " - " + (new Frac(frac2.getNum() + 1, frac2.getDenom() - 1)) + "$ = ");
						answers.add(Frac.sub(frac1.toString(true), new Frac(frac2.getNum() + 1, frac2.getDenom() - 1).toString(true)));
					}
				} else{
					if(isSame){
						questions.add(frac1 + " - " + (new Frac(frac2.getNum() - 1, frac2.getDenom() - 1)) + "$ = ");
						answers.add(Frac.sub(frac1.toString(true), new Frac(frac2.getNum() - 1, frac2.getDenom() - 1).toString(true)));
					} else{
						questions.add(frac1 + " - " + (new Frac(frac2.getNum() - 1, frac2.getDenom() + 1)) + "$ = ");
						answers.add(Frac.sub(frac1.toString(true), new Frac(frac2.getNum() - 1, frac2.getDenom() + 1).toString(true)));
					}
				}
			}
		} else

		if (random == 2) { // order of operation
			OofO ooo = new OofO();
			ooo.equation(new String(), new Range(1, 15), new Range(1, 15), new Range(1, 15), rand.nextInt(3) + 2);
			questions.add("(" + i + ") $" + ooo.getQuest() + "$ = "); // System.out.print(printmess);
			answers.add(ooo.getAns());
			/*
			 * for (int q = 0; q < 50 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 3) { // Distributive problems
			Distribution distro = new Distribution();
			String printmess = ("(" + i + ") " + distro.getMess());
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 50 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			answers.add(String.valueOf(distro.getAnswer()));
			// System.out.println();
			// System.out.println();
		} else

		if (random == 4) { // comparison
			Addmix compare = new Addmix();
			int comparison = rand.nextInt(2) + 1;
			String printmess = "";
			if (comparison == 1) {
				printmess = ("(" + i + ") Which is greater, " + Simp.getFrac(compare.addfracn, compare.addfracd, true) + " or " + (double) (compare.addmix2 / 100) / 100);
				if ((1.0 * compare.addfracn / compare.addfracd) > (double) (compare.addmix2 / 100) / 100) {
					answers.add(String.valueOf((1.0 * compare.addfracn / compare.addfracd)));
				} else {
					answers.add(String.valueOf((double) (compare.addmix2 / 100) / 100));
				}
			} else {
				printmess = ("(" + i + ") Which is greater, " + Simp.getFrac(compare.addfracn, compare.addfracd, true) + " or " + Simp.getFrac(compare.addfracn2, compare.addfracd2, true));
				if ((1.0 * compare.addfracn / compare.addfracd) > (1.0 * compare.addfracn2 / compare.addfracd2)) {
					answers.add(String.valueOf((1.0 * compare.addfracn / compare.addfracd)));
				} else {
					answers.add(String.valueOf((1.0 * compare.addfracn2 / compare.addfracd2)));
				}
			}
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 5) { // multiplication shortcuts
			Multshort multshort = new Multshort();
			String printmess = ("(" + i + ") " + multshort.multishort());
			answers.add(String.valueOf(multshort.getAns()));
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 6) { // squaring numbers
			int square = rand.nextInt(65) + 1;
			answers.add(String.valueOf(square * square));
			String printmess = ("(" + i + ") $" + square + "^{2}$");
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 7) { // conversion
			Conversion convert = new Conversion();
			convert.questionGen(i);
			String printmess = convert.getQuestion();
			questions.add(printmess);
			answers.add(convert.getAnswer());
			// System.out.print(printmess);
			// for (int q = 0; q < 60 - printmess.length(); q++) {
			// System.out.print("\\textunderscore");
			// }
			// System.out.println();
			// System.out.println();
		} else

		if (random == 8) { // gcf and lcm
			int choose = rand.nextInt(4) + 1;
			int num1 = rand.nextInt(20) + 3;
			int num2;
			do{
				num2 = rand.nextInt(20) + 5;
			} while(num2 == num1);
			int num3;
			do{
				num3 = rand.nextInt(20) + 6;
			} while(num3 == num2 || num3 == num1);
			String printmess = "";
			if (choose == 1) { // gcf of two
				printmess = ("(" + i + ") The GCD of " + num1 + " and " + num2 + " is");
				answers.add(String.valueOf(LCMandGCF.GCF(num1, num2)));
			}
			if (choose == 2) { // lcm of two
				printmess = ("(" + i + ") The LCM of " + num1 + " and " + num2 + " is");
				answers.add(String.valueOf(LCMandGCF.LCM(num1, num2)));
			}
			if (choose == 3) { // gcf of three
				printmess = ("(" + i + ") The GCD of " + num1 + ", " + num2 + ", and " + num3 + " is");
				answers.add(String.valueOf(LCMandGCF.GCF(num1, num2, num3)));
			}
			if (choose == 4) { // lcm of three
				printmess = ("(" + i + ") The LCM of " + num1 + ", " + (num1 * 1.5) + ", and " + (num1 * 2) + " is");
				answers.add(String.valueOf(LCMandGCF.LCM(num1, num2, num3)));
			}
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 9) { // percent problems
			int percent = (rand.nextInt(15) + 1) * 10;
			int percent2 = (rand.nextInt(15) + 1) * 10;
			while (percent == 100 || percent2 == 100) {
				percent = (rand.nextInt(15) + 1) * 10;
				percent2 = (rand.nextInt(15) + 1) * 10;
			}
			answers.add(String.valueOf(percent * percent2 / 100.0) + "\\%");
			String printmess = ("(" + i + ") P is " + percent + "\\% of Q. Q is " + +percent2 + "\\% of R. What percent is P of R?");
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 10) { // mean, mode, and median problems
			ArrayList<Integer> integer = new ArrayList<>();
			int sum = 0;
			int choose = rand.nextInt(3) + 1;
			String printmess = "";
			String charseries = "";
			if (choose == 1) { // mean
				int length = rand.nextInt(4) + 2;
				for (int p = 0; p < length; p++) {
					integer.add(rand.nextInt(40) + 1);
					sum = integer.get(p) + sum;
				}
				for (int p = 0; p < integer.size(); p++) {
					charseries = (charseries + String.valueOf(integer.get(p)) + " , ");
				}
				printmess = ("(" + i + ") What is the mean of " + charseries);
				answers.add(String.valueOf(1.0 * sum / integer.size()));
			} else if (choose == 2) { // median
				int length = rand.nextInt(4) + 3;
				for (int p = 0; p < length; p++) {
					integer.add(rand.nextInt(40) + 1);
					// sum = integer.get(p) + sum;
				}
				for (int p = 0; p < integer.size(); p++) {
					if (!(p == integer.size() - 1)) {
						charseries = (charseries + String.valueOf(integer.get(p)) + " , ");
					} else {
						charseries = (charseries + String.valueOf(integer.get(p)));
					}
				}
				Collections.sort(integer);
				double median;
				if (integer.size() % 2 == 0)
					median = (((double) integer.get(integer.size() / 2) + (double) integer.get(integer.size() / 2 - 1))
							/ 2);
				else {
					median = (double) integer.get(integer.size() / 2);
				}
				printmess = ("(" + i + ") What is the median of " + charseries);
				answers.add(String.valueOf(median));
			} else if (choose == 3) { // mode
				int length = rand.nextInt(3) + 6;
				for (int p = 0; p < length; p++) {
					integer.add(rand.nextInt(5) + 1);
					sum = integer.get(p) + sum;
				}
				for (int p = 0; p < integer.size(); p++) {
					charseries = (charseries + String.valueOf(integer.get(p)) + " , ");
				}
				answers.add(String.valueOf(MeanMedianMode.getMode(integer)));
				printmess = ("(" + i + ") What is the mode of " + charseries);
			}
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 50 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 11) { // Sums of Integers
			ArrayList<Integer> integer = new ArrayList<>();
			int sum = 0;
			int length = rand.nextInt(5) + 1;
			for (int p = 0; p < length; p++) {
				integer.add(rand.nextInt(50) + 10);
			}
			for (int p = 0; p < length; p++) {
				sum = integer.get(p) + sum;
			}
			answers.add(String.valueOf(sum));
			String charseries = "";
			for (int p = 0; p < integer.size(); p++) {
				if (p == integer.size() - 1) {
					charseries = (charseries + String.valueOf(integer.get(p)));
				} else {
					charseries = (charseries + String.valueOf(integer.get(p)) + " + ");
				}
			}
			String printmess = ("(" + i + ") " + charseries + "=");
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 12) { // Remainder Problems
			int dividend = rand.nextInt(10) + 3;
			int number = rand.nextInt(89999) + 10000;
			String printmess = "";
			if (dividend <= 10) {
				if (dividend == 7) { // traditional
					number = rand.nextInt(8999) + 1000;
				}
				printmess = ("(" + i + ") What is the remainder of " + number + " $\\div$ " + dividend + "?");
				answers.add(String.valueOf((number % dividend)));
			} /*
				 * else if (dividend == 12) {// power int base = rand.nextInt(12) + 2; int power
				 * = rand.nextInt(12) + 2; printmess = ("(" + i + ") What is the remainder of $"
				 * + base + "^{" + power + "}\\div" + dividend + "?$"); double exponentr =
				 * Math.pow(base, power); answers.add(String.valueOf(exponentr % dividend));
				 */
			// }
			else if (dividend == 12) { // expression
				OofO remainderex = new OofO();
				remainderex.equation(new String(), new Range(1, 15), new Range(2, 9), new Range(0,0), rand.nextInt(3) + 2);
				printmess = ("(" + i + ") What is the remainder of $" + remainderex.getQuest() + "$ $\\div$ " + dividend + "?");
				int ans = Integer.valueOf(remainderex.getAns()) % dividend;
				while(ans < 0){
					ans += dividend;
				}
				answers.add(String.valueOf(ans));
			}
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 60 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 13) { // Consumer Type Problems
			double price = 0;
			double postPrice = 0;
			String printmess = "";
			int oz = 0;
			double pounds = 0;
			int choose = rand.nextInt(2) + 1;
			if (choose == 1) {
				oz = (int) Math.pow(2, rand.nextInt(3) + 1);
				price = (rand.nextInt(71) + 31) / 100.0;
				pounds = .5 * (rand.nextInt((int) (Math.log(oz) / Math.log(2))) + 1);
				postPrice = price * 16 * pounds / oz;
			}
			if (choose == 2) {
				oz = rand.nextInt(10) + 3;
				price = .01 * oz * (rand.nextInt(9) + 5);
				pounds = .5 * (rand.nextInt(3) + 1);
				postPrice = price * 16 * pounds / oz;
			}
			if (choose == 3) {
				int initial = 100 * (rand.nextInt(9) + 1);
				int time = rand.nextInt(11) + 1;
				double rate = time * (rand.nextInt(90) + 10) / 10.0;
				printmess = "(" + i + ") What is the simple interest on $" + initial + ".00 with an interest rate of "+ rate + "\\% for " + time + " months?";
				answers.add("$" + Math.round(initial * rate * time / 12.0) / 100.0);
			} else {
				choose = rand.nextInt(2) + 1;
			}
			if (choose == 1) {
				printmess = "(" + i + ") If " + oz + " oz of a liquid costs \\$" + EliminateZero.money(price) + " then how much does " + pounds + " pounds cost?";
				answers.add(String.valueOf(EliminateZero.money(postPrice)));
			}
			if (choose == 2) {
				printmess = "(" + i + ") If " + pounds + " pounds of a liquid costs \\$" + EliminateZero.money(postPrice) + " then how much does " + oz + " oz cost?";
				answers.add(String.valueOf(pounds));
			}
			questions.add(printmess); // System.out.print(printmess);
			/*
			 * for (int q = 0; q < 50 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		} else

		if (random == 14) { // Number Theory Problems Involving: Prime Numbers, Divisors, Sums of Divisors,
			// etc.
			int choose = rand.nextInt(15) + 1;
			int base = rand.nextInt(100) + 21;
			SumOfDivisors composite = new SumOfDivisors();
			Relativeprimeundern relative = new Relativeprimeundern();
			String printmess = "";
			if (choose == 1) { // number of prime divisors
				printmess = ("(" + i + ") How many prime divisors in " + base + "?");
				answers.add(String.valueOf(PrimeDivisors.prime(base).size()));
			}
			if (choose == 2) { // sum of prime divisors
				printmess = ("(" + i + ") What is the sum of the prime divisors " + base + "?");
				answers.add(String.valueOf(PrimeDivisors.primesum(base)));
			}
			if (choose == 3) { // number of composite integers
				printmess = ("(" + i + ") How many divisors does " + base + " have?");
				answers.add(String.valueOf(composite.num(base)));
			}
			if (choose == 4) { // sum of composite integers
				printmess = ("(" + i + ") What is the sum of the composite integers in " + base + "?");
				answers.add(String.valueOf(composite.sum(base)));
			}
			if (choose == 5) { // number of prime divisors under n
				printmess = ("(" + i + ") How many prime divisors under " + base + " does " + base + " have?");
				answers.add(String.valueOf(relative.count(base)));
			}
			if (choose == 6) { // sum of prime divisors under n
				printmess = ("(" + i + ") What is the sum of the composite integers in " + base + "?");
				answers.add(String.valueOf(relative.sum(base)));
			}
			if (choose == 7) { // abundant number
				ArrayList<Integer> series1 = new ArrayList<>();
				series1.add(12);
				series1.add(18);
				series1.add(20);
				series1.add(24);
				series1.add(30);
				series1.add(36);
				series1.add(40);
				series1.add(42);
				series1.add(48);
				series1.add(54);
				series1.add(56);
				series1.trimToSize();
				NumberTypes abundant = new NumberTypes(series1, "abundant");
				printmess = ("(" + i + ") " + abundant.GenerateQuestion());
				answers.add(String.valueOf(abundant.getAnswer()));
			}
			if (choose == 8) { // deficient number
				ArrayList<Integer> series2 = new ArrayList<>();
				series2.add(1);
				series2.add(2);
				series2.add(3);
				series2.add(4);
				series2.add(5);
				series2.add(7);
				series2.add(8);
				series2.add(9);
				series2.add(10);
				series2.add(11);
				series2.add(13);
				series2.trimToSize();
				NumberTypes deficient = new NumberTypes(series2, "deficient");
				printmess = ("(" + i + ") " + deficient.GenerateQuestion());
				answers.add(String.valueOf(deficient.getAnswer()));
			}
			if (choose == 9) { // perfect number
				ArrayList<Integer> series3 = new ArrayList<>();
				series3.add(6);
				series3.add(28);
				series3.add(496);
				series3.trimToSize();
				NumberTypes perfect = new NumberTypes(series3, "perfect");
				printmess = ("(" + i + ") " + perfect.GenerateQuestion());
				answers.add(String.valueOf(perfect.getAnswer()));
			}
			ArrayList<Integer> lucky = new ArrayList<>(); // ArrayList for lucky and its inverse
			lucky.add(2);
			lucky.add(3);
			lucky.add(5);
			lucky.add(11);
			lucky.add(17);
			lucky.add(41);
			lucky.trimToSize();
			if (choose == 10) { // lucky number
				NumberTypes luckyType = new NumberTypes(lucky, "lucky");
				printmess = ("(" + i + ") " + luckyType.GenerateQuestion());
				answers.add(String.valueOf(luckyType.getAnswer()));
			}
			if (choose == 11) { // unlucky number
				ArrayList<Integer> series5 = new ArrayList<>();
				for (int p = 1; p < 90; p++) {
					if (lucky.indexOf(p) == -1) {
						series5.add(p);
					}
				}
				series5.trimToSize();
				NumberTypes unlucky = new NumberTypes(series5, "unlucky");
				printmess = ("(" + i + ") " + unlucky.GenerateQuestion());
				answers.add(String.valueOf(unlucky.getAnswer()));
			}
			ArrayList<Integer> happy = new ArrayList<>(); // ArrayList for happy and its inverse
			happy.add(1);
			happy.add(7);
			happy.add(10);
			happy.add(13);
			happy.add(19);
			happy.add(23);
			happy.add(28);
			happy.add(31);
			happy.add(32);
			happy.add(44);
			happy.add(49);
			happy.add(68);
			happy.add(70);
			happy.add(79);
			happy.add(82);
			happy.add(86);
			happy.trimToSize();
			if (choose == 12) { // happy number
				NumberTypes happyType = new NumberTypes(happy, "happy");
				printmess = ("(" + i + ") " + happyType.GenerateQuestion());
				answers.add(String.valueOf(happyType.getAnswer()));
			}
			if (choose == 13) { // unhappy number
				ArrayList<Integer> series6 = new ArrayList<>();
				for (int l = 0; l < 90; l++) {
					if (happy.indexOf(l) == -1) {
						series6.add(l);
					}
				}
				series6.trimToSize();
				NumberTypes unhappy = new NumberTypes(series6, "unhappy");
				printmess = ("(" + i + ") " + unhappy.GenerateQuestion());
				answers.add(String.valueOf(unhappy.getAnswer()));
			}
			if (choose == 14) { // odious number
				ArrayList<Integer> series7 = new ArrayList<>();
				series7.add(1);
				series7.add(2);
				series7.add(4);
				series7.add(7);
				series7.add(8);
				series7.add(11);
				series7.add(13);
				series7.add(14);
				series7.add(16);
				series7.add(19);
				series7.trimToSize();
				NumberTypes odious = new NumberTypes(series7, "odious");
				printmess = ("(" + i + ") " + odious.GenerateQuestion());
				answers.add(String.valueOf(odious.getAnswer()));
			}
			if (choose == 15) { // evil number
				ArrayList<Integer> series8 = new ArrayList<>();
				series8.add(0);
				series8.add(3);
				series8.add(5);
				series8.add(6);
				series8.add(9);
				series8.add(10);
				series8.add(12);
				series8.add(15);
				series8.add(17);
				series8.add(18);
				series8.add(20);
				series8.trimToSize();
				NumberTypes evil = new NumberTypes(series8, "evil");
				printmess = ("(" + i + ") " + evil.GenerateQuestion());
				answers.add(String.valueOf(evil.getAnswer()));
				questions.add(printmess);
			}
			// System.out.print(printmess);
			/*
			 * for (int q = 0; q < 50 - printmess.length(); q++) {
			 * //System.out.print("\\textunderscore"); }
			 */
			// System.out.println();
			// System.out.println();
		}
	}

	/*
	public static void main(String[] args) {
		ArrayList<String> temp = new ArrayList<>();
		ArrayList<String> temp2 = new ArrayList<>();
		int i = 1;
		QUp20 q = new QUp20();
		for (int a = 0; a < 40; a++) {
			q.Gen(temp, temp2, i);
		}
		for (String e : temp) {
			System.out.println(e);
		}
		for (String e : temp2) {
			System.out.println(e);
		}
	}
	*/
}
