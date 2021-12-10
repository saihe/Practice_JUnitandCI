package ksaito.practice.practicejunitci;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileOperation {
  public List<String> readFile(Path target) throws IOException {
    return Files.readAllLines(target, StandardCharsets.UTF_8);
  }
}
