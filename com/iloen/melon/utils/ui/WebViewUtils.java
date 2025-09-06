package com.iloen.melon.utils.ui;

import Ma.c;
import android.app.Activity;
import android.content.Context;
import com.google.firebase.b;
import com.iloen.melon.playback.playlist.add.AddAction.AddPlay;
import com.iloen.melon.playback.playlist.add.AddServerContent;
import com.iloen.melon.playback.playlist.add.AddToPlaylistUIHelperKt;
import com.iloen.melon.playback.playlist.add.PlayDataForSeverContent.MixUp;
import com.iloen.melon.utils.log.LogU;
import ie.H;
import ie.o;
import ie.p;
import k8.a;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.jetbrains.annotations.NotNull;
import pc.p1;
import we.n;

@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u0000 \u00042\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/iloen/melon/utils/ui/WebViewUtils;", "", "<init>", "()V", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class WebViewUtils {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001J\'\u0010\b\u001A\u00020\u00072\u0006\u0010\u0003\u001A\u00020\u00022\u0006\u0010\u0005\u001A\u00020\u00042\u0006\u0010\u0006\u001A\u00020\u0004H\u0007¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"Lcom/iloen/melon/utils/ui/WebViewUtils$Companion;", "", "Landroid/app/Activity;", "activity", "", "menuId", "cId", "Lie/H;", "playMixUpPlaylist", "(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        public final void playMixUpPlaylist(@NotNull Activity activity0, @NotNull String s, @NotNull String s1) {
            q.g(activity0, "activity");
            q.g(s, "menuId");
            q.g(s1, "cId");
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new n(s1, s, null) {
                public final String B;
                public final String D;
                public Object r;
                public final Activity w;

                {
                    this.w = activity0;
                    this.B = s;
                    this.D = s1;
                    super(2, continuation0);
                }

                @Override  // oe.a
                public final Continuation create(Object object0, Continuation continuation0) {
                    Continuation continuation1 = new com.iloen.melon.utils.ui.WebViewUtils.Companion.playMixUpPlaylist.1(this.w, this.B, this.D, continuation0);
                    continuation1.r = object0;
                    return continuation1;
                }

                @Override  // we.n
                public Object invoke(Object object0, Object object1) {
                    return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
                }

                public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                    return ((com.iloen.melon.utils.ui.WebViewUtils.Companion.playMixUpPlaylist.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
                }

                @Override  // oe.a
                public final Object invokeSuspend(Object object0) {
                    o o0;
                    H h0 = H.a;
                    CoroutineScope coroutineScope0 = (CoroutineScope)this.r;
                    d5.n.D(object0);
                    try {
                        Context context0 = this.w.getApplicationContext();
                        q.f(context0, "getApplicationContext(...)");
                        a a0 = ((k8.o)(((c)b.B(context0, c.class)))).d();
                        p1 p10 = new p1(this.B, this.D, null);
                        AddServerContent addServerContent0 = new AddServerContent(new AddPlay(false), false, false, a0, new MixUp(p10, this.D, null));
                        AddToPlaylistUIHelperKt.addPlaylistAndReturnAction$default(this.w, addServerContent0, false, 2, null);
                        o0 = h0;
                    }
                    catch(Throwable throwable0) {
                        o0 = d5.n.t(throwable0);
                    }
                    Throwable throwable1 = p.a(o0);
                    if(throwable1 != null) {
                        LogU.Companion.e("WebViewUtils", "playMixUpPlaylist error", throwable1);
                    }
                    return h0;
                }
            }, 3, null);
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;

    static {
        WebViewUtils.Companion = new Companion(null);
    }

    public static final void playMixUpPlaylist(@NotNull Activity activity0, @NotNull String s, @NotNull String s1) {
        WebViewUtils.Companion.playMixUpPlaylist(activity0, s, s1);
    }
}

