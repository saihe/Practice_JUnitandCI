package ksaito.practice.practicejunitci.file;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import ksaito.practice.practicejunitci.file.dto.InputCsv;

public class FileOperation {

  /**
   * 1.read
   * @param target .
   * @return .
   * @throws IOException .
   */
  public List<String> readFile(Path target) throws IOException {
    return Files.readAllLines(target, StandardCharsets.UTF_8);
  }

  /**
   * 2. read and mapping
   * @param target .
   * @return .
   * @throws IOException .
   */
  public List<InputCsv> readAndMapping(Path target) throws IOException {
    return Files.readAllLines(target).stream()
      .map(l -> l.split(","))
      .map(r -> new InputCsv(r[0], r[1], r[2], r[3]))
      .toList();
  }

  /**
   * 3. write
   * @param target .
   * @param lines .
   * @throws IOException .
   */
  public void write(Path target, List<String> lines) throws IOException {
    Files.write(target, lines, StandardCharsets.UTF_8, StandardOpenOption.CREATE);
  }

  /**
   * 4. mapping and write
   * @param target .
   * @param lines .
   * @throws IOException .
   */
  public void mappingAndWrite(Path target, List<InputCsv> lines) throws IOException {
    Files.write(
      target,
      lines.stream()
        .map(InputCsv::toString)
        .collect(Collectors.toList()),
      StandardCharsets.UTF_8,
      StandardOpenOption.CREATE
    );
  }

  /**
   * 5. sort by key
   * @param target .
   * @param key .
   * @return .
   * @throws IOException .
   */
  public List<InputCsv> sortByKey(Path target, String key) throws IOException {
    Comparator com = switch (key) {
      case "id" -> Comparator.comparing(InputCsv::id);
      case "name" -> Comparator.comparing(InputCsv::name);
      case "department_id" -> Comparator.comparing(InputCsv::departmentId);
      case "email" -> Comparator.comparing(InputCsv::email);
      default -> null;
    };

    return Files.readAllLines(target).stream()
      .map(l -> l.split(","))
      .map(r -> new InputCsv(r[0], r[1], r[2], r[3]))
      .sorted(com)
      .toList();
  }

  /**
   * 6. extract by condition
   * @param target .
   * @param conditionKey .
   * @param conditionValue .
   * @return .
   */
  public List<InputCsv> extractByCondition(Path target, String conditionKey, String conditionValue) throws IOException {
    return Files.readAllLines(target).stream()
      .map(l -> l.split(","))
      .map(r -> new InputCsv(r[0], r[1], r[2], r[3]))
      .filter(i -> switch (conditionKey) {
        case "id" -> i.id().equals(conditionValue);
        case "name" -> i.name().equals(conditionValue);
        case "department_id" -> i.departmentId().equals(conditionValue);
        case "email" -> i.email().equals(conditionValue);
        default -> false;
      })
      .toList();
  }
}
