package o;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

public final class a extends LayoutInflater {
    public static final String[] a;

    static {
        a.a = new String[]{"android.widget.", "android.webkit.", "android.app."};
    }

    public a(Context context0) {
        super(context0);
    }

    @Override  // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context context0) {
        return new a(context0);  // 初始化器: Landroid/view/LayoutInflater;-><init>(Landroid/content/Context;)V
    }

    @Override  // android.view.LayoutInflater
    public final View onCreateView(String s, AttributeSet attributeSet0) {
        for(int v = 0; v < 3; ++v) {
            String s1 = a.a[v];
            try {
                View view0 = this.createView(s, s1, attributeSet0);
                if(view0 != null) {
                    return view0;
                }
            }
            catch(ClassNotFoundException unused_ex) {
            }
        }
        return super.onCreateView(s, attributeSet0);
    }
}

