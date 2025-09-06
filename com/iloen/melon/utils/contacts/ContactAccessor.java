package com.iloen.melon.utils.contacts;

import android.content.ContentResolver;
import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;

public abstract class ContactAccessor {
    public static ContactAccessor a;

    public static ContactAccessor getInstance() {
        if(ContactAccessor.a == null) {
            String s = Integer.parseInt(Build.VERSION.SDK) >= 5 ? ContactAccessorSdk5.class.getCanonicalName() : ContactAccessorSdk3_4.class.getCanonicalName();
            try {
                ContactAccessor.a = (ContactAccessor)Class.forName(s).asSubclass(ContactAccessor.class).newInstance();
                return ContactAccessor.a;
            }
            catch(Exception exception0) {
                throw new IllegalStateException(exception0);
            }
        }
        return ContactAccessor.a;
    }

    public abstract Intent getPickContactIntent();

    public abstract ContactInfo loadContact(ContentResolver arg1, Uri arg2);
}

