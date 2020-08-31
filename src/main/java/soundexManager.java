public class soundexManager {

    public static double similarity(String palabra1, String palabra2){
        String p1 = Soundex.encode(palabra1);
        String p2 = Soundex.encode(palabra2);
        int equality = 0;
        for(int i=0; i< p1.length(); i++){
            if(p1.charAt(i) == p2.charAt(i)){
                equality++;
            }
        }

        return (double)equality/p1.length();
    }

    public static String encode(String palabra){
        return Soundex.encode(palabra);
    }
}
