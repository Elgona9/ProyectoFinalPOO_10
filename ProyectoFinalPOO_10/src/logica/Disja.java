package logica;

public class Disja {
    public int distance[] = new int[10];
    public int parent[] = new int[10];
    public int[][] cost = {
        {0, 70, 150, 999, 999, 999},
        {70, 0, 156, 65, 999, 999},
        {150, 156, 0, 134, 94, 999},
        {999, 65, 134, 0, 160, 61},
        {999, 999, 94, 160, 0, 999},
        {999, 999, 999, 61, 999, 0}
    };

    public void calc(int n, int s) {
        int flag[] = new int[n + 1];
        int i, minpos = 1, k, c, minimum;

        for (i = 1; i <= n; i++) {
            flag[i] = 0;
            this.distance[i] = this.cost[s][i];
            this.parent[i] = s;
        }
        c = 2;
        while (c <= n) {
            minimum = 999; 
            for (k = 1; k <= n; k++) {
                if (this.distance[k] < minimum && flag[k] != 1) {
                    minimum = this.distance[k];
                    minpos = k;
                }
            }
            flag[minpos] = 1;
            c++;
            for (k = 1; k <= n; k++) {
                if (this.distance[minpos] + this.cost[minpos][k] < this.distance[k] && flag[k] != 1) {
                    this.distance[k] = this.distance[minpos] + this.cost[minpos][k];
                    this.parent[k] = minpos;
                }
            }
        }
    }
}