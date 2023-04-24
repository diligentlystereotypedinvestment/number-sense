import java.util.ArrayList;
import java.util.Random;

public class QUp80 {

	public void Gen(ArrayList<String> questions, ArrayList<String> answers, int i) {
		Random rand = new Random();
		int random = rand.nextInt(157) + 1;
		int questionType = 0;
		if(check(random, questionType)){
			MinMax.gen(questions, answers, i);
		} else if(check(random, questionType)){
			Limit.gen(questions, answers, i);
		} else if(check(random, questionType)){
			Function.genInverse(questions, answers, i);
		} else if(check(random, questionType)){
			Function.genComposite(questions, answers, i);
		} else if(check(random, questionType)){
			Function.genDerivative(questions, answers, i);
		} else if(check(random, questionType)){
			Function.genIntegral(questions, answers, i);
		} else if(check(random, questionType)){
			Asymptotes.gen(questions, answers, i);
		} else if(check(random, questionType)){
			Function.genTangent(questions, answers, i);
		} else if(check(random, questionType)){
			Modulus.gen(questions,answers,i);
		} else if(check(random, questionType)){
			RepeatingFraction.genBase(questions,answers,i);
		} else if(check(random,questionType)){
			DomainAndRange.genQuestion(questions,answers,i);
		}
		else if (random < 137) {
			QUp70 questions70 = new QUp70();
			questions70.Gen(questions, answers, i);
		}
	}

	private static boolean check(int random, int questionType){
		for(int i = 0; i < 5; i++){
			questionType++;
			if(random == questionType){
				return true;
			}
		}
		return false;
	}
}
