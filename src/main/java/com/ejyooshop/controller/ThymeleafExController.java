package com.ejyooshop.controller;

import com.ejyooshop.dto.ItemDto;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;

@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafExController {

    @RequestMapping("/")
    public String test(Model model) {
        return "index";
    }

    @GetMapping("/loadPage")
    public String thymeleafTest(Model model) {
        model.addAttribute("data", "Hello World");
        return "thymeleafTestPage/outBasicText";
    }

    @GetMapping("/loadDemoItemData")
    public String thymeleafLoadDemoItemData(Model model) {
        ItemDto itemDto = new ItemDto();
        itemDto.setItemDetail("상품 상세 설명");
        itemDto.setItemNm("테스트 상품1");
        itemDto.setPrice(10000);
        itemDto.setRegTime(LocalDateTime.now());

        model.addAttribute("itemDto", itemDto);
        return "thymeleafTestPage/loadDemoItemData";
    }

    @GetMapping("/useLayoutTemplate")
    public String thymeleafUseLayout() {
        return "thymeleafTestPage/useLayoutTemplate";
    }
}
