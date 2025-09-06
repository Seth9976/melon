package androidx.mediarouter.app;

import B.a;
import De.I;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat.Token;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.g;
import d5.c;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;
import l4.G;
import l4.O;
import l4.Q;

public class MediaRouteControllerDialog extends g {
    public boolean A0;
    public FrameLayout B;
    public boolean B0;
    public boolean C0;
    public LinearLayout D;
    public int D0;
    public FrameLayout E;
    public int E0;
    public int F0;
    public ImageView G;
    public Interpolator G0;
    public final Interpolator H0;
    public TextView I;
    public final Interpolator I0;
    public final AccessibilityManager J0;
    public final f K0;
    public static final int L0;
    public TextView M;
    public TextView N;
    public final boolean S;
    public final boolean T;
    public LinearLayout V;
    public RelativeLayout W;
    public LinearLayout X;
    public View Y;
    public OverlayListView Z;
    public q b0;
    public ArrayList c0;
    public HashSet d0;
    public HashSet e0;
    public HashSet f0;
    public final Q g;
    public SeekBar g0;
    public final D h;
    public p h0;
    public final O i;
    public O i0;
    public final Context j;
    public int j0;
    public boolean k;
    public int k0;
    public boolean l;
    public int l0;
    public int m;
    public final int m0;
    public Button n;
    public HashMap n0;
    public Button o;
    public MediaControllerCompat o0;
    public final o p0;
    public PlaybackStateCompat q0;
    public ImageButton r;
    public MediaDescriptionCompat r0;
    public n s0;
    public Bitmap t0;
    public Uri u0;
    public boolean v0;
    public MediaRouteExpandCollapseButton w;
    public Bitmap w0;
    public int x0;
    public boolean y0;
    public boolean z0;

    static {
        Log.isLoggable("MediaRouteCtrlDialog", 3);
        MediaRouteControllerDialog.L0 = (int)TimeUnit.SECONDS.toMillis(30L);
    }

    public MediaRouteControllerDialog(Context context0) {
        ContextThemeWrapper contextThemeWrapper0 = I.w(context0, true);
        int v = I.L(contextThemeWrapper0, 0x7F04043A);  // attr:mediaRouteTheme
        if(v == 0) {
            v = I.J(contextThemeWrapper0);
        }
        super(contextThemeWrapper0, v);
        this.S = true;
        this.K0 = new f(this, 0);
        Context context1 = this.getContext();
        this.j = context1;
        this.p0 = new o(this);
        this.g = Q.d(context1);
        this.T = Q.h();
        this.h = new D(this, 3);
        this.i = Q.g();
        this.m(Q.e());
        this.m0 = context1.getResources().getDimensionPixelSize(0x7F07031F);  // dimen:mr_controller_volume_group_list_padding_top
        this.J0 = (AccessibilityManager)context1.getSystemService("accessibility");
        this.H0 = AnimationUtils.loadInterpolator(contextThemeWrapper0, 0x7F0C0015);  // interpolator:mr_linear_out_slow_in
        this.I0 = AnimationUtils.loadInterpolator(contextThemeWrapper0, 0x7F0C0014);  // interpolator:mr_fast_out_slow_in
    }

    public final void e(View view0, int v) {
        j j0 = new j(view0, view0.getLayoutParams().height, v, 0);
        j0.setDuration(((long)this.D0));
        j0.setInterpolator(this.G0);
        view0.startAnimation(j0);
    }

    public final boolean f() {
        return this.r0 != null || this.q0 != null;
    }

