package com.mushanwb.github.wxshop.generate;

import java.util.Date;

public class Goods {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.shop_id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Long shopId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.name
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.description
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private String description;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.details
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private String details;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.img_url
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private String imgUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.price
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Long price;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.stock
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Integer stock;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.status
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.created_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column goods.updated_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.id
     *
     * @return the value of goods.id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.id
     *
     * @param id the value for goods.id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.shop_id
     *
     * @return the value of goods.shop_id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Long getShopId() {
        return shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.shop_id
     *
     * @param shopId the value for goods.shop_id
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setShopId(Long shopId) {
        this.shopId = shopId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.name
     *
     * @return the value of goods.name
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.name
     *
     * @param name the value for goods.name
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.description
     *
     * @return the value of goods.description
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public String getDescription() {
        return description;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.description
     *
     * @param description the value for goods.description
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.details
     *
     * @return the value of goods.details
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public String getDetails() {
        return details;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.details
     *
     * @param details the value for goods.details
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setDetails(String details) {
        this.details = details == null ? null : details.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.img_url
     *
     * @return the value of goods.img_url
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.img_url
     *
     * @param imgUrl the value for goods.img_url
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.price
     *
     * @return the value of goods.price
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Long getPrice() {
        return price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.price
     *
     * @param price the value for goods.price
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setPrice(Long price) {
        this.price = price;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.stock
     *
     * @return the value of goods.stock
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Integer getStock() {
        return stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.stock
     *
     * @param stock the value for goods.stock
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setStock(Integer stock) {
        this.stock = stock;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.status
     *
     * @return the value of goods.status
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.status
     *
     * @param status the value for goods.status
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.created_at
     *
     * @return the value of goods.created_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.created_at
     *
     * @param createdAt the value for goods.created_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column goods.updated_at
     *
     * @return the value of goods.updated_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column goods.updated_at
     *
     * @param updatedAt the value for goods.updated_at
     *
     * @mbg.generated Wed Nov 18 14:44:18 CST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}