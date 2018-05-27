package net.ivan.triangleappdeluxe;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * A fragment representing a list of Items.
 */
public class HistoryFragment extends Fragment {

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
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_history, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();

            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setReverseLayout(true);
            linearLayoutManager.setStackFromEnd(true);

            RecyclerView recyclerView = (RecyclerView) view;
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(new TriangleHistoryAdapter(TriangleList.getItems()));
        }
        return view;
    }

    @Override
    public void onPause() {
        super.onPause();

        TriangleData td = new TriangleData(getActivity());
        td.putListObject(TriangleList.class.getSimpleName(), TriangleList.getItems());
    }

    @Override
    public void onResume() {
        super.onResume();

        TriangleData td = new TriangleData(getActivity());
        TriangleList.setItems(td.getListObject(TriangleList.class.getSimpleName(), Triangle.class));
    }
}
