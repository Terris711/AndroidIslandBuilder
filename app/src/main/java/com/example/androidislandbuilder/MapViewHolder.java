package com.example.androidislandbuilder;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MapViewHolder extends ViewModel {
    MapData mapData = MapData.get();
    MutableLiveData<Structure> selectedStructure = new MutableLiveData<>();
}
