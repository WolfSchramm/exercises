/* (c) 2016 Thomas Smits */
package tpe.testexception.test;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import tpe.testexception.CrypterCaesar;
import tpe.testexception.IllegalKeyException;
import tpe.testexception.IllegalMessageException;

/**
 * Testklasse für die Verschlüsselung.
 *
 * @author Thomas Smits
 */
public class CaesarTest {

    /**
     * Testet die Verschlüsselung an sich.
     *
     * @throws IllegalMessageException Wird geworfen, wenn die
     *          Nachricht ungültig ist.
     * @throws IllegalKeyException Wird geworfen, wenn der Schlüssel
     *          ungültig ist.
     */
    @Test
    public void testCaesar()
            throws IllegalKeyException, IllegalMessageException {
        String klarText = "KATHARGOMUSSFALLEN";
        CrypterCaesar c = new CrypterCaesar();
        assertEquals(klarText, c.decrypt("C",
                c.encrypt("C", klarText)));
        assertEquals("FDHVDU", c.encrypt("C", "CAESAR"));
        assertEquals(klarText, c.encrypt("Z", klarText));
    }
}
