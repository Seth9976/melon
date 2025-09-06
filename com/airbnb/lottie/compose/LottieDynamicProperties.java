package com.airbnb.lottie.compose;

import android.graphics.Bitmap;
import android.graphics.ColorFilter;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.Typeface;
import com.airbnb.lottie.LottieDrawable;
import com.airbnb.lottie.value.ScaleXY;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.q;
import org.jetbrains.annotations.NotNull;

@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u00D5\u0001\b\u0000\u0012\u0012\u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u0002\u0012\u0012\u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u0002\u0012\u0012\u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0002\u0012\u0012\u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u0002\u0012\u0012\u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u0002\u0012\u0016\u0010\u000F\u001A\u0012\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E0\u00030\u0002\u0012\u0012\u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u0002\u0012\u0012\u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00030\u0002\u0012\u0012\u0010\u0015\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00030\u0002\u0012\u0012\u0010\u0017\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u0002\u00A2\u0006\u0004\b\u0018\u0010\u0019B\u001B\b\u0016\u0012\u0010\u0010\u001A\u001A\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00030\u0002\u00A2\u0006\u0004\b\u0018\u0010\u001BJ\u0017\u0010!\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0000\u00A2\u0006\u0004\b\u001F\u0010 J\u0017\u0010#\u001A\u00020\u001E2\u0006\u0010\u001D\u001A\u00020\u001CH\u0000\u00A2\u0006\u0004\b\"\u0010 R \u0010\u0005\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0005\u0010$R \u0010\u0007\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0007\u0010$R \u0010\t\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\t\u0010$R \u0010\u000B\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\n0\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000B\u0010$R \u0010\r\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\r\u0010$R$\u0010\u000F\u001A\u0012\u0012\u000E\u0012\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u000E0\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u000F\u0010$R \u0010\u0011\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0011\u0010$R \u0010\u0013\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0013\u0010$R \u0010\u0015\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0015\u0010$R \u0010\u0017\u001A\u000E\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00030\u00028\u0002X\u0082\u0004\u00A2\u0006\u0006\n\u0004\b\u0017\u0010$\u00A8\u0006%"}, d2 = {"Lcom/airbnb/lottie/compose/LottieDynamicProperties;", "", "", "Lcom/airbnb/lottie/compose/LottieDynamicProperty;", "", "intProperties", "Landroid/graphics/PointF;", "pointFProperties", "", "floatProperties", "Lcom/airbnb/lottie/value/ScaleXY;", "scaleProperties", "Landroid/graphics/ColorFilter;", "colorFilterProperties", "", "intArrayProperties", "Landroid/graphics/Typeface;", "typefaceProperties", "Landroid/graphics/Bitmap;", "bitmapProperties", "", "charSequenceProperties", "Landroid/graphics/Path;", "pathProperties", "<init>", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;)V", "properties", "(Ljava/util/List;)V", "Lcom/airbnb/lottie/LottieDrawable;", "drawable", "Lie/H;", "addTo$lottie_compose_release", "(Lcom/airbnb/lottie/LottieDrawable;)V", "addTo", "removeFrom$lottie_compose_release", "removeFrom", "Ljava/util/List;", "lottie-compose_release"}, k = 1, mv = {1, 9, 0}, xi = 0x30)
public final class LottieDynamicProperties {
    public static final int $stable = 8;
    @NotNull
    private final List bitmapProperties;
    @NotNull
    private final List charSequenceProperties;
    @NotNull
    private final List colorFilterProperties;
    @NotNull
    private final List floatProperties;
    @NotNull
    private final List intArrayProperties;
    @NotNull
    private final List intProperties;
    @NotNull
    private final List pathProperties;
    @NotNull
    private final List pointFProperties;
    @NotNull
    private final List scaleProperties;
    @NotNull
    private final List typefaceProperties;

