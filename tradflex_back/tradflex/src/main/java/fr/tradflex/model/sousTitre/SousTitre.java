package fr.tradflex.model.sousTitre;

public record SousTitre(int id, String body, int timeCodeBegin, int timeCodeEnd) {
    public String formateToSRT()
    {
        String sousTitreFormatSRT = "";
        sousTitreFormatSRT +=   this.id() + "\n" +
                this.timeCodeBegin() + "-->" + this.timeCodeEnd() + "\n" +
                this.body() + "\n";
        return sousTitreFormatSRT;
    }

    private String formateBodyToSRT()
    {
        String bodyFormateToSRT = "";

        return bodyFormateToSRT;
    }

    public String formateTimeCodeToSRT()
    {
        String timeCodeFormateToSRT = "";

        return timeCodeFormateToSRT;
    }
}
