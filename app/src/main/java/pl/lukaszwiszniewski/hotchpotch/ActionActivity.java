package pl.lukaszwiszniewski.hotchpotch;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActionActivity extends AppCompatActivity implements View.OnClickListener{
    private Button buttonWebView;
    private Button buttonToasts;
    private Button buttonAnimation;
    private Button buttonBackground;
    private Button buttonLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);
        buttonWebView = (Button) findViewById(R.id.buttonWebView);
        buttonToasts = (Button) findViewById(R.id.buttonToasts);
        buttonAnimation = (Button) findViewById(R.id.buttonAnimation);
        buttonBackground = (Button) findViewById(R.id.buttonBackground);
        buttonLogout = (Button) findViewById(R.id.buttonLogOut);


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
        switch (v.getId()){
            case R.id.buttonWebView:
                if (Bundle.EMPTY == null) {


                    FragmentManager fragmentManager = getFragmentManager();

                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.add(R.id.frameLayout, new FragmentWebView());
                    ft.commit();
                    Log.e("buttonWebView","instance was not created before");
                    break;
                }
            case R.id.buttonToasts:
                if(Bundle.EMPTY==null){
                    FragmentManager fragmentManager = getFragmentManager();

                    FragmentTransaction ft = fragmentManager.beginTransaction();
                    ft.add(R.id.frameLayout, new FragmentToasts());
                    ft.commit();
                    Log.e("buttonToasts","instance was not created before");
                    break;
                }

        }
    }
}
