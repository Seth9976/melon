package com.iloen.melon.popup;

import com.android.volley.Response.Listener;
import com.iloen.melon.net.v5x.response.GenreMenuRes.RESPONSE.EXPERTSPICK.LIST;
import com.iloen.melon.net.v5x.response.GenreMenuRes.RESPONSE.EXPERTSPICK;
import com.iloen.melon.net.v5x.response.GenreMenuRes.RESPONSE.GNRMENULIST.GNRLIST;
import com.iloen.melon.net.v5x.response.GenreMenuRes.RESPONSE.GNRMENULIST;
import com.iloen.melon.net.v5x.response.GenreMenuRes;
import com.iloen.melon.types.MelonLinkInfo;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.system.ScreenUtils;
import java.util.ArrayList;
import java.util.Iterator;

class GenreAllPopup.4 implements Listener {
    public final GenreAllPopup a;

    public GenreAllPopup.4(GenreAllPopup genreAllPopup0) {
        this.a = genreAllPopup0;
    }

    public void onResponse(GenreMenuRes genreMenuRes0) {
        int v5;
        int v4;
        GenreAllPopup genreAllPopup0 = this.a;
        genreAllPopup0.h = genreMenuRes0.response;
        ArrayList arrayList0 = genreAllPopup0.c;
        if(genreMenuRes0.response != null) {
            arrayList0.clear();
            ArrayList arrayList1 = genreAllPopup0.h.gnrMenuList;
            int v = arrayList1.size();
            int v1 = -1;
            int v2 = 0;
            while(v2 < v) {
                if(v2 == 1) {
                    EXPERTSPICK genreMenuRes$RESPONSE$EXPERTSPICK0 = genreAllPopup0.h.expertsPick;
                    if(genreMenuRes$RESPONSE$EXPERTSPICK0 != null) {
                        arrayList0.add(new GenreInfo(genreAllPopup0, true, true, genreMenuRes$RESPONSE$EXPERTSPICK0.title, "", -1, null));
                        int v3 = 0;
                        for(Object object0: genreMenuRes$RESPONSE$EXPERTSPICK0.pickList) {
                            MelonLinkInfo melonLinkInfo0 = new MelonLinkInfo();
                            melonLinkInfo0.a = ((LIST)object0).linktype;
                            melonLinkInfo0.b = ((LIST)object0).linkurl;
                            arrayList0.add(new GenreInfo(genreAllPopup0, false, true, ((LIST)object0).dpName, ((LIST)object0).menuId, v3, melonLinkInfo0));
                            ++v3;
                        }
                        v4 = v3;
                    }
                }
                else {
                    v4 = 0;
                }
                arrayList0.add(new GenreInfo(genreAllPopup0, true, false, ((GNRMENULIST)arrayList1.get(v2)).menuName, ((GNRMENULIST)arrayList1.get(v2)).gnrMenuSeq, -1, null));
                Iterator iterator1 = ((GNRMENULIST)arrayList1.get(v2)).gnrList.iterator();
                while(true) {
                    v5 = v4;
                    if(!iterator1.hasNext()) {
                        break;
                    }
                    Object object1 = iterator1.next();
                    v4 = v5 + 1;
                    arrayList0.add(new GenreInfo(genreAllPopup0, false, false, ((GNRLIST)object1).gnrName, ((GNRLIST)object1).gnrCode, v5, null));
                }
                ++v2;
                v1 = v5;
            }
            if(v1 > 0) {
                int v6 = ScreenUtils.isOrientationPortrait(genreAllPopup0.getContext()) ? 2 : 3;
                int v7 = v1 % v6;
                if(v7 != 0) {
                    v6 = v7;
                }
                for(int v8 = 1; v8 <= v6; ++v8) {
                    ((GenreInfo)a.i(v8, arrayList0)).g = true;
                }
            }
        }
        GenreListAdapter genreAllPopup$GenreListAdapter0 = genreAllPopup0.e;
        if(genreAllPopup$GenreListAdapter0 != null) {
            genreAllPopup$GenreListAdapter0.notifyDataSetChanged();
        }
        if(genreMenuRes0.response != null) {
            com.iloen.melon.responsecache.a.a(genreAllPopup0.getContext(), genreMenuRes0, "genre_all");
        }
    }

    @Override  // com.android.volley.Response$Listener
    public void onResponse(Object object0) {
        this.onResponse(((GenreMenuRes)object0));
    }
}

