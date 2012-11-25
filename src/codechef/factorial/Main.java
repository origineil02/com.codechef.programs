package codechef.factorial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {

//    final InputStream stream = new FileInputStream("test_factorial.txt");
    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final Integer testCases = Integer.parseInt(in.readLine());

    for (int i = 0; i < testCases; i++) {

      final Long value = Long.parseLong(in.readLine());
      BigInteger factorial = factorial(BigInteger.valueOf(value));

      int count = 0;
      for (int index = factorial.toString().length() - 1; index > 0; index--) {

        if (factorial.toString().charAt(index) == '0') {
          count++;
        }
        else {
          break;
        }
      }

      System.out.println(count);
    }

  }

  public static BigInteger factorial(BigInteger value) {
    if (BigInteger.ONE.equals(value)) {
      return BigInteger.ONE;
    }

    value = value.multiply(factorial(value.subtract(BigInteger.ONE)));
    return value;
  }
}
