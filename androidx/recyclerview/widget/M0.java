package androidx.recyclerview.widget;

import android.view.View;

public abstract class m0 {
    public static void a(View view0, float f) {
        try {
            view0.setFrameContentVelocity(f);
        }
        catch(LinkageError unused_ex) {
        }
    }
}

