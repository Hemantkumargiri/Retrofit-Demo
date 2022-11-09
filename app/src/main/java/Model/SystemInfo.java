package Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class SystemInfo {

    @SerializedName("client_ver")
    @Expose
    private String clientVer;
    @SerializedName("tun_ver")
    @Expose
    private String tunVer;
    @SerializedName("os_ver")
    @Expose
    private String osVer;
    @SerializedName("os_build")
    @Expose
    private String osBuild;
    @SerializedName("cpu")
    @Expose
    private String cpu;
    @SerializedName("cpu_usage_percent")
    @Expose
    private String cpuUsagePercent;
    @SerializedName("total_ram")
    @Expose
    private String totalRam;
    @SerializedName("free_ram")
    @Expose
    private String freeRam;

    public String getClientVer() {
        return clientVer;
    }

    public void setClientVer(String clientVer) {
        this.clientVer = clientVer;
    }

    public String getTunVer() {
        return tunVer;
    }

    public void setTunVer(String tunVer) {
        this.tunVer = tunVer;
    }

    public String getOsVer() {
        return osVer;
    }

    public void setOsVer(String osVer) {
        this.osVer = osVer;
    }

    public String getOsBuild() {
        return osBuild;
    }

    public void setOsBuild(String osBuild) {
        this.osBuild = osBuild;
    }

    public String getCpu() {
        return cpu;
    }

    public void setCpu(String cpu) {
        this.cpu = cpu;
    }

    public String getCpuUsagePercent() {
        return cpuUsagePercent;
    }

    public void setCpuUsagePercent(String cpuUsagePercent) {
        this.cpuUsagePercent = cpuUsagePercent;
    }

    public String getTotalRam() {
        return totalRam;
    }

    public void setTotalRam(String totalRam) {
        this.totalRam = totalRam;
    }

    public String getFreeRam() {
        return freeRam;
    }

    public void setFreeRam(String freeRam) {
        this.freeRam = freeRam;
    }

}
