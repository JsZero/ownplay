package cn.neu;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MedianInStream {

    private int count = 0;
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);

    public static void main(String[] args) {
        MedianInStream medianInStream = new MedianInStream();
        Scanner scanner = new Scanner(System.in);
        boolean flag = true;
        while (flag) {
            System.out.print("[input]: ");
            String str = scanner.next();
            if (str.equals("exit"))
                flag = false;
            else {
                try {
                    medianInStream.insert(Integer.parseInt(str));
                } catch (Exception e) {
                    System.out.println("[Warning]: 输入错误，重新输入");
                    continue;
                }
                System.out.println("[current median]: " + medianInStream.getMedian());
            }

        }
    }

    private void insert(int num) {
        if ((count & 1) == 0) {
            maxHeap.offer(num);
            int maxValOfMaxHeap = maxHeap.poll();
            minHeap.offer(maxValOfMaxHeap);
        } else {
            minHeap.offer(num);
            int minValOfMinHeap = minHeap.poll();
            maxHeap.offer(minValOfMinHeap);
        }
        count++;
    }

    private Double getMedian() {
        return (count & 1) == 0 ? ((maxHeap.peek() + minHeap.peek()) / 2.0) : Double.valueOf(minHeap.peek());
    }
}
