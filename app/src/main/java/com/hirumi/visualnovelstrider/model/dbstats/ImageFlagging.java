package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageFlagging {
    @SerializedName("sexual_avg")
    @Expose
    public Integer sexualAvg;
    @SerializedName("violence_avg")
    @Expose
    public Integer violenceAvg;
    @SerializedName("votecount")
    @Expose
    public Integer votecount;

    public Integer getSexualAvg() {
        return sexualAvg;
    }

    public void setSexualAvg(Integer sexualAvg) {
        this.sexualAvg = sexualAvg;
    }

    public Integer getViolenceAvg() {
        return violenceAvg;
    }

    public void setViolenceAvg(Integer violenceAvg) {
        this.violenceAvg = violenceAvg;
    }

    public Integer getVotecount() {
        return votecount;
    }

    public void setVotecount(Integer votecount) {
        this.votecount = votecount;
    }
}
