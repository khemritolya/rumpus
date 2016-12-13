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

    public String[] requestInputs() {
        System.out.println("Story ID: " + storyId);
        System.out.println("Story: " + java.util.Arrays.toString(stories[storyId]));
        String[] res = new String[countOthers(stories[storyId])];

        int j = 0;
        for (int i = 0; i < stories[storyId].length; i++) {
            res[j] = stories[storyId][i];
        }

        return res;
    }

    public String assemble(String[] inputs) {
        if (inputs.length != stories[storyId].length)
            throw new IllegalArgumentException("Inavlid Input Length");

        String res = "";

        for (int i = 0; i < stories[storyId].length; i++)
            res += stories[storyId][i];

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
