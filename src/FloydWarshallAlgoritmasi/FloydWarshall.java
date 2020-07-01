package FloydWarshallAlgoritmasi;
public class FloydWarshall {
	public static int N = 81;
	
	public static int[][] maliyet = new int[N][N];
	public static int[][] yol = new int[N][N];
	
	public static void FloydWarshall(int[][] matris) {
		
		for (int v = 0; v < N; v++) {
			for (int u = 0; u < N; u++) {

				maliyet[v][u] = matris[v][u];

				if (v == u)
					yol[v][u] = 0;
				else if (maliyet[v][u] != Integer.MAX_VALUE)
					yol[v][u] = v;
				else
					yol[v][u] = -1;
			}
		}
		
		for (int i = 0; i < N; i++) {
			for (int v = 0; v < N; v++) {
				for (int u = 0; u < N; u++) {
					if (maliyet[v][i] != Integer.MAX_VALUE && maliyet[i][u] != Integer.MAX_VALUE
							&& (maliyet[v][i] + maliyet[i][u] < maliyet[v][u])) {
						maliyet[v][u] = maliyet[v][i] + maliyet[i][u];
						yol[v][u] = yol[i][u];
					}
				}

				if (maliyet[v][v] < 0) {
					System.out.println("Negatif Döngü");
					
					break;
				}
			}
		}
	}
	static void PrintMatris(int mesafe[][], int V) {
		
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				if (mesafe[i][j] == Integer.MAX_VALUE)
					System.out.print("INF ");
				else
					System.out.printf("%10d", mesafe[i][j]);
			}
			System.out.println();
		}
	}
	public static void PrintRotate(int bas, int bit) {
		if (yol[bas][bit] == bas) {
			return;
		} else {
			PrintRotate(bas, yol[bas][bit]);
		}
		
		System.out.print((yol[bas][bit] + 1) + ",");
	}
	

	
}