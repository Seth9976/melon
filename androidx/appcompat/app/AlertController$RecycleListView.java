package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.ListView;
import g.a;

public class AlertController.RecycleListView extends ListView {
    public final int a;
    public final int b;

    public AlertController.RecycleListView(Context context0) {
        this(context0, null);
    }

    public AlertController.RecycleListView(Context context0, AttributeSet attributeSet0) {
        super(context0, attributeSet0);
        TypedArray typedArray0 = context0.obtainStyledAttributes(attributeSet0, a.v);
        this.b = typedArray0.getDimensionPixelOffset(0, -1);
        this.a = typedArray0.getDimensionPixelOffset(1, -1);
    }
}

