package com.iloen.melon.fragments.settings;

import android.app.WallpaperManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.SeekBar;
import android.widget.TextView;
import b3.Z;
import com.bumptech.glide.Glide;
import com.iloen.melon.custom.RadioButton;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.color.ColorUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ScreenUtils;
import com.iloen.melon.utils.ui.FloatingLyricHelper;
import com.iloen.melon.utils.ui.ViewUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000B\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 @2\u00020\u0001:\u0001@B\u0007\u00A2\u0006\u0004\b\u0002\u0010\u0003J\u000F\u0010\u0005\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0005\u0010\u0003J\u000F\u0010\u0006\u001A\u00020\u0004H\u0002\u00A2\u0006\u0004\b\u0006\u0010\u0003J\u0017\u0010\t\u001A\u00020\u00042\u0006\u0010\b\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001A\u00020\u00042\u0006\u0010\f\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\r\u0010\u000EJ\u0017\u0010\u0010\u001A\u00020\u00042\u0006\u0010\u000F\u001A\u00020\u000BH\u0002\u00A2\u0006\u0004\b\u0010\u0010\u000EJ\u0017\u0010\u0012\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0013\u001A\u00020\u00042\u0006\u0010\u0011\u001A\u00020\u0007H\u0002\u00A2\u0006\u0004\b\u0013\u0010\nJ\u0017\u0010\u0016\u001A\u00020\u00042\u0006\u0010\u0015\u001A\u00020\u0014H\u0002\u00A2\u0006\u0004\b\u0016\u0010\u0017J\u000F\u0010\u0018\u001A\u00020\u0007H\u0014\u00A2\u0006\u0004\b\u0018\u0010\u0019J-\u0010 \u001A\u0004\u0018\u00010\u00142\u0006\u0010\u001B\u001A\u00020\u001A2\b\u0010\u001D\u001A\u0004\u0018\u00010\u001C2\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0016\u00A2\u0006\u0004\b \u0010!J!\u0010#\u001A\u00020\u00042\u0006\u0010\"\u001A\u00020\u00142\b\u0010\u001F\u001A\u0004\u0018\u00010\u001EH\u0016\u00A2\u0006\u0004\b#\u0010$J\u000F\u0010&\u001A\u00020%H\u0016\u00A2\u0006\u0004\b&\u0010\'R\u0018\u0010(\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010*\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b*\u0010)R\u0018\u0010,\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b,\u0010-R\u0018\u0010.\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b.\u0010-R\u0018\u0010/\u001A\u0004\u0018\u00010\u00148\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b/\u0010)R\u0018\u00100\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b0\u0010-R\u0018\u00101\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b1\u0010-R\u0018\u00102\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b2\u0010-R\u0018\u00103\u001A\u0004\u0018\u00010+8\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b3\u0010-R\u0018\u00105\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b5\u00106R\u0018\u00107\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b7\u00106R\u0018\u00108\u001A\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b8\u00106R\u0016\u00109\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b9\u0010:R\u0016\u0010;\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b;\u0010:R\u0016\u0010<\u001A\u00020\u00078\u0002@\u0002X\u0082\u000E\u00A2\u0006\u0006\n\u0004\b<\u0010:R\u0014\u0010>\u001A\u00020=8\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b>\u0010?\u00A8\u0006A"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingFloatingLyricFragment;", "Lcom/iloen/melon/fragments/settings/SettingBaseFragment;", "<init>", "()V", "Lie/H;", "initUI", "updateSkinType", "", "alpha", "updateTransparency", "(I)V", "", "fontSize", "setTextSize", "(F)V", "gap", "setTextViewGap", "index", "initFontSizeBtn", "updatePreview", "Landroid/view/View;", "btnView", "updateFontSizeBtnSelector", "(Landroid/view/View;)V", "getTitleResId", "()I", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "onCreateView", "(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;", "view", "onViewCreated", "(Landroid/view/View;Landroid/os/Bundle;)V", "", "isScreenLandscapeSupported", "()Z", "bgPreview", "Landroid/view/View;", "layout", "Landroid/widget/TextView;", "textPreview1", "Landroid/widget/TextView;", "textPreview2", "viewGap", "smallestBtn", "smallBtn", "mediumBtn", "bigBtn", "Landroid/widget/ImageView;", "melonLogo", "Landroid/widget/ImageView;", "closeBtn", "ivSetting", "alphaValue", "I", "skinType", "fontIndex", "Landroid/view/View$OnClickListener;", "mTextBtnClickListener", "Landroid/view/View$OnClickListener;", "Companion", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
public final class SettingFloatingLyricFragment extends SettingBaseFragment {
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000E\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001A\u00020\u0007H\u0007R\u000E\u0010\u0004\u001A\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/iloen/melon/fragments/settings/SettingFloatingLyricFragment$Companion;", "", "<init>", "()V", "TAG", "", "newInstance", "Lcom/iloen/melon/fragments/settings/SettingFloatingLyricFragment;", "app_playstoreProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 0x30)
    public static final class Companion {
        private Companion() {
        }

        public Companion(DefaultConstructorMarker defaultConstructorMarker0) {
        }

        @NotNull
        public final SettingFloatingLyricFragment newInstance() {
            return new SettingFloatingLyricFragment();
        }
    }

    public static final int $stable = 0;
    @NotNull
    public static final Companion Companion = null;
    @NotNull
    private static final String TAG = "SettingFloatingLyricFragment";
    private int alphaValue;
    @Nullable
    private View bgPreview;
    @Nullable
    private TextView bigBtn;
    @Nullable
    private ImageView closeBtn;
    private int fontIndex;
    @Nullable
    private ImageView ivSetting;
    @Nullable
    private View layout;
    @NotNull
    private final View.OnClickListener mTextBtnClickListener;
    @Nullable
    private TextView mediumBtn;
    @Nullable
    private ImageView melonLogo;
    private int skinType;
    @Nullable
    private TextView smallBtn;
    @Nullable
    private TextView smallestBtn;
    @Nullable
    private TextView textPreview1;
    @Nullable
    private TextView textPreview2;
    @Nullable
    private View viewGap;

    static {
        SettingFloatingLyricFragment.Companion = new Companion(null);
        SettingFloatingLyricFragment.$stable = 8;
    }

    public SettingFloatingLyricFragment() {
        this.mTextBtnClickListener = new t(this, 0);
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F130985;  // string:setting_floating_lyric "플로팅 가사 설정"
    }

    private final void initFontSizeBtn(int v) {
        switch(v) {
            case 1: {
                TextView textView1 = this.smallBtn;
                if(textView1 != null) {
                    textView1.setSelected(true);
                    return;
                }
                break;
            }
            case 2: {
                TextView textView2 = this.mediumBtn;
                if(textView2 != null) {
                    textView2.setSelected(true);
                    return;
                }
                break;
            }
            case 3: {
                TextView textView3 = this.bigBtn;
                if(textView3 != null) {
                    textView3.setSelected(true);
                    return;
                }
                break;
            }
            default: {
                TextView textView0 = this.smallestBtn;
                if(textView0 != null) {
                    textView0.setSelected(true);
                }
            }
        }
    }

    private final void initUI() {
        this.alphaValue = MelonSettingInfo.getLaboratoryFloatingLyricAlpha();
        this.skinType = MelonSettingInfo.getLaboratoryFloatingLyricSkinType();
        int v = FloatingLyricHelper.INSTANCE.getFontIndex();
        this.fontIndex = v;
        float f = FloatingLyricHelper.INSTANCE.getFontSize(v);
        this.layout = this.findViewById(0x7F0A0727);  // id:layout_lyric
        View view0 = this.findViewById(0x7F0A0B5C);  // id:text_preview_1
        q.e(view0, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view0).setTextSize(1, f);
        this.textPreview1 = (TextView)view0;
        View view1 = this.findViewById(0x7F0A0B5D);  // id:text_preview_2
        q.e(view1, "null cannot be cast to non-null type android.widget.TextView");
        ((TextView)view1).setTextSize(1, f);
        this.textPreview2 = (TextView)view1;
        this.viewGap = this.findViewById(0x7F0A04E6);  // id:gap
        this.bgPreview = this.findViewById(0x7F0A00EA);  // id:background_preview
        View view2 = this.findViewById(0x7F0A064F);  // id:iv_melon_logo
        q.e(view2, "null cannot be cast to non-null type android.widget.ImageView");
        this.melonLogo = (ImageView)view2;
        View view3 = this.findViewById(0x7F0A0613);  // id:iv_close
        q.e(view3, "null cannot be cast to non-null type android.widget.ImageView");
        this.closeBtn = (ImageView)view3;
        View view4 = this.findViewById(0x7F0A0688);  // id:iv_setting
        q.e(view4, "null cannot be cast to non-null type android.widget.ImageView");
        this.ivSetting = (ImageView)view4;
        View view5 = this.findViewById(0x7F0A0A99);  // id:smallest_size
        q.e(view5, "null cannot be cast to non-null type android.widget.TextView");
        this.smallestBtn = (TextView)view5;
        ViewUtils.setOnClickListener(((TextView)view5), this.mTextBtnClickListener);
        View view6 = this.findViewById(0x7F0A0A98);  // id:small_size
        q.e(view6, "null cannot be cast to non-null type android.widget.TextView");
        this.smallBtn = (TextView)view6;
        ViewUtils.setOnClickListener(((TextView)view6), this.mTextBtnClickListener);
        View view7 = this.findViewById(0x7F0A07F1);  // id:medium_size
        q.e(view7, "null cannot be cast to non-null type android.widget.TextView");
        this.mediumBtn = (TextView)view7;
        ViewUtils.setOnClickListener(((TextView)view7), this.mTextBtnClickListener);
        View view8 = this.findViewById(0x7F0A0107);  // id:big_size
        q.e(view8, "null cannot be cast to non-null type android.widget.TextView");
        this.bigBtn = (TextView)view8;
        ViewUtils.setOnClickListener(((TextView)view8), this.mTextBtnClickListener);
        this.updateSkinType();
        this.initFontSizeBtn(this.fontIndex);
        this.updatePreview(this.fontIndex);
        View view9 = this.findViewById(0x7F0A0255);  // id:check_skin_black
        q.e(view9, "null cannot be cast to non-null type com.iloen.melon.custom.RadioButton");
        boolean z = false;
        ((RadioButton)view9).setChecked(this.skinType == 0);
        View view10 = this.findViewById(0x7F0A0256);  // id:check_skin_white
        q.e(view10, "null cannot be cast to non-null type com.iloen.melon.custom.RadioButton");
        if(this.skinType == 1) {
            z = true;
        }
        ((RadioButton)view10).setChecked(z);
        ((RadioButton)view9).setOnClickListener(new u(this, ((RadioButton)view9), ((RadioButton)view10), 0));
        ((RadioButton)view10).setOnClickListener(new u(this, ((RadioButton)view9), ((RadioButton)view10), 1));
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0150), new t(this, 1));  // id:btn_confirm
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A0146), new t(this, 2));  // id:btn_cancel
        View view11 = this.findViewById(0x7F0A0A55);  // id:seekbar_transparency
        q.e(view11, "null cannot be cast to non-null type android.widget.SeekBar");
        View view12 = this.findViewById(0x7F0A0D4A);  // id:tv_transparency_ratio
        q.e(view12, "null cannot be cast to non-null type android.widget.TextView");
        Z.y(new Object[]{this.alphaValue}, 1, "%d%%", ((TextView)view12));
        ((SeekBar)view11).setOnClickListener(null);
        ((SeekBar)view11).setProgress(this.alphaValue);
        ((SeekBar)view11).setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar0, int v, boolean z) {
                q.g(seekBar0, "seekBar");
                ((TextView)view12).alphaValue = v;
                Z.y(new Object[]{((TextView)view12).alphaValue}, 1, "%d%%", this.$tvAlpha);
                ((TextView)view12).updateTransparency(((TextView)view12).alphaValue);
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar0) {
                q.g(seekBar0, "seekBar");
            }

            @Override  // android.widget.SeekBar$OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar0) {
                q.g(seekBar0, "seekBar");
            }
        });
    }

    private static final void initUI$lambda$2(SettingFloatingLyricFragment settingFloatingLyricFragment0, RadioButton radioButton0, RadioButton radioButton1, View view0) {
        if(settingFloatingLyricFragment0.skinType == 0) {
            return;
        }
        settingFloatingLyricFragment0.skinType = 0;
        radioButton0.setChecked(true);
        radioButton1.setChecked(false);
        settingFloatingLyricFragment0.updateSkinType();
    }

    private static final void initUI$lambda$3(SettingFloatingLyricFragment settingFloatingLyricFragment0, RadioButton radioButton0, RadioButton radioButton1, View view0) {
        if(settingFloatingLyricFragment0.skinType == 1) {
            return;
        }
        settingFloatingLyricFragment0.skinType = 1;
        radioButton0.setChecked(false);
        radioButton1.setChecked(true);
        settingFloatingLyricFragment0.updateSkinType();
    }

    private static final void initUI$lambda$4(SettingFloatingLyricFragment settingFloatingLyricFragment0, View view0) {
        MelonSettingInfo.setLaboratoryFloatingLyricAlpha(settingFloatingLyricFragment0.alphaValue);
        MelonSettingInfo.setLaboratoryFloatingLyricSkinType(settingFloatingLyricFragment0.skinType);
        MelonSettingInfo.setLaboratoryFloatingLyricFontIndex(settingFloatingLyricFragment0.fontIndex);
        settingFloatingLyricFragment0.performBackPress();
    }

    private static final void initUI$lambda$5(SettingFloatingLyricFragment settingFloatingLyricFragment0, View view0) {
        settingFloatingLyricFragment0.performBackPress();
    }

    @Override  // com.iloen.melon.fragments.MelonBaseFragment
    public boolean isScreenLandscapeSupported() {
        return false;
    }

    private static final void mTextBtnClickListener$lambda$7(SettingFloatingLyricFragment settingFloatingLyricFragment0, View view0) {
        int v = 0;
        switch(view0.getId()) {
            case 0x7F0A0107: {  // id:big_size
                v = 3;
                break;
            }
            case 0x7F0A07F1: {  // id:medium_size
                v = 2;
                break;
            }
            case 0x7F0A0A98: {  // id:small_size
                v = 1;
            }
        }
        settingFloatingLyricFragment0.fontIndex = v;
        settingFloatingLyricFragment0.updateFontSizeBtnSelector(view0);
        settingFloatingLyricFragment0.updatePreview(settingFloatingLyricFragment0.fontIndex);
    }

    @NotNull
    public static final SettingFloatingLyricFragment newInstance() {
        return SettingFloatingLyricFragment.Companion.newInstance();
    }

    @Override  // androidx.fragment.app.I
    @Nullable
    public View onCreateView(@NotNull LayoutInflater layoutInflater0, @Nullable ViewGroup viewGroup0, @Nullable Bundle bundle0) {
        q.g(layoutInflater0, "inflater");
        return layoutInflater0.inflate(0x7F0D082D, viewGroup0, false);  // layout:setting_floating_lyric
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(@NotNull View view0, @Nullable Bundle bundle0) {
        q.g(view0, "view");
        super.onViewCreated(view0, bundle0);
        View view1 = view0.findViewById(0x7F0A06B6);  // id:iv_wallpaper
        q.e(view1, "null cannot be cast to non-null type android.widget.ImageView");
        ImageView imageView0 = (ImageView)view1;
        try {
            imageView0.setImageDrawable(WallpaperManager.getInstance(this.getActivity()).getDrawable());
        }
        catch(Exception exception0) {
            LogU.Companion.w("SettingFloatingLyricFragment", "Err: " + exception0);
            q.d(Glide.with(imageView0.getContext()).load(0x7F0800CA).into(imageView0));  // drawable:bg_floatinglyrics
        }
        this.initUI();
    }

    private final void setTextSize(float f) {
        TextView textView0 = this.textPreview1;
        if(textView0 != null) {
            textView0.setTextSize(1, f);
        }
        TextView textView1 = this.textPreview2;
        if(textView1 != null) {
            textView1.setTextSize(1, f);
        }
    }

    private final void setTextViewGap(float f) {
        int v = ScreenUtils.dipToPixel(this.getContext(), f);
        TextView textView0 = this.textPreview1;
        if(textView0 != null) {
            textView0.setLineSpacing(((float)v), 1.0f);
        }
        TextView textView1 = this.textPreview2;
        if(textView1 != null) {
            textView1.setLineSpacing(((float)v), 1.0f);
        }
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.viewGap == null ? null : this.viewGap.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            viewGroup$LayoutParams0.height = v;
        }
        View view0 = this.viewGap;
        if(view0 != null) {
            view0.setLayoutParams(viewGroup$LayoutParams0);
        }
    }

    private final void updateFontSizeBtnSelector(View view0) {
        View[] arr_view = {this.smallestBtn, this.smallBtn, this.mediumBtn, this.bigBtn};
        for(int v = 0; v < 4; ++v) {
            View view1 = arr_view[v];
            if(view1 != null) {
                view1.setSelected(view0.getId() == view1.getId());
            }
        }
    }

    private final void updatePreview(int v) {
        float f = FloatingLyricHelper.INSTANCE.getFontSize(v);
        float f1 = FloatingLyricHelper.INSTANCE.getTextviewGap(v);
        float f2 = FloatingLyricHelper.INSTANCE.getLayoutHeight(v);
        this.setTextSize(f);
        this.setTextViewGap(f1);
        ViewGroup.LayoutParams viewGroup$LayoutParams0 = this.layout == null ? null : this.layout.getLayoutParams();
        if(viewGroup$LayoutParams0 != null) {
            viewGroup$LayoutParams0.height = ScreenUtils.dipToPixel(this.getContext(), f2);
        }
        View view0 = this.layout;
        if(view0 != null) {
            view0.setLayoutParams(viewGroup$LayoutParams0);
        }
        View view1 = this.layout;
        if(view1 != null) {
            view1.requestLayout();
        }
        View view2 = this.bgPreview;
        if(view2 != null) {
            view2.requestLayout();
        }
    }

    private final void updateSkinType() {
        if(this.skinType == 0) {
            View view0 = this.bgPreview;
            if(view0 != null) {
                view0.setBackgroundResource(0x7F0800C8);  // drawable:bg_floatinglyric_black
            }
            ImageView imageView0 = this.melonLogo;
            if(imageView0 != null) {
                imageView0.setImageResource(0x7F0805D2);  // drawable:ic_setting_melon_symbol_b
            }
            ImageView imageView1 = this.closeBtn;
            if(imageView1 != null) {
                imageView1.setImageResource(0x7F08025B);  // drawable:btn_setting_lab_close_b
            }
            ImageView imageView2 = this.ivSetting;
            if(imageView2 != null) {
                imageView2.setImageResource(0x7F0802AB);  // drawable:btn_widget_setup_b
            }
            TextView textView0 = this.textPreview1;
            if(textView0 != null) {
                textView0.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06017A));  // color:green500e_support_high_contrast
            }
            TextView textView1 = this.textPreview2;
            if(textView1 != null) {
                textView1.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F0604A1));  // color:white000e
            }
            View view1 = this.bgPreview;
            if(view1 != null) {
                view1.invalidate();
            }
        }
        else {
            View view2 = this.bgPreview;
            if(view2 != null) {
                view2.setBackgroundResource(0x7F0800C9);  // drawable:bg_floatinglyric_white
            }
            ImageView imageView3 = this.melonLogo;
            if(imageView3 != null) {
                imageView3.setImageResource(0x7F0805D3);  // drawable:ic_setting_melon_symbol_w
            }
            ImageView imageView4 = this.closeBtn;
            if(imageView4 != null) {
                imageView4.setImageResource(0x7F08025C);  // drawable:btn_setting_lab_close_w
            }
            ImageView imageView5 = this.ivSetting;
            if(imageView5 != null) {
                imageView5.setImageResource(0x7F0802AC);  // drawable:btn_widget_setup_w
            }
            TextView textView2 = this.textPreview1;
            if(textView2 != null) {
                textView2.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F06017A));  // color:green500e_support_high_contrast
            }
            TextView textView3 = this.textPreview2;
            if(textView3 != null) {
                textView3.setTextColor(ColorUtils.getColor(this.getContext(), 0x7F060171));  // color:gray990e
            }
            View view3 = this.bgPreview;
            if(view3 != null) {
                view3.invalidate();
            }
        }
        this.updateTransparency(this.alphaValue);
    }

    private final void updateTransparency(int v) {
        View view0 = this.bgPreview;
        if(view0 != null) {
            view0.getBackground().setAlpha(FloatingLyricHelper.INSTANCE.getAlphaValue(v));
            view0.invalidate();
        }
    }
}

