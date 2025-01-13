package dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class GetSingleUserRs {
    @SerializedName("data")
    @Expose
    private User user;
    @SerializedName("support")
    @Expose
    private Support support;
}
