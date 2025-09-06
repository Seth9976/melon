package q8;

import com.kakao.tiara.data.Click.Builder;
import com.kakao.tiara.data.Click;
import kotlin.jvm.internal.q;

public final class a extends Builder {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;

    public final void a(we.a a0) {
        this.g = (String)a0.invoke();
    }

    public final void b(we.a a0) {
        this.a = (String)a0.invoke();
    }

    @Override  // com.kakao.tiara.data.Click$Builder
    public final Click build() {
        Click click0 = new Builder().layer1(this.a).layer2(this.b).layer3(null).clickUrl(this.c).ordNum(this.e).setNum(this.d).image(this.f).copy(this.g).impressionId(this.h).impressionProvider(this.i).build();
        q.f(click0, "build(...)");
        return click0;
    }
}

