package FloydWarshallAlgoritmasi;
import java.util.Scanner;

public class App {
	protected static Scanner veriAl = new Scanner(System.in);

	public static int teslimatSayisiAl() {
		System.out.println("Teslimat Sayisini Giriniz:");
		int teslimatSayisi = 1;
		teslimatSayisi = veriAl.nextInt();
		if (teslimatSayisi >= 10) {
			System.out.println("Teslimat Sayisi 10 a esit ve 10 dan buyuk olamaz.");
			System.out.println("Teslimat Sayisini Yeniden Giriniz:");
			teslimatSayisi = veriAl.nextInt();
		}
		return teslimatSayisi;
	}

	public static int[] teslimatYerleriAl(int teslimatSayisi) {
		int[] teslimatYerleri = new int[teslimatSayisi];
		for (int i = 0; i < teslimatSayisi; i++) {
			System.out.printf("%d. teslimat yerinin plaka kodunu giriniz:", i + 1);
			teslimatYerleri[i] = (veriAl.nextInt() - 1);
		}
		return teslimatYerleri;
	}

	public static void rotaOlusturucu(int[] teslimatYerleri, int teslimatSayisi) {

		System.out.print("41,");
		int maliyet = 0;

		FloydWarshall.PrintRotate(40, teslimatYerleri[0]);
		maliyet += FloydWarshall.maliyet[40][teslimatYerleri[0]];
		System.out.print("->" + (teslimatYerleri[0] + 1) + ",");

		for (int i = 1; i < teslimatSayisi; i++) {
			FloydWarshall.PrintRotate(teslimatYerleri[i - 1], teslimatYerleri[i]);
			maliyet += FloydWarshall.maliyet[teslimatYerleri[i - 1]][teslimatYerleri[i]];
			System.out.print("->" + (teslimatYerleri[i] + 1) + ",");
		}

		System.out.println();
		System.out.println("-Dönüþ Yolu-");

		System.out.print((teslimatYerleri[teslimatSayisi - 1] + 1) + ",");
		FloydWarshall.PrintRotate(teslimatYerleri[teslimatSayisi - 1], 40);
		maliyet += FloydWarshall.maliyet[teslimatYerleri[teslimatSayisi - 1]][40];
		System.out.println("41");

		System.out.println("MALÝYET:" + maliyet + "km");
	}

	public static void main(String[] args) {
		FloydWarshall.FloydWarshall(Matris.matris);

		int ts = teslimatSayisiAl();
		int[] ty = teslimatYerleriAl(ts);

		System.out.println();
		System.out.println("EN KISA ROTA OLUÞTURULUYOR...");

		rotaOlusturucu(ty, ts);

		int bit = ty[ts - 1];
		
		int ks = Matris.komsuSayisi(bit);
		
		int[] komsular = Matris.hedefinKomsulari(bit, ks);
		int[] tyy = new int[ts + 1];

		int b = 0;
		while (b < ks) {
			if(b==4) {
				break;
			}
			for (int i = 0; i < ty.length; i++) {
				if (i == (ty.length) - 1) {
					tyy[i] = komsular[b];
				} else {
					tyy[i] = ty[i];
				}
			}
			tyy[ts] = ty[ts - 1];

			rotaOlusturucu(tyy, ts + 1);
			b++;
		}
	}

}