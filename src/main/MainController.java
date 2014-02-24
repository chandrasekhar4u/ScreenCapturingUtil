package main;

import imageUtil.ImageUtil;

import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 * 
 */
public class MainController {

	/**
	 * 
	 */
	private static final ResourceBundle bundle = ResourceBundle
			.getBundle("configuration");

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		while (true) {
			try {
				if (!checkPattern(bundle.getString("FROM_EMAIL_ADDRESS").trim()))
					break;
				if (!checkPattern(bundle.getString("TO_EMAIL_ADDRESS").trim()))
					break;
				try {
					ImageUtil.capturedImage(); // return true or false
					Thread.sleep((getDelayMin() * 60 * 1000));
				} catch (Exception e) {
					e.printStackTrace();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return interval in minutes.
	 */
	private static int getDelayMin() {
		return Integer.parseInt(bundle.getString("INTERVAL").trim());
	}

	/**
	 * @param word
	 * @return
	 */
	private static boolean checkPattern(String word) {
		try {
			word = word.split("\\s")[0];
			Pattern mailAddressPattern = Pattern
					.compile("[\\w\\.-]{3,30}@[\\w\\.-]{3,30}");
			Matcher eMailMatcher = mailAddressPattern.matcher(word);
			if (eMailMatcher.find())
				return true;
			return false;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
