package id.co.npad93.pm.t6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class IdolAdapter extends RecyclerView.Adapter<IdolAdapter.ViewHolder> {
    public IdolAdapter(@NonNull List<Idol> idols, OnItemClick clickCallback) {
        super();
        this.idols = idols;
        this.clickCallback = clickCallback;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_idol, parent, false);
        ViewHolder vh = new ViewHolder(view, clickCallback);
        view.setOnClickListener(vh);

        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Idol idol = idols.get(position);

        ApiHelper.loadImageAsync(holder.context, idol.getCharacterSmallImageURL(), holder.smallImage);
        holder.name.setText(idol.getNameLLMFSOrder());
        holder.jpnName.setText(idol.getJapaneseName());
        holder.group.setText(idol.getGroup());
    }

    @Override
    public int getItemCount() {
        return idols.size();
    }

    public interface OnItemClick {
        void onClick(int i);
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        Context context;
        ImageView smallImage;
        TextView name, jpnName, group;
        OnItemClick callback;

        public ViewHolder(@NonNull View itemView, OnItemClick cb) {
            super(itemView);
            context = itemView.getContext();
            callback = cb;

            smallImage = itemView.findViewById(R.id.imageView);
            name = itemView.findViewById(R.id.textView);
            jpnName = itemView.findViewById(R.id.textView2);
            group = itemView.findViewById(R.id.textView3);
        }

        @Override
        public void onClick(View v) {
            callback.onClick(getBindingAdapterPosition());
        }
    }

    private final List<Idol> idols;
    private final OnItemClick clickCallback;
}
