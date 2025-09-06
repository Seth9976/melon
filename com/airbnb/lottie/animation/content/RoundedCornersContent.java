package com.airbnb.lottie.animation.content;

import android.graphics.PointF;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation.AnimationListener;
import com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation;
import com.airbnb.lottie.model.CubicCurveData;
import com.airbnb.lottie.model.content.RoundedCorners;
import com.airbnb.lottie.model.content.ShapeData;
import com.airbnb.lottie.model.layer.BaseLayer;
import java.util.ArrayList;
import java.util.List;

public class RoundedCornersContent implements ShapeModifierContent, AnimationListener {
    private static final float ROUNDED_CORNER_MAGIC_NUMBER = 0.5519f;
    private final LottieDrawable lottieDrawable;
    private final String name;
    private final BaseKeyframeAnimation roundedCorners;
    private ShapeData shapeData;

    public RoundedCornersContent(LottieDrawable lottieDrawable0, BaseLayer baseLayer0, RoundedCorners roundedCorners0) {
        this.lottieDrawable = lottieDrawable0;
        this.name = roundedCorners0.getName();
        BaseKeyframeAnimation baseKeyframeAnimation0 = roundedCorners0.getCornerRadius().createAnimation();
        this.roundedCorners = baseKeyframeAnimation0;
        baseLayer0.addAnimation(baseKeyframeAnimation0);
        baseKeyframeAnimation0.addUpdateListener(this);
    }

    @Override  // com.airbnb.lottie.animation.content.ShapeModifierContent
    public void addUpdateListener(AnimationListener baseKeyframeAnimation$AnimationListener0) {
        this.roundedCorners.addUpdateListener(baseKeyframeAnimation$AnimationListener0);
    }

    private static int floorDiv(int v, int v1) {
        int v2 = v / v1;
        return (v ^ v1) >= 0 || v1 * v2 == v ? v2 : v2 - 1;
    }

