package he;

import jp.wasabeef.glide.transformations.RoundedCornersTransformation.CornerType;

public abstract class d {
    public static final int[] a;

    static {
        int[] arr_v = new int[RoundedCornersTransformation.CornerType.values().length];
        d.a = arr_v;
        try {
            arr_v[RoundedCornersTransformation.CornerType.ALL.ordinal()] = 1;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.TOP_LEFT.ordinal()] = 2;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.TOP_RIGHT.ordinal()] = 3;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.BOTTOM_LEFT.ordinal()] = 4;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.BOTTOM_RIGHT.ordinal()] = 5;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.TOP.ordinal()] = 6;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.BOTTOM.ordinal()] = 7;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.LEFT.ordinal()] = 8;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.RIGHT.ordinal()] = 9;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.OTHER_TOP_LEFT.ordinal()] = 10;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.OTHER_TOP_RIGHT.ordinal()] = 11;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.OTHER_BOTTOM_LEFT.ordinal()] = 12;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.OTHER_BOTTOM_RIGHT.ordinal()] = 13;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_LEFT.ordinal()] = 14;
        }
        catch(NoSuchFieldError unused_ex) {
        }
        try {
            d.a[RoundedCornersTransformation.CornerType.DIAGONAL_FROM_TOP_RIGHT.ordinal()] = 15;
        }
        catch(NoSuchFieldError unused_ex) {
        }
    }
}

