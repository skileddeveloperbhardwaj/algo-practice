package easy;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Utils {
	public static BufferedReader getReader() {
		return new BufferedReader(new InputStreamReader(System.in));
	}

	public static String[] getTrimmed(String line) {
		return line.trim().split("\\s+");
	}

	public static int parseInt(String str) {
		return Integer.parseInt(str);
	}

	public static void println(Object obj) {
		if (obj instanceof Integer) {
			System.out.println((Integer)obj);
		}
	}
}
