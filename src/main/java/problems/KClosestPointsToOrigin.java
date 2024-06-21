package problems;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author VeselovND <br>
 * created at 21.06.2024 <br>
 *
 * <a href="https://leetcode.com/problems/k-closest-points-to-origin/description/">K Closest Points To Origin</a>
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        int[][] points = new int[][]{{1, 3}, {-2, 2}};
        int k = 1;
        System.out.println(Arrays.deepToString(kClosest(points, k)));
    }

    public static int[][] kClosest(int[][] points, int k) {
        //Макс хип в коротой будут храниться точки, приоритет каждой вершины больше чем приоритет ее потомков, определяется
        // отдельный компаратор
        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> Integer.compare(b[0], a[0]));

        for (int[] point : points) {
            int distance = point[0] * point[0] + point[1] * point[1]; //определение расстояния
            heap.offer(new int[]{distance, point[0], point[1]});
            if (heap.size() > k) {
                //т.к. нам необходимо держать определенное количество элементов, мы просто убираем из очереди
                heap.poll();  // Keep the size of the heap at most k
            }
        }
        //просто достаем из очереди оставшиеся k результатов и возврашаем(т.к. порядок не важен по условию задачи)
        int[][] result = new int[k][2];
        for (int i = 0; i < k; i++) {
            int[] poll = heap.poll();
            assert poll != null;
            int[] point = new int[]{poll[1], poll[2]};
            result[i] = point;
        }
        return result;
    }
}
