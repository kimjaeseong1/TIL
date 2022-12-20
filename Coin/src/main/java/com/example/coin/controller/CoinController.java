package com.example.coin.controller;

import com.example.coin.service.CoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;

@Controller
public class CoinController {

    @Autowired
    CoinService cs;

    @PostMapping("/signup")
    public String insertCoin(@RequestParam HashMap<String ,String> param){

        cs.insertCoin(param);

        return "index";
    }

    @PostMapping("/login")
    public String selectCoin(@RequestParam HashMap<String,String> param, HttpSession session){
        System.out.println(param);
        for(HashMap<String,String> member : cs.selectCoin()){
            System.out.println(member);
            if(member.get("email").equals(param.get("email")) && member.get("password").equals(param.get("password"))){
                session.setAttribute("email",member.get("email"));
                System.out.println(member.get("email"));

                return "index";
            }
        }
        return "login";
    }


    @GetMapping("/point")
    public String insertPay(@RequestParam HashMap<String,String> param, HttpSession session){

        System.out.println(session.getAttribute("email"));
        System.out.println(param.get("amount"));
        System.out.println(param.get("uid"));

        param.put("email",String.valueOf(session.getAttribute("email")));

        cs.insertPay(param);

        System.out.println(session.getAttribute("email"));
        System.out.println(param.get("amount"));
        System.out.println(param.get("uid"));

        return "pay";

    }



    @GetMapping("/pointList")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectPay(HttpSession session){

        ArrayList<HashMap<String,Object>> his = new ArrayList<HashMap<String,Object>>();

       for(HashMap<String, Object> paylist: cs.selectPay()){

           if(paylist.get("email").equals(session.getAttribute("email"))){
               System.out.println("paylist.get(\"amount\") = " + paylist.get("amount"));
               System.out.println("paylist.get(\"indate\") = " + paylist.get("indate"));

               his.add(paylist);

           }
       }
        return his;
    }

    @PostMapping("/buyCoin")
    public @ResponseBody String insertBuy(@RequestParam HashMap<String,String> param ,HttpSession session){

    if(session.getAttribute("email") != null){
        param.put("email",String.valueOf(session.getAttribute("email")));
        cs.insertBuy(param);

        return "history";
    }

    return "market";

    }




    @GetMapping("/checkBalance")
    public @ResponseBody String selectCheck(HttpSession session,@RequestParam double total){

        System.out.println(cs.selectCheck("email"));

        if(session.getAttribute("email") != null){



            int tmoney =0;

            ArrayList<HashMap<String,String>> amount =  cs.selectCheck(String.valueOf(session.getAttribute("email")));
            System.out.println(amount);
            System.out.println(cs.selectCheck("amount"));
                for(HashMap<String,String> money : amount){
                    System.out.println("for문 안");
                    System.out.println(money.get(amount));
                    tmoney += Integer.parseInt(String.valueOf(money.get("amount")));
                }
            System.out.println(tmoney);


            if((tmoney -total) >0){
                return "can";
            }else{
                return "cannot";
            }



       }

       return "login";

    }


    @PostMapping("requestCall")
    public String insertContact(@RequestParam HashMap<String, String> contact, HttpSession session){


        if(session.getAttribute("email") != null){
            cs.selectCheck(String.valueOf(session.getAttribute("email")));

            cs.insertContact(contact);
            System.out.println("연락하기 성공");

            return "index";
        }

        return "연락 실패";
    }

    @GetMapping("/buyList")
    public @ResponseBody ArrayList<HashMap<String,Object>> selectDeal(HttpSession session){

        ArrayList<HashMap<String,Object>> buy = null;

        if(session.getAttribute("email") != null){
            buy = cs.selectDeal(String.valueOf(session.getAttribute("email")));

        }

        return buy;
    }


    @GetMapping("/hadBalance")
    @ResponseBody
    public double OldMoney( HttpSession session){

        double om = 0;

        if(session.getAttribute("email") != null){
            om = cs.OldMoney(String.valueOf(session.getAttribute("email")));

        }
        return om;
    }


    @GetMapping("/havingBalance")
    @ResponseBody
    public ArrayList<HashMap<String, Object>> NowMoney(String email, HttpSession session){

        ArrayList<HashMap<String, Object>> nm =null;

        if(session.getAttribute("email") != null){

            nm = cs.selectDeal(String.valueOf(session.getAttribute("email")));



        }
        return nm;
    }


    @GetMapping("subscribe")

    public int Subscribe(String email){
        return cs.Subscribe(email);
    }

    @PostMapping("subscribe")

    public String PSubscribe(String email){
         cs.Subscribe(email);

         return "redirect:index";
    }

}
