package com.iloen.melon.adapters.common;

import android.content.Context;
import android.text.TextUtils;
import com.iloen.melon.net.v4x.common.RecmdSongInfoBase;
import com.iloen.melon.net.v5x.common.StatsElementsBase;
import com.iloen.melon.playback.Playable;
import com.iloen.melon.types.Song;
import com.iloen.melon.utils.a;
import com.iloen.melon.utils.log.LogU;
import com.melon.net.res.common.AlbumInfoBase;
import com.melon.net.res.common.MvInfoBase;
import com.melon.net.res.common.SongInfoBase;
import e1.u;
import java.util.ArrayList;
import java.util.List;
import v9.m;
import va.e0;
import va.o;

public abstract class q extends j implements C, s {
    private static final String TAG = "MetaContentArrayAdapter";
    private boolean mIsScrolling;
    private String mMenuId;
    private String pageName;
    private String sectionName;
    private StatsElementsBase statsElements;

    public q(Context context0, List list0) {
        super(context0, list0);
        this.statsElements = null;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public List getAllIndexItems() {
        List list0 = new ArrayList();
        int v = this.getCount();
        for(int v1 = 0; v1 < v; v1 = a.d(v1, v1, 1, ((ArrayList)list0))) {
        }
        return list0;
    }

    public List getAllPlayableItems() {
        List list0 = new ArrayList();
        if(this.isEmpty()) {
            LogU.w("MetaContentArrayAdapter", "getAllPlayableItems() list empty");
            return list0;
        }
        int v = this.getCount();
        for(int v1 = 0; v1 < v; ++v1) {
            ((ArrayList)list0).add(this.getPlayable(v1));
        }
        return list0;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public m getAllWithoutRecommend() {
        boolean z4;
        boolean z3;
        int v = this.getCount();
        if(v == 0) {
            LogU.d("MetaContentArrayAdapter", "getAllWithoutRecommend() empty");
            return m.e;
        }
        m m0 = new m();
        boolean z = u.E(((e0)o.a()).j());
        boolean z1 = ((e0)o.a()).m();
        boolean z2 = false;
        int v2 = 0;
        int v3 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof SongInfoBase) {
                z3 = ((SongInfoBase)object0).isAdult;
                z4 = ((SongInfoBase)object0).canService;
            }
            else {
                z4 = false;
                z3 = false;
            }
            if(z4 && !(object0 instanceof RecmdSongInfoBase)) {
                if(z3 && (!z1 || !z)) {
                    ++v2;
                }
                m0.d.add(v3);
            }
            ++v3;
        }
        int v4 = m0.d.size();
        m0.a = v4 == 0;
        LogU.d("MetaContentArrayAdapter", "getMarkedList() marked:" + v4 + " adult:" + v2);
        if(v2 > 0 && v2 == v4) {
            LogU.d("MetaContentArrayAdapter", "getMarkedList() - 19 content scenario verified");
            m0.b = true;
        }
        if(v != v4) {
            z2 = true;
        }
        m0.c = z2;
        return m0;
    }

