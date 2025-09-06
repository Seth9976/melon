package Jc;

import Ac.U2;
import Fd.D;
import android.content.Context;
import androidx.compose.runtime.b0;
import androidx.recyclerview.widget.O0;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment.DetailAdapter;
import com.iloen.melon.fragments.DetailSongMetaContentBaseFragment;
import com.iloen.melon.fragments.comments.CmtBaseFragment;
import com.iloen.melon.fragments.main.common.OnImpLogListener;
import com.iloen.melon.fragments.news.FeedLogsItemHolder;
import com.iloen.melon.fragments.news.FeedLogsListAdapter;
import com.iloen.melon.net.v3x.comments.CmtResViewModel.result.cmtList;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.net.v6x.response.FeedLogsListRes.FEEDLOGLIST;
import com.iloen.melon.net.v6x.response.SearchHotKeywordAndMenuListRes.Contents;
import com.iloen.melon.net.v6x.response.SearchTagBase;
import com.iloen.melon.utils.Navigator;
import com.kakao.tiara.data.ViewImpContent.Builder;
import com.kakao.tiara.data.ViewImpContent;
import com.melon.net.res.SearchMainContentRes.ThemeOffering;
import com.melon.net.res.common.SongInfoBase;
import ed.F0;
import ed.q0;
import ie.H;
import kotlin.jvm.internal.q;
import we.a;
import we.k;
import z6.f;

public final class t0 implements a {
    public final int a;
    public final int b;
    public final Object c;
    public final Object d;
    public final Object e;

    public t0(FeedLogsListAdapter feedLogsListAdapter0, int v, FEEDLOGLIST feedLogsListRes$FEEDLOGLIST0, FeedLogsItemHolder feedLogsItemHolder0) {
        this.a = 3;
        super();
        this.c = feedLogsListAdapter0;
        this.b = v;
        this.d = feedLogsListRes$FEEDLOGLIST0;
        this.e = feedLogsItemHolder0;
    }

    public t0(Object object0, Object object1, int v, Object object2, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.b = v;
        this.e = object2;
        super();
    }

    public t0(Object object0, Object object1, Object object2, int v, int v1) {
        this.a = v1;
        this.c = object0;
        this.d = object1;
        this.e = object2;
        this.b = v;
        super();
    }

    @Override  // we.a
    public final Object invoke() {
        String s1;
        switch(this.a) {
            case 0: {
                X x0 = (X)this.c;
                Context context0 = (Context)this.d;
                v0 v00 = (v0)this.e;
                Builder viewImpContent$Builder0 = new Builder();
                StatsElementsBase statsElementsBase0 = x0.w;
                String s = "";
                if(statsElementsBase0 == null) {
                    s1 = "";
                }
                else {
                    s1 = statsElementsBase0.impressionId;
                    if(s1 == null) {
                        s1 = "";
                    }
                }
                Builder viewImpContent$Builder1 = viewImpContent$Builder0.impId(s1);
                if(statsElementsBase0 != null) {
                    String s2 = statsElementsBase0.impressionProvider;
                    if(s2 != null) {
                        s = s2;
                    }
                }
                Builder viewImpContent$Builder2 = viewImpContent$Builder1.impProvider(s).impType("vimp").impArea((statsElementsBase0 == null ? null : statsElementsBase0.rangeCode));
                int v = this.b;
                ViewImpContent viewImpContent0 = viewImpContent$Builder2.impOrdNum(String.valueOf(v + 1)).layer1("곡리스트").id(x0.r).type("곡").name(x0.g).build();
                q.f(viewImpContent0, "build(...)");
                OnImpLogListener onImpLogListener0 = v00.getOnImpLogListener();
                if(onImpLogListener0 != null) {
                    onImpLogListener0.onImpLogListener(String.valueOf(v), viewImpContent0);
                }
                return H.a;
            }
            case 1: {
                return DetailAdapter.onBindViewImpl$lambda$8$lambda$7$lambda$6(((DetailAdapter)this.c), ((DetailSongMetaContentBaseFragment)this.d), this.b, ((SongInfoBase)this.e));
            }
            case 2: {
                return ((CmtBaseFragment)this.c).lambda$removeCmt$1(((cmtList)this.d), this.b, ((String)this.e));
            }
            case 3: {
                return FeedLogsListAdapter.onBindViewImpl$lambda$7(((FeedLogsListAdapter)this.c), this.b, ((FEEDLOGLIST)this.d), ((O0)this.e));
            }
            case 4: {
                D d0 = f.q(6, ((Contents)this.c).keyword.toString(), null, null);
                Navigator.INSTANCE.open(d0);
                String s3 = ((Boolean)((b0)this.d).getValue()).booleanValue() ? "0" : "1";
                ((F0)((ed.Z.a)this.e).getViewModel()).k().b(((Contents)this.c).keyword.toString(), s3, String.valueOf(this.b + 1));
                return H.a;
            }
            case 5: {
                ThemeOffering searchMainContentRes$ThemeOffering0 = (ThemeOffering)this.c;
                k k0 = (k)this.d;
                String s4 = (String)this.e;
                if(searchMainContentRes$ThemeOffering0 != null) {
                    k0.invoke(new q0(searchMainContentRes$ThemeOffering0, s4, this.b));
                }
                return H.a;
            }
            default: {
                ((U2)this.c).invoke(((SearchTagBase)this.d), this.b);
                ((ed.v0)this.e).invoke(((SearchTagBase)this.d), this.b);
                return H.a;
            }
        }
    }
}

