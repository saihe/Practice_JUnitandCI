package ksaito.practice.practicejunitci;

public class BatchOperation {
  public int run(String[] args) {
    if (args.length == 0) {
      System.out.println("引数なし");
      return 1;
    } else {
      System.out.println(String.join(",", args));
      return 0;
    }
  }
}
