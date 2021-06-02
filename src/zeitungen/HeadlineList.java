package zeitungen;

import lexicon.SentimentWoerterList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class HeadlineList {
    ArrayList<Headline> headlinesList;
    Headline headlineParser;


    public HeadlineList(){
        this.headlinesList = new ArrayList<>();
    }

    public void addHeadline(Headline headline){
        if(headline.getZeitung() != null) {
            headlinesList.add(headline);
        }
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
                this.addHeadline(new Headline(line));
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

    public int size() {
        return this.headlinesList.size();
    }

    public Headline getHeadline(int index){
        return this.headlinesList.get(index);
    }
    SentimentWoerterList positiveWoerter = new SentimentWoerterList();
    SentimentWoerterList negativeWoerter = new SentimentWoerterList();



}
