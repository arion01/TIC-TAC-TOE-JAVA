

import java.util.Arrays;
import java.util.Scanner;

public class Board {
	
	private static char[][] brd;
	private static char k;
	private static int  n;
	private static Scanner scn = new Scanner(System.in);
	
	public static void show(){
		
		System.out.println("*********");
		
		brd = new char[][]{
			{'1','2','3'},
			{'4','5','6'},
			{'7','8','9'},
		};	
		
		outArr();
			
		System.out.println("Введите число в которое хотите поместить  :");
		
		if(random(3,9) > 5) k = 'x';
		
		if(k == 'x'){
			k = 'x';
		}else {
			k = 'o';
		}
		
		System.out.println("Ход у игрока -> " + k);
	
		
		while (check() != true) {
			
			n = scn.nextInt();
			
			if (n == 1) {
				brd[0][0] = k;
			}else if (n == 2) {
				brd[0][1] = k;
			}else if (n == 3) {
				brd[0][2] = k;
			}else if (n == 4) {		
				brd[1][0] = k;
			}else if (n == 5) {
				brd[1][1] = k;
			}else if (n == 6) {
				brd[1][2] = k;
			}else if (n == 7) {
				brd[2][0] = k;
			}else if (n == 8) {
				brd[2][1] = k;
			}else if (n == 9) {
				brd[2][2] = k;
			}
			
			if(check() == true){
				System.out.println("Выиграл игрок -> " + k);
				break;
			}else{
				outArr();
				check();
				
				if(k == 'x'){
					k = 'o';
				}else {
					k = 'x';
				}			
	     		System.out.println("Ход у игрока -> " + k);						
			}
		}
	}
	
	public static boolean check(){
		//row	
		if( brd[0][0] == 'x' && brd[0][1] == 'x' && brd[0][2] == 'x' || //1,2,3
		    brd[0][0] == 'o' && brd[0][1] == 'o' && brd[0][2] == 'o'){	
			return true;		
		} 
		if( brd[1][0] == 'x' && brd[1][1] == 'x' && brd[1][2] == 'x' || //4,5,6
		    brd[1][0] == 'o' && brd[1][1] == 'o' && brd[1][2] == 'o'){
			return true;
		}
		if( brd[2][0] == 'x' && brd[2][1] == 'x' && brd[2][2] == 'x' || //7,8,9
		    brd[2][0] == 'o' && brd[2][1] == 'o' && brd[2][2] == 'o'){
			return true;
		}	
		//diagonal
		if( brd[0][0] == 'x' && brd[1][1] == 'x' && brd[2][2] == 'x' || //1,5,9
		    brd[0][0] == 'o' && brd[1][1] == 'o' && brd[2][2] == 'o'){	
			return true;
    	}
		if( brd[2][0] == 'x' && brd[1][1] == 'x' && brd[0][2] == 'x' || //7,5,3
		    brd[2][0] == 'o' && brd[1][1] == 'o' && brd[0][2] == 'o'){	
			return true;
		}
		//col
		if( brd[0][0] == 'x' && brd[1][0] == 'x' && brd[2][0] == 'x' || //1,4,7
		    brd[0][0] == 'o' && brd[1][0] == 'o' && brd[2][0] == 'o'){	
			return true;
		}
		if( brd[0][1] == 'x' && brd[1][1] == 'x' && brd[2][1] == 'x' || //2,5,8
		    brd[0][1] == 'o' && brd[1][1] == 'o' && brd[2][1] == 'o'){
			return true;
		}
		if( brd[2][0] == 'x' && brd[2][1] == 'x' && brd[2][2] == 'x' || //7,8,9
		    brd[2][0] == 'o' && brd[2][1] == 'o' && brd[2][2] == 'o'){		
			return true;
		}
		return false;
	}
	
	public static void outArr(){
		for (int i = 0; i < brd.length; i++) {
			for (int j = 0; j < brd.length; j++) {
				System.out.print(Arrays.asList(brd[i][j]));
			}
			System.out.println();
		}
	}
	
	private static int random(int min, int max){
		return (int) Math.floor(Math.random() * (max - min) + min);
	}
}
