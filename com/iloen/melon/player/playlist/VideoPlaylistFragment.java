package com.iloen.melon.player.playlist;

import De.I;
import J8.g3;
import J8.k2;
import J8.x;
import Ld.v;
import M6.B;
import Qb.z;
import Tf.o;
import android.content.Context;
import android.os.Bundle;
import android.util.Range;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.D;
import androidx.lifecycle.f0;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.O0;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.j0;
import androidx.recyclerview.widget.w0;
import com.airbnb.lottie.LottieAnimationView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.iloen.melon.adapters.common.p;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.MetaContentBaseFragment;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.playlist.PlaylistId;
import com.iloen.melon.player.video.SingleTopStack;
import com.iloen.melon.utils.StringUtils;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.Category;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.playlist.interfaces.PlayableData;
import d3.g;
import d5.n;
import e.k;
import e1.m;
import ie.r;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kc.O2;
import kc.d3;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.guava.ListenableFutureKt;
import ne.a;
import oc.H;
import oc.w;
import oe.c;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import v9.h;
import v9.i;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 12\u00020\u00012\u00020\u0002:\u000221B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\u000F\u0010\u0006\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u0006\u0010\u0007J\u000F\u0010\b\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\b\u0010\u0007J\u000F\u0010\t\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\t\u0010\u0007J\u000F\u0010\n\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\n\u0010\u0007J\u000F\u0010\u000B\u001A\u00020\u0005H\u0016¢\u0006\u0004\b\u000B\u0010\u0007J\u000F\u0010\r\u001A\u00020\fH\u0014¢\u0006\u0004\b\r\u0010\u000EJ+\u0010\u0016\u001A\u00020\u00152\u0006\u0010\u0010\u001A\u00020\u000F2\b\u0010\u0012\u001A\u0004\u0018\u00010\u00112\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J!\u0010\u001A\u001A\u00020\u00192\u0006\u0010\u0018\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u0013H\u0016¢\u0006\u0004\b\u001A\u0010\u001BJ\u000F\u0010\u001C\u001A\u00020\u0019H\u0016¢\u0006\u0004\b\u001C\u0010\u0004J-\u0010#\u001A\u00020\u00052\b\u0010\u001E\u001A\u0004\u0018\u00010\u001D2\b\u0010 \u001A\u0004\u0018\u00010\u001F2\b\u0010\"\u001A\u0004\u0018\u00010!H\u0014¢\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0014¢\u0006\u0004\b&\u0010\'J\u001B\u0010+\u001A\u0006\u0012\u0002\b\u00030*2\u0006\u0010)\u001A\u00020(H\u0014¢\u0006\u0004\b+\u0010,J\u000F\u0010-\u001A\u00020\u0005H\u0016¢\u0006\u0004\b-\u0010\u0007J\u0017\u0010/\u001A\u00020\u00192\u0006\u0010.\u001A\u00020\u0013H\u0014¢\u0006\u0004\b/\u00100¨\u00063"}, d2 = {"Lcom/iloen/melon/player/playlist/VideoPlaylistFragment;", "Lcom/iloen/melon/fragments/MetaContentBaseFragment;", "Lcom/iloen/melon/player/video/SingleTopStack;", "<init>", "()V", "", "shouldIgnoreSetUIOnForegroundEvent", "()Z", "shouldIgnoreSetOrientation", "shouldShowMiniPlayer", "isPlaylistFragment", "isPlayerFragment", "Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "getPvDummyLogRequest", "()Lcom/iloen/melon/net/v4x/request/PvLogDummyReq;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "Lie/H;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "onDestroyView", "Lv9/i;", "type", "Lv9/h;", "param", "", "reason", "onFetchStart", "(Lv9/i;Lv9/h;Ljava/lang/String;)Z", "Landroidx/recyclerview/widget/RecyclerView;", "onCreateRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "Landroid/content/Context;", "context", "Landroidx/recyclerview/widget/j0;", "createRecyclerViewAdapter", "(Landroid/content/Context;)Landroidx/recyclerview/widget/j0;", "shouldOnResume", "inState", "onRestoreInstanceState", "(Landroid/os/Bundle;)V", "Companion", "VideoPlaylistAdapter", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class VideoPlaylistFragment extends MetaContentBaseFragment implements SingleTopStack {
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001J\u000F\u0010\u0003\u001A\u00020\u0002H\u0007¢\u0006\u0004\b\u0003\u0010\u0004R\u0014\u0010\u0006\u001A\u00020\u00058\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0006\u0010\u0007R\u0014\u0010\t\u001A\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000B\u001A\u00020\b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000B\u0010\n¨\u0006\f"}, d2 = {"Lcom/iloen/melon/player/playlist/VideoPlaylistFragment$Companion;", "", "Lcom/iloen/melon/player/playlist/VideoPlaylistFragment;", "newInstance", "()Lcom/iloen/melon/player/playlist/VideoPlaylistFragment;", "", "TAG", "Ljava/lang/String;", "", "TALKBACK_ACTION_DEFAULT", "I", "PAYLOAD_PLAYING_EVENT", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final VideoPlaylistFragment newInstance() {
            return new VideoPlaylistFragment();
        }
    }

    @Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u000E\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001DB\u001F\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u000E\u0010\u0007\u001A\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0006¢\u0006\u0004\b\b\u0010\tJ\u001F\u0010\r\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000EJ!\u0010\u0012\u001A\u00020\u00032\b\u0010\u0010\u001A\u0004\u0018\u00010\u000F2\u0006\u0010\u0011\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0012\u0010\u0013J)\u0010\u0016\u001A\u00020\u00152\b\u0010\u0014\u001A\u0004\u0018\u00010\u00032\u0006\u0010\u000B\u001A\u00020\n2\u0006\u0010\f\u001A\u00020\nH\u0016¢\u0006\u0004\b\u0016\u0010\u0017J-\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u0018\u001A\u00020\u00032\u0006\u0010\f\u001A\u00020\n2\f\u0010\u001A\u001A\b\u0012\u0004\u0012\u00020\u00190\u0006H\u0016¢\u0006\u0004\b\u001B\u0010\u001C¨\u0006\u001E"}, d2 = {"Lcom/iloen/melon/player/playlist/VideoPlaylistFragment$VideoPlaylistAdapter;", "Lcom/iloen/melon/adapters/common/p;", "Lcom/melon/playlist/interfaces/PlayableData;", "Landroidx/recyclerview/widget/O0;", "Landroid/content/Context;", "context", "", "playable", "<init>", "(Lcom/iloen/melon/player/playlist/VideoPlaylistFragment;Landroid/content/Context;Ljava/util/List;)V", "", "rawPosition", "position", "getItemViewTypeImpl", "(II)I", "Landroid/view/ViewGroup;", "parent", "viewType", "onCreateViewHolderImpl", "(Landroid/view/ViewGroup;I)Landroidx/recyclerview/widget/O0;", "viewHolder", "Lie/H;", "onBindViewImpl", "(Landroidx/recyclerview/widget/O0;II)V", "holder", "", "payloads", "onBindViewHolder", "(Landroidx/recyclerview/widget/O0;ILjava/util/List;)V", "MvItemViewHolder", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    final class VideoPlaylistAdapter extends p {
        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u001D\u0010\u000B\u001A\u00020\n2\u0006\u0010\u0007\u001A\u00020\u00062\u0006\u0010\t\u001A\u00020\b¢\u0006\u0004\b\u000B\u0010\fR\u0017\u0010\u0003\u001A\u00020\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u000E\u001A\u0004\b\u000F\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/player/playlist/VideoPlaylistFragment$VideoPlaylistAdapter$MvItemViewHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/k2;", "binding", "<init>", "(Lcom/iloen/melon/player/playlist/VideoPlaylistFragment$VideoPlaylistAdapter;LJ8/k2;)V", "Lcom/melon/playlist/interfaces/PlayableData;", "playableData", "", "position", "Lie/H;", "bindItem", "(Lcom/melon/playlist/interfaces/PlayableData;I)V", "a", "LJ8/k2;", "getBinding", "()LJ8/k2;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
        final class MvItemViewHolder extends O0 {
            public final k2 a;
            public final VideoPlaylistAdapter b;
            public static final int c;

            public MvItemViewHolder(@NotNull k2 k20) {
                q.g(k20, "binding");
                this.b = videoPlaylistFragment$VideoPlaylistAdapter0;
                super(k20.a);
                this.a = k20;
            }

            public final void bindItem(@NotNull PlayableData playableData0, int v) {
                q.g(playableData0, "playableData");
                Playable playable0 = playableData0.a;
                VideoPlaylistAdapter videoPlaylistFragment$VideoPlaylistAdapter0 = this.b;
                RequestBuilder requestBuilder0 = Glide.with(videoPlaylistFragment$VideoPlaylistAdapter0.getContext()).load(playableData0.m);
                k2 k20 = this.a;
                MelonTextView melonTextView0 = k20.h;
                g3 g30 = k20.g;
                MelonImageView melonImageView0 = k20.e;
                ConstraintLayout constraintLayout0 = k20.a;
                LottieAnimationView lottieAnimationView0 = k20.d;
                MelonTextView melonTextView1 = k20.f;
                requestBuilder0.into(k20.g.c);
                melonTextView1.setText("");
                o.H0("");
                k20.b.setText("");
                VideoPlaylistFragment videoPlaylistFragment0 = videoPlaylistFragment$VideoPlaylistAdapter0.b;
                constraintLayout0.setAccessibilityDelegate(new View.AccessibilityDelegate() {
                    @Override  // android.view.View$AccessibilityDelegate
                    public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                        int v;
                        q.g(view0, "host");
                        q.g(accessibilityNodeInfo0, "info");
                        super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                        VideoPlaylistFragment videoPlaylistFragment0 = v;
                        H h0 = VideoPlaylistFragment.access$getVodPlaylist(videoPlaylistFragment0);
                        if(h0 == null) {
                            return;
                        }
                        if(h0.getState().b() != "") {
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000000, videoPlaylistFragment0.getString(0x7F13027B)));  // string:ctx_menu_playback "재생"
                            v = 0x7F130BE8;  // string:talkback_playlist_item "%1$s, %2$s, 재생"
                        }
                        else if(VideoPlaylistFragment.access$isPlaying(videoPlaylistFragment0)) {
                            v = 0x7F130BF6;  // string:talkback_playlist_playing_item "재생중, %1$s, %2$s"
                        }
                        else {
                            accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000000, videoPlaylistFragment0.getString(0x7F13027B)));  // string:ctx_menu_playback "재생"
                            v = 0x7F130BF5;  // string:talkback_playlist_paused_item "일시정지됨, %1$s, %2$s, 재생"
                        }
                        String s = videoPlaylistFragment0.getString(v);
                        q.f(s, "getString(...)");
                        accessibilityNodeInfo0.setContentDescription(String.format(s, Arrays.copyOf(new Object[]{"", this}, 2)));
                        accessibilityNodeInfo0.setClassName("android.widget.Button");
                    }

                    @Override  // android.view.View$AccessibilityDelegate
                    public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                        q.g(view0, "host");
                        if(v == 100000000) {
                            this.e.getBinding().a.performClick();
                            return true;
                        }
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                });
                boolean z = true;
                ViewUtils.hideWhen(melonImageView0, true);
                ViewUtils.hideWhen(lottieAnimationView0, true);
                H h0 = VideoPlaylistFragment.access$getVodPlaylist(videoPlaylistFragment0);
                if(h0 == null) {
                    return;
                }
                int v1 = h0.getState().b();
                if(v1 == v) {
                    ViewUtils.showWhen(melonImageView0, true);
                    ViewUtils.showWhen(lottieAnimationView0, true);
                    if(VideoPlaylistFragment.access$isPlaying(videoPlaylistFragment0)) {
                        lottieAnimationView0.playAnimation();
                    }
                    else {
                        lottieAnimationView0.cancelAnimation();
                    }
                }
                if(v1 == v) {
                    melonTextView1.setTextColor(ColorUtils.getColor(videoPlaylistFragment$VideoPlaylistAdapter0.getContext(), 0x7F06017C));  // color:green500s_support_high_contrast
                    ViewUtils.hideWhen(g30.d, true);
                }
                else {
                    melonTextView1.setTextColor(ColorUtils.getColor(videoPlaylistFragment$VideoPlaylistAdapter0.getContext(), 0x7F06016D));  // color:gray900s
                    ViewUtils.showWhen(g30.d, true);
                }
                ViewUtils.setTextViewMarquee(melonTextView1, videoPlaylistFragment$VideoPlaylistAdapter0.isMarqueeNeeded(v));
                long v2 = playable0.getOriginalDuration();
                if(v2 <= 0L) {
                    z = false;
                }
                ViewUtils.showWhen(melonTextView0, z);
                ViewUtils.setText(melonTextView0, StringUtils.INSTANCE.formatPlayerDurationTime(v2));
                boolean z1 = playable0.isAdult();
                ViewUtils.showWhen(k20.c, z1);
                ViewUtils.setOnClickListener(constraintLayout0, new com.iloen.melon.player.playlist.q(videoPlaylistFragment0, v, playable0));
            }

            @NotNull
            public final k2 getBinding() {
                return this.a;
            }
        }

        public final int a;
        public final VideoPlaylistFragment b;

        public VideoPlaylistAdapter(@NotNull Context context0, @Nullable List list0) {
            q.g(context0, "context");
            this.b = videoPlaylistFragment0;
            super(context0, list0);
            this.a = 1;
        }

        @Override  // com.iloen.melon.adapters.common.p
        public int getItemViewTypeImpl(int v, int v1) {
            return this.a;
        }

        @Override  // androidx.recyclerview.widget.j0
        public void onBindViewHolder(@NotNull O0 o00, int v, @NotNull List list0) {
            q.g(o00, "holder");
            q.g(list0, "payloads");
            if(list0.isEmpty()) {
                super.onBindViewHolder(o00, v, list0);
                return;
            }
            for(Object object0: list0) {
                if(!q.b(object0, 1) || !(o00 instanceof MvItemViewHolder)) {
                }
                else if(VideoPlaylistFragment.access$isPlaying(this.b)) {
                    ((MvItemViewHolder)o00).getBinding().d.playAnimation();
                }
                else {
                    ((MvItemViewHolder)o00).getBinding().d.cancelAnimation();
                }
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        public void onBindViewImpl(@Nullable O0 o00, int v, int v1) {
            if(o00 instanceof MvItemViewHolder) {
                PlayableData playableData0 = (PlayableData)this.getItem(v1);
                q.d(playableData0);
                ((MvItemViewHolder)o00).bindItem(playableData0, v1);
            }
        }

        @Override  // com.iloen.melon.adapters.common.p
        @NotNull
        public O0 onCreateViewHolderImpl(@Nullable ViewGroup viewGroup0, int v) {
            View view0 = this.b.getLayoutInflater().inflate(0x7F0D04BC, viewGroup0, false);  // layout:listitem_video_new
            int v1 = 0x7F0A00C2;  // id:artist_tv
            View view1 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
            if(((MelonTextView)view1) != null) {
                v1 = 0x7F0A0633;  // id:iv_grade
                View view2 = I.C(view0, 0x7F0A0633);  // id:iv_grade
                if(((ImageView)view2) != null) {
                    v1 = 0x7F0A0658;  // id:iv_now_playing
                    View view3 = I.C(view0, 0x7F0A0658);  // id:iv_now_playing
                    if(((LottieAnimationView)view3) != null) {
                        v1 = 0x7F0A0659;  // id:iv_now_playing_bg
                        View view4 = I.C(view0, 0x7F0A0659);  // id:iv_now_playing_bg
                        if(((MelonImageView)view4) != null) {
                            v1 = 0x7F0A0890;  // id:mv_title
                            View view5 = I.C(view0, 0x7F0A0890);  // id:mv_title
                            if(((MelonTextView)view5) != null) {
                                v1 = 0x7F0A0B72;  // id:thumb_container
                                View view6 = I.C(view0, 0x7F0A0B72);  // id:thumb_container
                                if(view6 != null) {
                                    int v2 = 0x7F0A069A;  // id:iv_thumb
                                    MelonImageView melonImageView0 = (MelonImageView)I.C(view6, 0x7F0A069A);  // id:iv_thumb
                                    if(melonImageView0 == null || ((ImageView)I.C(view6, 0x7F0A069E)) == null || ((ImageView)I.C(view6, 0x7F0A06A4)) == null) {  // id:iv_thumb_default
                                        throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v2));
                                    }
                                    v2 = 0x7F0A0D96;  // id:v_bottom_gradient
                                    View view7 = I.C(view6, 0x7F0A0D96);  // id:v_bottom_gradient
                                    if(view7 == null) {
                                        throw new NullPointerException("Missing required view with ID: " + view6.getResources().getResourceName(v2));
                                    }
                                    g3 g30 = new g3(((FrameLayout)view6), melonImageView0, view7, 0);
                                    v1 = 0x7F0A0CE5;  // id:tv_playtime
                                    View view8 = I.C(view0, 0x7F0A0CE5);  // id:tv_playtime
                                    if(((MelonTextView)view8) != null && ((FrameLayout)I.C(view0, 0x7F0A0DB9)) != null) {  // id:video_thumbnail
                                        return new MvItemViewHolder(this, new k2(((ConstraintLayout)view0), ((MelonTextView)view1), ((ImageView)view2), ((LottieAnimationView)view3), ((MelonImageView)view4), ((MelonTextView)view5), g30, ((MelonTextView)view8)));
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v1));
        }
    }

    public static final int $stable;
    @NotNull
    public static final Companion Companion;
    public final LogU a;
    public x b;
    public final r c;
    public final r d;
    public final r e;
    public final r f;

    static {
        VideoPlaylistFragment.Companion = new Companion(null);
        VideoPlaylistFragment.$stable = 8;
    }

    public VideoPlaylistFragment() {
        this.a = com.iloen.melon.utils.log.LogU.Companion.create$default(LogU.Companion, "VideoPlaylistFragment", false, Category.UI, 2, null);
        this.c = g.Q(new com.iloen.melon.player.playlist.o(this, 0));
        this.d = g.Q(new com.iloen.melon.player.playlist.o(this, 2));
        this.e = g.Q(new com.iloen.melon.player.playlist.o(this, 3));
        this.f = g.Q(new com.iloen.melon.player.playlist.o(this, 4));
    }

    public static final LogU access$getLog$p(VideoPlaylistFragment videoPlaylistFragment0) {
        return videoPlaylistFragment0.a;
    }

    public static final Ub.q access$getPlaybackManager(VideoPlaylistFragment videoPlaylistFragment0) {
        return (Ub.q)videoPlaylistFragment0.d.getValue();
    }

    public static final z access$getPlayerController(VideoPlaylistFragment videoPlaylistFragment0) {
        return (z)videoPlaylistFragment0.e.getValue();
    }

    public static final ob.z access$getPlayerUseCase(VideoPlaylistFragment videoPlaylistFragment0) {
        return (ob.z)videoPlaylistFragment0.f.getValue();
    }

    public static final H access$getVodPlaylist(VideoPlaylistFragment videoPlaylistFragment0) {
        return ((d3)videoPlaylistFragment0.playlistManager).q(PlaylistId.VOD);
    }

    public static final Object access$handlePlaybackEvent(VideoPlaylistFragment videoPlaylistFragment0, boolean z, Continuation continuation0) {
        VideoPlaylistFragment.handlePlaybackEvent.1 videoPlaylistFragment$handlePlaybackEvent$10;
        videoPlaylistFragment0.getClass();
        if(continuation0 instanceof VideoPlaylistFragment.handlePlaybackEvent.1) {
            videoPlaylistFragment$handlePlaybackEvent$10 = (VideoPlaylistFragment.handlePlaybackEvent.1)continuation0;
            int v = videoPlaylistFragment$handlePlaybackEvent$10.B;
            if((v & 0x80000000) == 0) {
                videoPlaylistFragment$handlePlaybackEvent$10 = new VideoPlaylistFragment.handlePlaybackEvent.1(videoPlaylistFragment0, continuation0);
            }
            else {
                videoPlaylistFragment$handlePlaybackEvent$10.B = v ^ 0x80000000;
            }
        }
        else {
            videoPlaylistFragment$handlePlaybackEvent$10 = new VideoPlaylistFragment.handlePlaybackEvent.1(videoPlaylistFragment0, continuation0);
        }
        Object object0 = videoPlaylistFragment$handlePlaybackEvent$10.r;
        a a0 = a.a;
        switch(videoPlaylistFragment$handlePlaybackEvent$10.B) {
            case 0: {
                n.D(object0);
                B b0 = ((d3)videoPlaylistFragment0.playlistManager).g();
                videoPlaylistFragment$handlePlaybackEvent$10.B = 1;
                object0 = ListenableFutureKt.await(b0, videoPlaylistFragment$handlePlaybackEvent$10);
                if(object0 == a0) {
                    return a0;
                }
                break;
            }
            case 1: {
                n.D(object0);
                break;
            }
            default: {
                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
            }
        }
        int v1 = ((H)object0).getState().b();
        boolean z1 = new Range(new Integer(0), new Integer(videoPlaylistFragment0.getAdapter().getItemCount())).contains(new Integer(v1));
        ie.H h0 = ie.H.a;
        if(!z1) {
            return h0;
        }
        videoPlaylistFragment0.getAdapter().notifyItemChanged(v1, new Integer(1));
        return h0;
    }

    public static final void access$handlePlaylistState(VideoPlaylistFragment videoPlaylistFragment0, int v) {
        x x0 = videoPlaylistFragment0.b;
        q.d(x0);
        RecyclerView recyclerView0 = (RecyclerView)x0.d;
        w0 w00 = recyclerView0.getLayoutManager();
        LinearLayoutManager linearLayoutManager0 = w00 instanceof LinearLayoutManager ? ((LinearLayoutManager)w00) : null;
        if(linearLayoutManager0 == null) {
            return;
        }
        recyclerView0.getViewTreeObserver().addOnGlobalLayoutListener(new VideoPlaylistFragment.handlePlaylistState.1.1(recyclerView0, videoPlaylistFragment0, v, linearLayoutManager0));
    }

    public static final boolean access$isPlaying(VideoPlaylistFragment videoPlaylistFragment0) {
        return ((Ub.q)videoPlaylistFragment0.d.getValue()).a().b;
    }

    public static final void access$sendTiaraLog(VideoPlaylistFragment videoPlaylistFragment0, int v, String s, String s1) {
        w w0 = ((d3)videoPlaylistFragment0.playlistManager).q(PlaylistId.VOD);
        if(w0 != null) {
            Playable playable0 = k.p(w0);
            if(playable0 != null) {
                m.F(new v(videoPlaylistFragment0, v + 1, playable0, s, s1, 1)).track();
            }
        }
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public j0 createRecyclerViewAdapter(@NotNull Context context0) {
        q.g(context0, "context");
        return new VideoPlaylistAdapter(this, context0, null);
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    @NotNull
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "playlistVideo");
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isPlayerFragment() {
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isPlaylistFragment() {
        return true;
    }

    @NotNull
    public static final VideoPlaylistFragment newInstance() {
        return VideoPlaylistFragment.Companion.newInstance();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    @NotNull
    public RecyclerView onCreateRecyclerView() {
        x x0 = this.b;
        q.d(x0);
        q.f(((RecyclerView)x0.d), "recyclerView");
        LinearLayoutManager linearLayoutManager0 = new LinearLayoutManager(((RecyclerView)x0.d).getContext());
        ((RecyclerView)x0.d).setLayoutManager(linearLayoutManager0);
        ((RecyclerView)x0.d).setAdapter(this.mAdapter);
        ((RecyclerView)x0.d).setHasFixedSize(true);
        return (RecyclerView)x0.d;
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        View view0 = this.getLayoutInflater().inflate(0x7F0D08FB, viewGroup0, false);  // layout:video_playlist_new
        int v = 0x7F0A0613;  // id:iv_close
        ImageView imageView0 = (ImageView)I.C(view0, 0x7F0A0613);  // id:iv_close
        if(imageView0 != null) {
            v = 0x7F0A09D1;  // id:recycler_view
            RecyclerView recyclerView0 = (RecyclerView)I.C(view0, 0x7F0A09D1);  // id:recycler_view
            if(recyclerView0 != null && ((RelativeLayout)I.C(view0, 0x7F0A0B96)) != null && ((MelonTextView)I.C(view0, 0x7F0A0D34)) != null) {  // id:title_container
                this.b = new x(((RelativeLayout)view0), imageView0, recyclerView0, 10);
                q.f(((RelativeLayout)view0), "getRoot(...)");
                return (RelativeLayout)view0;
            }
        }
        throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onDestroyView() {
        super.onDestroyView();
        this.b = null;
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public boolean onFetchStart(@Nullable i i0, @Nullable h h0, @Nullable String s) {
        w w0 = ((d3)this.playlistManager).q(PlaylistId.VOD);
        if(w0 != null) {
            Collection collection0 = w0.getState().c();
            if(!collection0.isEmpty()) {
                j0 j00 = this.getAdapter();
                VideoPlaylistAdapter videoPlaylistFragment$VideoPlaylistAdapter0 = j00 instanceof VideoPlaylistAdapter ? ((VideoPlaylistAdapter)j00) : null;
                if(videoPlaylistFragment$VideoPlaylistAdapter0 != null) {
                    videoPlaylistFragment$VideoPlaylistAdapter0.clear();
                    videoPlaylistFragment$VideoPlaylistAdapter0.addAll(collection0);
                }
            }
        }
        return false;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public void onRestoreInstanceState(@NotNull Bundle bundle0) {
        q.g(bundle0, "inState");
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        D d0 = this.getViewLifecycleOwner();
        q.f(d0, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d0), null, null, new we.n(null) {
            public int r;
            public final VideoPlaylistFragment w;

            {
                this.w = videoPlaylistFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                a a0 = a.a;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                            @Override  // kotlinx.coroutines.flow.Flow
                            public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                                com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1.invokeSuspend..inlined.map.1.2 videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                                    @Override  // kotlinx.coroutines.flow.FlowCollector
                                    public final Object emit(Object object0, Continuation continuation0) {
                                        com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1.invokeSuspend..inlined.map.1.2.1 videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10;
                                        if(continuation0 instanceof com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1.invokeSuspend..inlined.map.1.2.1) {
                                            videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1.invokeSuspend..inlined.map.1.2.1)continuation0;
                                            int v = videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10.w;
                                            if((v & 0x80000000) == 0) {
                                                videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                    public Object r;
                                                    public int w;

                                                    @Override  // oe.a
                                                    public final Object invokeSuspend(Object object0) {
                                                        this.r = object0;
                                                        this.w |= 0x80000000;
                                                        return continuation0.emit(null, this);
                                                    }
                                                };
                                            }
                                            else {
                                                videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                            }
                                        }
                                        else {
                                            videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                                public Object r;
                                                public int w;

                                                @Override  // oe.a
                                                public final Object invokeSuspend(Object object0) {
                                                    this.r = object0;
                                                    this.w |= 0x80000000;
                                                    return continuation0.emit(null, this);
                                                }
                                            };
                                        }
                                        Object object1 = videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10.r;
                                        a a0 = a.a;
                                        switch(videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10.w) {
                                            case 0: {
                                                n.D(object1);
                                                videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                                return this.a.emit(Boolean.valueOf(((fc.a)object0).b), videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : ie.H.a;
                                            }
                                            case 1: {
                                                n.D(object1);
                                                return ie.H.a;
                                            }
                                            default: {
                                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                            }
                                        }
                                    }
                                };
                                Object object0 = this.a.collect(videoPlaylistFragment$onViewCreated$1$invokeSuspend$$inlined$map$1$20, continuation0);
                                return object0 == a.a ? object0 : ie.H.a;
                            }
                        });
                        com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.1.2 videoPlaylistFragment$onViewCreated$1$20 = new we.n(0, VideoPlaylistFragment.class, this.w, "handlePlaybackEvent", "handlePlaybackEvent(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;") {  // 初始化器: Lkotlin/jvm/internal/m;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                            @Override  // we.n
                            public Object invoke(Object object0, Object object1) {
                                return this.invoke(((Boolean)object0).booleanValue(), ((Continuation)object1));
                            }

                            public final Object invoke(boolean z, Continuation continuation0) {
                                return VideoPlaylistFragment.access$handlePlaybackEvent(((VideoPlaylistFragment)this.receiver), z, continuation0);
                            }
                        };
                        this.r = 1;
                        return FlowKt.collectLatest(flow0, videoPlaylistFragment$onViewCreated$1$20, this) == a0 ? a0 : ie.H.a;
                    }
                    case 1: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
            }
        }, 3, null);
        D d1 = this.getViewLifecycleOwner();
        q.f(d1, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(f0.f(d1), null, null, new we.n(null) {
            public int r;
            public final VideoPlaylistFragment w;

            {
                this.w = videoPlaylistFragment0;
                super(2, continuation0);
            }

            public static final Object access$invokeSuspend$handlePlaylistState(VideoPlaylistFragment videoPlaylistFragment0, int v, Continuation continuation0) {
                VideoPlaylistFragment.access$handlePlaylistState(videoPlaylistFragment0, v);
                return ie.H.a;
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2(this.w, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2)this.create(coroutineScope0, continuation0)).invokeSuspend(ie.H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Object object1;
                a a0 = a.a;
                VideoPlaylistFragment videoPlaylistFragment0 = this.w;
                switch(this.r) {
                    case 0: {
                        n.D(object0);
                        B b0 = ListenableFutureKt.future$default(((d3)videoPlaylistFragment0.playlistManager).b, null, null, new O2(((d3)videoPlaylistFragment0.playlistManager), null), 3, null);
                        this.r = 1;
                        object1 = ListenableFutureKt.await(b0, this);
                        if(object1 == a0) {
                            return a0;
                        }
                        break;
                    }
                    case 1: {
                        n.D(object0);
                        object1 = object0;
                        break;
                    }
                    case 2: {
                        n.D(object0);
                        return ie.H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                Flow flow0 = FlowKt.distinctUntilChanged(new Flow() {
                    @Override  // kotlinx.coroutines.flow.Flow
                    public Object collect(FlowCollector flowCollector0, Continuation continuation0) {
                        com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.invokeSuspend..inlined.map.1.2 videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$20 = new FlowCollector() {
                            @Override  // kotlinx.coroutines.flow.FlowCollector
                            public final Object emit(Object object0, Continuation continuation0) {
                                com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.invokeSuspend..inlined.map.1.2.1 videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10;
                                if(continuation0 instanceof com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.invokeSuspend..inlined.map.1.2.1) {
                                    videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10 = (com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.invokeSuspend..inlined.map.1.2.1)continuation0;
                                    int v = videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10.w;
                                    if((v & 0x80000000) == 0) {
                                        videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                            public Object r;
                                            public int w;

                                            @Override  // oe.a
                                            public final Object invokeSuspend(Object object0) {
                                                this.r = object0;
                                                this.w |= 0x80000000;
                                                return continuation0.emit(null, this);
                                            }
                                        };
                                    }
                                    else {
                                        videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10.w = v ^ 0x80000000;
                                    }
                                }
                                else {
                                    videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10 = new c(/*ERROR_MISSING_ARG_1/*) {
                                        public Object r;
                                        public int w;

                                        @Override  // oe.a
                                        public final Object invokeSuspend(Object object0) {
                                            this.r = object0;
                                            this.w |= 0x80000000;
                                            return continuation0.emit(null, this);
                                        }
                                    };
                                }
                                Object object1 = videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10.r;
                                a a0 = a.a;
                                switch(videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10.w) {
                                    case 0: {
                                        n.D(object1);
                                        videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10.w = 1;
                                        return this.a.emit(new Integer(((uc.B)object0).b), videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$2$10) == a0 ? a0 : ie.H.a;
                                    }
                                    case 1: {
                                        n.D(object1);
                                        return ie.H.a;
                                    }
                                    default: {
                                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                                    }
                                }
                            }
                        };
                        Object object0 = this.a.collect(videoPlaylistFragment$onViewCreated$2$invokeSuspend$$inlined$map$1$20, continuation0);
                        return object0 == a.a ? object0 : ie.H.a;
                    }
                });
                com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.2 videoPlaylistFragment$onViewCreated$2$20 = new we.n(4, VideoPlaylistFragment.class, videoPlaylistFragment0, "handlePlaylistState", "handlePlaylistState(I)V") {  // 初始化器: Lkotlin/jvm/internal/a;-><init>(IILjava/lang/Class;Ljava/lang/Object;Ljava/lang/String;Ljava/lang/String;)V
                    public final Object invoke(int v, Continuation continuation0) {
                        return com.iloen.melon.player.playlist.VideoPlaylistFragment.onViewCreated.2.access$invokeSuspend$handlePlaylistState(((VideoPlaylistFragment)this.receiver), v, continuation0);
                    }

                    @Override  // we.n
                    public Object invoke(Object object0, Object object1) {
                        return this.invoke(((Number)object0).intValue(), ((Continuation)object1));
                    }
                };
                this.r = 2;
                return FlowKt.collectLatest(flow0, videoPlaylistFragment$onViewCreated$2$20, this) == a0 ? a0 : ie.H.a;
            }
        }, 3, null);
        x x0 = this.b;
        q.d(x0);
        j j0 = new j(this, 3);
        ((ImageView)x0.c).setOnClickListener(j0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetOrientation() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldIgnoreSetUIOnForegroundEvent() {
        return true;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean shouldOnResume() {
        return ((d3)this.playlistManager).j() == PlaylistId.VOD;
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean shouldShowMiniPlayer() {
        return false;
    }
}

