package zd;

import android.app.Activity;
import com.iloen.melon.net.v4x.common.ContsTypeCode;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsManager.PostParam;
import com.iloen.melon.sns.target.SnsManager.SnsType;
import com.iloen.melon.sns.target.SnsTarget;
import com.melon.ui.popup.context.more.MelonBottomSheetItem;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import t9.D;
import t9.F;
import w4.f;
import wc.u;

public final class x0 extends D0 {
    public final Sharable a;

    public x0(Sharable sharable0) {
        q.g(sharable0, "sharable");
        super();
        this.a = sharable0;
    }

    @Override  // zd.D0
    public final String a() {
        String s = this.a.getContentId();
        return s == null ? "" : s;
    }

    @Override  // zd.Q
    public final ArrayList c() {
        boolean z = this.a().length() > 0 && !"-1".equals(this.a());
        ArrayList arrayList0 = new ArrayList();
        Sharable sharable0 = this.a;
        if(sharable0.isShowKakaoTalk()) {
            arrayList0.add(x.J);
        }
        if(sharable0.isShowInstagram()) {
            arrayList0.add(x.D);
        }
        if(sharable0.isShowTwitter()) {
            arrayList0.add(x.I);
        }
        ContsTypeCode contsTypeCode0 = sharable0.getContsTypeCode();
        if(q.b(ContsTypeCode.SONG, contsTypeCode0)) {
            if(sharable0.isShowFacebook()) {
                arrayList0.add(x.F);
            }
            if(sharable0.isShowFacebook()) {
                arrayList0.add(x.G);
            }
        }
        else if(sharable0.isShowFacebook()) {
            arrayList0.add(x.E);
        }
        if(sharable0.isShowUrlCopy()) {
            arrayList0.add(x.H);
        }
        if(sharable0.isShowMusicMessage()) {
            arrayList0.add(MelonBottomSheetItem.a(x.A, z, null, 0x2F));
        }
        if(sharable0.isShowMore()) {
            arrayList0.add(x.Q);
        }
        return arrayList0;
    }

    @Override
    public final boolean equals(Object object0) {
        if(this == object0) {
            return true;
        }
        return object0 instanceof x0 ? q.b(this.a, ((x0)object0).a) : false;
    }

    @Override  // zd.Q
    public final int g() {
        return 28;
    }

    @Override
    public final int hashCode() {
        return this.a.hashCode();
    }

    // 去混淆评级： 低(20)
    @Override  // zd.Q
    public final String r() {
        return "";
    }

    public static void s(Sharable sharable0, Activity activity0) {
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = SnsManager.SnsType.a;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = activity0;
        u u0 = new u(6);
        F.a.getClass();
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, u0);
    }

    public static void t(Sharable sharable0, Activity activity0) {
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = SnsManager.SnsType.d;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = activity0;
        snsManager$PostParam0.d = sharable0 == null ? null : sharable0.getDisplayMessage(new D());
        F.a.getClass();
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, null);
    }

    @Override
    public final String toString() {
        return "ShareSnsBottomSheetType(sharable=" + this.a + ")";
    }

    public final String u() {
        SnsTarget snsTarget0 = F.a.B(SnsManager.SnsType.h);
        String s = this.a.getDisplayMessage(snsTarget0);
        q.f(s, "getDisplayMessage(...)");
        return s;
    }

    public static void v(Sharable sharable0, Activity activity0, SnsManager.SnsType snsManager$SnsType0) {
        if(activity0 != null) {
            SnsTarget snsTarget0 = F.a.B(snsManager$SnsType0);
            SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
            snsManager$PostParam0.a = snsManager$SnsType0;
            snsManager$PostParam0.c = sharable0;
            snsManager$PostParam0.b = activity0;
            snsManager$PostParam0.d = sharable0 == null ? null : sharable0.getDisplayMessage(snsTarget0);
            F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, null);
        }
    }

    public static void w(Sharable sharable0, Activity activity0) {
        SnsManager.PostParam snsManager$PostParam0 = new SnsManager.PostParam();
        snsManager$PostParam0.a = SnsManager.SnsType.c;
        snsManager$PostParam0.c = sharable0;
        snsManager$PostParam0.b = activity0;
        f f0 = new f();  // 初始化器: Ljava/lang/Object;-><init>()V
        F.a.getClass();
        F.a.B(snsManager$PostParam0.a).a(snsManager$PostParam0, f0);
    }
}

