package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import kotlin.jvm.internal.q;

public final class l extends n {
    @Override  // F8.o
    public final boolean b() {
        return false;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D055F, null);  // layout:musicmessage_editor_title
        q.d(view0);
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        q.g(view0, "newView");
        return view0.findViewById(0x7F0A0BB0);  // id:titlebar_toggle_btn_block
    }

    @Override  // F8.o
    public final String e(Context context0) {
        return "";
    }
}

