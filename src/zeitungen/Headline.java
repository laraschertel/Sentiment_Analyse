package zeitungen;

public class Headline {
    public final String line;
    public final String zeitung;
    public final String headlineText;
    public final String datum;
    public double sentimentWert;
    public final String SUEDDEUTSCHE = "Sueddeutsche Zeitung";

    public Headline(String line){
        this.line = line;
        String[] parts = line.split(",");
        this.zeitung = parts[0];
        this.headlineText = parts[1];
        this.datum = parts[2];
        this.sentimentWert = 0;

    }

    public String getHeadlineText(){
        return this.headlineText;
    }

    private Datum getDatum() {
        String[] datumParts = this.datum.split(".");

        return new Datum(Integer.parseInt(datumParts[0]), Integer.parseInt(datumParts[1]), Integer.parseInt(datumParts[2]));
    }

    Zeitungen getZeitung() {

        Zeitungen zeitungEnum = null;

        switch (this.zeitung){
            case SUEDDEUTSCHE:
                zeitungEnum = Zeitungen.SUEDDEUTSCHE;

        }
        return zeitungEnum;

    }

    public double getSentimentWert() {
        return this.sentimentWert;
    }

    public void setSentimentWert(double sentimentWert) {
        this.sentimentWert = sentimentWert;
    }
}
