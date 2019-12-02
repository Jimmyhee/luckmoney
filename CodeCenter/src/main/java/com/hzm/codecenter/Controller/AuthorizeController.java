package com.hzm.codecenter.Controller;

import com.hzm.codecenter.Provider.GithubProvider;
import com.hzm.codecenter.dto.AccessTokenDTO;
import com.hzm.codecenter.dto.GithubUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code")String code,
                           @RequestParam(name = "state") String state){
        AccessTokenDTO accessTokenDTO = new AccessTokenDTO();
        accessTokenDTO.setClient_id("4dcf0b43b9eac98dd53c");
        accessTokenDTO.setClient_secert("6e62f72bf631a06ba76ef25ce20aaa79f206a57c");
        accessTokenDTO.setCode(code);
        accessTokenDTO.setRedirect_url("http://localhost:8081/callback");
        accessTokenDTO.setState(state);
        githubProvider.getAccessToken(accessTokenDTO);
        githubProvider.getGithubUser(githubProvider.getAccessToken(accessTokenDTO));
        return "index";
    }


}
