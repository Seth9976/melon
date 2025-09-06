package F8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public final class q extends w {
    public final String g;

    public q(String s) {
        kotlin.jvm.internal.q.g(s, "title");
        super();
        this.g = s;
    }

    @Override  // F8.o
    public final View c(Context context0) {
        View view0 = LayoutInflater.from(context0).inflate(0x7F0D0884, null);  // layout:titlebar_left_back_with_title_button
        TextView textView0 = (TextView)view0.findViewById(0x7F0A0BAF);  // id:titlebar_title
        if(textView0 != null) {
            textView0.setText(this.g);
        }
        return view0;
    }

    @Override  // F8.o
    public final View d(View view0) {
        kotlin.jvm.internal.q.g(view0, "newView");
        return view0;
    }

    @Override  // F8.o
    public final String e(Context context0) {
        kotlin.jvm.internal.q.f("이전페이지 가기", "getString(...)");
        return "이전페이지 가기";
    }

    @Override  // F8.w
    public final String f(Context context0) {
        return "뒤로가기";
    }

    @Override  // F8.w
    public final int i() {
        return 2;
    }
}

