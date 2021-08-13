package com.example.lesson1and3;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Build;
import android.os.Bundle;
import android.widget.Button;

import com.example.lesson1and3.data.Card;
import com.example.lesson1and3.ui.EmojiCardAdapter;
import com.example.lesson1and3.ui.EmojiCardAdapter;
import com.example.lesson1and3.ui.EmojiiGame;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@RequiresApi(api = Build.VERSION_CODES.R)
public class MainActivity extends AppCompatActivity {

    private Button btnrandom;
    private final EmojiiGame game = new EmojiiGame();

    private EmojiCardAdapter cardAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cardAdapter = new EmojiCardAdapter(game);
        RecyclerView recyclerView = findViewById(R.id.recycler);
        recyclerView.setAdapter(cardAdapter);

        Matcher m = Pattern.compile("\\w+").matcher("foo bar");
        while (m.find()) {
            System.out.println("Found: " + m.group(0));
        }

    }
}

//  @Override
//public void cardClick(Card<String> card) {
//  cardAdapter.notifyDataSetChanged();
//}
//}