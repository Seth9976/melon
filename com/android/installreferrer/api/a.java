package com.android.installreferrer.api;

import android.content.Context;

public final class a {
    public final Context a;

    public a(Context context0) {
        this.a = context0;
    }

    public final InstallReferrerClient a() {
        Context context0 = this.a;
        if(context0 == null) {
            throw new IllegalArgumentException("Please provide a valid Context.");
        }
        return new InstallReferrerClientImpl(context0);
    }
}

