package t9;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ToastManager;
import d5.n;
import ie.H;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import m4.e;
import m4.g;
import ne.a;

public final class v implements FlowCollector {
    public final z a;
    public final Context b;

    public v(z z0, Context context0) {
        this.a = z0;
        this.b = context0;
    }

    public final Object a(Drawable drawable0, Continuation continuation0) {
        Context context0;
        z z0;
        a a0;
        Object object0;
        s s0;
        if(continuation0 instanceof s) {
            s0 = (s)continuation0;
            int v = s0.G;
            if((v & 0x80000000) == 0) {
                s0 = new s(this, continuation0);
            }
            else {
                s0.G = v ^ 0x80000000;
            }
        }
        else {
            s0 = new s(this, continuation0);
        }
        try {
            object0 = s0.D;
            a0 = a.a;
            z0 = this.a;
            context0 = this.b;
            switch(s0.G) {
                case 0: {
                    goto label_15;
                }
                case 1: {
                    goto label_32;
                }
                case 2: {
                    goto label_47;
                }
            }
        }
        catch(Exception unused_ex) {
            ToastManager.show(0x7F13106D);  // string:toast_message_instagram_send_fail "인스타그램 공유에 실패하였습니다."
            return H.a;
        }
        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
    label_15:
        n.D(object0);
        try {
            q.e(drawable0, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
            Bitmap bitmap0 = ((BitmapDrawable)drawable0).getBitmap();
            q.f(bitmap0, "getBitmap(...)");
            e e0 = new e(bitmap0);
            e0.a = 24;
            g g0 = e0.a().e;
            z z1 = z0;
            int v1 = g0 == null ? ColorUtils.getColor(context0, 0x7F06048A) : g0.d;  // color:transparent
            Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new u(z1, context0, drawable0, v1, null), 3, null);
            Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new t(context0, v1, z1, null), 3, null);
            s0.r = deferred1;
            s0.B = v1;
            s0.G = 1;
            object0 = deferred0.await(s0);
            if(object0 == a0) {
                return a0;
            }
            goto label_37;
        label_32:
            int v2 = s0.B;
            deferred1 = s0.r;
            n.D(object0);
            v1 = v2;
            z1 = z0;
        label_37:
            s0.r = null;
            s0.w = (String)object0;
            s0.B = v1;
            s0.G = 2;
            Object object1 = deferred1.await(s0);
            if(object1 == a0) {
                return a0;
            }
            String s1 = (String)object0;
            object0 = object1;
            goto label_51;
        label_47:
            String s2 = s0.w;
            n.D(object0);
            s1 = s2;
            z1 = z0;
        label_51:
            LogU.Companion.d("InstagramSender", "share() bgFilePath: " + ((String)object0) + ", stickerFilePath: " + s1);
            if(AppUtils.checkExistApplication(context0, "com.instagram.android")) {
                z.c(z1, context0, ((String)object0), s1);
                return H.a;
            }
            ToastManager.show(0x7F13106C);  // string:toast_message_instagram_need_install "인스타그램이 설치되어 있지 않습니다."
        }
        catch(Exception unused_ex) {
            ToastManager.show(0x7F13106D);  // string:toast_message_instagram_send_fail "인스타그램 공유에 실패하였습니다."
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        return this.a(((Drawable)object0), continuation0);
    }
}

