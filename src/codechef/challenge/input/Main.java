package codechef.challenge.input;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {

  public static void main(String[] args) throws Exception {

//    final InputStream stream = new FileInputStream("test_input.txt");
    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final String[] tokens = in.readLine().split(" ");
    
    final int inputCount = Integer.parseInt(tokens[0]);
    final int divisor = Integer.parseInt(tokens[1]);
    
    int divisibleCount = 0;
    for (int i = 0; i < inputCount; ++i) {
      
      final int value = Integer.parseInt(in.readLine());
      if( value % divisor == 0)
      {
        ++divisibleCount;
      }
    }
    
    System.out.println(divisibleCount);
  }
}
