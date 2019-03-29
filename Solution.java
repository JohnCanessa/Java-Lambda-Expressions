import java.io.*;
import java.util.*;


/*
 * 
 */
interface PerformOperation {
	boolean check(int a);
}


/*
 * 
 */
class MyMath {
	
	// **** ****
	public static boolean checker(PerformOperation p, int num) {
		return p.check(num);
	}

	// **** check if a number is odd ****
	public PerformOperation isOdd() {
		
		// ???? ????
		return (num) -> {
			if (num % 2 != 0)
				return true;
			else
				return false;
		};
		
		// **** ****
//		return (num) -> num % 2 != 0;
	}
	
	// **** check is number is a palindrome ****
	public PerformOperation isPalindrome() {
		
		// ???? ????
		return (num) -> {
			String s = String.valueOf(num);
			String r = (new StringBuffer(s).reverse()).toString();
			return s.equals(r);
		};
		
		// **** ****
//		return (num) -> (String.valueOf(num).equalsIgnoreCase(new StringBuffer(String.valueOf(num)).reverse().toString()));
	}
	
	// **** ****
	public PerformOperation isPrime() {
		
		// ???? ????
		return (num) -> {
			boolean flag = true;
			
			if (num <= 1)
				flag = false;
			else {
				int sr = (int)Math.sqrt(num);
				
				for (int i = 2; i <= sr && flag; i++) {
					
					for (int j = i * i; j <= num; j += i) {
						if (j == num) {
							flag = false;
							break;
						}
					}
					
				}

			}

			return flag;
		};
		
		// **** ****
//		return (num) -> num > 1 && java.util.stream.IntStream.range(2, num - 1).noneMatch(index->num % index == 0);
	}

}

 
 /*
  * 
  */
public class Solution {

	public static void main(String[] args) throws IOException {
		  MyMath ob = new MyMath();
		  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		  int T = Integer.parseInt(br.readLine());
		  PerformOperation op;
		  boolean ret = false;
		  String ans = null;
		  while (T--> 0) {
		   String s = br.readLine().trim();
		   StringTokenizer st = new StringTokenizer(s);
		   int ch = Integer.parseInt(st.nextToken());
		   int num = Integer.parseInt(st.nextToken());
		   if (ch == 1) {
		    op = ob.isOdd();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "ODD" : "EVEN";
		   } else if (ch == 2) {
		    op = ob.isPrime();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PRIME" : "COMPOSITE";
		   } else if (ch == 3) {
		    op = ob.isPalindrome();
		    ret = ob.checker(op, num);
		    ans = (ret) ? "PALINDROME" : "NOT PALINDROME";

		   }
		   System.out.println(ans);
		  }
	}

}
