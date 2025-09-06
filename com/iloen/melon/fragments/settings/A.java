package com.iloen.melon.fragments.settings;

import android.view.View.OnClickListener;
import android.view.View;

public final class a implements View.OnClickListener {
    public final int a;
    public final KakaoMelonLoginFragment b;

    public a(KakaoMelonLoginFragment kakaoMelonLoginFragment0, int v) {
        this.a = v;
        this.b = kakaoMelonLoginFragment0;
        super();
    }

    @Override  // android.view.View$OnClickListener
    public final void onClick(View view0) {
        if(this.a != 0) {
            KakaoMelonLoginFragment.initViews$lambda$1(this.b, view0);
            return;
        }
        KakaoMelonLoginFragment.initViews$lambda$0(this.b, view0);
    }
}

