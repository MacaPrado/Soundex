import java.util.Arrays;

public class Soundex {
    private static final char[] soundex = new char[]{'0','1','2','3','0','1','2','0','0','2','2','4','5','5','0','1','2','6','2','3','0','1','0','2','0','2'};

    public static void main(String[] args) {

        String output = encode("clean");
        System.out.println(soundexManager.similarity("brooklin", "clean"));

        System.out.println(output);

    }

    private static char soundex(char each){         //Retorna el valor del array soundex
        if(each == ' '){
            return ' ';
        }
        return soundex[each - 'A'];
    }

    public static String encode(String palabra){
        char[] input = palabra.toUpperCase().toCharArray();
        char[] output = new char[]{'0', '0', '0', '0'};
        char last = soundex(input[0]);
        int j=0;        //posicion de output

        for(int i=0; i< input.length && j<4; i++){  //recorro el array
            char aux = soundex(input[i]);        //tomo el valor de soundex en un aux
            if(aux != ' '){                      // si no es un espacio
                if(j==0){
                    output[j] = input[i];
                    j++;
                }
                if(last != aux  && aux != '0') {    //que sea distinto al anterior
                    output[j] = aux;
                    j++;
                }
                last = aux;
            }

        }

        StringBuilder toReturn = new StringBuilder();
        for(int i=0; i <output.length; i++){
            toReturn.append(output[i]);
        }
        return toReturn.toString();
    }

}
