import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        PeselCheck pc = new PeselCheck();
        Long Pesel;

        System.out.println("Wybierz opcję: 1-Sprawdź poprawność PESEL 2-Wygeneruj wszystkie możliwe PESEL");
        int instruction = scanner.nextInt();
        switch (instruction){
            case 1:
                System.out.print("Wpisz pesel: ");
                Pesel = scanner.nextLong();
                if (pc.sprawdzPesel(Pesel)) {
                    System.out.println('D');
                } else {
                    System.out.println('N');
                }
                break;
            case 2:
                PeselGenerator pg = new PeselGenerator();
                pg.generujWszystkieMozliwePesele();
            default:
                System.out.println("Błędny wybór");
        }
        }
}
