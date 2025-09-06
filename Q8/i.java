package q8;

import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import java.util.LinkedHashMap;
import kotlin.jvm.internal.q;

public final class i extends Builder {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    public String j;
    public final LinkedHashMap k;

    public i() {
        this.k = new LinkedHashMap();
    }

    @Override  // com.kakao.tiara.data.ViewImpContent$Builder
    public final ViewImpContent build() {
        ViewImpContent viewImpContent0 = new Builder().id(this.b).type(this.c).name(this.e).category(null).provider(null).author(null).impId(this.a).impOrdNum(this.d).impType(this.f).impArea(this.g).impAreaOrdNum(null).impProvider(this.h).impExtraInfo(null).layer1(this.i).layer2(null).layer3(null).clickUrl(this.j).setNum(null).ordNum(null).copy(null).image(null).props(this.k).build();
        q.f(viewImpContent0, "build(...)");
        return viewImpContent0;
    }
}

