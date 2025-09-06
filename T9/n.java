package t9;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.utils.FileUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import ie.H;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;

public final class n extends i implements we.n {
    public final Uri B;
    public final o D;
    public final int E;
    public int r;
    public final Context w;

    public n(Context context0, Uri uri0, o o0, int v, Continuation continuation0) {
        this.w = context0;
        this.B = uri0;
        this.D = o0;
        this.E = v;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new n(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((n)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        o o0 = this.D;
        Context context0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new m(context0, this.E, o0, null), 3, null);
                this.r = 1;
                object0 = deferred0.await(this);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                d5.n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        Uri uri0 = FileUtils.getFileUri(context0, new File(((String)object0)));
        q.f("4022717807957185", "getString(...)");
        Intent intent0 = new Intent("com.facebook.stories.ADD_TO_STORY");
        intent0.setFlags(1);
        intent0.addFlags(0x10000000);
        intent0.setDataAndType(uri0, "image/png");
        intent0.putExtra("com.facebook.platform.extra.APPLICATION_ID", "4022717807957185");
        intent0.putExtra("interactive_asset_uri", this.B);
        context0.grantUriPermission("com.facebook.katana", uri0, 1);
        context0.grantUriPermission("com.facebook.katana", this.B, 1);
        try {
            context0.startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("FacebookStory", "shareForFacebook() - " + activityNotFoundException0);
            ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
        }
        return H.a;
    }
}

