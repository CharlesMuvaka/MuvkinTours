
package com.example.muvkintours.models;

import android.os.Parcelable;
import android.os.Parcelable.Creator;
import org.parceler.Generated;
import org.parceler.IdentityCollection;
import org.parceler.InjectionUtil;
import org.parceler.ParcelWrapper;
import org.parceler.ParcelerRuntimeException;

@Generated("org.parceler.ParcelAnnotationProcessor")
@SuppressWarnings({
    "unchecked",
    "deprecation"
})
public class User$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.muvkintours.models.User>
{

    private com.example.muvkintours.models.User user$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<User$$Parcelable>CREATOR = new Creator<User$$Parcelable>() {


        @Override
        public User$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new User$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public User$$Parcelable[] newArray(int size) {
            return new User$$Parcelable[size] ;
        }

    }
    ;

    public User$$Parcelable(com.example.muvkintours.models.User user$$2) {
        user$$0 = user$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(user$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.muvkintours.models.User user$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(user$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(user$$1));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.User.class, user$$1, "seat"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.User.class, user$$1, "ticket"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.User.class, user$$1, "phone"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.User.class, user$$1, "coach"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.User.class, user$$1, "username"));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.muvkintours.models.User getParcel() {
        return user$$0;
    }

    public static com.example.muvkintours.models.User read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.muvkintours.models.User user$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            user$$4 = new com.example.muvkintours.models.User();
            identityMap$$1 .put(reservation$$0, user$$4);
            InjectionUtil.setField(com.example.muvkintours.models.User.class, user$$4, "seat", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.User.class, user$$4, "ticket", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.User.class, user$$4, "phone", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.User.class, user$$4, "coach", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.User.class, user$$4, "username", parcel$$3 .readString());
            com.example.muvkintours.models.User user$$3 = user$$4;
            identityMap$$1 .put(identity$$1, user$$3);
            return user$$3;
        }
    }

}
