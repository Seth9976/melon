package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;
import com.iloen.melon.net.v6x.response.MyMusicSettingInformProfileSimpleRes.RESPONSE;

public final class q implements View.OnClickListener {
    public final int a;
    public final MemberProfileEditFragment b;
    public final MemberProfileEditAdapter c;
    public final RESPONSE d;

    public q(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, int v) {
        this.a = v;
        this.b = memberProfileEditFragment0;
        this.c = memberProfileEditFragment$MemberProfileEditAdapter0;
        this.d = myMusicSettingInformProfileSimpleRes$RESPONSE0;
        super();
    }

    public q(MemberProfileEditFragment memberProfileEditFragment0, RESPONSE myMusicSettingInformProfileSimpleRes$RESPONSE0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0) {
        this.a = 2;
        super();
        this.b = memberProfileEditFragment0;
        this.d = myMusicSettingInformProfileSimpleRes$RESPONSE0;
        this.c = memberProfileEditFragment$MemberProfileEditAdapter0;
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DjIntroduceViewHolder.bindItem$lambda$0(this.b, this.c, this.d, view0);
                return;
            }
            case 1: {
                DjPickViewHolder.bindItem$lambda$0(this.b, this.c, this.d, view0);
                return;
            }
            case 2: {
                SnsConnectViewHolder.d(this.b, this.c, this.d, view0);
                return;
            }
            default: {
                SnsConnectViewHolder.bindItem$lambda$2(this.b, this.c, this.d, view0);
            }
        }
    }
}

