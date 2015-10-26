package com.example.app.java;


import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Runner {

    public String getResponse(int numberOfDisks){

        int stepToTheSolution = (int)(Math.pow(2,numberOfDisks))-1;
        List<Tower> towers = createStartTowersWith(numberOfDisks, 3);
        HanoiController hanoiController = new HanoiController(towers, numberOfDisks);

        String output = "";
        ObjectMapper mapper = new ObjectMapper();
        for (int i = 0; i <= stepToTheSolution; i++) {
            Game game = new Game(towers.get(0), towers.get(1), towers.get(2));
            try {
                output +=  mapper.writeValueAsString(game) + ", ";
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }

            towers = hanoiController.move();
        }
        output = "[" + output.substring(0,output.length()-2) + "]";
        return output;

    }

    public List<Tower> createStartTowersWith(int numberOfDisks, int numberOfTowers) {
        List<Tower> towers = new ArrayList();
        towers.add(createFirstTower(numberOfDisks));
        for (int tower = 0; tower< numberOfTowers-1; tower++){
            towers.add(new Tower(new ArrayList()));
        }
        return towers;
    }

    private Tower createFirstTower(int numberOfDisks) {
        List<Disk> disks = new ArrayList();
        for (int diskSize =0; diskSize< numberOfDisks; diskSize++){
            disks.add(new Disk(diskSize));
        }
        return new Tower(disks);
    }
}
