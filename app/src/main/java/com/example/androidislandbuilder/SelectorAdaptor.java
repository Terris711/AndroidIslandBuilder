package com.example.androidislandbuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class SelectorAdaptor extends RecyclerView.Adapter<SelectorAdaptor.ViewHolder> {


    StructureData structureData = new StructureData();
    MapViewHolder liveData;

    public SelectorAdaptor(MapViewHolder liveData) {
        this.liveData = liveData;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public View getImageView() {
            return view;
        }

        public void bind(Structure structure, MapViewHolder liveData) {
            ImageView imageView = view.findViewById(R.id.image_view);
            imageView.setImageResource(structure.getDrawableId());
            TextView textView = view.findViewById(R.id.structure_des);
            textView.setText(structure.getLabel());

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    liveData.selectedStructure.setValue(structure);
                }
            });
        }
    }

    @NonNull
    @Override
    public SelectorAdaptor.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_selection, parent, false);
        return new SelectorAdaptor.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SelectorAdaptor.ViewHolder holder, int position) {
        holder.bind(structureData.get(position), liveData);
    }

    @Override
    public int getItemCount() {
        return structureData.size();
    }
}