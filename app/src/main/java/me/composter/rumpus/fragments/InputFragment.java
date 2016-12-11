package me.composter.rumpus.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.SpeechRecognizer;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.composter.rumpus.Launcher;
import me.composter.rumpus.MadLibs;
import org.nope.example.rumpus.R;

import java.util.ArrayList;
import java.util.Locale;


public class InputFragment extends Fragment {
    private String wordType;
    private int position;
    private MadLibs m;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        wordType = getArguments().getString("wordType");
        position = getArguments().getInt("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_input, container, false);

        m = ((Launcher) getActivity()).m;

        ((Launcher) getActivity()).tts.speak("Please say a " + wordType, TextToSpeech.QUEUE_FLUSH, savedInstanceState, "" + this.hashCode());
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Hello world.");
        startActivityForResult(intent, 100);

        return v;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
        m.wordsToAdd[position] = result.get(0);
        try {
            Bundle bundle = new Bundle();
            bundle.putString("wordType", m.thingsToAskFor[position + 1]);
            bundle.putInt("position", position + 1);
            ((Launcher) getActivity()).switchFragment(InputFragment.class, bundle);
        } catch(Exception e) {
            ((Launcher) getActivity()).switchFragment(OutputFragment.class, null);
        }
    }
}
