package Arithmetic.string;

public class LCR {
    public static void main(String[] args) {
        System.out.println(pathEncryption2("a.aef.qerf.bb"));
    }

    public static String pathEncryption(String path){
        return path.replaceAll("\\.", " ");
    }

    public static String pathEncryption2(String path){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '.')
                sb.append(' ');
            else sb.append(path.charAt(i));
        }
        return sb.toString();
    }
}
