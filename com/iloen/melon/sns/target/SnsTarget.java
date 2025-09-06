package com.iloen.melon.sns.target;

public interface SnsTarget {
    void a(SnsManager.PostParam arg1, SnsPostListener arg2);

    boolean b();

    String getId();
}

