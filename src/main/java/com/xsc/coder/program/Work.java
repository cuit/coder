package com.xsc.coder.program;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 题目描述
 * 为了找到自己满意的工作，牛牛收集了每种工作的难度和报酬。牛牛选工作的标准是在难度不超过自身能力值的情况下，牛牛选择报酬最高的工作。在牛牛选定了自己的工作后，牛牛的小伙伴们来找牛牛帮忙选工作，牛牛依然使用自己的标准来帮助小伙伴们。牛牛的小伙伴太多了，于是他只好把这个任务交给了你。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。
 * 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * 输出描述:
 * 对于每个小伙伴，在单独的一行输出一个正整数表示他能得到的最高报酬。一个工作可以被多个人选择。
 * 示例1
 * 输入
 * 3 3
 * 1 100
 * 10 1000
 * 1000000000 1001
 * 9 10 1000000000
 * 输出
 * 100
 * 1000
 * 1001
 *
 * @author xia
 * @date 2020/8/31 21:19
 */
public class Work {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            DifficultyAndReward[] difficultyAndRewards = new DifficultyAndReward[n];
            for (int i = 0; i < n; i++) {
                difficultyAndRewards[i] = new DifficultyAndReward(scanner.nextInt(), scanner.nextInt());
            }
            Arrays.sort(difficultyAndRewards, Comparator.comparing(DifficultyAndReward::getReward).reversed()
                    .thenComparing(DifficultyAndReward::getDifficulty));
            Person[] peoples = new Person[m];
            for (int i = 0; i < m; i++) {
                peoples[i] = new Person(i, scanner.nextInt());
            }
            Arrays.sort(peoples, Comparator.comparing(Person::getPower).reversed());
            int j = 0;
            for (Person people : peoples) {
                for (; j < difficultyAndRewards.length; j++) {
                    if (people.getPower() >= difficultyAndRewards[j].getDifficulty()) {
                        people.setReward(difficultyAndRewards[j].getReward());
                        break;
                    }
                }
            }
            Arrays.sort(peoples, Comparator.comparing(Person::getIndex));
            for (Person people : peoples) {
                System.out.println(people.getReward());
            }
        }
    }

    private static class DifficultyAndReward {

        private int difficulty;

        private int reward;

        public DifficultyAndReward(int difficulty, int reward) {
            this.difficulty = difficulty;
            this.reward = reward;
        }

        public int getDifficulty() {
            return difficulty;
        }

        public DifficultyAndReward setDifficulty(int difficulty) {
            this.difficulty = difficulty;
            return this;
        }

        public int getReward() {
            return reward;
        }

        public DifficultyAndReward setReward(int reward) {
            this.reward = reward;
            return this;
        }
    }

    private static class Person {

        private int index;

        private int power;

        private int reward;

        public Person(int index, int power) {
            this.index = index;
            this.power = power;
        }

        public int getIndex() {
            return index;
        }

        public Person setIndex(int index) {
            this.index = index;
            return this;
        }

        public int getPower() {
            return power;
        }

        public Person setPower(int power) {
            this.power = power;
            return this;
        }

        public int getReward() {
            return reward;
        }

        public Person setReward(int reward) {
            this.reward = reward;
            return this;
        }
    }

}
