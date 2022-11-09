package Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.retrofitdemo.R;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import ApiInterface.ApiInterface;
import ApiInterface.RetrofitClient;
import Model.SystemInfo;
import Model.UserParams;
import Model.UserResponse;
import okhttp3.OkHttpClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_login;
    EditText et_uId,et_pid,et_cid,et_gid;
    ProgressBar pg_bar;
    private Retrofit retrofit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btn_login.setOnClickListener(this);
    }

    public void init()
    {
        btn_login = findViewById(R.id.btn_login);
        et_uId = findViewById(R.id.et_lid);
        et_pid = findViewById(R.id.et_pid);
        et_cid = findViewById(R.id.et_cid);
        et_gid = findViewById(R.id.et_gid);
        pg_bar = findViewById(R.id.pg_bar);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()) {
            case R.id.btn_login:
                if (isConnected()) {
//                    pg_bar.setVisibility(View.VISIBLE);
                    LoginUser();
                    break;
                }
        }
//

    }

    private void LoginUser() {
        String UserId,PasswordId,CompanyId,Gateway;

        UserId = et_uId.getText().toString();
        PasswordId = et_pid.getText().toString();
        CompanyId = et_cid.getText().toString();
        Gateway = et_gid.getText().toString();

        if(UserId.isEmpty())
        {
            et_uId.requestFocus();
            et_uId.setError("Please enter your login Id");
            return;
        }

        if(PasswordId.isEmpty())
        {
            et_pid.requestFocus();
            et_pid.setError("Please enter your password ");
            return;
        }

        if(CompanyId.isEmpty())
        {
            et_cid.requestFocus();
            et_cid.setError("Please enter your company d");
            return;
        }

        if(Gateway.isEmpty())
        {
            et_gid.requestFocus();
            et_gid.setError("Please enter your Gateway");
            return;
        }



      /*  body.setClientVer("CSC-W v1.0.0.1");
        body.setTunVer("ncmv1.0.0");
        body.setOsVer("Windows 10 Pro 21H2");
        body.setOsBuild("19044.1415");
        body.setCpu("Intel(R) Core(TM)
 i5-9400F CPU @ 2.90GHz");
        body.setCpuUsagePercent("37");
        body.setTotalRam("4GB");
        body.setFreeRam("2GB");*/



        final OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .readTimeout(180, TimeUnit.SECONDS)
                .connectTimeout(180, TimeUnit.SECONDS)
                .build();
        retrofit = new Retrofit.Builder()
                .baseUrl(RetrofitClient.BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        ApiInterface api = retrofit.create(ApiInterface.class);
        Map<String, String> map = new HashMap<>();
        map.put("Accept","application/json");
        map.put("X-Cachatto-Company-ID", CompanyId);
        map.put("X-Cachatto-User_ID", UserId);

        Log.e("map", new Gson().toJson(map));
        UserParams body = new UserParams();

        body.setUserId(UserId);
        body.setUserPwd(PasswordId);
        body.setDeviceUuid("daac3291ca4a93e7-09a923-7fb34");
        SystemInfo systemInfo = new SystemInfo();
        systemInfo.setClientVer("CSC-W v1.0.0.1");
        systemInfo.setTunVer("ncmv1.0.0");
        systemInfo.setOsVer("Windows 10 Pro 21H2");
        systemInfo.setOsBuild("19044.1415");
        systemInfo.setCpu("Intel(R) Core(TM) i5-9400F CPU @ 2.90GHz");
        systemInfo.setCpuUsagePercent("37");
        systemInfo.setTotalRam("4GB");
        systemInfo.setFreeRam("2GB");

        Log.e("systemInfo", new Gson().toJson(systemInfo));

        body.setSystemInfo(systemInfo);

        Log.e("body", new Gson().toJson(body));
        Call<UserResponse> call = api.fetchUser(map,body);
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response)
            {
                Log.i("svdfer", "onResponse: "+ response.code());
/*
                if(response.code()==200){
                    pg_bar.setVisibility(View.GONE);*/

              /*      startActivity(new Intent(MainActivity.this, HomeActivity.class));
                }
               else
                {
                    Toast.makeText(MainActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                }*/
            }



            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.d("abcd", "onFailure: "+t.getMessage());
            }
        });

    }

    public boolean isConnected() {
        boolean connected = false;
        try {
            ConnectivityManager cm = (ConnectivityManager)getApplicationContext().getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo nInfo = cm.getActiveNetworkInfo();
            connected = nInfo != null && nInfo.isAvailable() && nInfo.isConnected();
            return connected;
        } catch (Exception e) {
            Log.e("Connectivity Exception", e.getMessage());
        }
        return connected;
    }
}