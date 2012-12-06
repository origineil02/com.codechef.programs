
package codechef.factorial;

import java.math.BigInteger;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author lklwndski
 */
public class MainTest {
  
 
  @Test
  public void testMain() throws Exception {
    String[] args = null;
    BigInteger factorial = Main.factorial(BigInteger.valueOf(100000));
    System.out.println(factorial.toString());
  }
  
  @Test
  public void testIteration() throws Exception {
    String[] args = null;
    BigInteger factorial = Main.factorialInteration(BigInteger.valueOf(500000));
    System.out.println(factorial.toString());
  }
  
  @Test
  public void testFactorial() throws Exception {
//    String[] args = null;
//    BigInteger factorial = BigInteger.ONE;
//    factorial = Main.factorial(factorial, BigInteger.valueOf(100000));
//    System.out.println(factorial.toString());

    for (int i = 15624; i < 15626; i++) {
      System.out.print(i + " ");
      BigInteger value = Main.factorialInteration(BigInteger.valueOf(i));
      Main.printTrailingZeros(value);
    }
  }
  
  @Test
  public void test()
  {
    final BigInteger value =BigInteger.valueOf(24);
    
    BigInteger factorial = Main.factorial(value.divide(BigInteger.valueOf(2)));
    System.out.println(factorial);
    System.out.println("--");
    Main.printTrailingZeros(factorial);
    
    
//    System.out.println(Main.factorial(BigInteger.valueOf(2).multiply(Main.factorial(BigInteger.valueOf(5)))));
  }
  
  /* 24-5 skip 5
   * 49-50 skip 11
   * 74-5 skip 17
   * 99-100 skip 23
   * 124-5 skip 29,30
   * 149-50 skip 36
   * 174-5 skip 42
   * 199-200 skip 48
   * 224-5 skip 54
   * 250 skip 60,61
   * 275 skip 67
   * 300 skip 73
   * 325 skip 79
   * 350 skip 85
   * 375 skip 91,92
   * 400 skip 98
   * 425 skip 104
   * 450 skip 110
   * 475 skip 116
   * 500 skip 122,123
   * 
   * 625 skip 153,4,5
   * 
   * 750 skip 185,6
   * 
   * 875 skip 216,7
   * 
   * 1250 skip 309,10,11
   * 
   * 3125 skip 777,8,9,80
   */
 }
