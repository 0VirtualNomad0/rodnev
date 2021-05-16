package vendorapplication.entities;

import javax.persistence.*;

@Entity
@Table(name="roles")
public class RolesEntity   {

    @Id
    @GeneratedValue(generator = "roles_role_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "roles_role_id_seq", sequenceName = "public.roles_role_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name="role_id")
    private Long roleId;

    @Column(name="role_name")
    private String roleName;

    @Column(name="role_description")
    private String roleDescription;

    @Column(name="active")
    private boolean active;


    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDescription() {
        return roleDescription;
    }

    public void setRoleDescription(String roleDescription) {
        this.roleDescription = roleDescription;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }




    @Override
    public String toString() {
        return "RolesEntity{" +
                "roleId=" + roleId +
                ", roleName='" + roleName + '\'' +
                ", roleDescription='" + roleDescription + '\'' +
                ", active=" + active +
                '}';
    }
}