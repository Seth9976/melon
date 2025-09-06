package com.iloen.melon.fragments.detail.viewholder;

import J8.a;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import com.iloen.melon.adapters.common.AdapterInViewHolder.Row;
import com.iloen.melon.custom.MelonTextView;
import com.iloen.melon.custom.l1;
import com.iloen.melon.fragments.OnViewHolderActionBaseListener;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000E\n\u0002\b\u0007\b\u0007\u0018\u0000 \u00132\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001:\u0002\u0013\u0014B\u0017\u0012\u0006\u0010\u0005\u001A\u00020\u0004\u0012\u0006\u0010\u0007\u001A\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u001D\u0010\f\u001A\u00020\u000B2\f\u0010\n\u001A\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¢\u0006\u0004\b\f\u0010\rJ\u000F\u0010\u000F\u001A\u00020\u000EH\u0016¢\u0006\u0004\b\u000F\u0010\u0010R\u0016\u0010\u0011\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E¢\u0006\u0006\n\u0004\b\u0011\u0010\u0012¨\u0006\u0015"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "Lcom/iloen/melon/fragments/detail/viewholder/DetailItemViewHolder;", "Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder$SongListEmptyData;", "LJ8/a;", "bind", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "onViewHolderActionListener", "<init>", "(LJ8/a;Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;)V", "row", "Lie/H;", "onBindView", "(Lcom/iloen/melon/adapters/common/AdapterInViewHolder$Row;)V", "", "getTitleName", "()Ljava/lang/String;", "holderBind", "LJ8/a;", "Companion", "SongListEmptyData", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SongListEmptyHolder extends DetailItemViewHolder {
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0018\u0010\u0006\u001A\u00020\u00072\u0006\u0010\b\u001A\u00020\t2\u0006\u0010\n\u001A\u00020\u000BH\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder;", "parent", "Landroid/view/ViewGroup;", "onViewHolderActionListener", "Lcom/iloen/melon/fragments/OnViewHolderActionBaseListener;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SongListEmptyHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
            return new SongListEmptyHolder(a.a(l1.a(viewGroup0, "parent", onViewHolderActionBaseListener0, "onViewHolderActionListener").inflate(0x7F0D0022, viewGroup0, false)), onViewHolderActionBaseListener0);  // layout:adapter_empty_view
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000E\n\u0000\n\u0002\u0010\u000B\n\u0002\b\u000F\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001D\u0012\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001A\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\u000B\u0010\u000F\u001A\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0010\u001A\u00020\u0005HÆ\u0003J\u001F\u0010\u0011\u001A\u00020\u00002\n\b\u0002\u0010\u0002\u001A\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001A\u00020\u0005HÆ\u0001J\u0013\u0010\u0012\u001A\u00020\u00052\b\u0010\u0013\u001A\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0014\u001A\u00020\u0015HÖ\u0001J\t\u0010\u0016\u001A\u00020\u0003HÖ\u0001R\u001C\u0010\u0002\u001A\u0004\u0018\u00010\u0003X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000BR\u001A\u0010\u0004\u001A\u00020\u0005X\u0086\u000E¢\u0006\u000E\n\u0000\u001A\u0004\b\u0004\u0010\f\"\u0004\b\r\u0010\u000E¨\u0006\u0017"}, d2 = {"Lcom/iloen/melon/fragments/detail/viewholder/SongListEmptyHolder$SongListEmptyData;", "", "msg", "", "isBottomSlotExist", "", "<init>", "(Ljava/lang/String;Z)V", "getMsg", "()Ljava/lang/String;", "setMsg", "(Ljava/lang/String;)V", "()Z", "setBottomSlotExist", "(Z)V", "component1", "component2", "copy", "equals", "other", "hashCode", "", "toString", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class SongListEmptyData {
        public static final int $stable = 8;
        private boolean isBottomSlotExist;
        @Nullable
        private String msg;

        public SongListEmptyData() {
            this(null, false, 3, null);
        }

        public SongListEmptyData(@Nullable String s, boolean z) {
            this.msg = s;
            this.isBottomSlotExist = z;
        }

        public SongListEmptyData(String s, boolean z, int v, DefaultConstructorMarker defaultConstructorMarker0) {
            if((v & 1) != 0) {
                s = "";
            }
            if((v & 2) != 0) {
                z = false;
            }
            this(s, z);
        }

        @Nullable
        public final String component1() {
            return this.msg;
        }

        public final boolean component2() {
            return this.isBottomSlotExist;
        }

        @NotNull
        public final SongListEmptyData copy(@Nullable String s, boolean z) {
            return new SongListEmptyData(s, z);
        }

        public static SongListEmptyData copy$default(SongListEmptyData songListEmptyHolder$SongListEmptyData0, String s, boolean z, int v, Object object0) {
            if((v & 1) != 0) {
                s = songListEmptyHolder$SongListEmptyData0.msg;
            }
            if((v & 2) != 0) {
                z = songListEmptyHolder$SongListEmptyData0.isBottomSlotExist;
            }
            return songListEmptyHolder$SongListEmptyData0.copy(s, z);
        }

        @Override
        public boolean equals(@Nullable Object object0) {
            if(this == object0) {
                return true;
            }
            if(!(object0 instanceof SongListEmptyData)) {
                return false;
            }
            return q.b(this.msg, ((SongListEmptyData)object0).msg) ? this.isBottomSlotExist == ((SongListEmptyData)object0).isBottomSlotExist : false;
        }

        @Nullable
        public final String getMsg() [...] // 潜在的解密器

        @Override
        public int hashCode() {
            return this.msg == null ? Boolean.hashCode(this.isBottomSlotExist) : Boolean.hashCode(this.isBottomSlotExist) + this.msg.hashCode() * 0x1F;
        }

        public final boolean isBottomSlotExist() {
            return this.isBottomSlotExist;
        }

        public final void setBottomSlotExist(boolean z) {
            this.isBottomSlotExist = z;
        }

        public final void setMsg(@Nullable String s) {
            this.msg = s;
        }

        @Override
        @NotNull
        public String toString() {
            return "SongListEmptyData(msg=" + this.msg + ", isBottomSlotExist=" + this.isBottomSlotExist + ")";
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    public static final String TAG = "SongListEmptyHolder";
    @NotNull
    private a holderBind;

    static {
        SongListEmptyHolder.Companion = new Companion(null);
        SongListEmptyHolder.$stable = 8;
    }

    public SongListEmptyHolder(@NotNull a a0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        q.g(a0, "bind");
        q.g(onViewHolderActionBaseListener0, "onViewHolderActionListener");
        super(a0, onViewHolderActionBaseListener0);
        this.holderBind = a0;
        this.setOnViewHolderActionListener(onViewHolderActionBaseListener0);
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    @NotNull
    public String getTitleName() {
        return "";
    }

    @NotNull
    public static final SongListEmptyHolder newInstance(@NotNull ViewGroup viewGroup0, @NotNull OnViewHolderActionBaseListener onViewHolderActionBaseListener0) {
        return SongListEmptyHolder.Companion.newInstance(viewGroup0, onViewHolderActionBaseListener0);
    }

    public void onBindView(@NotNull AdapterInViewHolder.Row adapterInViewHolder$Row0) {
        q.g(adapterInViewHolder$Row0, "row");
        super.onBindView(adapterInViewHolder$Row0);
        this.holderBind.f.setVisibility(0);
        this.holderBind.i.setText("");
        if(((SongListEmptyData)adapterInViewHolder$Row0.getItem()).isBottomSlotExist()) {
            this.holderBind.g.setPadding(0, 0, 0, 0);
            this.holderBind.d.setPadding(0, 0, 0, 0);
            this.holderBind.e.setVisibility(8);
            MelonTextView melonTextView0 = this.holderBind.i;
            int v = ScreenUtils.dipToPixel(melonTextView0.getContext(), 39.0f);
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = melonTextView0.getLayoutParams();
            q.e(viewGroup$LayoutParams0, "null cannot be cast to non-null type android.view.ViewGroup.MarginLayoutParams");
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).setMargins(0, v, 0, v);
            melonTextView0.setLayoutParams(((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0));
            this.holderBind.h.setVisibility(8);
            this.holderBind.c.setVisibility(8);
        }
    }

    @Override  // com.iloen.melon.fragments.detail.viewholder.DetailItemViewHolder
    public void onBindView(Object object0) {
        this.onBindView(((AdapterInViewHolder.Row)object0));
    }
}

