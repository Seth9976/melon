package com.iloen.melon.popup;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import com.iloen.melon.MelonAppBase;
import com.iloen.melon.utils.log.LogU;

@Deprecated(since = "Instead, Use MelonPopupHelper")
public class PopupHelper {
    public static final int DLG_OK = 0;
    public static final int DLG_OK_CANCEL = 1;
    protected static final int DLG_ONE_BUTTON = 2;
    protected static final int DLG_TWO_BUTTON = 3;

    public static boolean isAvailableActivity(Activity activity0) {
        if(activity0 != null && !activity0.isFinishing() && !MelonAppBase.instance.isAppPip()) {
            return true;
        }
        LogU.e("PopupHelper", "activity is null or not available!");
        return false;
    }

    public static MelonTextPopup makeAndShowTextPopup(Activity activity0, int v, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        if(!PopupHelper.isAvailableActivity(activity0)) {
            return null;
        }
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopup(activity0, v, s, s1, dialogInterface$OnClickListener0);
        if(melonTextPopup0 != null) {
            activity0.runOnUiThread(new PopupHelper.1(activity0, melonTextPopup0));
        }
        return melonTextPopup0;
    }

    public static MelonTextPopup makeTextPopup(Activity activity0, int v, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        MelonTextPopup melonTextPopup0;
        if(!PopupHelper.isAvailableActivity(activity0)) {
            return null;
        }
        switch(v) {
            case 0: {
                melonTextPopup0 = new MelonTextPopup(activity0, 1);
                break;
            }
            case 1: {
                melonTextPopup0 = new MelonTextPopup(activity0);
                break;
            }
            default: {
                LogU.e("PopupHelper", "makeTextPopup::Wrong popup type!");
                return null;
            }
        }
        melonTextPopup0.setTitleName(s);
        melonTextPopup0.setBodyMsg(s1);
        melonTextPopup0.setPopupOnClickListener(dialogInterface$OnClickListener0);
        return melonTextPopup0;
    }

    public static MelonTextPopup makeTextPopupCanTextButton(Activity activity0, int v, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        MelonTextPopup melonTextPopup0 = null;
        if(!PopupHelper.isAvailableActivity(activity0)) {
            return null;
        }
        switch(v) {
            case 2: {
                melonTextPopup0 = new MelonTextPopup(activity0, 1);
                break;
            }
            case 3: {
                melonTextPopup0 = new MelonTextPopup(activity0);
                break;
            }
            default: {
                LogU.e("PopupHelper", "showTextPopup::Wrong popup type!");
            }
        }
        if(melonTextPopup0 != null) {
            melonTextPopup0.setTitleName(s);
            melonTextPopup0.setBodyMsg(s1);
            melonTextPopup0.setPopupOnClickListener(dialogInterface$OnClickListener0);
        }
        return melonTextPopup0;
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showAlertPopup")
    public static MelonTextPopup showAlertPopup(Activity activity0, int v, int v1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        return PopupHelper.isAvailableActivity(activity0) ? PopupHelper.makeAndShowTextPopup(activity0, 0, activity0.getString(v), activity0.getString(v1), dialogInterface$OnClickListener0) : null;
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showAlertPopup")
    public static MelonTextPopup showAlertPopup(Activity activity0, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        return PopupHelper.makeAndShowTextPopup(activity0, 0, s, s1, dialogInterface$OnClickListener0);
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showTwoBtnAlertPopup")
    public static MelonTextPopup showConfirmPopup(Activity activity0, int v, int v1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        return PopupHelper.isAvailableActivity(activity0) ? PopupHelper.makeAndShowTextPopup(activity0, 1, activity0.getString(v), activity0.getString(v1), dialogInterface$OnClickListener0) : null;
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showTwoBtnAlertPopup")
    public static MelonTextPopup showConfirmPopup(Activity activity0, String s, String s1, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        return PopupHelper.makeAndShowTextPopup(activity0, 1, s, s1, dialogInterface$OnClickListener0);
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showAlertPopup")
    public static MelonTextPopup showOneButtonPopup(Activity activity0, int v, int v1, int v2, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        if(!PopupHelper.isAvailableActivity(activity0)) {
            return null;
        }
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopupCanTextButton(activity0, 2, activity0.getString(v), activity0.getString(v1), dialogInterface$OnClickListener0);
        if(melonTextPopup0 != null) {
            melonTextPopup0.setLeftBtnName(activity0.getString(v2));
            activity0.runOnUiThread(new PopupHelper.1(activity0, melonTextPopup0));
        }
        return melonTextPopup0;
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showTwoBtnAlertPopup")
    public static MelonTextPopup showTwoButtonPopup(Activity activity0, int v, int v1, int v2, int v3, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        if(!PopupHelper.isAvailableActivity(activity0)) {
            return null;
        }
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopupCanTextButton(activity0, 3, activity0.getString(v), activity0.getString(v1), dialogInterface$OnClickListener0);
        if(melonTextPopup0 != null) {
            melonTextPopup0.setRightBtnName(activity0.getString(v2));
            melonTextPopup0.setLeftBtnName(activity0.getString(v3));
            activity0.runOnUiThread(new PopupHelper.1(activity0, melonTextPopup0));
        }
        return melonTextPopup0;
    }

    @Deprecated(since = "Instead, Use MelonPopupHelper.showTwoBtnAlertPopup")
    public static MelonTextPopup showTwoButtonPopup(Activity activity0, String s, String s1, String s2, String s3, DialogInterface.OnClickListener dialogInterface$OnClickListener0) {
        MelonTextPopup melonTextPopup0 = PopupHelper.makeTextPopupCanTextButton(activity0, 3, s, s1, dialogInterface$OnClickListener0);
        if(melonTextPopup0 != null) {
            melonTextPopup0.setRightBtnName(s2);
            melonTextPopup0.setLeftBtnName(s3);
            activity0.runOnUiThread(new PopupHelper.1(activity0, melonTextPopup0));
        }
        return melonTextPopup0;
    }
}

