package com.melon.ui.playerdjmalrang;

import android.content.Context;
import android.graphics.Point;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import ed.w0;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import rd.O1;
import rd.P1;

@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000F\u0012\u0006\u0010\u0003\u001A\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005¨\u0006\u0006"}, d2 = {"Lcom/melon/ui/playerdjmalrang/DjMalrangPlayerViewCalculator;", "", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class DjMalrangPlayerViewCalculator {
    public final Context a;
    public final O1 b;

    public DjMalrangPlayerViewCalculator(@NotNull Context context0) {
        q.g(context0, "context");
        super();
        this.a = context0;
        this.b = new O1();  // 初始化器: Ljava/lang/Object;-><init>()V
    }

    public final Point a(Point point0) {
        if(point0 == null) {
            return new Point(0, 0);
        }
        P1 p10 = new P1(ScreenUtils.isOrientationPortrait(this.a), point0);
        w0 w00 = new w0(28, this, point0);
        O1 o10 = this.b;
        if(q.b(o10.a, p10)) {
            LogU.Companion.d("SavedValue", "Calculate canceled.");
            Object object0 = o10.b;
            q.d(object0);
            return (Point)object0;
        }
        o10.a = p10;
        Object object1 = w00.invoke();
        o10.b = object1;
        return (Point)object1;
    }

    public final int b() {
        return ScreenUtils.getStatusBarHeight(this.a) + ((int)this.a.getResources().getDimension(0x7F0700EE)) + ((int)this.a.getResources().getDimension(0x7F0700ED)) + ((int)this.a.getResources().getDimension(0x7F0700EC));  // dimen:dj_malrang_player_title_height
    }
}

