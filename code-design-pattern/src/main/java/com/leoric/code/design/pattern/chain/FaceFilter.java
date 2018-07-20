package com.leoric.code.design.pattern.chain;

/**
 * Created by wecash on 18/7/20.
 */
public class FaceFilter implements Filter {

    public void doFilter(Request request, Response response, FilterChain chain) {
        //将字符串中出现的":):"转换成"^V^";
        request.requestStr = request.requestStr.replace(":):", "^V^")
                //后面添加的是便于我们观察代码执行步骤的字符串
                + "----FaceFilter()";
        chain.doFilter(request, response, chain);
        response.responseStr += "---FaceFilter()";
    }

}
