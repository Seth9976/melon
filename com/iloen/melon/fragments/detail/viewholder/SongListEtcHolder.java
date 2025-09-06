package com.iloen.melon.fragments.detail.viewholder;

import A7.d;
import J8.r0;
import android.view.LayoutInflater;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import androidx.appcompat.app.o;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder$SongListEtcData;", "LJ8/r0;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/r0;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/r0;", "Companion", "SongListEtcData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongListEtcHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongListEtcHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            q.g(viewGroup0, "parent");
            q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
            return new SongListEtcHolder(r0.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0), onViewHolderActionBaseListener0);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0002\b\u0002\n\u0002\u0010\u000B\n\u0002\b\u0012\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0005\u001A\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u000B\u0010\u0012\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\u000B\u0010\u0013\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0014\u001A\u00020\u0006HÆ\u0003J+\u0010\u0015\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001A\u00020\u0006HÆ\u0001J\u0013\u0010\u0016\u001A\u00020\u00062\b\u0010\u0017\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001A\u00020\u0019HÖ\u0001J\t\u0010\u001A\u001A\u00020\u0003HÖ\u0001R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\t\u0010\n\"\u0004\b\u000B\u0010\fR\u001C\u0010\u0004\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\r\u0010\n\"\u0004\b\u000E\u0010\fR\u001A\u0010\u0005\u001A\u00020\u0006X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0005\u0010\u000F\"\u0004\b\u0010\u0010\u0011¨\u0006\u001B"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEtcHolder$SongListEtcData;", "", "composer", "", "movement", "isNextMovement", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Z)V", "getComposer", "()Ljava/lang/String;", "setComposer", "(Ljava/lang/String;)V", "getMovement", "setMovement", "()Z", "setNextMovement", "(Z)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SongListEtcData {
        public static final int $stable = 8;
        @Nullable
        private String composer;
        private boolean isNextMovement;
        @Nullable
        private String movement;

        public SongListEtcData() {
            this(null, null, false, 7, null);
        }

        public SongListEtcData(@Nullable String s, @Nullable String s1, boolean z) {
            this.composer = s;
            this.movement = s1;
            this.isNextMovement = z;
        }

        public SongListEtcData(String s, String s1, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                s1 = "";
            }
            if((v & 4) != 0) {
                z = false;
            }
            this(s, s1, z);
        }

        @Nullable
        public final String component1() {
            return this.composer;
        }

        @Nullable
        public final String component2() {
            return this.movement;
        }

        public final boolean component3() {
            return this.isNextMovement;
        }

        @NotNull
        public final SongListEtcData copy(@Nullable String s, @Nullable String s1, boolean z) {
            return new SongListEtcData(s, s1, z);
        }

        public static SongListEtcData copy$default(SongListEtcData songListEtcHolder$SongListEtcData0, String s, String s1, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                s = songListEtcHolder$SongListEtcData0.composer;
            }
            if((v & 2) != 0) {
                s1 = songListEtcHolder$SongListEtcData0.movement;
            }
            if((v & 4) != 0) {
                z = songListEtcHolder$SongListEtcData0.isNextMovement;
            }
            return songListEtcHolder$SongListEtcData0.copy(s, s1, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SongListEtcData)) {
                return false;
            }
            if(!q.b(this.composer, ((SongListEtcData)object0).composer)) {
                return false;
            }
            return q.b(this.movement, ((SongListEtcData)object0).movement) ? this.isNextMovement == ((SongListEtcData)object0).isNextMovement : false;
        }

        @Nullable
        public final String getComposer() [...] // 潜在的解密器

        @Nullable
        public final String getMovement() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            int v = 0;
            int v1 = this.composer == null ? 0 : this.composer.hashCode();
            String s = this.movement;
            if(s != null) {
                v = s.hashCode();
            }
            return Boolean.hashCode(this.isNextMovement) + (v1 * 0x1F + v) * 0x1F;
        }

        public final boolean isNextMovement() {
            return this.isNextMovement;
        }

        public final void setComposer(@Nullable String s) {
            this.composer = s;
        }

        public final void setMovement(@Nullable String s) {
            this.movement = s;
        }

        public final void setNextMovement(boolean z) {
            this.isNextMovement = z;
        }

        @Override
        @NotNull
        public String toString() {
            boolean z = this.isNextMovement;
            return o.s(d.o("SongListEtcData(composer=", this.composer, ", movement=", this.movement, ", isNextMovement="), z, ")");
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongListEtcHolder";
    @NotNull
    private r0 holderBind;

    static {
        SongListEtcHolder.Companion = new Companion(null);
        SongListEtcHolder.$stable = 8;
    }

    public SongListEtcHolder(@NotNull r0 r00, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(r00, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(r00, onViewHolderActionBaseListener0);
        this.holderBind = r00;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final SongListEtcHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongListEtcHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        SongListEtcData songListEtcHolder$SongListEtcData0 = (SongListEtcData)adapterInViewHolder$Row0.getItem();
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.holderBind.b.getLayoutParams();
        q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
        if(adapterInViewHolder$Row0.getPosition() == 0) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.dipToPixel(this.getContext(), 10.0f);
        }
        else if(songListEtcHolder$SongListEtcData0.isNextMovement()) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.dipToPixel(this.getContext(), 20.0f);
        }
        else {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = 0;
        }
        this.holderBind.b.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
        ViewUtils.hideWhen(this.holderBind.c, true);
        ViewUtils.hideWhen(this.holderBind.d, true);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

