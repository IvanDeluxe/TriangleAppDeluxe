package net.ivan.triangleappdeluxe;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

/**
 * {@link RecyclerView.Adapter} that can display a {@link Triangle}.
 */
public class TriangleHistoryAdapter extends RecyclerView.Adapter<TriangleHistoryAdapter.ViewHolder> {

    private final ArrayList<Triangle> mValues;

    TriangleHistoryAdapter(ArrayList<Triangle> items) {
        mValues = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_history_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        Locale locale = Locale.US;

        String format = "%.2f";

        String aText = String.format(locale, format, holder.mItem.a);
        String bText = String.format(locale, format, holder.mItem.b);
        String cText = String.format(locale, format, holder.mItem.c);
        String areaText = String.format(locale, format, holder.mItem.area);
        String timeText = String.valueOf(holder.mItem.time);
        String dateText = String.valueOf(holder.mItem.date);

        holder.mSideATextView.setText(aText);
        holder.mSideBTextView.setText(bText);
        holder.mSideCTextView.setText(cText);
        holder.mAreaTextView.setText(areaText);
        holder.mTimeTextView.setText(timeText);
        holder.mDateTextView.setText(dateText);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        final View mView;
        final TextView mSideATextView;
        final TextView mSideBTextView;
        final TextView mSideCTextView;
        final TextView mAreaTextView;
        final TextView mTimeTextView;
        final TextView mDateTextView;
        Triangle mItem;

        ViewHolder(View view) {
            super(view);
            mView = view;
            mSideATextView = view.findViewById(R.id.sideATextView);
            mSideBTextView = view.findViewById(R.id.sideBTextView);
            mSideCTextView = view.findViewById(R.id.sideCTextView);
            mAreaTextView = view.findViewById(R.id.areaTextView);
            mTimeTextView = view.findViewById(R.id.timeTextView);
            mDateTextView = view.findViewById(R.id.dateTextView);
        }
    }

    public void addItem(Triangle t) {
        for (int i = 0; i < mValues.size(); i++) {
            if (mValues.get(i).area > t.area) {
                mValues.add(i, t);

                notifyItemInserted(i);

                return;
            }
        }

        mValues.add(t);
    }

    public ArrayList<Triangle> getItems() {
        return mValues;
    }

    public void setItems(ArrayList<Triangle> list) {
        mValues.clear();
        mValues.addAll(list);
        notifyDataSetChanged();
    }
}
