package thanksmatrix.tmtrucking;

import android.annotation.SuppressLint;
import android.os.StrictMode;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by KangSu on 1/30/2017.
 */

public class ConnectionClass {
    String ip = "thanksmatrix.com";
    //String ip = "192.168.1.2";
    String classs = "net.sourceforge.jtds.jdbc.Driver";
    String db = "TMatrix";
    String un = "TMatrix";
    //String un = "steve1";
    String password = "TxDlwel&G&x&D7l7G7w*T*YlDelqSlzhsM";
    //String password = "1234okok";
    @SuppressLint("NewApi")
    public Connection CONN() {
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                .permitAll().build();
        StrictMode.setThreadPolicy(policy);
        Connection conn = null;
        String ConnURL = null;
        try {
            Class.forName(classs).newInstance();
            ConnURL = "jdbc:jtds:sqlserver://" + ip + ";" + "databaseName=" + db + ";user=" + un + ";password=" + password + ";";
            conn = DriverManager.getConnection(ConnURL);
        } catch (SQLException se) {
            Log.e("ERRO", se.getMessage());
        } catch (ClassNotFoundException e) {
            Log.e("ERRO", e.getMessage());
        } catch (Exception e) {
            Log.e("ERRO", e.getMessage());
        }
        return conn;
    }
}
