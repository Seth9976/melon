package com.iloen.melon.fragments.detail.viewholder;

import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface;
import com.iloen.melon.activity.BaseActivity;
import com.iloen.melon.fragments.settings.alarm.AlarmPermissionHelper.Companion;
import we.a;

public final class r implements DialogInterface.OnClickListener {
    public final int a;
    public final Object b;
    public final Object c;
    public final Object d;

    public r(Object object0, Object object1, Object object2, int v) {
        this.a = v;
        this.b = object0;
        this.c = object1;
        this.d = object2;
        super();
    }

    @Override  // android.content.DialogInterface$OnClickListener
    public final void onClick(DialogInterface dialogInterface0, int v) {
        if(this.a != 0) {
            Companion.a(((a)this.b), ((a)this.c), ((Context)this.d), dialogInterface0, v);
            return;
        }
        com.iloen.melon.fragments.detail.viewholder.LyricHolder.1.onLongClick$lambda$1$lambda$0(((BaseActivity)this.b), ((String)this.c), ((LyricHolder)this.d), dialogInterface0, v);
    }
}

