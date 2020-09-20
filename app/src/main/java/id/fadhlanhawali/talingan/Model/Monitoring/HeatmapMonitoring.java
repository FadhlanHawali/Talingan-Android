package id.fadhlanhawali.talingan.Model.Monitoring;

public class HeatmapMonitoring {
    String x,y,fill,accuracy;
    Integer heat;

    public HeatmapMonitoring(String x, String y, Integer heat,String fill,String accuracy) {
        this.x = x;
        this.y = y;
        this.fill = fill;
        this.accuracy = accuracy;
        this.heat = heat;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }

    public String getFill() {
        return fill;
    }

    public void setFill(String fill) {
        this.fill = fill;
    }

    public String getAccuracy() {
        return accuracy;
    }

    public void setAccuracy(String accuracy) {
        this.accuracy = accuracy;
    }

    public Integer getHeat() {
        return heat;
    }

    public void setHeat(Integer heat) {
        this.heat = heat;
    }
}
