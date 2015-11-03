
import com.example.app.java.Runner;
import com.example.app.java.Tower;
import org.junit.Test;

import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class RunnerTest {

    @Test
    public void shouldCreateGameBoard() throws Exception {
        Runner runner = new Runner();
        List<Tower> towers = runner.createStartTowersWith(4, 3);
        assertThat(new Printer().printDiskLocations(towers), is("T: ABCD, T2: 0 disks, T3: 0 disks"));

    }
}