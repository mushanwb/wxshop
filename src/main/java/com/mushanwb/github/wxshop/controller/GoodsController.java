package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.dao.GoodsDao;
import com.mushanwb.github.wxshop.entity.PageResponse;
import com.mushanwb.github.wxshop.entity.Response;
import com.mushanwb.github.wxshop.generate.Goods;
import com.mushanwb.github.wxshop.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@RequestMapping("/v1/api")
public class GoodsController {

    private final GoodsService goodsService;

    @Autowired
    public GoodsController(GoodsService goodsService) {
        this.goodsService = goodsService;
    }

    @PostMapping("goods")
    @ResponseBody
    public Response<Goods> createdGoods(@RequestBody Goods goods,
                                 HttpServletResponse response) {
        // 设置返回的 http 状态码为 201
        response.setStatus(HttpStatus.CREATED.value());

        try {
            return Response.of(goodsService.createGoods(goods));
        } catch (GoodsService.NotAuthorizedForShopException e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return Response.of(null, e.getMessage());
        }
    }

    @DeleteMapping("/goods/{id}")
    @ResponseBody
    public Response<Goods> deleteGoods(@PathVariable("id") Long goodsId, HttpServletResponse response) {
        try {
            response.setStatus(HttpStatus.NO_CONTENT.value());
            return Response.of(goodsService.deleteGoodsById(goodsId));
        } catch (GoodsService.NotAuthorizedForShopException e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return Response.of(null, e.getMessage());
        } catch (GoodsDao.ResourceNotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Response.of(null, e.getMessage());
        }
    }

    @GetMapping("/goods")
    @ResponseBody
    public PageResponse<Goods> getGoods(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam(value = "shopId", required = false) Integer shopId) {

        return goodsService.getGoods(pageNum, pageSize, shopId);
    }

    @PutMapping("/goods/{id}")
    @ResponseBody
    public Response<Goods> updateGoods(Goods goods, HttpServletResponse response) {
        try {
            return Response.of(goodsService.updateGoods(goods));
        } catch (GoodsService.NotAuthorizedForShopException e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return Response.of(null, e.getMessage());
        } catch (GoodsDao.ResourceNotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Response.of(null, e.getMessage());
        }
    }

}
