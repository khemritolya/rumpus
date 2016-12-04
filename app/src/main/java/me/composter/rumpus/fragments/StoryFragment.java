package me.composter.rumpus.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.view.View;
import android.widget.ListView;
import me.composter.rumpus.MadLibs;
import me.composter.rumpus.fragments.dummy.Story;
import me.composter.rumpus.util.ItemListAdapter;

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
        //I haven't the faintest idea.
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
