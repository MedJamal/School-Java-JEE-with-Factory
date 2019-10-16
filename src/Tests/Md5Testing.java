package Tests;

import controllers.PasswordHashing;

public class Md5Testing {
	public static void main(String args[]) {
		PasswordHashing passwordHashing = new PasswordHashing("password");
		System.out.println(passwordHashing.getGeneratedPassword());
	}
}
