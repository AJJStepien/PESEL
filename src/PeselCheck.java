public class PeselCheck {

    private int[] table = new int[11];
    private Long pesel;

    public Long getPesel() {
        return pesel;
    }

    public int[] getTable() {
        return table;
    }

    public boolean sprawdzPesel(Long Pesel) {
        this.pesel = Pesel;
        String value = Pesel.toString();
        int[] suma = new int[11];
        int result = 0;

        if (value.length() != 11) {
           // System.out.println("Niewłaściwa liczba cyfr!");
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            table[i] = value.charAt(i);

            switch (i) {
                case 0:
                    suma[i] = table[i] * 1;
                    break;
                case 1:
                    suma[i] = table[i] * 3;
                    break;
                case 2:
                    suma[i] = table[i] * 7;
                    break;
                case 3:
                    suma[i] = table[i] * 9;
                    break;
                case 4:
                    suma[i] = table[i] * 1;
                    break;
                case 5:
                    suma[i] = table[i] * 3;
                    break;
                case 6:
                    suma[i] = table[i] * 7;
                    break;
                case 7:
                    suma[i] = table[i] * 9;
                    break;
                case 8:
                    suma[i] = table[i] * 1;
                    break;
                case 9:
                    suma[i] = table[i] * 3;
                    break;
                case 10:
                    suma[i] = table[i] * 1;
                    break;
                default:
                    System.out.println("coś poszło nie tak");
            }
        }
        for (int x = 0; x < suma.length; x++) {
            result += suma[x];
        }


        return result % 10 == 0;
    }

}
