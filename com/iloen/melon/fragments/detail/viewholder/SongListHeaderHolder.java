package com.iloen.melon.fragments.detail.viewholder;

import J8.x0;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;", "LJ8/x0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/x0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/x0;", "Companion", "HeaderData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongListHeaderHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongListHeaderHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongListHeaderHolder(x0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\r\n\u0002\u0010\u000B\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001B\u0012\b\b\u0002\u0010\u0002\u001A\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\t\u0010\r\u001A\u00020\u0003HÆ\u0003J\t\u0010\u000E\u001A\u00020\u0003HÆ\u0003J\u001D\u0010\u000F\u001A\u00020\u00002\b\b\u0002\u0010\u0002\u001A\u00020\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0003HÆ\u0001J\u0013\u0010\u0010\u001A\u00020\u00112\b\u0010\u0012\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001A\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001A\u00020\u0003HÖ\u0001R\u001A\u0010\u0002\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001A\u0010\u0004\u001A\u00020\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u000B\u0010\b\"\u0004\b\f\u0010\n¨\u0006\u0016"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListHeaderHolder$HeaderData;", "", "totSongCnt", "", "totPlayTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTotSongCnt", "()Ljava/lang/String;", "setTotSongCnt", "(Ljava/lang/String;)V", "getTotPlayTime", "setTotPlayTime", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class HeaderData {
        public static final int $stable = 8;
        @NotNull
        private String totPlayTime;
        @NotNull
        private String totSongCnt;

        public HeaderData() {
            this(null, null, 3, null);
        }

        public HeaderData(@NotNull String s, @NotNull String s1) {
            q.g(s, "totSongCnt");
            q.g(s1, "totPlayTime");
            super();
            this.totSongCnt = s;
            this.totPlayTime = s1;
        }

        public HeaderData(String s, String s1, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            this(s, s1);
        }

        @NotNull
        public final String component1() {
            return this.totSongCnt;
        }

        @NotNull
        public final String component2() {
            return this.totPlayTime;
        }

        @NotNull
        public final HeaderData copy(@NotNull String s, @NotNull String s1) {
            q.g(s, "totSongCnt");
            q.g(s1, "totPlayTime");
            return new HeaderData(s, s1);
        }

        public static HeaderData copy$default(HeaderData songListHeaderHolder$HeaderData0, String s, String s1, int v, Object object0) {
            if((v & 1) != 0) {
                s = songListHeaderHolder$HeaderData0.totSongCnt;
            }
            if((v & 2) != 0) {
                s1 = songListHeaderHolder$HeaderData0.totPlayTime;
            }
            return songListHeaderHolder$HeaderData0.copy(s, s1);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof HeaderData)) {
                return false;
            }
            return q.b(this.totSongCnt, ((HeaderData)object0).totSongCnt) ? q.b(this.totPlayTime, ((HeaderData)object0).totPlayTime) : false;
        }

        @NotNull
        public final String getTotPlayTime() [...] // 潜在的解密器

        @NotNull
        public final String getTotSongCnt() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.totPlayTime.hashCode() + this.totSongCnt.hashCode() * 0x1F;
        }

        public final void setTotPlayTime(@NotNull String s) {
            q.g(s, "<set-?>");
            this.totPlayTime = s;
        }

        public final void setTotSongCnt(@NotNull String s) {
            q.g(s, "<set-?>");
            this.totSongCnt = s;
        }

        @Override
        @NotNull
        public String toString() {
            return "HeaderData(totSongCnt=" + this.totSongCnt + ", totPlayTime=" + this.totPlayTime + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongListHeaderHolder";
    @NotNull
    private x0 holderBind;

    static {
        SongListHeaderHolder.Companion = new Companion(null);
        SongListHeaderHolder.$stable = 8;
    }

    public SongListHeaderHolder(@NotNull x0 x00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(x00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(x00, onViewHolderActionBaseListener0);
        this.holderBind = x00;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    public static void a(SongListHeaderHolder songListHeaderHolder0, View view0) {
        SongListHeaderHolder.onBindView$lambda$0(songListHeaderHolder0, view0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final SongListHeaderHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongListHeaderHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        HeaderData songListHeaderHolder$HeaderData0 = (HeaderData)adapterInViewHolder$Row0.getItem();
        this.holderBind.g.setText(this.getString(0x7F130071, ""));  // string:album_song_cnt "%s곡"
        this.holderBind.h.setText("");
        this.getOnViewHolderActionListener().onSetBtnAll(this.holderBind.b);
        this.holderBind.d.setOnClickListener(new p(this, 2));
        ViewUtils.setContentDescriptionWithButtonClassName(this.holderBind.d, this.holderBind.b.getText());
        CharSequence charSequence0 = this.holderBind.g.getText();
        CharSequence charSequence1 = this.holderBind.h.getText();
        ViewUtils.setContentDescriptionWithClassName(this.holderBind.e, charSequence0 + charSequence1, null, null);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }

    private static final void onBindView$lambda$0(SongListHeaderHolder songListHeaderHolder0, View view0) {
        songListHeaderHolder0.getOnViewHolderActionListener().onAllSelectListener(true);
    }
}

