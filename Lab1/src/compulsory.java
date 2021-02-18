public class compulsory {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = { "C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java" };

        int n = (int) (Math.random() * 1_000_000);
        System.out.println("Numarul ales random: " + n);

        n *= 3;
        // n += Integer.parseInt("10101", 2); // transforma sirul ce reprezinta nr din baza 2 in integer in baza 10
        // n += Integer.parseInt("FF", 16); // din baza 16 in 10
        n += 0b10101 + 0xFF;
        n *= 6;
        System.out.println("Rezultatul operatiilor: " + n);

        int sum;
        do {
            sum = 0;
            while (n != 0) {    // suma cifrelor
                sum += n % 10;
                n /= 10;
            }
            n = sum; // atribuim lui n rezultatul obtinut pentru a recalcula suma cifrelor
        }while(sum > 9);
        System.out.println("Suma cifrelor: " + sum);

        System.out.println("Willy-nilly, this semester I will learn " + languages[sum]);
    }
}
