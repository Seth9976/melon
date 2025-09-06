package com.melon.ui.playermusic;

import android.content.Context;
import android.graphics.Point;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import td.K1;
import td.L1;
import td.z1;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/ui/playermusic/PlayerViewCalculator;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class PlayerViewCalculator {
    public final Context a;
    public final K1 b;

    public PlayerViewCalculator(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = new K1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final int a(int v) {
        double f = 1.5 * ((double)v);
        double f1 = ((double)this.c()) * 2.0 + ((double)v);
        if(f > f1) {
            f = f1;
        }
        return (int)f;
    }

    public final int b(Point point0) {
        if(point0 == null) {
            return 0;
        }
        L1 l10 = new L1(ScreenUtils.isOrientationPortrait(this.a), point0);
        z1 z10 = new z1(1, this, point0);
        K1 k10 = this.b;
        if(q.b(k10.a, l10)) {
            LogU.Companion.d("SavedValue", "Calculate canceled.");
            Object object0 = k10.b;
            q.d(object0);
            return ((Number)object0).intValue();
        }
        k10.a = l10;
        Object object1 = z10.invoke();
        k10.b = object1;
        return ((Number)object1).intValue();
    }

    public final int c() {
        return ScreenUtils.getStatusBarHeight(this.a) + ((int)this.a.getResources().getDimension(0x7F070417)) + ((int)this.a.getResources().getDimension(0x7F070416));  // dimen:player_top_info_container_height
    }

    public final boolean d(Point point0) {
        int v = this.c();
        int v1 = this.a.getResources().getDimensionPixelSize(0x7F07040E);  // dimen:player_like_mixup_container_height
        int v2 = this.a.getResources().getDimensionPixelSize(0x7F07040F);  // dimen:player_lyric_view_collapsed_single_lyric_height
        int v3 = this.a.getResources().getDimensionPixelSize(0x7F07040A);  // dimen:player_bottom_fixed_area_height
        return point0.y >= v3 + (v2 + (v1 + v));
    }
}

