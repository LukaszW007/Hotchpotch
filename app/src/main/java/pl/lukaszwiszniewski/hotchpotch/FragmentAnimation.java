package pl.lukaszwiszniewski.hotchpotch;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import static android.R.attr.animation;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentAnimation extends Fragment {
    private ImageView imageView;

    public FragmentAnimation() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_animation, container, false);
        imageView = (ImageView) v.findViewById(R.id.imageView);
        Animation animation = AnimationUtils.loadAnimation(this.getActivity(),R.anim.fadein);
        imageView.startAnimation(animation);
        //imageView.setAnimation(animation);
        //animation.start();

        return v;
    }

}
