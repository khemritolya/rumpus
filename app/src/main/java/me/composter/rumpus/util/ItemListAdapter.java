package me.composter.rumpus.util;

import android.content.Context;
import android.support.v7.view.menu.ListMenuItemView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;
import me.composter.rumpus.fragments.dummy.Story;

import java.util.ArrayList;

public class ItemListAdapter extends BaseAdapter {
    private Context context;
    private ArrayList<Story> stories;

    public ItemListAdapter(Context context, ArrayList<Story> stories) {
        this.context = context;
        this.stories = stories;
    }

    @Override
    public int getCount() {
        return stories.size();
    }

    @Override
    public Object getItem(int position) {
        return stories.get(position);
    }

    @Override
    public long getItemId(int position) {
        return stories.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (stories == null) {
            stories = new ArrayList<>();
        }
        TwoLineListItem twoLineListItem;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            twoLineListItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null);
        } else {
            twoLineListItem = (TwoLineListItem) convertView;
        }

        TextView text1 = twoLineListItem.getText1();
        TextView text2 = twoLineListItem.getText2();

        text1.setText(stories.get(position).getName());

        return twoLineListItem;
    }
}
