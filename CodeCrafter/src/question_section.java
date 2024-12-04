import java.awt.print.Printable;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class question_section {

	private static String question, answer1, answer2, answer3, answer4;
	public static int a = 0;
	public final static String[] lines = new String[8];
	public final static int[] array = new int[8];
	public static boolean check = true;
	public static int random;
	public static boolean easy, moderate, difficult = false;
	public static String exception = "";
	public static int buttonchecker = 0;
	public static int count = 0;

	public static degree_of_question degree_of_question;

	// Getters and Setters
	public static String getQuestion() {
		return question;
	}

	public static void setQuestion(String question) {
		question_section.question = question;
	}

	public static String getAnswer1() {
		return answer1;
	}

	public static void setAnswer1(String answer1) {
		question_section.answer1 = answer1;
	}

	public static String getAnswer2() {
		return answer2;
	}

	public static void setAnswer2(String answer2) {
		question_section.answer2 = answer2;
	}

	public static String getAnswer3() {
		return answer3;
	}

	public static void setAnswer3(String answer3) {
		question_section.answer3 = answer3;
	}

	public static String getAnswer4() {
		return answer4;
	}

	public static void setAnswer4(String answer4) {
		question_section.answer4 = answer4;
	}

	static ImageIcon imageIcon = new ImageIcon("warn.png");

	public static void placement() {

		String path = "Assets/files/8 questions.csv";
		BufferedReader br = null;
		String line = "";

		if (degree_of_question.getSelection() == 1) {
			try {
				br = new BufferedReader(new FileReader(path));
				while ((line = br.readLine()) != null) {
					int x = 0;
					for (int i = 0; i < line.length(); i++) { 
						char aString = line.charAt(i);
						if (aString == ',' || aString == ';') {
							x++;

						}
					}
					try {
						checker(x);

					} catch (fileexception e) {
						JOptionPane.showMessageDialog(null, "There are some deficiencies in your game file.", "ERROR",
								JOptionPane.WARNING_MESSAGE, imageIcon);
						System.exit(0);
					}

					if (line.charAt(3) == '1' || line.charAt(2) == '1') {
						a++;
						lines[a - 1] = line;
						System.out.println(lines[a - 1]);

					}

				}

			} catch (Exception e) {
				exception = ("oops, something went wrong!!!");
				JOptionPane.showMessageDialog(null, exception, "ERROR", JOptionPane.WARNING_MESSAGE, imageIcon);

				System.exit(0);
			}

		} else if (degree_of_question.getSelection() == 2) {
			try {
				br = new BufferedReader(new FileReader(path));
				while ((line = br.readLine()) != null) {

					if (line.charAt(3) == '2' || line.charAt(2) == '2') {
						a++;

						lines[a - 1] = line;
						System.out.println(lines[a - 1]);
					}

				}

			} catch (Exception e) {
				exception = ("Oops, something went wrong!!!");
				JOptionPane.showMessageDialog(null, exception, "ERROR", JOptionPane.WARNING_MESSAGE, imageIcon);
				System.exit(0);
			}

		} else if (degree_of_question.getSelection() == 3) {
			try {
				br = new BufferedReader(new FileReader(path));
				while ((line = br.readLine()) != null) {

					if (line.charAt(3) == '3' || line.charAt(2) == '3') {
						a++;
						lines[a - 1] = line;
						System.out.println(lines[a - 1]);
					}
					System.out.printf("a: %d ***", a);

				}

			} catch (Exception e) {
				exception = ("oops, something went wrong!!!");
				JOptionPane.showMessageDialog(null, exception, "ERROR", JOptionPane.WARNING_MESSAGE, imageIcon);
				System.exit(0);
			}

		}

		qstn_answr();

	}

	public static void qstn_answr() {
		while (check) {
			random_number_generator();
			check = false;

		}

		for (int j = 0; j < a; j++) {
			int q1 = 0;
			int q2 = 0;
			int a1 = 0;
			int a2 = 0;
			int a3 = 0;
			int a4 = 0;
			count = 0;
			for (int i = 0; i < lines[array[j]].length(); i++) {
				if (lines[array[j]].charAt(i) == ',' || lines[array[j]].charAt(i) == ';') {
					count++;
					if (count == 2) {
						q1 = i;
					} else if (count == 3) {
						q2 = i;
					} else if (count == 4) {
						a1 = i;
					} else if (count == 5) {
						a2 = i;
					} else if (count == 6) {
						a3 = i;
					} else if (count == 7) {
						a4 = i;
					}
				}

			}
			if (j == buttonchecker) {
				setQuestion(lines[array[j]].substring(q1 + 1, q2));
				setAnswer1(lines[array[j]].substring(q2 + 1, a1));
				setAnswer2(lines[array[j]].substring(a1 + 1, a2));
				setAnswer3(lines[array[j]].substring(a2 + 1, a3));
				setAnswer4(lines[array[j]].substring(a3 + 1, a4));
			}

		}

	}

	public static void random_number_generator() {

		Set<Integer> usedNumbers = new HashSet<>();

		for (int i = 0; i < array.length; i++) {
			int number;
			do {
				number = (int) (Math.random() * a);
			} while (usedNumbers.contains(number));

			array[i] = number;
			usedNumbers.add(number);
		}

		for (int i = 0; i < a; i++) {
			System.out.println(array[i]);
		}
	}

	static void checker(int file) throws fileexception {
		if (file != 7) {
			throw new fileexception("message");
		}
	}

}