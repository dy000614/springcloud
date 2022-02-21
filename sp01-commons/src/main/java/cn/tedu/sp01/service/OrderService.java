package cn.tedu.sp01.service;
import cn.tedu.sp01.pojo.Order;
public interface OrderService {
    //查询订单
    Order getOrder(String orderId);

    //创建订单
    void create(Order order);
}