    private static int floorMod(int v, int v1) {
        return v - RoundedCornersContent.floorDiv(v, v1) * v1;
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public String getName() {
        return this.name;
    }

    public BaseKeyframeAnimation getRoundedCorners() {
        return this.roundedCorners;
    }

    private ShapeData getShapeData(ShapeData shapeData0) {
        List list0 = shapeData0.getCurves();
        boolean z = shapeData0.isClosed();
        int v = list0.size() - 1;
        int v1 = 0;
        while(v >= 0) {
            CubicCurveData cubicCurveData0 = (CubicCurveData)list0.get(v);
            CubicCurveData cubicCurveData1 = (CubicCurveData)list0.get(RoundedCornersContent.floorMod(v - 1, list0.size()));
            PointF pointF0 = v != 0 || z ? cubicCurveData1.getVertex() : shapeData0.getInitialPoint();
            v1 = !(v != 0 || z ? cubicCurveData1.getControlPoint2() : pointF0).equals(pointF0) || !cubicCurveData0.getControlPoint1().equals(pointF0) || !shapeData0.isClosed() && (v == 0 || v == list0.size() - 1) ? v1 + 1 : v1 + 2;
            --v;
        }
        if(this.shapeData == null || this.shapeData.getCurves().size() != v1) {
            ArrayList arrayList0 = new ArrayList(v1);
            for(int v2 = 0; v2 < v1; ++v2) {
                arrayList0.add(new CubicCurveData());
            }
            this.shapeData = new ShapeData(new PointF(0.0f, 0.0f), false, arrayList0);
        }
        this.shapeData.setClosed(z);
        return this.shapeData;
    }

    @Override  // com.airbnb.lottie.animation.content.ShapeModifierContent
    public ShapeData modifyShape(ShapeData shapeData0) {
        List list0 = shapeData0.getCurves();
        if(list0.size() > 2) {
            float f = (float)(((Float)this.roundedCorners.getValue()));
            if(f != 0.0f) {
                ShapeData shapeData1 = this.getShapeData(shapeData0);
                shapeData1.setInitialPoint(shapeData0.getInitialPoint().x, shapeData0.getInitialPoint().y);
                List list1 = shapeData1.getCurves();
                boolean z = shapeData0.isClosed();
                int v1 = 0;
                for(int v = 0; v < list0.size(); ++v) {
                    CubicCurveData cubicCurveData0 = (CubicCurveData)list0.get(v);
                    CubicCurveData cubicCurveData1 = (CubicCurveData)list0.get(RoundedCornersContent.floorMod(v - 1, list0.size()));
                    CubicCurveData cubicCurveData2 = (CubicCurveData)list0.get(RoundedCornersContent.floorMod(v - 2, list0.size()));
                    PointF pointF0 = v != 0 || z ? cubicCurveData1.getVertex() : shapeData0.getInitialPoint();
                    PointF pointF1 = v != 0 || z ? cubicCurveData1.getControlPoint2() : pointF0;
                    boolean z1 = true;
                    PointF pointF2 = cubicCurveData0.getControlPoint1();
                    PointF pointF3 = cubicCurveData2.getVertex();
                    PointF pointF4 = cubicCurveData0.getVertex();
                    if(shapeData0.isClosed() || v != 0 && v != list0.size() - 1) {
                        z1 = false;
                    }
                    if(!pointF1.equals(pointF0) || !pointF2.equals(pointF0) || z1) {
                        CubicCurveData cubicCurveData6 = (CubicCurveData)list1.get(RoundedCornersContent.floorMod(v1 - 1, list1.size()));
                        CubicCurveData cubicCurveData7 = (CubicCurveData)list1.get(v1);
                        cubicCurveData6.setControlPoint2(cubicCurveData1.getControlPoint2().x, cubicCurveData1.getControlPoint2().y);
                        cubicCurveData6.setVertex(cubicCurveData1.getVertex().x, cubicCurveData1.getVertex().y);
                        cubicCurveData7.setControlPoint1(cubicCurveData0.getControlPoint1().x, cubicCurveData0.getControlPoint1().y);
                        ++v1;
                    }
                    else {
                        float f1 = (float)Math.hypot(pointF4.x - pointF0.x, pointF4.y - pointF0.y);
                        float f2 = Math.min(f / ((float)Math.hypot(pointF0.x - pointF3.x, pointF0.y - pointF3.y)), 0.5f);
                        float f3 = Math.min(f / f1, 0.5f);
                        float f4 = (pointF3.x - pointF0.x) * f2 + pointF0.x;
                        float f5 = (pointF3.y - pointF0.y) * f2 + pointF0.y;
                        float f6 = (pointF4.x - pointF0.x) * f3 + pointF0.x;
                        float f7 = (pointF4.y - pointF0.y) * f3 + pointF0.y;
                        float f8 = f4 - (f4 - pointF0.x) * 0.5519f;
                        float f9 = f5 - (f5 - pointF0.y) * 0.5519f;
                        float f10 = f6 - (f6 - pointF0.x) * 0.5519f;
                        float f11 = f7 - (f7 - pointF0.y) * 0.5519f;
                        CubicCurveData cubicCurveData3 = (CubicCurveData)list1.get(RoundedCornersContent.floorMod(v1 - 1, list1.size()));
                        CubicCurveData cubicCurveData4 = (CubicCurveData)list1.get(v1);
                        cubicCurveData3.setControlPoint2(f4, f5);
                        cubicCurveData3.setVertex(f4, f5);
                        if(v == 0) {
                            shapeData1.setInitialPoint(f4, f5);
                        }
                        cubicCurveData4.setControlPoint1(f8, f9);
                        CubicCurveData cubicCurveData5 = (CubicCurveData)list1.get(v1 + 1);
                        cubicCurveData4.setControlPoint2(f10, f11);
                        cubicCurveData4.setVertex(f6, f7);
                        cubicCurveData5.setControlPoint1(f6, f7);
                        v1 += 2;
                    }
                }
                return shapeData1;
            }
        }
        return shapeData0;
    }

    @Override  // com.airbnb.lottie.animation.keyframe.BaseKeyframeAnimation$AnimationListener
    public void onValueChanged() {
        this.lottieDrawable.invalidateSelf();
    }

    @Override  // com.airbnb.lottie.animation.content.Content
    public void setContents(List list0, List list1) {
    }
}

