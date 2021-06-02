package lexicon;

public class SentimentWort {
    public final String wort;
    public final double setimentWert;
    public String sentimentVariationen;


    public SentimentWort(String line) {
        String[] parts = line.split("\t");
        String wortUnsauber = parts[0];
        String[] wort = wortUnsauber.split("\\|");
        this.wort = wort[0];
        this.setimentWert = Double.parseDouble(parts[1]);
        if(parts.length == 3) {
            this.sentimentVariationen = parts[2];
        }
    }

    public String getWort() {
        return this.wort;
    }

    public double getSetimentWert() {
        return this.setimentWert;
    }

    public String getSentimentVariationen() {
        return this.sentimentVariationen;
    }


}
