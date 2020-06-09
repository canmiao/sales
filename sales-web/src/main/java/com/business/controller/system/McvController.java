package com.business.controller.system;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @Author: taoye
 * @Description: 页面跳转
 * @Date: 15:37 2018/8/15
 */
@Controller
public class McvController {

    @RequestMapping(value = "/security/user")
    public String userView() {
        return "settings/user";
    }

    @RequestMapping(value = "/security/news")
    public String newsView() {
        return "settings/news";
    }

    @RequestMapping(value = "/security/upload")
    public String uploadView() {
        return "settings/upload";
    }

    @RequestMapping(value = "/security/defend")
    public String defendView() {
        return "settings/defend";
    }

    @RequestMapping(value = "/warehouse/search")
    public String warehouseView() {
        return "warehouse/search";
    }

    @RequestMapping(value = "/sales/history")
    public String historyView() {
        return "sales/history";
    }


    @RequestMapping(value = "/purchase/history")
    public String purchaseHistoryView() {
        return "purchase/history";
    }


    @RequestMapping(value = "/saler/sale")
    public String saleView() {
        return "salesperson/sale";
    }

    @RequestMapping(value = "/saler/back")
    public String backView() {
        return "salesperson/back";
    }


    @RequestMapping(value = "/research/sale")
    public String researchView() {
        return "salesperson/search";
    }
    
    // 销售管理
    @RequestMapping(value = "/check/manager/no", method = RequestMethod.GET)
    public String checkNO(){
        return "manager/no";
    }

    @RequestMapping(value = "/check/manager/yes", method = RequestMethod.GET)
    public String checkYes(){
        return "manager/yes";
    }

    @RequestMapping(value = "/search/manager/sale", method = RequestMethod.GET)
    public String checkSearch(){
        return "manager/search";
    }
    
    // 出库
    @RequestMapping(value = "/output/regist",method = RequestMethod.GET)
    public String outputRegister(){
        return "/output/register";
    }
    @RequestMapping(value = "/output2/search/history",method = RequestMethod.GET)
    public String outputHistory(){
        return "/output/history";
    }
    @RequestMapping(value = "/output/input/regist",method = RequestMethod.GET)
    public String inputRegister(){
        return "/output/input";
    }
    // 质检员
    @RequestMapping(value = "/inspector/register")
    public String inspectorRegister(){
        return "inspector/register";
    }

    @RequestMapping(value = "/inspectorcheck/regist")
    public String inspector(){
        return "inspector/check";
    }

    //采购
    @RequestMapping(value = "/purchase/register")
    public String purchaseRegister(){
        return "purchase/register";
    }

    @RequestMapping(value = "/purchase/back")
    public String purchaseBack(){
        return "purchase/back";
    }

    @RequestMapping(value = "/purchase/search/history")
    public String purchaseHistory(){
        return "purchase/history1";
    }

    //采购主管
    @RequestMapping(value = "/purchase/manager/list")
    public String purchaseList(){
        return "purchase/list";
    }

    @RequestMapping(value = "/purchase/manager/search/history")
    public String purchaseSearchHistory(){
        return "purchase/search";
    }



}
