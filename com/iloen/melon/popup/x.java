package com.iloen.melon.popup;

import J8.I2;
import android.net.Uri;
import android.text.TextUtils;
import android.webkit.URLUtil;
import com.android.volley.Response.ErrorListener;
import com.android.volley.Response.Listener;
import com.android.volley.VolleyError;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.iloen.melon.mcache.CacheUrlBuilder;
import com.iloen.melon.mcache.error.MCacheError;
import com.iloen.melon.net.v4x.response.StreamGetPathRes.RESPONSE.GetPathInfo;
import com.iloen.melon.net.v4x.response.StreamGetPathRes;
import com.iloen.melon.net.v4x.response.StreamGetSongInfoRes.RESPONSE.ContentsInfo;
import com.iloen.melon.playback.OemMusicPlayer;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.playback.PlayerState;
import com.iloen.melon.utils.ClassUtils;
import com.iloen.melon.utils.log.LogU;
import com.iloen.melon.utils.system.ToastManager;
import d9.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import je.w;
import kotlin.jvm.internal.q;
import x8.f;

public final class x implements ErrorListener, Listener {
    public final String a;
    public final InstantPlayPopup b;

    public x(InstantPlayPopup instantPlayPopup0, String s) {
        this.b = instantPlayPopup0;
        this.a = s;
    }

    public x(String s, InstantPlayPopup instantPlayPopup0) {
        this.a = s;
        this.b = instantPlayPopup0;
    }

    @Override  // com.android.volley.Response$ErrorListener
    public void onErrorResponse(VolleyError volleyError0) {
        ToastManager.show(this.a);
        this.b.dismiss();
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        String s5;
        String s = null;
        InstantPlayPopup instantPlayPopup0 = this.b;
        if(instantPlayPopup0.B != null) {
            if((((StreamGetPathRes)object0) == null ? null : ((StreamGetPathRes)object0).response) == null) {
                instantPlayPopup0.dismiss();
                return;
            }
            String s1 = this.a;
            ArrayList arrayList0 = ((StreamGetPathRes)object0).response.contentsInfo;
            if(arrayList0 != null) {
                Iterator iterator0 = arrayList0.iterator();
                q.f(iterator0, "iterator(...)");
                while(iterator0.hasNext()) {
                    Object object1 = iterator0.next();
                    ContentsInfo streamGetSongInfoRes$RESPONSE$ContentsInfo0 = (ContentsInfo)object1;
                    if(ClassUtils.equals(streamGetSongInfoRes$RESPONSE$ContentsInfo0.cid, (instantPlayPopup0.f == null ? null : ""))) {
                        if(TextUtils.isEmpty(instantPlayPopup0.n)) {
                            instantPlayPopup0.n = streamGetSongInfoRes$RESPONSE$ContentsInfo0.contentimgpath;
                            RequestBuilder requestBuilder0 = Glide.with(instantPlayPopup0.requireContext()).load(instantPlayPopup0.n);
                            I2 i20 = instantPlayPopup0.B;
                            q.d(i20);
                            requestBuilder0.into(i20.e);
                        }
                        Playable playable0 = instantPlayPopup0.f;
                        if(playable0 != null) {
                            playable0.setLyricType(streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyrictype);
                        }
                        Playable playable1 = instantPlayPopup0.f;
                        if(playable1 != null) {
                            playable1.setLyricspath(streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyricpath);
                        }
                        Playable playable2 = instantPlayPopup0.f;
                        if(playable2 != null) {
                            playable2.setLyricLastUpdated(streamGetSongInfoRes$RESPONSE$ContentsInfo0.lyricfileupdtdate);
                        }
                        Lyric instantPlayPopup$Lyric0 = instantPlayPopup0.r;
                        if(ClassUtils.equals(instantPlayPopup0.f, instantPlayPopup$Lyric0.getPlayable())) {
                            Collection collection0 = instantPlayPopup$Lyric0.getLyricsInfoList();
                            if(collection0 != null && !collection0.isEmpty()) {
                                instantPlayPopup0.o.requestUpdateLyric(0L);
                                break;
                            }
                        }
                        instantPlayPopup$Lyric0.setPlayable(null);
                        instantPlayPopup$Lyric0.setLyricsInfoList(w.a);
                        instantPlayPopup$Lyric0.setCurrentIndex(0);
                        instantPlayPopup$Lyric0.setCurrentLyricTime(0L);
                        I2 i21 = instantPlayPopup0.B;
                        q.d(i21);
                        CharSequence charSequence0 = instantPlayPopup0.getText(0x7F1300EE);  // string:appwidget_lyric_searching_text "가사 검색 중..."
                        i21.j.setText(charSequence0);
                        I2 i22 = instantPlayPopup0.B;
                        q.d(i22);
                        i22.k.setText("");
                        f.execute$default(new b(instantPlayPopup0.f, false, instantPlayPopup0.D), null, 1, null);
                        break;
                    }
                    if(false) {
                        break;
                    }
                }
            }
            GetPathInfo streamGetPathRes$RESPONSE$GetPathInfo0 = ((StreamGetPathRes)object0).response.getpathinfo;
            if(streamGetPathRes$RESPONSE$GetPathInfo0 == null || TextUtils.isEmpty(streamGetPathRes$RESPONSE$GetPathInfo0.cid) || !ClassUtils.equals(streamGetPathRes$RESPONSE$GetPathInfo0.cid, (instantPlayPopup0.f == null ? null : ""))) {
                ToastManager.show(s1);
                instantPlayPopup0.dismiss();
                return;
            }
            String s2 = streamGetPathRes$RESPONSE$GetPathInfo0.path;
            if(instantPlayPopup0.f != null) {
                s = "";
            }
            String s3 = new CacheUrlBuilder(s2, s).cacheEnable(Ob.b.b()).build();
            try {
                q.d(s3);
                String s4 = streamGetPathRes$RESPONSE$GetPathInfo0.c;
                q.f(s4, "c");
                s5 = "";
                s5 = Ob.b.c(s3, s4);
                if(!URLUtil.isNetworkUrl(s5)) {
                    throw new MCacheError("Wrong mcache path: " + s5 + ", src:" + s3);
                }
            }
            catch(Exception exception0) {
                LogU.Companion.e("InstantPlayPopup", "mcache path error: " + exception0);
            }
            if(s5.equals("")) {
                ToastManager.show(s1);
                instantPlayPopup0.dismiss();
                return;
            }
            if(instantPlayPopup0.k == null) {
                OemMusicPlayer oemMusicPlayer0 = new OemMusicPlayer();
                instantPlayPopup0.k = oemMusicPlayer0;
                oemMusicPlayer0.initialize(instantPlayPopup0);
            }
            if(instantPlayPopup0.l == PlayerState.Idle || instantPlayPopup0.l == PlayerState.Stopped || instantPlayPopup0.l == PlayerState.PlaybackCompleted) {
                OemMusicPlayer oemMusicPlayer1 = instantPlayPopup0.k;
                if(oemMusicPlayer1 != null) {
                    oemMusicPlayer1.setData(Uri.parse(s5));
                }
                instantPlayPopup0.l = PlayerState.Preparing;
            }
        }
    }
}

