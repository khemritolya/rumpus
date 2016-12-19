package me.composter.rumpus.fragments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import me.composter.rumpus.Launcher;
import org.nope.example.rumpus.R;

public class OutputFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_output, container, false);

        String story = ((Launcher) getActivity()).m.assemble(((Launcher) getActivity()).m.wordsToAdd);

        TextView t = (TextView) v.findViewById(R.id.viewThing);
        t.setText(story);

        ((Launcher) getActivity()).tts.speak(story, TextToSpeech.QUEUE_FLUSH, null, this.hashCode() + ":" + story);
        return v;
    }
}
