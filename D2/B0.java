package D2;

import androidx.glance.appwidget.GlanceAppWidgetManager;
import oe.c;

public final class b0 extends c {
    public Object B;
    public final GlanceAppWidgetManager D;
    public int E;
    public GlanceAppWidgetManager r;
    public GlanceAppWidgetManager w;

    public b0(GlanceAppWidgetManager glanceAppWidgetManager0, c c0) {
        this.D = glanceAppWidgetManager0;
        super(c0);
    }

    @Override  // oe.a
    public final Object invokeSuspend(Object object0) {
        this.B = object0;
        this.E |= 0x80000000;
        return this.D.b(this);
    }
}

