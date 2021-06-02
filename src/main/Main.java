package main;

import lexicon.SentimentWoerterList;
import sentimentAnalysis.SentimentAnalyser;
import zeitungen.HeadlineList;

public class Main {

    public static void main(String[] args) {
        HeadlineList headlineList = new HeadlineList();
        headlineList.addFromCSVFile("C:/Users/Lara/Desktop/HTW/ZeitungenList.csv");


        SentimentWoerterList positiveWoerter = new SentimentWoerterList();
        positiveWoerter.addFromCSVFile("C:/Users/Lara/Desktop/HTW/SentiWS_v2.0_Positive.txt");

        /*for(int j = 0; j < positiveWoerter.getSize(); j++){
            System.out.println(positiveWoerter.getSentimentWortIndex(j).getWort());
        }

         */

        SentimentWoerterList negativeWoerter = new SentimentWoerterList();
       negativeWoerter.addFromCSVFile("C:/Users/Lara/Desktop/HTW/SentiWS_v2.0_Negative.txt");

       /*for(int j = 0; j < negativeWoerter.getSize(); j++){
            System.out.println(negativeWoerter.getSentimentWortIndex(j).getWort());
        }

        */

        SentimentAnalyser sentimentAnalyser = new SentimentAnalyser(headlineList, positiveWoerter, negativeWoerter);

        sentimentAnalyser.headlineListeAnalysieren();

          for(int i = 0; i < headlineList.size(); i++) {
            System.out.println(headlineList.getHeadline(i).getHeadlineText() + "; WERT: " + headlineList.getHeadline(i).getSentimentWert() );
         }
    }
}
