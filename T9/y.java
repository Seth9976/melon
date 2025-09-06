package t9;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.iloen.melon.utils.FileUtils;
import ie.H;
import java.io.File;
import kotlin.coroutines.Continuation;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.i;
import we.n;

public final class y extends i implements n {
    public final Uri B;
    public final int D;
    public final z E;
    public int r;
    public final Context w;

    public y(Context context0, Uri uri0, int v, z z0, Continuation continuation0) {
        this.w = context0;
        this.B = uri0;
        this.D = v;
        this.E = z0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new y(this.w, this.B, this.D, this.E, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        return ((y)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        a a0 = a.a;
        Context context0 = this.w;
        switch(this.r) {
            case 0: {
                d5.n.D(object0);
                Deferred deferred0 = BuildersKt__Builders_commonKt.async$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new x(context0, this.D, this.E, null), 3, null);
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
        Intent intent0 = new Intent("com.instagram.share.ADD_TO_STORY");
        intent0.setFlags(1);
        intent0.addFlags(0x10000000);
        intent0.setDataAndType(uri0, "image/png");
        intent0.putExtra("interactive_asset_uri", this.B);
        context0.grantUriPermission("com.instagram.android", uri0, 1);
        context0.grantUriPermission("com.instagram.android", this.B, 1);
        context0.startActivity(intent0);
        return H.a;
    }
}

