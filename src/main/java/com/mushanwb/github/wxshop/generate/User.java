package com.mushanwb.github.wxshop.generate;

import java.util.Date;

public class User {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.name
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.tel
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String tel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.avatar_url
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String avatarUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.id
     *
     * @return the value of user.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.id
     *
     * @param id the value for user.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.name
     *
     * @return the value of user.name
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.name
     *
     * @param name the value for user.name
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.tel
     *
     * @return the value of user.tel
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getTel() {
        return tel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.tel
     *
     * @param tel the value for user.tel
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.avatar_url
     *
     * @return the value of user.avatar_url
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getAvatarUrl() {
        return avatarUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.avatar_url
     *
     * @param avatarUrl the value for user.avatar_url
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl == null ? null : avatarUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.address
     *
     * @return the value of user.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.address
     *
     * @param address the value for user.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.created_at
     *
     * @return the value of user.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.created_at
     *
     * @param createdAt the value for user.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user.updated_at
     *
     * @return the value of user.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user.updated_at
     *
     * @param updatedAt the value for user.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}