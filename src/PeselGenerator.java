import java.io.*;

public class PeselGenerator {

    public void generujWszystkieMozliwePesele() throws IOException {

        File tmp1, tmp2, peselBase;

        tmp1 = new File("tmp1.txt");
        tmp1.createNewFile();
        StringBuilder sb = new StringBuilder();
        FileWriter fw = new FileWriter(tmp1);
        for (int y = 0; y < 100; y++) {       //generuje 2 pierwsze cyfry pesel
            switch (y) {
                case 0:
                case 1:
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                case 8:
                case 9:
                    fw.write("0" + y + "\n");
                    break;
                default:
                    ;
                    fw.write(y + "\n");
                    break;
            }
        }
        fw.close();
        System.out.println("Postęp 2/11");

        tmp2 = new File("tmp2.txt");   //tmp2 wskazuje na plik tmp2.txt
        tmp2.createNewFile();                   //  tworzy nowy plik jeśli nie instnieje
        fw = new FileWriter(tmp2);              //fw pozwala pisać we wskazanym pliku
        FileReader fr = new FileReader("tmp1.txt");    //wskazuje plik z którego będziemy czytać
        BufferedReader br = new BufferedReader(fr);             //posiada metode do ekonomicznego czytania z pliku linia po linii

        for (int y = 0; y < 100; y++) {
            String year = br.readLine();
            for (int m = 0; m < 93; m++) {
                switch (m) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        fw.write(year + "0" + m + "\n");
                        break;
                    default:
                        ;
                        fw.write(year + m + "\n");
                        break;
                }
            }
        }
        tmp1.delete();
        fw.close();
        System.out.println();
        System.out.println("Postęp 4/11");

        tmp1 = new File("tmp1.txt");
        tmp1.createNewFile();
        fw = new FileWriter(tmp1);              //fw pozwala pisać we wskazanym pliku
        fr = new FileReader("tmp2.txt");    //wskazuje plik z którego będziemy czytać
        br = new BufferedReader(fr);

