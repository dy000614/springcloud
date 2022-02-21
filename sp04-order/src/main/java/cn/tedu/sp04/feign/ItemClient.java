package cn.tedu.sp04.feign;

import cn.tedu.sp01.pojo.Item;
import cn.tedu.web.util.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/*
配置：
1. 调用哪个服务
2. 调用哪个路径
3. 提交什么参数
 */
//   item-service ----------- localhost:8001, localhost:8002
@FeignClient("item-service")
public interface ItemClient {
    @GetMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable("orderId") String orderId);

    @PostMapping("/decreaseNumber")
    JsonResult<?> decreaseNumber(@RequestBody List<Item> items);
}
