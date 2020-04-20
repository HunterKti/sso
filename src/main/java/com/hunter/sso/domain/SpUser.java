package com.hunter.sso.domain;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.*;

@Table(name = "sp_user")
public class SpUser {
    /**
     * 主键
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SELECT LAST_INSERT_ID()")
    private Integer id;

    /**
     * 用户编号
     */
    private String no;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 电话
     */
    private String phone;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 性别 0 未知；1 男；2 女
     */
    private Integer sex;

    /**
     * 头像
     */
    private String img;

    /**
     * 简介
     */
    private String note;

    /**
     * 创建日期
     */
    @Column(name = "create_date")
    private Date createDate;

    /**
     * 区域id
     */
    @Column(name = "area_id")
    private Integer areaId;

    /**
     * 会员类型
     */
    private Integer state;

    /**
     * 账户金额
     */
    private BigDecimal amount;

    /**
     * 推广费用
     */
    @Column(name = "promote_fees")
    private BigDecimal promoteFees;

    /**
     * 邀请码
     */
    @Column(name = "invite_code")
    private String inviteCode;

    /**
     * 获取主键
     *
     * @return id - 主键
     */
    public Integer getId() {
        return id;
    }

    /**
     * 设置主键
     *
     * @param id 主键
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取用户编号
     *
     * @return no - 用户编号
     */
    public String getNo() {
        return no;
    }

    /**
     * 设置用户编号
     *
     * @param no 用户编号
     */
    public void setNo(String no) {
        this.no = no;
    }

    /**
     * 获取用户姓名
     *
     * @return username - 用户姓名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户姓名
     *
     * @param username 用户姓名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取登录密码
     *
     * @return password - 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置登录密码
     *
     * @param password 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取性别 0 未知；1 男；2 女
     *
     * @return sex - 性别 0 未知；1 男；2 女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别 0 未知；1 男；2 女
     *
     * @param sex 性别 0 未知；1 男；2 女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取头像
     *
     * @return img - 头像
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置头像
     *
     * @param img 头像
     */
    public void setImg(String img) {
        this.img = img;
    }

    /**
     * 获取简介
     *
     * @return note - 简介
     */
    public String getNote() {
        return note;
    }

    /**
     * 设置简介
     *
     * @param note 简介
     */
    public void setNote(String note) {
        this.note = note;
    }

    /**
     * 获取创建日期
     *
     * @return create_date - 创建日期
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * 设置创建日期
     *
     * @param createDate 创建日期
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * 获取区域id
     *
     * @return area_id - 区域id
     */
    public Integer getAreaId() {
        return areaId;
    }

    /**
     * 设置区域id
     *
     * @param areaId 区域id
     */
    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    /**
     * 获取会员类型
     *
     * @return state - 会员类型
     */
    public Integer getState() {
        return state;
    }

    /**
     * 设置会员类型
     *
     * @param state 会员类型
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 获取账户金额
     *
     * @return amount - 账户金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 设置账户金额
     *
     * @param amount 账户金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 获取推广费用
     *
     * @return promote_fees - 推广费用
     */
    public BigDecimal getPromoteFees() {
        return promoteFees;
    }

    /**
     * 设置推广费用
     *
     * @param promoteFees 推广费用
     */
    public void setPromoteFees(BigDecimal promoteFees) {
        this.promoteFees = promoteFees;
    }

    /**
     * 获取邀请码
     *
     * @return invite_code - 邀请码
     */
    public String getInviteCode() {
        return inviteCode;
    }

    /**
     * 设置邀请码
     *
     * @param inviteCode 邀请码
     */
    public void setInviteCode(String inviteCode) {
        this.inviteCode = inviteCode;
    }
}