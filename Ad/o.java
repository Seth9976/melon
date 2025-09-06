package ad;

import com.iloen.melon.fragments.comments.CommentListRenewalViewHolder;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.melon.ui.k2;
import ie.H;
import kotlin.jvm.internal.q;
import q8.a;
import we.k;

public final class o implements k {
    public final int a;
    public final int b;
    public final int c;
    public final boolean d;
    public final Object e;

    public o(Object object0, int v, int v1, boolean z, int v2) {
        this.a = v2;
        this.e = object0;
        this.b = v;
        this.c = v1;
        this.d = z;
        super();
    }

    @Override  // we.k
    public final Object invoke(Object object0) {
        if(this.a != 0) {
            return CommentListRenewalViewHolder.showContextPopupMore$lambda$12$lambda$11(((CommentListRenewalViewHolder)this.e), this.b, this.c, this.d, ((k2)object0));
        }
        StatsElementsBase statsElementsBase0 = (StatsElementsBase)this.e;
        q.g(((a)object0), "$this$click");
        String s = null;
        ((a)object0).e = this.b == -1 ? null : String.valueOf(this.b + 1);
        ((a)object0).d = this.c == -1 ? null : String.valueOf(this.c + 1);
        String s1 = statsElementsBase0 == null ? null : statsElementsBase0.impressionProvider;
        if(s1 != null && s1.length() != 0) {
            if(this.d && statsElementsBase0 != null) {
                s = statsElementsBase0.impressionProvider;
            }
            ((a)object0).i = s;
        }
        return H.a;
    }
}

