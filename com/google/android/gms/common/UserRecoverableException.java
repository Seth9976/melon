package com.google.android.gms.common;

import android.content.Intent;

public class UserRecoverableException extends Exception {
    private final Intent zza;

    public UserRecoverableException(String s, Intent intent0) {
        super(s);
        this.zza = intent0;
    }

    public Intent getIntent() {
        return new Intent(this.zza);
    }
}

