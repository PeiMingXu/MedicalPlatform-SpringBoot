package com.xmut.controller;

import com.github.pagehelper.PageInfo;

import com.xmut.pojo.Prescript;
import com.xmut.service.PrescriptService;
import com.xmut.utils.SMSUtil_one;
import com.xmut.utils.SMSUtil_one_time;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;


import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date: 2024/1/19
 **/
@Controller
public class PrescriptController {
     @Autowired
    private PrescriptService prescriptService;


    // 带条件分页加模糊查询
    @RequestMapping("/searchPrescript")
    public String getPages(Model model, Prescript prescript,
                           @RequestParam(value = "pageIndex",defaultValue = "1") int pageIndex,
                           @RequestParam(value = "pageSize",defaultValue = "10",required = false) int pageSize){

        PageInfo page = prescriptService.findPages(prescript,pageIndex, pageSize);
        model.addAttribute("prescript",prescript);
        model.addAttribute("path","searchPrescript?pageIndex=");
        model.addAttribute("page",page);

        return "admin/prescript";
    }



    //点击发送单条短信提示
    @PostMapping("/oneSms")
    @ResponseBody
    public Map<String, Object> oneSms(String phone , HttpServletRequest request){
        Map<String, Object> result = new HashMap<>();

        if(phone!=null && !phone.equals("")){
            String success = SMSUtil_one.sendSMS(request,phone);
            if (success!=null) {
                result.put("success", true);
                result.put("msg", "发送成功！");
                result.put("redirectUrl", "./searchPrescript");
                return result;
            } else {
                result.put("success", false);
                result.put("msg", "发送失败，请稍后再试！");
                return result;
            }

        }else{
            result.put("success", false);
            result.put("msg", "手机号错误，请稍后再试！");
            return result;
        }
    }





}
