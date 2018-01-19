package inq.cdac.myapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;

public class MainActivity extends AppCompatActivity {

    //this os fpr testing purpose for github...
    //UI fields
    private TextView mscoreView;
    private TextView mQuestion;
    private Button mButtonChoice1,mButtonChoice2,mButtonChoice3,mButtonChoice4;

    private int mScore;
    private int mQuestionNumber = 0;
    private String mAnswer;
    private Firebase mQuestionRef,mchoice1Ref,mChoice2Ref,mChoice3Ref,mChoice4Ref,mAnswerRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mscoreView = findViewById(R.id.score);
        mQuestion = findViewById(R.id.question);

        mButtonChoice1 = findViewById(R.id.choice1);
        mButtonChoice2 = findViewById(R.id.choice2);
        mButtonChoice3 = findViewById(R.id.choice3);
        mButtonChoice4 = findViewById(R.id.choice4);

        String fetchedString = null;

       if(savedInstanceState==null)
       {
           Bundle extras = getIntent().getExtras();
           if(extras==null)
           {
               fetchedString=null;
           }
           else {
               fetchedString = extras.getString("Topic");
           }
       }
       else {
           fetchedString = (String) savedInstanceState.getSerializable("Topic");
       }


       updateQuestion();



        //button1
       mButtonChoice1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {

               if(mButtonChoice1.getText().equals(mAnswer))
               {
                   mScore = mScore+1;
                   updateQuestion();
                   updateScore(mScore);
               }
               else
               {
                   updateQuestion();
               }

           }
       });
       //button2
       mButtonChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice2.getText().equals(mAnswer))
                {
                    mScore = mScore+1;
                    updateQuestion();
                    updateScore(mScore);
                }
                else
                {
                    updateQuestion();
                }

            }
        });
       //button3
        mButtonChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice3.getText().equals(mAnswer))
                {
                    mScore = mScore+1;
                    updateQuestion();
                    updateScore(mScore);
                }
                else
                {
                    updateQuestion();
                }

            }
        });
        //button4
        mButtonChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(mButtonChoice4.getText().equals(mAnswer))
                {
                    mScore = mScore+1;
                    updateQuestion();
                    updateScore(mScore);
                }
                else
                {
                    updateQuestion();
                }

            }
        });

    }


      private void updateScore(int score)
      {

          mscoreView.setText(""+mScore);
      }


    public void updateQuestion()
    {
        mQuestionRef = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/question");
        mQuestionRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String question = dataSnapshot.getValue(String.class);
                mQuestion.setText(question);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mchoice1Ref = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/choice1");
        mchoice1Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice1.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mChoice2Ref = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/choice2");
        mChoice2Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice2.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mChoice3Ref = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/choice3");
        mChoice3Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice3.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mChoice4Ref = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/choice4");
        mChoice4Ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String choice = dataSnapshot.getValue(String.class);
                mButtonChoice4.setText(choice);
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

        mAnswerRef = new Firebase("https://myquiz-330ec.firebaseio.com/"+mQuestionNumber+"/answer");
        mAnswerRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                mAnswer = dataSnapshot.getValue(String.class);

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
        mQuestionNumber++;
    }
}
