public class Parte1_Decoder {
  public static int checkBattery(char[] bank) {
    int batteryValue = ((bank[0] - '0') * 10) + (bank[1] - '0');
    for (int first = 0; first < bank.length - 1; first++) {
      for (int second = bank.length - 1; second > first; second--) {
        int checkValue = ((bank[first] - '0') * 10) + (bank[second] - '0');
        if (checkValue > batteryValue) {
          batteryValue = checkValue;
        }
      }
    }
    return batteryValue;
  }

  public static void main(String[] args) {
    int code = 0;
    for (int i = 0; i < args.length; i++) {
      char[] arg = args[i].toCharArray();
      code = code + checkBattery(arg);
    }
    System.out.println(code);
  }
}
