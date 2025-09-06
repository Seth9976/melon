package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.W1;
import J8.i0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.fragments.main.common.MainTabTitleView;
import com.iloen.melon.net.v4x.common.TagInfoBase;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.ui.ViewUtilsKt;
import com.kakao.tiara.data.ActionKind;
import e.k;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import p8.f;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0017\u0018\u0000 \u001A2\u0014\u0012\u0010\u0012\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00020\u0001:\u0001\u001AB\u0017\u0012\u0006\u0010\u0006\u001A\u00020\u0005\u0012\u0006\u0010\b\u001A\u00020\u0007¢\u0006\u0004\b\t\u0010\nJ!\u0010\u000F\u001A\u00020\u000E2\b\u0010\u000B\u001A\u0004\u0018\u00010\u00042\u0006\u0010\r\u001A\u00020\fH\u0002¢\u0006\u0004\b\u000F\u0010\u0010J\u000F\u0010\u0012\u001A\u00020\u0011H\u0016¢\u0006\u0004\b\u0012\u0010\u0013J#\u0010\u0016\u001A\u00020\u00152\u0012\u0010\u0014\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u0016\u0010\u0018\u001A\u00020\u00058\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0018\u0010\u0019¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "", "Lcom/iloen/melon/net/v4x/common/TagInfoBase;", "LJ8/i0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/i0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "item", "", "position", "LJ8/W1;", "bindItem", "(Lcom/iloen/melon/net/v4x/common/TagInfoBase;I)LJ8/W1;", "", "getTitleName", "()Ljava/lang/String;", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "holderBind", "LJ8/i0;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public class PlaylistTagHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/PlaylistTagHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final PlaylistTagHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            View view0 = l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0220, viewGroup0, false);  // layout:detail_item_tag
            int v = 0x7F0A05A7;  // id:item_container
            FlexboxLayout flexboxLayout0 = (FlexboxLayout)I.C(view0, 0x7F0A05A7);  // id:item_container
            if(flexboxLayout0 != null) {
                v = 0x7F0A07CA;  // id:main_contents_title
                MainTabTitleView mainTabTitleView0 = (MainTabTitleView)I.C(view0, 0x7F0A07CA);  // id:main_contents_title
                if(mainTabTitleView0 != null) {
                    return new PlaylistTagHolder(new i0(((LinearLayout)view0), flexboxLayout0, mainTabTitleView0), onViewHolderActionBaseListener0);
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "PlaylistTagHolder";
    @NotNull
    private i0 holderBind;

    static {
        PlaylistTagHolder.Companion = new Companion(null);
        PlaylistTagHolder.$stable = 8;
    }

    public PlaylistTagHolder(@NotNull i0 i00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(i00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(i00, onViewHolderActionBaseListener0);
        this.holderBind = i00;
        this.setTitleView(i00.c);
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    private final W1 bindItem(TagInfoBase tagInfoBase0, int v) {
        String s = null;
        View view0 = LayoutInflater.from(this.getContext()).inflate(0x7F0D0487, null, false);  // layout:listitem_detail_tag
        MelonTextView melonTextView0 = (MelonTextView)I.C(view0, 0x7F0A0B29);  // id:tag_name
        if(melonTextView0 == null) {
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(0x7F0A0B29));  // id:tag_name
        }
        W1 w10 = new W1(((FrameLayout)view0), melonTextView0);
        if(tagInfoBase0 != null) {
            s = tagInfoBase0.tagName;
        }
        melonTextView0.setText(s);
        ViewUtilsKt.setAccessibilityButtonClassName(melonTextView0);
        melonTextView0.setOnClickListener(new l(tagInfoBase0, this, v, 5));
        return w10;
    }

    private static final void bindItem$lambda$3$lambda$2(TagInfoBase tagInfoBase0, PlaylistTagHolder playlistTagHolder0, int v, View view0) {
        String s = null;
        Navigator.openMelonDJTagHubDetail((tagInfoBase0 == null ? null : tagInfoBase0.tagSeq));
        f f0 = playlistTagHolder0.getOnViewHolderActionListener().onTiaraEventBuilder();
        if(f0 != null) {
            f0.d = ActionKind.ClickContent;
            f0.a = playlistTagHolder0.getString(0x7F130DC9);  // string:tiara_common_action_name_move_page "페이지이동"
            f0.y = playlistTagHolder0.getString(0x7F130E6A);  // string:tiara_djplaylist_layer1_tag "연관태그"
            f0.F = playlistTagHolder0.getString(0x7F130DA6);  // string:tiara_click_copy_tag_name "태그명"
            f0.c(v + 1);
            if(tagInfoBase0 != null) {
                s = tagInfoBase0.tagName;
            }
            f0.i = s;
            f0.a().track();
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return this.getString(0x7F13034B);  // string:dj_playlist_title_relation_tag "연관 태그"
    }

    @NotNull
    public static final PlaylistTagHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return PlaylistTagHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        List list0 = (List)adapterInViewHolder$Row0.getItem();
        MainTabTitleView mainTabTitleView0 = this.getTitleView();
        if(mainTabTitleView0 != null) {
            mainTabTitleView0.setTitle(this.getTitleName());
        }
        MainTabTitleView mainTabTitleView1 = this.getTitleView();
        if(mainTabTitleView1 != null) {
            mainTabTitleView1.setTitleClickable(adapterInViewHolder$Row0.isViewAll());
        }
        if(this.holderBind.b.getChildCount() <= 0 && list0 != null) {
            int v = 0;
            for(Object object0: list0) {
                if(v >= 0) {
                    W1 w10 = this.bindItem(((TagInfoBase)object0), v);
                    this.holderBind.b.addView(w10.a);
                    ++v;
                    continue;
                }
                k.O();
                throw null;
            }
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

