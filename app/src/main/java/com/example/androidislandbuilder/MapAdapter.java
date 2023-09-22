package com.example.androidislandbuilder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Map;

public class MapAdapter extends RecyclerView.Adapter<MapAdapter.ViewHolder> {
    MapViewHolder liveData;

    public MapAdapter(MapViewHolder liveData) {
        this.liveData = liveData;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private final View view;
        public ViewHolder (@NonNull View itemView) {
            super(itemView);
            view = itemView;
        }

        public View getImageView() {
            return view;
        }

        public void bind(MapElement mapElement, MapViewHolder liveData, int position){
            ImageView terrain1 = view.findViewById(R.id.terrain1);
            terrain1.setImageResource(mapElement.getNorthWest());

            ImageView terrain2 = view.findViewById(R.id.terrain2);
            terrain1.setImageResource(mapElement.getNorthEast());

            ImageView terrain3 = view.findViewById(R.id.terrain3);
            terrain1.setImageResource(mapElement.getSouthWest());

            terrain1.setImageResource(mapElement.getSouthEast());

            ImageView structure = view.findViewById(R.id.terrain5);
            if (mapElement.getStructure() != null){
                structure.setImageResource(mapElement.getStructure().getDrawableId());
            }

            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Structure curStruct = liveData.selectedStructure.getValue();
                    if (curStruct != null && mapElement.isBuildable()){
                        structure.setImageResource(curStruct.getDrawableId());
                        mapElement.setStructure(curStruct);
                        notifyItemChanged(position);
                    }
                }
            });
        }
    }
    @NonNull
    @Override
    public MapAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_cell,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MapAdapter.ViewHolder holder, int position){
        int row = position % MapData.HEIGHT;
        int col = position / MapData.WIDTH;
        holder.bind(liveData.mapData.get(row,col), liveData,position);
    }

    @Override
    public int getItemCount(){
        return MapData.HEIGHT * MapData.WIDTH;
    }
}
