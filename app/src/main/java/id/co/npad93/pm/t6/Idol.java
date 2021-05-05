package id.co.npad93.pm.t6;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

public class Idol implements Parcelable {
    public String getName() {
        return name;
    }

    public String getNameLLMFSOrder() {
        String names[] = name.split(" ");

        switch (names.length) {
            case 0:
            case 1:
            default:
                return name;
            case 2:
                return names[1] + " " + names[0];
        }
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public String getVAName() {
        return cv.name;
    }

    public int getAge() {
        return age;
    }

    public String getGroup() {
        return group;
    }

    public String getSubGroup() {
        return subGroup;
    }

    public String getSummary() {
        return summary;
    }

    public String getCharacterImageURL() {
        return "https://i.schoolido.lu/chibi/" + getCharacterImageFile();
    }

    public String getCharacterSmallImageURL() {
        return "https://i.schoolido.lu/chibi/small_" + getCharacterImageFile();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(japaneseName);
        dest.writeInt(age);
        dest.writeString(group);
        dest.writeString(subGroup);
        dest.writeString(summary);
        dest.writeString(cv.name);
    }

    public static final Parcelable.Creator<Idol> CREATOR = new Parcelable.Creator<Idol>() {
        @Override
        public Idol createFromParcel(Parcel source) {
            Idol i = new Idol();
            i.name = source.readString();
            i.japaneseName = source.readString();
            i.age = source.readInt();
            i.group = source.readString();
            i.subGroup = source.readString();
            i.summary = source.readString();
            i.cv = new CV();
            i.cv.name = source.readString();
            return i;
        }

        @Override
        public Idol[] newArray(int size) {
            return new Idol[size];
        }
    };

    public static class CV {
        private String name;
    }

    private String name;
    @SerializedName("japanese_name")
    private String japaneseName;
    private int age;
    @SerializedName("main_unit")
    private String group;
    @SerializedName("sub_unit")
    private String subGroup;
    private String summary;
    private CV cv;

    private String getCharacterImageFile() {
        return name.replace(' ', '_') + ".png";
    }
}
