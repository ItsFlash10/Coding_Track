package Day6;

//1217. Minimum Cost to Move Chips to The Same Position
//https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/

class Soluchip {
    public int minCostToMoveChips(int[] position) {
        int odd_numbers = 0, even_numbers = 0;
        for (int num: position)
        {
            if (num % 2 == 0)
                ++even_numbers;
            else
                ++odd_numbers;
        }
            
        return Math.min(odd_numbers, even_numbers);
    }
}
