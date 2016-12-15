package me.composter.rumpus;

public class MadLibs {

    public static final String[][] stories = {
            { "Example", "There was once a young ", "NOUN", " of Wright, who travelled much faster than ", "NOUN",
                    ", and, departing one day, in a relative way, had ", "VERB", " on the previous ", "NOUN", "!" },
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
    }

    public static String[] requestInputs() {
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

    private String assemble(String[] inputs) {
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
