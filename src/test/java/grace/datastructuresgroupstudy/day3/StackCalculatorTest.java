package grace.datastructuresgroupstudy.day3;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class StackCalculatorTest {

  @Autowired StackCalculator stackCalculator;

  @Test
  void calculate() {

    assertEquals(10, stackCalculator.calculate("6 + ( 3 - 2 ) * 4"));
    assertEquals(8, stackCalculator.calculate("( 8 - 4 ) + ( 3 - 2 ) * 4"));
    assertEquals(16, stackCalculator.calculate("2 * ( 3 + 5 )"));
    assertEquals(11, stackCalculator.calculate("2 * 3 + 5"));
    assertEquals(17, stackCalculator.calculate("2 + 3 * 5"));
    assertEquals(2, stackCalculator.calculate("( ( 2 + 4 ) - 5 ) * 2"));
    assertEquals(20, stackCalculator.calculate("( 2 + ( 3 + 5 ) ) * 2"));
    assertEquals(12, stackCalculator.calculate("( ( 17 - 5 ) - ( 5 + 3 ) ) * 3"));
    assertEquals(0, stackCalculator.calculate("( ( 8 + 2 ) * 2 ) / 4 - 5"));


  }
}