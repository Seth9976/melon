package androidx.appcompat.text;

import android.content.Context;
import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import java.util.Locale;

public class AllCapsTransformationMethod implements TransformationMethod {
    public final Locale a;

    public AllCapsTransformationMethod(Context context0) {
        this.a = context0.getResources().getConfiguration().locale;
    }

    @Override  // android.text.method.TransformationMethod
    public final CharSequence getTransformation(CharSequence charSequence0, View view0) {
        return charSequence0 != null ? charSequence0.toString().toUpperCase(this.a) : null;
    }

    @Override  // android.text.method.TransformationMethod
    public final void onFocusChanged(View view0, CharSequence charSequence0, boolean z, int v, Rect rect0) {
    }
}

