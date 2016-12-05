package me.composter.rumpus.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import me.composter.rumpus.R;


public class OutputFragment extends Fragment {
    public OutputFragment() {
        // Required empty public constructor
    }

    public static OutputFragment newInstance() {
        OutputFragment fragment = new OutputFragment();

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }
}
