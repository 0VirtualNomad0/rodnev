package vendorapplication.entities;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "mst_state")
public class StateEntity {

    @Id
    @GeneratedValue(generator = "mst_state_state_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "mst_state_state_id_seq", sequenceName = "public.mst_state_state_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="state_id")
    private Integer stateID;

    @Column(name="state_name")
    private String stateName;

    @Column(name="is_active")
    private boolean isActive;

    @Column(name="is_deleted")
    private boolean isDeleted;

    @Column(name = "created_on")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;



    public Integer getRolestateId() {
        return stateID;
    }

    public Integer getStateID() {
        return stateID;
    }



    public void setStateID(Integer stateID) {
        this.stateID = stateID;
    }

    public void setRolestateId(Integer rolestateId) {
        this.stateID = rolestateId;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean deleted) {
        isDeleted = deleted;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }


}
