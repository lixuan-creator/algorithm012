package com.algorithm.week04;

/**
 * 贪心算法
 * 柠檬水找零
 */

public class LemonadeChange {

    public boolean solution(int[] bills) {

        int five = 0, ten = 0;
        // 付5块钱，直接收
        // 付10块钱，找5块钱
        // 付20块钱，找5块+10块或者3个5块
        for (int bill : bills) {
            if (bill == 5) {
                five ++;
            } else if (bill == 10) {
                if (five == 0) return false;
                five--;
                ten++;
            } else if (bill == 20) {
                if (five > 0 && ten >0) {
                    ten--;
                    five--;
                } else if (five >= 3) {
                    five -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
