package cn.chouyv.controller;

import cn.chouyv.service.MoneyService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author SurKaa
 */
@RestController
@RequestMapping("/money")
public class MoneyController {
    
    private final MoneyService moneyService;

    public MoneyController(MoneyService moneyService) {
        this.moneyService = moneyService;
    }


}
