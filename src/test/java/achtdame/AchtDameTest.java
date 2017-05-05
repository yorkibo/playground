package achtdame;

import static org.junit.Assert.*;

import org.junit.Test;

public class AchtDameTest
{
    @Test
    public void testeGueltigeLoesung8()
    {
        String gueltigeLoesung = "[0, 6, 4, 7, 1, 3, 5, 2]";
        assertTrue("Lösung ist gültig, die Berechnung ergibt aber eine üngültige Lösung!",
            AchtDame.isLoesung(gueltigeLoesung));
    }

    @Test
    public void testeGueltigeLoesung4()
    {
        String gueltigeLoesung = "[2, 0, 3, 1]";
        assertTrue("Lösung ist gültig, die Berechnung ergibt aber eine üngültige Lösung!",
            AchtDame.isLoesung(gueltigeLoesung));
    }

    @Test
    public void testeUngueltigeLoesung8()
    {
        String gueltigeLoesung = "[0, 6, 4, 6, 1, 3, 5, 2]";
        assertFalse("Lösung ist ungültig, die Berechnung ergibt aber eine gültige Lösung!",
            AchtDame.isLoesung(gueltigeLoesung));
    }
}