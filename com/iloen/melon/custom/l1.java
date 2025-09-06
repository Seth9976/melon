package com.iloen.melon.custom;

import H0.e;
import M.c;
import android.content.Context;
import android.net.Uri.Builder;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.compose.foundation.layout.LayoutWeightElement;
import androidx.compose.runtime.p;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.adapters.common.a;
import com.iloen.melon.fragments.FetcherBaseFragment;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.comments.CommentListRenewalViewHolder;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.video.VideoLivePreviewFragment;
import com.iloen.melon.utils.ReentrantMutexContextKey;
import com.iloen.melon.utils.log.DevLog;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.melon.ui.c3;
import com.melon.ui.e3;
import i.n.i.b.a.s.e.M3;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.sync.Mutex;
import r0.n;
import u8.d;
import x1.j;
import x1.m;

public abstract class l1 {
    public static void A(String s, FetcherBaseFragment fetcherBaseFragment0, String s1) {
        LogU.w(s1, s + fetcherBaseFragment0);
    }

    public static void B(String s, boolean z, Companion logU$Companion0, String s1) {
        logU$Companion0.d(s1, s + z);
    }

    public static void C(StringBuilder stringBuilder0, String s, DevLog devLog0) {
        stringBuilder0.append(s);
        devLog0.put(stringBuilder0.toString());
    }

    public static void D(Object[] arr_object, int v, String s, MelonTextView melonTextView0) {
        melonTextView0.setText(String.format(s, Arrays.copyOf(arr_object, v)));
    }

    public static LayoutInflater a(ViewGroup viewGroup0, String s, OnViewHolderActionBaseListener onViewHolderActionBaseListener0, String s1) {
        q.g(viewGroup0, s);
        q.g(onViewHolderActionBaseListener0, s1);
        return LayoutInflater.from(viewGroup0.getContext());
    }

    public static ReentrantMutexContextKey b(String s, int v, String s1, DevLog devLog0, Mutex mutex0) {
        devLog0.put(s + v + s1);
        return new ReentrantMutexContextKey(mutex0);
    }

    public static M3 c(p p0, int v, boolean z) {
        p0.a0(v);
        p0.p(z);
        return new M3();  // 初始化器: Ljava/lang/RuntimeException;-><init>()V
    }

    public static Object d(VideoLivePreviewFragment videoLivePreviewFragment0) {
        return videoLivePreviewFragment0.L().getLiveRes().getValue();
    }

    public static String e(Uri.Builder uri$Builder0, String s, String s1) {
        String s2 = uri$Builder0.appendPath(s).build().toString();
        q.f(s2, s1);
        return s2;
    }

    public static String f(Uri.Builder uri$Builder0, String s, String s1, String s2) {
        String s3 = uri$Builder0.appendQueryParameter(s, s1).build().toString();
        q.f(s3, s2);
        return s3;
    }

    public static String g(Bundle bundle0, String s, String s1, String s2, String s3) {
        q.g(bundle0, s);
        String s4 = bundle0.getString(s1, s2);
        q.f(s4, s3);
        return s4;
    }

    public static String h(p p0, int v, int v1, p p1, boolean z) {
        p0.a0(v);
        String s = e.Y(p1, v1);
        p0.p(z);
        return s;
    }

    public static String i(CommentListRenewalViewHolder commentListRenewalViewHolder0, int v) {
        return commentListRenewalViewHolder0.getContext().getResources().getString(v);
    }

    public static String j(Playable playable0, String s, String s1) [...] // Inlined contents

    public static String k(String s, c3 c30, String s1) [...] // Inlined contents

    public static String l(String s, e3 e30, String s1) [...] // Inlined contents

    public static String m(String s, String s1, Context context0, int v, String s2) {
        q.f(s, s1);
        String s3 = context0.getString(v);
        q.f(s3, s2);
        return s3;
    }

    public static String n(String s, String s1, Playable playable0, String s2) {
        q.f(s, s1);
        String s3 = playable0.getArtistNames();
        q.f(s3, s2);
        return s3;
    }

    public static String o(String s, String s1, String s2, d d0) [...] // Inlined contents

    public static String p(String s, String s1, List list0) [...] // Inlined contents

    public static String q(StringBuilder stringBuilder0, int v, int v1) {
        return stringBuilder0.substring(v1, stringBuilder0.length() - v);
    }

    public static String r(ArrayList arrayList0, String s, String s1) [...] // Inlined contents

    public static String s(n n0, float f, p p0, int v, p p1) {
        c.d(p0, androidx.compose.foundation.layout.d.q(n0, f));
        return e.Y(p1, v);
    }

    public static StringBuilder t(String s, String s1, String s2, int v, Object object0) {
        StringBuilder stringBuilder0 = new StringBuilder(s);
        stringBuilder0.append(v);
        stringBuilder0.append(s1);
        stringBuilder0.append(object0);
        stringBuilder0.append(s2);
        return stringBuilder0;
    }

    public static j u(p p0) {
        j j0 = new j();
        p0.l0(j0);
        return j0;
    }

    public static m v(j j0, p p0) {
        m m0 = new m(j0);
        p0.l0(m0);
        return m0;
    }

    public static x1.q w(r1.c c0, p p0) {
        x1.q q0 = new x1.q(c0);
        p0.l0(q0);
        return q0;
    }

    public static void x(float f, boolean z, p p0) {
        c.d(p0, new LayoutWeightElement(f, z));
    }

    public static void y(p p0, boolean z, n n0, float f, p p1) {
        p0.p(z);
        c.d(p1, androidx.compose.foundation.layout.d.h(n0, f));
    }

    public static void z(a a0, ArrayList arrayList0) {
        arrayList0.add(new AdapterInViewHolder.Row(a0));
    }
}

