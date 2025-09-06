package com.iloen.melon.fragments.detail.viewholder;

import J8.G1;
import Tf.o;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.AccessibilityDelegate;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.ImageView;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.ArtistDetailContentsAlbumRes.RESPONSE.ALBUMLIST;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.net.res.common.AlbumInfoBase;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0002\u0016\u0017B\u0019\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u0006\u0010\u0005\u001A\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u001F\u0010\r\u001A\u00020\f2\b\u0010\t\u001A\u0004\u0018\u00010\b2\u0006\u0010\u000B\u001A\u00020\n¢\u0006\u0004\b\r\u0010\u000EJ\u0015\u0010\u0010\u001A\u00020\f2\u0006\u0010\u000F\u001A\u00020\n¢\u0006\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0012R\u0014\u0010\u0005\u001A\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\u0013R\u0016\u0010\u0014\u001A\u00020\n8\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0018"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/G1;", "binding", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "actionListener", "<init>", "(LJ8/G1;Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;)V", "Lcom/melon/net/res/common/AlbumInfoBase;", "item", "", "position", "Lie/H;", "bind", "(Lcom/melon/net/res/common/AlbumInfoBase;I)V", "size", "setTotal", "(I)V", "LJ8/G1;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "total", "I", "Companion", "AlbumActionListener", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsAlbumItemHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001C\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J!\u0010\u0007\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\t\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\t\u0010\bJ!\u0010\n\u001A\u00020\u00062\b\u0010\u0003\u001A\u0004\u0018\u00010\u00022\u0006\u0010\u0005\u001A\u00020\u0004H&¢\u0006\u0004\b\n\u0010\b¨\u0006\u000BÀ\u0006\u0003"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "", "Lcom/melon/net/res/common/AlbumInfoBase;", "album", "", "position", "Lie/H;", "onPlayAlbum", "(Lcom/melon/net/res/common/AlbumInfoBase;I)V", "onClickAlbum", "onLongClickAlbum", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public interface AlbumActionListener {
        void onClickAlbum(@Nullable AlbumInfoBase arg1, int arg2);

        void onLongClickAlbum(@Nullable AlbumInfoBase arg1, int arg2);

        void onPlayAlbum(@Nullable AlbumInfoBase arg1, int arg2);
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0016\u0010\t\u001A\u00020\n2\u0006\u0010\u000B\u001A\u00020\f2\u0006\u0010\r\u001A\u00020\u000ER\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000F"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$Companion;", "", "<init>", "()V", "TALKBACK_ACTION_DEFAULT", "", "TALKBACK_ACTION_NAVIGATE_ALBUM_DETAIL", "TALKBACK_ACTION_PLAYBACK", "TALKBACK_ACTION_DETAIL", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder;", "parent", "Landroid/view/ViewGroup;", "actionListener", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsAlbumItemHolder$AlbumActionListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsAlbumItemHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull AlbumActionListener detailContentsAlbumItemHolder$AlbumActionListener0) {
            q.g(viewGroup0, "parent");
            q.g(detailContentsAlbumItemHolder$AlbumActionListener0, "actionListener");
            return new DetailContentsAlbumItemHolder(G1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), detailContentsAlbumItemHolder$AlbumActionListener0, null);
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    private static final int TALKBACK_ACTION_DEFAULT = 100000000;
    private static final int TALKBACK_ACTION_DETAIL = 100000003;
    private static final int TALKBACK_ACTION_NAVIGATE_ALBUM_DETAIL = 100000001;
    private static final int TALKBACK_ACTION_PLAYBACK = 100000002;
    @NotNull
    private final AlbumActionListener actionListener;
    @NotNull
    private final G1 binding;
    private int total;

    static {
        DetailContentsAlbumItemHolder.Companion = new Companion(null);
        DetailContentsAlbumItemHolder.$stable = 8;
    }

    private DetailContentsAlbumItemHolder(G1 g10, AlbumActionListener detailContentsAlbumItemHolder$AlbumActionListener0) {
        super(g10.a);
        this.binding = g10;
        this.actionListener = detailContentsAlbumItemHolder$AlbumActionListener0;
        int v = this.itemView.getContext().getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = g10.f.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, viewGroup$MarginLayoutParams0.bottomMargin);
        }
    }

    public DetailContentsAlbumItemHolder(G1 g10, AlbumActionListener detailContentsAlbumItemHolder$AlbumActionListener0, DefaultConstructorMarker defaultConstructorMarker0) {
        this(g10, detailContentsAlbumItemHolder$AlbumActionListener0);
    }

    public final void bind(@Nullable AlbumInfoBase albumInfoBase0, int v) {
        String s = null;
        Glide.with(this.binding.e.b).load((albumInfoBase0 == null ? null : albumInfoBase0.albumImg)).into(this.binding.e.b);
        int v1 = 0;
        boolean z = albumInfoBase0 == null ? false : albumInfoBase0.canService;
        boolean z1 = albumInfoBase0 != null && albumInfoBase0 instanceof ALBUMLIST && ((ALBUMLIST)albumInfoBase0).isMasterPiece;
        ViewUtils.setEnable(this.binding.f, z);
        ViewUtils.showWhen(this.binding.g, z);
        this.binding.h.setText((albumInfoBase0 == null ? null : albumInfoBase0.albumName));
        this.binding.b.setText(ProtocolUtils.getArtistNames((albumInfoBase0 == null ? null : albumInfoBase0.artistList)));
        MelonTextView melonTextView0 = this.binding.c;
        if(albumInfoBase0 != null) {
            s = albumInfoBase0.issueDate;
        }
        melonTextView0.setText(s);
        ImageView imageView0 = this.binding.d;
        if(!z1) {
            v1 = 8;
        }
        imageView0.setVisibility(v1);
        g g0 = new g(this, albumInfoBase0, v, 0);
        this.binding.a.setOnClickListener(g0);
        h h0 = new h(this, albumInfoBase0, v);
        this.binding.a.setOnLongClickListener(h0);
        g g1 = new g(this, albumInfoBase0, v, 1);
        this.binding.g.setOnClickListener(g1);
        com.iloen.melon.fragments.detail.viewholder.DetailContentsAlbumItemHolder.bind.5 detailContentsAlbumItemHolder$bind$50 = new View.AccessibilityDelegate() {
            @Override  // android.view.View$AccessibilityDelegate
            public void onInitializeAccessibilityNodeInfo(View view0, AccessibilityNodeInfo accessibilityNodeInfo0) {
                q.g(view0, "host");
                q.g(accessibilityNodeInfo0, "info");
                super.onInitializeAccessibilityNodeInfo(view0, accessibilityNodeInfo0);
                Context context0 = z.itemView.getContext();
                if(context0 == null) {
                    return;
                }
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000001, "앨범 상세보기"));
                if(z1) {
                    accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000002, "앨범 재생하기"));
                }
                accessibilityNodeInfo0.addAction(new AccessibilityNodeInfo.AccessibilityAction(100000003, "더보기"));
                StringBuilder stringBuilder0 = new StringBuilder(z.binding.h.getText() + ", " + "아티스트" + " : " + z.binding.b.getText());
                if(v) {
                    stringBuilder0.insert(0, "명반, ");
                }
                CharSequence charSequence0 = z.binding.c.getText();
                q.f(charSequence0, "getText(...)");
                if(!o.H0(charSequence0)) {
                    stringBuilder0.append(", 발매일 : " + z.binding.c.getText());
                }
                accessibilityNodeInfo0.setContentDescription(stringBuilder0);
                accessibilityNodeInfo0.setClassName("android.widget.Button");
                String s = context0.getString(0x7F130BA8, new Object[]{z.total, ((int)(albumInfoBase0 + 1))});  // string:talkback_number_out_of_number "%1$d개중 %2$d번째"
                if(!z1) {
                    s = s + ", " + "음원 서비스 불가 앨범이지만 앨범 상세 정보를 확인할 수 있습니다.";
                }
                accessibilityNodeInfo0.setHintText(s);
            }

            @Override  // android.view.View$AccessibilityDelegate
            public boolean performAccessibilityAction(View view0, int v, Bundle bundle0) {
                q.g(view0, "host");
                switch(v) {
                    case 100000001: {
                        z.actionListener.onClickAlbum(this.$item, albumInfoBase0);
                        return true;
                    }
                    case 100000002: {
                        z.actionListener.onPlayAlbum(this.$item, albumInfoBase0);
                        return true;
                    }
                    case 100000003: {
                        z.actionListener.onLongClickAlbum(this.$item, albumInfoBase0);
                        return true;
                    }
                    default: {
                        return super.performAccessibilityAction(view0, v, bundle0);
                    }
                }
            }
        };
        this.binding.a.setAccessibilityDelegate(detailContentsAlbumItemHolder$bind$50);
    }

    private static final void bind$lambda$2(DetailContentsAlbumItemHolder detailContentsAlbumItemHolder0, AlbumInfoBase albumInfoBase0, int v, View view0) {
        detailContentsAlbumItemHolder0.actionListener.onClickAlbum(albumInfoBase0, v);
    }

    private static final boolean bind$lambda$3(DetailContentsAlbumItemHolder detailContentsAlbumItemHolder0, AlbumInfoBase albumInfoBase0, int v, View view0) {
        detailContentsAlbumItemHolder0.actionListener.onLongClickAlbum(albumInfoBase0, v);
        return true;
    }

    private static final void bind$lambda$4(DetailContentsAlbumItemHolder detailContentsAlbumItemHolder0, AlbumInfoBase albumInfoBase0, int v, View view0) {
        detailContentsAlbumItemHolder0.actionListener.onPlayAlbum(albumInfoBase0, v);
    }

    public final void setTotal(int v) {
        this.total = v;
    }
}

