package com.leoric.code.design.pattern.chain;

import com.sun.org.apache.regexp.internal.RE;

/**
 * Created by wecash on 18/7/20.
 */
public class Test {

    public static void main(String[] args) {
        //设定过滤规则，对msg字符串进行过滤处理
        String msg = ":):,<script>,敏感,被就业,网络授课";
        //过滤请求
        Request request = Request.builder().requestStr(msg).build();
        //set方法，将待处理字符串传递进去
        //处理过程结束，给出的响应
        Response response = Response.builder().responseStr("response:").build();
        //FilterChain,过滤规则形成的拦截链条
        FilterChain fc = new FilterChain();
        //规则链条添加过滤规则，采用的是链式调用
        fc.addFilter(new HTMLFilter())
                .addFilter(new SensitiveFilter())
                .addFilter(new FaceFilter());
        //按照FilterChain的规则顺序，依次应用过滤规则
        fc.doFilter(request, response, fc);
        //打印请求信息
        System.out.println(request.getRequestStr());
        //打印响应信息
        System.out.println(response.getResponseStr());
                 /*
          * 处理器对数据进行处理
          * --|----|---数据--|-----|---
          * 规则1      规则2                 规则3       规则4
          */
    }
}