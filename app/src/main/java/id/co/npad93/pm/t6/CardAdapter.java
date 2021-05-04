package id.co.npad93.pm.t6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {
    CardAdapter(List<Card> cards, IdolAdapter.OnItemClick clickCallback) {
        super();
        this.cards = cards;
        this.clickCallback = clickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        ViewHolder vh = new CardAdapter.ViewHolder(view, clickCallback);
        view.setOnClickListener(vh);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Card card = cards.get(position);

        ApiHelper.loadImageAsync(holder.context, card.getRoundedCardImageURL(), holder.cardImage);
        holder.cardName.setText(ApiHelper.nullCoalesce(card.getTranslatedSkillName(), card.getSkillName()));
        holder.idolName.setText(card.getNameLLMFSOrder());
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        IdolAdapter.OnItemClick callback;

        ImageView cardImage;
        TextView cardName, idolName;

        public ViewHolder(@NonNull View itemView, IdolAdapter.OnItemClick cb) {
            super(itemView);
            context = itemView.getContext();
            callback = cb;

            cardImage = itemView.findViewById(R.id.imageView2);
            cardName = itemView.findViewById(R.id.textView5);
            idolName = itemView.findViewById(R.id.textView6);
        }

        @Override
        public void onClick(View v) {
            callback.onClick(getBindingAdapterPosition());
        }
    }

    private final List<Card> cards;
    private final IdolAdapter.OnItemClick clickCallback;
}
