package cn.tedu.sp02.service;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {
    @Override
    public List<Item> getItems(String orderId) {
        log.info("获取订单商品列表，orderId="+orderId);
        List<Item> list = new ArrayList<>();
        list.add(new Item(1, "商品1", 1));
        list.add(new Item(2, "商品2", 4));
        list.add(new Item(3, "商品3", 1));
        list.add(new Item(4, "商品4", 6));
        list.add(new Item(5, "商品5", 3));
        return list;
    }

    @Override
    public void decreaseNumber(List<Item> items) {
        for (Item item : items) {
            log.info("减少库存： "+item);
        }
    }
}
