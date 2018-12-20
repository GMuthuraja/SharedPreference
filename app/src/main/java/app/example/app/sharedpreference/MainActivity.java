package app.example.app.sharedpreference;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    StorageData store;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        store = new StorageData(getApplicationContext());

        if(store.isUserLoggedIn()){
            startActivity(new Intent(MainActivity.this, Main2Activity.class));
            finish();
        }else {
            store.createSession("Muthu", "Chennai", true);
        }
    }


    public  void goNext(View v){
        startActivity(new Intent(MainActivity.this, Main2Activity.class));
    }
}
