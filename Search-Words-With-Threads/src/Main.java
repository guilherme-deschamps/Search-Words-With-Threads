import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final int qtFiles = 250;

    public static void main(String[] args) throws InterruptedException {

        int ocurrences = 0;

        String word = "potato";

        /** Para utilizar o bloco de código abaixo, basta comentar a declaração
         * da variável "qtThreads" e descomentar o bloco de código abaixo.
         *
         * Scanner s = new Scanner(System.in);
         * System.out.println("Informe a quantidade de threads a ser utilizada na execução: ");
         * int qtThreads = s.nextInt();
         */

        int qtThreads = 250;

        List<MyWordsCounter> threads = new ArrayList<>();

        for (int i = 0; i < qtThreads; i++) {
            int begin = new Float((qtFiles / qtThreads) * i).intValue();
            int end = new Float(((qtFiles / qtThreads) * (i + 1)) - 1).intValue();
            MyWordsCounter thread = new MyWordsCounter(begin, end, word);
            thread.start();
            threads.add(thread);
        }

        for (MyWordsCounter t : threads) {
            t.join();
            ocurrences += t.getOcurrences();
        }

        System.out.println("Processo finalizado! A quantidade de ocorrências da " +
                "palavra \"" + word + "\" é " + ocurrences + ".");
    }
}
