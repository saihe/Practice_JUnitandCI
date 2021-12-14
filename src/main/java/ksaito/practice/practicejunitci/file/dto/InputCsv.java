package ksaito.practice.practicejunitci.file.dto;

public record InputCsv(String id, String name, String departmentId, String email) {
  @Override
  public String toString() {
    return id + "," + name + "," + departmentId + "," + email;
  }
}
