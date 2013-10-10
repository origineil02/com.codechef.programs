package codechef.deliciousdishes;

import codechef.challenge.deliciousdishes.Main;
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
  public void testPermutationByValue()
  {
    for (long i = 1; i < 10; i++) {
      assertEquals(i, (long)Main.determinePermutationsFor(i));
    }
    
    assertEquals(10, (long)Main.determinePermutationsFor(10L));
    assertEquals(10, (long)Main.determinePermutationsFor(11L));
    assertEquals(11, (long)Main.determinePermutationsFor(12L));
    assertEquals(12, (long)Main.determinePermutationsFor(13L));
    assertEquals(18, (long)Main.determinePermutationsFor(19L));
    
//    assertEquals(21, (long)Main.determinePermutationsFor(21L));
//    assertEquals(21, (long)Main.determinePermutationsFor(22L));
//    assertEquals(22, (long)Main.determinePermutationsFor(23L));
    
//    assertEquals(47, (long)Main.determinePermutationsFor(50L));
    
//    assertEquals(30, (long)Main.determinePermutationsFor(33L));
    
//    assertEquals(80, (long)Main.determinePermutationsFor(83L));
    
    assertEquals(90, (long)Main.determinePermutationsFor(99L));
    assertEquals(90, (long)Main.determinePermutationsFor(100L));
    assertEquals(90, (long)Main.determinePermutationsFor(101L));
    assertEquals(91, (long)Main.determinePermutationsFor(102L));
  }
  
}
