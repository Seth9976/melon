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
import ne.a;

public final class j implements FlowCollector {
    public final o a;
    public final Context b;

    public j(o o0, Context context0) {
        this.a = o0;
        this.b = context0;
    }

    public final Object a(Drawable drawable0, Continuation continuation0) {
        Context context0;
        a a0;
        Object object0;
        g g0;
        o o0 = this.a;
        if(continuation0 instanceof g) {
            g0 = (g)continuation0;
            int v = g0.G;
            if((v & 0x80000000) == 0) {
                g0 = new g(this, continuation0);
            }
            else {
                g0.G = v ^ 0x80000000;
            }
        }
        else {
            g0 = new g(this, continuation0);
        }
        try {
            object0 = g0.D;
            a0 = a.a;
            context0 = this.b;
            switch(g0.G) {
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
            ToastManager.show(0x7F13106B);  // string:toast_message_facebook_send_fail "페이스북 공유에 실패하였습니다."
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
            m4.g g1 = e0.a().e;
            Context context1 = context0;
            int v1 = g1 == null ? ColorUtils.getColor(context0, 0x7F06048A) : g1.d;  // color:transparent
            Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new i(context1, drawable0, v1, o0, null), 3, null);
            Deferred deferred1 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new h(context1, v1, o0, null), 3, null);
            g0.r = deferred1;
            g0.B = v1;
            g0.G = 1;
            object0 = deferred0.await(g0);
            if(object0 == a0) {
                return a0;
            }
            goto label_37;
        label_32:
            int v2 = g0.B;
            deferred1 = g0.r;
            n.D(object0);
            v1 = v2;
            context1 = context0;
        label_37:
            g0.r = null;
            g0.w = (String)object0;
            g0.B = v1;
            g0.G = 2;
            Object object1 = deferred1.await(g0);
            if(object1 == a0) {
                return a0;
            }
            String s = (String)object0;
            object0 = object1;
            goto label_51;
        label_47:
            String s1 = g0.w;
            n.D(object0);
            s = s1;
            context1 = context0;
        label_51:
            LogU.Companion.d("FacebookStory", "share() bgFilePath: " + ((String)object0) + ", stickerFilePath: " + s);
            if(AppUtils.checkExistApplication(context1, "com.facebook.katana")) {
                BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new l(context1, ((String)object0), s, null), 3, null);
                return H.a;
            }
            ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
        }
        catch(Exception unused_ex) {
            ToastManager.show(0x7F13106B);  // string:toast_message_facebook_send_fail "페이스북 공유에 실패하였습니다."
        }
        return H.a;
    }

    @Override  // kotlinx.coroutines.flow.FlowCollector
    public final Object emit(Object object0, Continuation continuation0) {
        return this.a(((Drawable)object0), continuation0);
    }
}

