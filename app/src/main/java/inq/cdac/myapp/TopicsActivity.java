package inq.cdac.myapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class TopicsActivity extends AppCompatActivity {
ImageView permutationsandcombinations,probability,analogies,numberseries;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_topics);

        permutationsandcombinations = findViewById(R.id.permutationsandcombinations);
        probability = findViewById(R.id.probability);
        analogies = findViewById(R.id.analogies);
        numberseries = findViewById(R.id.numberseries);

        permutationsandcombinations.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TopicsActivity.this,MainActivity.class);
                intent.putExtra("Topic",1);
                startActivity(intent);


            }
        });

        probability.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(TopicsActivity.this,MainActivity.class);
                intent.putExtra("Topic",2);
                startActivity(intent);


            }
        });


        analogies.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsActivity.this,MainActivity.class);
                intent.putExtra("Topic",3);
                startActivity(intent);

            }
        });

        numberseries.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TopicsActivity.this,MainActivity.class);
                intent.putExtra("Topic",4);
                startActivity(intent);


            }
        });








    }
}
