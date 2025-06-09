package HelloWorld;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class dab {

    public static void main(String[] args) {
        // データベース接続情報（データベース名：test）
        String url = "jdbc:mysql://localhost:3306/test";
        String user = "root";                // DBユーザー名
        String password = "Hiro0113";        // DBパスワード

        Connection conn = null;

        try {
            // JDBCドライバの読み込み（MySQL用ドライバをロード）
            Class.forName("com.mysql.cj.jdbc.Driver");

            // データベースへ接続
            conn = DriverManager.getConnection(url, user, password);

            // 自動コミットを無効化（手動でcommitまたはrollbackを行うため）
            conn.setAutoCommit(false);

            // ---------------------
            // SQLの準備（1件のデータをusersテーブルに挿入）
            // ---------------------
            String sql = "INSERT INTO users_insert ("
            		+ "	name, "
            		+ "	email, "
            		+ "	created_at,"
            		+ "	status "
            		+ ") "
            		+ "SELECT "
            		+ "	name, "
            		+ "	email, "
            		+ "	created_at, "
            		+ "	status "
            		+ "FROM users";

            // SQL文の実行準備（プレースホルダに値を後から指定）
            PreparedStatement stmt = conn.prepareStatement(sql);

            // SQLを実行（データ挿入）
            stmt.executeUpdate();

            // 正常に完了したのでコミット
            conn.commit();

            // 結果の出力
            System.out.println("データを挿入しました");

        } catch (Exception e) {
            // エラー時はスタックトレース表示
            e.printStackTrace();
            try {
                if (conn != null) conn.rollback(); // エラー発生時はロールバック
            } catch (SQLException se) {
                se.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) conn.close(); // 接続を閉じる
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
    }
}
