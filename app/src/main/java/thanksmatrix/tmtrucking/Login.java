package thanksmatrix.tmtrucking;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;


/**
 * Created by KangSu on 1/30/2017.
 */

public class Login extends AppCompatActivity {
    private ConnectionClass connectionClass;
    private EditText edtuserid,edtpass;
    private Button btnlogin;
    private ProgressBar pbbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        addListenerOnButton();
        connectionClass = new ConnectionClass();
        edtuserid = (EditText) findViewById(R.id.userId);
        edtpass = (EditText) findViewById(R.id.password);
        btnlogin = (Button) findViewById(R.id.loginButton);
        pbbar = (ProgressBar) findViewById(R.id.pbbar);
        pbbar.setVisibility(View.GONE);
    }
    private void addListenerOnButton() {
        final Context context = this;
        btnlogin = (Button) findViewById(R.id.loginButton);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Dashboard.class);
                startActivity(intent);
            }
        });
    }


//        btnlogin.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                DoLogin doLogin = new DoLogin();
//                doLogin.execute("");
//            }
//        });

//    public class DoLogin extends AsyncTask<String,String,String>
//    {
//        String z = "";
//        Boolean isSuccess = false;
//
//        String userid = edtuserid.getText().toString();
//        String password = edtpass.getText().toString();
//
//
//        @Override
//        protected void onPreExecute() {
//            pbbar.setVisibility(View.VISIBLE);
//        }
//        @Override
//        protected void onPostExecute(String r) {
//            pbbar.setVisibility(View.GONE);
//            Toast.makeText(Login.this,r,Toast.LENGTH_SHORT).show();
//            if(isSuccess) {
//                SharedPreferences prefs = getSharedPreferences("MA", MODE_PRIVATE);
//                prefs.edit().putString("UN", userid).commit();
//                Intent i = new Intent(Login.this, Dashboard.class);
//                startActivity(i);
//                finish();
//            }
//        }
//
//        @Override
//        protected String doInBackground(String... params) {
//            if(userid.trim().equals("")|| password.trim().equals(""))
//                z = "Please enter username and password!";
//            else {
//                try {
//                    Connection con = connectionClass.CONN();
//                    if (con == null) {
//                        z = "Error in connection with SQL server!";
//                    } else {
//                        String query = "select loginid, password from users where loginid='" + userid + "' and password='" + password + "'";
//                        Statement stmt = con.createStatement();
//                        ResultSet rs = stmt.executeQuery(query);
//
//                        if(rs.next()) {
//                            z = "Login Successful!";
//                            isSuccess=true;
//                        }
//                        else {
//                            z = "Invalid Credentials";
//                            isSuccess = false;
//                        }
//                    }
//                }
//                catch (Exception ex) {
//                    isSuccess = false;
//                    z = ex.getMessage();
//                }
//            }
//            return z;
//        }
//    }

}
