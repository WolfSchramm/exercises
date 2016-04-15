package tpe.map;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Zählen von Worthäfigkeiten.
 */
public class WordCount {

    /**
     * Klasse für die Verwaltung der Worthäufigkeiten.
     */
    // TODO: Sortierbar machen (Comparable)
    public static class WordFrequency {

        /** Das Wort. */
        String word;

        /** Seine Häufigkeit. */
        int frequency;

        /**
         * Legt ein neues Objekt an.
         *
         * @param word das gespeicherte Wort
         * @param frequency die Häfigkeit
         */
        WordFrequency(String word, int frequency) {
            this.word = word;
            this.frequency = frequency;
        }

        /**
         * @see java.lang.Object#toString()
         */
        @Override
        public String toString() {
            return String.format("%s: %d",  word, frequency);
        }
    }

    /**
     * Listet alle Worte in der Datei und deren Häufigkeit auf.
     * Die zurückgegebene Liste ist bereits nach der Häfuigkeit
     * sortiert.
     *
     * @param filename Dateiname
     * @return die Liste der vorhandenen Wort
     * @throws IOException Fehler beim Dateizugriff.
     */
    private static List<WordFrequency> countWords(String filename)
            throws IOException {

        // TODO: Map deklarieren

        // Datei zum Lesen öffnen
        BufferedReader reader = new BufferedReader(new FileReader(filename));

        String line; // aktuelle Zeile

        // Über die Zeilen der Datei iterieren
        while ((line = reader.readLine()) != null) {

            // Sonderzeichen entfernen und die Zeilen in Worte splitten
            line = line.toLowerCase();
            line = line.replaceAll("[\",.:;\\)'\\-\\!?]", "");

            String[] words = line.toLowerCase().split("[,. ]");

            for (String word : words) {
                // TODO: Worthäufigkeiten in Map speichern
            }
        }

        reader.close();

        // TODO: Worthäufigkeiten aus der Map extrahieren und sortieren

        // TODO: Ergebnis zurückgeben
        return null;
    }

    /**
     * Hauptmethode.
     *
     * @param args Kommandozeilen-Argumente.
     */
    public static void main(String[] args) {

        try {
            List<WordFrequency> words = countWords("assets/kafka.txt");

            for (WordFrequency word : words) {
                System.out.println(word);
            }
        }
        catch (IOException e) {
            System.err.println("Probleme beim Dateizugriff: " + e);
        }
    }
}
