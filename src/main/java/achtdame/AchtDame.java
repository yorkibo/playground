package achtdame;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

public class AchtDame
{

    public static void main(String[] args)
    {
        for (List<Integer> loesung : damenProblem(4, 4))
        {
            System.out.println(loesung.toString());
        }

    }

    public static boolean isLoesung(String moeglicheLoesung)
    {
        boolean isLoesung = false;
        
        //nur quadratische Bretter
        int reiheUndSpalte = StringUtils.countMatches(moeglicheLoesung, ",") + 1;

        List<String> loesungAlsString = new ArrayList<>();

        for (List<Integer> loesung : damenProblem(reiheUndSpalte, reiheUndSpalte))
        {
            loesungAlsString.add(loesung.toString());
        }

        if (loesungAlsString.contains(moeglicheLoesung))
        {
            isLoesung = true;
        }

        return isLoesung;
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

    private static List<ArrayList<Integer>> eineDameDazu(int neueReihe, int spalten,
        List<ArrayList<Integer>> vorherigeLoesungen)
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