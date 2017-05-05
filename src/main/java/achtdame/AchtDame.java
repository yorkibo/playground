package achtdame;

import java.util.ArrayList;
import java.util.List;

public class AchtDame
{

    public static void main(String[] args)
    {
        for (List<Integer> loesung : damenProblem(8, 8))
        {
            System.out.println(loesung.toString());
        }

    }

    private static List<ArrayList<Integer>> damenProblem(int reihen, int spalten)
    {
        if (reihen <= 0)
        {
            ArrayList<ArrayList<Integer>> arrayList = new ArrayList<ArrayList<Integer>>();
            arrayList.add(new ArrayList<Integer>());
            return arrayList;
        }
        else
        {
            return eineDameDazu(reihen - 1, spalten, damenProblem(reihen - 1, spalten));
        }
    }

    private static List<ArrayList<Integer>> eineDameDazu(int neueReihe, int spalten, List<ArrayList<Integer>> vorherigeLoesungen)
    {
        List<ArrayList<Integer>> neueLoesungen = new ArrayList<ArrayList<Integer>>();

        for (ArrayList<Integer> loesung : vorherigeLoesungen)
        {
            for (int neueSpalte = 0; neueSpalte < spalten; neueSpalte++)
            {
                if (keinKonflikt(neueReihe, neueSpalte, loesung))
                {
                    @SuppressWarnings("unchecked")
                    ArrayList<Integer> tempLoesung = (ArrayList<Integer>) loesung.clone();
                    tempLoesung.add(Integer.valueOf(neueSpalte));
                    neueLoesungen.add(tempLoesung);
                }
            }
        }
        return neueLoesungen;
    }

    private static boolean keinKonflikt(int neueReihe, int neueSpalte, List<Integer> loesung)
    {
        for (int reihe = 0; reihe < neueReihe; reihe++)
        {
            if ((loesung.get(reihe).intValue() == neueSpalte)
                || (loesung.get(reihe).intValue() + reihe == neueSpalte + neueReihe)
                || (loesung.get(reihe).intValue() - reihe == neueSpalte - neueReihe))
                return false;

        }
        return true;
    }
}