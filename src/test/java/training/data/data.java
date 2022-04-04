package training.data;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class data {

    private static int Recnum = 1;

    public ResultSet ConnectAndQuerySQL(String sDBURL, String sUserName, String sPassword, String sQuery) {

        ResultSet rs = null;
        try {

            String dbURL = sDBURL;
            String user = sUserName;
            String pass = sPassword;
            java.sql.Connection conn = DriverManager.getConnection(dbURL, user, pass);
            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            rs = stmt.executeQuery(sQuery);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return rs;
    }

    public int rowCount(ResultSet resultset) throws Exception {
        int count = 0;
        try {
            resultset.last();
            count = resultset.getRow();
            resultset.beforeFirst();
        } catch (Exception e) {

        }
        return count;
    }

    public static String getCellData(String strColumn, int iRow, ResultSet resultset, String Type) throws Exception {
        String sValue = null;


//            case "Excel":
//                if (iRow == Recnum) {
//                    if (record.next()) {
//                        Recnum = iRow + 1;
//                        sValue = record.getField(strColumn);
//                    }
//                } else {
//                    sValue = record.getField(strColumn);
//                }
//                break;
        try {

            if (iRow == Recnum) {
                if (resultset.next()) {
                    Recnum = iRow + 1;
                    sValue = resultset.getString(strColumn);
                }
            } else {
                sValue = resultset.getString(strColumn);
            }
        } catch (Exception e) {


        }
        return sValue;
    }
}
