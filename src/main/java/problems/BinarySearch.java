package problems;

/**
 * @author VeselovND <br>
 * created at 07.06.2024 <br>
 * <a href="https://leetcode.com/problems/binary-search/description/">Binary search</a>
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        System.out.println(binarySearch(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }

    public static int binarySearch(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        //берем индексы начального массива (правый и левый) и начинаем уменьшать массив (по половинкам)
        while (left <= right) {
            int mid = left + (right - left) / 2; //находим середину массива
            if (nums[mid] == target) { //если попали в средний элемент, то элемент найден
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1; // сдвигаем левую границу на середину
            } else {
                right = mid - 1; //сдвигаем правую границу на середину
            }
        }
        //в самом последнем случае left==right==mid, и если этот последний элемент не равен таргету, значит этого поиск неуспешный
        return -1;
    }
}