    public SongInfoBase getDetailSongItem(Object object0) {
        return null;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public m getMarkedList(boolean z) {
        boolean z7;
        boolean z6;
        boolean z5;
        boolean z4;
        int v3;
        int v = this.getCount();
        if(v == 0) {
            LogU.d("MetaContentArrayAdapter", "getMarkedList() empty");
            return m.e;
        }
        m m0 = new m();
        boolean z1 = u.E(((e0)o.a()).j());
        boolean z2 = ((e0)o.a()).m();
        boolean z3 = false;
        if(z) {
            int v2 = 0;
            v3 = 0;
            for(int v1 = 0; v1 < v; ++v1) {
                Object object0 = this.getItem(v1);
                if(object0 instanceof SongInfoBase) {
                    z4 = ((SongInfoBase)object0).isAdult;
                    z5 = ((SongInfoBase)object0).canService;
                }
                else if(this.isDetailSongItem(object0)) {
                    SongInfoBase songInfoBase0 = this.getDetailSongItem(object0);
                    z4 = songInfoBase0.isAdult;
                    z5 = songInfoBase0.canService;
                }
                else {
                    z5 = false;
                    z4 = false;
                }
                if(z5) {
                    if(z4 && (!z2 || !z1)) {
                        ++v3;
                    }
                    m0.d.add(v2);
                }
                ++v2;
            }
            z6 = v == m0.d.size() ? false : true;
        }
        else {
            List list0 = this.getMarkedItems();
            v3 = 0;
            for(Object object1: list0) {
                Object object2 = this.getItem(((int)(((Integer)object1))));
                if(object2 instanceof SongInfoBase) {
                    z7 = ((SongInfoBase)object2).isAdult;
                }
                else {
                    z7 = this.isDetailSongItem(object2) ? this.getDetailSongItem(object2).isAdult : false;
                }
                if(z7 && (!z2 || !z1)) {
                    ++v3;
                }
                m0.d.add(((Integer)object1));
            }
            z6 = list0.size() != m0.d.size();
        }
        int v4 = m0.d.size();
        if(v4 == 0) {
            z3 = true;
        }
        m0.a = z3;
        LogU.d("MetaContentArrayAdapter", "getMarkedList() marked:" + v4 + " adult:" + v3);
        if(v3 > 0 && v3 == v4) {
            LogU.d("MetaContentArrayAdapter", "getMarkedList() - 19 content scenario verified");
            m0.b = true;
        }
        m0.c = z6;
        return m0;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public List getMarkedPlayableItems() {
        List list0 = new ArrayList();
        List list1 = this.getMarkedItems();
        if(list1 != null) {
            for(Object object0: list1) {
                ((ArrayList)list0).add(this.getPlayable(((int)(((Integer)object0)))));
            }
        }
        return list0;
    }

    public String getMenuId() {
        return TextUtils.isEmpty(this.mMenuId) ? "9999999999" : this.mMenuId;
    }

    public String getPageName() {
        return this.pageName;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public Playable getPlayable(int v) {
        Object object0 = this.getItem(v);
        if(object0 != null) {
            if(object0 instanceof Playable) {
                return (Playable)object0;
            }
            int v1 = this.mListContentType;
            if(3 == v1) {
                if(object0 instanceof MvInfoBase) {
                    return Playable.from(((MvInfoBase)object0), this.getMenuId(), this.statsElements);
                }
                LogU.w("MetaContentArrayAdapter", "getPlayable() not MvInfoBase");
                return null;
            }
            if(1 == v1) {
                if(object0 instanceof SongInfoBase) {
                    return Playable.from(((SongInfoBase)object0), this.getMenuId(), this.statsElements);
                }
                if(this.isDetailSongItem(object0)) {
                    String s = this.getMenuId();
                    return Playable.from(this.getDetailSongItem(object0), s, this.statsElements);
                }
                LogU.w("MetaContentArrayAdapter", "getPlayable() not SongInfoBase");
                return null;
            }
            if(2 == v1) {
                if(object0 instanceof AlbumInfoBase) {
                    return Playable.from(((AlbumInfoBase)object0), this.getMenuId(), this.statsElements);
                }
                LogU.w("MetaContentArrayAdapter", "getPlayable() not AlbumInfoBase");
                return null;
            }
            LogU.w("MetaContentArrayAdapter", "getPlayable() not supported: " + object0);
        }
        return null;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public List getPlayableItems(List list0) {
        List list1 = new ArrayList();
        if(list0 != null) {
            for(Object object0: list0) {
                ((ArrayList)list1).add(this.getPlayable(((int)(((Integer)object0)))));
            }
        }
        return list1;
    }

    public int getPositionByAlbumId(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MetaContentArrayAdapter", "getPositionByAlbumId() invalid albumId");
            return -1;
        }
        int v = this.getCount();
        if(v == 0) {
            LogU.w("MetaContentArrayAdapter", "getPositionByAlbumId() list empty");
            return -1;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof AlbumInfoBase && s.equals(((AlbumInfoBase)object0).albumId)) {
                return v2;
            }
            ++v2;
        }
        LogU.w("MetaContentArrayAdapter", "getPositionByAlbumId() can not found");
        return -1;
    }

    public int getPositionByMvId(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MetaContentArrayAdapter", "getPositionByMvId() invalid mvId");
            return -1;
        }
        int v = this.getCount();
        if(v == 0) {
            LogU.w("MetaContentArrayAdapter", "getPositionByMvId() list empty");
            return -1;
        }
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof MvInfoBase && s.equals(((MvInfoBase)object0).mvId)) {
                return v1;
            }
        }
        LogU.w("MetaContentArrayAdapter", "getPositionByMvId() can not found");
        return -1;
    }

    public int getPositionBySongId(String s) {
        if(TextUtils.isEmpty(s)) {
            LogU.w("MetaContentArrayAdapter", "getPositionBySongId() invalid songId");
            return -1;
        }
        int v = this.getCount();
        if(v == 0) {
            LogU.w("MetaContentArrayAdapter", "getPositionBySongId() list empty");
            return -1;
        }
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = this.getItem(v1);
            if(object0 instanceof SongInfoBase && s.equals(((SongInfoBase)object0).songId)) {
                return v2;
            }
            ++v2;
        }
        LogU.w("MetaContentArrayAdapter", "getPositionBySongId() can not found");
        return -1;
    }

    public String getSectionName() {
        return this.sectionName;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public int getServiceAvailableCount() {
        int v = this.getCount();
        int v2 = 0;
        for(int v1 = 0; v1 < v; ++v1) {
            Object object0 = this.getItem(v1);
            if(!(object0 instanceof AlbumInfoBase) || this.mEditMode || ((AlbumInfoBase)object0).canService) {
                ++v2;
            }
        }
        return v2;
    }

    public List getSongIdItemsFromPositionIndices(List list0) {
        List list1 = new ArrayList();
        if(list0 != null && list0.size() != 0) {
            if(this.getCount() == 0) {
                LogU.w("MetaContentArrayAdapter", "getSongIdItemsFromPositionIndices() list empty");
                return list1;
            }
            for(Object object0: list0) {
                Object object1 = this.getItem(((int)(((Integer)object0))));
                if(object1 instanceof SongInfoBase) {
                    ((ArrayList)list1).add(((SongInfoBase)object1).songId);
                }
            }
            return list1;
        }
        LogU.w("MetaContentArrayAdapter", "getSongIdItemsFromPositionIndices() - invalid paramter");
        return list1;
    }

    @Override  // com.iloen.melon.adapters.common.s
    public List getSongsFromPositionIndices(List list0) {
        List list1 = new ArrayList();
        if(list0 != null && list0.size() != 0) {
            if(this.getCount() == 0) {
                LogU.w("MetaContentArrayAdapter", "getSongsFromPositionIndices() list empty");
                return list1;
            }
            for(Object object0: list0) {
                Object object1 = this.getItem(((int)(((Integer)object0))));
                if(object1 instanceof SongInfoBase) {
                    ((ArrayList)list1).add(Song.b(((SongInfoBase)object1).songId));
                }
                else if(this.isDetailSongItem(object1)) {
                    ((ArrayList)list1).add(Song.b(this.getDetailSongItem(object1).songId));
                }
            }
        }
        return list1;
    }

    public StatsElementsBase getStatsElements() {
        return this.statsElements;
    }

    public boolean ignoreCanService() {
        return false;
    }

    public boolean isDetailSongItem(Object object0) {
        return false;
    }

    public boolean isScrolling() {
        return this.mIsScrolling;
    }

    public boolean isServiceAvailable(int v) {
        Object object0 = this.getItem(v);
        if(object0 != null && object0 instanceof AlbumInfoBase) {
            return this.mEditMode ? true : ((AlbumInfoBase)object0).canService;
        }
        return false;
    }

    @Override  // com.iloen.melon.adapters.common.C
    public void onChangedScrollState(int v) {
        if(v == 2) {
            this.mIsScrolling = true;
            return;
        }
        this.mIsScrolling = false;
    }

    public void onScrollStateIdle() {
    }

    // 去混淆评级： 低(20)
    @Override  // com.iloen.melon.adapters.common.j
    public boolean setMarked(int v, String s, boolean z) {
        Object object0 = this.getItem(v);
        return this.ignoreCanService() || !(object0 instanceof AlbumInfoBase) || (this.mEditMode || ((AlbumInfoBase)object0).canService) ? super.setMarked(v, s, z) : false;
    }

    public void setMenuId(String s) {
        this.mMenuId = s;
    }

    public void setPageName(String s) {
        this.pageName = s;
    }

    public void setSectionName(String s) {
        this.sectionName = s;
    }

    public void setStatsElements(StatsElementsBase statsElementsBase0) {
        this.statsElements = statsElementsBase0;
    }
}

