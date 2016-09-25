package pl.lukaszwiszniewski.hotchpotch;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentToasts extends Fragment implements View.OnClickListener {


    public FragmentToasts() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_toasts, container, false);
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
