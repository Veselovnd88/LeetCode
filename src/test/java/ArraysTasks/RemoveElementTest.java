package ArraysTasks;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * @author VeselovND
 * created at 29.05.2024
 */
class RemoveElementTest {

    @Test
    void removeElement_1() {
        int[] arr = new int[]{0, 1, 2, 2, 3, 0, 4, 2};
        Assertions.assertEquals(5, RemoveElement.removeElement(arr, 2));
    }

    @Test
    void removeElement_2() {
        int[] arr = new int[]{3, 2, 2, 3};
        Assertions.assertEquals(2, RemoveElement.removeElement(arr, 3));
    }

    @Test
    void removeElement_3() {
        int[] arr = new int[]{1};
        Assertions.assertEquals(0, RemoveElement.removeElement(arr, 1));
    }

    @Test
    void removeElement_4() {
        int[] arr = new int[]{};
        Assertions.assertEquals(0, RemoveElement.removeElement(arr, 1));
    }

    @Test
    void removeElement_5() {
        int[] arr = new int[]{1, 1};
        Assertions.assertEquals(0, RemoveElement.removeElement(arr, 1));
    }

    @Test
    void removeElement_6() {
        int[] arr = new int[]{4, 5};
        Assertions.assertEquals(1, RemoveElement.removeElement(arr, 5));
    }

    @Test
    void removeElement_7() {
        int[] arr = new int[]{2};
        Assertions.assertEquals(1, RemoveElement.removeElement(arr, 3));
    }

    @Test
    void removeElement_8() {
        int[] arr = new int[]{3, 3};
        Assertions.assertEquals(2, RemoveElement.removeElement(arr, 5));
    }


}