public class Parte1_Decoder {
  public static String[][] groupNumbers(String[] numbers, int group, int fileLength) {
    int idQuant = numbers.length / group;
    String[][] groupedNumbers = new String[idQuant][group];
    for (int i = 0; i < idQuant; i++) {
      for (int j = 0; j < group; j++) {
        groupedNumbers[i][j] = numbers[(fileLength * j) + i];
      }
    }
    return groupedNumbers;
  }

  public static void doOperation(String[][] groupedNumbers, String[] operations) {
    long code = 0;
    for (int i = 0; i < operations.length; i++) {
      long operation = 0;
      for (int j = 0; j < groupedNumbers[i].length; j++) {
        if (operations[i].equals("+")) {
          operation = operation + Long.valueOf(groupedNumbers[i][j]);
        } else {
          operation = (operation == 0) ? Long.valueOf(groupedNumbers[i][j])
              : operation * Long.valueOf(groupedNumbers[i][j]);
        }
      }
      code = code + operation;
    }
    System.out.println(code);
  }

  public static String[] makeArray(String[] oldArr, String newElement) {
    int oldLength = (oldArr == null) ? 0 : oldArr.length;
    String[] nextArray = new String[oldLength + 1];
    for (int i = 0; i < oldArr.length; i++) {
      nextArray[i] = oldArr[i];
    }
    nextArray[oldLength] = newElement;
    return nextArray;
  }

  public static void print(String[] args) {
    for (int i = 0; i < args.length; i++) {
      System.out.println(args[i]);
    }
  }

  public static void main(String[] args) {
    String[] operations = new String[0];
    String[] numbers = new String[0];
    for (int i = 0; i < args.length; i++) {
      if (args[i].equals("+") || args[i].equals("M")) {
        operations = makeArray(operations, args[i]);
      } else {
        numbers = makeArray(numbers, args[i]);
      }
    }
    int grupos = numbers.length / operations.length;
    int fileLength = args.length / (grupos + 1);
    String[][] groupedNumbers = groupNumbers(numbers, grupos, fileLength);
    doOperation(groupedNumbers, operations);
  }
}
