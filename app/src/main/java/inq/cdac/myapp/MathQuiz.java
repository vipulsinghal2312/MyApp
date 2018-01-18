package inq.cdac.myapp;

import android.app.Application;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.Firebase;

/**
 * Created by dmc on 18/01/18.
 */

public class MathQuiz extends Application {



    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);


    }
}
