public class Parte1_Decoder {
  public static void print(int[][] rackValue) {
    for (int i = 0; i < rackValue.length; i++) {
      for (int j = 0; j < rackValue.length; j++) {
        System.out.print(rackValue[i][j]);
      }
      System.out.println();
    }
  }

  public static int getSlotValue(char[][] rack, int row, int slot) {
    int value = -1;
    if (rack[row][slot] == '.') {
      return value;
    } else {
      for (int i = row - 1; i < row + 2; i++) {
        for (int j = slot - 1; j < slot + 2; j++) {
          if ((i >= 0 && j >= 0) && (i < rack.length && j < rack[0].length)) {
            if (rack[i][j] == '@')
              value++;

          }
        }
      }
    }
    return value;
  }

  public static void main(String[] args) {
    char[][] scrollRack = new char[args.length][args[0].length()];
    int[][] scrollValues;
    int code = 0;
    for (int row = 0; row < scrollRack.length; row++) {
      for (int slot = 0; slot < scrollRack[row].length; slot++) {
        scrollRack[row][slot] = args[row].charAt(slot);
      }
    }
    scrollValues = new int[scrollRack.length][scrollRack[0].length];
    for (int row = 0; row < scrollRack.length; row++) {
      for (int slot = 0; slot < scrollRack[row].length; slot++) {
        scrollValues[row][slot] = getSlotValue(scrollRack, row, slot);
      }
    }
    // print(scrollValues);
    for (int row = 0; row < scrollRack.length; row++) {
      for (int slot = 0; slot < scrollRack[row].length; slot++) {
        if (scrollValues[row][slot] < 4 && scrollValues[row][slot] > -1) {
          code = code + 1;
        }
      }
    }
    System.out.println(code);
  }
}
