package com.yoti.robotichoover;

import java.util.List;

public class HooverOutput {
    private List<Integer> coords = null;
    private int patches;

    public HooverOutput(List<Integer> coords, Integer patches){
        this.coords = coords;
        this.patches = patches;
    }

    public List<Integer> getCoords() {
        return coords;
    }

    public void setCoords(List<Integer> coords) {
        this.coords = coords;
    }

    public int getPatches() {
        return patches;
    }

    public void setPatches(int patches) {
        this.patches = patches;
    }

    @Override
    public String toString()
    {
        return "HooverOnput [patches = "+patches+", coords = "+coords+"]";
    }
}
