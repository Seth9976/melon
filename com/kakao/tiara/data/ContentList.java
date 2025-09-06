package com.kakao.tiara.data;

import java.util.ArrayList;
import java.util.List;

public class ContentList {
    private List contents;

    public ContentList() {
        this.contents = new ArrayList();
    }

    public void addContent(Object object0) {
        this.contents.add(object0);
    }

    // 去混淆评级： 低(20)
    public List getContents() {
        return this.contents.isEmpty() ? null : this.contents;
    }
}

