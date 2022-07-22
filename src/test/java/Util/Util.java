package Util;

public class Util {

    public static String obtenerCorreo() {
        return "pedro."+ randomAlphaNumeric(4)+"@escamoso.com";
    }

    public static String randomAlphaNumeric(int count) {
        String caracteres = "abcdefghijklmnopqrstuvwxyz0123456789";
        StringBuilder builder = new StringBuilder();
        while (count-- != 0) {
            int character = (int) (Math.random() * caracteres.length());
            builder.append(caracteres.charAt(character));
        }
        return builder.toString();
    }
}
