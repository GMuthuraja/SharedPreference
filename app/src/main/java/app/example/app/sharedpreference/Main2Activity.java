package app.example.app.sharedpreference;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

public class Main2Activity extends AppCompatActivity {

    StorageData store_data;
    TextView txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txt = (TextView) findViewById(R.id.textView);

        store_data = new StorageData(getApplicationContext());
        boolean val =  store_data.isUserLoggedIn();

        HashMap<String, String> userDetail = store_data.getUserDetails();
        String name = userDetail.get("hash_name");
        String city = userDetail.get("hash_city");

        txt.setText(val+"\n"+name+"\n"+city);
    }


    public  void logout(View v){
        store_data.clearStorage();
    }
}
