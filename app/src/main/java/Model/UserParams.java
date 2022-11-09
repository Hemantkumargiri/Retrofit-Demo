package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class UserParams
{
    @SerializedName("user_id")
    @Expose
    private String userId;
    @SerializedName("user_pwd")
    @Expose
    private String userPwd;
    @SerializedName("device_uuid")
    @Expose
    private String deviceUuid;
    @SerializedName("system_info")
    @Expose
    private SystemInfo systemInfo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getDeviceUuid(String s) {
        return deviceUuid;
    }

    public void setDeviceUuid(String deviceUuid) {
        this.deviceUuid = deviceUuid;
    }

    public SystemInfo getSystemInfo() {
        return systemInfo;
    }

    public void setSystemInfo(SystemInfo systemInfo) {
        this.systemInfo = systemInfo;
    }

}
