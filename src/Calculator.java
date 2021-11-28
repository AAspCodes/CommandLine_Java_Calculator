
import java.util.Scanner;
import java.util.InputMismatchException;

public class Calculator {
	private static Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		System.out.println("Welcome to Anthony's first Java Program, a Calculator.");

		while (true) {
			do_math();
			if (!(yes_or_no()))
				break;
		}
		
		System.out.println("bye");
		scanner.close();
	}
	
	public static void do_math() {	
		int first_num = enter_int();
		String operation = what_operation();
		int second_num = enter_int();
		String answer = operate(first_num, second_num, operation);
		System.out.println(answer);
	}
	
	public static boolean yes_or_no() {
		
		String input = "";
		String yes = "y";
		String no = "n";
		
		while (true) {
			System.out.println("would you like to do another math calculation? y/n");
			
			input = scanner.next();			
			if (input.equals(yes)) { 
				return true;
			}
			else if (input.equals(no))
				return false;

			else 
				System.out.println("try again...");
		}
	}
	
	public static String operate(int first_num, int second_num, String operation) {
		String answer = "";
	
		switch (operation) {
		case "a":
			//add
			int result = first_num + second_num;
			answer = String.valueOf(result);
			break;
		case "s":
			//subtract
			result = first_num - second_num;
			answer = String.valueOf(result);
			break;
		case "m":
			result = first_num * second_num;
			answer = String.valueOf(result);
			break;
		case "d":
			//divide
			float div_result = (float)first_num / (float) second_num;
			answer = String.valueOf(div_result);
			break;
		default:
			assert(1==2);
		}
		
		return answer;
	}
	
	public static int enter_int() {
		int input = 0;
		
		while (true){
			System.out.println("enter a number");
			
			try {
				input = scanner.nextInt();	
				return input;
				
			}catch (InputMismatchException e) {
				scanner.nextLine();
				System.out.println("That was not an appropriate answer!");
			}
		}
	}
	
	public static String what_operation() {
		
		while (true){
			
			System.out.println("What operation do you want to do? a/s/d/m");
			String input = scanner.next();
			
			if (("asdm".indexOf(input) != -1? true:false) & (input.length() == 1)) {
				return input;
			} else {
			System.out.println("That was not an appropriate answer!");
			}
		}
	}
}