package net.ivan.triangleappdeluxe;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class TriangleFragment extends Fragment {
    private EditText text1;
    private EditText text2;
    private EditText text3;

    private TextView resultText;

    public TriangleFragment() {
    }

    /**
     * Returns a new instance of this fragment for the given section
     * number.
     */
    public static TriangleFragment newInstance() {
        return new TriangleFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_triangle, container, false);

        text1 = rootView.findViewById(R.id.editTextA);
        text2 = rootView.findViewById(R.id.editTextB);
        text3 = rootView.findViewById(R.id.editTextC);

        resultText = rootView.findViewById(R.id.textView);

        Button button = rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double a = parseDouble(text1.getText().toString());
                double b = parseDouble(text2.getText().toString());
                double c = parseDouble(text3.getText().toString());

                if(a > 0 && b > 0 && c > 0) {
                    Triangle t = new Triangle(a, b, c);

                    resultText.setText(String.valueOf(t.area));

                    TriangleList.addItem(t);
                }
                else {
                    resultText.setText(R.string.triangle_error);
                }
            }
        });

        return rootView;
    }

    private double parseDouble(String s) {
        double d;

        try {
            d = Double.parseDouble(s);
        } catch(NumberFormatException e) {
            d = 0;
        }

        return d;
    }
}
