import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class GenRunner {

	public static final long startTime = System.nanoTime();
	public static final Random random = new Random();
	private static int numOfTests;
	private static boolean separateKey;
	private static boolean contestantNumIncluded;
	private static int numOfContestants;
	/*
	public static final ArrayList<QuestionType> estimations = new ArrayList<QuestionType>();
	public static final ArrayList<QuestionType> under20 = new ArrayList<QuestionType>();
	public static final ArrayList<QuestionType> under40 = new ArrayList<QuestionType>();
	public static final ArrayList<QuestionType> under60 = new ArrayList<QuestionType>();
	public static final ArrayList<QuestionType> under70 = new ArrayList<QuestionType>();
	public static final ArrayList<QuestionType> under80 = new ArrayList<QuestionType>();

	public static void setup() {
		under20.add(new MeanMedianMode());
		under20.add(new Adding());

		under40.addAll(under20);
		under60.addAll(under40);
		under70.addAll(under60);
		under80.addAll(under70);
		// add all types under20, 40, 60, etc.
	}

	public static Question generateQuestionAt(int questionNumber) {
		if (questionNumber % 10 == 0) {
			return estimations.get(random.nextInt(estimations.size())).generateQuestion(questionNumber);
		} else if (questionNumber < 20) {
			return under20.get(random.nextInt(under20.size())).generateQuestion(questionNumber);
		} else if (questionNumber < 40) {
			return under40.get(random.nextInt(under40.size())).generateQuestion(questionNumber);
		} else if (questionNumber < 60) {
			return under60.get(random.nextInt(under60.size())).generateQuestion(questionNumber);
		} else if (questionNumber < 70) {
			return under70.get(random.nextInt(under70.size())).generateQuestion(questionNumber);
		} else {
			return under80.get(random.nextInt(under80.size())).generateQuestion(questionNumber);
		}
	}

	public static Question[] generateAllQuestion(int howMany) {
		Question[] problems = new Question[howMany]; // stores all questions
		for (int i = 1; i < problems.length + 1; i++) {
			problems[i] = generateQuestionAt(i);
		}
		return problems;
	}
	public static void printLatexDocument(Question[] problems) {
		System.out.println(
				"\\documentclass{article}\n\\usepackage[margin=0.5in]{geometry}\n\\usepackage{amsmath}\n\\usepackage{setspace}\n\\usepackage{multicol}\n%\\newcommand\\textbox[1]{\n%\\parbox{.333\\textwidth}{#1}%\n%}\n\\pagenumbering{gobble}\n\\begin{document}\n\\begin{center}\n\\textbf{The University Interscholastic League\\\\\nNumber Sense Test $\\cdot$ HS District $\\cdot$ \\date}\n\\end{center}\n\\hfill Final \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent \\textbf{Contestant's Number} \\textunderscore\\textunderscore\\textunderscore\\textunderscore\\hfill  2nd \\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent   .\\hfill  1st \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent \\textbf{Read directions carefully} \\hspace{.65in} {\\textbf{DO NOT UNFOLD THIS SHEET} }\\hfill{\\textbf{Score\\hspace{.05in} Initials}\n\n\\noindent \\textbf{before beginning test} \\hspace{1.2in}{\\textbf{UNTIL TOLD TO BEGIN}}\\hfill{}\n\n\n\\textbf{Directions}:  Do not turn this page until the person conducting this test gives the signal to begin. This is a ten-minute test. There are 80 problems. Solve accurately and quickly as many as you can in the order in which they appear. ALL  PROBLEMS  ARE  TO  BE SOLVED MENTALLY.  Make  no  calculations with paper and  pencil.  Write only the answer  in the space provided at the end of each problem.  Problems marked with a  ( * )  require approximate integral answers;  any answer to a starred problem  that is within five percent of the exact answer will be scored correct; all other problems require exact answers.\n\n\n\\textbf{The person conducting this contest should explain these directions to the contestants.}\n\n\\center{\\textbf{STOP -- WAIT FOR SIGNAL!}}\n\n\n\\setstretch{2}\n\\begin{multicols}{2}\n\\begin{flushleft}");
		for (int i = 0; i < problems.length; i++) {
			if (problems[i] == null) {
				problems[i] = new Question(i + 1, "0", "0");
			}
		}
		for (Question p : problems) {
			System.out.print("\\textbf{");
			System.out.print(p.question);
			if (p.question.indexOf("\\hrulefill") == -1) {
				System.out.print("\\hrulefill");
			}
			System.out.print("}\n\n");
		}
		System.out.println("\\end{flushleft}\\end{multicols}");
		System.out.println(
				"\n\\clearpage\n\\textbf{DO NOT DISTRIBUTE TO STUDENTS BEFORE OR DURING THE CONTEST}\n\n\\textbf{University Interscholastic League - Number Sense Answer Key HS $\\cdot$ Generated $\\cdot$ \\the\\year{}}\n\n\\textbf{*number) $x-y$ means an integer between $x$ and $y$ inclusive}\n\n\\textbf{NOTE: If an answer is of the type like $\\frac{2}{3}$ it cannot be written as a repeating decimal}");
		System.out.println("\n\\begin{multicols}{4}\n");
		int i = 1;
		for (Question p : problems) {
			if (i % 10 == 0) {
				System.out.print("*");
			}
			if (p.answer.indexOf("$") == -1) {
				System.out.print(i + ") $" + p.answer + "$\n\n");
			} else {
				System.out.print(i + ") " + p.answer + "\n\n");
			}
			i++;
		}
		System.out.println("\n\n\\end{multicols}\n");
		System.out.println("\n\n\\end{document}");
	}
*/

	public static void config() throws FileNotFoundException {
		Scanner conf = new Scanner(new File("../../config.txt"));
		numOfTests = Integer.valueOf(getData(conf.nextLine()));
		separateKey = Boolean.valueOf(getData(conf.nextLine()));
		contestantNumIncluded = Boolean.valueOf(getData(conf.nextLine()));
		if(contestantNumIncluded) {
			numOfContestants = Integer.valueOf(getData(conf.nextLine()));
		}
		conf.close();
	}

	public static String getData(String line) {
		return line.substring(line.indexOf('=')+2);
	}

	public static void main(String[] args) throws IOException {
		//setup();
		config();
		Unit.init();

		//create the questions and answers
		ArrayList<String> questions = new ArrayList<String>(), answers = new ArrayList<String>();
		for (int i = 1; i <= 80; i++) {
			if (i % 10 == 0) { // Estimation problems
				Estimation estimate = new Estimation(i);
				answers.add((int) (.95 * estimate.getAnswer()) + " - " + (int) (1.05 * estimate.getAnswer()));
				questions.add(("*(" + i + ") " + estimate.getMess()));
				// for (int q = 0; q < 60 - estimate.getMess().length(); q++) {
				// System.out.print("\\textunderscore");
				// }
				// System.out.println();
				// System.out.println();
				continue;
			}
			if (i < 21) {
				QUp20 questions20 = new QUp20();
				questions20.Gen(questions, answers, i);
			}
			if (i > 20 && i < 41) { // Questions 21-40
				QUp40 questions40 = new QUp40();
				questions40.Gen(questions, answers, i);
			}
			// Questions 41-60
			if (i > 40 && i < 61) {
				QUp60 questions60 = new QUp60();
				questions60.Gen(questions, answers, i);
			}
			if (i > 60 && i < 71) { // Questions 61-70
				QUp70 questions70 = new QUp70();
				questions70.Gen(questions, answers, i);
			}
			if (i > 70 && i < 81) { // Questions 71-80
				QUp80 questions80 = new QUp80();
				questions80.Gen(questions, answers, i);
			}
		}

		//filler while this is work in progress
		while (questions.size() < 80) {
			questions.add("0");
		}
		while (answers.size() < 80) {
			answers.add("0");
		}
		questions.trimToSize();
		answers.trimToSize();

		//cobbling together the contents of the test
		String contents = "";
		for (String e : questions) {
			contents += "\\textbf{";
			contents += e;
			if (e.equals(null)) {
				continue;
			}
			if (e.indexOf("\\hrulefill") == -1) {
				contents += "\\hrulefill";
			}
			contents += "}\n\n";
		}
		contents += "\\end{flushleft}\\end{multicols}";

		//for naming the files
		Date dNow = new Date( );
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd");

		//outputting the test
      	if(separateKey) {
      		FileWriter key = new FileWriter("NS.KEY" + ft.format(dNow) + ".tex", true);
    		key.write(
    				"\\\\documentclass{article}\\n\\\\usepackage[margin=0.5in]{geometry}\\n\\\\usepackage{microtype}\\n\\\\usepackage{amsmath}\\n\\\\usepackage{setspace}\\n\\\\usepackage{multicol}\\n%\\\\newcommand\\\\textbox[1]{\\n%\\\\parbox{.333\\\\textwidth}{#1}%\\n%}\\n\\\\pagenumbering{gobble}\\n\\\\begin{document}\n\\clearpage\n\\textbf{DO NOT DISTRIBUTE TO STUDENTS BEFORE OR DURING THE CONTEST}\n\n\\textbf{University Interscholastic League - Number Sense Answer Key HS $\\cdot$ Generated $\\cdot$ \\the\\year{}}\n\n\\textbf{*number) $x-y$ means an integer between $x$ and $y$ inclusive}\n\n\\textbf{NOTE: If an answer is of the type like $\\frac{2}{3}$ it cannot be written as a repeating decimal}");
    		key.write("\n\\begin{multicols}{4}\n");
    		int i = 1;
    		for (String e : answers) {
    			if (i % 10 == 0) {
    				key.write("*");
    			}
    			if (e.indexOf("$") == -1) {
    				key.write(i + ") $" + e + "$\n\n");
    			} else {
    				key.write(i + ") " + e + "\n\n");
    			}
    			i++;
    		}
    		key.write("\n\n\\end{multicols}\n");
    		key.write("\n\n\\end{document}");
    		key.close();
      	}
		for(int i = 0; i < numOfTests; i++) {
			String intro = "\\documentclass{article}\n\\usepackage[margin=0.5in]{geometry}\n\\usepackage{microtype}\n\\usepackage{amsmath}\n\\usepackage{setspace}\n\\usepackage{multicol}\n%\\newcommand\\textbox[1]{\n%\\parbox{.333\\textwidth}{#1}%\n%}\n\\pagenumbering{gobble}\n\\begin{document}\n\\begin{center}\n\\textbf{The University Interscholastic League\\\\\nNumber Sense Test $\\cdot$ HS District $\\cdot$ \\date}\n\\end{center}\n\\hfill Final \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent\\textbf{Contestant's Number}";
			if(contestantNumIncluded) {
				intro+="\\textunderscore\\textunderscore" + "\\underline{" + String.valueOf(i+1) + "}" + "\\textunderscore\\textunderscore\\hfill  2nd \\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent   .\\hfill  1st \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent \\textbf{Read directions carefully} \\hspace{.45in} {\\textbf{DO NOT UNFOLD THIS SHEET} }\\hfill{\\textbf{Score\\hspace {.05in} Initials}\n\n\\noindent \\textbf{before beginning test} \\hspace{1in}{\\textbf{UNTIL TOLD TO BEGIN}}\\hfill{}\n\n\n\\textbf{Directions}:  Do not turn this page until the person conducting this test gives the signal to begin. This is a ten-minute test. There are 80 problems. Solve accurately and quickly as many as you can in the order in which they appear. ALL  PROBLEMS  ARE  TO  BE SOLVED MENTALLY.  Make  no  calculations with paper and  pencil.  Write only the answer  in the space provided at the end of each problem.  Problems marked with a  ( * )  require approximate integral answers;  any answer to a starred problem  that is within five percent of the exact answer will be scored correct; all other problems require exact answers.\n\n\n\\textbf{The person conducting this contest should explain these directions to the contestants.}\n\n\\center{\\textbf{STOP -- WAIT FOR SIGNAL!}}\n\n\n\\setstretch{2.1}\n\\begin{multicols}{2}\n\\begin{flushleft}";
			} else {
				intro += "\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\hfill  2nd \\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent   .\\hfill  1st \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent \\textbf{Read directions carefully} \\hspace{.45in} {\\textbf{DO NOT UNFOLD THIS SHEET} }\\hfill{\\textbf{Score\\hspace {.05in} Initials}\n\n\\noindent \\textbf{before beginning test} \\hspace{1in}{\\textbf{UNTIL TOLD TO BEGIN}}\\hfill{}\n\n\n\\textbf{Directions}:  Do not turn this page until the person conducting this test gives the signal to begin. This is a ten-minute test. There are 80 problems. Solve accurately and quickly as many as you can in the order in which they appear. ALL  PROBLEMS  ARE  TO  BE SOLVED MENTALLY.  Make  no  calculations with paper and  pencil.  Write only the answer  in the space provided at the end of each problem.  Problems marked with a  ( * )  require approximate integral answers;  any answer to a starred problem  that is within five percent of the exact answer will be scored correct; all other problems require exact answers.\n\n\n\\textbf{The person conducting this contest should explain these directions to the contestants.}\n\n\\center{\\textbf{STOP -- WAIT FOR SIGNAL!}}\n\n\n\\setstretch{2.1}\n\\begin{multicols}{2}\n\\begin{flushleft}";
			}
			FileWriter test = new FileWriter("NS" + ft.format(dNow) + String.valueOf(i+1) + ".tex");
			test.write(intro + contents + "\\end{document}");
			test.close();
		}

		//System.out.print("\\documentclass{article}\n\\usepackage[margin=0.5in]{geometry}\n\\usepackage{microtype}\n\\usepackage{amsmath}\n\\usepackage{setspace}\n\\usepackage{multicol}\n%\\newcommand\\textbox[1]{\n%\\parbox{.333\\textwidth}{#1}%\n%}\n\\pagenumbering{gobble}\n\\begin{document}\n\\begin{center}\n\\textbf{The University Interscholastic League\\\\\nNumber Sense Test $\\cdot$ HS District $\\cdot$ \\date}\n\\end{center}\n\\hfill Final \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent "
				//+ "\\textbf{Contestant's Number}\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\hfill  2nd \\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent   .\\hfill  1st \\textunderscore\\textunderscore\\textunderscore\\textunderscore \\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\\textunderscore\n\n\\noindent \\textbf{Read directions carefully} \\hspace{.45in} {\\textbf{DO NOT UNFOLD THIS SHEET} }\\hfill{\\textbf{Score\\hspace {.05in} Initials}\n\n\\noindent \\textbf{before beginning test} \\hspace{1in}{\\textbf{UNTIL TOLD TO BEGIN}}\\hfill{}\n\n\n\\textbf{Directions}:  Do not turn this page until the person conducting this test gives the signal to begin. This is a ten-minute test. There are 80 problems. Solve accurately and quickly as many as you can in the order in which they appear. ALL  PROBLEMS  ARE  TO  BE SOLVED MENTALLY.  Make  no  calculations with paper and  pencil.  Write only the answer  in the space provided at the end of each problem.  Problems marked with a  ( * )  require approximate integral answers;  any answer to a starred problem  that is within five percent of the exact answer will be scored correct; all other problems require exact answers.\n\n\n\\textbf{The person conducting this contest should explain these directions to the contestants.}\n\n\\center{\\textbf{STOP -- WAIT FOR SIGNAL!}}\n\n\n\\setstretch{2.1}\n\\begin{multicols}{2}\n\\begin{flushleft}");



		// printTime();
	}

	public static void printTime() {
		System.out.println();
		System.out.println("---------------------------------------------------------");
		System.out.println("This program has ran for: " + (System.nanoTime() - startTime) / 1000000000.0 + " seconds");
		System.out.println("---------------------------------------------------------");
		System.out.println();
	}

}
//72 space
//56 lowest root
