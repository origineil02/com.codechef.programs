package codechef.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

  public static void main(String[] args) throws Exception {

//    final InputStream stream = new FileInputStream("test_input.txt");
    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final String[] tokens = in.readLine().split(" ");
    
    final BigInteger inputCount = new BigInteger(tokens[0]);
    final BigInteger divisor = new BigInteger(tokens[1]);
    
    BigInteger number = BigInteger.ZERO;
    int divisibleCount = 0;
    for (BigInteger i = BigInteger.ZERO; i.compareTo(inputCount) < 0; i = i.add(BigInteger.ONE)) {
      number = new BigInteger(in.readLine());
      
      if(number.remainder(divisor).compareTo(BigInteger.ZERO) == 0)
      {
        divisibleCount++;
      }
    }
    
    System.out.println(divisibleCount);
  }
}
