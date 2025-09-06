package Jc;

import Ad.n;
import J8.N1;
import J8.O1;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.recyclerview.widget.O0;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestManager;
import com.iloen.melon.adapters.common.c;
import com.iloen.melon.net.v5x.response.DetailBaseRes.PHOTO;
import java.util.ArrayList;
import kotlin.jvm.internal.q;
import y5.a;

public final class j0 extends c {
    public final ArrayList a;
    public final n0 b;

    public j0(n0 n00, Context context0, ArrayList arrayList0, ArrayList arrayList1) {
        this.b = n00;
        super(context0, arrayList0);
        this.a = arrayList1;
    }

    @Override  // androidx.recyclerview.widget.j0
    public final int getItemViewType(int v) {
        PHOTO detailBaseRes$PHOTO0 = (PHOTO)this.getItem(v);
        return q.b((detailBaseRes$PHOTO0 == null ? null : detailBaseRes$PHOTO0.photoImgSizeFlg), "W") ? 2 : 1;
    }

    @Override  // com.iloen.melon.adapters.common.y
    public final void onBindViewHolder(O0 o00, int v, int v1) {
        q.g(o00, "vh");
        q.g(o00, "vh");
        if(o00 instanceof k0) {
            ((k0)o00).a.b.b.setImageDrawable(null);
        }
        else if(o00 instanceof l0) {
            ((l0)o00).a.b.b.setImageDrawable(null);
        }
        PHOTO detailBaseRes$PHOTO0 = (PHOTO)this.getItem(v1);
        n0 n00 = this.b;
        String s = null;
        if(o00 instanceof k0) {
            N1 n10 = ((k0)o00).a;
            RequestManager requestManager0 = Glide.with(a.B(n00));
            if(detailBaseRes$PHOTO0 != null) {
                s = detailBaseRes$PHOTO0.photoImg;
            }
            requestManager0.load(s).into(n10.b.b);
        }
        else if(o00 instanceof l0) {
            O1 o10 = ((l0)o00).a;
            RequestManager requestManager1 = Glide.with(a.B(n00));
            if(detailBaseRes$PHOTO0 != null) {
                s = detailBaseRes$PHOTO0.photoImg;
            }
            requestManager1.load(s).into(o10.b.b);
        }
        n n0 = new n(n00, v1, this.a, 4);
        o00.itemView.setOnClickListener(n0);
    }

    @Override  // androidx.recyclerview.widget.j0
    public final O0 onCreateViewHolder(ViewGroup viewGroup0, int v) {
        q.g(viewGroup0, "parent");
        return v == 2 ? new l0(O1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0)) : new k0(N1.a(LayoutInflater.from(viewGroup0.getContext()), viewGroup0));
    }
}

