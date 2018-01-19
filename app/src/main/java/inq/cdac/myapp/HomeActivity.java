package inq.cdac.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {
    
    ImageView practicemode,challengemode;
    
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        
         practicemode = findViewById(R.id.practice_mode);
         challengemode = findViewById(R.id.challenge_mode);
        
        
        practicemode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HomeActivity.this,TopicsActivity.class));
            }
        });
        
        
        
        
    }

}
