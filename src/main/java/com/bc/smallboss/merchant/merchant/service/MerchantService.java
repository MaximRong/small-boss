package com.bc.smallboss.merchant.merchant.service;

import com.bc.smallboss.merchant.merchant.bean.Merchant;
import org.n3r.eql.Eql;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {


    public void merchantSave(Merchant merchant) {
        new Eql().params(merchant).execute();
    }

    public Merchant queryMerchant() {
        return new Eql().selectFirst("queryMerchant").returnType(Merchant.class).execute();
    }
}
