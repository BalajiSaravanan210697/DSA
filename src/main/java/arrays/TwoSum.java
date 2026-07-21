import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TwoSum {

    public int[] twoSumBF(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
    
    @Test
    void shouldReturnIndicesWhenPairExists() {
        assertArrayEquals(new int[]{0, 1}, twoSumBF(new int[]{2, 7, 9, 12}, 9));
    }

    @Test
    void shouldReturnEmptyWhenNoPairExists() {
        assertArrayEquals(new int[]{}, twoSumBF(new int[]{1, 2, 3}, 10));
    }

}
 