package androidx.glance.appwidget.protobuf;

import androidx.datastore.preferences.protobuf.e;
import java.util.Iterator;

public abstract class g extends i {
    private static final long serialVersionUID = 1L;

    @Override
    public final Iterator iterator() {
        return new e(this);
    }
}

