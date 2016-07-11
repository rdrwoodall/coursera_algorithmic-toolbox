import java.util.*;

/* 

<< Problem Introduction >
	The Fibonacci numbers are defined as follows: F0 = 0, F1 = 1, and Fi = Fi−1 + Fi−2 for i ≥ 2.
<< Problem Description >>
	- Task. Given two integers n and m, output Fn mod m (that is, the remainder of Fn when divided by m).
	- Input Format. The input consists of two integers n and m given on the same line (separated by a space).
	- Constraints. 1 ≤ n ≤ 10^18, 2 ≤ m ≤ 10^5
<< Output Format >>
	Output Fn mod m.
<< Time Limits >>
	C: 1 sec, C++: 1 sec, Java: 1.5 sec, Python: 5 sec. C#: 1.5 sec, Haskell: 2 sec, JavaScript:
	3 sec, Ruby: 3 sec, Scala: 3 sec.
<< Memory Limit >>
	512Mb 
<< Sample 1 >>
	Input:
		281621358815590 30524
	Output:
		11963

*/

public class FibonacciHuge {
    private static long getFibonacciHuge(long n, long m) {
        //write your code here
        return 0;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        long m = scanner.nextLong();
        System.out.println(getFibonacciHuge(n, m));
    }
}

