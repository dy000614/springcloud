package cn.tedu.sp01.service;
import cn.tedu.sp01.pojo.User;
public interface UserService {
    //用户在查询订单时，获取用户的信息
    User getUser(Integer userId);

    //用户在创建订单时，增加用户的积分
    void addScore(Integer userId, Integer score);
}
