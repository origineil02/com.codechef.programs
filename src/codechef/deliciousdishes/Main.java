package codechef.deliciousdishes;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) throws Exception {
    final InputStream stream = new FileInputStream("test.txt");
//    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final Integer testCases = Integer.parseInt(in.readLine());

    for (int i = 0; i < testCases; ++i) {
      final String parameters = in.readLine();
      final String[] params = parameters.split("\\s");

      final Long begin = Long.parseLong(params[0]);
      final Long end = Long.parseLong(params[1]);

      //how many unique non repeating numbers up to the beginning
      Long b = determinePermutationsFor(begin);
      Long e = determinePermutationsFor(end);
      System.out.println(e - b);
    }
  }

  public static Long determinePermutationsFor(final Long value)
  {
    if(1 == value.toString().length())
    {
      return value-1;
    }
    
    final List<Integer> values = new ArrayList<Integer>();
    for (Character c : value.toString().toCharArray()) {
      
      final Integer cap = Integer.parseInt(c.toString());
      values.add(0 == cap ? 0 : cap);
    }
    
    
    Integer result = 1;
    for (Integer integer : values) {
      result *= integer;
    }
    
    final Integer x = result + determinePermutationsUpTo(value.toString().length()-1);
    return Long.valueOf(x.toString());
  }

  private static int determinePermutationsUpTo(Integer i) {
    
    if(i <= 1)
    {
      return 9;
    }
    int value = 1;
    for (int j = 0; j < i; j++) {
      value *= j == 1 ? 9 : (9-j);
    }
    
    return value + determinePermutationsUpTo(i-1);
  }
}
