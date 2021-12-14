package ksaito.practice.practicejunitci.file;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import ksaito.practice.practicejunitci.file.dto.InputCsv;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FileOperationTest {

  private Path inputCsvPath = Paths.get("lib", "input.csv");
  private Path outputCsvPath = Paths.get("lib", "output.csv");
  private FileOperation operation = new FileOperation();

  @Test
  void readFile() {
    try {
      var result = operation.readFile(inputCsvPath);
      Assertions.assertNotNull(result);
      Assertions.assertNotEquals(0, result.size());
      System.out.println("1. read");
      result.forEach(System.out::println);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void readAndMapping() {
    try {
      var result = operation.readAndMapping(inputCsvPath);
      Assertions.assertNotNull(result);
      Assertions.assertNotEquals(0, result.size());
      System.out.println("2. read and mapping");
      result.forEach(System.out::println);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void write() {
    try {
      operation.write(outputCsvPath, Collections.singletonList("テストだよ。"));
      Assertions.assertTrue(true);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void mappingAndWrite() {
    try {
      operation.mappingAndWrite(
        outputCsvPath,
        Collections.singletonList(new InputCsv("1", "ksaito", "1", "test@test.com"))
      );
      Assertions.assertTrue(true);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void sortByKey() {
    try {
      var result = operation.sortByKey(inputCsvPath, "id");
      Assertions.assertNotNull(result);
      Assertions.assertNotEquals(0, result.size());
      System.out.println("5. sort by key");
      result.forEach(System.out::println);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }

  @Test
  void extractByCondition() {
    try {
      var result = operation.extractByCondition(inputCsvPath, "id", "1");
      Assertions.assertNotNull(result);
      Assertions.assertNotEquals(0, result.size());
      System.out.println("6. extract by condition");
      result.forEach(System.out::println);
    } catch (IOException e) {
      Assertions.fail(e);
    }
  }
}