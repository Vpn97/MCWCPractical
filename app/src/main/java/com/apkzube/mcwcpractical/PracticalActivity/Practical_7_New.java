package com.apkzube.mcwcpractical.PracticalActivity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.apkzube.mcwcpractical.R;
import com.apkzube.mcwcpractical.Words;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Practical_7_New extends AppCompatActivity {

    RecyclerView rcView;
    List<Words> list=new ArrayList<>();
    WordsAdapter wordsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_7__new);
        allocation();
        setEvent();
    }


    private void allocation() {
        rcView=findViewById(R.id.rcView);
        wordsAdapter=new WordsAdapter(list);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        rcView.setLayoutManager(layoutManager);
        rcView.setItemAnimator(new DefaultItemAnimator());
        rcView.

                addItemDecoration(new DividerItemDecoration(this,LinearLayoutManager.VERTICAL));

        rcView.setAdapter(wordsAdapter);

        int count=getIntent().getIntExtra("count",1);
        Random random=new Random();
        int size;

        for(int i=0;i<count;i++){
            size=random.nextInt(9999)+1;
            list.add(new Words(""+size));
        }
    }


    private void setEvent() {

    }



    public class WordsAdapter extends RecyclerView.Adapter<WordsAdapter.MyViewHolder> {
        List<Words> wordsList;

        public WordsAdapter(List<Words> wordsList) {
            this.wordsList = wordsList;
        }

        @NonNull
        @Override
        public WordsAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.words_row,parent,false);
            return new MyViewHolder(view);
        }

        @Override
        public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
            final Words word = wordsList.get(position);
            holder.txtWord.setText(word.getWord());
        }

        @Override
        public int getItemCount() {
            return wordsList.size();
        }


        public class MyViewHolder extends RecyclerView.ViewHolder {

            View myView;
            TextView txtWord;

            public MyViewHolder(View itemView) {
                super(itemView);
                myView = itemView;
                txtWord = myView.findViewById(R.id.txtWord);
            }
        }
    }
}
