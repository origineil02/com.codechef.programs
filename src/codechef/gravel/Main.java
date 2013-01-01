package codechef.gravel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Arrays;

class Main {

  public static void main(String[] args) throws Exception {

    //final InputStream stream = new FileInputStream("test_gravel.txt");
      final InputStream stream = System.in;
    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final String[] parameters = in.readLine().split(" ");
    final Integer heaps = Integer.parseInt(parameters[0]);
    final Integer operations = Integer.parseInt(parameters[1]);
    final Integer gravel = Integer.parseInt(parameters[2]);
    
    final int gravelHeaps[] = new int[heaps];
    Arrays.fill(gravelHeaps, 0, heaps-1, gravel);
    
    for (int i = 0; i < operations; i++) {
      String[] operation = in.readLine().split(" ");
      
      if("Q".equals(operation[0]))
      {
        final Integer index = Integer.parseInt(operation[1]);
        System.out.println(gravelHeaps[index-1]);
      }
      else
      {
        final Integer from = Integer.parseInt(operation[1]);
        final Integer to = Integer.parseInt(operation[2]);
        final Integer pieces = Integer.parseInt(operation[3]);
        
        for (int j = from-1; j <= to-1; j++) {
          gravelHeaps[j] += pieces;
        }
      }
    }
  }
}