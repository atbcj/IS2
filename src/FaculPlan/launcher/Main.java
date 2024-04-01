package FaculPlan.launcher;

import java.text.DecimalFormat;

public class Main {

	public static void main(String[] args) {
		System.out.println("Hola Munoo");
		System.out.println("Hola");
		DecimalFormat df = new DecimalFormat("#.00");
		double x = 1.4159999999;
		System.out.println(df.format(x));
		String st = df.format(x);
		double y = Double.parseDouble(st);
		System.out.println(y);
		System.out.println(df.format(x));
		System.out.println("No se que coño estoy haciendo");
	}

}