    public final void g(boolean z) {
        int v = this.Z.getFirstVisiblePosition();
        for(int v1 = 0; v1 < this.Z.getChildCount(); ++v1) {
            View view0 = this.Z.getChildAt(v1);
            O o0 = (O)this.b0.getItem(v + v1);
            if(!z || (this.d0 == null || !this.d0.contains(o0))) {
                ((LinearLayout)view0.findViewById(0x7F0A0DE1)).setVisibility(0);  // id:volume_item_container
                AnimationSet animationSet0 = new AnimationSet(true);
                AlphaAnimation alphaAnimation0 = new AlphaAnimation(1.0f, 1.0f);
                alphaAnimation0.setDuration(0L);
                animationSet0.addAnimation(alphaAnimation0);
                new TranslateAnimation(0.0f, 0.0f, 0.0f, 0.0f).setDuration(0L);
                animationSet0.setFillAfter(true);
                animationSet0.setFillEnabled(true);
                view0.clearAnimation();
                view0.startAnimation(animationSet0);
            }
        }
        for(Object object0: this.Z.a) {
            ((L)object0).j = true;
            ((L)object0).k = true;
            c c0 = ((L)object0).l;
            if(c0 != null) {
                MediaRouteControllerDialog mediaRouteControllerDialog0 = (MediaRouteControllerDialog)c0.c;
                mediaRouteControllerDialog0.f0.remove(((O)c0.b));
                mediaRouteControllerDialog0.b0.notifyDataSetChanged();
            }
        }
        if(!z) {
            this.h(false);
        }
    }

    public final void h(boolean z) {
        this.d0 = null;
        this.e0 = null;
        this.B0 = false;
        if(this.C0) {
            this.C0 = false;
            this.q(z);
        }
        this.Z.setEnabled(true);
    }

    public final int i(int v, int v1) {
        return v < v1 ? ((int)(((float)this.m) * 9.0f / 16.0f + 0.5f)) : ((int)(((float)this.m) * ((float)v1) / ((float)v) + 0.5f));
    }

    public final int j(boolean z) {
        if(!z && this.X.getVisibility() != 0) {
            return 0;
        }
        int v = this.V.getPaddingTop();
        int v1 = this.V.getPaddingBottom() + v;
        if(z) {
            v1 += this.W.getMeasuredHeight();
        }
        if(this.X.getVisibility() == 0) {
            v1 += this.X.getMeasuredHeight();
        }
        return !z || this.X.getVisibility() != 0 ? v1 : this.Y.getMeasuredHeight() + v1;
    }

    public final boolean k() {
        return this.i.e() && Collections.unmodifiableList(this.i.v).size() > 1;
    }

    public static void l(View view0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        viewGroup$LayoutParams0.height = v;
        view0.setLayoutParams(viewGroup$LayoutParams0);
    }

    public final void m(Token mediaSessionCompat$Token0) {
        MediaControllerCompat mediaControllerCompat0 = this.o0;
        MediaDescriptionCompat mediaDescriptionCompat0 = null;
        o o0 = this.p0;
        if(mediaControllerCompat0 != null) {
            mediaControllerCompat0.unregisterCallback(o0);
            this.o0 = null;
        }
        if(mediaSessionCompat$Token0 == null || !this.l) {
            return;
        }
        MediaControllerCompat mediaControllerCompat1 = new MediaControllerCompat(this.j, mediaSessionCompat$Token0);
        this.o0 = mediaControllerCompat1;
        mediaControllerCompat1.registerCallback(o0);
        MediaMetadataCompat mediaMetadataCompat0 = this.o0.getMetadata();
        if(mediaMetadataCompat0 != null) {
            mediaDescriptionCompat0 = mediaMetadataCompat0.getDescription();
        }
        this.r0 = mediaDescriptionCompat0;
        this.q0 = this.o0.getPlaybackState();
        this.o();
        this.n(false);
    }

