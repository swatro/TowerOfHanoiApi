import com.example.app.java.Disk;
import com.example.app.java.Tower;

import java.util.List;

public class Printer {

    public String printDiskLocations(List<Tower> towersToPrint) {
        String output = "";
        int count = 1;
        for (Tower tower : towersToPrint){
            if (tower.getDisks().size()!=0){
                output += "T" + count + ": " + printDisks(tower) + ", ";
            }
            else {
                output += "T" + count + ": 0 disks, ";
            }
            count++;
        }
        String outputWithOutTrailingComma = output.substring(0, output.length() - 2);
        return outputWithOutTrailingComma;
    }

    private String printDisks(Tower tower) {
        String output = "";

        for (Disk disk : tower.getDisks()){
            output += disk.toString();
        }

        return output;
    }

}
