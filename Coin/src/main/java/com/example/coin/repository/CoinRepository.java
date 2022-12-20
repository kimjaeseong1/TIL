package com.example.coin.repository;

import com.example.coin.mapper.CoinMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Repository
public class CoinRepository {

    @Autowired
    CoinMapper mapper;

    public int insertCoin(HashMap<String ,String> param){
        return mapper.insertCoin(param);
    }

    public ArrayList<HashMap<String,String>> selectCoin(){
        return mapper.selectCoin();
    }

    public int insertPay(HashMap<String,String> param){
        return mapper.insertPay(param);
    }

    public ArrayList<HashMap<String, Object>> selectPay(){
        return mapper.selectPay();
    }

    public int insertBuy(HashMap<String,String> param){
        return mapper.insertBuy(param);
    }

    public ArrayList<HashMap<String,String>> selectCheck(String email){
        return mapper.selectCheck(email);
    }

    public int insertContact(HashMap<String, String> contact){
        return mapper.insertContact(contact);
    }

    public ArrayList<HashMap<String,Object>> selectDeal(String email){
        return mapper.selectDeal( email);
    }

    public double OldMoney(String email){
        return mapper.OldMoney(email);
    }

    public int Subscribe(String email){
        return mapper.Subscribe(email);
    }

}
