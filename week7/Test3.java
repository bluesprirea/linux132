import java.io.File;
import java.io.*;
import java.util.*;

public class Test3{
	static Random r = new Random();
	static final String PRE = "dir_";
	static final String STR = "This is fire\n" + "Bye Bye ~\n";

	public static void main(String[] args) throws IOException{
		boolean isCreate = false;
		String fname = PRE + r.nextInt(100);
		File f = new File("./", fname);
		FileOutputStream fos = new FileOutputStream(f);
		BufferedOutputStream bos = new BufferedOutputStream(fos);

		bos.write(STR.getBytes());
		bos.close();
		fos.close();
	}
}
