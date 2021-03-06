package no.oslomet.cs.algdat;

import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * Created by data structure of algorithm gruppe
 * gruppemedlemmer:
 * Amina Shahzad
 * Alexandros Messaritakis Chousein Aga
 * Gaute Tessand Baalsrud
 * Harith Elamin
 */
public class Oblig1 {

    // basic method
    // to swap the integer values location inside the array
    private static void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // basic method
    // to swap the char values location inside the array
    private static void swap(char[] a, int i, int j) {
        char temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    //assignment 1, part 2
    // to get the max value in the array in the last
    //tested
    public static int maks(int a[]) {
        if (a.length < 1) throw new NoSuchElementException("the table is empty");
        for (int i = 1; i < a.length; i++)
            if (a[i - 1] > a[i]) {
                swap(a, i - 1, i);
            }

        return a[a.length - 1];
    }


    //assignment 1, part 2
    // to get the number of swapping inside the array to get the max value in the last.
    //tested?????????????????????????????????
    public static int ombyttinger(int[] a) {
        int coount = 0;
        if (a.length < 1) throw new NoSuchElementException("The table is empty");
        for (int i = 1; i < a.length; i++) {
            if (a[i - 1] > a[i]) {
                swap(a, i - 1, i);
            }
            coount++;
        }
        System.out.println("The number of swapping inside the array to get the max value in the last is " + coount);
        return coount;
    }

    //assignment 2
    //to returtn the number of different values;
    //tested
    public static int antallUlikeSortert(int[] a) {
        int count = 1;
        if (a.length < 2) {
            count = a.length;
        }
        {
            for (int i = 1; i < a.length; i++) {
                if (a[i - 1] > a[i]) {
                    throw new IllegalStateException("The Array is not arranged");
                } else {
                    if (a[i - 1] < a[i]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    //assignment 3
    //tested
    public static int antallUlikeUsortert(int[] a) {
        int count = 1;
        if (a.length < 2) count = a.length;
        for (int i = 1; i < a.length; i++) {
            int k = 0;
            for (; k < i; k++) {
                if (a[k] == a[i]) break;

            }

            if (k == i) count++;
        }
        return count;
    }

    //assignment 4
    //tested
    public static void delsortering(int[] a) {
        int l = 0;
        int r = a.length - 1;

        while (l < a.length && (a[l] & 1) != 0) l++;
        while (r >= 0 && (a[r] & 1) == 0) r--;

        while (true) {
            if (l < r) swap(a, l++, r--);
            else break;
            while ((a[l] & 1) != 0) l++;
            while ((a[r] & 1) == 0) l--;
        }

        Arrays.sort(a, 0, l);
        Arrays.sort(a, l, a.length);
    }

    //assignment 5
    //to rotate the array
    //tested
    public static void rotasjon(char[] a) {
        if (a.length > 1) {
            char temp = a[a.length - 1];
            for (int i = a.length - 1; i > 0; i--) {
                a[i] = a[i - 1];
            }
            a[0] = temp;
        }
    }

    //
    public static void reverse(char[] a, int left, int right) {
        if (a == null || a.length == 1)
            return;

        while (left < right) {
            char temp = a[left];
            a[left] = a[right];
            a[right] = temp;
            left++;
            right--;
        }
    }

    //assignment 6
    //to rotate array's values in the array regarding to k value, + or -, right or left.
    //tested
    public static void rotasjon(char[] a, int k) {
        int n = a.length;
        if (a.length >= 1) {
            k %= n;
            if (k < 0) k += n;

            // bruker hjelpemetoden snu - se øverst
            reverse(a, 0, n - 1);    // snur hele tabellen
            reverse(a, 0, k - 1);    // snur de k første
            reverse(a, k, n - 1);    // snur resten
        }
    }

    //assignment 7, part a
    //tested
    //to merge together the character strings s and t so that the result becomes a character string.
    // If s and t have different lengths, what is "left over" must be inserted in the back
    //For example,  String a = flett("ABC","DEFGH");
    //String b = flett("IJKLMN","OPQ");
    //String b = flett("","AB");   // the result would be //// Utskrift: ADBECFGH IOJPKQLMN AB
    public static String flett(String s, String t) {
        // Build a long string
        StringBuilder str = new StringBuilder();
        int k = 0;

        if (s.length() < t.length()) {
            k = s.length();
        } else {
            k = t.length();
        }

        // insert the value in the new string
        for (int i = 0; i < k; i++) {
            str.append(s.charAt(i)).append(t.charAt(i));
        }
        //intsert the overfollow valuses of s
        for (int i = k; i < s.length(); i++) {
            str.append(s.charAt(i));  // tar med resten
        }
        //intsert the overfollow valuses of t
        for (int i = k; i < t.length(); i++) {
            str.append(t.charAt(i));  // tar med resten
        }
        return str.toString();
    }

    //assignment 7, part b
    //tested
    //character strings
    //
    public static String flett(String... s) {
        StringBuilder str = new StringBuilder();
        if (s.length == 0) str.append("");
        int y = s.length;
        // to get the length
        for (int i = 1; i < s.length; i++) {
            int temp = s[i].length();
            if (temp > y) y = temp;
        }
        //
        for (int i = 0; i < y; i++) {
            for (String t : s) {
                if (i < t.length()) {
                    str.append(t.charAt(i));
                }
            }
        }
        System.out.println(str);
        return str.toString();

    }

    //assignment 8
    // to return a table of indexes to the values in table a where a should not be changed.
    //
    public static int[] indekssortering(int[] a) {
        int[] index = new int[a.length];
        for (int i=0; i<index.length; i++)
        {
            index [i] =i;
        }
        for (int i = 1; i < a.length; i++)
        {
            
        }
            return index;
    }

    //assignment 9
    //tested?????????????????????????????????????
    //Må forbedres! Du har minst 3 feil eller svakheter!
    public static int[] tredjeMin(int[] a) {
        int n = a.length; //lengden til tabellen
        //Hvis tabellen har mindre enn 3 verdier skal det "kastes Exception"
        if (n < 2) {
            throw new java.util.NoSuchElementException("a.length(" + n + ") < 2!");
        }
//
        //some change
        int[] indeks = new int[a.length];
//
        int m = indeks[0]; //Dette er indeksen/posisjonen til minste verdi
        int nm = indeks[1]; //Dette er indeksen/posisjonen til nest miinste verdi
        int mn = indeks[2]; //Dette er indeksen/posisjonen til tredj minste verdi

        int minverdi = a[m]; //Minste verdi
        int nestminverdi = a[nm]; //Nest minste verdi
        int tredjminsteverdi = a[mn]; //Tredj minste verdi

        //Lager en løkke for å loope gjennom alle tallene
        for (int i = 3; i < n; i++) {
            if (a[i] < tredjminsteverdi) { //Hvis a[i] er mindre enn trejminste så skal neste setning kjøres
                if (a[i] < nestminverdi) {  //Hvis a[i] er mindre enn nestminste verdi så skal neste setning kjøres
                    if (a[i] < minverdi) {  //Hvis a[i] er mindre en minst verdi så skal ny verdi settes
                        mn = nm;
                        tredjminsteverdi = nestminverdi;

                        nm = m;
                        nestminverdi = minverdi;

                        m = i;
                        minverdi = a[m];
                    } else {
                        mn = nm;
                        tredjminsteverdi = nestminverdi;

                        nm = i;
                        nestminverdi = a[nm];
                    }
                } else {
                    mn = i;
                    tredjminsteverdi = a[mn];
                }
            }
        }
        return new int[]{m, nm, mn};//returnerer tabell med inndekser

    }


    boolean inneholdt(String a, String b){
        return false;
    }
}
