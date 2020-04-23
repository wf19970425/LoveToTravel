package edu.wf.fac.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.wf.fac.model.Fac;
import edu.wf.fac.service.FacService;
import edu.wf.main.PageBean;

@Controller
public class FacController {
    @Autowired
    private FacService facService;
    //查询列表
    @RequestMapping("/back/facList")
    public String facList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Fac fac,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = facService.facList(map);
        return "jsp/back/fac/facList";
    }
    //添加页面
    @RequestMapping("/back/facAdd")
    public String facAdd(Map<String,Object> map){
        return "jsp/back/fac/facAdd";
    }
    //添加后台
    @RequestMapping("/back/facAddDo")
    public String facAddDo(Map<String,Object> map,Fac fac){
        map = facService.add(fac , map);
        map.put("url" , "back/facAdd");
        return "jsp/back/main/addMessage";
    }
    //删除页面
    @RequestMapping("/back/facDel")
    public String facDel(Integer fac_id,Map<String,Object> map){
        map.put("fac_id" , fac_id);
        return "jsp/back/fac/facDel";
    }
    //删除
    @RequestMapping("/back/facDelDo")
    public String facDelDo(Fac fac,Map<String,Object> map){
        map = facService.delete(fac , map);
        return "jsp/back/main/message";
    }
    //通过id查询一条记录
    @RequestMapping("/back/facMdi")
    public String facload(Integer fac_id,Map<String,Object> map){
        Fac fac = facService.load(fac_id);
        map.put("fac" , fac);
        return "jsp/back/fac/facMdi";
    }
    //修改
    @RequestMapping("/back/facMdiDo")
    public String facMdi(Fac fac,Map<String,Object> map){
        map = facService.update(fac , map);
        return "jsp/back/main/message";
    }

    
}
