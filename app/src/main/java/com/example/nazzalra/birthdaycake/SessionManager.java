package com.example.nazzalra.birthdaycake;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import java.util.HashMap;

/**
 * Created by nazzalra on 27/10/2016.
 */

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;
    // Editor untuk Shared preferences
    SharedPreferences.Editor editor;
    // Context
    Context _context;
    // Shared pref mode
    int PRIVATE_MODE = 0;
    // Sharedpref file name
    private static final String PREF_NAME = "DataLogin";
    // Semua Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";
    // Nama User (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_USERNAME = "dataUsername";
    // Alamat Email address (buat dengan variable public agar dapat di akses dari luar)
    public static final String KEY_PASSWORD = "dataPassword";
    // Constructor
    public SessionManager(Context context){
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void createLoginSession(){
// menyimpan login dengan nilai TRUE
        editor.putBoolean(IS_LOGIN, true);
// Simpan Perubahan
        editor.commit();
    }

    /**
     * Mendapatkan session data yang tersimpan
     * */
    public HashMap<String, String> getUserDetails(){
        HashMap<String, String> user = new HashMap<String, String>();
        user.put(KEY_USERNAME, pref.getString(KEY_USERNAME, null));
        user.put(KEY_PASSWORD, pref.getString(KEY_PASSWORD, null));
// return user
        return user;
    }

    /**
     * metode Check login akan mengecek login status
     * jika false maka akan mengarahkan ke page Login
     * jika tidak maka tidak ada perubahan
     * */
    public void checkLogin(){
// Cek login status
        if(!this.isLoggedIn()){
// jika user tidak login maka akan d arahakan ke Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
// tutup semua Activities
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
// tambahkan Flag baru untuk memulai Activity baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
// membuka Activity Login
            _context.startActivity(i);
        }
    }
    /**
     * cek user login
     * **/
// mendapatkan Login State
    public boolean isLoggedIn(){
        return pref.getBoolean(IS_LOGIN, false);
    }

    public void logoutUser(){
// menghapus semua data dari Shared Preferences
        editor.clear();
        editor.commit();

// setelah logout user diarahkan ke LoginActivity
        Intent i = new Intent(_context, LoginActivity.class);
// tutup semua Activities
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
// tambahkan Flag baru untuk memulai Activity baru
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // membuka Activity Login
        _context.startActivity(i);
    }
}