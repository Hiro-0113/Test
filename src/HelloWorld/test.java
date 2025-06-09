package HelloWorld;

public class test {
	
	// フィールド定義
	public String Name = "あなたは：";
	private static int num1 = 1;
	private static int num2 = 5;
	
	public String show() {
		return Name;
	}
	
	public static int test1(int age) {
		try {
			if (age == 0) {
				int sum = num1 + num2;
				System.out.println("計算結果: " + sum);
			} else if (age == 1) {
				int kake = num1 * num2;
				System.out.println("計算結果: " + kake);
			} else {
				System.out.println("対象外の数値を選択しました。");
			}
			return age;
		} catch(Exception e) {
			System.out.println("エラーが発生しました: " + e.getMessage());
			return -1;
		}
	}
	
	public static int test2(int age) {
		
		switch (age) {
			case 1:
				System.out.println("１を選択されました。");
				return 1;
			case 2:
				System.out.println("2を選択されました。");
				return 2;
			case 3:
				System.out.println("3を選択されました。");
				return 3;
			default:
				System.out.println("正しい数値を入力してください。");
				return 0;
		}
	}
}
