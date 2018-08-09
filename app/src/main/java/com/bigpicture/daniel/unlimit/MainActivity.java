package com.bigpicture.daniel.unlimit;

import android.content.DialogInterface;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.bigpicture.daniel.unlimit.Util.DeviceUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(!DeviceUtil.getNetworkConnection(this)){
            showDialog();
        }
    }

    private void showDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("네트워크 연결 실패");
        builder.setMessage("네트워크 연결이 필요합니다. 시스템을 종료합니다.");
        builder.setPositiveButton("예",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        finishApp();
                    }
                });
        builder.show();
    }

    private void finishApp(){
        finishAffinity();
        System.runFinalization();
        System.exit(0);
    }
}
