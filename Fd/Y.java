package Fd;

import A0.c;
import J8.N2;
import android.view.inputmethod.InputMethodManager;
import androidx.fragment.app.a;
import androidx.fragment.app.l0;
import com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchHotKeywordInnerFragment;
import com.iloen.melon.fragments.webview.MelonWebViewExtensionFragment.SearchKeywordInnerFragment;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.H;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Job.DefaultImpls;
import kotlinx.coroutines.Job;
import oe.i;
import we.n;

public final class y extends i implements n {
    public final D B;
    public final H D;
    public final H E;
    public final H G;
    public final CoroutineScope I;
    public Object r;
    public final N2 w;

    public y(N2 n20, D d0, H h0, H h1, H h2, CoroutineScope coroutineScope0, Continuation continuation0) {
        this.w = n20;
        this.B = d0;
        this.D = h0;
        this.E = h1;
        this.G = h2;
        this.I = coroutineScope0;
        super(2, continuation0);
    }

    @Override  // oe.a
    public final Continuation create(Object object0, Continuation continuation0) {
        Continuation continuation1 = new y(this.w, this.B, this.D, this.E, this.G, this.I, continuation0);
        continuation1.r = object0;
        return continuation1;
    }

    @Override  // we.n
    public final Object invoke(Object object0, Object object1) {
        ((y)this.create(((e0)object0), ((Continuation)object1))).invokeSuspend(ie.H.a);
        return ie.H.a;
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        SearchHotKeywordInnerFragment melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0;
        e0 e00 = (e0)this.r;
        d5.n.D(object0);
        ie.H h0 = ie.H.a;
        N2 n20 = this.w;
        if(e00 == null) {
            n20.d.setVisibility(8);
            return h0;
        }
        String s = e00.a;
        if(s.length() > 0) {
            H h1 = this.D;
            String s1 = (String)h1.a;
            H h2 = this.E;
            String s2 = (String)h2.a;
            boolean z = e00.c;
            D d0 = this.B;
            N2 n21 = (N2)d0.getBinding();
            if(n21 != null) {
                ((InputMethodManager)d0.d.getValue()).hideSoftInputFromWindow(n21.e.getWindowToken(), 0);
                if(z) {
                    c c0 = ((Y)d0.getViewModel()).q;
                    melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0 = SearchHotKeywordInnerFragment.Companion.newInstance(s, s1, s2, c0);
                }
                else {
                    c c1 = ((Y)d0.getViewModel()).q;
                    melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0 = SearchKeywordInnerFragment.Companion.newInstance(s, s1, s2, c1);
                }
                l0 l00 = d0.getChildFragmentManager();
                a a0 = com.iloen.melon.utils.a.f(l00, "getChildFragmentManager(...)", l00);
                a0.g(n21.d.getId(), melonWebViewExtensionFragment$SearchHotKeywordInnerFragment0, null);
                a0.k();
            }
            h1.a = null;
            h2.a = null;
        }
        H h3 = this.G;
        Job job0 = (Job)h3.a;
        if(job0 != null) {
            DefaultImpls.cancel$default(job0, null, 1, null);
        }
        x x0 = new x(e00, n20, null);
        h3.a = BuildersKt__Builders_commonKt.launch$default(this.I, null, null, x0, 3, null);
        return h0;
    }
}

