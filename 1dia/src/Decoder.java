import java.lang.Math;
// import java.nio.file.Files;
// import java.nio.file.Paths;
// import java.util.List;

public class Decoder {
  public static int getSymbol(char letter) {
    if (letter == 'L')
      return -1;
    if (letter == 'R')
      return 1;
    else {
      System.out.println("Se ha roto algo");
      System.exit(0);
      return 0;
    }
  }

  public static int procesarInt(String arg) {
    char letter = arg.charAt(0);
    int direction = getSymbol(letter), num;
    String numPart = "";
    for (int contador = 1; contador < arg.length(); contador++) {
      numPart = numPart + arg.charAt(contador);
    }
    num = Integer.parseInt(numPart);
    num = num * direction;
    return num;
  }

  public static int extractBig(int action) {
    return action / 100;
  }

  public static int checkJump(int initialPos, int action, int finalPos) {
    if (initialPos + Math.abs(action) >= 100 && initialPos != Math.abs(action) && initialPos != finalPos) {
      return 1;
    }
    return 0;
  }

  public static int module(int num) {
    int resto;
    resto = ((num % 100) + 100) % 100;
    return resto;
  }

  public static void main(String[] args) {
    int code = 0, decoder = 50, accion, buffer;
    for (int iterator = 0; iterator < args.length; iterator++) {
      buffer = decoder;
      accion = procesarInt(args[iterator].toUpperCase().trim());
      code = code + Math.abs(extractBig(accion));
      decoder = decoder + (accion - (extractBig(accion) * 100));
      decoder = module(decoder);
      code = code + checkJump(buffer, accion, decoder);
      if (decoder == 0)
        code++;
    }
    System.out.println("El código es: " + code);
  }
}
