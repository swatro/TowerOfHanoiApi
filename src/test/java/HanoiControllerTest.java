
import com.example.app.java.HanoiController;
import com.example.app.java.Runner;
import com.example.app.java.Tower;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class HanoiControllerTest {

    private List<Tower> startTowers;

    @Before
    public void setUp() throws Exception {
        Runner runner = new Runner();
        startTowers = runner.createStartTowersWith(4, 3);
    }

    @Test
    public void shouldMoveDiskAToSecondTowerOnFirstMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: BCD, T2: A, T3: 0 disks"));
    }

    @Test
    public void shouldMoveDiskAToThirdTowerOnFirstMoveWith3Disk() throws Exception {
        Runner runner = new Runner();
        List<Tower> startTowersWithThreeDisks = runner.createStartTowersWith(3, 3);
        HanoiController controller = new HanoiController(startTowersWithThreeDisks, 3);
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: BC, T2: 0 disks, T3: A"));
    }

    @Test
    public void shoudMoveDiskBToThirdTowerOnSecondMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: CD, T2: A, T3: B"));
    }

    @Test
    public void shouldMoveDiskAToThirdTowerOnThirdMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: CD, T2: 0 disks, T3: AB"));
    }

    @Test
    public void shouldMoveDiskCToSecondTowerOnFourthMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: D, T2: C, T3: AB"));
    }

    @Test
    public void shouldMoveDiskAToFirstTowerOnFifthMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: AD, T2: C, T3: B"));
    }

    @Test
    public void shouldMoveDiskBToSecondTowerOnSixthMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: AD, T2: BC, T3: 0 disks"));
    }

    @Test
    public void shouldMoveDiskAToSecondTowerOnSeventhMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: D, T2: ABC, T3: 0 disks"));
    }

    @Test
    public void shouldMoveDiskDToThirdTowerOnEightMoveMove() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        controller.move();
        List<Tower> towers = controller.move();
        assertThat(new Printer().printDiskLocations(towers), is("T1: 0 disks, T2: ABC, T3: D"));
    }

    @Test
    public void shouldFinishMovingAllDisksIn15Moves() throws Exception {
        HanoiController controller = new HanoiController(startTowers, 4);
        List<Tower> towers = new ArrayList();
        for (int i=1; i<=15; i++){
            towers = controller.move();
        }
        assertThat(new Printer().printDiskLocations(towers), is("T1: 0 disks, T2: 0 disks, T3: ABCD"));

    }
}
