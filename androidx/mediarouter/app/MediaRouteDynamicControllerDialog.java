package androidx.mediarouter.app;

import B.a;
import Bb.e;
import De.I;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.SystemClock;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatDialog;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;
import l4.G;
import l4.N;
import l4.O;
import l4.Q;
import l4.w;

public class MediaRouteDynamicControllerDialog extends AppCompatDialog {
    public final e B;
    public RecyclerView D;
    public J E;
    public K G;
    public HashMap I;
    public O M;
    public HashMap N;
    public boolean S;
    public boolean T;
    public boolean V;
    public ImageButton W;
    public Button X;
    public ImageView Y;
    public View Z;
    public ImageView b0;
    public TextView c0;
    public TextView d0;
    public String e0;
    public final Q f;
    public MediaControllerCompat f0;
    public final D g;
    public final A g0;
    public G h;
    public MediaDescriptionCompat h0;
    public O i;
    public z i0;
    public final ArrayList j;
    public Bitmap j0;
    public final ArrayList k;
    public Uri k0;
    public final ArrayList l;
    public boolean l0;
    public final ArrayList m;
    public Bitmap m0;
    public final Context n;
    public int n0;
    public boolean o;
    public final boolean o0;
    public static final int p0;
    public boolean r;
    public long w;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
    }

    public MediaRouteDynamicControllerDialog(Context context0) {
        ContextThemeWrapper contextThemeWrapper0 = I.w(context0, false);
        int v = I.L(contextThemeWrapper0, 0x7F04043A);  // attr:mediaRouteTheme
        if(v == 0) {
            v = I.J(contextThemeWrapper0);
        }
        super(contextThemeWrapper0, v);
        this.h = G.c;
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.l = new ArrayList();
        this.m = new ArrayList();
        this.B = new e(this, 10);
        Context context1 = this.getContext();
        this.n = context1;
        this.f = Q.d(context1);
        this.o0 = Q.h();
        this.g = new D(this, 0);
        this.i = Q.g();
        this.g0 = new A(this);
        this.f(Q.e());
    }

    public final void d(List list0) {
        for(int v = list0.size() - 1; v >= 0; --v) {
            O o0 = (O)list0.get(v);
            if(o0.d() || !o0.g || !o0.h(this.h) || this.i == o0) {
                list0.remove(v);
            }
        }
    }

    public final void e() {
        Uri uri0 = null;
        Bitmap bitmap0 = this.h0 == null ? null : this.h0.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat0 = this.h0;
        if(mediaDescriptionCompat0 != null) {
            uri0 = mediaDescriptionCompat0.getIconUri();
        }
        Bitmap bitmap1 = this.i0 == null ? this.j0 : this.i0.a;
        if(bitmap1 == bitmap0 && (bitmap1 != null || Objects.equals((this.i0 == null ? this.k0 : this.i0.b), uri0))) {
            return;
        }
        z z0 = this.i0;
        if(z0 != null) {
            z0.cancel(true);
        }
        z z1 = new z(this);
        this.i0 = z1;
        z1.execute(new Void[0]);
    }

    public final void f(Token mediaSessionCompat$Token0) {
        MediaControllerCompat mediaControllerCompat0 = this.f0;
        MediaDescriptionCompat mediaDescriptionCompat0 = null;
        A a0 = this.g0;
        if(mediaControllerCompat0 != null) {
            mediaControllerCompat0.unregisterCallback(a0);
            this.f0 = null;
        }
        if(mediaSessionCompat$Token0 == null || !this.r) {
            return;
        }
        MediaControllerCompat mediaControllerCompat1 = new MediaControllerCompat(this.n, mediaSessionCompat$Token0);
        this.f0 = mediaControllerCompat1;
        mediaControllerCompat1.registerCallback(a0);
        MediaMetadataCompat mediaMetadataCompat0 = this.f0.getMetadata();
        if(mediaMetadataCompat0 != null) {
            mediaDescriptionCompat0 = mediaMetadataCompat0.getDescription();
        }
        this.h0 = mediaDescriptionCompat0;
        this.e();
        this.i();
    }

    public final void g(G g0) {
        if(g0 == null) {
            throw new IllegalArgumentException("selector must not be null");
        }
        if(!this.h.equals(g0)) {
            this.h = g0;
            if(this.r) {
                this.f.j(this.g);
                this.f.a(g0, this.g, 1);
                this.j();
            }
        }
    }

    public final void h() {
        int v = -1;
        int v1 = this.n.getResources().getBoolean(0x7F050009) ? a.z(this.n) : -1;  // bool:is_tablet
        if(this.n.getResources().getBoolean(0x7F050009)) {  // bool:is_tablet
            v = -2;
        }
        this.getWindow().setLayout(v1, v);
        this.j0 = null;
        this.k0 = null;
        this.e();
        this.i();
        this.k();
    }

    public final void i() {
        int v = this.M != null || this.S ? 1 : !this.o;
        if(v != 0) {
            this.V = true;
            return;
        }
        this.V = false;
        if(!this.i.g() || this.i.d()) {
            this.dismiss();
        }
        CharSequence charSequence0 = null;
        if(!this.l0 || (this.m0 != null && this.m0.isRecycled() || this.m0 == null)) {
            if(this.m0 != null && this.m0.isRecycled()) {
                Log.w("MediaRouteCtrlDialog", "Can\'t set artwork image with recycled bitmap: " + this.m0);
            }
            this.b0.setVisibility(8);
            this.Z.setVisibility(8);
            this.Y.setImageBitmap(null);
        }
        else {
            this.b0.setVisibility(0);
            this.b0.setImageBitmap(this.m0);
            this.b0.setBackgroundColor(this.n0);
            this.Z.setVisibility(0);
            Bitmap bitmap0 = this.m0;
            RenderScript renderScript0 = RenderScript.create(this.n);
            Allocation allocation0 = Allocation.createFromBitmap(renderScript0, bitmap0);
            Allocation allocation1 = Allocation.createTyped(renderScript0, allocation0.getType());
            ScriptIntrinsicBlur scriptIntrinsicBlur0 = ScriptIntrinsicBlur.create(renderScript0, Element.U8_4(renderScript0));
            scriptIntrinsicBlur0.setRadius(10.0f);
            scriptIntrinsicBlur0.setInput(allocation0);
            scriptIntrinsicBlur0.forEach(allocation1);
            Bitmap bitmap1 = bitmap0.copy(bitmap0.getConfig(), true);
            allocation1.copyTo(bitmap1);
            allocation0.destroy();
            allocation1.destroy();
            scriptIntrinsicBlur0.destroy();
            renderScript0.destroy();
            this.Y.setImageBitmap(bitmap1);
        }
        this.l0 = false;
        this.m0 = null;
        this.n0 = 0;
        CharSequence charSequence1 = this.h0 == null ? null : this.h0.getTitle();
        boolean z = TextUtils.isEmpty(charSequence1);
        MediaDescriptionCompat mediaDescriptionCompat0 = this.h0;
        if(mediaDescriptionCompat0 != null) {
            charSequence0 = mediaDescriptionCompat0.getSubtitle();
        }
        boolean z1 = TextUtils.isEmpty(charSequence0);
        if(z) {
            this.c0.setText(this.e0);
        }
        else {
            this.c0.setText(charSequence1);
        }
        if(!z1) {
            this.d0.setText(charSequence0);
            this.d0.setVisibility(0);
            return;
        }
        this.d0.setVisibility(8);
    }

    public final void j() {
        ArrayList arrayList0 = this.j;
        arrayList0.clear();
        ArrayList arrayList1 = this.k;
        arrayList1.clear();
        ArrayList arrayList2 = this.l;
        arrayList2.clear();
        arrayList0.addAll(Collections.unmodifiableList(this.i.v));
        l4.K k0 = this.i.a();
        if(k0 != null) {
            N n0 = this.i.a;
            n0.getClass();
            Q.b();
            for(Object object0: Collections.unmodifiableList(n0.b)) {
                O o0 = (O)object0;
                if(k0.o(o0)) {
                    arrayList1.add(o0);
                }
                w w0 = (w)k0.x.get(o0.c);
                if(w0 != null && w0.e) {
                    arrayList2.add(o0);
                }
            }
        }
        this.d(arrayList1);
        this.d(arrayList2);
        Collections.sort(arrayList0, c.d);
        Collections.sort(arrayList1, c.d);
        Collections.sort(arrayList2, c.d);
        this.E.d();
    }

    public final void k() {
        if(this.r) {
            if(Long.compare(SystemClock.uptimeMillis() - this.w, 300L) >= 0) {
                int v = this.M != null || this.S ? 1 : !this.o;
                if(v != 0) {
                    this.T = true;
                    return;
                }
                this.T = false;
                if(!this.i.g() || this.i.d()) {
                    this.dismiss();
                }
                this.w = SystemClock.uptimeMillis();
                this.E.c();
                return;
            }
            this.B.removeMessages(1);
            this.B.sendEmptyMessageAtTime(1, this.w + 300L);
        }
    }

    public final void l() {
        if(this.T) {
            this.k();
        }
        if(this.V) {
            this.i();
        }
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.r = true;
        this.f.a(this.h, this.g, 1);
        this.j();
        this.f(Q.e());
    }

    @Override  // androidx.appcompat.app.AppCompatDialog
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.setContentView(0x7F0D0520);  // layout:mr_cast_dialog
        View view0 = this.getWindow().getDecorView();
        int v = I.N(this.n) ? 0x7F0603FE : 0x7F0603FD;  // color:mr_dynamic_dialog_background_light
        view0.setBackgroundColor(P1.c.getColor(this.n, v));
        ImageButton imageButton0 = (ImageButton)this.findViewById(0x7F0A082C);  // id:mr_cast_close_button
        this.W = imageButton0;
        imageButton0.setColorFilter(-1);
        this.W.setOnClickListener(new y(this, 0));
        Button button0 = (Button)this.findViewById(0x7F0A083C);  // id:mr_cast_stop_button
        this.X = button0;
        button0.setTextColor(-1);
        this.X.setOnClickListener(new y(this, 1));
        this.E = new J(this);
        RecyclerView recyclerView0 = (RecyclerView)this.findViewById(0x7F0A0832);  // id:mr_cast_list
        this.D = recyclerView0;
        recyclerView0.setAdapter(this.E);
        this.D.setLayoutManager(new LinearLayoutManager(this.n));
        this.G = new K(this);
        this.I = new HashMap();
        this.N = new HashMap();
        this.Y = (ImageView)this.findViewById(0x7F0A0834);  // id:mr_cast_meta_background
        this.Z = this.findViewById(0x7F0A0835);  // id:mr_cast_meta_black_scrim
        this.b0 = (ImageView)this.findViewById(0x7F0A0833);  // id:mr_cast_meta_art
        TextView textView0 = (TextView)this.findViewById(0x7F0A0837);  // id:mr_cast_meta_title
        this.c0 = textView0;
        textView0.setTextColor(-1);
        TextView textView1 = (TextView)this.findViewById(0x7F0A0836);  // id:mr_cast_meta_subtitle
        this.d0 = textView1;
        textView1.setTextColor(-1);
        this.e0 = "No info available";
        this.o = true;
        this.h();
    }

    @Override  // android.app.Dialog
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.r = false;
        this.f.j(this.g);
        this.B.removeCallbacksAndMessages(null);
        this.f(null);
    }
}

