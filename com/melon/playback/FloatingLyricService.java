package com.melon.playback;

import Gd.f;
import Nb.b;
import Nb.c;
import Nb.d;
import Nb.e;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Configuration;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleService;
import androidx.lifecycle.f0;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.eventbus.EventActivityState.EventActivityResumed;
import com.iloen.melon.eventbus.EventActivityState;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.lyric.LyricsInfo;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU.Companion;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import d3.g;
import d9.h;
import d9.j;
import ie.r;
import java.util.ArrayList;
import java.util.List;
import k8.t;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.Dispatchers;
import ob.z;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000\u001A\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001A\u00020\u00062\b\u0010\u0005\u001A\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/melon/playback/FloatingLyricService;", "Landroidx/lifecycle/LifecycleService;", "<init>", "()V", "Lcom/iloen/melon/eventbus/EventActivityState;", "event", "Lie/H;", "onEventBackgroundThread", "(Lcom/iloen/melon/eventbus/EventActivityState;)V", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class FloatingLyricService extends LifecycleService {
    public e B;
    public e D;
    public FloatingLyricService.getBroadcastReceiver.1 E;
    public static final int G;
    public final r a;
    public final r b;
    public WindowManager c;
    public WindowManager.LayoutParams d;
    public View e;
    public ImageView f;
    public ImageView g;
    public ImageView h;
    public View i;
    public View j;
    public TextView k;
    public TextView l;
    public Playable m;
    public List n;
    public boolean o;
    public final Handler r;
    public h w;

    static {
    }

    public FloatingLyricService() {
        this.a = g.Q(new b(this, 0));
        this.b = g.Q(new b(this, 1));
        this.r = new Handler(Looper.getMainLooper());
        this.n = new ArrayList();
    }

    public static final void a(FloatingLyricService floatingLyricService0) {
        int v = MelonSettingInfo.getLaboratoryFloatingLyricSkinType();
        if(!floatingLyricService0.o) {
            TextView textView0 = floatingLyricService0.k;
            if(textView0 != null) {
                textView0.setTextColor(ColorUtils.getColor(floatingLyricService0, (v == 0 ? 0x7F0604A1 : 0x7F060171)));  // color:white000e
                textView0.setText("등록된 가사가 없습니다");
            }
            TextView textView1 = floatingLyricService0.l;
            if(textView1 != null) {
                textView1.setText("");
            }
            ViewUtils.hideWhen(floatingLyricService0.j, true);
            ViewUtils.hideWhen(floatingLyricService0.l, true);
            return;
        }
        TextView textView2 = floatingLyricService0.k;
        if(textView2 != null) {
            textView2.setMaxLines(2);
            textView2.setTextColor(ColorUtils.getColor(floatingLyricService0, 0x7F06017A));  // color:green500e_support_high_contrast
            if(!floatingLyricService0.n.isEmpty()) {
                textView2.setText(((LyricsInfo)floatingLyricService0.n.get(0)).b);
            }
        }
        TextView textView3 = floatingLyricService0.l;
        if(textView3 != null) {
            textView3.setMaxLines(2);
            if(floatingLyricService0.n.size() > 1) {
                textView3.setText(((LyricsInfo)floatingLyricService0.n.get(1)).b);
            }
        }
        ViewUtils.showWhen(floatingLyricService0.j, true);
        ViewUtils.showWhen(floatingLyricService0.l, true);
    }

    public final void b() {
        LogU.Companion.i("FloatingLyricService", "initLayoutParams()");
        WindowManager.LayoutParams windowManager$LayoutParams0 = new WindowManager.LayoutParams(ScreenUtils.getScreenWidth(this) - ScreenUtils.dipToPixel(this, 24.0f), -2, 0x7F6, 8, -3);
        this.d = windowManager$LayoutParams0;
        windowManager$LayoutParams0.gravity = 81;
        int v = (int)(((float)ScreenUtils.getScreenHeight(this)) * 0.3f);
        WindowManager.LayoutParams windowManager$LayoutParams1 = this.d;
        q.d(windowManager$LayoutParams1);
        windowManager$LayoutParams1.x = 0;
        WindowManager.LayoutParams windowManager$LayoutParams2 = this.d;
        q.d(windowManager$LayoutParams2);
        windowManager$LayoutParams2.y = MelonPrefs.getInstance().getInt("FloatingLyricY", v);
    }

    public final void c() {
        int v = MelonSettingInfo.getLaboratoryFloatingLyricAlpha();
        int v1 = MelonSettingInfo.getLaboratoryFloatingLyricSkinType();
        FloatingLyricHelper floatingLyricHelper0 = FloatingLyricHelper.INSTANCE;
        int v2 = floatingLyricHelper0.getFontIndex();
        float f = floatingLyricHelper0.getFontSize(v2);
        int v3 = ScreenUtils.dipToPixel(this, floatingLyricHelper0.getLayoutHeight(v2));
        int v4 = ScreenUtils.dipToPixel(this, floatingLyricHelper0.getTextviewGap(v2));
        if(v1 == 0) {
            View view0 = this.e;
            q.d(view0);
            view0.setBackgroundResource(0x7F0800C8);  // drawable:bg_floatinglyric_black
            ImageView imageView0 = this.f;
            q.d(imageView0);
            imageView0.setImageResource(0x7F0805D2);  // drawable:ic_setting_melon_symbol_b
            ImageView imageView1 = this.g;
            q.d(imageView1);
            imageView1.setImageResource(0x7F08025B);  // drawable:btn_setting_lab_close_b
            ImageView imageView2 = this.h;
            q.d(imageView2);
            imageView2.setImageResource(0x7F0802AB);  // drawable:btn_widget_setup_b
            TextView textView0 = this.k;
            q.d(textView0);
            textView0.setTextColor(ColorUtils.getColor(this, 0x7F06017A));  // color:green500e_support_high_contrast
            TextView textView1 = this.l;
            q.d(textView1);
            textView1.setTextColor(ColorUtils.getColor(this, 0x7F0604A1));  // color:white000e
        }
        else {
            View view1 = this.e;
            q.d(view1);
            view1.setBackgroundResource(0x7F0800C9);  // drawable:bg_floatinglyric_white
            ImageView imageView3 = this.f;
            q.d(imageView3);
            imageView3.setImageResource(0x7F0805D3);  // drawable:ic_setting_melon_symbol_w
            ImageView imageView4 = this.g;
            q.d(imageView4);
            imageView4.setImageResource(0x7F08025C);  // drawable:btn_setting_lab_close_w
            ImageView imageView5 = this.h;
            q.d(imageView5);
            imageView5.setImageResource(0x7F0802AC);  // drawable:btn_widget_setup_w
            TextView textView2 = this.k;
            q.d(textView2);
            textView2.setTextColor(ColorUtils.getColor(this, 0x7F06017A));  // color:green500e_support_high_contrast
            TextView textView3 = this.l;
            q.d(textView3);
            textView3.setTextColor(ColorUtils.getColor(this, 0x7F060171));  // color:gray990e
        }
        TextView textView4 = this.k;
        q.d(textView4);
        textView4.setTextSize(1, f);
        TextView textView5 = this.k;
        q.d(textView5);
        textView5.setLineSpacing(((float)v4), 1.0f);
        TextView textView6 = this.l;
        q.d(textView6);
        textView6.setTextSize(1, f);
        TextView textView7 = this.l;
        q.d(textView7);
        textView7.setLineSpacing(((float)v4), 1.0f);
        View view2 = this.j;
        q.d(view2);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view2.getLayoutParams();
        viewGroup$LayoutParams0.height = v4;
        View view3 = this.j;
        q.d(view3);
        view3.setLayoutParams(viewGroup$LayoutParams0);
        View view4 = this.i;
        q.d(view4);
        ViewGroup.LayoutParams viewGroup$LayoutParams1 = view4.getLayoutParams();
        viewGroup$LayoutParams1.height = v3;
        View view5 = this.i;
        q.d(view5);
        view5.setLayoutParams(viewGroup$LayoutParams1);
        View view6 = this.e;
        q.d(view6);
        view6.getBackground().setAlpha(floatingLyricHelper0.getAlphaValue(v));
        View view7 = this.e;
        q.d(view7);
        view7.invalidate();
        WindowManager.LayoutParams windowManager$LayoutParams0 = this.d;
        q.d(windowManager$LayoutParams0);
        windowManager$LayoutParams0.height = v3;
        WindowManager windowManager0 = this.c;
        q.d(windowManager0);
        windowManager0.updateViewLayout(this.e, this.d);
        ViewUtils.hideWhen(this.e, true);
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final IBinder onBind(Intent intent0) {
        q.g(intent0, "intent");
        LogU.Companion.d("FloatingLyricService", "onBind()");
        BuildersKt__Builders_commonKt.launch$default(f0.f(this), Dispatchers.getMain(), null, new c(this, null), 2, null);
        return super.onBind(intent0);
    }

    @Override  // android.app.Service
    public final void onConfigurationChanged(Configuration configuration0) {
        q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        LogU.Companion.d("FloatingLyricService", "onConfigurationChanged()");
        if(this.c != null && this.e != null) {
            this.b();
            WindowManager windowManager0 = this.c;
            q.d(windowManager0);
            windowManager0.updateViewLayout(this.e, this.d);
        }
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onCreate() {
        View view2;
        super.onCreate();
        Companion logU$Companion0 = LogU.Companion;
        logU$Companion0.d("FloatingLyricService", "onCreate()");
        if(Settings.canDrawOverlays(this)) {
            MelonAppBase.Companion.getClass();
            if(t.a().isAppForeground()) {
                logU$Companion0.d("FloatingLyricService", "isServiceInUse() Melon is foreground. stop self.");
            }
            else if(t.a().isCarConnected()) {
                logU$Companion0.d("FloatingLyricService", "isServiceInUse() AndroidAuto is running");
            }
            else if(MelonSettingInfo.isUseLaboratoryFloatingLyric() && ((z)this.b.getValue()).n()) {
                Object object0 = this.getSystemService("window");
                q.e(object0, "null cannot be cast to non-null type android.view.WindowManager");
                this.c = (WindowManager)object0;
                EventBusHelper.register(this);
                IntentFilter intentFilter0 = new IntentFilter();
                intentFilter0.addAction("android.intent.action.SCREEN_ON");
                intentFilter0.addAction("android.intent.action.SCREEN_OFF");
                FloatingLyricService.getBroadcastReceiver.1 floatingLyricService$getBroadcastReceiver$10 = new FloatingLyricService.getBroadcastReceiver.1(this);
                this.E = floatingLyricService$getBroadcastReceiver$10;
                ImageView imageView0 = null;
                this.registerReceiver(floatingLyricService$getBroadcastReceiver$10, intentFilter0, "com.iloen.melon.permission.SIG_PERMISSION", null);
                this.b();
                View view0 = LayoutInflater.from(this).inflate(0x7F0D043A, null, false);  // layout:layout_floating_lyric
                this.e = view0;
                this.i = view0 == null ? null : view0.findViewById(0x7F0A0727);  // id:layout_lyric
                this.k = this.e == null ? null : ((TextView)this.e.findViewById(0x7F0A0B5C));  // id:text_preview_1
                this.l = this.e == null ? null : ((TextView)this.e.findViewById(0x7F0A0B5D));  // id:text_preview_2
                this.j = this.e == null ? null : this.e.findViewById(0x7F0A04E6);  // id:gap
                this.f = this.e == null ? null : ((ImageView)this.e.findViewById(0x7F0A064F));  // id:iv_melon_logo
                ImageView imageView1 = this.e == null ? null : ((ImageView)this.e.findViewById(0x7F0A0613));  // id:iv_close
                this.g = imageView1;
                ViewUtils.setOnClickListener(imageView1, new f(1));
                View view1 = this.e;
                if(view1 != null) {
                    imageView0 = (ImageView)view1.findViewById(0x7F0A0688);  // id:iv_setting
                }
                this.h = imageView0;
                ViewUtils.setOnClickListener(imageView0, new A6.b(this, 16));
                try {
                    WindowManager windowManager0 = this.c;
                    q.d(windowManager0);
                    windowManager0.addView(this.e, this.d);
                    this.c();
                    view2 = this.e;
                }
                catch(Exception exception0) {
                    LogU.Companion.e("FloatingLyricService", "onCreate() >> add to WindowManager Err: " + exception0);
                    this.stopSelf();
                    return;
                }
                if(view2 != null) {
                    view2.setOnClickListener(new f(2));
                }
                View view3 = this.e;
                if(view3 != null) {
                    view3.setOnTouchListener(new d(this));
                }
                h h0 = j.b("FloatingLyricService");
                this.w = h0;
                e e0 = new e(this, 0);
                this.B = e0;
                this.D = new e(this, 1);
                h0.h.observeForever(e0);
                h h1 = this.w;
                q.d(h1);
                e e1 = this.D;
                q.e(e1, "null cannot be cast to non-null type androidx.lifecycle.Observer<kotlin.collections.List<com.iloen.melon.lyric.LyricsInfo>>");
                h1.k.observeForever(e1);
                return;
            }
        }
        else {
            logU$Companion0.d("FloatingLyricService", "isServiceInUse() Overlay authority is off.");
        }
        this.stopSelf();
    }

    @Override  // androidx.lifecycle.LifecycleService
    public final void onDestroy() {
        super.onDestroy();
        LogU.Companion.d("FloatingLyricService", "onDestroy()");
        h h0 = this.w;
        if(h0 != null) {
            e e0 = this.B;
            if(e0 != null) {
                h0.h.removeObserver(e0);
            }
            e e1 = this.D;
            if(e1 != null) {
                h h1 = this.w;
                q.d(h1);
                h1.k.removeObserver(e1);
            }
        }
        WindowManager windowManager0 = this.c;
        if(windowManager0 != null) {
            View view0 = this.e;
            if(view0 != null) {
                try {
                    windowManager0.removeView(view0);
                }
                catch(Exception exception0) {
                    LogU.Companion.d("FloatingLyricService", "onDestroy() >> remove from WindowManager Err: " + exception0);
                }
                this.e = null;
            }
        }
        FloatingLyricService.getBroadcastReceiver.1 floatingLyricService$getBroadcastReceiver$10 = this.E;
        if(floatingLyricService$getBroadcastReceiver$10 != null) {
            this.unregisterReceiver(floatingLyricService$getBroadcastReceiver$10);
            this.E = null;
        }
        EventBusHelper.unregister(this);
        j.d("FloatingLyricService");
    }

    @Subscribe(threadMode = ThreadMode.BACKGROUND)
    public final void onEventBackgroundThread(@Nullable EventActivityState eventActivityState0) {
        if(eventActivityState0 instanceof EventActivityResumed) {
            LogU.Companion.d("FloatingLyricService", "EventActivityResumed : floating lyric will be stopped");
            this.stopSelf();
        }
    }

    @Override  // android.app.Service
    public final boolean onUnbind(Intent intent0) {
        q.g(intent0, "intent");
        LogU.Companion.d("FloatingLyricService", "onUnbind()");
        return super.onUnbind(intent0);
    }
}

