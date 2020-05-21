package edu.wf.orsp.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import edu.wf.client.model.Client;
import edu.wf.main.PageBean;
import edu.wf.orsp.model.Orsp;
import edu.wf.orsp.service.OrspService;

@Controller
public class OrspController {
    @Autowired
    private OrspService orspService;
    //查询列表
    @RequestMapping("/back/orspList")
    public String orspList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Orsp orsp,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = orspService.orspList(map);
        return "jsp/back/orsp/orspList";
    }
    //添加页面
    @RequestMapping("/back/orspAdd")
    public String orspAdd(Map<String,Object> map){
        return "jsp/back/orsp/orspAdd";
    }
    //添加后台
    @RequestMapping("/back/orspAddDo")
    public String orspAddDo(Map<String,Object> map,Orsp orsp){
    	orsp.setOrsp_date(new Date());
        map = orspService.add(orsp , map);
        map.put("url" , "back/orspAdd");
        return "jsp/back/main/addMessage";
    }
    //通过id查询一条记录
    @RequestMapping("/back/orspLoad")
    public String orspload(Integer orsp_id,Map<String,Object> map){
        Orsp orsp = orspService.load(orsp_id);
        map.put("orsp" , orsp);
        return "jsp/back/orsp/orspMdi";
    }
    //修改
    @RequestMapping("/back/orspMdi")
    public String orspMdi(Orsp orsp,Map<String,Object> map,Integer pages) throws IllegalStateException, IOException{
    	map = orspService.update(orsp , map);
        map.put("pages" , pages);
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/back/orspList";
    }
    //修改
    @RequestMapping("/back/orspDel")
    public String orspDel(Integer orsp_id,Map<String,Object> map){
        map.put("orsp_id" , orsp_id);
        return "jsp/back/orsp/orspDel";
    }
    //删除
    @RequestMapping("/back/orspDelDo")
    public String orspDelDo(Orsp orsp,Map<String,Object> map){
        map = orspService.delete(orsp , map);
        return "jsp/back/main/message";
    }
    //前台查询列表
    @RequestMapping("/bf/orspList")
    public String orspList1(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Orsp orsp,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = orspService.orspList(map);
        return "jsp/bf/orsp/orspList";
    }
    //修改
    @RequestMapping("/bf/orspMdi")
    public String orspMdi(Orsp orsp,Map<String,Object> map,int pages,String oper,Integer fk_orspClient_id,HttpServletRequest request){
    	HttpSession session = request.getSession();
    	Client client = (Client)session.getAttribute("client");
        map = orspService.update(orsp , map);
        map.put("pages" , pages);
        if(oper!=null&&oper!=""&&oper.equals("grAdd")){
            map.put("message" , "评价成功");
            return "jsp/back/main/message";
        }else {
            return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/bf/orspList?fk_orspClient_id="+client.getClient_id();
        }
        
    }
    //添加
    @RequestMapping("/bf/orspAdd")
    public String orspAdd1(Map<String,Object> map,Orsp orsp,String spot_name,String spot_price,String spot_child){
        Date date = new Date();
       SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
        String orsp_code = s.format(date)+(int)(Math.random()*9000+1000);
        orsp.setOrsp_code(orsp_code);
        map.put("orsp" , orsp);
        map.put("spot_name" , spot_name);
        map.put("spot_price" , spot_price);
        map.put("spot_child" , spot_child);
        return "jsp/bf/orsp/orspAdd";
    }
    //添加后台
    @RequestMapping("/bf/orspAddDo")
    public String orspAddDo1(Map<String,Object> map,Orsp orsp,String client_paypassword,HttpServletRequest request,Integer fk_orspSpot_id,Integer orsp_num){
        HttpSession session = request.getSession();
        Client client = (Client)session.getAttribute("client");
        
        if(client_paypassword.equals(client.getClient_paypassword())){
            Date date = new Date();
            orsp.setOrsp_date(date);
            map.put("orsp" , orsp);
            map = orspService.add(orsp , map);
        }else {
            map.put("message" , "支付密码错误");
        }
        return "jsp/back/main/message";
    }
    
    @RequestMapping("/back/orspTotal")
    public String orspTotal(Map<String,Object> map,String orsp_date){
    	if(orsp_date!=null&&orsp_date!=""){
    		map.put("orsp_date", orsp_date);
    		List<Map<String, Object>> orspTotal = orspService.orspTotal(orsp_date);
    		map.put("orspTotal", orspTotal);
    	}
        return "jsp/back/orsp/orspTotal";
    }
    
}
