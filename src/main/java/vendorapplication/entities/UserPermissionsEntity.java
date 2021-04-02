package vendorapplication.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="userapplication_permissions")
public class UserPermissionsEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "userapplication_permissions_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "userapplication_permissions_id_seq", sequenceName = "public.userapplication_permissions_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "id")
    private Integer id;

    @Column(name = "app_id")
    private Integer appId;


    @Column(name="user_id" ,updatable = false)
    private Integer userId;

    @Column(name = "role_name")
    private String roleName;

    @Column(name = "status")
    private String status;

    @Column(name = "comments")
    private String comments;

    @Column(name = "attachment")
    private String attachemnts;

    @Column(name="applicatnt_mobile")
    private String applicantMobile;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createddate;

    public String getRoleId() {
        return roleName;
    }

    public void setRoleId(String roleId) {
        this.roleName = roleId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAppId() {
        return appId;
    }

    public void setAppId(Integer appId) {
        this.appId = appId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getAttachemnts() {
        return attachemnts;
    }

    public void setAttachemnts(String attachemnts) {
        this.attachemnts = attachemnts;
    }

    public String getApplicantMobile() {
        return applicantMobile;
    }

    public void setApplicantMobile(String applicantMobile) {
        this.applicantMobile = applicantMobile;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Date getCreateddate() {
        return createddate;
    }

    public void setCreateddate(Date createddate) {
        this.createddate = createddate;
    }

    @Override
    public String toString() {
        return "UserPermissionsEntity{" +
                "id=" + id +
                ", appId=" + appId +
                ", userId=" + userId +
                ", roleId=" + roleName +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", attachemnts='" + attachemnts + '\'' +
                ", applicantMobile='" + applicantMobile + '\'' +
                ", active=" + active +
                ", createddate=" + createddate +
                '}';
    }
}
