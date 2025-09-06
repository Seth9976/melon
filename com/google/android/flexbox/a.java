package com.google.android.flexbox;

import android.view.View;
import java.util.List;

public interface a {
    void a(View arg1, int arg2, int arg3, b arg4);

    int b(int arg1, int arg2, int arg3);

    View c(int arg1);

    int d(int arg1, int arg2, int arg3);

    void e(View arg1, int arg2);

    int f(View arg1);

    int getAlignContent();

    int getAlignItems();

    int getFlexDirection();

    int getFlexItemCount();

    List getFlexLinesInternal();

    int getFlexWrap();

    int getLargestMainSize();

    int getMaxLine();

    int getPaddingBottom();

    int getPaddingEnd();

    int getPaddingLeft();

    int getPaddingRight();

    int getPaddingStart();

    int getPaddingTop();

    int getSumOfCrossSize();

    void i(b arg1);

    View j(int arg1);

    int k(View arg1, int arg2, int arg3);

    boolean m();

    void setFlexLines(List arg1);
}

