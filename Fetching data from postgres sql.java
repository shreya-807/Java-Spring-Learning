import  java.sql.*;
public class Demojdbc {
    public Demojdbc() throws Exception {
    }

    public static void main(String[] args) throws Exception{
    /*{
    import package;
    load driver;
    register driver;
    create connection;
    create statement;
    execute statement;
    close;
    */
    String url="jdbc:postgresql://.....:......./.......";
    String username="postgres";
    String password="###";
    String sql="SELECT * FROM student";

    Class.forName("org.postgresql.Driver");
    Connection con = DriverManager.getConnection(url, username, password);
        System.out.println("Database establisted successfully");
        Statement st= con.createStatement();
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            System.out.print(rs.getInt("id")+ " : "+ rs.getString("name")+" : "+ rs.getInt("age"));
            System.out.println();
        }
         sql= "SELECT name FROM student where id=1";
        rs = st.executeQuery(sql);
        System.out.println(rs.next());
        String result = rs.getString("name");
         System.out.println("Name of the student is "+ result);
        con.close();
        System.out.println("connection close");
}

}
