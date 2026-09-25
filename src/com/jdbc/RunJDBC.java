import com.jdbc.JDBCExample;

class RunJDBC
{
    public static void main(String[] args)
    {
        JDBCExample jdbc = new JDBCExample();
        jdbc.connectDatabase();
        jdbc.readData();
        jdbc.addData();
        jdbc.updateData();
        jdbc.deleteData();
    }
}
