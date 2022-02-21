package cn.tedu.sp01.pojo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private User user;  //所属的用户
    private List<Item> items;   //订单中的商品列表
}
