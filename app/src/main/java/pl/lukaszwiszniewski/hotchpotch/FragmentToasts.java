package pl.lukaszwiszniewski.hotchpotch;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentToasts extends Fragment implements View.OnClickListener {
    private Button buttonToast1;
    private Button buttonToast2;

    public FragmentToasts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_toasts, container, false);
        buttonToast1 = (Button) v.findViewById(R.id.buttonToast1);
        buttonToast1.setOnClickListener(this);
        buttonToast2 = (Button) v.findViewById(R.id.buttonToast2);
        buttonToast2.setOnClickListener(this);
        return v;
    }

    @Override
    public void onClick(View v) {
            switch (v.getId()){
                case R.id.buttonToast1:
                    Toast.makeText(this.getActivity(), "Toast1 - works", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.buttonToast2:
                    Toast.makeText(this.getActivity(), "Toast2 - works", Toast.LENGTH_SHORT).show();
                    break;
            }
    }
}
