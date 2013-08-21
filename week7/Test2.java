import java.io.File;
import java.io.*;
import java.util.*;

public class Test2 {
	static Random r = new Random();
	static final String PRE = "dir_";

	public static void main(String[] args)
		throws FileNotFoundException{
		boolean isCreate = false;
		String dname = PRE + r.nextInt(100);
		File f = new File("./",dname);
		if(!f.exists())
			isCreate = f.mkdir();
		else{
			System.err.printf("%s exists!\n", dname);
			System.exit(1);
		}

		if(isCreate)
			System.out.printf("create  %s success",
					f.getAbsolutePath());
		else
			System.out.println("fail");
	}
}
