package com.kakao.emoticon.ui.widget;

import S1.d;
import android.view.View;
import c2.B0;
import c2.v;
import com.iloen.melon.MusicBrowserActivity;
import com.iloen.melon.activity.PopupFragmentActivity;
import com.kakao.digitalitem.image.lib.AnimatedItemImageContainer;
import com.kakao.digitalitem.image.lib.AnimatedItemImageView.OnIndexChangeListener;
import kotlin.jvm.internal.q;

public final class b implements v, OnIndexChangeListener {
    public final int a;
    public final View b;

    public b(View view0, int v) {
        this.a = v;
        this.b = view0;
        super();
    }

    @Override  // com.kakao.digitalitem.image.lib.AnimatedItemImageView$OnIndexChangeListener
    public void onIndexChange(AnimatedItemImageContainer animatedItemImageContainer0, int v) {
        EmoticonSpan.lambda$addIndexChangeListener$0(this.b, animatedItemImageContainer0, v);
    }

    @Override  // c2.v
    public B0 s(View view0, B0 b00) {
        switch(this.a) {
            case 1: {
                q.g(view0, "<unused var>");
                d d0 = b00.a.g(0x28F);
                q.f(d0, "getInsets(...)");
                this.b.setPadding(d0.a, 0, d0.c, d0.d);
                return b00;
            }
            case 2: {
                return MusicBrowserActivity.updateSystemUiFit$lambda$61$lambda$58(this.b, view0, b00);
            }
            case 3: {
                return MusicBrowserActivity.updateSystemUiFit$lambda$61$lambda$59(this.b, view0, b00);
            }
            case 4: {
                return MusicBrowserActivity.updateSystemUiFit$lambda$61$lambda$60(this.b, view0, b00);
            }
            case 5: {
                return PopupFragmentActivity.updateSystemUiFit$lambda$3$lambda$0(this.b, view0, b00);
            }
            case 6: {
                return PopupFragmentActivity.updateSystemUiFit$lambda$3$lambda$1(this.b, view0, b00);
            }
            default: {
                return PopupFragmentActivity.updateSystemUiFit$lambda$3$lambda$2(this.b, view0, b00);
            }
        }
    }
}

