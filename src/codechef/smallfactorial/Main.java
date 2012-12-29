package codechef.smallfactorial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import static java.math.BigInteger.ONE;

public class Main {

  public static void main(final String[] args) throws IOException {
//    final InputStream stream = new FileInputStream("test_small_factorial.txt");
    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final int linesToRead = Integer.parseInt(in.readLine());

    int input = 1;
    for (int i = 0; i < linesToRead; ++i) {
      input = Integer.parseInt(in.readLine());
      System.out.println(factorial(input));
    }
  }

  public static BigInteger factorial(Integer value) {

    BigInteger result = ONE;
    while (value != 1) {
      result = result.multiply(BigInteger.valueOf(value));
      --value;
    }

    return result;
  }
}