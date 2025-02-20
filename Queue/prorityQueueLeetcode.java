package Queue;
import java.util.*;

public class prorityQueueLeetcode {
    
    // Leetcode Problem No : 1046. Last Stone Weight

    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < stones.length; i++) {
            pq.add(stones[i]);
        }


        while (!pq.isEmpty()) {
           
            int x = pq.poll();
            int y = 0;
            if (!pq.isEmpty()) {
                y=pq.poll();
            }else{
                return x;
            }

            pq.add(Math.abs(x-y));

        }
        return 0;
    }

    // Leetcode Problem No 347. Top K Frequent Elements

    class Number implements Comparable<Number> {
        int num;
        int frequency;
        
        Number(int num, int frequency) {
            this.num = num;
            this.frequency = frequency;
        }
       
        @Override
        public int compareTo(Number other) {
            return Integer.compare(other.frequency, this.frequency); 
        }
    }

    public int[] topKFrequent(int[] nums, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < nums.length; i++) {
            pq.add(nums[i]);
        }

        PriorityQueue<Number> f = new PriorityQueue<>();

        do {
            int frequency = 1;
            int element=pq.poll();

            while (!pq.isEmpty() && pq.peek()==element) {
                pq.poll();
                frequency++;
            }
            f.add(new Number(element, frequency));
        } while (!pq.isEmpty());
        
        int []arr = new int[k];

        for (int i = 0; i < arr.length; i++) {
            arr[i]=f.poll().num;
        }
        return arr;
    }

}
