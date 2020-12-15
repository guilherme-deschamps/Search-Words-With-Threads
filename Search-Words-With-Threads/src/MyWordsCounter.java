import java.io.*;

public class MyWordsCounter extends Thread {

    private int begin;
    private int end;
    private String word;
    private int ocurrences = 0;

    public MyWordsCounter(int begin, int end, String word) {
        this.begin = begin;
        this.end = end;
        this.word = word;
    }

    @Override
    public void run() {
        for (int i = begin; i <= end; i++) {
            File file = new File("dataset" + File.separator + i + ".txt");
            try {
                FileReader fileReader = new FileReader(file);
                BufferedReader reader = new BufferedReader(fileReader);
                String line = reader.readLine();
                while(line != null){
                    if(line.equals(word))
                        ocurrences++;
                    line = reader.readLine();
                }
                reader.close();
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public int getOcurrences(){
        return ocurrences;
    }
}
