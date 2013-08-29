
public class Test3 implements Runnable{

	public void run(){
		int x = 0;
		float[] listX = new float[512];
		float[] listY = new float[512];
		float[] listM = new float[512];
		
		for(int i = 1; i<=512; i++){
			float a = (float) Math.random();
			listX[i-1] = a;
		}
		
		for(int i = 1; i<=512; i++){
			float b = (float) Math.random();
			listY[i-1] = b;
		}
		
		for(int i = 1; i<=512; i++){
			listM[i-1] = listX[i-1] - listY[i-1];
		}
		
		for(int i =1; i<=512; i++){
			if(listM[i-1]<=1){
				x+=1;
			}
		}
		System.out.println(x);
	}
	
	public static void main(String[] args){
		Test3 test = new Test3();
		Thread thread = new Thread(test);
		Thread thread1 = new Thread(test);
		Thread thread2 = new Thread(test);
		thread.start();
		thread1.start();
		thread2.start();
	}

}
