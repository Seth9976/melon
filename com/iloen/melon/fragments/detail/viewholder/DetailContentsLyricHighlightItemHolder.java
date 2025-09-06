package com.iloen.melon.fragments.detail.viewholder;

import De.I;
import J8.L1;
import J8.f3;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.fragments.detail.LyricHighLightShareFragment;
import com.iloen.melon.net.v4x.common.ProtocolUtils;
import com.iloen.melon.net.v6x.response.MyMusicLyricListLyricHighlightRes.RESPONSE.LYRICHIGHLIGHTLIST;
import com.iloen.melon.utils.Navigator;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \f2\u00020\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\t\u001A\u00020\b2\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u000B¨\u0006\r"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder;", "Landroidx/recyclerview/widget/O0;", "LJ8/L1;", "binding", "<init>", "(LJ8/L1;)V", "Lcom/iloen/melon/net/v6x/response/MyMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST;", "item", "Lie/H;", "bind", "(Lcom/iloen/melon/net/v6x/response/MyMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST;)V", "LJ8/L1;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailContentsLyricHighlightItemHolder extends O0 {
    @Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000E\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\tR\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/DetailContentsLyricHighlightItemHolder;", "parent", "Landroid/view/ViewGroup;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final DetailContentsLyricHighlightItemHolder newInstance(@NotNull ViewGroup viewGroup0) {
            q.g(viewGroup0, "parent");
            View view0 = LayoutInflater.from(viewGroup0.getContext()).inflate(0x7F0D047B, viewGroup0, false);  // layout:listitem_detail_lyric_highlight
            int v = 0x7F0A00C2;  // id:artist_tv
            View view1 = I.C(view0, 0x7F0A00C2);  // id:artist_tv
            if(((MelonTextView)view1) != null) {
                v = 0x7F0A037E;  // id:date_tv
                View view2 = I.C(view0, 0x7F0A037E);  // id:date_tv
                if(((MelonTextView)view2) != null) {
                    v = 0x7F0A040D;  // id:edit_iv
                    View view3 = I.C(view0, 0x7F0A040D);  // id:edit_iv
                    if(((ImageView)view3) != null) {
                        v = 0x7F0A056B;  // id:include_thumbnail_layout
                        View view4 = I.C(view0, 0x7F0A056B);  // id:include_thumbnail_layout
                        if(view4 != null) {
                            f3 f30 = f3.a(view4);
                            v = 0x7F0A05B7;  // id:item_layout
                            View view5 = I.C(view0, 0x7F0A05B7);  // id:item_layout
                            if(((LinearLayout)view5) != null) {
                                v = 0x7F0A07C1;  // id:lyric_tv
                                View view6 = I.C(view0, 0x7F0A07C1);  // id:lyric_tv
                                if(((MelonTextView)view6) != null) {
                                    v = 0x7F0A0A83;  // id:share_iv
                                    View view7 = I.C(view0, 0x7F0A0A83);  // id:share_iv
                                    if(((ImageView)view7) != null) {
                                        v = 0x7F0A0AB7;  // id:song_tv
                                        View view8 = I.C(view0, 0x7F0A0AB7);  // id:song_tv
                                        if(((MelonTextView)view8) != null) {
                                            return new DetailContentsLyricHighlightItemHolder(new L1(((FrameLayout)view0), ((MelonTextView)view1), ((MelonTextView)view2), ((ImageView)view3), f30, ((LinearLayout)view5), ((MelonTextView)view6), ((ImageView)view7), ((MelonTextView)view8)), null);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            throw new NullPointerException("Missing required view with ID: " + view0.getResources().getResourceName(v));
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "DetailContentsLyricHighlightItemHolder";
    @NotNull
    private final L1 binding;

    static {
        DetailContentsLyricHighlightItemHolder.Companion = new Companion(null);
        DetailContentsLyricHighlightItemHolder.$stable = 8;
    }

    private DetailContentsLyricHighlightItemHolder(L1 l10) {
        super(l10.a);
        this.binding = l10;
        Context context0 = this.itemView.getContext();
        int v = context0.getResources().getDimensionPixelSize(0x7F0700E3);  // dimen:detail_list_padding_left_right
        int v1 = ScreenUtils.dipToPixel(context0, 15.0f);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = l10.f.getLayoutParams();
        ViewGroup.MarginLayoutParams viewGroup$MarginLayoutParams0 = viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0) : null;
        if(viewGroup$MarginLayoutParams0 != null) {
            viewGroup$MarginLayoutParams0.setMargins(v, viewGroup$MarginLayoutParams0.topMargin, v, v1);
        }
        int v2 = ScreenUtils.dipToPixel(context0, 44.0f);
        ViewUtils.setDefaultImage(l10.e.c, v2);
    }

    public DetailContentsLyricHighlightItemHolder(L1 l10, DefaultConstructorMarker defaultConstructorMarker0) {
        this(l10);
    }

    public final void bind(@NotNull LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0) {
        q.g(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, "item");
        this.binding.g.setText(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.chicLyric);
        this.binding.c.setText(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.highlightDate);
        Glide.with(this.binding.e.b).load(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.albumImg).into(this.binding.e.b);
        String s = ProtocolUtils.getArtistNames(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.artistList);
        this.binding.b.setText(s);
        this.binding.i.setText(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songName);
        k k0 = new k(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, 0);
        this.binding.e.a.setOnClickListener(k0);
        k k1 = new k(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, 1);
        this.binding.i.setOnClickListener(k1);
        k k2 = new k(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, 2);
        this.binding.b.setOnClickListener(k2);
        if(q.b(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.isService, Boolean.TRUE)) {
            this.binding.d.setAlpha(1.0f);
            this.binding.h.setAlpha(1.0f);
            k k3 = new k(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, 3);
            this.binding.d.setOnClickListener(k3);
            k k4 = new k(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, 4);
            this.binding.h.setOnClickListener(k4);
            return;
        }
        this.binding.d.setAlpha(0.3f);
        this.binding.h.setAlpha(0.3f);
        this.binding.d.setOnClickListener(null);
        this.binding.h.setOnClickListener(null);
    }

    private static final void bind$lambda$2(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, View view0) {
        String s = myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songId;
        q.f(s, "songId");
        Navigator.openSongInfo(s);
    }

    private static final void bind$lambda$3(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, View view0) {
        String s = myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songId;
        q.f(s, "songId");
        Navigator.openSongInfo(s);
    }

    private static final void bind$lambda$4(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, View view0) {
        String s = myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songId;
        q.f(s, "songId");
        Navigator.openSongInfo(s);
    }

    private static final void bind$lambda$5(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, View view0) {
        Navigator.INSTANCE.openLyricHighlight(myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songId, "song");
    }

    private static final void bind$lambda$6(LYRICHIGHLIGHTLIST myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0, View view0) {
        String s = myMusicLyricListLyricHighlightRes$RESPONSE$LYRICHIGHLIGHTLIST0.songId;
        q.f(s, "songId");
        Navigator.open(LyricHighLightShareFragment.Companion.newInstance(s));
    }
}

