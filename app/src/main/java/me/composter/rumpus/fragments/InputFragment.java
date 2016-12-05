package me.composter.rumpus.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.nope.example.rumpus.R;

import java.util.ArrayList;

public class InputFragment extends Fragment {
    private String wordType;

    @Override
    public void setArguments(Bundle args) {
        super.setArguments(args);
        wordType = getArguments().getString("wordType");

    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_input, container, false);
    }
}
