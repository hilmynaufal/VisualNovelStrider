package com.hirumi.visualnovelstrider.model.dbstats;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ImageFlagging {
    @SerializedName("sexual_avg")
    @Expose
    public Double sexualAvg;
    @SerializedName("violence_avg")
    @Expose
    public Double violenceAvg;
    @SerializedName("votecount")
    @Expose
    public Double votecount;

    public Double getSexualAvg() {
        return sexualAvg;
    }

    public void setSexualAvg(Double sexualAvg) {
        this.sexualAvg = sexualAvg;
    }

    public Double getViolenceAvg() {
        return violenceAvg;
    }

    public void setViolenceAvg(Double violenceAvg) {
        this.violenceAvg = violenceAvg;
    }

    public Double getVotecount() {
        return votecount;
    }

    public void setVotecount(Double votecount) {
        this.votecount = votecount;
    }
}
