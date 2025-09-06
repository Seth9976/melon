package com.iloen.melon.fragments.mymusic;

import android.view.View.OnClickListener;
import android.view.View;

public final class r implements View.OnClickListener {
    public final int a;
    public final MemberProfileEditFragment b;
    public final MemberProfileEditAdapter c;

    public r(MemberProfileEditFragment memberProfileEditFragment0, MemberProfileEditAdapter memberProfileEditFragment$MemberProfileEditAdapter0, int v) {
        this.a = v;
        this.b = memberProfileEditFragment0;
        this.c = memberProfileEditFragment$MemberProfileEditAdapter0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        switch(this.a) {
            case 0: {
                DjIntroduceViewHolder.bindItem$lambda$2(this.b, this.c, view0);
                return;
            }
            case 1: {
                DjPickViewHolder.bindItem$lambda$2(this.b, this.c, view0);
                return;
            }
            case 2: {
                MessageSettingViewHolder.bindItem$lambda$2(this.b, this.c, view0);
                return;
            }
            case 3: {
                NickNameEditViewHolder.bindItem$lambda$1(this.b, this.c, view0);
                return;
            }
            case 4: {
                NickNameEditViewHolder.bindItem$lambda$3(this.b, this.c, view0);
                return;
            }
            default: {
                ProfileThumbViewHolder.bindItem$lambda$2(this.b, this.c, view0);
            }
        }
    }
}

