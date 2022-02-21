package cn.tedu.sp01.service;
import cn.tedu.sp01.pojo.Item;

import java.util.List;
public interface ItemService {
    //用户查询订单时，在这里获取订单的商品列表
    List<Item> getItems(String orderId);

    //用户创建订单时，在这里减少商品库存
    void decreaseNumber(List<Item> items);
}
