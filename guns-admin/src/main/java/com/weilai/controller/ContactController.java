package com.weilai.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.stylefeng.guns.core.base.controller.BaseController;
import com.stylefeng.guns.core.base.warpper.BaseWarpper;
import com.stylefeng.guns.core.log.LogObjectHolder;
import com.weilai.model.Contact;
import com.weilai.service.IContactService;
import com.weilai.warpper.ContactWarpper;

/**
 * 装修控制器
 *
 * @author fengshuonan
 * @Date 2017-12-10 01:33:38
 */
@Controller
@RequestMapping("/contact")
public class ContactController extends BaseController {

    private String PREFIX = "/weilai/concat/";

    @Autowired
    private IContactService concatService;

    /**
     * 跳转到装修首页
     */
    @RequestMapping(value={""})
    public String index() {
        return PREFIX + "concat.html";
    }
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list() {
    	List<Contact> list = concatService.selectList(new Contact());
    	return new ContactWarpper(list).warp();
    }
    /**
     * 跳转到详情
     */
    @RequestMapping("/detail/{id}")
    public String renovationDetail(@PathVariable String id, Model model) {
        Contact renovation = concatService.selectById(id);
        model.addAttribute("item",renovation);
        LogObjectHolder.me().set(renovation);
        return PREFIX + "detail.html";
    }
    /**
     * 删除装修
     */
    @RequestMapping(value = "/delete")
    @ResponseBody
    public Object delete(@RequestParam String id) {
    	concatService.deleteById(id);
        return SUCCESS_TIP;
    }
    /**
     * 删除装修
     */
    @RequestMapping(value = "/read")
    @ResponseBody
    public Object read(@RequestParam String id) {
    	concatService.read(id);
        return SUCCESS_TIP;
    }
}
