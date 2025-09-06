package com.facebook.login;

import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import java.util.Date;

public final class a implements DialogInterface.OnClickListener {
    public final DeviceAuthDialog a;
    public final String b;
    public final PermissionsLists c;
    public final String d;
    public final Date e;
    public final Date f;

    public a(DeviceAuthDialog deviceAuthDialog0, String s, PermissionsLists deviceAuthDialog$PermissionsLists0, String s1, Date date0, Date date1) {
        this.a = deviceAuthDialog0;
        this.b = s;
        this.c = deviceAuthDialog$PermissionsLists0;
        this.d = s1;
        this.e = date0;
        this.f = date1;
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        DeviceAuthDialog.presentConfirmation$lambda$6(this.a, this.b, this.c, this.d, this.e, this.f, dialogInterface0, v);
    }
}

