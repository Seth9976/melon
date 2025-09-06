package com.iloen.melon.utils.contacts;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract.Contacts;
import jeb.synthetic.TWR;

@SuppressLint({"NewApi"})
public class ContactAccessorSdk5 extends ContactAccessor {
    @Override  // com.iloen.melon.utils.contacts.ContactAccessor
    public Intent getPickContactIntent() {
        return new Intent("android.intent.action.PICK", ContactsContract.Contacts.CONTENT_URI).setType("vnd.android.cursor.dir/phone_v2");
    }

    @Override  // com.iloen.melon.utils.contacts.ContactAccessor
    public ContactInfo loadContact(ContentResolver contentResolver0, Uri uri0) {
        ContactInfo contactInfo0 = new ContactInfo();
        Cursor cursor0 = contentResolver0.query(uri0, new String[]{"display_name", "data1"}, null, null, null);
        if(cursor0 == null) {
            return contactInfo0;
        }
        try {
            if(cursor0.moveToFirst()) {
                contactInfo0.setDisplayName(cursor0.getString(0));
                contactInfo0.setPhoneNumber(cursor0.getString(1));
            }
        }
        catch(Throwable throwable0) {
            TWR.safeClose$NT(cursor0, throwable0);
            throw throwable0;
        }
        cursor0.close();
        return contactInfo0;
    }
}

