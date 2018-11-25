package dp_basic;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 참고 : http://rainmaker0303.blogspot.com/2018/01/1005-acm-craft-java.html
// http://mygumi.tistory.com/178
// 위상정렬?

public class Num1005
{
    private static int D[] = null;
    private static int cache[] = null;
    private static List<BuildingOrder> list;

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int W;

        BuildingOrder buildingOrder = null;
        for (int i = 0 ; i < T ; i++)
        {
            // 건물 및 순서 갯수
            int N = sc.nextInt();
            int K = sc.nextInt();

            // 건설에 걸리는 시간 D
            D = new int[N];
            for (int j = 0 ; j < N ; j++)
            {
                D[j] = sc.nextInt();
            }

            // 건설순서 X Y
            list = new ArrayList<BuildingOrder>();
            for (int z = 0 ; z < K ; z++)
            {
                buildingOrder = new BuildingOrder(sc.nextInt(), sc.nextInt());
                list.add(buildingOrder);
            }

            W = sc.nextInt();
            cache = new int[N];

            System.out.println(solve(W, D, list, cache));
        }
    }

    public static int solve(int W, int D[], List<BuildingOrder> list, int cache[])
    {
        // 기저사례
        if (cache[W-1] != 0)
        {
            return cache[W-1];
        }
        cache[W-1] = D[W-1];

        // 재귀
        for (BuildingOrder buildingOrder : list)
        {
            int time = D[W-1];
            if (W == buildingOrder.Y)
            {
                time += solve(buildingOrder.X, D, list, cache);
                cache[W-1] = Math.max(time, cache[W-1]);
            }
        }
        return cache[W-1];
    }
}

class BuildingOrder
{
    int X;
    int Y;

    public BuildingOrder(int x, int y)
    {
        X = x;
        Y = y;
    }
}