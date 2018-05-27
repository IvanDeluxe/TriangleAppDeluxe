package net.ivan.triangleappdeluxe;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Triangle}.
 */
public class TriangleHistoryAdapter extends RecyclerView.Adapter<TriangleHistoryAdapter.ViewHolder> {

    private final ArrayList<Triangle> mValues;

    public TriangleHistoryAdapter(ArrayList<Triangle> items) {
        mValues = items;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mSideATextView.setText(String.valueOf(mValues.get(position).a));
        holder.mSideBTextView.setText(String.valueOf(mValues.get(position).b));
        holder.mSideCTextView.setText(String.valueOf(mValues.get(position).c));
        holder.mAreaTextView.setText(String.valueOf(mValues.get(position).area));
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mSideATextView;
        public final TextView mSideBTextView;
        public final TextView mSideCTextView;
        public final TextView mAreaTextView;
        public Triangle mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mSideATextView = (TextView) view.findViewById(R.id.sideATextView);
            mSideBTextView = (TextView) view.findViewById(R.id.sideBTextView);
            mSideCTextView = (TextView) view.findViewById(R.id.sideCTextView);
            mAreaTextView = (TextView) view.findViewById(R.id.areaTextView);
        }
    }
}
