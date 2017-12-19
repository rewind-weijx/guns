package com.weilai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.tips.SuccessTip;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.weilai.model.Renovation;
import com.weilai.model.RenovationDetail;
import com.weilai.service.IRenovationService;
import com.weilai.util.Constant;

/**
 * 装修控制器
 *
 * @author fengshuonan
 * @Date 2017-12-10 01:33:38
 */
@Controller
@RequestMapping("/renovation")
public class RenovationController extends BaseController {

    private String PREFIX = "/weilai/renovation/";

    @Autowired
    private IRenovationService renovationService;

    /**
     * 跳转到装修首页
     */
    @RequestMapping(value={"/{type}"})
    public String index(@PathVariable String type,ModelMap modelMap) {
    	modelMap.put("type", type);
    	modelMap.put("typeName", Constant.getRenovationNameByValue(type));
        return PREFIX + "renovation.html";
    }

    /**
     * 跳转到添加装修
     */
    @RequestMapping("/renovation_add/{type}")
    public String renovationAdd(@PathVariable String type,ModelMap modelMap) {
    	modelMap.put("type", type);
        return PREFIX + "renovation_add.html";
    }

    /**
     * 跳转到修改装修
     */
    @RequestMapping("/renovation_update/{renovationId}")
    public String renovationUpdate(@PathVariable String renovationId, Model model) {
        Renovation renovation = renovationService.selectById(renovationId);
        model.addAttribute("item",renovation);
        LogObjectHolder.me().set(renovation);
        return PREFIX + "renovation_edit.html";
    }
    /**
     * 跳转到详情
     */
    @RequestMapping("/renovation_detail/{renovationId}")
    public String renovationDetail(@PathVariable String renovationId, Model model) {
        Renovation renovation = renovationService.selectById(renovationId);
        model.addAttribute("item",renovation);
        List<RenovationDetail> list = renovationService.selectDetailList(renovation.getId());
        model.addAttribute("list", list);
        LogObjectHolder.me().set(renovation);
        return PREFIX + "renovation_detail.html";
    }
    @RequestMapping("/renovation_goUpdate/{renovationId}")
    public String renovationGoUpdate(@PathVariable String renovationId, Model model) {
        Renovation renovation = renovationService.selectById(renovationId);
        model.addAttribute("item",renovation);
        List<RenovationDetail> list = renovationService.selectDetailList(renovation.getId());
        model.addAttribute("list", list);
        LogObjectHolder.me().set(renovation);
        return PREFIX + "renovation_update.html";
    }
    /**
     * 获取装修列表
     */
    @RequestMapping(value = "/list/{type}")
    @ResponseBody
    public Object list(Renovation renovation,@PathVariable String type) {
    	renovation.setType(type);
        return renovationService.selectList(renovation);
    }

    /**
     * 新增装修
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Object add(Renovation renovation) {
        renovationService.insert(renovation);
        SuccessTip tip = super.SUCCESS_TIP;
        tip.setData(renovation.getId());
        return tip;
    }
    @RequestMapping(value = "/addDetail")
    @ResponseBody
    public Object addDetail(RenovationDetail renovationDetail) {
        renovationService.insertDetail(renovationDetail);
        return super.SUCCESS_TIP;
    }
    @RequestMapping(value = "/deleteDetail")
    @ResponseBody
    public Object deleteDetail(String renovationId) {
        renovationService.deleteDetail(renovationId);
        return super.SUCCESS_TIP;
    }
    /**
     * 删除装修
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String renovationId) {
        renovationService.deleteById(renovationId);
        return SUCCESS_TIP;
    }

    /**
     * 修改装修
     */
    @RequestMapping(value = "/update")
    @ResponseBody
    public Object update(Renovation renovation) {
        renovationService.updateById(renovation);
        SuccessTip tip = super.SUCCESS_TIP;
        tip.setData(renovation.getId());
        return tip;
    }

    /**
     * 装修详情
     */
    @RequestMapping(value = "/detail/{renovationId}")
    @ResponseBody
    public Object detail(@PathVariable("renovationId") Integer renovationId) {
        return renovationService.selectById(renovationId);
    }
}
