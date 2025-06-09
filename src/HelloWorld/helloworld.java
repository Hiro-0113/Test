package HelloWorld;

import java.util.Scanner;

public class helloworld {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        test t = new test();

        System.out.println("数値を入力してください。");
        int number = scanner.nextInt();
        int result = test.test1(number);

        if (result == 0 || result == 1) {
            System.out.println("---- " + t.show() + "正しい数値を選択しました ----");
        } else {
            System.out.println("---- " + t.show() + "エラー：無効な数値です ----");
        }

        System.out.println("数値を入力してください。");
        int number1 = scanner.nextInt();
        int c = test.test2(number1);

        // ↓ ここで dabクラスのSQLを実行して検証！
        System.out.println("DBへ接続し、データをINSERTします。");
        dab.main(null); // ← これでdabのmain()を呼び出せる

        scanner.close();
    }
}
