package com.iloen.melon.fragments.detail;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.H;
import com.iloen.melon.adapters.common.p;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\u001E\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001F\u0012\u0006\u0010\u0003\u001A\u00020\u0002\u0012\u000E\u0010\u0005\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0017\u0010\n\u001A\u00020\b2\u0006\u0010\t\u001A\u00020\bH\u0016¢\u0006\u0004\b\n\u0010\u000BR\u0014\u0010\u0003\u001A\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\fR\u001C\u0010\u0005\u001A\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010\r¨\u0006\u000E"}, d2 = {"Lcom/iloen/melon/fragments/detail/DetailPhotoSpanSizeLookup;", "Landroidx/recyclerview/widget/H;", "Landroidx/recyclerview/widget/GridLayoutManager;", "layoutManager", "Lcom/iloen/melon/adapters/common/p;", "adapter", "<init>", "(Landroidx/recyclerview/widget/GridLayoutManager;Lcom/iloen/melon/adapters/common/p;)V", "", "rawPosition", "getSpanSize", "(I)I", "Landroidx/recyclerview/widget/GridLayoutManager;", "Lcom/iloen/melon/adapters/common/p;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DetailPhotoSpanSizeLookup extends H {
    public static final int $stable = 8;
    @NotNull
    private final p adapter;
    @NotNull
    private final GridLayoutManager layoutManager;

    public DetailPhotoSpanSizeLookup(@NotNull GridLayoutManager gridLayoutManager0, @NotNull p p0) {
        q.g(gridLayoutManager0, "layoutManager");
        q.g(p0, "adapter");
        super();
        this.layoutManager = gridLayoutManager0;
        this.adapter = p0;
    }

    @Override  // androidx.recyclerview.widget.H
    public int getSpanSize(int v) {
        int v1 = this.adapter.getHeaderCount();
        return this.adapter.isReservedPosition(v) || v - v1 < 0 ? this.layoutManager.b : 1;
    }
}

