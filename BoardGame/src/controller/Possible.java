package controller;

public class Possible {
	static int n = 360;
	public static boolean roll (int dice) {
		//int i = 0;
		int mut = 1;
		int num;
		int num1;
	 	if(dice < n ){
				n= n-dice;
				System.out.println("Spaces rolled "+ dice +" ends in "+n);
				for(int i=1; i<=6;i++){
					int m = 1;
					do{
						dice= i;
						num=dice*m;
						m++;
						if(num == n){
							System.out.println("Possible: roll " +m+" number " +dice);
						}
					}while(num < n);
					
				}
				for(int i=1; i<=6;i++){
				int d1 = 1, d2 = 2, d3 = 3, d4 = 4, d5 = 5, d6 = 6;
//				for(int d1=1; d1<=6; d1++){
//					for(int d2=1; d2<=6; d2++){
//						for(int d3=1; d3<=6; d3++){
//							for(int d4=1; d4<=6; d4++){
//								for(int d5=1; d5<=6; d5++){
//									for(int d6=1; d6<=6; d6++){
										do{
											num1 = d1*mut+d2*mut+d3*mut+d4*mut+d5*mut+d6*mut;
											mut++;
										if(num1 == n){
										System.out.println("Possible: roll " +mut+" number " +d1+" + "+mut+" number " +d2+" + "
												+mut+" number " +d3+" + "+mut+" number " +d4+" + "+mut+" number " +d5+" + "+mut+" number " +d6);
										
										}
										}while(num1 < n);
				}
//									}
//								}
//							}
//						}
//					}
//					
//				}
				
									
				return false;
}else{
	System.out.println("Finish!!");
		return true;
}
	}
}
