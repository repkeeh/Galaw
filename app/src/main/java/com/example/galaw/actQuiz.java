package com.example.galaw;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

public class actQuiz extends AppCompatActivity {

    int [][] Answer = new int[3][14];
    TextView dass;
    ImageView imageV;
    ProgressBar progressBar;

    class Collection{
        String Quest = new String();
        String picture = new String();
    }

    Collection [][] AllQuestion = new Collection[3][14];
    int type_Question;
    int number_Question;

    Button[] buttons = new Button[4];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_act_quiz);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        type_Question = getIntent().getIntExtra("type_Question",-1);
        number_Question = 0;


        for (int i=0; i< 3; i ++){
            for (int j=0; j< 14; j ++) {

                AllQuestion[i][j] = new Collection();
            }
        }

        //AllQuestion[0][0].Quest = "Saya merasa bahwa diri saya menjadi marah karena hal-hal sepele";
        progressBar = findViewById(R.id.progressBar);
        imageV = findViewById(R.id.imageV);
        dass = findViewById(R.id.dass);
        buttons[0] = findViewById(R.id.jwb0);
        buttons[1] = findViewById(R.id.jwb1);
        buttons[2] = findViewById(R.id.jwb2);
        buttons[3] = findViewById(R.id.jwb3);




        SetCollection();
        dass.setText(""+ AllQuestion[type_Question][0].Quest);
        int id = getResources().getIdentifier("com.example.galaw:drawable/" +AllQuestion[type_Question][0].picture , null, null);
        imageV.setImageResource(id);



      for (int i =0 ; i< buttons.length ; i++){
            final int temp = i;
          buttons[i].setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View v) {
                  ChangeValue(temp);

              }
          });
      }



    }



    void ChangeValue(int index){

        Answer[type_Question][number_Question] = index;
        number_Question ++ ;


        if (number_Question >= 14 ){
        int temp = 0;
            for (int i =0 ; i<  Answer[type_Question].length ; i++){
                temp += Answer[type_Question] [i];

            }

            Intent intent = new Intent(actQuiz.this, actResult.class);
            intent.putExtra("total", temp);
            startActivity(intent);
        }else {

            dass.setText(""+ AllQuestion[type_Question][number_Question].Quest);
            int id = getResources().getIdentifier("com.example.galaw:drawable/" +AllQuestion[type_Question][number_Question].picture , null, null);
            imageV.setImageResource(id);
        }
    }

    void SetCollection(){
// Stress question
        AllQuestion[0][0].Quest = "Saya merasa bahwa diri saya menjadi marah karena hal-hal sepele";
        AllQuestion[0][1].Quest = "Saya cenderung bereaksi berlebihan terhadap suatu situasi.";
        AllQuestion[0][2].Quest = "Saya merasa sulit untuk bersantai.";
        AllQuestion[0][3].Quest = "Saya menemukan diri saya mudah merasa kesal.";
        AllQuestion[0][4].Quest = "Saya merasa telah menghabiskan banyak energi untuk merasa cemas.";
        AllQuestion[0][5].Quest = "Saya menemukan diri saya menjadi tidak sabar ketika mengalami penundaan (misalnya: kemacetan lalu lintas, menunggu sesuatu)";
        AllQuestion[0][6].Quest = "Saya merasa bahwa saya mudah tersinggung.";
        AllQuestion[0][7].Quest = "Saya merasa sulit untuk beristirahat.";
        AllQuestion[0][8].Quest = "Saya merasa bahwa saya sangat mudah marah";
        AllQuestion[0][9].Quest = "Saya merasa sulit untuk tenang setelah sesuatu membuat saya kesal.";
        AllQuestion[0][10].Quest = "Saya sulit untuk sabar dalam menghadapi gangguan terhadap hal yang sedang saya lakukan.";
        AllQuestion[0][11].Quest = "Saya sedang merasa gelisah.";
        AllQuestion[0][12].Quest = "Saya tidak dapat memaklumi hal apapun yang menghalangi saya untuk menyelesaikan hal yang sedang saya lakukan.";
        AllQuestion[0][13].Quest = "Saya menemukan diri saya mudah gelisah.";
//Anxiety Question
        AllQuestion[1][0].Quest = "Saya merasa bibir saya sering kering";
        AllQuestion[1][1].Quest = "Saya mengalami kesulitan bernafas (misalnya: seringkali terengah-engah atau tidak dapat bernafas padahal tidak melakukan aktivitas fisik sebelumnya)";
        AllQuestion[1][2].Quest = "Saya merasa goyah (misalnya, kaki terasa mau ’copot’).";
        AllQuestion[1][3].Quest = "Saya menemukan diri saya berada dalam situasi yang membuat saya merasa sangat cemas dan saya akan merasa sangat lega jika semua ini berakhir. ";
        AllQuestion[1][4].Quest = "Saya merasa lemas seperti mau pingsan";
        AllQuestion[1][5].Quest = "Saya berkeringat secara berlebihan (misalnya: tangan berkeringat), padahal temperatur tidak panas atau tidak melakukan aktivitas fisik sebelumnya. ";
        AllQuestion[1][6].Quest = "Saya merasa takut tanpa alasan yang jelas.";
        AllQuestion[1][7].Quest = "Saya mengalami kesulitan dalam menelan";
        AllQuestion[1][8].Quest = "Saya menyadari kegiatan jantung, walaupun saya tidak sehabis melakukan aktivitas fisik (misalnya: merasa detak jantung meningkat atau melemah).";
        AllQuestion[1][9].Quest = "Saya merasa saya hampir panik.";
        AllQuestion[1][10].Quest = "Saya takut bahwa saya akan ‘terhambat’ oleh tugas-tugas sepele yang tidak biasa saya lakukan. ";
        AllQuestion[1][11].Quest = "Saya merasa sangat ketakutan.";
        AllQuestion[1][12].Quest = "Saya merasa khawatir dengan situasi dimana saya mungkin menjadi panik dan mempermalukan diri sendiri.";
        AllQuestion[1][13].Quest = "Saya merasa gemetar (misalnya: pada tangan)";
//Depression question
        AllQuestion[2][0].Quest = "Saya sama sekali tidak dapat merasakan perasaan positif.";
        AllQuestion[2][1].Quest = "Saya sepertinya tidak kuat lagi untuk melakukan suatu kegiatan.";
        AllQuestion[2][2].Quest = "Saya merasa tidak ada hal yang dapat diharapkan di masa depan.";
        AllQuestion[2][3].Quest = "Saya merasa sedih dan tertekan.";
        AllQuestion[2][4].Quest = "Saya merasa saya kehilangan minat akan segala hal.";
        AllQuestion[2][5].Quest = "Saya merasa bahwa saya tidak berharga sebagai seorang manusia";
        AllQuestion[2][6].Quest = "Saya merasa bahwa hidup tidak bermanfaat.";
        AllQuestion[2][7].Quest = "Saya tidak dapat merasakan kenikmatan dari berbagai hal yang saya lakukan.";
        AllQuestion[2][8].Quest = "Saya merasa putus asa dan sedih.";
        AllQuestion[2][9].Quest = "Saya tidak merasa antusias dalam hal apapun";
        AllQuestion[2][10].Quest = "Saya merasa bahwa saya tidak berharga.";
        AllQuestion[2][11].Quest = "Saya melihat tidak ada harapan untuk masa depan.";
        AllQuestion[2][12].Quest = "Saya merasa bahwa hidup tidak berarti.";
        AllQuestion[2][13].Quest = "Saya merasa sulit untuk meningkatkan inisiatif dalam melakukan sesuatu.";

        AllQuestion[0][0].picture = "satu";
        AllQuestion[0][1].picture = "enam";
        AllQuestion[0][2].picture = "delapan";
        AllQuestion[0][3].picture = "satu"; //sebelas
        AllQuestion[0][4].picture = "duabelas";
        AllQuestion[0][5].picture = "empatbelas";
        AllQuestion[0][6].picture = "satu";
        AllQuestion[0][7].picture = "satu";
        AllQuestion[0][8].picture = "satu";
        AllQuestion[0][9].picture = "satu";
        AllQuestion[0][10].picture = "satu";
        AllQuestion[0][11].picture = "satu";
        AllQuestion[0][12].picture = "satu";
        AllQuestion[0][13].picture = "satu";

        AllQuestion[1][0].picture = "empatbelas";
        AllQuestion[1][1].picture = "empatbelas";
        AllQuestion[1][2].picture = "empatbelas";
        AllQuestion[1][3].picture = "empatbelas";
        AllQuestion[1][4].picture = "empatbelas";
        AllQuestion[1][5].picture = "empatbelas";
        AllQuestion[1][6].picture = "empatbelas";
        AllQuestion[1][7].picture = "empatbelas";
        AllQuestion[1][8].picture = "empatbelas";
        AllQuestion[1][9].picture = "empatbelas";
        AllQuestion[1][10].picture = "empatbelas";
        AllQuestion[1][11].picture = "empatbelas";
        AllQuestion[1][12].picture = "empatbelas";
        AllQuestion[1][13].picture = "empatbelas";

    }
}
