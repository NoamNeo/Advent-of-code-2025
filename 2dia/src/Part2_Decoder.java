public class Part2_Decoder {
  public static long modulusOpe(long num, long module) {
    long dividend = num;
    long divisor = module;
    long remainder;
    remainder = dividend - (divisor * (dividend / divisor));
    return remainder;
  }

  public static boolean isEqualSplit(String[] args) {
    return args[0].equals(args[1]);
  }

  public static boolean isGood(long longArg) {
    String arg = String.valueOf(longArg);
    return modulusOpe(arg.length(), 2) == 0;
  }

  public static long[] castArg(String arg) {
    String[] splitArg = splitArg(arg);
    long[] output = new long[splitArg.length];
    for (int i = 0; i < splitArg.length; i++) {
      output[i] = Long.valueOf(splitArg[i]);
    }
    return output;
  }

  public static String[] splitArg(long longArg, int pos) {
    String buffer = String.valueOf(longArg);
    String[] parts = { buffer.substring(0, pos), buffer.substring(pos) };
    return parts;
  }

  public static String[] splitArg(long longArg) {
    String buffer = String.valueOf(longArg);
    int midPoint = buffer.length() / 2;
    String[] parts = { buffer.substring(0, midPoint), buffer.substring(midPoint) };
    return parts;
  }

  public static String[] splitArg(String arg) {
    String[] output = arg.split("-");
    return output;
  }

  public static void main(String[] args) {
    long code = 0;
    for (int i = 0; i < args.length; i++) {
      long[] range = castArg(args[i]);
      for (long j = range[0]; j <= range[1]; j++) {
        if (isGood(j)) {
          String[] buffer = splitArg(j);
          if (isEqualSplit(buffer)) {
            code = code + j;
          }
        }
      }
    }
    System.out.println(code);
  }
}
