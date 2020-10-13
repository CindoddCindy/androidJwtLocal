package ac.i.pemesanan.shared_pref;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferenceHandler {
    public static final String GEEK_APP_PROJECT = "pemesanan_app";

    public static final String GEEK_USER_NAME = "geek_user_name";
    public static final String GEEK_USER_EMAIL = "geek_user_email";
    public static final String GEEK_USER_PHONE = "geek_user_phone";
    public static final String GEEK_USER_PASS = "geek_user_pass";

    SharedPreferences sp;
    SharedPreferences.Editor spEditor;

    public SharedPreferenceHandler(Context context){
        sp = context.getSharedPreferences(GEEK_APP_PROJECT, Context.MODE_PRIVATE);
        spEditor = sp.edit();
    }

    //metod

    public void setGeekUserName(String key, String value){
        spEditor.putString(key,value);
        spEditor.commit();
    }

    public String getZonaGetNamaUser(){
        return sp.getString(GEEK_USER_NAME,"");
    }

    public  void setGeekUserEmail(String key, String value){
        spEditor.putString(key,value);
        spEditor.commit();
    }

    public String getGeekUserEmail(){
        return  sp.getString(GEEK_USER_EMAIL, "");
    }

    public void  setGeekUserPhone(String key, String value){
        spEditor.putString(key, value);
        spEditor.commit();
    }

    public String getGeekUserPhone(){
        return sp.getString(GEEK_USER_PHONE,"");
    }

    public void setGeekUserPass(String key, String value){
        spEditor.putString(key, value);
        spEditor.commit();
    }

    public String getGeekUserPass(){
        return sp.getString(GEEK_USER_PASS,"");
    }


}
