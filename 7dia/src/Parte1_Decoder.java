public class Parte1_Decoder {
  public static void print(char[][] map) {
    for (int i = 0; i < map.length; i++) {
      for (int j = 0; j < map[i].length; j++) {
        System.out.print(map[i][j]);
      }
      System.out.println();
    }
  }

  public static void placeBeams(char[] row, int coord) {
    row[coord] = '|';
  }

  public static int runBeams(char[] currentRow, char[] previousRow) {
    int split = 0;
    for (int i = 0; i < currentRow.length; i++) {
      if (previousRow[i] == 'S' || previousRow[i] == '|') {
        if (currentRow[i] == '.') {
          placeBeams(currentRow, i);
        } else if (currentRow[i] == '^') {
          split++;
          if ((i - 1) >= 0 && currentRow[i - 1] == '.') {
            placeBeams(currentRow, i - 1);
          }
          if ((i + 1) < currentRow.length && currentRow[i + 1] == '.') {
            placeBeams(currentRow, (i + 1));
          }
        }
      }
    }
    return split;
  }

  public static void main(String[] args) {
    int code = 0;
    char[][] map = new char[args.length][args[0].length()];
    for (int i = 0; i < args.length; i++) {
      map[i] = args[i].toCharArray();
    }
    for (int i = 1; i < map.length; i++) {
      code = code + runBeams(map[i], map[i - 1]);
    }
    print(map);
    System.out.println(code);
  }
}
