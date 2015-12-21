package com.bc.smallboss.merchant.merchant.controller;

import com.bc.smallboss.base.utils.RMap;
import com.bc.smallboss.merchant.merchant.bean.Merchant;
import com.bc.smallboss.merchant.merchant.service.MerchantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping("/merchant/merchant")
public class MerchantController {

    @Autowired
    private MerchantService service;

    @RequestMapping(value = "/edit")
    public ModelAndView merchantEdit() {
        ModelAndView mav = new ModelAndView();
        Merchant merchant = service.queryMerchant();
        mav.addObject("merchant", merchant);

        mav.setViewName("merchant/merchant-edit");
        return mav;
    }

    @RequestMapping(value = "/save")
    public @ResponseBody
    Map merchantSave(@RequestBody Merchant merchant) {
        service.merchantSave(merchant);
        return RMap.of("result", "ok");
    }



}
