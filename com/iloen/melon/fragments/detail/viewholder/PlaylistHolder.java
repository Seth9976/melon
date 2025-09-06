package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.Q1;
import J8.R1;
import J8.e0;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonImageView;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PLAYLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.Arrays;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0017\u0018\u0000 \u001F2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001FB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u00020\u00152\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017J1\u0010\u001B\u001A\u00020\u00152\u0006\u0010\u0019\u001A\u00020\u00182\u0006\u0010\u001A\u001A\u00020\u00112\u0006\u0010\r\u001A\u00020\f2\b\u0010\u000B\u001A\u0004\u0018\u00010\u0004H\u0016¢\u0006\u0004\b\u001B\u0010\u001CR\u0016\u0010\u001D\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u001D\u0010\u001E¨\u0006 "}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;", "LJ8/e0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/e0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "position", "LJ8/R1;", "bindItem", "(Lcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;I)LJ8/R1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "Lcom/kakao/tiara/data/ActionKind;", "actionKind", "actionName", "itemClickLog", "(Lcom/kakao/tiara/data/ActionKind;Ljava/lang/String;ILcom/iloen/melon/net/v5x/response/DetailBaseRes$PLAYLIST;)V", "holderBind", "LJ8/e0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\n\u001A\u00020\u000B2\u0006\u0010\f\u001A\u00020\r2\u0006\u0010\u000E\u001A\u00020\u000FH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\t\u001A\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder$Companion;", "", "<init>", "()V", "TAG", "", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL", "TALKBACK_ACTION_PLAYBACK", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new PlaylistHolder(e0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistHolder";
    public static final int TALKBACK_ACTION_DEFAULT = 100000000;
    public static final int TALKBACK_ACTION_NAVIGATE_PLAYLIST_DETAIL = 100000001;
    public static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private e0 holderBind;

    static {
        PlaylistHolder.Companion = new Companion(null);
        PlaylistHolder.$stable = 8;
    }

    public PlaylistHolder(@NotNull e0 e00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(e00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(e00, onViewHolderActionBaseListener0);
        this.holderBind = e00;
        this.setTitleView(e00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void b(PlaylistHolder playlistHolder0, PLAYLIST detailBaseRes$PLAYLIST0, int v, View view0) {
        PlaylistHolder.bindItem$lambda$2(detailBaseRes$PLAYLIST0, playlistHolder0, v, view0);
    }

    private final R1 bindItem(PLAYLIST detailBaseRes$PLAYLIST0, int v) {
        String s1;
        String s = null;
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0481, null, false);  // layout:listitem_detail_playlist_common
        View view1 = I.C(view0, 0x7F0A05B7);  // id:item_layout
        if(view1 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A05B7));  // id:item_layout
        }
        Q1 q10 = Q1.a(view1);
        ImageView imageView0 = q10.f;
        R1 r10 = new R1(((FrameLayout)view0), q10);
        MelonImageView melonImageView0 = q10.d.b;
        if(detailBaseRes$PLAYLIST0 == null || (detailBaseRes$PLAYLIST0.thumbimg == null || detailBaseRes$PLAYLIST0.thumbimg.length() <= 0)) {
            s1 = detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.thumbImgUrl;
        }
        else {
            s1 = detailBaseRes$PLAYLIST0.thumbimg;
        }
        Glide.with(melonImageView0).load(s1).into(melonImageView0);
        q10.l.setText((detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.plylsttitle));
        MelonTextView melonTextView0 = q10.b;
        if(detailBaseRes$PLAYLIST0 != null && (detailBaseRes$PLAYLIST0.memberNickname != null && detailBaseRes$PLAYLIST0.memberNickname.length() > 0)) {
            s = detailBaseRes$PLAYLIST0.memberNickname;
        }
        else if(detailBaseRes$PLAYLIST0 != null) {
            s = detailBaseRes$PLAYLIST0.ownernickname;
        }
        melonTextView0.setText(s);
        ((FrameLayout)view0).setOnClickListener(new w(detailBaseRes$PLAYLIST0, this, v));
        imageView0.setOnClickListener(new w(this, detailBaseRes$PLAYLIST0, v));
        imageView0.setImportantForAccessibility(2);
        ((FrameLayout)view0).setAccessibilityDelegate(new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, detailBaseRes$PLAYLIST0.getString(0x7F130272)));  // string:ctx_menu_open_playlist "플레이리스트 열기"
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, detailBaseRes$PLAYLIST0.getString(0x7F13025F)));  // string:ctx_menu_listen "듣기"
                accessibilityNodeInfo0.setContentDescription(String.format(detailBaseRes$PLAYLIST0.getString(0x7F130BE1), Arrays.copyOf(new Object[]{(q10 == null ? null : q10.plylsttitle), v.b.getText()}, 2)));  // string:talkback_playlist_common_listitem_container "%1$s, 제작자: %2$s, 상세보기"
                accessibilityNodeInfo0.setHintText("3개중 " + (r10 + 1) + "번째");
                accessibilityNodeInfo0.setClassName("android.widget.Button");
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        this.$binding.a.performClick();
                        return true;
                    }
                    case 100000002: {
                        v.f.performClick();
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        });
        return r10;
    }

    private static final void bindItem$lambda$2(PLAYLIST detailBaseRes$PLAYLIST0, PlaylistHolder playlistHolder0, int v, View view0) {
        Navigator.openDjPlaylistDetail((detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.plylstseq));
        String s = playlistHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
        playlistHolder0.itemClickLog(ActionKind.ClickContent, s, v, detailBaseRes$PLAYLIST0);
    }

    private static final void bindItem$lambda$3(PlaylistHolder playlistHolder0, PLAYLIST detailBaseRes$PLAYLIST0, int v, View view0) {
        OnViewHolderActionBaseListener onViewHolderActionBaseListener0 = playlistHolder0.getOnViewHolderActionListener();
        String s = null;
        String s1 = detailBaseRes$PLAYLIST0 == null ? null : detailBaseRes$PLAYLIST0.plylstseq;
        if(detailBaseRes$PLAYLIST0 != null) {
            s = detailBaseRes$PLAYLIST0.contsTypeCode;
        }
        onViewHolderActionBaseListener0.onPlayDjPlaylistListener(s1, s);
        String s2 = playlistHolder0.getString(0x7F130DCB);  // string:tiara_common_action_name_play_music "음악재생"
        playlistHolder0.itemClickLog(ActionKind.PlayMusic, s2, v, detailBaseRes$PLAYLIST0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() [...] // 潜在的解密器

    public void itemClickLog(@NotNull ActionKind actionKind0, @NotNull String s, int v, @Nullable PLAYLIST detailBaseRes$PLAYLIST0) {
        q.g(actionKind0, "actionKind");
        q.g(s, "actionName");
    }

    @NotNull
    public static final PlaylistHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle("");
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        int v = 0;
        if(this.holderBind.b.getChildCount() <= 0) {
            int v1 = list0 == null ? 0 : list0.size();
            if(list0 != null) {
                for(Object object0: list0) {
                    FrameLayout.LayoutParams frameLayout$LayoutParams0 = null;
                    if(v >= 0) {
                        R1 r10 = this.bindItem(((PLAYLIST)object0), v);
                        if(v == v1 - 1) {
                            ViewGroup.LayoutParams viewGroup$LayoutParams0 = r10.b.a.getLayoutParams();
                            if(viewGroup$LayoutParams0 instanceof FrameLayout.LayoutParams) {
                                frameLayout$LayoutParams0 = (FrameLayout.LayoutParams)viewGroup$LayoutParams0;
                            }
                            if(frameLayout$LayoutParams0 != null) {
                                frameLayout$LayoutParams0.bottomMargin = ScreenUtils.dipToPixel(this.getContext(), 1.0f);
                            }
                        }
                        this.holderBind.b.addView(r10.a);
                        ++v;
                        continue;
                    }
                    k.O();
                    throw null;
                }
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

