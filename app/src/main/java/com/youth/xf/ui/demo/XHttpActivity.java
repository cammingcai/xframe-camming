package com.youth.xf.ui.demo;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.youth.xf.BaseActivity;
import com.youth.xf.R;
import com.youth.xf.data.Weather;
import com.youth.xframe.utils.http.HttpCallBack;
import com.youth.xframe.utils.http.XHttp;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class XHttpActivity extends BaseActivity {

    TextView text;
    private String URL_HOST = "http://192.168.11.237:8181";
//    private String URL_HOST = "http://120.78.121.247:8090";
    private String PHP_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpc3MiOiJodHRwOlwvXC8xOTIuMTY4LjExLjI0OFwvYXBpXC91c2VyXC9sb2dpbiIsImlhdCI6MTU1NDEwNjU1NCwiZXhwIjoxNTU0MTkyOTU0LCJuYmYiOjE1NTQxMDY1NTQsImp0aSI6Ijd3YThyUEVKZ1oxRE9qVFUiLCJzdWIiOjExMiwicHJ2IjoiYjkxMjc5OTc4ZjExYWE3YmM1NjcwNDg3ZmZmMDFlMjI4MjUzZmU0OCJ9.1hgBItft7WPZbBB9Cj7UhWDJkTJ2el6SAmap8XsCsjI";
    @Override
    public int getLayoutId() {
        return R.layout.activity_xhttp;
    }

    @Override
    public void initData(Bundle savedInstanceState) {

    }

    @Override
    public void initView() {
        text = (TextView) findViewById(R.id.text);
    }

    public void onClick(View view) {
        request();
    }

    public void request() {

///
//get
        Map<String,Object> params = new HashMap<>();
        params.put("token",PHP_TOKEN);
        XHttp.obtain().get(URL_HOST + "/api/order/getVipPriceList", params, new HttpCallBack<String>() {
            @Override
            public void onSuccess(String o) {
                Log.i("XHttpActivity","result onSuccess="+o.toString());
                text.setText(""+o);
            }

            @Override
            public void onFailed(String error) {
                Log.i("XHttpActivity","result error = "+error);
            }
        });

//post
//        Map<String,Object> params = new HashMap<>();
//        params.put("phone","13560048370");
//        params.put("password","123456");
//        XHttp.obtain().post(URL_HOST + "/api/user/login", params, new HttpCallBack<String>() {
//            @Override
//            public void onSuccess(String o) {
//                Log.i("XHttpActivity","result onSuccess="+o.toString());
//                text.setText(""+o);
//            }
//
//            @Override
//            public void onFailed(String error) {
//                Log.i("XHttpActivity","result error = "+error);
//            }
//        });

//        //这里是公用接口，没有办法演示传参，谅解
//        String url = "http://wthrcdn.etouch.cn/weather_mini?citykey=101010100";
//        /**
//         * 调用 网络请求 get方法
//         * @param url 请求url
//         * @param params 参数，没有可以传一个空集合 or null
//         * @param HttpCallBack<T> 回调接口，T 为你想返回的类型（String or entity）
//         */
//        XHttp.obtain().get(url, null, new HttpCallBack<Weather>() {
//            //成功返回你传入的返回类型
//            @Override
//            public void onSuccess(Weather weather) {
//                text.setText(
//                        weather.getData().getCity() + " \n温度：" +
//                        weather.getData().getWendu() + "度 \n 提示：" +
//                        weather.getData().getGanmao()
//                );
//            }
//
//            @Override
//            public void onFailed(String str) {
//                text.setText(str);
//            }
//        });



//        Map<String,Object> params = new HashMap<>();
//        params.put("search","数学");
//        params.put("pageNum","1");
//        params.put("pageSize","10");
//        XHttp.obtain().post(URL_HOST + "/api/side/searchQuestionList", null, new HttpCallBack<String>() {
//            @Override
//            public void onSuccess(String o) {
//                Log.i("XHttpActivity","result onSuccess="+o.toString());
//                text.setText(o);
//
//            }
//
//            @Override
//            public void onFailed(String error) {
//                Log.i("XHttpActivity","result error = "+error);
//            }
//        });
    }

}
