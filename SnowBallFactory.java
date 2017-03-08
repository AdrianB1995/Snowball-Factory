package teamProject02;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class SnowBallFactory {
	static Random gen = new Random(System.currentTimeMillis());
	
	public static void main(String[] args) {
		ArrayList<SnowFlake> snowBall = new ArrayList<SnowFlake>();
		Scanner input = new Scanner(System.in);
		System.out.println("Snow Ball Factory up and running.");
		
		int balls = 3;
		for(int j = 0; j < balls; j++){
			System.out.print("\nEnter desired size of snowball to be created:");
			double desiredSize = input.nextDouble();
			
			System.out.println("Created snow ball of size : " + desiredSize);
			createSnowBall(desiredSize, 0, snowBall);

			// Snow ball analysis
			System.out.println("There are " + snowBall.size() + " snowFlakes.");
			double size = 0.0;
			for (SnowFlake s : snowBall) {
				size += s.getDiameter();
			}
			System.out.println("Actual Size " + size);

			// How long to melt?
			int minutes = 0;
			while (!snowBall.isEmpty()) {
				for (SnowFlake s : snowBall) {
					s.melt();
				}
				for (int i = snowBall.size() - 1; i >= 0; i--) {
					if (snowBall.get(i).getDiameter() < 1.0) {
						snowBall.remove(i);
					}
				}
				minutes++;
			}
			System.out.println("It took " + minutes + " minutes to melt the snowball.");
		}
		System.out.println("SnowFall : " + SnowFlake.snowFall);
		input.close();
		
	}
	
	public static void createSnowBall(double desiredSize, double currentSize, ArrayList<SnowFlake> snowball){
	//Add code here to recursively call createSnowBall.	
	}

	private static SnowFlake createSnowFlake() {
		//Add code to match the types which you have chosen to implement.
		int type = gen.nextInt(2) +1;
		switch(type){
		case(1):return new SimpleStar();
		case(2):return new StellarDentrites();
		}
		return null;
		
	}

}
