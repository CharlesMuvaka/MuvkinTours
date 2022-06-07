
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
public class Category$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.muvkintours.models.Category>
{

    private com.example.muvkintours.models.Category category$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Category$$Parcelable>CREATOR = new Creator<Category$$Parcelable>() {


        @Override
        public Category$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Category$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Category$$Parcelable[] newArray(int size) {
            return new Category$$Parcelable[size] ;
        }

    }
    ;

    public Category$$Parcelable(com.example.muvkintours.models.Category category$$2) {
        category$$0 = category$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(category$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.muvkintours.models.Category category$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(category$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(category$$1));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.Category.class, category$$1, "strCategory"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.Category.class, category$$1, "strCategoryDescription"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.Category.class, category$$1, "idCategory"));
            parcel$$1 .writeString(InjectionUtil.getField(java.lang.String.class, com.example.muvkintours.models.Category.class, category$$1, "strCategoryThumb"));
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.muvkintours.models.Category getParcel() {
        return category$$0;
    }

    public static com.example.muvkintours.models.Category read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.muvkintours.models.Category category$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            category$$4 = new com.example.muvkintours.models.Category();
            identityMap$$1 .put(reservation$$0, category$$4);
            InjectionUtil.setField(com.example.muvkintours.models.Category.class, category$$4, "strCategory", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.Category.class, category$$4, "strCategoryDescription", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.Category.class, category$$4, "idCategory", parcel$$3 .readString());
            InjectionUtil.setField(com.example.muvkintours.models.Category.class, category$$4, "strCategoryThumb", parcel$$3 .readString());
            com.example.muvkintours.models.Category category$$3 = category$$4;
            identityMap$$1 .put(identity$$1, category$$3);
            return category$$3;
        }
    }

}
