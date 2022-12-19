package grace.datastructuresgroupstudy.week8;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinarySearchTreeTest {

  @Test
  void insert() {

    BinarySearchTree binarySearchTree = new BinarySearchTree();
    binarySearchTree.insert(20);
    binarySearchTree.insert(15);
    binarySearchTree.insert(13);
    binarySearchTree.insert(16);


  }

}