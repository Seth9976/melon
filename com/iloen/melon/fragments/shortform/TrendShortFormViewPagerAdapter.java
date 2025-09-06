package com.iloen.melon.fragments.shortform;

import android.view.View;
import androidx.fragment.app.I;
import androidx.recyclerview.widget.O0;
import androidx.viewpager2.adapter.h;
import androidx.viewpager2.adapter.i;
import com.iloen.melon.custom.n;
import com.iloen.melon.custom.t;
import com.iloen.melon.net.v6x.response.TrendShortFormRes.Response.SLOTLIST;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import we.k;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B5\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\f\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\u0016\b\u0002\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0007¢\u0006\u0004\b\u000B\u0010\fJ\u000F\u0010\r\u001A\u00020\bH\u0016¢\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u00022\u0006\u0010\u000F\u001A\u00020\bH\u0016¢\u0006\u0004\b\u0010\u0010\u0011J-\u0010\u0016\u001A\u00020\t2\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u000F\u001A\u00020\b2\f\u0010\u0015\u001A\b\u0012\u0004\u0012\u00020\u00140\u0004H\u0016¢\u0006\u0004\b\u0016\u0010\u0017R\u001A\u0010\u0006\u001A\b\u0012\u0004\u0012\u00020\u00050\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010\u0018R\"\u0010\n\u001A\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\n\u0010\u0019R\u0017\u0010\u001B\u001A\u00020\u001A8\u0006¢\u0006\f\n\u0004\b\u001B\u0010\u001C\u001A\u0004\b\u001D\u0010\u001E¨\u0006\u001F"}, d2 = {"Lcom/iloen/melon/fragments/shortform/TrendShortFormViewPagerAdapter;", "Landroidx/viewpager2/adapter/h;", "Landroidx/fragment/app/I;", "fm", "", "Lcom/iloen/melon/net/v6x/response/TrendShortFormRes$Response$SLOTLIST;", "slotList", "Lkotlin/Function1;", "", "Lie/H;", "itemClickListener", "<init>", "(Landroidx/fragment/app/I;Ljava/util/List;Lwe/k;)V", "getItemCount", "()I", "position", "createFragment", "(I)Landroidx/fragment/app/I;", "Landroidx/viewpager2/adapter/i;", "holder", "", "payloads", "onBindViewHolder", "(Landroidx/viewpager2/adapter/i;ILjava/util/List;)V", "Ljava/util/List;", "Lwe/k;", "Lcom/iloen/melon/custom/n;", "positionProvider", "Lcom/iloen/melon/custom/n;", "getPositionProvider", "()Lcom/iloen/melon/custom/n;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class TrendShortFormViewPagerAdapter extends h {
    public static final int $stable = 8;
    @Nullable
    private final k itemClickListener;
    @NotNull
    private final n positionProvider;
    @NotNull
    private final List slotList;

    public TrendShortFormViewPagerAdapter(@NotNull I i0, @NotNull List list0, @Nullable k k0) {
        q.g(i0, "fm");
        q.g(list0, "slotList");
        super(i0);
        this.slotList = list0;
        this.itemClickListener = k0;
        this.positionProvider = new n(new t() {
            @Override  // com.iloen.melon.custom.t
            public int getCount() {
                return TrendShortFormViewPagerAdapter.access$getSlotList$p(TrendShortFormViewPagerAdapter.this).size();
            }
        });
    }

    public TrendShortFormViewPagerAdapter(I i0, List list0, k k0, int v, DefaultConstructorMarker defaultConstructorMarker0) {
        if((v & 4) != 0) {
            k0 = null;
        }
        this(i0, list0, k0);
    }

    public static final List access$getSlotList$p(TrendShortFormViewPagerAdapter trendShortFormViewPagerAdapter0) {
        return trendShortFormViewPagerAdapter0.slotList;
    }

    @Override  // androidx.viewpager2.adapter.h
    @NotNull
    public I createFragment(int v) {
        int v1 = this.positionProvider.c(v);
        String s = ((SLOTLIST)this.slotList.get(v1)).uiType;
        if(s != null) {
            switch(s) {
                case "M01": 
                case "M02": {
                    return TrendMusicWaveExclusiveFragment.Companion.newInstance(v1);
                }
                case "M03": {
                    return TrendMusicWavePopularFragment.Companion.newInstance(v1);
                }
                case "S01": {
                    return TrendEmphasizeSongFragment.Companion.newInstance(v1);
                }
                case "T01": {
                    return TrendShortLyricsFragment.Companion.newInstance(v1);
                }
                case "T02": {
                    return TrendMagazineFragment.Companion.newInstance(v1);
                }
                case "V01": {
                    return TrendShortVideoOfferingFragment.Companion.newInstance(v1);
                }
                case "V02": {
                    return TrendShortVideoEmphasisFragment.Companion.newInstance(v1);
                }
                default: {
                    return TrendMagazineFragment.Companion.newInstance(v1);
                }
            }
        }
        return TrendMagazineFragment.Companion.newInstance(v1);
    }

    @Override  // androidx.recyclerview.widget.j0
    public int getItemCount() {
        return this.positionProvider.a();
    }

    @NotNull
    public final n getPositionProvider() {
        return this.positionProvider;
    }

    @Override  // androidx.recyclerview.widget.j0
    public void onBindViewHolder(O0 o00, int v, List list0) {
        this.onBindViewHolder(((i)o00), v, list0);
    }

    public void onBindViewHolder(@NotNull i i0, int v, @NotNull List list0) {
        q.g(i0, "holder");
        q.g(list0, "payloads");
        super.onBindViewHolder(i0, v, list0);
        m m0 = new m(this, v, 0);
        i0.itemView.setOnClickListener(m0);
    }

    private static final void onBindViewHolder$lambda$1(TrendShortFormViewPagerAdapter trendShortFormViewPagerAdapter0, int v, View view0) {
        k k0 = trendShortFormViewPagerAdapter0.itemClickListener;
        if(k0 != null) {
            k0.invoke(v);
        }
    }
}

