package pl.lukaszwiszniewski.hotchpotch;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActionActivity extends AppCompatActivity implements View.OnClickListener {
    private Button buttonWebView;
    private Button buttonToasts;
    private Button buttonAnimation;
    private Button buttonBackground;
    private Button buttonLogout;
    protected FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        buttonWebView = (Button) findViewById(R.id.buttonWebView);
        buttonWebView.setOnClickListener(this);
        buttonToasts = (Button) findViewById(R.id.buttonToasts);
        buttonToasts.setOnClickListener(this);
        buttonAnimation = (Button) findViewById(R.id.buttonAnimation);
        buttonAnimation.setOnClickListener(this);
        buttonBackground = (Button) findViewById(R.id.buttonBackground);
        buttonBackground.setOnClickListener(this);
        buttonLogout = (Button) findViewById(R.id.buttonLogOut);
        buttonLogout.setOnClickListener(this);
        fragmentManager = getFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);



      /*  if (savedInstanceState == null) {


            FragmentManager fragmentManager = getFragmentManager();

            FragmentTransaction ft = fragmentManager.beginTransaction();
            ft.add(R.id.frameLayout, new FragmentWebView());
            ft.commit();

            //FragmentWebView fragmentWebView = (FragmentWebView) getFragmentManager().findFragmentById(R.id.fragmentWebView);

        }*/
    }


    @Override
    public void onClick(View v) {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        switch (v.getId()) {
            case R.id.buttonWebView:
                ft.replace(R.id.frameLayout, new FragmentWebView());
                ft.commit();
                Log.e("buttonWebView", "instance was not created before");
                break;
            case R.id.buttonToasts:
                ft.replace(R.id.frameLayout, new FragmentToasts());
                ft.commit();
                Log.e("buttonToasts", "instance was not created before");
                break;
            case R.id.buttonAnimation:
                ft.replace(R.id.frameLayout, new FragmentAnimation());
                ft.commit();
                Log.e("buttonAnimation", "instance was not created before");

                break;
            case R.id.buttonBackground:
                ft.replace(R.id.frameLayout, new FragmentBackground());
                ft.commit();
                Log.e("buttonBackground", "instance was not created before");
                break;
            case R.id.buttonLogOut:
                this.finish();
                Log.e("buttonLogout", "instance was not created before");
        }
    }
}
