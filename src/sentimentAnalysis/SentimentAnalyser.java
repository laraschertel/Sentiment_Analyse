package sentimentAnalysis;

import lexicon.SentimentWoerterList;
import zeitungen.Headline;
import zeitungen.HeadlineList;

public class SentimentAnalyser {
    private HeadlineList headlineList;
    private SentimentWoerterList positiveWoerter;
    private SentimentWoerterList negativeWoerter;

    public SentimentAnalyser(HeadlineList headlineList,SentimentWoerterList positiveWoerter, SentimentWoerterList negativeWoerter ){
        this.headlineList = headlineList;
        this.positiveWoerter = positiveWoerter;
        this.negativeWoerter = negativeWoerter;
    }

    public void einHeadlineAnalysieren(Headline headline) {

        double totalHeadlineWert = 0;
        double totalWoerter = 0;
        String[] parts = headline.getHeadlineText().split("\\s+");
        for (int i = 0; i < parts.length; i++) {
            for (int j = 0; j < positiveWoerter.getSize(); j++) {
                if ((positiveWoerter.getSentimentWortIndex(j).getWort() != null && positiveWoerter.getSentimentWortIndex(j).getWort().equalsIgnoreCase(parts[i]))
                        || (positiveWoerter.getSentimentWortIndex(j).getSentimentVariationen() != null && positiveWoerter.getSentimentWortIndex(j).getSentimentVariationen().contains(parts[0]))) {
                    totalHeadlineWert = positiveWoerter.getSentimentWortIndex(j).setimentWert;
                    totalWoerter++;
                }
            }
                for (int k = 0; k < negativeWoerter.getSize(); k++) {
                    if ((negativeWoerter.getSentimentWortIndex(k).getWort() != null && negativeWoerter.getSentimentWortIndex(k).getWort().equalsIgnoreCase(parts[i]))
                            || (negativeWoerter.getSentimentWortIndex(k).getSentimentVariationen() != null && negativeWoerter.getSentimentWortIndex(k).getSentimentVariationen().contains(parts[0]))) {
                        totalHeadlineWert = negativeWoerter.getSentimentWortIndex(k).setimentWert;
                        totalWoerter++;
                    }

                }
            }


        if(totalWoerter != 0){
            headline.setSentimentWert(totalHeadlineWert/totalWoerter);
        }

    }

    public void headlineListeAnalysieren(){
        for(int i = 0; i < this.headlineList.size(); i++){
            einHeadlineAnalysieren(this.headlineList.getHeadline(i));
        }
    }
}
