package com.example.coin.mapper;

import org.apache.ibatis.annotations.Mapper;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

@Mapper
public interface CoinMapper {


    public int insertCoin(HashMap<String ,String> param);

    public ArrayList<HashMap<String,String>> selectCoin();

    public int insertPay(HashMap<String,String> param);

    public ArrayList<HashMap<String, Object>> selectPay();

    public int insertBuy(HashMap<String,String> param);

    public ArrayList<HashMap<String,String>> selectCheck(String email);

    public int insertContact(HashMap<String, String> contact);

    public ArrayList<HashMap<String,Object>> selectDeal(String email);

    public double OldMoney(String email);

    public int Subscribe(String email);





}
