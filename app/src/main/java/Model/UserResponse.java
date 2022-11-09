package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserResponse {

@SerializedName("api_key")
@Expose
private String apiKey;
@SerializedName("heartbeat_url")
@Expose
private String heartbeatUrl;
@SerializedName("heartbeat_freq_secs")
@Expose
private Integer heartbeatFreqSecs;

public String getApiKey() {
return apiKey;
}

public void setApiKey(String apiKey) {
this.apiKey = apiKey;
}

public String getHeartbeatUrl() {
return heartbeatUrl;
}

public void setHeartbeatUrl(String heartbeatUrl) {
this.heartbeatUrl = heartbeatUrl;
}

public Integer getHeartbeatFreqSecs() {
return heartbeatFreqSecs;
}

public void setHeartbeatFreqSecs(Integer heartbeatFreqSecs) {
this.heartbeatFreqSecs = heartbeatFreqSecs;
}

}