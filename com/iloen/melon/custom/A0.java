package com.iloen.melon.custom;

import A7.d;
import android.os.Message;
import android.text.TextUtils;
import com.iloen.melon.eventbus.EventBusHelper;
import com.iloen.melon.eventbus.EventWebView.UncheckAll;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.player.playlist.tiara.ToolbarTiaraLogHelper;
import com.iloen.melon.utils.log.LogU;
import java.util.ArrayList;
import java.util.HashMap;
import p8.s;

public final class a0 extends U0 {
    public final int a;

    public a0(Object object0, int v) {
        this.a = v;
        super(object0);
    }

    @Override  // com.iloen.melon.custom.U0
    public final void handleMessage(Object object0, Message message0) {
        ArrayList arrayList0;
        if(this.a != 0) {
            LogU.v("MelonWebView", "msg.what : " + message0.what + " , msg.obj : " + message0.obj);
            int v = message0.what;
            int v1 = 0;
            switch(v) {
                case 1: {
                    String s4 = (String)message0.obj;
                    ((MelonWebView)object0).a.showBlockedProgress(true);
                    LogU.d("MelonWebView", "addNowPlayingList() " + s4);
                    HashMap hashMap1 = MelonWebView.d(s4);
                    String s5 = (String)hashMap1.get("items");
                    String s6 = (String)hashMap1.get("ctype");
                    String s7 = (String)hashMap1.get("menuId");
                    StringBuilder stringBuilder1 = d.o("addNowPlayingList() cid:", s5, ", ctype:", s6, ", menuId:");
                    stringBuilder1.append(s7);
                    LogU.d("MelonWebView", stringBuilder1.toString());
                    if(!TextUtils.isEmpty(s5) && !TextUtils.isEmpty(s6)) {
                        MelonWebViewListener melonWebViewListener0 = ((MelonWebView)object0).w;
                        if(melonWebViewListener0 != null) {
                            melonWebViewListener0.addOrPlay(false, s6, s7, s5);
                        }
                    }
                    ((MelonWebView)object0).a.showBlockedProgress(false);
                    EventBusHelper.post(new UncheckAll());
                    return;
                }
                case 2: {
                    String s8 = (String)message0.obj;
                    r0 r00 = new r0(((MelonWebView)object0));
                    r00.c = s8;
                    r00.execute(null);
                    return;
                }
                case 0: 
                case 3: {
                    String s = (String)message0.obj;
                    LogU.d("MelonWebView", "streaming() params: " + s);
                    HashMap hashMap0 = MelonWebView.d(s);
                    String s1 = (String)hashMap0.get("items");
                    String s2 = (String)hashMap0.get("ctype");
                    String s3 = (String)hashMap0.get("menuId");
                    StringBuilder stringBuilder0 = d.o("streaming() cid:", s1, ", ctype:", s2, ", menuId:");
                    stringBuilder0.append(s3);
                    LogU.d("MelonWebView", stringBuilder0.toString());
                    if(TextUtils.isEmpty(s3)) {
                        s3 = "1000000543";
                    }
                    if(!TextUtils.isEmpty(s1) && !TextUtils.isEmpty(s2) && ((MelonWebView)object0).w != null) {
                        if(TextUtils.isEmpty(s1)) {
                            arrayList0 = null;
                        }
                        else {
                            arrayList0 = new ArrayList();
                            String[] arr_s = s1.split(",");
                            for(int v2 = 0; v2 < arr_s.length; ++v2) {
                                arrayList0.add(Playable.newBuilder().songId(arr_s[v2]).cType(s2).menuId(s3).build());
                            }
                        }
                        if(v != 0) {
                            v1 = 0x1F;
                        }
                        ToolbarTiaraLogHelper.sendClickLog(v1, new s("", "", s3, null), arrayList0);
                        if(v == 0) {
                            ((MelonWebView)object0).w.addOrPlay(true, s2, s3, s1);
                        }
                        else {
                            ((MelonWebView)object0).w.playMixUp(s2, s3, s1);
                        }
                    }
                    EventBusHelper.post(new UncheckAll());
                    return;
                }
                default: {
                    return;
                }
            }
        }
        if(message0.what == 0) {
            ItemsPagerContainer.b(((ItemsPagerContainer)object0));
        }
    }
}

