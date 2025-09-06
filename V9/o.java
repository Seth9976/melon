package v9;

import android.text.TextUtils;
import android.view.View.OnClickListener;

public final class o {
    public boolean a;
    public int b;
    public int c;
    public String d;
    public int e;
    public View.OnClickListener f;
    public View.OnClickListener g;
    public int h;
    public int i;
    public static final o j;

    static {
        o o0 = new o();  // 初始化器: Ljava/lang/Object;-><init>()V
        o0.b = -1;
        o0.c = -1;
        o0.e = -1;
        o0.h = -1;
        o0.i = -1;
        o0.a = true;
        o.j = o0;
    }

    public static o a(o o0, o o1) {
        if(o0 == null && o1 == null) {
            return null;
        }
        if(o0 != null && o1 == null) {
            return o0;
        }
        if(o0 == null && o1 != null) {
            return o1;
        }
        o1.getClass();
        if(o1.a) {
            return o1;
        }
        o1.b = o1.b == -1 ? o0.b : o1.b;
        o1.c = o1.c == -1 ? o0.c : o1.c;
        o1.d = TextUtils.isEmpty(o1.d) ? o0.d : o1.d;
        o1.f = o1.f == null ? o0.f : o1.f;
        o1.g = o1.g == null ? o0.g : o1.g;
        o1.i = o1.i == -1 ? o0.i : o1.i;
        o1.h = o1.h == -1 ? o0.h : o1.h;
        o1.e = o1.e == -1 ? o0.e : o1.e;
        return o1;
    }

    @Override
    public final String toString() {
        StringBuilder stringBuilder0 = new StringBuilder("NetworkErrorInfo{invisible=");
        stringBuilder0.append(this.a);
        stringBuilder0.append(", reset=false, bgResId=");
        stringBuilder0.append(this.b);
        stringBuilder0.append(", imgResId=");
        stringBuilder0.append(this.c);
        stringBuilder0.append(", errorMessage=\'");
        stringBuilder0.append(this.d);
        stringBuilder0.append("\', messageTextColor=");
        stringBuilder0.append(this.e);
        stringBuilder0.append(", confirmButtonListener=\'");
        stringBuilder0.append(this.f);
        stringBuilder0.append("\', retryButtonListener=");
        stringBuilder0.append(this.g);
        stringBuilder0.append(", buttonTextColor=");
        stringBuilder0.append(this.h);
        stringBuilder0.append(", buttonBgResId=");
        return androidx.appcompat.app.o.q(stringBuilder0, this.i, '}');
    }
}

