package vendorapplication.entities;

import javax.persistence.*;

@Entity
@Table(name="routs")
public class ApplicationRoutesEntity {

    @Id
    @GeneratedValue(generator = "routs_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "routs_id_seq", sequenceName = "public.routs_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="id")
    private Long routeId;

    @OneToOne
    @JoinColumn(name="app_id" )
    private UserApplicationEntity appId;

    @OneToOne
    @JoinColumn(name="area_id" )
    private AvailableAreaEntity areaId;


    @Column(name="active")
    private boolean active;

    public Long getRouteId() {
        return routeId;
    }

    public void setRouteId(Long routeId) {
        this.routeId = routeId;
    }

    public UserApplicationEntity getAppId() {
        return appId;
    }

    public void setAppId(UserApplicationEntity appId) {
        this.appId = appId;
    }

    public AvailableAreaEntity getAreaId() {
        return areaId;
    }

    public void setAreaId(AvailableAreaEntity areaId) {
        this.areaId = areaId;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "ApplicationRoutesEntity{" +
                "routeId=" + routeId +
                ", appId=" + appId +
                ", areaId=" + areaId +
                ", active=" + active +
                '}';
    }
}