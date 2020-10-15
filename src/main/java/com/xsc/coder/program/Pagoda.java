package com.xsc.coder.program;

/**
 * 小易有一些立方体，每个立方体的边长为1，他用这些立方体搭了一些塔。
 * 现在小易定义：这些塔的不稳定值为它们之中最高的塔与最低的塔的高度差。
 * 小易想让这些塔尽量稳定，所以他进行了如下操作：每次从某座塔上取下一块立方体，并把它放到另一座塔上。
 * 注意，小易不会把立方体放到它原本的那座塔上，因为他认为这样毫无意义。
 * 现在小易想要知道，他进行了不超过k次操作之后，不稳定值最小是多少。
 * 输入描述:
 * 第一行两个数n,k (1 <= n <= 100, 0 <= k <= 1000)表示塔的数量以及最多操作的次数。
 * 第二行n个数，ai(1 <= ai <= 104)表示第i座塔的初始高度。
 * 输出描述:
 * 第一行两个数s, m，表示最小的不稳定值和操作次数(m <= k)
 * 接下来m行，每行两个数x,y表示从第x座塔上取下一块立方体放到第y座塔上。
 * 示例1
 * 输入
 * 3 2
 * 5 8 5
 * 输出
 * 0 2
 * 2 1
 * 2 3
 *
 * @author xia
 * @date 2020/9/26 19:21
 */
public class Pagoda {

//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        while (scanner.hasNext()) {
//            int n = scanner.nextInt();
//            int k = scanner.nextInt();
//            int[] tower = new int[n];
//            int index = 0;
//            int tmp = 0;
//            for (int i = 0; i < n; i++) {
//                tower[i] = scanner.nextInt();
//                if (tower[i] > tmp) {
//                    tmp = tower[i];
//                    index = i;
//                }
//            }
//            if (index == 0) {
//                System.out.println("0 0");
//            } else {
//
//            }
//        }
//    }


}
