package com.yoti.robotichoover;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Component
public class RoboticHooverService {

    public HooverOutput hoover(HooverInput hooverInput){
        String[] instructions = hooverInput.getInstructions().split("");
        List<Integer> coords = hooverInput.getCoords();
        List<Integer> roomSize = hooverInput.getRoomSize();
        List<List<Integer>> patches = hooverInput.getPatches();
        List<String> instructionList = Arrays.asList(instructions);
        int numberOfPatchCleared = 0;
        boolean patchFound = false;
        for(int i=0; i<instructionList.size(); i++){
            coords = updateCoords(coords,instructionList.get(i),roomSize);
            for (List patch : patches) {
                if(patch.equals(coords)){
                    patchFound = true;
                    numberOfPatchCleared++;
                }
            }
            if(patchFound)
                patches.remove(coords);
        }
        HooverOutput hooverOutput = new HooverOutput(coords,numberOfPatchCleared);
        return hooverOutput;
    }

    private List<Integer> updateCoords(List<Integer> coords, String direction, List<Integer> roomSize){
        if(direction.equals("N")){
            //Y value of roomsize(5) on North considered as wall so do nothing else move
            if((coords.get(1) + 1) < roomSize.get(1)){
                coords.set(1,coords.get(1) + 1);
            }
        }
        else if(direction.equals("S")) {
            //Y value of 0 on South considered as wall so do nothing else move
            if ((coords.get(1) - 1) > 0) {
                coords.set(1, coords.get(1) - 1);
            }
        }
        else if(direction.equals("E")) {
            //X value of roomsize(5) on East considered as wall so do nothing else move
            if ((coords.get(0) + 1) < roomSize.get(0)) {
                coords.set(0, coords.get(0) + 1);
            }
        }
        else if(direction.equals("W")){
            //X value of 0 on West considered as wall so do nothing else move
            if((coords.get(0) - 1) > 0){
                coords.set(0,coords.get(0) - 1);
            }
        }
        return coords;
    }
}

