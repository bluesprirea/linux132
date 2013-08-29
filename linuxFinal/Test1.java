
import java.util.Scanner;
import java.io.*;

public class Test1 {
	public static void main(String[] args) throws IOException{
		System.out.print("1st Place :");
		Scanner scan = new Scanner(System.in);
		String st1 = scan.next();
		System.out.print("2nd Place :");
		Scanner scan1 = new Scanner(System.in);
		String st2 = scan1.next();
		
		File f = new File(st1);
		File f1 = new File(st2);
		
		if(f.isDirectory() || f1.isDirectory()){
			System.out.println("Can't Copy!");
			System.exit(1);
		}
		else{
			CopyFile(st1, st2);
		}
		
	}

	private static void CopyFile(String st1, String st2) throws IOException {
		FileInputStream fis;
		FileOutputStream fos;
		
		fis = new FileInputStream(st1);
		fos = new FileOutputStream(st2);
		int d = 0;
		while((d=fis.read())!=-1);
		fos.write(d);
		
		fis.close();
		fos.close();
		
	}
}