    public final void n(boolean z) {
        int v2;
        int v1;
        boolean z6;
        boolean z5;
        boolean z1 = true;
        if(this.i0 != null) {
            this.y0 = true;
            this.z0 |= z;
            return;
        }
        int v = 0;
        this.y0 = false;
        this.z0 = false;
        O o0 = this.i;
        if(o0.g() && !o0.d()) {
            if(!this.k) {
                return;
            }
            this.N.setText(o0.d);
            this.n.setVisibility((o0.j ? 0 : 8));
            CharSequence charSequence0 = null;
            if(this.v0) {
                if(this.w0 == null || !this.w0.isRecycled()) {
                    this.G.setImageBitmap(this.w0);
                    this.G.setBackgroundColor(this.x0);
                }
                else {
                    Log.w("MediaRouteCtrlDialog", "Can\'t set artwork image with recycled bitmap: " + this.w0);
                }
                this.v0 = false;
                this.w0 = null;
                this.x0 = 0;
            }
            boolean z2 = this.T;
            if(!z2 && this.k()) {
                this.X.setVisibility(8);
                this.A0 = true;
                this.Z.setVisibility(0);
                this.G0 = this.A0 ? this.H0 : this.I0;
                this.q(false);
            }
            else if(this.A0 && !z2 || (!this.S || (!o0.e() || Q.h() ? o0.o : 0) != 1)) {
                this.X.setVisibility(8);
            }
            else if(this.X.getVisibility() == 8) {
                this.X.setVisibility(0);
                this.g0.setMax(o0.q);
                this.g0.setProgress(o0.p);
                this.w.setVisibility((this.k() ? 0 : 8));
            }
            if(this.f()) {
                CharSequence charSequence1 = this.r0 == null ? null : this.r0.getTitle();
                boolean z3 = TextUtils.isEmpty(charSequence1);
                MediaDescriptionCompat mediaDescriptionCompat0 = this.r0;
                if(mediaDescriptionCompat0 != null) {
                    charSequence0 = mediaDescriptionCompat0.getSubtitle();
                }
                boolean z4 = TextUtils.isEmpty(charSequence0);
                if(o0.r != -1) {
                    this.I.setText(0x7F1306C1);  // string:mr_controller_casting_screen "Casting screen"
                    z5 = false;
                    z6 = true;
                }
                else if(this.q0 == null || this.q0.getState() == 0) {
                    this.I.setText(0x7F1306C7);  // string:mr_controller_no_media_selected "No media selected"
                    z5 = false;
                    z6 = true;
                }
                else if(z3 && z4) {
                    this.I.setText(0x7F1306C6);  // string:mr_controller_no_info_available "No info available"
                    z5 = false;
                    z6 = true;
                }
                else {
                    if(z3) {
                        z6 = false;
                    }
                    else {
                        this.I.setText(charSequence1);
                        z6 = true;
                    }
                    if(z4) {
                        z5 = false;
                    }
                    else {
                        this.M.setText(charSequence0);
                        z5 = true;
                    }
                }
                this.I.setVisibility((z6 ? 0 : 8));
                this.M.setVisibility((z5 ? 0 : 8));
                PlaybackStateCompat playbackStateCompat0 = this.q0;
                if(playbackStateCompat0 != null) {
                    boolean z7 = playbackStateCompat0.getState() == 6 || this.q0.getState() == 3;
                    Context context0 = this.r.getContext();
                    if(z7 && (this.q0.getActions() & 0x202L) != 0L) {
                        v1 = 0x7F040435;  // attr:mediaRoutePauseDrawable
                        v2 = 0x7F1306C8;  // string:mr_controller_pause "Pause"
                    }
                    else if(z7 && (this.q0.getActions() & 1L) != 0L) {
                        v1 = 0x7F040439;  // attr:mediaRouteStopDrawable
                        v2 = 0x7F1306CA;  // string:mr_controller_stop "Stop"
                    }
                    else if(z7 || (this.q0.getActions() & 0x204L) == 0L) {
                        z1 = false;
                        v1 = 0;
                        v2 = 0;
                    }
                    else {
                        v1 = 0x7F040436;  // attr:mediaRoutePlayDrawable
                        v2 = 0x7F1306C9;  // string:mr_controller_play "Play"
                    }
                    ImageButton imageButton0 = this.r;
                    if(!z1) {
                        v = 8;
                    }
                    imageButton0.setVisibility(v);
                    if(z1) {
                        this.r.setImageResource(I.L(context0, v1));
                        this.r.setContentDescription(context0.getResources().getText(v2));
                    }
                }
            }
            this.q(z);
            return;
        }
        this.dismiss();
    }

    public final void o() {
        Uri uri0 = null;
        Bitmap bitmap0 = this.r0 == null ? null : this.r0.getIconBitmap();
        MediaDescriptionCompat mediaDescriptionCompat0 = this.r0;
        if(mediaDescriptionCompat0 != null) {
            uri0 = mediaDescriptionCompat0.getIconUri();
        }
        Bitmap bitmap1 = this.s0 == null ? this.t0 : this.s0.a;
        Uri uri1 = this.s0 == null ? this.u0 : this.s0.b;
        if((bitmap1 != bitmap0 || bitmap1 == null && (uri1 == null || !uri1.equals(uri0)) && (uri1 != null || uri0 != null)) && (!this.k() || this.T)) {
            n n0 = this.s0;
            if(n0 != null) {
                n0.cancel(true);
            }
            n n1 = new n(this);
            this.s0 = n1;
            n1.execute(new Void[0]);
        }
    }

