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
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author
 * @date: 2023/5/19
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
        model.addAttribute("drugs",prescript);
        model.addAttribute("path","searchPrescript?pageIndex=");
        model.addAttribute("page",page);
        return "admin/Prescript";
    }

    // //获取全部药方
    // @RequestMapping("/searchPrescript")
    // public ModelAndView findByAll(Prescript prescript, Integer pageNum, Integer pageSize, HttpServletRequest request){
    //     ModelAndView modelAndView=new ModelAndView();
    //     //设置分页的默认值
    //     if (pageNum==null){
    //         pageNum=1;//默认为一页
    //     }
    //     if (pageSize==null){
    //         pageSize=10;//默认一页10条数据
    //     }
    //     //调用service
    //     PageResult pageResult = prescriptService.findByAll(prescript,pageNum, pageSize);
    //
    //
    //     //页面
    //     modelAndView.setViewName("/admin/prescript_borrowed");
    //     //数据
    //     //搜索信息框回显
    //     modelAndView.addObject("searchPrescript",prescript);
    //     //分页数据信息
    //     modelAndView.addObject("pageResult",pageResult);
    //     //当前页码
    //     modelAndView.addObject("pageNum",pageNum);
    //     //分页请求再次请求的地址
    //     modelAndView.addObject("gourl",request.getRequestURI());
    //     return modelAndView;
    // }

    //点击发送单条短信提示
    // @PostMapping("/oneSms")
    // @ResponseBody
    // public Map<String, Object> oneSms(String phone , HttpServletRequest request){
    //     Map<String, Object> result = new HashMap<>();
    //     if(phone!=null && !phone.equals("")){
    //         String success = SMSUtil_one.sendSMS(request,phone);
    //         if (success!=null) {
    //             result.put("success", true);
    //             result.put("msg", "发送成功！");
    //             result.put("redirectUrl", "./searchPrescript");
    //             return result;
    //         } else {
    //             result.put("success", false);
    //             result.put("msg", "发送失败，请稍后再试！");
    //             return result;
    //         }
    //
    //     }else{
    //         result.put("success", false);
    //         result.put("msg", "手机号错误，请稍后再试！");
    //         return result;
    //     }
    // }
    //
    // //点击发送多条短信提示,定时
    // @PostMapping("/determinate_oneSms")
    // @ResponseBody
    // public Map<String,Object> determinate_oneSms(
    //                                 @RequestParam("phone") String [] phones,
    //                                 HttpServletRequest request){
    //     Map<String, Object> result = new HashMap<>();
    //     System.out.println("phone= " + Arrays.toString(phones));
    //
    //     if(phones.length!=0){
    //         boolean success = true; // 是否全部发送成功
    //         for (String phone : phones){
    //             System.out.println("传进来的手机号为=="+phone);
    //             String s = SMSUtil_one_time.sendSMS(request, phone);
    //             if (s!=null) {
    //                 // 如果发送成功，则继续发送下一个手机号
    //                 continue;
    //             }else {
    //                 // 如果发送失败，则标记发送失败，并跳出循环
    //                 success = false;
    //                 break;
    //             }
    //       }
    //       if (success){
    //             result.put("success", true);
    //             result.put("msg", "发送成功！");
    //             result.put("redirectUrl", "./searchPrescript");
    //             return result;
    //       } else {
    //             result.put("success", false);
    //             result.put("msg", "发送失败，请检查，是否选中，稍后再试！");
    //             return result;
    //         }
    //     }else{
    //         result.put("success", false);
    //         result.put("msg", "手机号错误，请稍后再试！");
    //         return result;
    //     }
    // }
    //
    //

}