    public LottieDynamicProperties(@NotNull List list0) {
        q.g(list0, "properties");
        ArrayList arrayList0 = new ArrayList();
        for(Object object0: list0) {
            if(((LottieDynamicProperty)object0).getProperty$lottie_compose_release() instanceof Integer) {
                arrayList0.add(object0);
            }
        }
        ArrayList arrayList1 = new ArrayList();
        for(Object object1: list0) {
            if(((LottieDynamicProperty)object1).getProperty$lottie_compose_release() instanceof PointF) {
                arrayList1.add(object1);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        for(Object object2: list0) {
            if(((LottieDynamicProperty)object2).getProperty$lottie_compose_release() instanceof Float) {
                arrayList2.add(object2);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        for(Object object3: list0) {
            if(((LottieDynamicProperty)object3).getProperty$lottie_compose_release() instanceof ScaleXY) {
                arrayList3.add(object3);
            }
        }
        ArrayList arrayList4 = new ArrayList();
        for(Object object4: list0) {
            if(((LottieDynamicProperty)object4).getProperty$lottie_compose_release() instanceof ColorFilter) {
                arrayList4.add(object4);
            }
        }
        ArrayList arrayList5 = new ArrayList();
        for(Object object5: list0) {
            if(((LottieDynamicProperty)object5).getProperty$lottie_compose_release() instanceof Object[]) {
                arrayList5.add(object5);
            }
        }
        ArrayList arrayList6 = new ArrayList();
        for(Object object6: list0) {
            if(((LottieDynamicProperty)object6).getProperty$lottie_compose_release() instanceof Typeface) {
                arrayList6.add(object6);
            }
        }
        ArrayList arrayList7 = new ArrayList();
        for(Object object7: list0) {
            if(((LottieDynamicProperty)object7).getProperty$lottie_compose_release() instanceof Bitmap) {
                arrayList7.add(object7);
            }
        }
        ArrayList arrayList8 = new ArrayList();
        for(Object object8: list0) {
            if(((LottieDynamicProperty)object8).getProperty$lottie_compose_release() instanceof CharSequence) {
                arrayList8.add(object8);
            }
        }
        ArrayList arrayList9 = new ArrayList();
        for(Object object9: list0) {
            if(((LottieDynamicProperty)object9).getProperty$lottie_compose_release() instanceof Path) {
                arrayList9.add(object9);
            }
        }
        this(arrayList0, arrayList1, arrayList2, arrayList3, arrayList4, arrayList5, arrayList6, arrayList7, arrayList8, arrayList9);
    }

    public LottieDynamicProperties(@NotNull List list0, @NotNull List list1, @NotNull List list2, @NotNull List list3, @NotNull List list4, @NotNull List list5, @NotNull List list6, @NotNull List list7, @NotNull List list8, @NotNull List list9) {
        q.g(list0, "intProperties");
        q.g(list1, "pointFProperties");
        q.g(list2, "floatProperties");
        q.g(list3, "scaleProperties");
        q.g(list4, "colorFilterProperties");
        q.g(list5, "intArrayProperties");
        q.g(list6, "typefaceProperties");
        q.g(list7, "bitmapProperties");
        q.g(list8, "charSequenceProperties");
        q.g(list9, "pathProperties");
        super();
        this.intProperties = list0;
        this.pointFProperties = list1;
        this.floatProperties = list2;
        this.scaleProperties = list3;
        this.colorFilterProperties = list4;
        this.intArrayProperties = list5;
        this.typefaceProperties = list6;
        this.bitmapProperties = list7;
        this.charSequenceProperties = list8;
        this.pathProperties = list9;
    }

    public final void addTo$lottie_compose_release(@NotNull LottieDrawable lottieDrawable0) {
        q.g(lottieDrawable0, "drawable");
        for(Object object0: this.intProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object0).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object0).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object0).getCallback$lottie_compose_release()));
        }
        for(Object object1: this.pointFProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object1).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object1).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object1).getCallback$lottie_compose_release()));
        }
        for(Object object2: this.floatProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object2).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object2).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object2).getCallback$lottie_compose_release()));
        }
        for(Object object3: this.scaleProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object3).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object3).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object3).getCallback$lottie_compose_release()));
        }
        for(Object object4: this.colorFilterProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object4).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object4).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object4).getCallback$lottie_compose_release()));
        }
        for(Object object5: this.intArrayProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object5).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object5).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object5).getCallback$lottie_compose_release()));
        }
        for(Object object6: this.typefaceProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object6).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object6).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object6).getCallback$lottie_compose_release()));
        }
        for(Object object7: this.bitmapProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object7).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object7).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object7).getCallback$lottie_compose_release()));
        }
        for(Object object8: this.charSequenceProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object8).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object8).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object8).getCallback$lottie_compose_release()));
        }
        for(Object object9: this.pathProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object9).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object9).getProperty$lottie_compose_release(), LottieDynamicPropertiesKt.access$toValueCallback(((LottieDynamicProperty)object9).getCallback$lottie_compose_release()));
        }
    }

    public final void removeFrom$lottie_compose_release(@NotNull LottieDrawable lottieDrawable0) {
        q.g(lottieDrawable0, "drawable");
        for(Object object0: this.intProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object0).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object0).getProperty$lottie_compose_release(), null);
        }
        for(Object object1: this.pointFProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object1).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object1).getProperty$lottie_compose_release(), null);
        }
        for(Object object2: this.floatProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object2).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object2).getProperty$lottie_compose_release(), null);
        }
        for(Object object3: this.scaleProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object3).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object3).getProperty$lottie_compose_release(), null);
        }
        for(Object object4: this.colorFilterProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object4).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object4).getProperty$lottie_compose_release(), null);
        }
        for(Object object5: this.intArrayProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object5).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object5).getProperty$lottie_compose_release(), null);
        }
        for(Object object6: this.typefaceProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object6).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object6).getProperty$lottie_compose_release(), null);
        }
        for(Object object7: this.bitmapProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object7).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object7).getProperty$lottie_compose_release(), null);
        }
        for(Object object8: this.charSequenceProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object8).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object8).getProperty$lottie_compose_release(), null);
        }
        for(Object object9: this.pathProperties) {
            lottieDrawable0.addValueCallback(((LottieDynamicProperty)object9).getKeyPath$lottie_compose_release(), ((LottieDynamicProperty)object9).getProperty$lottie_compose_release(), null);
        }
    }
}

