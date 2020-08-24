package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/4 22:55
 */
public class Test9 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int r = scanner.nextInt();
            int avg = scanner.nextInt();
            int nowScore = 0;
            ScoreTime[] scoreTimes = new ScoreTime[n];
            for (int i = 0; i < n; i++) {
                ScoreTime scoreTime = new ScoreTime();
                // 当前课的成绩
                scoreTime.score = scanner.nextInt();
                // 每多拿一分所花的时间
                scoreTime.time = scanner.nextLong();
                scoreTimes[i] = scoreTime;
                nowScore += scoreTime.score;
            }
            // 所需达到的总分
            int expectScore = avg * n;
            if (nowScore >= expectScore) {
                System.out.println(0);
            } else {
                int needScore = expectScore - nowScore;
                long result = process(scoreTimes, needScore, r);
                System.out.println(result);
            }
        }
    }

    private static long process(ScoreTime[] scoreTimes, int needScore, int r) {
        long result = 0;
        Arrays.sort(scoreTimes, (o1, o2) -> (int) (o1.time - o2.time));
        for (ScoreTime scoreTime : scoreTimes) {
            if (scoreTime.score >= r) {
                continue;
            }
            if (r - scoreTime.score >= needScore) {
                result += scoreTime.time * needScore;
                break;
            } else {
                result += scoreTime.time * (r - scoreTime.score);
                needScore -= r - scoreTime.score;
            }
        }
        return result;
    }

    private static class ScoreTime {

        private int score;

        private long time;

    }

}
