package codechef.challenge.factorial;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;
import static java.math.BigInteger.ZERO;

public class Main {

  public static final BigInteger FIVE = new BigInteger("5");
  public static void main(String[] args) throws Exception {

//    final InputStream stream = new FileInputStream("test_factorial.txt");
    final InputStream stream = System.in;

    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final Integer testCases = Integer.parseInt(in.readLine());

    for (int i = 0; i < testCases; i++) {

      final BigInteger value = new BigInteger(in.readLine()) ;
      System.out.println(calculate0s(value));
    }

  }

public static long calculate0s(BigInteger value)
  {
    int count = 0;
    
    if (value.compareTo(FIVE) < 0)
    {
      return 0;
    }
    
    if (value.compareTo(FIVE) == 0)
    {
      count++;
      return count;
    }
    
    for (BigInteger i = FIVE; i.compareTo(value) <= 0; i = i.add(FIVE))
    {
      count += howManyTimesCanIDivideBy5For(i);
    }
    return count;
  }
  
  public static int howManyTimesCanIDivideBy5For(BigInteger value)
  {
    if (value.remainder(FIVE).compareTo(ZERO) != 0)
    {
      //fix the value down to the nearest multiple of 5
      String x = value.toString();
      
      String lastNumber = x.substring(x.length() - 1);
      Integer i = Integer.parseInt(lastNumber);
      String fixedValue = x.substring(0, x.length() - 1).concat(i < 5 ? "0" : "5");
      return howManyTimesCanIDivideBy5For(new BigInteger(fixedValue));
    }
    
    int count = 0;
    for (BigInteger i = value; i.compareTo(FIVE) >= 0; i = i.divide(FIVE))
    {
      if (i.remainder(FIVE).compareTo(ZERO) == 0)
      {
        count++;
      }
      else
      {
        break;
      }
    }
    
    return count;
  }
}
