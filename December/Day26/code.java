package Day25;
import java.util.*;

//973. K Closest Points to Origin
//https://leetcode.com/problems/k-closest-points-to-origin/

class kClsPtOr {
    public int[][] kClosest(int[][] points, int K) {
        int i = 0, j = points.length - 1;
        while(i < j) {
            int mid = partition(points, i, j);
            if(mid == K) break;
            if(mid < K) {
                i = mid + 1;
            } else {
                j = mid - 1;
            }
        }
        return Arrays.copyOf(points, K);
    }
    
    private int partition(int[][] points, int start, int end) {
        int[] pivot = points[end];
        int swapIndex = start - 1;
        for(int i = start; i < end; i++) {
            if(value(points[i]) < value(pivot)) {
                swapIndex++;
                swap(points, swapIndex, i);
            }
        }
        swap(points, ++swapIndex, end);
        return swapIndex;
    }
    
    private int value(int[] a) {
        return a[0] * a[0] + a[1] * a[1];
    }
    
    private void swap(int[][] points, int i, int j) {
        int[] temp = points[i];
        points[i] = points[j];
        points[j] = temp;
    }
}
