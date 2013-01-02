package codechef.chefoftheyear;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {

  public static void main(String[] args) throws Exception {

    //final InputStream stream = new FileInputStream("test_chefoftheyear.txt");
    final InputStream stream = System.in;
    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    String[] parameters = in.readLine().split(" ");
    final int chefsToRead = Integer.parseInt(parameters[0]);
    final int emails = Integer.parseInt(parameters[1]);

    //minimum requirments
    //able to lookup country by chef name
    //tally countries
    //tally chef name

    if (chefsToRead == 1) {
      parameters = in.readLine().split(" ");
      System.out.println(parameters[1]);
      System.out.println(parameters[0]);
      return;
    }

    final Map<String, Node> chefToCountry = new HashMap<String, Node>();
    final Map<String, Node> chefToChef = new HashMap<String, Node>();
    final Map<String, Node> countryToCountry = new HashMap<String, Node>();

    for (int i = 0; i < chefsToRead; ++i) {
      parameters = in.readLine().split(" ");

      if (countryToCountry.containsKey(parameters[1])) {
        chefToCountry.put(parameters[0], countryToCountry.get(parameters[1]));
      }
      else {
        Node country = new Node(parameters[1]);
        chefToCountry.put(parameters[0], country);
        countryToCountry.put(parameters[1], country);
      }

      chefToChef.put(parameters[0], new Node(parameters[0]));
    }

    Node chef = null;
    Node country = null;
    boolean firstPass = true;
    for (int i = 0; i < emails; ++i) {
      final String subject = in.readLine();

      if (firstPass) {
        chef = chefToChef.get(subject);
        chef.votes++;

        country = chefToCountry.get(subject);
        country.votes++;

        firstPass = false;
      }
      else {
        Node currentChef = chefToChef.get(subject);
        currentChef.votes++;
        chef = handleNode(currentChef, chef);

        Node currentCountry = chefToCountry.get(subject);
        currentCountry.votes++;
        country = handleNode(currentCountry, country);
      }
    }

    System.out.println(country.data);
    System.out.println(chef.data);
  }

  private static Node handleNode(Node current, Node node) {
    if (current.data.compareTo(node.data) != 0) {
      if (current.votes > node.votes) {
        node = current;
      }
      else if (current.votes == node.votes && current.data.compareTo(node.data) < 0) {
        node = current;
      }
    }
    return node;
  }

  private static class Node {

    String data;
    int votes = 0;

    public Node(String data) {
      this.data = data;
    }

    @Override
    public String toString() {
      return "Node{" + "data=" + data + ' ' + votes + '}';
    }
  }
}
