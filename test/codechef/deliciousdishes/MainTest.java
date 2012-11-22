package codechef.deliciousdishes;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author lklwndski
 */
public class MainTest {

//  @Test
  public void test1() {
    
    for (Integer i = 1; i < 100; i++) {

      System.out.println("target " + i);
      
      
      System.out.println(" 9 x " + i.toString().length() + "! =" + (9*factorial(i.toString().length())));
    }
  }
//  @Test
  public void test() {
    final String[] regexs = new String[]{"[1-9]{1}",
//                                         "[1-9]0{1}[^0]*",
                                         "1[^1]*",
                                         "2[^2]*",
                                         "3[^3]*",
                                         "4[^4]*",
                                         "5[^5]*",
                                         "6[^6]*",
                                         "7[^7]*",
                                         "8[^8]*",
                                         "9[^9]*"};
//     final Pattern p = Pattern.compile(regex);

    int count = 0;

    //9 x length - 1 x something probably a power
    
    // 9 per 10
    // 18 per 100
    // 27 per 1000
    // 52 per 10000
    
    
    
//    10  x 1 - 1
    //10 x 2 - 11
    //10 x 3 - 291
    
    //1 - 9 = 0
    //1 - 99 = 9 
    //1 - 199 = 29
    //1 - 1999 = 469
    
    //110 - 199 = 18        
    //100 - 199 = 20
    //100 - 999 = 180   9 x 20 (20 x  1)
    //1000 - 1099 = 20
    //1000 - 9999 = 2520 9 x 280 x (20 x 14)
    //10000 - 99999 = 31680 9 x 3520 (20 x 176)
    // 9 x  41680 (20 x 2084) = 375120
    
    long before = System.currentTimeMillis();
    for (Integer i = 10; i <= 1999; i++) {
//       final Matcher m = p.matcher(i.toString());
//       System.out.println(m.start());
      boolean valid = false;

      if(i % 100 != 0)
      {
        
      
      for (String regex : regexs) {
        final boolean ignore = i.toString().matches(regex);
        valid |= ignore;
//        System.out.println(i.toString().matches(regex));
      }
      }
      if (!valid) {
        System.out.println(i + " " + ++count);
      }
    }

    long result = System.currentTimeMillis() - before;
    System.out.println(result /1000);
  }
  
  
  @Test
  public void testMain() throws Exception {

    String[] args = null;
    Main.main(args);

  }
  
  @Test
  public void baseTest()
  {
    assertEquals(1, findBase10(Long.valueOf("1")));
    assertEquals(10, findBase10(Long.valueOf("15")));
    assertEquals(100, findBase10(Long.valueOf("125")));
  }

  private int factorial(int length) {
    if(1 == length)
      return 1;
    
    return length * factorial(--length);
  }
  
  private long findPermutation(Long value)
  {
//    git@github.com:origineil02/com.codechef.programs.git
    return value; 
  }
  
  private long findBase10(Long value)
  {
    return (long)Math.pow(10, value.toString().length()-1);
  }
}
