package roll_dice_2_2;

public class RollDice {
	public static void main(String[] args) {
		int first = (int) (Math.random()*6) + 1;
		int second = (int) (Math.random()*6) + 1;
		
		System.out.println("The first dice: " + first);
		System.out.println("The second dice: " + second);
		System.out.println();
		
	}

}
