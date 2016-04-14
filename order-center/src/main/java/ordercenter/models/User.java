package ordercenter.models;

import common.models.utils.EntityClass;
import ordercenter.constants.UserType;
import org.hibernate.annotations.Type;
import org.joda.time.DateTime;

import javax.persistence.*;

/**
 * Created by llz on 2016/4/12.
 */
@Table(name = "user")
@Entity
public class User implements EntityClass<Integer> {
    /**
     * 用户ID
     */
    private Integer id;
    /**
     * 用户类型
     */
    private UserType userType;
    /**
     * 用户地址
     */
    private String address;
    /**
     * 用户真实姓名
     */
    private String realName;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户邮箱
     */
    private String email;
    /**
     * 用户电话
     */
    private String phone;
    /**
     * 用户名
     */
    private String name;
    /**
     * 用户头像
     */
    private String avatar;
    /**
     * 用户经营的产业
     */
    private String industry;
    /**
     * 用户产业规模
     */
    private String scale;
    /**
     * 用户最近登录时间
     */
    private DateTime lastLoginTime;
    /**
     * 用户注册时间
     */
    private DateTime registerTime;

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "address")
    @Basic
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Column(name = "type")
    @Enumerated(EnumType.STRING)
    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    @Column(name = "real_name")
    @Basic
    public String getRealName() {
        return realName;
    }

    @Column(name = "password")
    @Basic
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "email")
    @Basic
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Column(name = "phone")
    @Basic
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Column(name = "name")
    @Basic
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "avatar")
    @Basic
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Column(name = "industry")
    @Basic
    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    @Column(name = "scale")
    @Basic
    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    @Column(name = "last_login_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(DateTime lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Column(name = "register_time")
    @Type(type = "org.jadira.usertype.dateandtime.joda.PersistentDateTime")
    public DateTime getRegisterTime() {
        return registerTime;
    }

    public void setRegisterTime(DateTime registerTime) {
        this.registerTime = registerTime;
    }

}
