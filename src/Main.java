import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(fact(n));
    }

    public static BigInteger fact(int n) {
        BigInteger ans = new BigInteger("1");
        for (int i = 1; i < n + 1; ++i) {
            BigInteger BigI = new BigInteger(String.format("%d", i));
            ans = ans.multiply(BigI);
        }
        return ans;
    }
}
