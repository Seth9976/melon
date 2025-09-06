package com.iloen.melon.adapters.common;

import android.text.TextUtils;
import com.iloen.melon.types.MelonLinkInfo;
import com.melon.net.res.common.ResponseBase;
import p8.s;

public class AdapterInViewHolder.Row {
    private String cdNum;
    private String contentId;
    private String contentOwner;
    private Object data;
    private boolean isFirstItem;
    private boolean isLocationSearch;
    private boolean isViewAll;
    private int itemViewType;
    private s melonTiaraProperty;
    private String menuId;
    private String pageImpressionId;
    private int position;
    private MelonLinkInfo viewAllLinkInfo;
    private boolean visibleBottomLine;

    public AdapterInViewHolder.Row(a a0) {
        this.visibleBottomLine = true;
        this.isLocationSearch = false;
        this.itemViewType = a0.a;
        this.data = a0.b;
        this.menuId = a0.c;
        this.pageImpressionId = a0.d;
        this.contentId = a0.e;
        this.isViewAll = a0.g;
        this.contentOwner = a0.f;
        this.isFirstItem = false;
        this.cdNum = null;
        this.melonTiaraProperty = a0.h;
        if(TextUtils.isEmpty(a0.c)) {
            Object object0 = this.data;
            if(object0 instanceof ResponseBase) {
                this.menuId = ((ResponseBase)object0).menuId;
            }
        }
    }

    public static AdapterInViewHolder.Row create(int v, Object object0) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = v;
        a0.b = object0;
        return new AdapterInViewHolder.Row(a0);
    }

    public static AdapterInViewHolder.Row create(int v, Object object0, String s) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = v;
        a0.b = object0;
        a0.c = s;
        return new AdapterInViewHolder.Row(a0);
    }

    public static AdapterInViewHolder.Row create(int v, Object object0, String s, String s1) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = v;
        a0.b = object0;
        a0.c = s;
        a0.d = s1;
        return new AdapterInViewHolder.Row(a0);
    }

    public static AdapterInViewHolder.Row create(int v, Object object0, String s, String s1, s s2) {
        a a0 = new a();  // 初始化器: Ljava/lang/Object;-><init>()V
        a0.a = v;
        a0.b = object0;
        a0.c = s;
        a0.d = s1;
        a0.h = s2;
        return new AdapterInViewHolder.Row(a0);
    }

    public String getCdNum() {
        return this.cdNum;
    }

    public String getContentId() {
        return this.contentId;
    }

    public String getContentOwner() {
        return this.contentOwner;
    }

    public Object getItem() {
        return this.data;
    }

    public int getItemViewType() {
        return this.itemViewType;
    }

    public s getMelonTiaraProperty() {
        return this.melonTiaraProperty;
    }

    public String getMenuId() {
        return this.menuId;
    }

    public String getPageImpressionId() {
        return this.pageImpressionId;
    }

    public int getPosition() {
        return this.position;
    }

    public MelonLinkInfo getViewAllLinkInfo() {
        return this.viewAllLinkInfo;
    }

    public boolean isFirstItem() {
        return this.isFirstItem;
    }

    public boolean isLocationSearch() {
        return this.isLocationSearch;
    }

    public boolean isViewAll() {
        return this.isViewAll;
    }

    public boolean isVisibleBottomLine() {
        return this.visibleBottomLine;
    }

    public void setCdNum(String s) {
        this.cdNum = s;
    }

    public void setContentId(String s) {
        this.contentId = s;
    }

    public void setContentOwner(String s) {
        this.contentOwner = s;
    }

    public void setFirstItem(boolean z) {
    }

    public void setItem(Object object0) {
        this.data = object0;
    }

    public void setLocationSearch(boolean z) {
        this.isLocationSearch = z;
    }

    public void setMelonTiaraProperty(s s0) {
        this.melonTiaraProperty = s0;
    }

    public void setMenuId(String s) {
        this.menuId = s;
    }

    public void setPageImpressionId(String s) {
        this.pageImpressionId = s;
    }

    public void setPosition(int v) {
        this.position = v;
    }

    public void setViewAll(boolean z) {
        this.isViewAll = z;
    }

    public void setViewAllLinkInfo(MelonLinkInfo melonLinkInfo0) {
        this.viewAllLinkInfo = melonLinkInfo0;
    }

    public void setVisibleBottomLine(boolean z) {
        this.visibleBottomLine = z;
    }
}

