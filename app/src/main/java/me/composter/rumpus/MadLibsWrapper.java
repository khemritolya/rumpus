package me.composter.rumpus;

public class MadLibsWrapper {

    private String[] text;
    private String[] words;

    public MadLibsWrapper(int id, String[] words) {
        /*if (MadLibs.all[id].length + 1 != words.length)
            throw new IllegalArgumentException("Invalid Array Lengths in MadLibsWrapper");

        this.text = MadLibs.all[id];
        this.words = words;*/
    }

    public String assemble() {
        String res = words[0];

        for (int i = 0; i < text.length; i++) {
            res += text[i] + words[i + 1];
        }

        return res;
    }
}
