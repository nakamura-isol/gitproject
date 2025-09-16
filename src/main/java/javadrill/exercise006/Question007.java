package javadrill.exercise006;

public class Question007 {

	public static void main(String[] args) {
		for(int i=5;i>= 1;i--) {
			// 外側のループ変数 i が その行で出力すべき「*」の数 を表す
			// 内側のループ変数 j は、実際に何回 "*" を出力したかをカウントする
			for(int j =1;j <= i;j++) {
				 System.out.print("*");
			}
			System.out.println();
		}

	}

}
