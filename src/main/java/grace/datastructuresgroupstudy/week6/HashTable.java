package grace.datastructuresgroupstudy.week6;

import java.util.LinkedList;

public class HashTable {

  private LinkedList<Node>[] table;

  public HashTable(int size) {
    table = new LinkedList[size];
  }

  public Long getHashCode(String key) {
    Long hashCode = 0L;
    for (char c : key.toCharArray()) {
      hashCode += (long) c;
    }
    return hashCode;
  }

  public int getIndex(Long hashCode) {
    return (int) (hashCode % table.length);
  }

  public Node searchNode(int index, String key) {
    LinkedList<Node> indexedList = table[index];

    for (Node n : indexedList) {
      if (n.key == key) {
        return n;
      }
    }
    return null;
  }

  public void put(String key, String value) {
    Long hashCode = getHashCode(key);
    int index = getIndex(hashCode);

    if (table[index] == null) {
      table[index] = new LinkedList<Node>();
      table[index].add(new Node(key, value));
    } else {
      Node searched = searchNode(index, key);

      if (searched != null) {
        searched.value = value;
      } else {
        table[index].add(new Node(key, value));
      }
    }
  }

  public String get(String key) {
    Long hashCode = getHashCode(key);
    int index = getIndex(hashCode);

    Node searched = searchNode(index, key);

    if (searched == null) {
      return "";
    } else {
      return searched.value;
    }
  }

}
