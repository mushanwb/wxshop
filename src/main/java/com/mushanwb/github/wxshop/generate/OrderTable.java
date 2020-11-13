package com.mushanwb.github.wxshop.generate;

import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import java.util.Date;

@SuppressFBWarnings(value = {"EI_EXPOSE_REP", "EI_EXPOSE_REP2"})
public class OrderTable {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.user_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Long userId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.total_price
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Long totalPrice;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String address;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.express_company
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String expressCompany;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.express_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String expressId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.status
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private String status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Date createdAt;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column order_table.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    private Date updatedAt;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.id
     *
     * @return the value of order_table.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.id
     *
     * @param id the value for order_table.id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.user_id
     *
     * @return the value of order_table.user_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.user_id
     *
     * @param userId the value for order_table.user_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.total_price
     *
     * @return the value of order_table.total_price
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Long getTotalPrice() {
        return totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.total_price
     *
     * @param totalPrice the value for order_table.total_price
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setTotalPrice(Long totalPrice) {
        this.totalPrice = totalPrice;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.address
     *
     * @return the value of order_table.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getAddress() {
        return address;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.address
     *
     * @param address the value for order_table.address
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.express_company
     *
     * @return the value of order_table.express_company
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getExpressCompany() {
        return expressCompany;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.express_company
     *
     * @param expressCompany the value for order_table.express_company
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setExpressCompany(String expressCompany) {
        this.expressCompany = expressCompany == null ? null : expressCompany.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.express_id
     *
     * @return the value of order_table.express_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getExpressId() {
        return expressId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.express_id
     *
     * @param expressId the value for order_table.express_id
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setExpressId(String expressId) {
        this.expressId = expressId == null ? null : expressId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.status
     *
     * @return the value of order_table.status
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.status
     *
     * @param status the value for order_table.status
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.created_at
     *
     * @return the value of order_table.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.created_at
     *
     * @param createdAt the value for order_table.created_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column order_table.updated_at
     *
     * @return the value of order_table.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column order_table.updated_at
     *
     * @param updatedAt the value for order_table.updated_at
     *
     * @mbg.generated Fri Nov 13 14:56:58 CST 2020
     */
    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }
}