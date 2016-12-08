package me.composter.rumpus.fragments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.widget.TextView;

import org.nope.example.rumpus.R;

import me.composter.rumpus.Launcher;

public class OutputFragment extends Fragment {

    public OutputFragment() {
        super();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        String story = savedInstanceState.getString("THITNFA UGTRFBL");

        TextView t = (TextView) getView().findViewById(R.id.viewThing);
        t.setText(story);

        ((Launcher) this.getActivity()).tts.speak(story, TextToSpeech.QUEUE_FLUSH, null, this.hashCode() + ":" + story);
    }
}
