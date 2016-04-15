/**
 * Objekte dieser Klasse repräsentieren eine Währung. Eine Währung zeichnet
 * sich durch einen Namen (z.B. EURO), ein Kürzel (z.B. € oder EUR) und einen
 * Umrechnungskurs zum US-Dollar aus.
 *
 * Objekte dieser Klasse sind imutable, d.h. sie können nach der Erzeugung
 * nicht mehr verändert werden.
 *
 * @author Thomas Smits
 */
public class Waehrung {

    /** Umrechnungskurs zum Dollar. */
    private final int kurs;

    /** Langer Name der Währung. */
    private final String name;

    /** Abkürzung zur Währung. */
    private final String kuerzel;

    /** Teiler für die Nachkommastellen. */
    private static final long TEILER = 10000;

    /**
     * Erzeugt ein neues Objekt.
     *
     * @param name Name der Währung (z.B. EURO).
     * @param kuerzel Kürzel der Währung (z.B. €).
     * @param kurs Wechselkurs zum Dollar.
     */
    public Waehrung(String name, String kuerzel, double kurs) {
        this.kurs = (int) (kurs * TEILER);
        this.name = name;
        this.kuerzel = kuerzel;
    }

    /**
     * Rechnet einen Berag in der aktuellen Währung in eine andere Währung
     * um.
     *
     * @param betrag Betrag der umgerechnet werden soll.
     * @param toWaehrung die Zielwährung.
     * @return Ergebnis der Umrechnung.
     */
    public long umrechnen(long betrag, Waehrung toWaehrung) {
        return betrag * kurs / toWaehrung.kurs;
    }

    /**
     * Gibt den Kurs der aktuellen Währung zurück.
     *
     * @return Wechselkurs bezogen auf den US-Dollar.
     */
    public int getKurs() {
        return kurs;
    }

    /**
     * Gibt den Namen der Währung zurück.
     *
     * @return Name der Währung (z.B. Euro oder Dollar).
     */
    public String getName() {
        return name;
    }

    /**
     * Gibt das Kürzel für die Währung zurück.
     *
     * @return Das Kürzel der Währung (z.B. EUR oder $)
     */
    public String getKuerzel() {
        return kuerzel;
    }

    /**
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return String.format("%s [%s] 1 %s = %.4f %s",
                name, kuerzel, "$",
                kurs / (double) TEILER, kuerzel);
    }

    /**
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
                + ((name == null) ? 0 : name.hashCode());
        result = prime * result + kurs;
        result = prime * result
                + ((kuerzel == null) ? 0 : kuerzel.hashCode());
        return result;
    }

    /**
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Waehrung other = (Waehrung) obj;
        if (name == null) {
            if (other.name != null) {
                return false;
            }
        }
        else if (!name.equals(other.name)) {
            return false;
        }
        if (kurs != other.kurs) {
            return false;
        }
        if (kuerzel == null) {
            if (other.kuerzel != null) {
                return false;
            }
        }
        else if (!kuerzel.equals(other.kuerzel)) {
            return false;
        }
        return true;
    }
}
