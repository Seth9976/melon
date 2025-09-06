package androidx.mediarouter.app;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.MeasureSpec;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.ImageView.ScaleType;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import l4.O;

public final class i implements ViewTreeObserver.OnGlobalLayoutListener {
    public final boolean a;
    public final MediaRouteControllerDialog b;

    public i(MediaRouteControllerDialog mediaRouteControllerDialog0, boolean z) {
        this.b = mediaRouteControllerDialog0;
        this.a = z;
    }

    @Override  // android.view.ViewTreeObserver$OnGlobalLayoutListener
    public final void onGlobalLayout() {
        HashMap hashMap1;
        HashMap hashMap0;
        int v5;
        int v1;
        MediaRouteControllerDialog mediaRouteControllerDialog0 = this.b;
        mediaRouteControllerDialog0.E.getViewTreeObserver().removeGlobalOnLayoutListener(this);
        if(mediaRouteControllerDialog0.B0) {
            mediaRouteControllerDialog0.C0 = true;
            return;
        }
        O o0 = mediaRouteControllerDialog0.i;
        int v = mediaRouteControllerDialog0.V.getLayoutParams().height;
        MediaRouteControllerDialog.l(mediaRouteControllerDialog0.V, -1);
        mediaRouteControllerDialog0.r(mediaRouteControllerDialog0.f());
        View view0 = mediaRouteControllerDialog0.getWindow().getDecorView();
        view0.measure(View.MeasureSpec.makeMeasureSpec(mediaRouteControllerDialog0.getWindow().getAttributes().width, 0x40000000), 0);
        MediaRouteControllerDialog.l(mediaRouteControllerDialog0.V, v);
        if(mediaRouteControllerDialog0.G.getDrawable() instanceof BitmapDrawable) {
            Bitmap bitmap0 = ((BitmapDrawable)mediaRouteControllerDialog0.G.getDrawable()).getBitmap();
            if(bitmap0 == null) {
                v1 = 0;
            }
            else {
                v1 = mediaRouteControllerDialog0.i(bitmap0.getWidth(), bitmap0.getHeight());
                mediaRouteControllerDialog0.G.setScaleType((bitmap0.getWidth() < bitmap0.getHeight() ? ImageView.ScaleType.FIT_CENTER : ImageView.ScaleType.FIT_XY));
            }
        }
        else {
            v1 = 0;
        }
        int v2 = mediaRouteControllerDialog0.j(mediaRouteControllerDialog0.f());
        int v3 = mediaRouteControllerDialog0.c0.size();
        if(mediaRouteControllerDialog0.k()) {
            int v4 = mediaRouteControllerDialog0.k0;
            v5 = Collections.unmodifiableList(o0.v).size() * v4;
        }
        else {
            v5 = 0;
        }
        if(v3 > 0) {
            v5 += mediaRouteControllerDialog0.m0;
        }
        int v6 = mediaRouteControllerDialog0.A0 ? Math.min(v5, mediaRouteControllerDialog0.l0) : 0;
        int v7 = Math.max(v1, v6) + v2;
        Rect rect0 = new Rect();
        view0.getWindowVisibleDisplayFrame(rect0);
        int v8 = mediaRouteControllerDialog0.D.getMeasuredHeight();
        int v9 = mediaRouteControllerDialog0.E.getMeasuredHeight();
        int v10 = rect0.height() - (v8 - v9);
        if(v1 <= 0 || v7 > v10) {
            int v11 = mediaRouteControllerDialog0.Z.getLayoutParams().height;
            if(mediaRouteControllerDialog0.V.getMeasuredHeight() + v11 >= mediaRouteControllerDialog0.E.getMeasuredHeight()) {
                mediaRouteControllerDialog0.G.setVisibility(8);
            }
            v7 = v6 + v2;
            v1 = 0;
        }
        else {
            mediaRouteControllerDialog0.G.setVisibility(0);
            MediaRouteControllerDialog.l(mediaRouteControllerDialog0.G, v1);
        }
        if(!mediaRouteControllerDialog0.f() || v7 > v10) {
            mediaRouteControllerDialog0.W.setVisibility(8);
        }
        else {
            mediaRouteControllerDialog0.W.setVisibility(0);
        }
        mediaRouteControllerDialog0.r(mediaRouteControllerDialog0.W.getVisibility() == 0);
        int v12 = mediaRouteControllerDialog0.j(mediaRouteControllerDialog0.W.getVisibility() == 0);
        int v13 = Math.max(v1, v6) + v12;
        if(v13 > v10) {
            v6 -= v13 - v10;
        }
        else {
            v10 = v13;
        }
        mediaRouteControllerDialog0.V.clearAnimation();
        mediaRouteControllerDialog0.Z.clearAnimation();
        mediaRouteControllerDialog0.E.clearAnimation();
        boolean z = this.a;
        if(z) {
            mediaRouteControllerDialog0.e(mediaRouteControllerDialog0.V, v12);
            mediaRouteControllerDialog0.e(mediaRouteControllerDialog0.Z, v6);
            mediaRouteControllerDialog0.e(mediaRouteControllerDialog0.E, v10);
        }
        else {
            MediaRouteControllerDialog.l(mediaRouteControllerDialog0.V, v12);
            MediaRouteControllerDialog.l(mediaRouteControllerDialog0.Z, v6);
            MediaRouteControllerDialog.l(mediaRouteControllerDialog0.E, v10);
        }
        MediaRouteControllerDialog.l(mediaRouteControllerDialog0.B, rect0.height());
        List list0 = Collections.unmodifiableList(o0.v);
        if(list0.isEmpty()) {
            mediaRouteControllerDialog0.c0.clear();
            mediaRouteControllerDialog0.b0.notifyDataSetChanged();
            return;
        }
        if(new HashSet(mediaRouteControllerDialog0.c0).equals(new HashSet(list0))) {
            mediaRouteControllerDialog0.b0.notifyDataSetChanged();
            return;
        }
        if(z) {
            OverlayListView overlayListView0 = mediaRouteControllerDialog0.Z;
            q q0 = mediaRouteControllerDialog0.b0;
            hashMap0 = new HashMap();
            int v14 = overlayListView0.getFirstVisiblePosition();
            for(int v15 = 0; v15 < overlayListView0.getChildCount(); ++v15) {
                Object object0 = q0.getItem(v14 + v15);
                View view1 = overlayListView0.getChildAt(v15);
                hashMap0.put(object0, new Rect(view1.getLeft(), view1.getTop(), view1.getRight(), view1.getBottom()));
            }
        }
        else {
            hashMap0 = null;
        }
        if(z) {
            Context context0 = mediaRouteControllerDialog0.j;
            OverlayListView overlayListView1 = mediaRouteControllerDialog0.Z;
            q q1 = mediaRouteControllerDialog0.b0;
            hashMap1 = new HashMap();
            int v16 = overlayListView1.getFirstVisiblePosition();
            for(int v17 = 0; v17 < overlayListView1.getChildCount(); ++v17) {
                Object object1 = q1.getItem(v16 + v17);
                View view2 = overlayListView1.getChildAt(v17);
                Bitmap bitmap1 = Bitmap.createBitmap(view2.getWidth(), view2.getHeight(), Bitmap.Config.ARGB_8888);
                view2.draw(new Canvas(bitmap1));
                hashMap1.put(object1, new BitmapDrawable(context0.getResources(), bitmap1));
            }
        }
        else {
            hashMap1 = null;
        }
        ArrayList arrayList0 = mediaRouteControllerDialog0.c0;
        HashSet hashSet0 = new HashSet(list0);
        hashSet0.removeAll(arrayList0);
        mediaRouteControllerDialog0.d0 = hashSet0;
        HashSet hashSet1 = new HashSet(mediaRouteControllerDialog0.c0);
        hashSet1.removeAll(list0);
        mediaRouteControllerDialog0.e0 = hashSet1;
        mediaRouteControllerDialog0.c0.addAll(0, mediaRouteControllerDialog0.d0);
        mediaRouteControllerDialog0.c0.removeAll(mediaRouteControllerDialog0.e0);
        mediaRouteControllerDialog0.b0.notifyDataSetChanged();
        if(z && mediaRouteControllerDialog0.A0 && mediaRouteControllerDialog0.e0.size() + mediaRouteControllerDialog0.d0.size() > 0) {
            mediaRouteControllerDialog0.Z.setEnabled(false);
            mediaRouteControllerDialog0.Z.requestLayout();
            mediaRouteControllerDialog0.B0 = true;
            mediaRouteControllerDialog0.Z.getViewTreeObserver().addOnGlobalLayoutListener(new k(mediaRouteControllerDialog0, hashMap0, hashMap1));
            return;
        }
        mediaRouteControllerDialog0.d0 = null;
        mediaRouteControllerDialog0.e0 = null;
    }
}

