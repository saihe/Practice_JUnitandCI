package ksaito.practice.practicejunitci;

import java.io.IOException;
import java.nio.file.Paths;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FileOperationTest {

  private final FileOperation operation = new FileOperation();

  @Test
  void readFile() {
    try {
      Assertions.assertNotNull(operation.readFile(Paths.get("./", "README.md")));
    } catch (IOException e) {
      Assertions.fail("ファイル読み込みに失敗");
    }
  }
}