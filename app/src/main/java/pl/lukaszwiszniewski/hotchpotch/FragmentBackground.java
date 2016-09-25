package pl.lukaszwiszniewski.hotchpotch;


import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.app.Fragment;
import android.os.Handler;
import android.os.Message;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentBackground extends Fragment {
    private FrameLayout layout;

    public FragmentBackground() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_background, container, false);

        layout = (FrameLayout) v.findViewById(R.id.layout);
        final AnimationDrawable animation = (AnimationDrawable) layout.getBackground();

        Handler handler = new Handler(new Handler.Callback(){
            @Override
            public boolean handleMessage (Message msg){
                switch (msg.what){
                    case 1: {
                        animation.start();
                        break;
                    }
                    case 2: {
                        animation.stop();
                        break;
                    }
                }return false;
            }
        });
        handler.sendEmptyMessageDelayed(1,1000);
        handler.sendEmptyMessageDelayed(2,15000);

        return v;
    }

}
