import java.util.ArrayList;
import java.util.Random;

public class QUp70 {
	public void Gen(ArrayList<String> questions, ArrayList<String> answers, int i) {
		Random rand = new Random();
		int random = rand.nextInt(137) + 1;
		if(random == 1 || random == 2 || random == 3 || random == 4){
			MoreGeo.gen(questions, answers, i);
		} else if(check(random,5)){
			GreatestInt.gen(questions, answers, i);
		} else if(check(random, 9)){
			AdvRemainders.gen(questions, answers, i);
		} else if(check(random, 13)){
			Matrix.gen(questions, answers, i);
		} else if(check(random, 17)){
			Function.genComposite(questions, answers, i);
		} else if(check(random, 21)){
			Polar.gen(questions, answers, i);
		} else if(check(random, 25)){
			Matrix.gen(questions, answers, i);
		} else if(check(random, 29)){
			Vectors.gen(questions, answers, i);
		}


		if (random < 97) {
			QUp60 questions60 = new QUp60();
			questions60.Gen(questions, answers, i);
		}
	}

	private static boolean check(int random, int questionType){
		for(int i = 0; i < 4; i++){
			questionType++;
			if(random == questionType){
				return true;
			}
		}
		return false;
	}
}
