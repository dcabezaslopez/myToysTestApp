package com.test.mytoys.view;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.test.mytoys.R;
import com.test.mytoys.model.Child;
import com.test.mytoys.model.NavigationEntry;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * Created by david on 9/9/16.
 */
public class CustomNavigationDrawerAdapter extends BaseAdapter {

    private static final int TYPE_ITEM = 0;
    private static final int TYPE_SEPARATOR = 1;

    private Context mContext;

    private ArrayList<Object> mData = new ArrayList<Object>();
    private TreeSet<Integer> sectionHeader = new TreeSet<Integer>();
    private LayoutInflater mInflater = null;

    public CustomNavigationDrawerAdapter(Context context) {

        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void addItem(final Child item) {
        mData.add(item);
        notifyDataSetChanged();
    }

    public void addSectionHeaderItem(final NavigationEntry item) {
        mData.add(item);
        sectionHeader.add(mData.size() - 1);
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        return sectionHeader.contains(position) ? TYPE_SEPARATOR : TYPE_ITEM;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public int getCount() {
        return this.mData.size();
    }

    @Override
    public Object getItem(int position) {
        return this.mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        int rowType = getItemViewType(position);

        if (convertView == null) {
            holder = new ViewHolder();

            convertView = mInflater.inflate(R.layout.item_row, null);
            holder.text = (TextView) convertView.findViewById(R.id.textView);

            switch (rowType) {
                case TYPE_SEPARATOR:
                    convertView.setBackgroundColor(Color.GRAY);
                    holder.text.setText(((NavigationEntry) mData.get(position)).getLabel());
                    break;
                case TYPE_ITEM:
                    holder.text.setText(((Child) mData.get(position)).getLabel());

                    holder.arrow = (ImageView) convertView.findViewById(R.id.arrow_image);
                    if (((Child) mData.get(position)).getType().equalsIgnoreCase("node")) { // is a node
                        holder.arrow.setVisibility(View.VISIBLE);

                    } else {
                        holder.arrow.setVisibility(View.GONE);
                    }
                    break;
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        switch (rowType) {
            case TYPE_SEPARATOR:
                holder.text.setText(((NavigationEntry) mData.get(position)).getLabel());
                break;
            case TYPE_ITEM:
                holder.text.setText(((Child) mData.get(position)).getLabel());

                if (((Child) mData.get(position)).getType().equalsIgnoreCase("node")) { // is a node
                    holder.arrow.setVisibility(View.VISIBLE);

                } else {
                    holder.arrow.setVisibility(View.GONE);
                }
                break;
        }

        return convertView;

    }

    public class ViewHolder {

        TextView text;
        ImageView arrow;

    }
}
