package id.co.npad93.pm.t6;

import com.google.gson.annotations.SerializedName;

public class Idol {
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

    public void setName(String name) {
        this.name = name;
    }

    public String getJapaneseName() {
        return japaneseName;
    }

    public void setJapaneseName(String japaneseName) {
        this.japaneseName = japaneseName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getCharacterImageURL() {
        return "https://i.schoolido.lu/chibi/" + getCharacterImageFile();
    }

    public String getCharacterSmallImageURL() {
        return "https://i.schoolido.lu/chibi/small_" + getCharacterImageFile();
    }

    private String name;
    @SerializedName("japanese_name")
    private String japaneseName;
    private int age;
    @SerializedName("main_unit")
    private String group;
    private String summary;

    private String getCharacterImageFile() {
        return name.replace(' ', '_') + ".png";
    }
}
