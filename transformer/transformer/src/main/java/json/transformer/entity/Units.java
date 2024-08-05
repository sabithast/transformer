package json.transformer.entity;

public class Units {
    private Long unitnumber;
    private boolean available;
    private String modelUuid;

    public Units(){}

    public Units(Long unitnumber, boolean available, String modelUuid) {
        this.unitnumber = unitnumber;
        this.available = available;
        this.modelUuid = modelUuid;
    }

    public Long getUnitnumber() {
        return unitnumber;
    }

    public void setUnitnumber(Long unitnumber) {
        this.unitnumber = unitnumber;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

    public String getModelUuid() {
        return modelUuid;
    }

    public void setModelUuid(String modelUuid) {
        this.modelUuid = modelUuid;
    }
}
