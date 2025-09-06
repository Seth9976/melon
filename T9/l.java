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
import kotlinx.coroutines.CoroutineScope;
import oe.i;
import we.n;

public final class l extends i implements n {
    public final String B;
    public final Context r;
    public final String w;

    public l(Context context0, String s, String s1, Continuation continuation0) {
        this.r = context0;
        this.w = s;
        this.B = s1;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        return new l(this.r, this.w, this.B, continuation0);
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((l)this.create(((CoroutineScope)object0), ((Continuation)object1))).invokeSuspend(H.a);
        return H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        d5.n.D(object0);
        File file0 = new File(this.w);
        Uri uri0 = FileUtils.getFileUri(this.r, file0);
        File file1 = new File(this.B);
        Uri uri1 = FileUtils.getFileUri(this.r, file1);
        q.f("4022717807957185", "getString(...)");
        Intent intent0 = new Intent("com.facebook.stories.ADD_TO_STORY");
        intent0.setFlags(1);
        intent0.addFlags(0x10000000);
        intent0.setDataAndType(uri0, "image/png");
        intent0.putExtra("com.facebook.platform.extra.APPLICATION_ID", "4022717807957185");
        intent0.putExtra("interactive_asset_uri", uri1);
        this.r.grantUriPermission("com.facebook.katana", uri0, 1);
        this.r.grantUriPermission("com.facebook.katana", uri1, 1);
        try {
            this.r.startActivity(intent0);
        }
        catch(ActivityNotFoundException activityNotFoundException0) {
            LogU.Companion.w("FacebookStory", "shareForFacebook() - " + activityNotFoundException0);
            ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
        }
        return H.a;
    }
}

