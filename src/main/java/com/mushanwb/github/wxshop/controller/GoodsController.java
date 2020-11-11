package com.mushanwb.github.wxshop.controller;

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

}
