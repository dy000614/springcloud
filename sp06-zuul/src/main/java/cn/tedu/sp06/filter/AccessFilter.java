package cn.tedu.sp06.filter;

import cn.tedu.web.util.JsonResult;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@Component
public class AccessFilter extends ZuulFilter {
    // 设置过滤器的类型， pre, routing, post, error
    @Override
    public String filterType() {
        // return "pre";
        return FilterConstants.PRE_TYPE;
    }
    // 设置过滤器的顺序号
    @Override
    public int filterOrder() {
        return 6;
    }
    // 针对当前请求，是否要执行下面的过滤代码
    @Override
    public boolean shouldFilter() {
        /*
        请求商品，需要判断权限；
        请求其他模块，跳过权限判断直接访问。
         */
        // 获得请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 从上下文对象获得 serviceId（正在调用的服务）
        String serviceId =
                (String) ctx.get(FilterConstants.SERVICE_ID_KEY);//("serviceId");
        // serviceId是否是 item-service
        return "item-service".equals(serviceId);
    }
    // 过滤代码
    @Override
    public Object run() throws ZuulException {
        // http://localhost:3001/item-service/y45tr3432r?token=7yu4t53r
        // 获得请求上下文
        RequestContext ctx = RequestContext.getCurrentContext();
        // 从上下文对象获得 request 对象
        HttpServletRequest request = ctx.getRequest();
        // 从 request 获得 token 参数
        String token = request.getParameter("token");
        // 如果没有 token，阻止继续调用，直接返回响应
        // null, "", "    "
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false); //阻止继续调用
            // 告诉客户端返回的数据是什么类型
            ctx.addZuulResponseHeader("Content-Type",
                    "application/json;charset=UTF-8");
            String json = JsonResult
                    .build().code(400).msg("未登录").toString();
            ctx.setResponseBody(json);
        }
        return null; //当前zuul版本中没有使用这个返回值，返回任何数据都是无效的

    }
}