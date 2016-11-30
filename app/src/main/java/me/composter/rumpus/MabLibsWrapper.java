package me.composter.rumpus;

public class MabLibsWrapper {

    private String[] text;
    private String[] words;

    public MabLibsWrapper(int id, String[] words) {
        if (MabLibs.all[id].length + 1 != words.length)
            throw new IllegalArgumentException("Invalid Array Lengths in MadLibsWrapper");

        this.text = MabLibs.all[id];
        this.words = words;
    }

    public String assemble() {
        String res = words[0];

        for (int i = 0; i < text.length; i++) {
            res += text[i] + words[i + 1];
        }

        return res;
    }
}
