package com.iloen.melon.fragments.settings;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View.OnClickListener;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.fragment.app.l0;
import b3.Z;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.iloen.melon.custom.N0;
import com.iloen.melon.custom.RadioGroup;
import com.iloen.melon.fragments.webview.MelonWebViewDefaultMiniPlayerFragment.BuyingGoodsFragment;
import com.iloen.melon.net.RequestBuilder;
import com.iloen.melon.net.v4x.request.CheckProductSrcFlagReq;
import com.iloen.melon.net.v4x.request.PvLogDummyReq;
import com.iloen.melon.net.v4x.response.CheckProductSrcFlagRes.RESPONSE;
import com.iloen.melon.net.v4x.response.CheckProductSrcFlagRes;
import com.iloen.melon.net.v6x.request.DolbyAtmosSettingStatusReq;
import com.iloen.melon.utils.MelonSettingInfo;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.player.MediaCodecInfoCompat;
import com.iloen.melon.utils.ui.ViewUtils;
import com.melon.ui.popup.b;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import p8.g;
import va.Y;
import va.e0;
import va.o;

public class SettingSongFragment extends SettingSoundQualityFragment {
    private static final String TAG = "SettingSongFragment";
    private RadioGroup streamingOptionFlac;
    private RadioGroup streamingOptionLte;
    private RadioGroup streamingOptionSpatial;
    private RadioGroup streamingOptionWifi;

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public PvLogDummyReq getPvDummyLogRequest() {
        return new PvLogDummyReq(this.getContext(), "settingsSoundQuality");
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public int getTitleResId() {
        return 0x7F13105B;  // string:title_setting_song "곡 음질 설정"
    }

    private void initViews() {
        this.streamingOptionLte = (RadioGroup)this.findViewById(0x7F0A09AA);  // id:radiogroup_streaming_lte_type
        this.streamingOptionWifi = (RadioGroup)this.findViewById(0x7F0A09AB);  // id:radiogroup_streaming_wifi_type
        String s = MelonSettingInfo.getStreamingFileLte();
        String s1 = MelonSettingInfo.getStreamingFileWiFi();
        LogU.d("SettingSongFragment", "initViews() streamingTypeLte: " + s + ", streamingTypeWifi: " + s1);
        if("AAC320".equals(s)) {
            this.streamingOptionLte.a(0x7F0A0020);  // id:aac_320_lte_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionLte, 0x7F0A0020);  // id:aac_320_lte_layout
        }
        else if("MP3320".equals(s)) {
            this.streamingOptionLte.a(0x7F0A0827);  // id:mp3_320_lte_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionLte, 0x7F0A0827);  // id:mp3_320_lte_layout
        }
        else if("AAC128".equals(s)) {
            this.streamingOptionLte.a(0x7F0A001C);  // id:aac_128_lte_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionLte, 0x7F0A001C);  // id:aac_128_lte_layout
        }
        else {
            this.streamingOptionLte.a(0x7F0A0024);  // id:aac_lte_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionLte, 0x7F0A0024);  // id:aac_lte_layout
        }
        if("AAC320".equals(s1)) {
            this.streamingOptionWifi.a(0x7F0A0022);  // id:aac_320_wifi_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionWifi, 0x7F0A0022);  // id:aac_320_wifi_layout
        }
        else if("MP3320".equals(s1)) {
            this.streamingOptionWifi.a(0x7F0A0829);  // id:mp3_320_wifi_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionWifi, 0x7F0A0829);  // id:mp3_320_wifi_layout
        }
        else if("AAC128".equals(s1)) {
            this.streamingOptionWifi.a(0x7F0A001E);  // id:aac_128_wifi_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionWifi, 0x7F0A001E);  // id:aac_128_wifi_layout
        }
        else {
            this.streamingOptionWifi.a(0x7F0A0026);  // id:aac_wifi_layout
            this.setAccessibilityWifiLteDesc(this.streamingOptionWifi, 0x7F0A0026);  // id:aac_wifi_layout
        }
        this.streamingOptionLte.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                String s3;
                String s2;
                Z.r(v, "onCheckedChanged() streamingTypeLte checkedId: ", "SettingSongFragment");
                String s = SettingSongFragment.this.getString(0x7F130FEE);  // string:tiara_setting_song_layer1_cellular "데이터네트워크선택"
                String s1 = SettingSongFragment.this.getString(0x7F130FE8);  // string:tiara_setting_song_copy_aac "AAC+"
                if(v == 0x7F0A0020) {  // id:aac_320_lte_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FEA);  // string:tiara_setting_song_copy_aac_320 "AAC 320K"
                    s2 = "SQ05";
                    s3 = "AAC320";
                }
                else {
                    switch(v) {
                        case 0x7F0A001C: {  // id:aac_128_lte_layout
                            s1 = SettingSongFragment.this.getString(0x7F130FE9);  // string:tiara_setting_song_copy_aac_128 "AAC 128K"
                            s3 = "AAC128";
                            s2 = "SQ02";
                            break;
                        }
                        case 0x7F0A0827: {  // id:mp3_320_lte_layout
                            s1 = SettingSongFragment.this.getString(0x7F130FEC);  // string:tiara_setting_song_copy_mp3_320 "MP3 320K"
                            s3 = "MP3320";
                            s2 = "SQ04";
                            break;
                        }
                        default: {
                            s3 = "AAC";
                            s2 = "SQ01";
                        }
                    }
                }
                SettingSongFragment.this.setAccessibilityWifiLteDesc(SettingSongFragment.this.streamingOptionLte, v);
                if(!s3.equals(MelonSettingInfo.getStreamingFileLte())) {
                    MelonSettingInfo.setStreamingFileLte(s3);
                    if("AAC320" == s3) {
                        l0 l00 = SettingSongFragment.this.getChildFragmentManager();
                        String s4 = SettingSongFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        String s5 = SettingSongFragment.this.getString(0x7F1300E6);  // string:alert_selected_song_high_quality_lte "고음질 스트리밍 시 네트워크 환경에 따라 재생 중 끊김 현상이 
                                                                                     // 발생하거나 데이터 소모량이 증가할 수 있습니다."
                        b.a.c(l00, s4, s5);
                    }
                    SettingSongFragment.this.sendUALog("settingsDataNetworkSoundQuality", s2);
                    SettingSongFragment.this.sendTiaraLog(s, s1, null);
                }
            }
        });
        this.streamingOptionWifi.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                String s3;
                String s2;
                Z.r(v, "onCheckedChanged() streamingTypeLte checkedId: ", "SettingSongFragment");
                String s = SettingSongFragment.this.getString(0x7F130FF1);  // string:tiara_setting_song_layer1_wifi "Wi-Fi선택"
                String s1 = SettingSongFragment.this.getString(0x7F130FE8);  // string:tiara_setting_song_copy_aac "AAC+"
                if(v == 0x7F0A0022) {  // id:aac_320_wifi_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FEA);  // string:tiara_setting_song_copy_aac_320 "AAC 320K"
                    s2 = "SQ05";
                    s3 = "AAC320";
                }
                else {
                    switch(v) {
                        case 0x7F0A001E: {  // id:aac_128_wifi_layout
                            s1 = SettingSongFragment.this.getString(0x7F130FE9);  // string:tiara_setting_song_copy_aac_128 "AAC 128K"
                            s3 = "AAC128";
                            s2 = "SQ02";
                            break;
                        }
                        case 0x7F0A0829: {  // id:mp3_320_wifi_layout
                            s1 = SettingSongFragment.this.getString(0x7F130FEC);  // string:tiara_setting_song_copy_mp3_320 "MP3 320K"
                            s3 = "MP3320";
                            s2 = "SQ04";
                            break;
                        }
                        default: {
                            s3 = "AAC";
                            s2 = "SQ01";
                        }
                    }
                }
                SettingSongFragment.this.setAccessibilityWifiLteDesc(SettingSongFragment.this.streamingOptionWifi, v);
                if(!s3.equals(MelonSettingInfo.getStreamingFileWiFi())) {
                    MelonSettingInfo.setStreamingFileWiFi(s3);
                    if("AAC320" == s3) {
                        l0 l00 = SettingSongFragment.this.getChildFragmentManager();
                        String s4 = SettingSongFragment.this.getString(0x7F1300D0);  // string:alert_dlg_title_info "안내"
                        String s5 = SettingSongFragment.this.getString(0x7F1300E5);  // string:alert_selected_song_high_quality "네트워크 환경에 따라 재생 중 끊김 현상이 발생하거나 다음 곡으로의 연결이 
                                                                                     // 느려질 수 있습니다."
                        b.a.c(l00, s4, s5);
                    }
                    SettingSongFragment.this.sendUALog("settingsWifiSoundQuality", s2);
                    SettingSongFragment.this.sendTiaraLog(s, s1, null);
                }
            }
        });
        RadioGroup radioGroup0 = (RadioGroup)this.findViewById(0x7F0A09A4);  // id:radiogroup_cdstreaming_type
        this.streamingOptionFlac = radioGroup0;
        radioGroup0.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                Z.r(v, "onCheckedChanged() cdStreamingType checkedId: ", "SettingSongFragment");
                String s = SettingSongFragment.this.getString(0x7F130FEF);  // string:tiara_setting_song_layer1_flac "고음질(FLAC 16bit)선택"
                String s1 = SettingSongFragment.this.getString(0x7F130FED);  // string:tiara_setting_song_copy_wifi "Wi-Fi"
                int v1 = 1;
                String s2 = "SQ06";
                if(v == 0x7F0A04BF) {  // id:flac_wifi_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FED);  // string:tiara_setting_song_copy_wifi "Wi-Fi"
                }
                else if(v == 0x7F0A04C1) {  // id:flac_wifi_lte_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FEB);  // string:tiara_setting_song_copy_cellular "Wi-Fi/LTE"
                    v1 = 2;
                    s2 = "SQ07";
                }
                SettingSongFragment.this.setAccessibilityFlac(radioGroup0, v);
                if(v1 != MelonSettingInfo.getCdStreamingType()) {
                    MelonSettingInfo.setCdStreamingType(v1);
                    SettingSongFragment.this.sendUALog("settingsHifiSoundQuality", s2);
                    SettingSongFragment.this.sendTiaraLog(s, s1, null);
                }
            }
        });
        this.updateFlacStreamingViews(((e0)o.a()).j().getHasFlacStProd());
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A019B), new View.OnClickListener() {  // id:btn_purchase_goods
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                BuyingGoodsFragment.newInstance().open();
            }
        });
        RadioGroup radioGroup1 = (RadioGroup)this.findViewById(0x7F0A09A9);  // id:radiogroup_spatial_type
        this.streamingOptionSpatial = radioGroup1;
        radioGroup1.setOnCheckedChangeListener(new N0() {
            @Override  // com.iloen.melon.custom.N0
            public void onCheckedChanged(RadioGroup radioGroup0, int v) {
                Z.r(v, "onCheckedChanged() cdStreamingType checkedId: ", "SettingSongFragment");
                String s = SettingSongFragment.this.getString(0x7F130FF0);  // string:tiara_setting_song_layer1_spatial "입체음향(Dolby Atmos)선택"
                String s1 = SettingSongFragment.this.getString(0x7F130FED);  // string:tiara_setting_song_copy_wifi "Wi-Fi"
                int v1 = 1;
                if(v == 0x7F0A0AC9) {  // id:spatial_wifi_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FED);  // string:tiara_setting_song_copy_wifi "Wi-Fi"
                }
                else if(v == 0x7F0A0ACB) {  // id:spatial_wifi_lte_layout
                    s1 = SettingSongFragment.this.getString(0x7F130FEB);  // string:tiara_setting_song_copy_cellular "Wi-Fi/LTE"
                    v1 = 2;
                }
                if(v1 != MelonSettingInfo.getSpatialStreamingType()) {
                    MelonSettingInfo.setSpatialStreamingType(v1);
                }
                if(MediaCodecInfoCompat.isAc4Supported()) {
                    SettingSongFragment.this.sendTiaraLog(s, s1, null);
                }
            }
        });
        this.calculateScrollView(this.findViewById(0x7F0A0A78));  // id:setting_scrollview
    }

    public static SettingSongFragment newInstance() {
        return new SettingSongFragment();
    }

    @Override  // com.iloen.melon.fragments.MelonAdapterViewBaseFragment
    public boolean onBackPressed() {
        return false;
    }

    @Override  // androidx.fragment.app.I
    public View onCreateView(LayoutInflater layoutInflater0, ViewGroup viewGroup0, Bundle bundle0) {
        return layoutInflater0.inflate(0x7F0D083D, viewGroup0, false);  // layout:setting_song
    }

    @Override  // com.iloen.melon.fragments.FetcherBaseFragment
    public void onResume() {
        super.onResume();
        this.updateFlacStInfo();
        this.updateSpatialStInfo();
    }

    @Override  // com.iloen.melon.fragments.settings.SettingBaseFragment
    public void onViewCreated(View view0, Bundle bundle0) {
        super.onViewCreated(view0, bundle0);
        this.initViews();
    }

    private void sendTiaraLog(String s, String s1, String s2) {
        g g0 = new g();  // 初始化器: Lp8/f;-><init>()V
        g0.a = this.getString(0x7F130DD0);  // string:tiara_common_action_name_select "선택"
        g0.b = this.getString(0x7F130E57);  // string:tiara_common_section_setting "설정"
        g0.c = this.getString(0x7F130E49);  // string:tiara_common_page_setting_song "설정_곡음질설정"
        g0.y = s;
        g0.I = this.getMenuId();
        if(!TextUtils.isEmpty(s1)) {
            g0.F = s1;
        }
        if(!TextUtils.isEmpty(s2)) {
            g0.V = s2;
        }
        g0.a().track();
    }

    private void setAccessibilityFlac(RadioGroup radioGroup0, int v) {
        String s = this.getString(0x7F130A02);  // string:setting_wifi "Wi-Fi"
        String s1 = this.getString(0x7F130A03);  // string:setting_wifi_lte "Wi-Fi/LTE"
        if(v == 0x7F0A04BF) {  // id:flac_wifi_layout
            radioGroup0.c(0x7F0A04BF, String.format(this.getString(0x7F130AF3), s));  // id:flac_wifi_layout
            radioGroup0.c(0x7F0A04C1, String.format(this.getString(0x7F130AF7), s1));  // id:flac_wifi_lte_layout
            return;
        }
        radioGroup0.c(0x7F0A04C1, String.format(this.getString(0x7F130AF3), s1));  // id:flac_wifi_lte_layout
        radioGroup0.c(0x7F0A04BF, String.format(this.getString(0x7F130AF7), s));  // id:flac_wifi_layout
    }

    private void setAccessibilityWifiLteDesc(RadioGroup radioGroup0, int v) {
        int v7;
        int v4;
        String[] arr_s = {this.getString(0x7F130927), this.getString(0x7F1309B5), this.getString(0x7F130926), this.getString(0x7F130925)};  // string:setting_aac_320 "AAC 320K"
        int v1 = 0;
        switch(v) {
            case 0x7F0A001C:   // id:aac_128_lte_layout
            case 0x7F0A0020:   // id:aac_320_lte_layout
            case 0x7F0A0024:   // id:aac_lte_layout
            case 0x7F0A0827: {  // id:mp3_320_lte_layout
                int v2 = 0;
                while(v1 < 4) {
                    int v3 = new int[]{0x7F0A0020, 0x7F0A0827, 0x7F0A001C, 0x7F0A0024}[v1];  // id:aac_320_lte_layout
                    if(v3 == v) {
                        v4 = v2 + 1;
                        radioGroup0.c(v3, String.format(this.getString(0x7F130AF3), arr_s[v2]));  // string:talkback_common_select "%s 선택됨"
                    }
                    else {
                        v4 = v2 + 1;
                        radioGroup0.c(v3, String.format(this.getString(0x7F130AF7), arr_s[v2]));  // string:talkback_common_unselect "%s 선택해제"
                    }
                    v2 = v4;
                    ++v1;
                }
                return;
            }
            case 0x7F0A001E:   // id:aac_128_wifi_layout
            case 0x7F0A0022:   // id:aac_320_wifi_layout
            case 0x7F0A0026:   // id:aac_wifi_layout
            case 0x7F0A0829: {  // id:mp3_320_wifi_layout
                int v5 = 0;
                while(v1 < 4) {
                    int v6 = new int[]{0x7F0A0022, 0x7F0A0829, 0x7F0A001E, 0x7F0A0026}[v1];  // id:aac_320_wifi_layout
                    if(v6 == v) {
                        v7 = v5 + 1;
                        radioGroup0.c(v6, String.format(this.getString(0x7F130AF3), arr_s[v5]));  // string:talkback_common_select "%s 선택됨"
                    }
                    else {
                        v7 = v5 + 1;
                        radioGroup0.c(v6, String.format(this.getString(0x7F130AF7), arr_s[v5]));  // string:talkback_common_unselect "%s 선택해제"
                    }
                    v5 = v7;
                    ++v1;
                }
            }
        }
    }

    private void updateFlacStInfo() {
        RequestBuilder.newInstance(new CheckProductSrcFlagReq(this.getContext(), "SONG_FLAC_ST_POC_CASE")).tag("SettingSongFragment").listener(new Listener() {
            public void onResponse(CheckProductSrcFlagRes checkProductSrcFlagRes0) {
                if(SettingSongFragment.this.isFragmentValid() && checkProductSrcFlagRes0.isSuccessful()) {
                    RESPONSE checkProductSrcFlagRes$RESPONSE0 = checkProductSrcFlagRes0.response;
                    if(checkProductSrcFlagRes$RESPONSE0 != null) {
                        SettingSongFragment.this.updateFlacStreamingViews(checkProductSrcFlagRes$RESPONSE0.hasSrc);
                    }
                }
            }

            @Override  // com.android.volley.Response$Listener
            public void onResponse(Object object0) {
                this.onResponse(((CheckProductSrcFlagRes)object0));
            }
        }).errorListener(new ErrorListener() {
            @Override  // com.android.volley.Response$ErrorListener
            public void onErrorResponse(VolleyError volleyError0) {
            }
        }).request();
    }

    private void updateFlacStreamingViews(boolean z) {
        e0 e00 = (e0)o.a();
        Y y0 = new Y(e00, z, null);
        BuildersKt__Builders_commonKt.launch$default(e00.i, null, null, y0, 3, null);
        ViewUtils.setEnable(this.streamingOptionFlac, z);
        if(z && this.streamingOptionFlac != null) {
            int v = 1 == MelonSettingInfo.getCdStreamingType() ? 0x7F0A04BF : 0x7F0A04C1;  // id:flac_wifi_layout
            this.streamingOptionFlac.a(v);
            this.setAccessibilityFlac(this.streamingOptionFlac, v);
        }
        ViewUtils.hideWhen(this.findViewById(0x7F0A098C), z);  // id:purchase_desc
        ViewUtils.hideWhen(this.findViewById(0x7F0A019B), z);  // id:btn_purchase_goods
    }

    private void updateSpatialStInfo() {
        boolean z = MediaCodecInfoCompat.isAc4Supported();
        LogU.v("SettingSongFragment", "updateSpatialStInfo() supported ac4: " + z);
        ViewUtils.showWhen(this.findViewById(0x7F0A0745), z);  // id:layout_spatial
        if(!z) {
            MelonSettingInfo.setUseSpatialStreaming(false);
            return;
        }
        this.updateSpatialStreamingView();
    }

    private void updateSpatialStreamingView() {
        boolean z = MelonSettingInfo.isUseSpatialStreaming();
        ImageView imageView0 = (ImageView)this.findViewById(0x7F0A0996);  // id:radio_button
        imageView0.setImageResource((z ? 0x7F08016E : 0x7F08016D));  // drawable:btn_common_round_check_on
        imageView0.setContentDescription(this.getResources().getString((z ? 0x7F130BA9 : 0x7F130BAD)) + "버튼");  // string:talkback_off "꺼짐"
        ViewUtils.setEnable(this.streamingOptionSpatial, z);
        if(z) {
            RadioGroup radioGroup0 = this.streamingOptionSpatial;
            if(radioGroup0 != null) {
                radioGroup0.a((1 == MelonSettingInfo.getSpatialStreamingType() ? 0x7F0A0AC9 : 0x7F0A0ACB));  // id:spatial_wifi_layout
            }
        }
        ViewUtils.setOnClickListener(this.findViewById(0x7F0A09A0), new View.OnClickListener() {  // id:radio_use_spatial
            @Override  // android.view.View$OnClickListener
            public void onClick(View view0) {
                MelonSettingInfo.setUseSpatialStreaming(!z);
                if(MediaCodecInfoCompat.isAc4Supported()) {
                    String s = SettingSongFragment.this.getString(0x7F130FF0);  // string:tiara_setting_song_layer1_spatial "입체음향(Dolby Atmos)선택"
                    SettingSongFragment.this.sendTiaraLog(s, null, SettingSongFragment.this.getString((z ? 0x7F130FCE : 0x7F130FCF)));  // string:tiara_props_off "off"
                }
                if(((e0)o.a()).m()) {
                    RequestBuilder.newInstance(new DolbyAtmosSettingStatusReq(SettingSongFragment.this.getContext(), !z)).errorListener(new ErrorListener() {
                        @Override  // com.android.volley.Response$ErrorListener
                        public void onErrorResponse(VolleyError volleyError0) {
                            LogU.e("SettingSongFragment", "updateSpatialStreamingView() error: " + volleyError0);
                        }
                    }).request();
                }
                SettingSongFragment.this.updateSpatialStreamingView();
            }
        });
    }
}

