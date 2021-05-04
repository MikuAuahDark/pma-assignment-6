package id.co.npad93.pm.t6;

import com.google.gson.annotations.SerializedName;

public class Card {
    public class MiniIdol {
        public String name;
    }

    public class Stats {
        public int smile, pure, cool;
    }

    public String getName() {
        return miniIdol.name;
    }

    public String getNameLLMFSOrder() {
        String names[] = miniIdol.name.split(" ");

        switch (names.length) {
            case 0:
            case 1:
            default:
                return miniIdol.name;
            case 2:
                return names[1] + " " + names[0];
        }
    }

    public String getCollection() {
        return collection;
    }

    public String getTranslatedCollection() {
        return translatedCollection;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public int getHp() {
        return hp;
    }

    public Stats getBaseStats() {
        Stats result = new Stats();
        result.smile = baseStatsSmile;
        result.pure = baseStatsPure;
        result.cool = baseStatsCool;
        return result;
    }

    public Stats getMaxStats() {
        Stats result = new Stats();
        result.smile = maxStatsSmile;
        result.pure = maxStatsPure;
        result.cool = maxStatsCool;
        return result;
    }

    public Stats getMaxIdolizedStats() {
        Stats result = new Stats();
        result.smile = maxIdolizedStatsSmile;
        result.pure = maxIdolizedStatsPure;
        result.cool = maxIdolizedStatsCool;
        return result;
    }

    public String getSkillName() {
        return skillName;
    }

    public String getTranslatedSkillName() {
        return translatedSkillName.isEmpty() ? null : translatedSkillName;
    }

    public String getSkillDetails() {
        return skillDetails;
    }

    public String getCenterSkill() {
        return centerSkill;
    }

    public String getCenterSkillDetails() {
        return centerSkillDetails;
    }

    public String getCardImageURL() {
        return "https:" + cardImage;
    }

    public String getIdolizedCardImageURL() {
        return "https:" + idolizedCardImage;
    }

    public String getRoundedCardImageURL() {
        return "https:" + roundedCardImage;
    }

    @SerializedName("idol")
    private MiniIdol miniIdol;
    @SerializedName("japanese_collection")
    private String collection;
    @SerializedName("translated_collection")
    private String translatedCollection;
    @SerializedName("release_date")
    private String releaseDate;
    private int hp;
    @SerializedName("minimum_statistics_smile")
    private int baseStatsSmile;
    @SerializedName("minimum_statistics_pure")
    private int baseStatsPure;
    @SerializedName("minimum_statistics_cool")
    private int baseStatsCool;
    @SerializedName("non_idolized_maximum_statistics_smile")
    private int maxStatsSmile;
    @SerializedName("non_idolized_maximum_statistics_pure")
    private int maxStatsPure;
    @SerializedName("non_idolized_maximum_statistics_cool")
    private int maxStatsCool;
    @SerializedName("idolized_maximum_statistics_smile")
    private int maxIdolizedStatsSmile;
    @SerializedName("idolized_maximum_statistics_pure")
    private int maxIdolizedStatsPure;
    @SerializedName("idolized_maximum_statistics_cool")
    private int maxIdolizedStatsCool;
    @SerializedName("japanese_skill")
    private String skillName;
    @SerializedName("skill")
    private String translatedSkillName;
    @SerializedName("skill_details")
    private String skillDetails;
    @SerializedName("center_skill")
    private String centerSkill;
    @SerializedName("center_skill_details")
    private String centerSkillDetails;
    @SerializedName("card_image")
    private String cardImage;
    @SerializedName("card_idolized_image")
    private String idolizedCardImage;
    @SerializedName("round_card_image")
    private String roundedCardImage;
}
