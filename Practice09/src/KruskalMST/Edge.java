package KruskalMST;

public class Edge {
	int vertex, adjvertex; // ������ �糡 ������
	int weight;            // ������ ����ġ
	public Edge(int u, int v, int wt) {
		vertex    = u;
		adjvertex = v;
		weight    = wt;
	}
}
