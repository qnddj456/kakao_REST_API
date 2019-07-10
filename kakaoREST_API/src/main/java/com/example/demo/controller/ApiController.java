package com.example.demo.controller;

import com.example.demo.Token.KakaoAccessToken;
import com.fasterxml.jackson.databind.JsonNode;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
public class ApiController {

    @GetMapping("/oauth")
    public String oauth(@RequestParam("code") String code, RedirectAttributes ra, HttpSession session,
                      HttpServletResponse response) throws IOException {
        System.out.println("code : " + code);

        JsonNode jsonNode = KakaoAccessToken.getKakaoAccessToken(code);

        System.out.println("JSON 반환 : " + jsonNode.get("access_token"));

        String returnCode = "token : " + jsonNode.get("access_token");

        return returnCode;
    }
}
