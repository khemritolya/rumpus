package me.composter.rumpus.fragments;


import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import org.nope.example.rumpus.R;

import me.composter.rumpus.Launcher;

public class HelpFragment extends Fragment {


    public HelpFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_help, container, false);

        Button b = (Button)v.findViewById(R.id.nounButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "A noun is an idea or an objct: Like chair, or water, or cow, or ipad";
                ((Launcher) getActivity()).tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, this.hashCode() + text);
            }
        });

        b = (Button)v.findViewById(R.id.verbButton);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "A verb is an action word: Like run, or fly, or give, or say";
                ((Launcher) getActivity()).tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, this.hashCode() + text);
            }
        });

        return v;
    }

}
