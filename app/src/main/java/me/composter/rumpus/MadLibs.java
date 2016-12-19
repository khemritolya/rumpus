package me.composter.rumpus;

public class MadLibs {

    public static final String[][] stories = {
            { "Light ", "There was once a young ", "NOUN", " of Wright, who travelled much faster than ", "NOUN",
                    ", and, departing one day, in a relative way, had ", "VERB", " on the previous ", "NOUN", "!" },
            { "Three ", "Once there were three little ", "NOUN", ". One of them ", "VERB", " a house out of ", "NOUN",
                    ", but the big bad ", "NOUN", " blew it down. Another little pig ", "VERB", " his house out of ",
                    "NOUN", ", but again the big bad ", "NOUN", " ", "VERB", " it down. The last little ", "NOUN",
                    " decided to ", "VERB", " a house out of ", "NOUN", " and this time, the ", "NOUN", " did not ",
                    "VERB", " the ", "NOUN", " down. Yay!" },
            { "Lunch ", "Our cafeteria serves wonderful ", "NOUN", ". I especially like the fried ", "NOUN",
                    " special. I can sit on ", "NOUN", "s and ", "VERB", " to my best ", "NOUN", ". Sometimes, the ",
                    "NOUN", " tastes funny, especially when they ", "VERB", " ", "NOUN", "."}
    };

    public static final String[] pos = {
            "NOUN", "VERB"
    };

    public String[] thingsToAskFor;
    public String[] wordsToAdd;

    private int storyId;

    public MadLibs(int storyID) {
        this.storyId = storyID;
        thingsToAskFor = requestInputs();
        wordsToAdd = new String[thingsToAskFor.length];
    }

    public String[] requestInputs() {
        String[] res = new String[countOthers(stories[storyId])];

        int j = 0;
        for (int i = 0; i < stories[storyId].length; i++) {
            if (isOther(stories[storyId][i])) {
                res[j] = stories[storyId][i];
                j++;
            }
        }

        return res;
    }

    public String assemble(String[] inputs) {
        String res = "";
        
        int i = 0;
        for (int j = 0; j < stories[storyId].length; j++) {
            if (isOther(stories[storyId][j])) {
                res += inputs[i];
                i++;
            } else {
                res += stories[storyId][j];
            }
        }
        
        return res;
    }
    private boolean isOther(String in) {
        boolean res = false;

        for (int i = 0; i < pos.length; i++) {
            if (in.equals(pos[i])){
                res = true;
                break;
            }
        }

        return res;
    }

    private int countOthers(String[] story) {
        int i = 0;

        for (int j = 0; j < story.length; j++) {
            if (isOther(story[j])) {
                i++;
            }
        }

        return i;
    }
}
