package vendorapplication.modal;

import java.io.Serializable;

public class BlockModal implements Serializable {

    private Integer blockId;
    private String blockName;

    public BlockModal() {
    }

    public BlockModal(Integer blockId, String blockName) {
        this.blockId = blockId;
        this.blockName = blockName;
    }

    public Integer getBlockId() {
        return blockId;
    }

    public void setBlockId(Integer blockId) {
        this.blockId = blockId;
    }

    public String getBlockName() {
        return blockName;
    }

    public void setBlockName(String blockName) {
        this.blockName = blockName;
    }

    @Override
    public String toString() {
        return "BlockModal{" +
                "blockId=" + blockId +
                ", blockName='" + blockName + '\'' +
                '}';
    }
}
