package b9;

import E9.w;
import Ma.g;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.I;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;
import com.kakao.emoticon.interfaces.EmoticonClickListener;
import com.kakao.emoticon.ui.PopupEmoticonFragment;
import k8.Y;
import k8.o;
import k8.t;
import kb.D;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import mb.f;
import mb.k;
import mb.l;

public final class d {
    public final LogU a;
    public final k b;
    public final f c;
    public final D d;
    public I e;
    public PopupEmoticonFragment f;
    public boolean g;
    public static d h;

    public d() {
        this.a = new LogU("KakaoEmoticonPopupManager");
        this.b = (k)((o)(((g)Y.f(MelonAppBase.Companion, g.class)))).m.get();
        this.c = ((o)(((g)w.s(t.a().getContext(), g.class)))).f();
        this.d = new D(((l)((o)(((g)w.s(t.a().getContext(), g.class)))).j.get()));
        this.g = true;
    }

    public final void a() {
        if(this.f != null) {
            I i0 = this.e;
            if(i0 != null) {
                FragmentActivity fragmentActivity0 = i0.getActivity();
                if(fragmentActivity0 != null && !fragmentActivity0.isFinishing()) {
                    I i1 = this.e;
                    q.d(i1);
                    if(i1.isAdded()) {
                        PopupEmoticonFragment popupEmoticonFragment0 = this.f;
                        if(popupEmoticonFragment0 != null) {
                            popupEmoticonFragment0.dismiss();
                        }
                    }
                }
            }
        }
    }

    public final void b(EmoticonClickListener emoticonClickListener0) {
        q.g(emoticonClickListener0, "emoticonClickListener");
        if(this.g) {
            this.g = false;
            I i0 = this.e;
            if(i0 != null) {
                BuildersKt__Builders_commonKt.launch$default(f0.f(i0), null, null, new b(this, emoticonClickListener0, null), 3, null);
            }
        }
    }
}

