package me.composter.rumpus.fragments;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import me.composter.rumpus.Launcher;
import me.composter.rumpus.MadLibs;
import me.composter.rumpus.fragments.dummy.Story;
import me.composter.rumpus.util.ItemListAdapter;
import org.nope.example.rumpus.R;

import java.util.ArrayList;

public class StoryFragment extends ListFragment {
    protected ItemListAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ItemListAdapter(getActivity(), generateStories());
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        String text = "You selected: " + ((TextView) v.findViewById(R.id.text1)).getText();

        Toast.makeText(getContext(), text, Toast.LENGTH_SHORT).show();

        ((Launcher) this.getActivity()).tts.speak(text, TextToSpeech.QUEUE_FLUSH, null, this.hashCode() + ":" + text);

        ((Launcher)getActivity()).m = new MadLibs(position);
        String[] thingsToAskFor = ((Launcher)getActivity()).m.requestInputs();
        String[] thingsIGot = new String[thingsToAskFor.length];

        for (int i = 0; i < thingsToAskFor.length; i++) {
            //thingsIGot[i];
        }

        String res = ((Launcher)getActivity()).m.assemble(thingsIGot);


    }

    private ArrayList<Story> generateStories() {
        ArrayList<Story> stories = new ArrayList<>();
        int i = 0;
        for (String[] strings : MadLibs.stories) {
            stories.add(new Story(strings[0], i));
            i++;
        }
        return stories;
    }
}
