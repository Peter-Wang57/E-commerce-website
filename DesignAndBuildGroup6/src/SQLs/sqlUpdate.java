package SQLs;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class sqlUpdate {
    public static void universalUpdate(String sql, Object... args) {
        Connection conn = null;
        PreparedStatement ps = null;
        try {
            //1获取连接
            conn = utils.JDBCUtils.getConnection();
            //2预编译
            ps = conn.prepareStatement(sql);
            //3填充占位符
            for (int i = 0; i < args.length; i++) {
                ps.setObject(i + 1, args[i]);
            }
            //4执行
            ps.execute();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //5关闭资源
            utils.JDBCUtils.closeResource(conn, ps);
        }
    }
}
