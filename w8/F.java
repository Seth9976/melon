package w8;

import Ub.q;
import android.content.Context;
import com.iloen.melon.appwidget.CoverWidgetProgressBarWorker;
import oe.c;

public final class f extends c {
    public Object B;
    public final CoverWidgetProgressBarWorker D;
    public int E;
    public Context r;
    public q w;

    public f(CoverWidgetProgressBarWorker coverWidgetProgressBarWorker0, c c0) {
        this.D = coverWidgetProgressBarWorker0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.c(this);
    }
}

