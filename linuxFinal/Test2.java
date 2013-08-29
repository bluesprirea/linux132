import java.io.File;
import java.util.Scanner;

public class Test2 {
	public static void main(String[] args){
		System.out.print("Path :");
		Scanner scan = new Scanner(System.in);
		String st1 = scan.next();
		System.out.print("File Name :");
		Scanner scan1 = new Scanner(System.in);
		String st2 = scan1.next();
		String[] list = new String[512];
		File f = new File(st1);
		if(f.isDirectory()){
			list = f.list();
		}
		else {
			System.exit(1);
		}
		
		int Place = find(list, st2);
		if(Place > 0){
			System.out.println(list[Place]);
			File f1 = new File(st2);
			System.out.println(f1.getAbsolutePath());
		}
	}

	private static int find(String[] arr, String st2) {
		for(int i = 0; i<arr.length;i++){
			if(arr[i]==st2)
				return i;
		}
		return -1;
		}
	}

