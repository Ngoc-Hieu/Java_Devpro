package ViDu_1;

public class StringDemo {
	public static void main(String[] args) {
		String str = new String();
		str = "Hello Devpro";
		
		System.out.println("char at index 0: " 
		+ str.charAt(0));
		System.out.println("Index of 'Dev': "
				+ str.indexOf("Dev"));
		System.out.println("Chuoi thuong: " 
				+ str.toLowerCase());
		System.out.println("Chuoi in: "
				+ str.toUpperCase());
		String str1 = str.concat(" 2025");
		System.out.println("str1: " + str1);
		
		if(str.compareTo("Hello devpro") == 0) {
			System.out.println("Giong nhau");
		}
		else if(str.compareTo("Hello devpro") > 0)
			System.out.println("str lon hon");
		else 
			System.out.println("str nho hon");
		
		if(str.contains("Dev")) System.out.println("Yes");
		else System.out.println("No");
		
		str1 = str.substring(6,9);
		System.out.println("str1 = " + str1);
		
		str1 = str.replace('e', 'E');
		System.out.println("str1 = " + str1);
		
		str = "cam quyt mit dua chuoi tao";
		String[] fruits = str.split(" ");
		for(String s : fruits) {
			System.out.println(s);
		}
		
		
	}
}
