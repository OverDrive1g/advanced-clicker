package com.example.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.Collection;
import java.util.List;

public class UpdateAdapter extends RecyclerView.Adapter<UpdateAdapter.ViewHolder> {
    private List<Upgrade> datas;

    public UpdateAdapter(List<Upgrade> datas) {
        this.datas = datas;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.upgrade_layout_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Log.d("updateAdapter", "onBindViewHolder: "+i);
        viewHolder.bind(datas.get(i));
    }

    @Override
    public int getItemCount() {
        Log.d("updateAdapter", "getItemCount: "+datas.size());
        return datas.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout layout;
        public ImageView image;
        public TextView text;
        public TextView description;
        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.upgrade_layout);
            text = itemView.findViewById(R.id.upgrade_name);
            image = itemView.findViewById(R.id.upgrade_image);
            description = itemView.findViewById(R.id.upgrade_description);
        }

        public void bind(Upgrade upgrade){
            image.setImageResource(upgrade.getImageId());
            text.setText(upgrade.getName());
            description.setText(upgrade.getDescription());

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Snackbar.make(v, "Пока не сделал :c", Snackbar.LENGTH_SHORT)
                            .setAction("TODO", null).show();
                }
            });
        }
    }

}
