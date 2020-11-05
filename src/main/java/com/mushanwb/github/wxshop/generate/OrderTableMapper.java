package com.mushanwb.github.wxshop.generate;

import com.mushanwb.github.wxshop.generate.OrderTable;
import com.mushanwb.github.wxshop.generate.OrderTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface OrderTableMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    long countByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int deleteByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int insert(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int insertSelective(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    List<OrderTable> selectByExample(OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    OrderTable selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int updateByExampleSelective(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int updateByExample(@Param("record") OrderTable record, @Param("example") OrderTableExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int updateByPrimaryKeySelective(OrderTable record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table order_table
     *
     * @mbg.generated Thu Nov 05 11:35:45 CST 2020
     */
    int updateByPrimaryKey(OrderTable record);
}