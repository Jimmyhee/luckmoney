package com.hzm.codecenter.Provider;

import com.alibaba.fastjson.JSON;
import com.hzm.codecenter.dto.AccessTokenDTO;
import com.hzm.codecenter.dto.GithubUser;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.IOException;

/**
 * @program: luckmoney
 * @author: Jimmy.He
 * @create: 2019-11-25 15:05
 **/
@Component
public class GithubProvider {
    /**
     * 获取access_token
     * @param accessTokenDTO
     * @return
     */
    public String getAccessToken(@RequestBody AccessTokenDTO accessTokenDTO){
        MediaType mediaType = MediaType.get("application/json; charset=utf-8");
        OkHttpClient okclient = new OkHttpClient();
        okhttp3.RequestBody body = okhttp3.RequestBody.create(mediaType,JSON.toJSONString(accessTokenDTO));
        Request request = new Request.Builder()
                .url("https://github.com/login/oauth/access_token")
                .post(body)
                .build();
        try(Response response = okclient.newCall(request).execute()){
            String string =  response.body().string();
            System.out.print(string);
            return string;
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 根据accessToken获取githubuser
     * @param accessToken
     * @return
     */
    public GithubUser getGithubUser(String accessToken){
        OkHttpClient okclient = new OkHttpClient();
        Request request = new Request.Builder()
                .url("https://api.github.com/user?access_token"+accessToken)
                .build();
    try {
        Response response = okclient.newCall(request).execute();
        String s1 = response.body().string();
        GithubUser githubUser = JSON.parseObject(s1,GithubUser.class);
        return githubUser;
    }catch (IOException e){
        e.printStackTrace();
    }
        return null;
    }
}
