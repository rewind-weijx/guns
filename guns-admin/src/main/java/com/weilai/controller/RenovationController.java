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
    @RequestMapping(value={"/{renovation}"})
    public String index(@PathVariable String renovation,ModelMap modelMap) {
    	modelMap.put("type", getTypeByLocation(renovation));
    	modelMap.put("location", renovation);
        return PREFIX + "renovation.html";
    }

    private String getTypeByLocation(String renovation){
    	if("designstyle".equals(renovation)){
    		return "1";
    	}if("smarthome".equals(renovation)){
    		return "2";
    	}if("customwoodendoor".equals(renovation)){
    		return "3";
    	}
    	return "1";
    }
    
    /**
     * 跳转到添加装修
     */
    @RequestMapping("/renovation_add/{renovation}")
    public String renovationAdd(@PathVariable String renovation,ModelMap modelMap) {
    	modelMap.put("type", getTypeByLocation(renovation));
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
    /**
     * 获取装修列表
     */
    @RequestMapping(value = "/list/{location}")
    @ResponseBody
    public Object list(Renovation renovation,@PathVariable String location) {
    	renovation.setType(getTypeByLocation(location));
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
        return super.SUCCESS_TIP;
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
