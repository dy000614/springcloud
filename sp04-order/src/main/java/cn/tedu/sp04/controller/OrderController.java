package cn.tedu.sp04.controller;
import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.pojo.Order;
import cn.tedu.sp01.pojo.User;
import cn.tedu.sp01.service.OrderService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
    @Autowired
    private OrderService orderService;
    @GetMapping("/{orderId}")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        Order order = orderService.getOrder(orderId);
        return JsonResult.build().code(200).data(order);
    }
    @GetMapping("/create")
    public JsonResult<?> create() {
        User user = new User(8, null, null); // 已登录的用户
        List<Item> items = new ArrayList<>();// 从购物车获取
        items.add(new Item(1,"商品1",1));
        items.add(new Item(2,"商品2",3));
        items.add(new Item(3,"商品3",2));
        Order order = new Order("yt34r2t", user, items);
        orderService.create(order);
        return JsonResult.build().code(200).msg("创建订单成功");
    }

    @GetMapping("/favicon.ico")
    public void ico() {
    }
}
