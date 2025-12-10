public class Parte2_Decoder {
  public static int getRows(char[] args) {
    for (int i = 2; i < args.length; i++) {
      if (args.length % i == 0) {
        return i;
      }
    }
    return -1;
  }

  public static int[][] parseCharsToInt(char[] args) {
    int[][] map = new int[0][0];
    return null;
  }

  public static void print(char[] args) {
    for (int i = 0; i < args.length; i++) {
      if (args[i] == 'N') {
        System.out.println();
      } else {
        System.out.print(args[i]);
      }
    }
  }

  public static void main(String[] args) {
    char[] input = args[0].toCharArray();
    System.out.println(getRows(input));
  }
}
