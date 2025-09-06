package x2;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;
import e1.u;

public final class g extends u {
    public final f e;

    public g(TextView textView0) {
        this.e = new f(textView0);
    }

    @Override  // e1.u
    public final boolean G() {
        return this.e.g;
    }

    // 去混淆评级： 低(30)
    @Override  // e1.u
    public final void S(boolean z) {
    }

    @Override  // e1.u
    public final void T(boolean z) {
        this.e.g = z;
    }

    // 去混淆评级： 低(30)
    @Override  // e1.u
    public final TransformationMethod W(TransformationMethod transformationMethod0) {
        return transformationMethod0;
    }

    // 去混淆评级： 低(30)
    @Override  // e1.u
    public final InputFilter[] t(InputFilter[] arr_inputFilter) {
        return arr_inputFilter;
    }
}

