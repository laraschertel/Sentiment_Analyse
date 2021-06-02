package lexicon;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class SentimentWoerterList {
    ArrayList<SentimentWort> sentimentWortList;
    SentimentWort sentimentWort;

    public SentimentWoerterList(){
        this.sentimentWortList = new ArrayList<>();
    }

    public void addWort(SentimentWort wort){
        this.sentimentWortList.add(wort);
    }

    public int getSize(){
        return this.sentimentWortList.size();
    }

    public SentimentWort getSentimentWortIndex(int index){
        return this.sentimentWortList.get(index);
    }

    public void addFromCSVFile(String filepath) {
        File file = new File(filepath);
        FileReader filereader = null;
        try {
            filereader = new FileReader(file);
        } catch (Exception e) {
            System.out.println("Datei nicht gefunden");
            System.exit(1);
        }
        BufferedReader reader = new BufferedReader(filereader);
        try {
            while (reader.ready()) {
                String line = reader.readLine();
                this.addWort(new SentimentWort(line));
            }
        } catch (Exception e) {
            System.out.println("Fehler beim Lesen der Datei");
            e.printStackTrace();
        }
        try {
            reader.close();
        } catch (Exception e) {
            System.out.println("Fehler beim Schließen der Datei");
            e.printStackTrace();
        }

    }
}
