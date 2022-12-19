package grace.datastructuresgroupstudy.week9;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class AVLTreeTest {

  @Test
  void insert() {
    AVLTree avlTree = new AVLTree();
    avlTree.insert(1);
    avlTree.insert(2);
    avlTree.insert(3);
    avlTree.insert(4);
    avlTree.insert(5);

    avlTree.traverse();

    // 전위 : 2-1-4-3-5
    // 중위 : 1-2-3-4-5
    // 후위 : 1-3-5-4-2

  }
}