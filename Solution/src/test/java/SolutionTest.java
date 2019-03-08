import org.junit.Test;
import java.util.List;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class SolutionTest {

    private Solution solution = new Solution();


    @Ignore
    @Test
    public void getRowReturnsPascalsTriangle(){

        List<Integer> actual = solution.getRow(2);
        assertThat(actual.size(), is(1));
        actual = solution.getRow(2);
        assertThat(actual.size(), is(3));
        actual = solution.getRow(4);
        assertThat(actual.get(2), is(6));
    }

}