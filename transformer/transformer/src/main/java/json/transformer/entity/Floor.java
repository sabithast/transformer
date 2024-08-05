package json.transformer.entity;

import java.util.List;

public class Floor {
    private List<Units> units;
    private Long floornumber;

    public Floor(){}

    public Floor(Long floornumber, List<Units> units) {
        this.floornumber = floornumber;
        this.units = units;
    }

    public Long getFloornumber() {
        return floornumber;
    }

    public void setFloornumber(Long floornumber) {
        this.floornumber = floornumber;
    }

    public List<Units> getUnits() {
        return units;
    }

    public void setUnits(List<Units> units) {
        this.units = units;
    }
}
