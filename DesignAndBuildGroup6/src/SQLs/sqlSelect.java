package SQLs;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;

public class sqlSelect {
    public static <T> T getInstance(Class<T> clazz,String sql,Object...args){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            conn= utils.JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取结果集的元数据，通过它获取列数
            int columnCount =rsmd.getColumnCount();

            if(rs.next()){
                T newInstance=clazz.newInstance();
                for (int i=0;i<columnCount;i++) {

                    Object columnValue=rs.getObject(i+1);
                    //给customer指定属性(columnName)赋值为value
                    String columnName=rsmd.getColumnLabel(i+1);
                    Field field=clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(newInstance,columnValue);
                }
                return newInstance;
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }

    public static <T> List<T> getInstances(Class<T> clazz, String sql, Object...args){
        Connection conn=null;
        PreparedStatement ps =null;
        ResultSet rs=null;
        try {
            conn= utils.JDBCUtils.getConnection();
            ps=conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++){
                ps.setObject(i+1,args[i]);
            }
            rs=ps.executeQuery();
            ResultSetMetaData rsmd=rs.getMetaData();
            //获取结果集的元数据，通过它获取列数
            int columnCount =rsmd.getColumnCount();
            //创建集合对象
            ArrayList<T> list=new ArrayList<T>();

            while(rs.next()){
                T newInstance=clazz.newInstance();
                for (int i=0;i<columnCount;i++) {

                    Object columnValue=rs.getObject(i+1);
                    //给customer指定属性(columnName)赋值为value
                    String columnName=rsmd.getColumnLabel(i+1);
                    Field field=clazz.getDeclaredField(columnName);
                    field.setAccessible(true);
                    field.set(newInstance,columnValue);
                }
                list.add(newInstance);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            utils.JDBCUtils.closeResource(conn,ps,rs);
        }
        return null;
    }
}
