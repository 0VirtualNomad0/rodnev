package vendorapplication.entities;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.LazyToOne;
import org.hibernate.annotations.LazyToOneOption;
import org.springframework.context.annotation.Lazy;
import sun.jvm.hotspot.opto.Block;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(generator = "users_user_id_seq", strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "users_user_id_seq", sequenceName = "public.users_user_id_seq", initialValue = 1, allocationSize = 1)
    @Column(name = "user_id", unique = true)
    private Long userId;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "username")
    private String username;

    @Column(name = "lastname")
    private String lastName;


    @Column(name = "password")
    private String password;

    @Column(name = "mobile_number")
    private Long mobileNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "p_address")
    private String pAddress;

    @OneToOne()
    @JoinColumn(name="state_id", updatable = false )
    @Basic(fetch=FetchType.LAZY)
    private StateEntity state;

    @OneToOne()
    @JoinColumn(name="district_id", updatable = false )
    @Basic(fetch=FetchType.LAZY)
    private DistrictEntity district;

    @OneToOne()
    @JoinColumn(name="block_id", updatable = false )
    private BlocksEntity block;

    @OneToOne()
    @JoinColumn(name="tehsil_id", updatable = false )
    private TehsilEntity tehsil;

    @OneToOne()
    @JoinColumn(name="panchayat_id", updatable = false )
    private GPEntity grampanchayat;


    @OneToOne()
    @JoinColumn(name="gender_id", updatable = false )
    private GenderEntity genderID;

    @Column(name = "age")
    private Integer age;

    @Column(name = "active")
    private boolean active;

    @Column(name = "isdeleted")
    private boolean isDeleted;

    @Column(name = "createddate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;


//    @Column(name = "updateddate")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date updatedDate;
//
//
//    @Column(name = "lastmodifieddate")
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastmodifieddate;

    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "user_role_mapping", joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "role_id"))
    private List<RolesEntity> roles;


    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(Long mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getpAddress() {
        return pAddress;
    }

    public void setpAddress(String pAddress) {
        this.pAddress = pAddress;
    }

    public StateEntity getState() {
        return state;
    }

    public void setState(StateEntity state) {
        this.state = state;
    }

    public DistrictEntity getDistrict() {
        return district;
    }

    public void setDistrict(DistrictEntity district) {
        this.district = district;
    }

    public BlocksEntity getBlock() {
        return block;
    }

    public void setBlock(BlocksEntity block) {
        this.block = block;
    }

    public TehsilEntity getTehsil() {
        return tehsil;
    }

    public void setTehsil(TehsilEntity tehsil) {
        this.tehsil = tehsil;
    }

    public GPEntity getGrampanchayat() {
        return grampanchayat;
    }

    public void setGrampanchayat(GPEntity grampanchayat) {
        this.grampanchayat = grampanchayat;
    }

    public GenderEntity getGenderID() {
        return genderID;
    }

    public void setGenderID(GenderEntity genderID) {
        this.genderID = genderID;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
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

//    public Date getUpdatedDate() {
//        return updatedDate;
//    }
//
//    public void setUpdatedDate(Date updatedDate) {
//        this.updatedDate = updatedDate;
//    }
//
//    public Date getLastmodifieddate() {
//        return lastmodifieddate;
//    }
//
//    public void setLastmodifieddate(Date lastmodifieddate) {
//        this.lastmodifieddate = lastmodifieddate;
//    }

    public List<RolesEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<RolesEntity> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "userId=" + userId +
                ", firstName='" + firstName + '\'' +
                ", username='" + username + '\'' +
                ", lastName='" + lastName + '\'' +
                ", password='" + password + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", email='" + email + '\'' +
                ", pAddress='" + pAddress + '\'' +
                ", state=" + state +
                ", district=" + district +
                ", block=" + block +
                ", tehsil=" + tehsil +
                ", grampanchayat=" + grampanchayat +
                ", genderID=" + genderID +
                ", age=" + age +
                ", active=" + active +
                ", isDeleted=" + isDeleted +
                ", createdDate=" + createdDate +
             //   ", updatedDate=" + updatedDate +
             //   ", lastmodifieddate=" + lastmodifieddate +
                ", roles=" + roles +
                '}';
    }
}