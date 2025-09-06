package com.google.android.gms.auth.api.signin.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import org.json.JSONException;

@KeepForSdk
public class Storage {
    private static final Lock zaa;
    private static Storage zab;
    private final Lock zac;
    private final SharedPreferences zad;

    static {
        Storage.zaa = new ReentrantLock();
    }

    public Storage(Context context0) {
        this.zac = new ReentrantLock();
        this.zad = context0.getSharedPreferences("com.google.android.gms.signin", 0);
    }

    @KeepForSdk
    public void clear() {
        this.zac.lock();
        try {
            this.zad.edit().clear().apply();
        }
        finally {
            this.zac.unlock();
        }
    }

    @KeepForSdk
    public static Storage getInstance(Context context0) {
        Storage storage0;
        Preconditions.checkNotNull(context0);
        Lock lock0 = Storage.zaa;
        lock0.lock();
        try {
            if(Storage.zab == null) {
                Storage.zab = new Storage(context0.getApplicationContext());
            }
            storage0 = Storage.zab;
        }
        catch(Throwable throwable0) {
            Storage.zaa.unlock();
            throw throwable0;
        }
        lock0.unlock();
        return storage0;
    }

    @KeepForSdk
    public GoogleSignInAccount getSavedDefaultGoogleSignInAccount() {
        String s = this.zaa("defaultGoogleSignInAccount");
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        String s1 = this.zaa(Storage.zae("googleSignInAccount", s));
        if(s1 != null) {
            try {
                return GoogleSignInAccount.zab(s1);
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    @KeepForSdk
    public GoogleSignInOptions getSavedDefaultGoogleSignInOptions() {
        String s = this.zaa("defaultGoogleSignInAccount");
        if(TextUtils.isEmpty(s)) {
            return null;
        }
        String s1 = this.zaa(Storage.zae("googleSignInOptions", s));
        if(s1 != null) {
            try {
                return GoogleSignInOptions.zab(s1);
            }
            catch(JSONException unused_ex) {
            }
        }
        return null;
    }

    @KeepForSdk
    public String getSavedRefreshToken() {
        return this.zaa("refreshToken");
    }

    @KeepForSdk
    public void saveDefaultGoogleSignInAccount(GoogleSignInAccount googleSignInAccount0, GoogleSignInOptions googleSignInOptions0) {
        Preconditions.checkNotNull(googleSignInAccount0);
        Preconditions.checkNotNull(googleSignInOptions0);
        this.zad("defaultGoogleSignInAccount", googleSignInAccount0.zac());
        Preconditions.checkNotNull(googleSignInAccount0);
        Preconditions.checkNotNull(googleSignInOptions0);
        String s = googleSignInAccount0.zac();
        this.zad(Storage.zae("googleSignInAccount", s), googleSignInAccount0.zad());
        this.zad(Storage.zae("googleSignInOptions", s), googleSignInOptions0.zaf());
    }

    public final String zaa(String s) {
        this.zac.lock();
        try {
            return this.zad.getString(s, null);
        }
        finally {
            this.zac.unlock();
        }
    }

    public final void zab(String s) {
        this.zac.lock();
        try {
            this.zad.edit().remove(s).apply();
        }
        finally {
            this.zac.unlock();
        }
    }

    public final void zac() {
        String s = this.zaa("defaultGoogleSignInAccount");
        this.zab("defaultGoogleSignInAccount");
        if(TextUtils.isEmpty(s)) {
            return;
        }
        this.zab(Storage.zae("googleSignInAccount", s));
        this.zab(Storage.zae("googleSignInOptions", s));
    }

    public final void zad(String s, String s1) {
        this.zac.lock();
        try {
            this.zad.edit().putString(s, s1).apply();
        }
        finally {
            this.zac.unlock();
        }
    }

    private static final String zae(String s, String s1) {
        return s + ":" + s1;
    }
}

