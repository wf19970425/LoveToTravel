package edu.wf.orte.controller;

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
import edu.wf.orte.model.Orte;
import edu.wf.orte.model.Orte;
import edu.wf.orte.model.Orte;
import edu.wf.orte.service.OrteService;

@Controller
public class OrteController {
    @Autowired
    private OrteService orteService;
    //查询列表
    @RequestMapping("/back/orteList")
    public String orteList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Orte orte,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = orteService.orteList(map);
        return "jsp/back/orte/orteList";
    }
    //添加页面
    @RequestMapping("/back/orteAdd")
    public String orteAdd(Map<String,Object> map){
        return "jsp/back/orte/orteAdd";
    }
    //添加后台
    @RequestMapping("/back/orteAddDo")
    public String orteAddDo(Map<String,Object> map,Orte orte){
    	orte.setOrte_date(new Date());
        map = orteService.add(orte , map);
        map.put("url" , "back/orteAdd");
        return "jsp/back/main/addMessage";
    }
    //通过id查询一条记录
    @RequestMapping("/back/orteLoad")
    public String orteload(Integer orte_id,Map<String,Object> map){
        Orte orte = orteService.load(orte_id);
        map.put("orte" , orte);
        return "jsp/back/orte/orteMdi";
    }
    //修改
    @RequestMapping("/back/orteMdi")
    public String orteMdi(Orte orte,Map<String,Object> map,Integer pages) throws IllegalStateException, IOException{
    	map = orteService.update(orte , map);
        map.put("pages" , pages);
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/back/orteList";
    }
    //修改
    @RequestMapping("/back/orteDel")
    public String orteDel(Integer orte_id,Map<String,Object> map){
        map.put("orte_id" , orte_id);
        return "jsp/back/orte/orteDel";
    }
    //删除
    @RequestMapping("/back/orteDelDo")
    public String orteDelDo(Orte orte,Map<String,Object> map){
        map = orteService.delete(orte , map);
        return "jsp/back/main/message";
    }
  //前台查询列表
    @RequestMapping("/bf/orteList")
    public String orteList1(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Orte orte,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = orteService.orteList(map);
        return "jsp/bf/orte/orteList";
    }
  //修改
    @RequestMapping("/bf/orteMdi")
    public String orteMdi(Orte orte,Map<String,Object> map,int pages,String oper,HttpServletRequest request){
    	HttpSession session = request.getSession();
    	Client client = (Client)session.getAttribute("client");
    	map = orteService.update(orte , map);
        map.put("pages" , pages);
        if(oper!=null&&oper!=""&&oper.equals("grAdd")){
            map.put("message" , "评价成功");
            return "jsp/back/main/message";
        }else {
            return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/bf/orteList?fk_orteClient_id="+client.getClient_id();
        }
        
    }
  //添加
    @RequestMapping("/bf/orteAdd")
    public String orteAdd1(Map<String,Object> map,Orte orte,String teams_name,String teams_price,String teams_child){
        Date date = new Date();
       SimpleDateFormat s = new SimpleDateFormat("yyyyMMddHHmmss");
        String orte_code = s.format(date)+(int)(Math.random()*9000+1000);
        orte.setOrte_code(orte_code);
        map.put("orte" , orte);
        map.put("teams_name" , teams_name);
        map.put("teams_price" , teams_price);
        map.put("teams_child" , teams_child);
        return "jsp/bf/orte/orteAdd";
    }
    //添加后台
    @RequestMapping("/bf/orteAddDo")
    public String orteAddDo1(Map<String,Object> map,Orte orte,String client_paypassword,HttpServletRequest request,Integer fk_orteTeams_id,Integer orte_num){
        HttpSession session = request.getSession();
        Client client = (Client)session.getAttribute("client");
        
        if(client_paypassword.equals(client.getClient_paypassword())){
            Date date = new Date();
            orte.setOrte_date(date);
            map.put("orte" , orte);
            map = orteService.add(orte , map);
        }else {
            map.put("message" , "支付密码错误");
        }
        return "jsp/back/main/message";
    }
    @RequestMapping("/back/orteTotal")
    public String orteTotal(Map<String,Object> map,String orte_date){
    	if(orte_date!=null&&orte_date!=""){
    		map.put("orte_date", orte_date);
    		List<Map<String, Object>> orteTotal = orteService.orteTotal(orte_date);
    		map.put("orteTotal", orteTotal);
    	}
        return "jsp/back/orte/orteTotal";
    }
    
}
