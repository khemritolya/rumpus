package me.composter.rumpus.util;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;
import me.composter.rumpus.fragments.dummy.Story;
import org.nope.example.rumpus.R;

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
        LinearLayout listItemLayout;
        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            listItemLayout = (LinearLayout) inflater.inflate(R.layout.list_item, null);
        } else {
            listItemLayout = (LinearLayout) convertView;
        }

        TextView text = (TextView) listItemLayout.findViewById(R.id.text1);

        text.setText(stories.get(position).getName());

        return listItemLayout;
    }
}
