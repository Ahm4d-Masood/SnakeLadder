import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class Snake_ladder {
public static void main(String[] args) {
		ImageIcon first = new ImageIcon("src//first.gif");
		ImageIcon exit = new ImageIcon("src//exit.gif");
		ImageIcon win = new ImageIcon("src//win.gif");
		ImageIcon ladder = new ImageIcon("src//ladder.gif");
		ImageIcon snake = new ImageIcon("src//snake.gif");
		
		JOptionPane.showMessageDialog(null, "Welcome","Snake Ladder", 1);
		
		
		String player_one = "";
		player_one =  (String) JOptionPane.showInputDialog(null ,"enter your name","first player name" , JOptionPane.INFORMATION_MESSAGE, null , null ,"");
		if (player_one == null) {		player_one = "Player 1";}else
		if (player_one.length() <1) {		player_one = "Player 1";}
		System.out.println(player_one+" == ♫");
		
		String player_two = "";
		player_two =  (String) JOptionPane.showInputDialog(null ,"enter your name","first player name" , JOptionPane.INFORMATION_MESSAGE, null , null ,"");
		if (player_two == null) {		player_two = "Player 2";}else
		if (player_two.length() <1) {		player_two = "Player 2";}
		System.out.println(player_two+" == ♥");
		System.out.println("----------------------------------------------------------------");
		int place1 = 0;
		int place2 = 0;
		int Dice1 = dice();
		int Dice2 = dice();
		int A1 = 0;
		int A2= 0;
		int Strt = JOptionPane.showConfirmDialog(null,player_one +" and "+player_two+" will roll the dice who get the bigger number will play first", " Snake Ladder", 1);
		if(Strt==0) {
		while (Dice1 == Dice2) {
			Dice1 = dice();
			Dice2 = dice();
		}
		
		if(Dice1>Dice2) {
			JOptionPane.showMessageDialog(null , player_one+" get "+Dice1 + " || "+player_two +" get "+Dice2 +"\n"+ player_one +" get bigger number will start first" , "Snake ladder",JOptionPane.INFORMATION_MESSAGE, first);
			
			A1+=1;
		}else {
			JOptionPane.showMessageDialog(null , player_one+" get "+Dice1 + " || "+player_two +" get "+Dice2 +"\n"+ player_two +" get bigger number will start first" , "Snake ladder",JOptionPane.INFORMATION_MESSAGE, first);
			A2+=1;
		}
		
		while(true) {
			 if (place2==100) {
					JOptionPane.showMessageDialog(null, "Congratilation "+player_two+" you win Excelent game", "Snake Ladder",JOptionPane.INFORMATION_MESSAGE, win);
					break;
				}
			 if (place1==100) {
					JOptionPane.showMessageDialog(null, "Congratilation "+player_one+" you win Excelent game", "Snake Ladder",JOptionPane.INFORMATION_MESSAGE, win);
					break;
				}
			if(A1>A2) {
				int cont = JOptionPane.showConfirmDialog(null,player_one+" Do you want to continue",player_one+" Roll the dice ",0);
				if (cont == 0) {
					Dice1 = dice();
					JOptionPane.showMessageDialog(null, player_one+" get "+Dice1, "Snake Ladder",1);
					place1+=Dice1;
					if(place1>100) {
						JOptionPane.showMessageDialog(null, player_one+" you get bigger than 100 you will be in your position ", "Snake Ladder",1);
						place1-=Dice1;
					}
					A2+=2;
					
					/////System.out.println(player_one+" get "+Dice1 + " || " + player_one + " is on position "+ place1);
				
					if(place1 ==4||place1==9||place1==20||place1==28||place1==40||place1==51||place1==63||place1==71) {
						JOptionPane.showMessageDialog(null, "Congratulation "+player_one+ " you are on ladder", "ladder",JOptionPane.INFORMATION_MESSAGE, ladder);
						
						int ladd = ladder(place1);
						place1=ladd;
						JOptionPane.showMessageDialog(null, player_one+" your position now is "+place1, "ladder",1);
						//System.out.println(player11+" you cross ladder, your position is "+place1);
					}
					if(place1==17||place1==54||place1==62||place1==64||place1==87||place1==93||place1==95||place1==99) {
						JOptionPane.showMessageDialog(null, "Sadnlly "+player_one+ " the snake ate you", "snake",JOptionPane.INFORMATION_MESSAGE, snake);
						int snak = snake(place1);
						place1=snak;
						JOptionPane.showMessageDialog(null, player_one+" , your position now is "+place1, "Snake",1);
						//System.out.println(player11+" Snake ate you, your position is "+place1);
					}
					
					
				}else {
					JOptionPane.showMessageDialog(null, player_one+ " Exited the game "+player_two+" win", "Snake ladder",JOptionPane.INFORMATION_MESSAGE, exit);
					break;
				}
				
			}else {
				int cont = JOptionPane.showConfirmDialog(null,player_two+" Do you want to continue",player_two+" Roll the dice ",0);
				if(cont==0) {
					Dice2=dice();
					place2+=Dice2;
					JOptionPane.showMessageDialog(null, player_two+" get "+Dice2, "Snake Ladder",1);
					if(place2>100) {
						JOptionPane.showMessageDialog(null, player_two+" you get bigger than 100 you will be in your position ", "Snake Ladder",1);
						place2-=Dice2;
					}
				    A1+=2;
				    
				    //System.out.println(player_two+" get "+Dice2 + " || " + player_two + " is on position "+ place2);
				
				    if(place2 ==4||place2==9||place2==20||place2==28||place2==40||place2==51||place2==63||place2==71) {
						JOptionPane.showMessageDialog(null, "Congratulation "+player_two+ " you are on ladder", "ladder",JOptionPane.INFORMATION_MESSAGE, ladder);
						int ladd = ladder(place2);
						place1=ladd;
						JOptionPane.showMessageDialog(null, player_two+" your position now is "+place2, "ladder",1);
						//System.out.println(player_two+" you cross ladder, your position is "+place2);
					}
				    
				    if(place2==17||place2==54||place2==62||place2==64||place2==87||place2==93||place2==95||place2==99) {
						JOptionPane.showMessageDialog(null, "Sadnlly "+player_two+ " the snake ate you", "snake",JOptionPane.INFORMATION_MESSAGE, snake);
						int snak = snake(place2);
						place2=snak;
						JOptionPane.showMessageDialog(null, player_two+" your position now is "+place2, "Snake",1);
						//System.out.println(player_two+"  Snake ate you, your position is "+place2);
					}
				    
				   
				}else {
					JOptionPane.showMessageDialog(null, player_two+ " Exited the game "+player_one+" win", "Snake ladder", JOptionPane.INFORMATION_MESSAGE, exit);
					break;
				}
			}
			table(place1,place2);
			System.out.println();
			System.out.println();
			System.out.println(player_one + " ==>♫"+"\t"+player_one + " is on position ==>"+ place1);
			System.out.println(player_two + " ==>♥"+"\t"+player_two + " is on position ==>"+ place2);
			System.out.println("----------------------------------------------------------------------------------------------------");
			}
			
	
		
		
	 
	}else{
		JOptionPane.showMessageDialog(null, "You exited the game", "Snake Ladder", 1);
	}
		
	}
	//---------------------------------------------------------------------------------
	
	public static int dice() {
		int dic=0;
		while (dic==0) {
			dic =(int) (Math.random()*7);
		}
		return dic;
	}
	//-----------------------------------------------------------------------------------
	public static int ladder(int r) {
		
		int [] position= {4,9,20,28,40,51,63,71,   14,31,38,84,59,67,81,91};
		int []after_ladder=new int[position.length/2];
		for(int i=0; i<position.length/2;i++) {
			after_ladder[i]=position[8+i];
			if(position[i]==r) {
				r=after_ladder[i];
			}
		}
		return r;
		
	}
	//-----------------------------------------------------------------------------------
	public static int snake(int a) {
		int position[] = {17,54,62,64,87,93,95,99  ,7,34,19,60,24,73,75,78};
		int []after_Snake=new int[position.length/2];
		for(int i=0; i<position.length/2;i++) {
			after_Snake[i]=position[8+i];
			if(position[i]==a) {
				a=after_Snake[i];
			}
		}
		return a;
		//-----------------------------------------------------------------------------------
	}
	public static void table(int position1,int position2) {
		int[] poss90 = {100, 99 ,98 ,97 ,96 ,95,94 ,93 ,92 ,91 };
		int[] poss80 = {81 , 82 ,83 ,84 ,85 ,86 ,87 ,88 ,89 ,90 };
		int[] poss70 = {80, 79 ,78 ,77 ,76 ,75 ,74 ,73 ,72 ,71 };
		int[] poss60 = {61 , 62,63 ,64,65 ,66 ,67 ,68 ,69 ,70 };
		int[] poss50 = {60 , 59 ,58 ,57 ,56 ,55 ,54 ,53 ,52 ,51 };
		int[] poss40 = {41 , 42,43,44 ,45 ,46 ,47 ,48 ,49 ,50 };
		int[] poss30 = {40 , 39 ,38 ,37 ,36 ,35 ,34 ,33 ,32 ,31 };
		int[] poss20 = {21 , 22 ,23 ,24 ,25 ,26 ,27 ,28 ,29 ,30 };
		int[] poss10 = {20 , 19 ,18 ,17 ,16 ,15 ,14 ,13 ,12 ,11 };
		int[] poss1  = {1 , 2 ,3 ,4 ,5 ,6 ,7 ,8 ,9 ,10 };
		
		
		for(boolean i=true; i==true; ) {
			for(int j=0; j<poss90.length;j++) {
				if(poss90[j]==position1 || poss90[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss90[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss90[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss90[j]+" ");
					}}
			System.out.println();
			for(int j=0; j<poss80.length;j++) {
				if(poss80[j]==position1 || poss80[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss80[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss80[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}
					}}else {
					System.out.print(poss80[j]+" ");
					}}
			System.out.println();
			for(int j=0; j<poss70.length;j++) {
				if(poss70[j]==position1 || poss70[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss70[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss70[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}
					}}else {
					System.out.print(poss70[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss60.length;j++) {
				if(poss60[j]==position1 || poss60[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss60[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss60[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss60[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss50.length;j++) {
				if(poss50[j]==position1 || poss50[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss50[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss50[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss50[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss40.length;j++) {
				
				if(poss40[j]==position1 || poss40[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss40[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss40[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}
				else {
						System.out.print(poss40[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss30.length;j++) {
				if(poss30[j]==position1 || poss30[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss30[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss30[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss30[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss20.length;j++) {
				if(poss20[j]==position1 || poss20[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss20[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss20[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss20[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss10.length;j++) {
				if(poss10[j]==position1 || poss10[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss10[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss10[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(poss10[j]+" ");
					}
			}
			System.out.println();
			for(int j=0; j<poss1.length;j++) {
				if(poss1[j]==position1 || poss1[j]==position2 ) {
					if(position1==position2) {
						System.out.print(" "+"♥♫"+" ");
					}else {
						if (poss1[j]==position1) {
							System.out.print(" "+"♫"+" ");
						}
						if(poss1[j]==position2) {
							System.out.print(" "+"♥"+" ");
						}}}else {
						System.out.print(" "+poss1[j]+" ");
					}
			}
			break;
		}
	}

}
