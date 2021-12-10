package ksaito.practice.practicejunitci;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BatchOperationTest {

  private final BatchOperation operation = new BatchOperation();

  @Test
  void run() {
    Assertions.assertEquals(0, operation.run(new String[]{"test"}));
  }
}