package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;

/**
 * @author xia
 * @date 2020/8/2 22:23
 */
public class Test7 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] likes = new int[n];
        for (int i = 0; i < n; i++) {
            likes[i] = scanner.nextInt();
        }
        int q = scanner.nextInt();
        Map<Integer, List<User>> userMap = new HashMap<>();
        Map<User, Integer> map = new HashMap<>();
        for (int i = 0; i < q; i++) {
            User user = new User(scanner.nextInt(), scanner.nextInt(), scanner.nextInt(), i);
            if (userMap.containsKey(user.k)) {
                List<User> users = userMap.get(user.k);
                users.add(user);
            } else {
                List<User> users = new ArrayList<>();
                users.add(user);
                userMap.put(user.k, users);
            }
            map.put(user, 0);
        }
        Map<User, Integer> result = process(likes, userMap, map);
        result.entrySet().stream()
                .sorted(Comparator.comparing(x -> x.getKey().order))
                .map(Map.Entry::getValue)
                .forEach(System.out::println);
    }

    /**
     * 便利整个文章喜好度范围，记录哪些用户查询的范围区间在里面，且符合查询的值
     *
     * @param likes   整个文章喜好度范围
     * @param userMap 需要查询的喜好度的关联的用户查询范围map字典
     * @param map     用户查询范围以及命中次数字典
     * @return map
     */
    private static Map<User, Integer> process(int[] likes, Map<Integer, List<User>> userMap, Map<User, Integer> map) {
        for (int i = 0; i < likes.length; i++) {
            if (!userMap.containsKey(likes[i])) {
                continue;
            }
            List<User> users = userMap.get(likes[i]);
            for (User user : users) {
                if (i >= user.l - 1 && i <= user.r - 1) {
                    map.put(user, map.get(user) + 1);
                }
            }
        }
        return map;
    }

    private static class User {
        private int l;

        private int r;

        private int k;

        private int order;

        public User(int l, int r, int k, int order) {
            this.l = l;
            this.r = r;
            this.k = k;
            this.order = order;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            User user = (User) o;
            return l == user.l &&
                    r == user.r &&
                    k == user.k &&
                    order == user.order;
        }

        @Override
        public int hashCode() {
            return Objects.hash(l, r, k, order);
        }
    }
}