    @Override  // android.app.Dialog
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.l = true;
        this.g.a(G.c, this.h, 2);
        this.m(Q.e());
    }

    @Override  // androidx.appcompat.app.g
    public final void onCreate(Bundle bundle0) {
        super.onCreate(bundle0);
        this.getWindow().setBackgroundDrawableResource(0x106000D);
        this.setContentView(0x7F0D0528);  // layout:mr_controller_material_dialog_b
        this.findViewById(0x102001B).setVisibility(8);
        m m0 = new m(this);
        FrameLayout frameLayout0 = (FrameLayout)this.findViewById(0x7F0A0856);  // id:mr_expandable_area
        this.B = frameLayout0;
        frameLayout0.setOnClickListener(new h(this, 1));
        LinearLayout linearLayout0 = (LinearLayout)this.findViewById(0x7F0A0855);  // id:mr_dialog_area
        this.D = linearLayout0;
        linearLayout0.setOnClickListener(new androidx.mediarouter.app.g());  // 初始化器: Ljava/lang/Object;-><init>()V
        Context context0 = this.j;
        int v = I.K(context0, 0, 0x7F040182);  // attr:colorPrimary
        if(S1.c.e(v, I.K(context0, 0, 0x1010031)) < 3.0) {
            v = I.K(context0, 0, 0x7F040162);  // attr:colorAccent
        }
        Button button0 = (Button)this.findViewById(0x102001A);
        this.n = button0;
        button0.setText(0x7F1306C4);  // string:mr_controller_disconnect "Disconnect"
        this.n.setTextColor(v);
        this.n.setOnClickListener(m0);
        Button button1 = (Button)this.findViewById(0x1020019);
        this.o = button1;
        button1.setText(0x7F1306CB);  // string:mr_controller_stop_casting "Stop casting"
        this.o.setTextColor(v);
        this.o.setOnClickListener(m0);
        this.N = (TextView)this.findViewById(0x7F0A085A);  // id:mr_name
        ((ImageButton)this.findViewById(0x7F0A084D)).setOnClickListener(m0);  // id:mr_close
        FrameLayout frameLayout1 = (FrameLayout)this.findViewById(0x7F0A0853);  // id:mr_custom_control
        this.E = (FrameLayout)this.findViewById(0x7F0A0854);  // id:mr_default_control
        h h0 = new h(this, 2);
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A082A);  // id:mr_art
        this.G = imageView0;
        imageView0.setOnClickListener(h0);
        this.findViewById(0x7F0A0852).setOnClickListener(h0);  // id:mr_control_title_container
        this.V = (LinearLayout)this.findViewById(0x7F0A0859);  // id:mr_media_main_control
        this.Y = this.findViewById(0x7F0A084E);  // id:mr_control_divider
        this.W = (RelativeLayout)this.findViewById(0x7F0A0861);  // id:mr_playback_control
        this.I = (TextView)this.findViewById(0x7F0A0851);  // id:mr_control_title
        this.M = (TextView)this.findViewById(0x7F0A0850);  // id:mr_control_subtitle
        ImageButton imageButton0 = (ImageButton)this.findViewById(0x7F0A084F);  // id:mr_control_playback_ctrl
        this.r = imageButton0;
        imageButton0.setOnClickListener(m0);
        LinearLayout linearLayout1 = (LinearLayout)this.findViewById(0x7F0A0863);  // id:mr_volume_control
        this.X = linearLayout1;
        linearLayout1.setVisibility(8);
        SeekBar seekBar0 = (SeekBar)this.findViewById(0x7F0A0866);  // id:mr_volume_slider
        this.g0 = seekBar0;
        O o0 = this.i;
        seekBar0.setTag(o0);
        p p0 = new p(this);
        this.h0 = p0;
        this.g0.setOnSeekBarChangeListener(p0);
        this.Z = (OverlayListView)this.findViewById(0x7F0A0864);  // id:mr_volume_group_list
        this.c0 = new ArrayList();
        q q0 = new q(this, this.Z.getContext(), this.c0);
        this.b0 = q0;
        this.Z.setAdapter(q0);
        this.f0 = new HashSet();
        LinearLayout linearLayout2 = this.V;
        OverlayListView overlayListView0 = this.Z;
        boolean z = this.k();
        int v1 = I.K(context0, 0, 0x7F040182);  // attr:colorPrimary
        int v2 = I.K(context0, 0, 0x7F040184);  // attr:colorPrimaryDark
        if(z && I.E(context0, 0) == 0xDE000000) {
            v2 = v1;
            v1 = -1;
        }
        linearLayout2.setBackgroundColor(v1);
        overlayListView0.setBackgroundColor(v2);
        linearLayout2.setTag(v1);
        overlayListView0.setTag(v2);
        MediaRouteVolumeSlider mediaRouteVolumeSlider0 = (MediaRouteVolumeSlider)this.g0;
        LinearLayout linearLayout3 = this.V;
        int v3 = I.E(context0, 0);
        if(Color.alpha(v3) != 0xFF) {
            v3 = S1.c.h(v3, ((int)(((Integer)linearLayout3.getTag()))));
        }
        mediaRouteVolumeSlider0.a(v3, v3);
        HashMap hashMap0 = new HashMap();
        this.n0 = hashMap0;
        hashMap0.put(o0, this.g0);
        MediaRouteExpandCollapseButton mediaRouteExpandCollapseButton0 = (MediaRouteExpandCollapseButton)this.findViewById(0x7F0A0857);  // id:mr_group_expand_collapse
        this.w = mediaRouteExpandCollapseButton0;
        mediaRouteExpandCollapseButton0.i = new h(this, 0);
        this.G0 = this.A0 ? this.H0 : this.I0;
        this.D0 = context0.getResources().getInteger(0x7F0B003B);  // integer:mr_controller_volume_group_list_animation_duration_ms
        this.E0 = context0.getResources().getInteger(0x7F0B003C);  // integer:mr_controller_volume_group_list_fade_in_duration_ms
        this.F0 = context0.getResources().getInteger(0x7F0B003D);  // integer:mr_controller_volume_group_list_fade_out_duration_ms
        this.k = true;
        this.p();
    }

    @Override  // android.app.Dialog
    public final void onDetachedFromWindow() {
        this.g.j(this.h);
        this.m(null);
        this.l = false;
        super.onDetachedFromWindow();
    }

    @Override  // androidx.appcompat.app.g
    public final boolean onKeyDown(int v, KeyEvent keyEvent0) {
        if(v != 24 && v != 25) {
            return super.onKeyDown(v, keyEvent0);
        }
        if(this.T || !this.A0) {
            this.i.k((v == 25 ? -1 : 1));
        }
        return true;
    }

    @Override  // androidx.appcompat.app.g
    public final boolean onKeyUp(int v, KeyEvent keyEvent0) {
        return v == 24 || v == 25 ? true : super.onKeyUp(v, keyEvent0);
    }

    public final void p() {
        int v = a.z(this.j);
        this.getWindow().setLayout(v, -2);
        View view0 = this.getWindow().getDecorView();
        this.m = v - view0.getPaddingLeft() - view0.getPaddingRight();
        Resources resources0 = this.j.getResources();
        this.j0 = resources0.getDimensionPixelSize(0x7F07031D);  // dimen:mr_controller_volume_group_list_item_icon_size
        this.k0 = resources0.getDimensionPixelSize(0x7F07031C);  // dimen:mr_controller_volume_group_list_item_height
        this.l0 = resources0.getDimensionPixelSize(0x7F07031E);  // dimen:mr_controller_volume_group_list_max_height
        this.t0 = null;
        this.u0 = null;
        this.o();
        this.n(false);
    }

    public final void q(boolean z) {
        this.E.requestLayout();
        this.E.getViewTreeObserver().addOnGlobalLayoutListener(new i(this, z));
    }

    public final void r(boolean z) {
        int v = 0;
        this.Y.setVisibility((this.X.getVisibility() != 0 || !z ? 8 : 0));
        LinearLayout linearLayout0 = this.V;
        if(this.X.getVisibility() == 8 && !z) {
            v = 8;
        }
        linearLayout0.setVisibility(v);
    }
}

