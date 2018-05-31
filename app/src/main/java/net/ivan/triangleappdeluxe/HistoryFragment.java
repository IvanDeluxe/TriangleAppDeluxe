package net.ivan.triangleappdeluxe;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

/**
 * A fragment representing a list of Items.
 */
public class HistoryFragment extends Fragment {
    TriangleHistoryAdapter mAdapter;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public HistoryFragment() {
    }

    public static HistoryFragment newInstance() {
        return new HistoryFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(new LinearLayoutManager(context));
            recyclerView.setAdapter(mAdapter = new TriangleHistoryAdapter(new ArrayList<Triangle>()));
        }
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        TriangleData td = new TriangleData(getActivity());
        td.putListObject(HistoryFragment.class.getSimpleName(), mAdapter.getItems());
    }

    @Override
    public void onResume() {
        super.onResume();

        TriangleData td = new TriangleData(getActivity());
        mAdapter.setItems(td.getListObject(HistoryFragment.class.getSimpleName(), Triangle.class));
    }

    public void passToAdapter(Object o) {
        mAdapter.addItem((Triangle) o);
    }
}
