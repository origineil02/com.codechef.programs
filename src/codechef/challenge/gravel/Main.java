package codechef.challenge.gravel;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Main {

  public static void main(String[] args) throws Exception {

    final InputStream stream = new FileInputStream("test_gravel.txt");
    // final InputStream stream = System.in;
    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    final String[] parameters = in.readLine().split(" ");
    final Integer heaps = Integer.parseInt(parameters[0]);
    final Integer operations = Integer.parseInt(parameters[1]);
    final Integer gravel = Integer.parseInt(parameters[2]);

    Map<Integer, Node> gravelHeap = new TreeMap<Integer, Node>();
    final Node node = new Node(1, heaps, gravel);
    for (int i = 1; i <= heaps; i++) {
      gravelHeap.put(i, node);
    }


    for (int i = 0; i < operations; i++) {
      String[] operation = in.readLine().split(" ");

      if ("Q".equals(operation[0])) {
        final Integer index = Integer.parseInt(operation[1]);
        System.out.println(gravelHeap.get(index).size);
      }
      else {
        final Integer from = Integer.parseInt(operation[1]);
        final Integer to = Integer.parseInt(operation[2]);
        final Integer pieces = Integer.parseInt(operation[3]);

        final Node blah = gravelHeap.get(from);

        if (!blah.requiresSplit(from, to)) {
          node.size += pieces;
        }
        else {
          node.split(from, to, pieces);
        }
      }
    }
  }

  private static class Node {

    private Integer from;
    private Integer to;
    Node siblingLeft;
    Node siblingRight;
    Integer size;
    Node parent;

    public Node(Integer from, Integer to, Integer size) {
      this.from = from;
      this.to = to;
      this.size = size;
    }

    private void split(Integer from, Integer to, Integer sizeAdjustment) {
      if (parent == null) {
        
        siblingLeft = new Node(this.from, from - 1, this.size);
        siblingLeft.parent = this;
        this.from = from;
        this.to = to;
        size += sizeAdjustment;
      }
      else {
        //determine affected nodes
        if(from < this.from)
        {
          parent.split(from, this.from, sizeAdjustment);
        }
      }
    }

    private boolean requiresSplit(Integer from, Integer to) {
      return this.from == from && this.to == to;
    }
  }
}