package codechef.challenge.chefoftheyear;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public class Main_Old {

  public static void main(String[] args) throws Exception {

    final InputStream stream = new FileInputStream("test_chefoftheyear.txt");
    // final InputStream stream = System.in;
    final BufferedReader in = new BufferedReader(new InputStreamReader(stream));
    String[] parameters = in.readLine().split(" ");
    final Integer chefsToRead = Integer.parseInt(parameters[0]);
    final Integer emails = Integer.parseInt(parameters[1]);

    final Map<String, ChefNode> chefToData = new HashMap<String, ChefNode>();
    final Map<String, CountryNode> countryData = new HashMap<String, CountryNode>();
    final Map<Integer, Set<String>> votesToChefs = new HashMap<Integer, Set<String>>();
    final Map<Integer, Set<String>> votesToCountry = new HashMap<Integer, Set<String>>();

    for (int i=0; i < chefsToRead; ++i) {
      parameters = in.readLine().split(" ");
      final ChefNode node = new ChefNode();
      final CountryNode cn = countryData.containsKey(parameters[1]) ? countryData.get(parameters[1]) : new CountryNode();
      cn.country = parameters[1];
      node.countryNode = cn;
      countryData.put(cn.country, cn);
      chefToData.put(parameters[0], node);
    }

//    for (Map.Entry<String, DataNode> entry : chefToData.entrySet()) {
//      System.out.println(entry.getKey() + " : " + entry.getValue().country );
//    }

    int maxChefVotes = 0;
    int maxCountryVotes = 0;
    for (int i = 0; i < emails; ++i) {
      final String subject = in.readLine();
      final ChefNode node = chefToData.get(subject);
      int votes = node.votes;
      maxChefVotes = handleChefVote(votesToChefs, votes, node, subject, maxChefVotes, countryData);
      maxCountryVotes = handleCountryVote(chefToData.get(subject), votesToCountry, maxCountryVotes, countryData);
    }
    final String chef = votesToChefs.get(maxChefVotes).iterator().next();
    final String country = votesToCountry.get(maxCountryVotes).iterator().next();
    System.out.println(country);
    System.out.println(chef);
  }

  private static int handleChefVote(final Map<Integer,
          Set<String>> votesToChefs, 
          int votes, 
          final ChefNode node,
          final String subject, 
          int maxChefVotes,
          final Map<String, CountryNode> countryData) {
    
    if (votesToChefs.containsKey(votes + 1)) {
      node.votes++;
      votesToChefs.get(node.votes).add(subject);
    }
    else {
      if (votes + 1 > maxChefVotes) {
        maxChefVotes++;
      }
      Set<String> chefs = new TreeSet<String>();
      chefs.add(subject);
      votesToChefs.put(++node.votes, chefs);
    }
    return maxChefVotes;
  }

  private static int handleCountryVote(ChefNode node, Map<Integer, Set<String>> votesToCountry, int maxCountryVotes,
          final Map<String, CountryNode> countryData) {

    int votes = node.countryNode.votes;
    if (votesToCountry.containsKey(votes + 1)) {
      node.countryNode.votes++;
      votesToCountry.get(node.countryNode.votes).add(node.countryNode.country);
    }
    else {
      if (votes + 1 > maxCountryVotes) {
        maxCountryVotes++;
      }
      Set<String> countries = new TreeSet<String>();
      countries.add(node.countryNode.country);
      votesToCountry.put(++node.countryNode.votes, countries);
    }

    return maxCountryVotes;
  }

  private static class ChefNode {

    CountryNode countryNode = new CountryNode();
    int votes = 0;
  }

  private static class CountryNode {

    String country;
    int votes = 0;
  }
}