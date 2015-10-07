import java.util.Arrays;

/*
@author Ariel Ancer 
@date 2/15/2014
Assignment 2 - Building chips.
 */

public class chipClass2 extends chipClass{
	 	
	  /*
	|   a   |   b   |  sum  | carry |
	|   0   |   0   |   0   |   0   |
	|   0   |   1   |   1   |   0   |
	|   1   |   0   |   1   |   0   |
	|   1   |   1   |   0   |   1   |
		 */

	public int[] halfAdder(int a, int b){
		int[] arr = new int[2];
		arr[0] = xor(a,b);
		arr[1] = and(a,b);
		return arr;
	}

	/*
	|   a   |   b   |   c   |  sum  | carry |
	|   0   |   0   |   0   |   0   |   0   |
	|   0   |   0   |   1   |   1   |   0   |
	|   0   |   1   |   0   |   1   |   0   |
	|   0   |   1   |   1   |   0   |   1   |
	|   1   |   0   |   0   |   1   |   0   |
	|   1   |   0   |   1   |   0   |   1   |
	|   1   |   1   |   0   |   0   |   1   |
	|   1   |   1   |   1   |   1   |   1   |
	 */

	public int[] fullAdder(int a, int b, int c){
	int[] arr = new int[2];
	arr[0] = xor(xor(a,b),c);
	arr[1] = xor(and(a,b),and(xor(a,b),c));
	return arr;
	}

	/*
	|        a         |        b         |       out        |
	| 0000000000000000 | 0000000000000000 | 0000000000000000 |
	| 0000000000000000 | 1111111111111111 | 1111111111111111 |
	| 1111111111111111 | 1111111111111111 | 1111111111111110 |
	| 1010101010101010 | 0101010101010101 | 1111111111111111 |
	| 0011110011000011 | 0000111111110000 | 0100110010110011 |
	| 0001001000110100 | 1001100001110110 | 1010101010101010 |
	 */

	public int[] add16(int[] a, int[] b){
		
		int[] arr = new int[16];
		int c = halfAdder(a[15],b[15])[1];
		arr[15] = halfAdder(a[15],b[15])[0];
		
		for(int i=14;i>=0;i--){
			arr[i] = fullAdder(a[i],b[i],c)[0];
			c = fullAdder(a[i],b[i],c)[1];	
		}
		
		return arr;
	}

	/*
	|        in        |       out        |
	| 0000000000000000 | 0000000000000001 |
	| 1111111111111111 | 0000000000000000 |
	| 0000000000000101 | 0000000000000110 |
	| 1111111111111011 | 1111111111111100 | 
	 */

	public int[] inc16(int[] a){
		
		int[] inc = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		
		return add16(a,inc);
	}

	/*
	 * Testing material for alu chip not included as is too large.
	 * Link to testing material provided : http://www.nand2tetris.org/02.php
	 */

	public int[] alu(int[] x, int[] y, int zx, int nx, int zy, int ny, int f, int no){
		
		int[] arr = new int[16];
		int[] zero = {0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0};
		int[] a = new int[16];
		int[] b = new int[16];
		int[] res = new int[18];
		
		x = mux16(x,zero,zx);
		a = x.clone();
		x = mux16(x,not16(a),nx);
		
		y = mux16(y,zero,zy);
		b = y.clone();
		y = mux16(y,not16(b),ny);
		
		a = x.clone();
		b = y.clone();
		arr = mux16(arr,add16(x,y),f);
		
		arr = mux16(and16(a,b),arr,f);
		a = arr.clone();
		arr = mux16(arr,not16(a),no);
		
		for(int i = 0; i<16;i++){
			res[i] = arr[i];
		}
		
		res[16] = not(or(or8way(Arrays.copyOfRange(arr, 0, 8)),or8way(Arrays.copyOfRange(arr, 8, 16))));
		res[17] = and(arr[0],1);		
		
		return res;
	}
}
