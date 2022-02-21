package cn.tedu.sp02.controller;
import cn.tedu.sp01.pojo.Item;
import cn.tedu.sp01.service.ItemService;
import cn.tedu.web.util.JsonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@Slf4j
public class ItemController {
    @Autowired
    private ItemService itemService;
    @GetMapping("/{orderId}")
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) throws InterruptedException {
        List<Item> items = itemService.getItems(orderId);

        // 随机延迟代码
        if (Math.random() < 0.9) { //90%概率执行延迟代码
            // 随机延迟时长
            int t = new Random().nextInt(5000); // 0 到 5秒
            log.info("延迟： "+t);
            Thread.sleep(t);
        }

        return JsonResult.build().code(200).data(items);
    }

    // @RequestBody 完整的接收 post 请求协议体数据
    @PostMapping("/decreaseNumber")
    public JsonResult<?> decreaseNumber(@RequestBody List<Item> items) {
        itemService.decreaseNumber(items);
        return JsonResult.build().code(200).msg("减少库存成功");
    }

    @GetMapping("/favicon.ico")
    public void ico() {
    }
}











