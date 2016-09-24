package pl.lukaszwiszniewski.hotchpotch;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class ActionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        FragmentManager fragmentManager = getFragmentManager();

        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.add(R.id.frameLayout,new FragmentWebView());
        ft.commit();
    }
}
