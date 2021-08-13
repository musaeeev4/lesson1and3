package com.example.lesson1and3.ui;


import android.graphics.Color;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson1and3.MainActivity;
import com.example.lesson1and3.R;
import com.example.lesson1and3.data.Card;

import java.util.Timer;
import java.util.TimerTask;

@RequiresApi(api = Build.VERSION_CODES.R)
public class EmojiCardAdapter extends RecyclerView.Adapter<EmojiCardAdapter.EmojiHolder> {

    private EmojiiGame game;

    public EmojiCardAdapter(EmojiiGame game) {
        this.game = game;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view, game);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }

    class EmojiHolder extends RecyclerView.ViewHolder {
        private final EmojiiGame game;
        private TextView tvCard;
        private Animation fadeIn;

        public EmojiHolder(@NonNull View itemView, EmojiiGame game) {
            super(itemView);
            tvCard = itemView.findViewById(R.id.item_tv);
            this.game = game;
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(v -> {
                game.choose(card);
//                for (int i = 0; i < game.getCards().size(); i++) {
//                    if (game.getCards().get(i).isMatch()) {
//                        game.getCards().get(i).setFaceAp(true);
//                    }
                //}
                    new Timer().schedule(new TimerTask() {
                                    @Override
                                    public void run() {
                for (int i = 0; i < game.getCards().size(); i++) {
                    if (game.getCards().get(i).isMatch()) {
                        game.getCards().remove(i);
                    }
                                 }

                                    }
                                }, 500);
                notifyDataSetChanged();
            });

            if (card.isFaceAp()) {
                tvCard.setBackgroundColor(Color.WHITE);
                tvCard.setText((card.getContent()));

            } else {
                tvCard.setBackgroundColor(Color.BLUE);
                tvCard.setText("");
            }

        }

    }

    public interface Listener {
        void cardClick(Card<String> card);
    }
}