        for (int ym = 0; ym < 9300; ym++) {
            String yearAndMonth = br.readLine();
            for (int d = 1; d < 32; d++) {
                switch (d) {
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                    case 7:
                    case 8:
                    case 9:
                        fw.write(yearAndMonth + "0" + d + "\n");
                        break;
                    default:
                        ;
                        fw.write(yearAndMonth + d + "\n");
                        break;
                }
            }
        }
        tmp2.delete();
        fw.close();
        System.out.println("Postep 6/11");
        /*
        //
        //        stworz plik1, plik2, plik3, plik4, plik5, plik6, plik7, peselBase
        //
        //                pętla generująca rok 00-99
        //                    BEGIN
        //                        funkcja warunkowa dopisująca 0 z przodu w przypadku cyfr (0-9)
        //                        BEGIN
        //                            wygeneruj liczbę z przedziału pętli. W razie (0-9) dopisz "0" z przodu
        //                            zapis do pliku1 w nowych liniach
        //                        END
        //                        zamknij strumien zapisu do plik1
        //                    END
        //                    wyświetl informację o postepie 2/11
        //                pętla generująca miesiąc 00-93
        //                    BEGIN
        //                        funkcja warunkowa dopisująca 0 z przodu w przypadku cyfr (0-9)
        //                        BEGIN
        //                            wygeneruj liczbę z przedziału pętli. W razie (0-9) dopisz "0" z przodu.
        //                            pobierz linię z pliku1 dopoki plik1 != null
        //                            i do każdej linii dopisz na końcu wygenerowaną liczbę
        //                            zapisz do pliku2
        //                        END
        //                        zamknij strumien zapisu do plik2
        //                    END
        //                    po wykonanej pętli usuń plik1
        //                    wyświetl informacje o postepie 4/11
        //                petla generujaca dzien 00-31
        //                    BEGIN
        //                        funkcja warunkowa dopisująca 0 z przodu w przypadku cyfr (0-9)
        //                        BEGIN
        //                            wygeneruj liczbę z przedziału pętli. W razie (0-9) dopisz "0" z przodu.
        //                            pobierz linię z pliku2 dopoki plik2 != null
        //                            i do każdej linii dopisz na końcu wygenerowaną liczbę
        //                            zapisz do pliku3
        //                        END
        //                        zamknij strumien zapisu do plik3
        //                    END
        //                    po wykonanej petli usuń plik2
        //                    wyświetl informacje o postępie 6/11
        //           END
        //                    // plik 3 zawiera w tym momencie wszystkie możliwe pierwsze 6 cyfr pesel.
        //           wyświetl informację o wygenerowaniu daty 6/11
        //
        //                petla generująca 1 cyfrę kontrolną (0-9)
        //                    BEGIN
        //                        wygeneruj liczbę z przedziału pętli.
        //                        pobierz linię z pliku3 dopoki plik3 != null
        //                        i do każdej linii dopiszna końcu wygenerowaną cyfrę.
        //                        zapisz do pliku4 w nowych liniach
        //                    END
        //                    zamknij strumien zapisu do plik4
        //                wyswietl informację o wygenerowaniu 1 cyfry kontrolnej (7/11)
        //
        //                petla generująca 2 cyfrę kontrolną (0-9)
        //                    BEGIN
        //                        wygeneruj liczbę z przedziału pętli.
        //                        pobierz linię z pliku4 dopoki plik4 != null
        //                        i do każdej linii dopiszna końcu wygenerowaną cyfrę.
        //                        zapisz do pliku5 w nowych liniach
        //                    END
        //                    zamknij strumien zapisu do plik5
        //                wyswietl informację o wygenerowaniu 2 cyfry kontrolnej (8/11)
        //                petla generująca 3 cyfrę kontrolną (0-9)
        //                    BEGIN
        //                        wygeneruj liczbę z przedziału pętli.
        //                        pobierz linię z pliku5 dopoki plik5 != null
        //                        i do każdej linii dopiszna końcu wygenerowaną cyfrę.
        //                        zapisz do pliku6 w nowych liniach
        //                    END
        //                    zamknij strumien zapisu do plik6
        //                wyswietl informację o wygenerowaniu 3 cyfry kontrolnej (9/11)
        //                petla generująca 4 cyfrę kontrolną  (0-9)
        //                    BEGIN
        //                        wygeneruj liczbę z przedziału pętli.
        //                        pobierz linię z pliku6 dopoki plik6 != null
        //                        do każdej linii dopisz na końcu wygenerowaną cyfrę.
        //                        zapisz do pliku7 w nowych liniach
        //                    END
        //                    zamknij strumien zapisu do plik7
        //                wyswietl informację o wygenerowaniu 4 cyfry kontrolnej (10/11)
        //                    // plik7 zawiera teraz wszystkie możliwe w pesel kombinacje cyfr lecz bez ostatniej cyfry kontrolnej.
        //
        //                petla generująca ostatnią cyfrę kontrolną
        //                    BEGIN
        //                        pobierz linię jako String z plik7 dopóki plik7 != null i zapisz do zmiennej tymczasowej String result
        //
        //                        int suma1 = 1 cyfra * 9
        //                        int suma2 = 2 cyfra * 7
        //                        int suma3 = 3 cyfra * 3
        //                        int suma4 = 4 cyfra * 1
        //                        int suma5 = 5 cyfra * 9
        //                        int suma6 = 6 cyfra * 7
        //                        int suma7 = 7 cyfra * 3
        //                        int suma8 = 8 cyfra * 1
        //                        int suma9 = 9 cyfra * 9
        //                        int suma10 = 10 cyfra * 7
        //
        //                        int sumaCałkowita = suma1+suma2(...)+suma10
        //                        int ostatniaCyfra = sumaCałkowita % 10;
        //
        //                        dopisz do końca utworzonej zmiennej tymczasowej zmienną ostatniaCyfra
        //                        zapisz zmienną result do pliku peselBase od nowych linii
        //                    END
        //                zamknij strumień zapisu do pliku peselBase;
        //                Wyświetl informację o wygenerowaniu bazy pesel (11/11)
        //

         */
    }
}
