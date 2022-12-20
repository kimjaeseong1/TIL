package com.example.coin.service;

import com.example.coin.repository.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Service
public class CoinService {

    @Autowired
    CoinRepository cr;


    public int insertCoin(HashMap<String ,String> param){

        return cr.insertCoin(param);

    }

    public ArrayList<HashMap<String,String>> selectCoin(){
        return cr.selectCoin();
    }

    public int insertPay(HashMap<String,String> param){
        return cr.insertPay(param);
    }

    public ArrayList<HashMap<String, Object>> selectPay(){
        return cr.selectPay();
    }

    public int insertBuy(HashMap<String,String> param){
        return cr.insertBuy(param);
    }

    public ArrayList<HashMap<String,String>> selectCheck(String email){
        return cr.selectCheck(email);
    }

    public int insertContact(HashMap<String, String> contact){
        return cr.insertContact(contact);
    }

    public ArrayList<HashMap<String,Object>> selectDeal(String email){
        return cr.selectDeal(email);
    }

    public double OldMoney(String email){
        return cr.OldMoney(email);
    }

    public int Subscribe(String email){
        return cr.Subscribe(email);
    }

}
