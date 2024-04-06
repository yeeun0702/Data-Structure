package KruskalMST;
public class UnionFind {  
	protected  int[] p;    // �迭ũ��� ������ �� N�̰� p[i]�� i�� �θ� ���Ҹ� �����Ѵ�. 
	protected  int[] rank; 
	
	public UnionFind(int N) {
		p = new int[N];
		rank = new int[N];
		for (int i = 0; i < N; i++) {
			p[i]    = i;  // �ʱ⿣ N���� Ʈ���� ���� i �ڱ� �ڽ��� �θ��̱� ������ 
			rank[i] = 0;  // �ʱ⿣ N���� Ʈ�� ������ rank�� 0���� �ʱ�ȭ 
		}
	}
	//i�� ���� ������ ��Ʈ��带 ��������� ã�� ���������� ��λ��� �� ������ �θ� ��Ʈ���� �����.
	protected int find(int i) { // ��� ����
		if ( i != p[i])   
			p[i] = find(p[i]);  //�����ϸ� ��λ��� �� ����� �θ� ��Ʈ���ǵ��� �����.
		return p[i];
	}
	//i�� j�� ���� Ʈ���� �ִ����� �˻�
	public boolean isConnected(int i, int j) {
		return find(i) == find(j); 
	}
	public void union(int i, int j) {  // Union ����
		int iroot = find(i);
		int jroot = find(j);
		if (iroot == jroot) return;  // ��Ʈ��尡 �����ϸ� ���̻��� ������� �״�� ����
		// rank�� ���� ��Ʈ��尡 ���ڷ� union�� �����Ѵ�.
		if (rank[iroot] > rank[jroot]) 
			p[jroot] = iroot;               // iroot�� ����
		else if (rank[iroot] < rank[jroot]) 
			p[iroot] = jroot;               // jroot�� ����
		else {
			p[jroot] = iroot;  // ���߿� �ϳ� ���Ƿ� ����
			rank[iroot]++;     // iroot�� rank 1 ����
		}
	}
}
