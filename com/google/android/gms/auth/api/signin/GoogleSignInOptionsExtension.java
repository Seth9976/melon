package com.google.android.gms.auth.api.signin;

import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import java.util.List;

@Deprecated
public interface GoogleSignInOptionsExtension {
    @KeepForSdk
    public static final int FITNESS = 3;
    @KeepForSdk
    public static final int GAMES = 1;

    @KeepForSdk
    int getExtensionType();

    @KeepForSdk
    List getImpliedScopes();

    @KeepForSdk
    Bundle toBundle();
}

