package com.xsc.coder.program;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * @author xia
 * @date 2020/7/31 21:31
 */
public class Test4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        Map<Integer, List<Pos>> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            int len = scanner.nextInt();
            if (len == 0) {
                continue;
            }
            List<Pos> list = new ArrayList<>(len);
            for (int j = 0; j < len; j++) {
                int x = scanner.nextInt();
                int y = scanner.nextInt();
                list.add(new Pos(x, y));
            }
            map.put(i, list);
        }
        int result = process(map);
        System.out.println(result);
    }

    private static int process(Map<Integer, List<Pos>> map) {
        Map<Integer, List<List<Pos>>> group = group(map);
        int result = 1;
        for (List<List<Pos>> lists : group.values()) {
            if (lists.size() == 1) {
                continue;
            }
            result = Math.max(result, calc(lists));
        }
        return result;
    }

    private static int calc(List<List<Pos>> lists) {
        // 获取所有特征
        List<Pos> pos = lists.stream().flatMap(Collection::stream).distinct().collect(Collectors.toList());
        Map<Pos, Integer> posIntegerMap = new HashMap<>();
        for (Pos p : pos) {
            Map<Integer, Integer> countMap = new HashMap<>();
            for (int i = 0; i < lists.size(); i++) {
                if (!lists.get(i).contains(p)) {
                    continue;
                }
                if (i == 0) {
                    countMap.put(0, 1);
                } else {
                    Integer before = countMap.get(i - 1) == null ? 0 : countMap.get(i - 1);
                    countMap.remove(i - 1);
                    countMap.put(i, before + 1);
                }
            }
            posIntegerMap.put(p, countMap.values().stream().max(Comparator.comparing(Integer::intValue)).orElse(1));
        }
        return posIntegerMap.values().stream().max(Comparator.comparing(Integer::intValue)).orElse(1);
    }

    private static Map<Integer, List<List<Pos>>> group(Map<Integer, List<Pos>> map) {
        Map<Integer, List<List<Pos>>> listMap = new HashMap<>();
        for (Map.Entry<Integer, List<Pos>> entry : map.entrySet()) {
            if (entry.getKey() == 0) {
                List<List<Pos>> lists = new ArrayList<>();
                lists.add(entry.getValue());
                listMap.put(entry.getKey(), lists);
            } else {
                if (listMap.containsKey(entry.getKey() - 1)) {
                    List<List<Pos>> lists = listMap.get(entry.getKey() - 1);
                    lists.add(entry.getValue());
                    listMap.remove(entry.getKey() - 1);
                    listMap.put(entry.getKey(), lists);
                } else {
                    List<List<Pos>> lists = new ArrayList<>();
                    lists.add(entry.getValue());
                    listMap.put(entry.getKey(), lists);
                }
            }
        }
        return listMap;
    }

    private static class Pos {

        int x;

        int y;

        public Pos(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pos pos = (Pos) o;
            return x == pos.x &&
                    y == pos.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
