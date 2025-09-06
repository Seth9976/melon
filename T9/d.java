package t9;

import com.iloen.melon.MelonAppBase;
import com.iloen.melon.sns.model.Sharable;
import com.iloen.melon.sns.target.SnsManager.PostParam;
import com.iloen.melon.sns.target.SnsPostListener;
import com.iloen.melon.sns.target.SnsTarget;
import com.iloen.melon.utils.system.AppUtils;
import com.iloen.melon.utils.system.ToastManager;
import k8.t;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineExceptionHandler;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

public final class d implements SnsTarget {
    public SnsPostListener a;
    public Sharable b;
    public final c c;

    public d() {
        this.c = new c(CoroutineExceptionHandler.Key, this);
    }

    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final void a(SnsManager.PostParam snsManager$PostParam0, SnsPostListener snsPostListener0) {
        this.a = snsPostListener0;
        this.b = snsManager$PostParam0.c;
        MelonAppBase.Companion.getClass();
        if(AppUtils.checkExistApplication(t.a().getContext(), "com.facebook.katana")) {
            CoroutineScope coroutineScope0 = CoroutineScopeKt.CoroutineScope(Dispatchers.getIO());
            b b0 = new b(snsManager$PostParam0, this, null);
            BuildersKt__Builders_commonKt.launch$default(coroutineScope0, this.c, null, b0, 2, null);
            return;
        }
        ToastManager.show(0x7F13106A);  // string:toast_message_facebook_need_install "페이스북이 설치되어 있지 않습니다."
    }

    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final boolean b() {
        return true;
    }

    @Override  // com.iloen.melon.sns.target.SnsTarget
    public final String getId() {
        return "facebook";
    }
}

