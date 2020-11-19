package com.mushanwb.github.wxshop.controller;

import com.mushanwb.github.wxshop.entity.Response;
import com.mushanwb.github.wxshop.entity.WxShopException;
import com.mushanwb.github.wxshop.generate.Shop;
import com.mushanwb.github.wxshop.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController
@RequestMapping("/v1/api")
public class ShopController {

    private final ShopService shopService;

    @Autowired
    public ShopController(ShopService shopService) {
        this.shopService = shopService;
    }

    @PostMapping("shop")
    @ResponseBody
    public Response<Shop> createShop(@RequestBody Map<String, String> param,
                               HttpServletResponse response) {

        Shop createShop = createAndUpdateShopParam(param);
        Shop shop = shopService.createShop(createShop);
        response.setStatus(HttpStatus.CREATED.value());
        return Response.of(shop);
    }

    @PutMapping("shop/{id}")
    @ResponseBody
    public Response<Shop> updateShop(@PathVariable("id") Long shopId,
                                     @RequestBody Map<String, String> param,
                                     HttpServletResponse response) {
        Shop updateShop = createAndUpdateShopParam(param);

        try {
            updateShop.setId(shopId);
            return Response.of(shopService.updateShop(updateShop));
        } catch (WxShopException.NotAuthorizedForShopException e) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return Response.of(null, e.getMessage());
        } catch (WxShopException.ResourceNotFoundException e) {
            response.setStatus(HttpStatus.NOT_FOUND.value());
            return Response.of(null, e.getMessage());
        }
    }

    private Shop createAndUpdateShopParam(Map<String, String> param) {
        String name = param.get("name");
        String description = param.get("description");
        String imgUrl = param.get("imgUrl");
        Shop createShop = new Shop();
        createShop.setImgUrl(imgUrl);
        createShop.setDescription(description);
        createShop.setName(name);
        return createShop;
    }

}
