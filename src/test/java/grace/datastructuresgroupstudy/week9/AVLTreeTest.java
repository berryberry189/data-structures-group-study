package grace.datastructuresgroupstudy.week9;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AVLTreeTest {

  @Test
  void insert_and_delete() {
    AVLTree avlTree = new AVLTree();
    avlTree.insert(1);
    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(4);
    avlTree.insert(5);
    avlTree.insert(6);

    avlTree.traverse();

    // 5
    // 전위 : 2-1-4-3-5
    // 중위 : 1-2-3-4-5
    // 후위 : 1-3-5-4-2

    // 6
    // 전위 : 4-2-1-3-5-6
    // 중위 : 1-2-3-4-5-6
    // 후위 : 1-3-2-6-5-4

    System.out.println("\n");
    avlTree.delete(3);

    avlTree.traverse();

    // 전위 : 2-1-4-5
    // 중위 : 1-2-4-5
    // 후위 : 1-5-4-2

  }
}