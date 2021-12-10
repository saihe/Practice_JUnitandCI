package ksaito.practice.practicejunitci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BooleanOperationTest {

  private final BooleanOperation operation = new BooleanOperation();

  @Test
  void isTrue() {
    Assertions.assertTrue(operation.isTrue(1));
  }
}