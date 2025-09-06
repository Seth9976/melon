package androidx.core.widget;

import android.view.inputmethod.EditorInfo;

public abstract class g {
    public static void a(NestedScrollView nestedScrollView0, float f) {
        try {
            nestedScrollView0.setFrameContentVelocity(f);
        }
        catch(LinkageError unused_ex) {
        }
    }

    public static void b(EditorInfo editorInfo0, boolean z) {
        editorInfo0.setStylusHandwritingEnabled(z);
    }
}

