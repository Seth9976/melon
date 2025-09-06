package com.iloen.melon.activity;

import Fc.k;
import Fc.t;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.I;
import b.a;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.utils.color.ColorUtils;
import com.kakao.tiara.data.ActionKind;
import com.kakao.tiara.track.Event;
import gd.r5;
import ie.H;
import java.util.LinkedHashMap;
import k8.Y;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import l8.n;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import q8.b;
import q8.c;
import q8.d;
import q8.f;
import q8.h;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000B\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00182\u00020\u00012\u00020\u0002:\u0001\u0019B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\'\u0010\n\u001A\u00020\t2\u0006\u0010\u0006\u001A\u00020\u00052\u0006\u0010\u0007\u001A\u00020\u00052\u0006\u0010\b\u001A\u00020\u0005H\u0002¢\u0006\u0004\b\n\u0010\u000BJ\u0019\u0010\u000E\u001A\u00020\t2\b\u0010\r\u001A\u0004\u0018\u00010\fH\u0014¢\u0006\u0004\b\u000E\u0010\u000FJ\u000F\u0010\u0011\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0011\u0010\u0012J\u000F\u0010\u0013\u001A\u00020\u0010H\u0016¢\u0006\u0004\b\u0013\u0010\u0012R\u0016\u0010\u0017\u001A\u0004\u0018\u00010\u00148TX\u0094\u0004¢\u0006\u0006\u001A\u0004\b\u0015\u0010\u0016¨\u0006\u001A"}, d2 = {"Lcom/iloen/melon/activity/CoverScreenActivity;", "Lcom/iloen/melon/activity/PopupFragmentActivity;", "Lr8/b;", "<init>", "()V", "", "clickCopy", "pageMetaId", "pageMetaName", "Lie/H;", "trackTiaraEventLog", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "", "shouldIgnoreForeground", "()Z", "isLockScreen", "Landroidx/fragment/app/I;", "getAddFragment", "()Landroidx/fragment/app/I;", "addFragment", "Companion", "l8/n", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class CoverScreenActivity extends Hilt_CoverScreenActivity {
    public static final int $stable = 8;
    @NotNull
    public static final n Companion = null;
    @NotNull
    private static final String TAG = "CoverScreenActivity";

    static {
        CoverScreenActivity.Companion = new n();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    @Nullable
    public I getAddFragment() {
        if(this.getIntent() == null) {
            return null;
        }
        String s = String.valueOf(this.getIntent().getIntExtra("com.iloen.melon.intent.extra.widget.page_meta_id", -1));
        String s1 = this.getIntent().getStringExtra("com.iloen.melon.intent.extra.widget.page_meta_name");
        if(s1 == null) {
            s1 = "";
        }
        if(q.b(this.getIntent().getAction(), "com.iloen.melon.intent.action.widget.cover_playlist")) {
            q.f("재생목록", "getString(...)");
            this.trackTiaraEventLog("재생목록", s, s1);
            return new t();
        }
        q.f("가사", "getString(...)");
        this.trackTiaraEventLog("가사", s, s1);
        return new k();
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public boolean isLockScreen() {
        return true;
    }

    @Override  // com.iloen.melon.activity.Hilt_CoverScreenActivity
    public void onBackStackChangeCancelled() {
    }

    @Override  // com.iloen.melon.activity.Hilt_CoverScreenActivity
    public void onBackStackChangeCommitted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.Hilt_CoverScreenActivity
    public void onBackStackChangeProgressed(a a0) {
    }

    @Override  // com.iloen.melon.activity.Hilt_CoverScreenActivity
    public void onBackStackChangeStarted(I i0, boolean z) {
    }

    @Override  // com.iloen.melon.activity.PopupFragmentActivity
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        View view0 = this.getFragmentContainer();
        if(view0 != null) {
            view0.setFitsSystemWindows(false);
            MelonAppBase.Companion.getClass();
            view0.setBackgroundColor(ColorUtils.getColor(k8.t.a().getContext(), 0x7F060030));  // color:black000a
        }
    }

    @Override  // com.iloen.melon.activity.PopupFragmentBaseActivity
    public boolean shouldIgnoreForeground() {
        return true;
    }

    private final void trackTiaraEventLog(String s, String s1, String s2) {
        d d0 = new d();  // 初始化器: LQb/h;-><init>()V
        CoverScreenActivity.trackTiaraEventLog$lambda$16(this, s, s1, s2, d0);
        ((Event)d0.p()).track();
    }

    private static final H trackTiaraEventLog$lambda$16(CoverScreenActivity coverScreenActivity0, String s, String s1, String s2, d d0) {
        q.g(d0, "$this$tiaraEventLogBuilder");
        CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$2(coverScreenActivity0, ((h)d0.b));
        b b0 = (b)d0.c;
        if(b0 == null) {
            b b1 = new b();  // 初始化器: Ljava/lang/Object;-><init>()V
            CoverScreenActivity.w(coverScreenActivity0, b1);
            d0.c = b1;
        }
        else {
            CoverScreenActivity.w(coverScreenActivity0, b0);
        }
        q8.a a0 = (q8.a)d0.d;
        if(a0 == null) {
            q8.a a1 = new q8.a();  // 初始化器: Lcom/kakao/tiara/data/Click$Builder;-><init>()V
            CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$9(coverScreenActivity0, s, a1);
            d0.d = a1;
        }
        else {
            CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$9(coverScreenActivity0, s, a0);
        }
        f f0 = (f)d0.f;
        if(f0 == null) {
            f f1 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
            CoverScreenActivity.u(s1, s2, f1);
            d0.f = f1;
        }
        else {
            CoverScreenActivity.u(s1, s2, f0);
        }
        c c0 = new c();
        CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$15(c0);
        ((LinkedHashMap)d0.g).putAll(c0.a);
        return H.a;
    }

    private static final H trackTiaraEventLog$lambda$16$lambda$13(String s, String s1, f f0) {
        q.g(f0, "$this$pageMeta");
        f0.a = s;
        f0.b = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$13$lambda$11();
        f0.c = s1;
        return H.a;
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$13$lambda$10(String s) [...] // Inlined contents

    private static final String trackTiaraEventLog$lambda$16$lambda$13$lambda$11() {
        return Y.i(ContsTypeCode.SONG, "code(...)");
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$13$lambda$12(String s) [...] // Inlined contents

    private static final H trackTiaraEventLog$lambda$16$lambda$15(c c0) {
        q.g(c0, "$this$customProps");
        c0.a(new r5(25));
        return H.a;
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$15$lambda$14() [...] // Inlined contents

    private static final H trackTiaraEventLog$lambda$16$lambda$2(CoverScreenActivity coverScreenActivity0, h h0) {
        q.g(h0, "$this$track");
        String s = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$2$lambda$1(coverScreenActivity0);
        if(s == null) {
            s = "";
        }
        h0.a = s;
        return H.a;
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$2$lambda$1(CoverScreenActivity coverScreenActivity0) {
        return "페이지이동";
    }

    private static final H trackTiaraEventLog$lambda$16$lambda$6(CoverScreenActivity coverScreenActivity0, b b0) {
        q.g(b0, "$this$common");
        b0.c = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$6$lambda$3();
        b0.a = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$6$lambda$4(coverScreenActivity0);
        b0.b = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$6$lambda$5(coverScreenActivity0);
        return H.a;
    }

    private static final ActionKind trackTiaraEventLog$lambda$16$lambda$6$lambda$3() {
        return ActionKind.ClickContent;
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$6$lambda$4(CoverScreenActivity coverScreenActivity0) {
        return "위젯";
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$6$lambda$5(CoverScreenActivity coverScreenActivity0) {
        return "위젯_aos_z플립위젯";
    }

    private static final H trackTiaraEventLog$lambda$16$lambda$9(CoverScreenActivity coverScreenActivity0, String s, q8.a a0) {
        q.g(a0, "$this$click");
        a0.a = CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$9$lambda$7(coverScreenActivity0);
        a0.g = s;
        return H.a;
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$9$lambda$7(CoverScreenActivity coverScreenActivity0) {
        return "플레이어";
    }

    private static final String trackTiaraEventLog$lambda$16$lambda$9$lambda$8(String s) [...] // Inlined contents

    public static H u(String s, String s1, f f0) {
        return CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$13(s, s1, f0);
    }

    public static String v() [...] // 潜在的解密器

    public static H w(CoverScreenActivity coverScreenActivity0, b b0) {
        return CoverScreenActivity.trackTiaraEventLog$lambda$16$lambda$6(coverScreenActivity0, b0);
    }
}

