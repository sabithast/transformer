package json.transformer.entity;

import java.util.List;

public class Block {
    private List<Floor> floors;
    private Long blocknumber;

    public Block(){}

    public Block(Long blocknumber, List<Floor> floors) {
        this.blocknumber = blocknumber;
        this.floors = floors;
    }

    public Long getBlocknumber() {
        return blocknumber;
    }

    public void setBlocknumber(Long blocknumber) {
        this.blocknumber = blocknumber;
    }

    public List<Floor> getFloors() {
        return floors;
    }

    public void setFloors(List<Floor> floors) {
        this.floors = floors;
    }
}
