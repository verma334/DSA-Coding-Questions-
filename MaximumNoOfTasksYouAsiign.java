package ArrayAndStringsDSAQuestions;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.TreeMap;

public class MaximumNoOfTasksYouAsiign {

	
	public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);

        int left = 0, right = Math.min(tasks.length, workers.length);
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (canAssign(mid, tasks, workers, pills, strength)) {
                result = mid;
                left = mid + 1; // try to assign more
            } else {
                right = mid - 1; // try fewer
            }
        }

        return result;
    }

    private boolean canAssign(int count, int[] tasks, int[] workers, int pills, int strength) {
        Deque<Integer> taskDeque = new ArrayDeque<>();
        for (int i = count - 1; i >= 0; i--) {
            taskDeque.addLast(tasks[i]);
        }

        TreeMap<Integer, Integer> workerMap = new TreeMap<>();
        for (int i = workers.length - count; i < workers.length; i++) {
            workerMap.put(workers[i], workerMap.getOrDefault(workers[i], 0) + 1);
        }

        int pillsLeft = pills;

        while (!taskDeque.isEmpty()) {
            int task = taskDeque.pollFirst();

            // Try to assign without pill
            Integer worker = workerMap.ceilingKey(task);
            if (worker != null) {
                removeWorker(workerMap, worker);
                continue;
            }

            // Try to assign with pill
            if (pillsLeft == 0) return false;

            worker = workerMap.ceilingKey(task - strength);
            if (worker == null) return false;

            removeWorker(workerMap, worker);
            pillsLeft--;
        }

        return true;
    }

    private void removeWorker(TreeMap<Integer, Integer> map, int key) {
        if (map.get(key) == 1) {
            map.remove(key);
        } else {
            map.put(key, map.get(key) - 1);
        }
    }

    public static void main(String[] args) {
    	MaximumNoOfTasksYouAsiign sol = new MaximumNoOfTasksYouAsiign();
        System.out.println(sol.maxTaskAssign(new int[]{3,2,1}, new int[]{0,3,3}, 1, 1)); // Output: 3
        System.out.println(sol.maxTaskAssign(new int[]{5,4}, new int[]{0,0,0}, 1, 5));   // Output: 1
        System.out.println(sol.maxTaskAssign(new int[]{10,15,30}, new int[]{0,10,10,10,10}, 3, 10)); // Output: 2
    }

}
