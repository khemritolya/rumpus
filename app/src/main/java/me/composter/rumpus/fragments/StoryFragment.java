package me.composter.rumpus.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import me.composter.rumpus.R;
import me.composter.rumpus.fragments.dummy.DummyContent;
import me.composter.rumpus.fragments.dummy.DummyContent.DummyItem;
import org.nope.example.rumpus.R;

import java.util.List;

public class StoryFragment extends ListFragment {
    protected ItemListAdapter adapter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        adapter = new ItemListAdapter(getActivity(), /**Something goes here.**/);
        setListAdapter(adapter);
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        //I haven't the faintest idea.
    }
}
