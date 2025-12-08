import java.lang.Math;

public class Parte1_Decoder {
  public static void print(String[] ingredientList) {
    for (int i = 0; i < ingredientList.length; i++) {
      System.out.println(ingredientList[i]);
    }
  }

  public static void print(long[] ingredientList) {
    for (int i = 0; i < ingredientList.length; i++) {
      System.out.println(ingredientList[i]);
    }
  }

  public static long getValue(String arg) {
    long value = Long.valueOf(arg);
    return value;
  }

  public static long[] orderRange(String ranges) {
    long[] range = new long[ranges.length()];
    String[] values = ranges.split("-");
    if (getValue(values[0]) < getValue(values[1])) {
      range[0] = getValue(values[0]);
      range[1] = getValue(values[1]);
    } else {
      range[1] = getValue(values[0]);
      range[0] = getValue(values[1]);
    }
    return range;
  }

  public static boolean repeatedIngredient(long[] freshIds, long newValue) {
    boolean isRepeated = true;
    for (int i = 0; i < freshIds.length; i++) {
      if (newValue == freshIds[i])
        return false;
    }
    return isRepeated;
  }

  public static void getFresh(String[] range, String[] ingredientID) {
    int code = 0;
    int[] freshIds = new int[ingredientID.length];
    long[] freshIngredients = new long[0];
    for (int i = 0; i < freshIds.length; i++) {
      freshIds[i] = 0;
    }
    for (int i = 0; i < ingredientID.length; i++) {
      long ingredientValue = getValue(ingredientID[i]);
      for (int j = 0; j < range.length; j++) {
        long[] ingredientRange = orderRange(range[j]);
        if (ingredientValue >= ingredientRange[0] && ingredientValue <= ingredientRange[1]) {
          if (repeatedIngredient(freshIngredients, ingredientValue)) {
            freshIds[i] = 1;
            freshIngredients = makeArray(freshIngredients, ingredientValue);
          }
        }
      }
    }
    for (int i = 0; i < freshIds.length; i++) {
      code = code + freshIds[i];
    }
    System.out.println(code);
  }

  public static long[] makeArray(long[] oldArray, long newValue) {
    int oldLength = (oldArray == null) ? 0 : oldArray.length;
    long[] newArray = new long[oldLength + 1];
    for (int i = 0; i < oldLength; i++) {
      newArray[i] = oldArray[i];
    }
    newArray[oldLength] = newValue;
    return newArray;
  }

  public static String[] makeArray(String[] oldArray, String newValue) {
    int oldLength = (oldArray == null) ? 0 : oldArray.length;
    String[] newArray = new String[oldLength + 1];
    for (int i = 0; i < oldLength; i++) {
      newArray[i] = oldArray[i];
    }
    newArray[oldLength] = newValue;
    return newArray;
  }

  public static void main(String[] args) {
    String[] ingredientID = new String[0];
    String[] availableRange = new String[0];
    for (int count = 0; count < args.length; count++) {
      if (!args[count].contains("-")) {
        ingredientID = makeArray(ingredientID, args[count]);
      } else {
        availableRange = makeArray(availableRange, args[count]);
      }
    }
    // for (int i = 0; i < ingredientID.length; i++) {
    // System.out.println(getValue(ingredientID[i]));
    // }
    getFresh(availableRange, ingredientID);
  }
}
