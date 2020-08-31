import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class SoundexTester {

    static String palabra;

    @BeforeAll
    static void initAll() {
        //Si tuviese un parametro que se comparte en todos los tests o la funcion a testear no es estatica y se debe
        //inicializar, podemos aprovechar esta forma de ejecutar codigo al principio del testeo.
        palabra = "estructura";
    }


    @Test
    void sizeFourTest() {
        // Longitud 4?
        Assertions.assertEquals(4, Soundex.encode(palabra).length());
    }

    @Test
    void noStrangeChars() {
        //Caracteres normales
        Assertions.assertTrue(Soundex.encode(palabra).matches("[A-Z0-9]*"));
    }

    @Test
    void firstChar() {
        //Comienza por letra
        Assertions.assertTrue(Soundex.encode(palabra).substring(0,1).matches("[A-Z]{1}"));
    }

    @Test
    void LastThreeDigits() {
        //Termina en 3 digitos
        Assertions.assertTrue(Soundex.encode(palabra).substring(1).matches("[0-9]{3}"));
    }

    @Test
    void similarityOk() {
        // Funcionamiento correcto de la normalizacion del similarity
        Assertions.assertEquals(soundexManager.similarity("face", "feis"), 1);
        Assertions.assertEquals(soundexManager.similarity("threshold", "hold"), 0);
        Assertions.assertEquals(soundexManager.similarity("phone", "foun"), 0.75);

    }

    @Test
    void encodingOK() {
        //Algunos ejemplos particulares
        Assertions.assertEquals("T624", soundexManager.encode("threshold"));
        Assertions.assertEquals("T600", soundexManager.encode("thre"));
        Assertions.assertEquals("T000", soundexManager.encode("t"));
        Assertions.assertEquals("H000", soundexManager.encode("hhhhhh"));
        Assertions.assertEquals("A426", soundexManager.encode("algorithm"));
    }

    @Test
    void encodingPlus() {
        //Algunos ejemplos particulares
        Assertions.assertEquals("T624", soundexManager.encode("threshold"));
        Assertions.assertEquals("H430", soundexManager.encode("hold"));
        Assertions.assertEquals("P500", soundexManager.encode("phone"));
        Assertions.assertEquals("F500", soundexManager.encode("foun"));
    }

}
