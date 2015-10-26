package com.example.app.java;

import java.util.List;

public class HanoiController {
    private final List<Tower> towers;
    private final int totalNumberOfDisks;
    private Disk lastDiskToMove = new Disk(-1);

    public HanoiController(List<Tower> towers, int totalNumberOfDisks) {
        this.towers = towers;
        this.totalNumberOfDisks = totalNumberOfDisks;
    }

    public List<Tower> move() {
        for (int towerIndex= 0; towerIndex<towers.size(); towerIndex++) {
            Tower towerToRemoveFrom = towers.get(towerIndex);
            Disk topDisk = towerToRemoveFrom.getTopDisk();
            if (diskWasSuccessfullyMoved(towerToRemoveFrom, topDisk, towerIndex)) break;
        }
        return towers;
    }


    private boolean diskWasSuccessfullyMoved(Tower towerToRemoveFrom, Disk topDisk, int towerIndex) {
        if (topDisk == lastDiskToMove || topDisk == Disk.EMPTY_DISK){
            return false;
        }
        int attempts = 0;
        while (attempts < towers.size()){
            attempts++;
            towerIndex = incrementTowerIndex(towerIndex);
            int nextTowerIndex = (towerIndex) % (towers.size());
            Tower tower = towers.get(nextTowerIndex);

            if (tower != towerToRemoveFrom && canDiskMoveToThisTower(tower, topDisk)) {
                towerToRemoveFrom.removeTopDisk();
                tower.addDiskToTop(topDisk);
                lastDiskToMove = topDisk;
                return true;
            }

        }
        return false;
    }

    private int incrementTowerIndex(int towerIndex) {
        if (totalNumberOfDisks % 2 ==0) {
            return towerIndex+1;
        }
        else{
            int newIndex = towerIndex-1;
            if (newIndex < 0) { newIndex += towers.size(); }
            return newIndex;
        }
    }


    private boolean canDiskMoveToThisTower(Tower tower, Disk topDisk) {
        List<Disk> disks = tower.getDisks();
        return disks.size() == 0 || topDisk.isDiskSmaller(disks.get(0));
    }
}
