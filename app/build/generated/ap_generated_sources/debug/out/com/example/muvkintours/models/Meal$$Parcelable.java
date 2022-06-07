
package com.example.muvkintours.models;

import java.util.ArrayList;
import java.util.List;
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
public class Meal$$Parcelable
    implements Parcelable, ParcelWrapper<com.example.muvkintours.models.Meal>
{

    private com.example.muvkintours.models.Meal meal$$0;
    @SuppressWarnings("UnusedDeclaration")
    public final static Creator<Meal$$Parcelable>CREATOR = new Creator<Meal$$Parcelable>() {


        @Override
        public Meal$$Parcelable createFromParcel(android.os.Parcel parcel$$2) {
            return new Meal$$Parcelable(read(parcel$$2, new IdentityCollection()));
        }

        @Override
        public Meal$$Parcelable[] newArray(int size) {
            return new Meal$$Parcelable[size] ;
        }

    }
    ;

    public Meal$$Parcelable(com.example.muvkintours.models.Meal meal$$2) {
        meal$$0 = meal$$2;
    }

    @Override
    public void writeToParcel(android.os.Parcel parcel$$0, int flags) {
        write(meal$$0, parcel$$0, flags, new IdentityCollection());
    }

    public static void write(com.example.muvkintours.models.Meal meal$$1, android.os.Parcel parcel$$1, int flags$$0, IdentityCollection identityMap$$0) {
        int identity$$0 = identityMap$$0 .getKey(meal$$1);
        if (identity$$0 != -1) {
            parcel$$1 .writeInt(identity$$0);
        } else {
            parcel$$1 .writeInt(identityMap$$0 .put(meal$$1));
            if (InjectionUtil.getField(new InjectionUtil.GenericType<List<com.example.muvkintours.models.Category>>(), com.example.muvkintours.models.Meal.class, meal$$1, "categories") == null) {
                parcel$$1 .writeInt(-1);
            } else {
                parcel$$1 .writeInt(InjectionUtil.getField(new InjectionUtil.GenericType<List<com.example.muvkintours.models.Category>>(), com.example.muvkintours.models.Meal.class, meal$$1, "categories").size());
                for (com.example.muvkintours.models.Category category$$0 : InjectionUtil.getField(new InjectionUtil.GenericType<List<com.example.muvkintours.models.Category>>(), com.example.muvkintours.models.Meal.class, meal$$1, "categories")) {
                    com.example.muvkintours.models.Category$$Parcelable.write(category$$0, parcel$$1, flags$$0, identityMap$$0);
                }
            }
        }
    }

    @Override
    public int describeContents() {
        return  0;
    }

    @Override
    public com.example.muvkintours.models.Meal getParcel() {
        return meal$$0;
    }

    public static com.example.muvkintours.models.Meal read(android.os.Parcel parcel$$3, IdentityCollection identityMap$$1) {
        int identity$$1 = parcel$$3 .readInt();
        if (identityMap$$1 .containsKey(identity$$1)) {
            if (identityMap$$1 .isReserved(identity$$1)) {
                throw new ParcelerRuntimeException("An instance loop was detected whild building Parcelable and deseralization cannot continue.  This error is most likely due to using @ParcelConstructor or @ParcelFactory.");
            }
            return identityMap$$1 .get(identity$$1);
        } else {
            com.example.muvkintours.models.Meal meal$$4;
            int reservation$$0 = identityMap$$1 .reserve();
            meal$$4 = new com.example.muvkintours.models.Meal();
            identityMap$$1 .put(reservation$$0, meal$$4);
            int int$$0 = parcel$$3 .readInt();
            ArrayList<com.example.muvkintours.models.Category> list$$0;
            if (int$$0 < 0) {
                list$$0 = null;
            } else {
                list$$0 = new ArrayList<com.example.muvkintours.models.Category>(int$$0);
                for (int int$$1 = 0; (int$$1 <int$$0); int$$1 ++) {
                    com.example.muvkintours.models.Category category$$1 = com.example.muvkintours.models.Category$$Parcelable.read(parcel$$3, identityMap$$1);
                    list$$0 .add(category$$1);
                }
            }
            InjectionUtil.setField(com.example.muvkintours.models.Meal.class, meal$$4, "categories", list$$0);
            com.example.muvkintours.models.Meal meal$$3 = meal$$4;
            identityMap$$1 .put(identity$$1, meal$$3);
            return meal$$3;
        }
    }

}
