package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * @author VeselovND <br>
 * created at 28.06.2024 <br>
 */
public class CourseSchedule {

    public static void main(String[] args) {
        int num = 20;
        int[][] courses = new int[][]{{0, 10}, {3, 18}, {5, 5}, {6, 11}, {11, 14}, {13, 1}, {15, 1}, {17, 4}};

        System.out.println(canFinish(num, courses));

    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        if (prerequisites == null || prerequisites.length == 0) {
            return true;
        }
        //находим вершины курсов (те, в которые не ведут никакие курсы), идем по массиву и плюсуем каждый раз, когда
        //видим что требуется курс для прохождения курса
        int[] edges = new int[numCourses];
        //Составляем мапу: Курс: Список курсов которым Требуется данный курс
        Map<Integer, List<Integer>> courseMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            edges[prerequisites[i][0]]++;
            if (!courseMap.containsKey(prerequisites[i][1])) {
                ArrayList<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                courseMap.put(prerequisites[i][1], list);
            } else {
                courseMap.get(prerequisites[i][1]).add(prerequisites[i][0]);//на выходе у нас мапа где {Ключ: List(Курсы, которым требуется Ключ)}
            }
        }

        //Добавляются в очередь вершины, в которые не требуется заходить (нули)
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (edges[i] == 0) {
                queue.add(i);
            }
        }
        //Далее мы берем каждую вершину (мы посетили курс)
        while (!queue.isEmpty()) {
            Integer top = queue.remove();
            //и для каждого курса, которому требуется чтобы этот курс был посещенным уменьшаем общее кол-во нга один (количество ребер)
            List<Integer> courses = courseMap.get(top);
            if (courses != null) {
                for (Integer cours : courses) { //
                    edges[cours]--;
                    if (edges[cours] == 0) { //проверяем если для указанной вершины все ребра посещены - то добавляем ее в очередь (считаем что курс пройден)
                        queue.add(cours);
                    }
                }
            }
        }
        for (int i : edges) {
            if (i != 0) return false;
        }
        return true;
    }


}
