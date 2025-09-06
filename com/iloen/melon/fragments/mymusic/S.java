package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import kotlin.jvm.internal.H;

public final class s implements View.OnClickListener {
    public final int a;
    public final boolean b;
    public final MemberProfileEditFragment c;
    public final String d;
    public final String e;
    public final H f;
    public final MemberProfileEditAdapter g;
    public final String h;

    public s(boolean z, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, String s2, int v) {
        this.a = v;
        this.b = z;
        this.c = memberProfileEditFragment0;
        this.d = s;
        this.e = s1;
        this.f = h0;
        this.g = memberProfileEditFragment$MemberProfileEditAdapter0;
        this.h = s2;
        super();
    }

    public s(boolean z, H h0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, MemberProfileEditFragment memberProfileEditFragment0, String s, String s1, String s2) {
        this.a = 0;
        super();
        this.b = z;
        this.f = h0;
        this.g = memberProfileEditFragment$MemberProfileEditAdapter0;
        this.c = memberProfileEditFragment0;
        this.d = s;
        this.e = s1;
        this.h = s2;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                MessageSettingViewHolder.b(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
                return;
            }
            case 1: {
                PrivateSettingViewHolder.bindItem$lambda$1(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
                return;
            }
            case 2: {
                PrivateSettingViewHolder.bindItem$lambda$2(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
                return;
            }
            case 3: {
                PrivateSettingViewHolder.bindItem$lambda$3(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
                return;
            }
            case 4: {
                PrivateSettingViewHolder.bindItem$lambda$4(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
                return;
            }
            default: {
                PrivateSettingViewHolder.bindItem$lambda$5(this.b, this.c, this.d, this.e, this.f, this.g, this.h, view0);
            }
        }
    }
}

