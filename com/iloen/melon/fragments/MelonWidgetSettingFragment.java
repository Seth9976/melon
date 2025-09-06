package com.iloen.melon.fragments;

import D2.f;
import android.app.WallpaperManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.glance.appwidget.GlanceAppWidgetManager;
import com.bumptech.glide.Glide;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.custom.RadioButton;
import com.iloen.melon.custom.title.TitleBar;
import com.iloen.melon.playback.Actor;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.preference.MelonPrefs;
import com.iloen.melon.utils.system.CompatUtils;
import com.iloen.melon.utils.system.ScreenUtils;
import com.kakao.tiara.data.ActionKind;
import ie.H;
import java.util.Iterator;
import k8.Y;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import ne.a;
import oe.e;
import oe.i;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p8.g;
import q2.b;
import w8.A;
import w8.Q;
import w8.m;
import w8.q;
import w8.w0;
import we.n;

@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0006J\u000F\u0010\u0007\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0007\u0010\u0006J\u001F\u0010\r\u001A\u00020\f2\u0006\u0010\t\u001A\u00020\b2\u0006\u0010\u000B\u001A\u00020\nH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u000F\u0010\u000F\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u000F\u0010\u0003J)\u0010\u0015\u001A\u00020\f2\b\u0010\u0011\u001A\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001A\u00020\u00122\u0006\u0010\u0014\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0015\u0010\u0016J\u000F\u0010\u0017\u001A\u00020\fH\u0002\u00A2\u0006\u0004\b\u0017\u0010\u0003J\u0017\u0010\u0019\u001A\u00020\f2\u0006\u0010\u0018\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0019\u0010\u001AJ\u0019\u0010\u001D\u001A\u00020\f2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0016\u00A2\u0006\u0004\b\u001D\u0010\u001EJ\u0017\u0010 \u001A\u00020\f2\u0006\u0010\u001F\u001A\u00020\u001BH\u0016\u00A2\u0006\u0004\b \u0010\u001EJ\u0017\u0010#\u001A\u00020\f2\u0006\u0010\"\u001A\u00020!H\u0016\u00A2\u0006\u0004\b#\u0010$J+\u0010&\u001A\u00020\u00122\u0006\u0010\t\u001A\u00020\b2\b\u0010%\u001A\u0004\u0018\u00010\n2\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0016\u00A2\u0006\u0004\b&\u0010\'J!\u0010(\u001A\u00020\f2\u0006\u0010\u0013\u001A\u00020\u00122\b\u0010\u001C\u001A\u0004\u0018\u00010\u001BH\u0016\u00A2\u0006\u0004\b(\u0010)R\u0018\u0010+\u001A\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b+\u0010,R\u0018\u0010.\u001A\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010/R\u0018\u00100\u001A\u0004\u0018\u00010-8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u0010/R\u0018\u00102\u001A\u0004\u0018\u0001018\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u00103R\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0016\u0010\u0018\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b\u0018\u00107R\u0016\u00108\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00107R\u0018\u0010:\u001A\u0004\u0018\u0001098\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b:\u0010;R\u0016\u0010<\u001A\u00020\u00048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u00107R\u0014\u0010>\u001A\u00020=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?\u00A8\u0006A"}, d2 = {"Lcom/iloen/melon/fragments/MelonWidgetSettingFragment;", "Lcom/iloen/melon/fragments/MelonBaseFragment;", "<init>", "()V", "", "getCurrentSkinType", "()I", "getCurrentTransparencyPercent", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "viewGroup", "Lie/H;", "inflateViewForOrientation", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V", "initLayout", "Landroid/content/Context;", "context", "Landroid/view/View;", "view", "marginDp", "updateTopMargin", "(Landroid/content/Context;Landroid/view/View;I)V", "updateWidgetSample", "transparencyPercent", "updateWidgetSampleAlpha", "(I)V", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "(Landroid/os/Bundle;)V", "outState", "onSaveInstanceState", "Landroid/content/res/Configuration;", "newConfig", "onConfigurationChanged", "(Landroid/content/res/Configuration;)V", "container", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "Landroid/widget/ImageView;", "widgetSampleImageView", "Landroid/widget/ImageView;", "Lcom/iloen/melon/custom/RadioButton;", "btnBlack", "Lcom/iloen/melon/custom/RadioButton;", "btnWhite", "Landroid/widget/SeekBar;", "seekBar", "Landroid/widget/SeekBar;", "Landroid/widget/TextView;", "transparencyText", "Landroid/widget/TextView;", "I", "skinType", "Lcom/iloen/melon/playback/Actor;", "actor", "Lcom/iloen/melon/playback/Actor;", "widgetId", "Landroid/view/View$OnClickListener;", "confirmClickListener", "Landroid/view/View$OnClickListener;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class MelonWidgetSettingFragment extends MelonBaseFragment {
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001C\u0010\f\u001A\u00020\r2\b\u0010\u000E\u001A\u0004\u0018\u00010\u000F2\b\b\u0002\u0010\u0010\u001A\u00020\u0005H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0006\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\u0007\u001A\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000E\u0010\b\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\n\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000E\u0010\u000B\u001A\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/iloen/melon/fragments/MelonWidgetSettingFragment$Companion;", "", "<init>", "()V", "DEFAULT_WIDGET_TRANSPARENCY_PERCENT", "", "WIDGET_TYPE_BLACK", "WIDGET_TYPE_WHITE", "TAG", "", "ARG_ACTOR", "ARG_WIDGET_ID", "newInstance", "Lcom/iloen/melon/fragments/MelonWidgetSettingFragment;", "actor", "Lcom/iloen/melon/playback/Actor;", "widgetId", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final MelonWidgetSettingFragment newInstance(@Nullable Actor actor0) {
            return Companion.newInstance$default(this, actor0, 0, 2, null);
        }

        @NotNull
        public final MelonWidgetSettingFragment newInstance(@Nullable Actor actor0, int v) {
            MelonWidgetSettingFragment melonWidgetSettingFragment0 = new MelonWidgetSettingFragment();
            Bundle bundle0 = new Bundle();
            bundle0.putSerializable("arg_actor", actor0);
            bundle0.putInt("arg_widget_id", v);
            melonWidgetSettingFragment0.setArguments(bundle0);
            return melonWidgetSettingFragment0;
        }

        public static MelonWidgetSettingFragment newInstance$default(Companion melonWidgetSettingFragment$Companion0, Actor actor0, int v, int v1, Object object0) {
            if((v1 & 2) != 0) {
                v = -1;
            }
            return melonWidgetSettingFragment$Companion0.newInstance(actor0, v);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 0x30)
    public static final class WhenMappings {
        public static final int[] $EnumSwitchMapping$0;

        static {
            int[] arr_v = new int[Actor.values().length];
            try {
                arr_v[Actor.Widget_2x1.ordinal()] = 1;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Actor.Widget_2x2.ordinal()] = 2;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Actor.Widget_4x1.ordinal()] = 3;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            try {
                arr_v[Actor.Widget_4x2.ordinal()] = 4;
            }
            catch(NoSuchFieldError unused_ex) {
            }
            WhenMappings.$EnumSwitchMapping$0 = arr_v;
        }
    }

    public static final int $stable = 0;
    @NotNull
    private static final String ARG_ACTOR = "arg_actor";
    @NotNull
    private static final String ARG_WIDGET_ID = "arg_widget_id";
    @NotNull
    public static final Companion Companion = null;
    public static final int DEFAULT_WIDGET_TRANSPARENCY_PERCENT = 30;
    @NotNull
    private static final String TAG = "MelonWidgetSettingFragment";
    public static final int WIDGET_TYPE_BLACK = 0;
    public static final int WIDGET_TYPE_WHITE = 1;
    @Nullable
    private Actor actor;
    @Nullable
    private RadioButton btnBlack;
    @Nullable
    private RadioButton btnWhite;
    @NotNull
    private final View.OnClickListener confirmClickListener;
    @Nullable
    private SeekBar seekBar;
    private int skinType;
    private int transparencyPercent;
    @Nullable
    private TextView transparencyText;
    private int widgetId;
    @Nullable
    private ImageView widgetSampleImageView;

    static {
        MelonWidgetSettingFragment.Companion = new Companion(null);
        MelonWidgetSettingFragment.$stable = 8;
    }

    public MelonWidgetSettingFragment() {
        this.widgetId = -1;
        this.confirmClickListener = new x(this, 0);

        @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001A\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lkotlinx/coroutines/CoroutineScope;", "Lie/H;", "<anonymous>", "(Lkotlinx/coroutines/CoroutineScope;)V"}, k = 3, mv = {2, 2, 0})
        @e(c = "com.iloen.melon.fragments.MelonWidgetSettingFragment$confirmClickListener$1$1", f = "MelonWidgetSettingFragment.kt", l = {310, 311, 316}, m = "invokeSuspend")
        final class com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1 extends i implements n {
            final w0 $widgetClass;
            int I$0;
            int I$1;
            Object L$0;
            Object L$1;
            Object L$2;
            Object L$3;
            Object L$4;
            Object L$5;
            int label;

            public com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1(w0 w00, MelonWidgetSettingFragment melonWidgetSettingFragment0, Continuation continuation0) {
                this.$widgetClass = w00;
                MelonWidgetSettingFragment.this = melonWidgetSettingFragment0;
                super(2, continuation0);
            }

            @Override  // oe.a
            public final Continuation create(Object object0, Continuation continuation0) {
                return new com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1(this.$widgetClass, MelonWidgetSettingFragment.this, continuation0);
            }

            @Override  // we.n
            public Object invoke(Object object0, Object object1) {
                return this.invoke(((CoroutineScope)object0), ((Continuation)object1));
            }

            public final Object invoke(CoroutineScope coroutineScope0, Continuation continuation0) {
                return ((com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1)this.create(coroutineScope0, continuation0)).invokeSuspend(H.a);
            }

            @Override  // oe.a
            public final Object invokeSuspend(Object object0) {
                Iterator iterator1;
                MelonWidgetSettingFragment melonWidgetSettingFragment0;
                int v;
                Context context2;
                Context context1;
                a a0 = a.a;
                switch(this.label) {
                    case 0: {
                        d5.n.D(object0);
                        context1 = Y.a(MelonAppBase.Companion);
                        GlanceAppWidgetManager glanceAppWidgetManager0 = new GlanceAppWidgetManager(context1);
                        Class class0 = this.$widgetClass.getClass();
                        this.L$0 = context1;
                        this.label = 1;
                        object0 = glanceAppWidgetManager0.a(class0, this);
                        if(object0 == a0) {
                            return a0;
                        }
                        goto label_17;
                    }
                    case 1: {
                        context1 = (Context)this.L$0;
                        d5.n.D(object0);
                    label_17:
                        Iterator iterator0 = ((Iterable)object0).iterator();
                        context2 = context1;
                        v = 0;
                        melonWidgetSettingFragment0 = MelonWidgetSettingFragment.this;
                        iterator1 = iterator0;
                        break;
                    }
                    case 2: {
                        v = this.I$0;
                        f f0 = (f)this.L$5;
                        iterator1 = (Iterator)this.L$3;
                        melonWidgetSettingFragment0 = (MelonWidgetSettingFragment)this.L$2;
                        Iterable iterable0 = (Iterable)this.L$1;
                        context2 = (Context)this.L$0;
                        d5.n.D(object0);
                        break;
                    }
                    case 3: {
                        Context context0 = (Context)this.L$0;
                        d5.n.D(object0);
                        return H.a;
                    }
                    default: {
                        throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                    }
                }
                while(iterator1.hasNext()) {
                    Object object1 = iterator1.next();
                    com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1.1.1 melonWidgetSettingFragment$confirmClickListener$1$1$1$10 = new n(null) {
                        Object L$0;
                        int label;

                        {
                            MelonWidgetSettingFragment.this = melonWidgetSettingFragment0;
                            super(2, continuation0);
                        }

                        @Override  // oe.a
                        public final Continuation create(Object object0, Continuation continuation0) {
                            Continuation continuation1 = new com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1.1.1(MelonWidgetSettingFragment.this, continuation0);
                            continuation1.L$0 = object0;
                            return continuation1;
                        }

                        @Override  // we.n
                        public Object invoke(Object object0, Object object1) {
                            return this.invoke(((b)object0), ((Continuation)object1));
                        }

                        public final Object invoke(b b0, Continuation continuation0) {
                            return ((com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1.1.1)this.create(b0, continuation0)).invokeSuspend(H.a);
                        }

                        @Override  // oe.a
                        public final Object invokeSuspend(Object object0) {
                            b b0 = (b)this.L$0;
                            if(this.label != 0) {
                                throw new IllegalStateException("call to \'resume\' before \'invoke\' with coroutine");
                            }
                            d5.n.D(object0);
                            b0.g(w0.f, Boolean.valueOf(MelonWidgetSettingFragment.access$getSkinType$p(MelonWidgetSettingFragment.this) == 1));
                            b0.g(w0.g, new Float(((float)(100 - MelonWidgetSettingFragment.access$getTransparencyPercent$p(MelonWidgetSettingFragment.this))) / 100.0f));
                            return H.a;
                        }
                    };
                    this.L$0 = context2;
                    this.L$1 = null;
                    this.L$2 = melonWidgetSettingFragment0;
                    this.L$3 = iterator1;
                    this.L$4 = null;
                    this.L$5 = null;
                    this.I$0 = v;
                    this.I$1 = 0;
                    this.label = 2;
                    if(d5.f.Y(context2, ((f)object1), melonWidgetSettingFragment$confirmClickListener$1$1$1$10, this) == a0) {
                        return a0;
                    }
                    if(false) {
                        break;
                    }
                }
                this.L$0 = null;
                this.L$1 = null;
                this.L$2 = null;
                this.L$3 = null;
                this.L$4 = null;
                this.L$5 = null;
                this.label = 3;
                return com.google.firebase.b.P(this.$widgetClass, context2, this) == a0 ? a0 : H.a;
            }
        }

    }

    public static final int access$getSkinType$p(MelonWidgetSettingFragment melonWidgetSettingFragment0) {
        return melonWidgetSettingFragment0.skinType;
    }

    private static final void confirmClickListener$lambda$7(MelonWidgetSettingFragment melonWidgetSettingFragment0, View view0) {
        m m1;
        ie.m m0;
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        switch((melonWidgetSettingFragment0.actor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[melonWidgetSettingFragment0.actor.ordinal()])) {
            case 1: {
                m0 = new ie.m("Widget21SkinType", "Widget21Skin");
                break;
            }
            case 2: {
                m0 = new ie.m("Widget22SkinType", "Widget22Skin");
                break;
            }
            case 3: {
                m0 = new ie.m("Widget41SkinType", "Widget41Skin");
                break;
            }
            default: {
                m0 = new ie.m("Widget42SkinType", "Widget42Skin");
            }
        }
        melonPrefs0.setInt(((String)m0.a), melonWidgetSettingFragment0.skinType);
        melonPrefs0.setInt(((String)m0.b), melonWidgetSettingFragment0.transparencyPercent);
        switch((melonWidgetSettingFragment0.actor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[melonWidgetSettingFragment0.actor.ordinal()])) {
            case 1: {
                m1 = new m();
                break;
            }
            case 2: {
                m1 = new q();
                break;
            }
            case 3: {
                m1 = new A();
                break;
            }
            default: {
                m1 = new Q();
            }
        }
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getMain()), null, null, new com.iloen.melon.fragments.MelonWidgetSettingFragment.confirmClickListener.1.1(m1, melonWidgetSettingFragment0, null), 3, null);
        if(melonWidgetSettingFragment0.widgetId > 0) {
            Intent intent0 = new Intent();
            intent0.putExtra("appWidgetId", melonWidgetSettingFragment0.widgetId);
            melonWidgetSettingFragment0.requireActivity().setResult(-1, intent0);
        }
        melonWidgetSettingFragment0.performBackPress();
    }

    private final int getCurrentSkinType() {
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        switch((this.actor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[this.actor.ordinal()])) {
            case 1: {
                return melonPrefs0.getInt("Widget21SkinType", 0);
            }
            case 2: {
                return melonPrefs0.getInt("Widget22SkinType", 0);
            }
            case 3: {
                return melonPrefs0.getInt("Widget41SkinType", 0);
            }
            case 4: {
                return melonPrefs0.getInt("Widget42SkinType", 0);
            }
            default: {
                return 0;
            }
        }
    }

    private final int getCurrentTransparencyPercent() {
        MelonPrefs melonPrefs0 = MelonPrefs.getInstance();
        switch((this.actor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[this.actor.ordinal()])) {
            case 1: {
                return melonPrefs0.getInt("Widget21Skin", 30);
            }
            case 2: {
                return melonPrefs0.getInt("Widget22Skin", 30);
            }
            case 3: {
                return melonPrefs0.getInt("Widget41Skin", 30);
            }
            case 4: {
                return melonPrefs0.getInt("Widget42Skin", 30);
            }
            default: {
                return 30;
            }
        }
    }

    private final void inflateViewForOrientation(LayoutInflater layoutInflater0, ViewGroup viewGroup0) {
        viewGroup0.removeAllViewsInLayout();
        layoutInflater0.inflate(0x7F0D02CA, viewGroup0);  // layout:fragment_widget_setting
    }

    private final void initLayout() {
        LogU.Companion.i("MelonWidgetSettingFragment", "initLayout()");
        View view0 = this.findViewById(0x7F0A0BAD);  // id:titlebar
        kotlin.jvm.internal.q.e(view0, "null cannot be cast to non-null type com.iloen.melon.custom.title.TitleBar");
        boolean z = true;
        ((TitleBar)view0).a(B.a.s(1));
        ((TitleBar)view0).setTitleColor(ColorUtils.getColor(this.getContext(), 0x7F06016D));  // color:gray900s
        ((TitleBar)view0).setTitle("위젯 설정");
        View view1 = this.findViewById(0x7F0A06B6);  // id:iv_wallpaper
        kotlin.jvm.internal.q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView0 = (ImageView)view1;
        try {
            imageView0.setImageDrawable(WallpaperManager.getInstance(this.getActivity()).getDrawable());
        }
        catch(Exception unused_ex) {
            LogU.Companion.w("MelonWidgetSettingFragment", "onViewCreated() - failed to load wallpaper image.");
            View view2 = this.findViewById(0x7F0A06B7);  // id:iv_wallpaper_bg
            kotlin.jvm.internal.q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
            Glide.with(((ImageView)view2).getContext()).load(0x7F0800CA).into(((ImageView)view2));  // drawable:bg_floatinglyrics
            imageView0.setVisibility(8);
            ((ImageView)view2).setVisibility(0);
        }
        this.findViewById(0x7F0A0146).setOnClickListener(new x(this, 1));  // id:btn_cancel
        this.findViewById(0x7F0A0150).setOnClickListener(this.confirmClickListener);  // id:btn_confirm
        View view3 = this.findViewById(0x7F0A0672);  // id:iv_preview
        kotlin.jvm.internal.q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
        this.widgetSampleImageView = (ImageView)view3;
        View view4 = this.findViewById(0x7F0A0255);  // id:check_skin_black
        kotlin.jvm.internal.q.e(view4, "null cannot be cast to non-null type com.iloen.melon.custom.RadioButton");
        ((RadioButton)view4).setChecked(this.skinType == 0);
        ((RadioButton)view4).setOnClickListener(new x(this, 2));
        this.btnBlack = (RadioButton)view4;
        View view5 = this.findViewById(0x7F0A0256);  // id:check_skin_white
        kotlin.jvm.internal.q.e(view5, "null cannot be cast to non-null type com.iloen.melon.custom.RadioButton");
        if(this.skinType != 1) {
            z = false;
        }
        ((RadioButton)view5).setChecked(z);
        ((RadioButton)view5).setOnClickListener(new x(this, 3));
        this.btnWhite = (RadioButton)view5;
        View view6 = this.findViewById(0x7F0A0D4A);  // id:tv_transparency_ratio
        kotlin.jvm.internal.q.e(view6, "null cannot be cast to non-null type android.widget.TextView");
        this.transparencyText = (TextView)view6;
        Context context0 = this.getContext();
        ((TextView)view6).setText((context0 == null ? null : context0.getString(0x7F1307E0, new Object[]{this.transparencyPercent})));  // string:percent_number "%1$d%%"
        View view7 = this.findViewById(0x7F0A0A55);  // id:seekbar_transparency
        kotlin.jvm.internal.q.e(view7, "null cannot be cast to non-null type android.widget.SeekBar");
        ((SeekBar)view7).setProgress(this.transparencyPercent);
        ((SeekBar)view7).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
                kotlin.jvm.internal.q.g(seekBar0, "seekBar");
                ((SeekBar)view7).transparencyPercent = v;
                TextView textView0 = ((SeekBar)view7).transparencyText;
                if(textView0 != null) {
                    Context context0 = this.$this_apply.getContext();
                    textView0.setText((context0 == null ? null : context0.getString(0x7F1307E0, new Object[]{((SeekBar)view7).transparencyPercent})));  // string:percent_number "%1$d%%"
                }
                ((SeekBar)view7).updateWidgetSampleAlpha(v);
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar0) {
                kotlin.jvm.internal.q.g(seekBar0, "seekBar");
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar0) {
                kotlin.jvm.internal.q.g(seekBar0, "seekBar");
            }
        });
        this.seekBar = (SeekBar)view7;
        this.updateWidgetSample();
        if(Actor.Widget_4x2 == this.actor) {
            Context context1 = this.getContext();
            ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.findViewById(0x7F0A0A76).getLayoutParams();  // id:setting_container
            viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(context1, 309.0f);
            View view8 = this.findViewById(0x7F0A0D0E);  // id:tv_skin
            kotlin.jvm.internal.q.f(view8, "findViewById(...)");
            this.updateTopMargin(context1, view8, 14);
            View view9 = this.findViewById(0x7F0A0D49);  // id:tv_transparency
            kotlin.jvm.internal.q.f(view9, "findViewById(...)");
            this.updateTopMargin(context1, view9, 26);
            int v = ScreenUtils.isLandscape(context1) ? 17 : 27;
            View view10 = this.findViewById(0x7F0A01E3);  // id:button_container
            kotlin.jvm.internal.q.f(view10, "findViewById(...)");
            this.updateTopMargin(context1, view10, v);
        }
    }

    private static final void initLayout$lambda$1(MelonWidgetSettingFragment melonWidgetSettingFragment0, View view0) {
        melonWidgetSettingFragment0.performBackPress();
    }

    private static final void initLayout$lambda$3$lambda$2(MelonWidgetSettingFragment melonWidgetSettingFragment0, View view0) {
        if(melonWidgetSettingFragment0.skinType == 0) {
            return;
        }
        melonWidgetSettingFragment0.skinType = 0;
        SeekBar seekBar0 = melonWidgetSettingFragment0.seekBar;
        if(seekBar0 != null) {
            seekBar0.setProgress(30);
        }
        melonWidgetSettingFragment0.transparencyPercent = 30;
        RadioButton radioButton0 = melonWidgetSettingFragment0.btnBlack;
        if(radioButton0 != null) {
            radioButton0.setChecked(true);
        }
        RadioButton radioButton1 = melonWidgetSettingFragment0.btnWhite;
        if(radioButton1 != null) {
            radioButton1.setChecked(false);
        }
        melonWidgetSettingFragment0.updateWidgetSample();
    }

    private static final void initLayout$lambda$5$lambda$4(MelonWidgetSettingFragment melonWidgetSettingFragment0, View view0) {
        if(melonWidgetSettingFragment0.skinType == 1) {
            return;
        }
        melonWidgetSettingFragment0.skinType = 1;
        SeekBar seekBar0 = melonWidgetSettingFragment0.seekBar;
        if(seekBar0 != null) {
            seekBar0.setProgress(30);
        }
        melonWidgetSettingFragment0.transparencyPercent = 30;
        RadioButton radioButton0 = melonWidgetSettingFragment0.btnBlack;
        if(radioButton0 != null) {
            radioButton0.setChecked(false);
        }
        RadioButton radioButton1 = melonWidgetSettingFragment0.btnWhite;
        if(radioButton1 != null) {
            radioButton1.setChecked(true);
        }
        melonWidgetSettingFragment0.updateWidgetSample();
    }

    @NotNull
    public static final MelonWidgetSettingFragment newInstance(@Nullable Actor actor0) {
        return MelonWidgetSettingFragment.Companion.newInstance(actor0);
    }

    @NotNull
    public static final MelonWidgetSettingFragment newInstance(@Nullable Actor actor0, int v) {
        return MelonWidgetSettingFragment.Companion.newInstance(actor0, v);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onConfigurationChanged(@NotNull Configuration configuration0) {
        kotlin.jvm.internal.q.g(configuration0, "newConfig");
        super.onConfigurationChanged(configuration0);
        ViewGroup viewGroup0 = (ViewGroup)this.getView();
        if(viewGroup0 != null) {
            LayoutInflater layoutInflater0 = LayoutInflater.from(this.getContext());
            kotlin.jvm.internal.q.f(layoutInflater0, "from(...)");
            this.inflateViewForOrientation(layoutInflater0, viewGroup0);
        }
        this.initLayout();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onCreate(@Nullable Bundle bundle0) {
        super.onCreate(bundle0);
        if(bundle0 == null) {
            bundle0 = this.getArguments();
        }
        if(bundle0 != null) {
            this.actor = (Actor)CompatUtils.getSerializable(bundle0, "arg_actor", Actor.class);
            this.widgetId = bundle0.getInt("arg_widget_id");
        }
        this.skinType = this.getCurrentSkinType();
        this.transparencyPercent = this.getCurrentTransparencyPercent();
    }

    @Override  // androidx.fragment.app.I
    @NotNull
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(layoutInflater0, "inflater");
        View view0 = new FrameLayout(this.requireContext());
        this.inflateViewForOrientation(layoutInflater0, ((ViewGroup)view0));
        return view0;
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onSaveInstanceState(@NotNull Bundle bundle0) {
        kotlin.jvm.internal.q.g(bundle0, "outState");
        bundle0.putSerializable("arg_actor", this.actor);
        super.onSaveInstanceState(bundle0);
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        kotlin.jvm.internal.q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        Context context0 = this.getContext();
        if(this.actor == Actor.Widget_4x2 && context0 != null) {
            g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
            g0.I = "1000003153";
            g0.a = "페이지이동";
            g0.d = ActionKind.ClickContent;
            g0.b = "위젯";
            g0.c = "위젯_aos_바탕화면위젯";
            g0.y = "4*2";
            g0.F = "설정";
            g0.a().track();
        }
        this.initLayout();
    }

    private final void updateTopMargin(Context context0, View view0, int v) {
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = view0.getLayoutParams();
        if(viewGroup$LayoutParams0 instanceof ViewGroup.MarginLayoutParams) {
            ((ViewGroup.MarginLayoutParams)viewGroup$LayoutParams0).topMargin = ScreenUtils.dipToPixel(context0, ((float)v));
        }
    }

    private final void updateWidgetSample() {
        int v;
        boolean z = this.skinType == 1;
        switch((this.actor == null ? -1 : WhenMappings.$EnumSwitchMapping$0[this.actor.ordinal()])) {
            case 1: {
                v = z ? 0x7F08068C : 0x7F080688;  // drawable:img_widget_setting_w_2_x_1
                break;
            }
            case 2: {
                v = z ? 0x7F08068D : 0x7F080689;  // drawable:img_widget_setting_w_2_x_2
                break;
            }
            case 3: {
                v = z ? 0x7F08068E : 0x7F08068A;  // drawable:img_widget_setting_w_4_x_1
                break;
            }
            case 4: {
                v = z ? 0x7F08068F : 0x7F08068B;  // drawable:img_widget_setting_w_4_x_2
                break;
            }
            default: {
                return;
            }
        }
        ImageView imageView0 = this.widgetSampleImageView;
        if(imageView0 != null) {
            imageView0.setImageResource(v);
        }
        ImageView imageView1 = this.widgetSampleImageView;
        if(imageView1 != null) {
            imageView1.setBackgroundResource((z ? 0x7F0800DD : 0x7F0800DC));  // drawable:bg_widget_w
        }
        this.updateWidgetSampleAlpha(this.transparencyPercent);
    }

    private final void updateWidgetSampleAlpha(int v) {
        ImageView imageView0 = this.widgetSampleImageView;
        if(imageView0 != null) {
            Drawable drawable0 = imageView0.getBackground();
            if(drawable0 != null) {
                drawable0.setAlpha(((int)(((float)((100 - v) * 0xFF)) / 100.0f)));
            }
        }
        ImageView imageView1 = this.widgetSampleImageView;
        if(imageView1 != null) {
            imageView1.invalidate();
        }
    }
}

