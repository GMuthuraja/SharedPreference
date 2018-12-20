package app.example.app.sharedpreference;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.HashMap;



public class StorageData {

    Context context;
    SharedPreferences sp;
    SharedPreferences.Editor editor;


    public StorageData(Context _context){
        context = _context;
        sp = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE);
        editor = sp.edit();
    }


    public void createSession(String name, String city, Boolean session){
        editor.putString("name", name);
        editor.putString("city", "Chennai");
        editor.putBoolean("isLogedIn", session);
        editor.commit();
    }


    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> users = new HashMap<String, String>();
        users.put("hash_name", sp.getString("name", null));
        users.put("hash_city", sp.getString("city", null));
        return users;
    }


    public boolean isUserLoggedIn(){
        return sp.getBoolean("isLogedIn", false);
    }


    public void clearStorage(){
        editor.clear();
        editor.commit();
    }

}
