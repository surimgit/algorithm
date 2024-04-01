package group;

public class Ex0103 {
	
	static int[] cols = new int[9];
	static int count = 0;

	public static void main(String[] args) {
		queens(1); 
		System.out.println(count);
		
	}
	public static void queens( int level ) {
		if(level == 9) {
			count++;
			for(int i = 1; i <= 8;i++)
			System.out.print(cols[i]);
			System.out.println();
			return;
		}
		for (int i=1; i<=8; i++) {
			cols[level] = i;
			if (promising(level))
				queens(level+1);
		}
	}
	
	public static boolean promising(int level){
		 for (int i=1; i<level; i++) {
			 if (cols[i]==cols[level])
				 return false;
			 else if (level-i == Math.abs(cols[level]-cols[i]))
				 return false;
		 }
		 return true;
	}
	
	
}
