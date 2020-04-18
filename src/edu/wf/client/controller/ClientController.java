package edu.wf.client.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;


import edu.wf.client.model.Client;
import edu.wf.client.service.ClientService;
import edu.wf.fac.model.Fac;
import edu.wf.fac.service.FacService;
import edu.wf.main.FilePath;
import edu.wf.main.PageBean;
import edu.wf.orsp.model.Orsp;
import edu.wf.orsp.service.OrspService;
import edu.wf.orte.model.Orte;
import edu.wf.orte.service.OrteService;

@Controller
public class ClientController {
    @Autowired
    private ClientService clientService;
    @Autowired
    private OrspService orspService;
    @Autowired
    private OrteService orteService;
    @Autowired
    private FacService facService;
    //查询列表
    @RequestMapping("/back/clientList")
    public String clientList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Client client,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = clientService.clientList(map);
        return "jsp/back/client/clientList";
    }
    //添加页面
    @RequestMapping("/back/clientAdd")
    public String clientAdd(Map<String,Object> map){
    	List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        return "jsp/back/client/clientAdd";
    }
    //添加后台
    @RequestMapping("/back/clientAddDo")
    public String clientAddDo(Map<String,Object> map,Client client,MultipartFile icon) throws IllegalStateException, IOException{
    	if(icon.getOriginalFilename()!=null&&icon.getOriginalFilename()!=""){
    		String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            client.setClient_date(newName);
    	}
    	map = clientService.add(client , map);
        map.put("url" , "back/clientAdd");
        return "jsp/back/main/addMessage";
    }
    //删除页面
    @RequestMapping("/back/clientDel")
    public String clientDel(Integer client_id,Map<String,Object> map){
        map.put("client_id" , client_id);
        return "jsp/back/client/clientDel";
    }
    //删除
    @RequestMapping("/back/clientDelDo")
    public String clientDelDo(Client client,Map<String,Object> map){
        map = clientService.delete(client , map);
        return "jsp/back/main/message";
    }
    //通过id查询一条记录
    @RequestMapping("/back/clientLoad")
    public String clientload(Integer client_id,Map<String,Object> map){
        Client client = clientService.load(client_id);
        map.put("client" , client);
        List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        return "jsp/back/client/clientMdi";
    }
    //前段修改个人信息
    @RequestMapping("/back/clientMdi1")
    public String clientMdi(Client client,Map<String,Object> map,String[] fk_clientFac_ids) throws IllegalStateException, IOException{
    	if(fk_clientFac_ids!=null){
    		String fk_clientFac_id = StringUtils.join(fk_clientFac_ids,",");
        	client.setFk_clientFac_id(fk_clientFac_id);
    	}
        map = clientService.update(client , map);
        return "jsp/back/main/message";
    }
    //后端修改个人信息
    @RequestMapping("/back/clientMdi")
    public String clientMdi(Client client,Map<String,Object> map,String[] fk_clientFac_ids,MultipartFile icon) throws IllegalStateException, IOException{
    	if((icon.getOriginalFilename()!=null)&&(icon.getOriginalFilename()!="")){
        	String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            client.setClient_date(newName);
    	}
        map = clientService.update(client , map);
        return "jsp/back/main/message";
    }
    //登录
    @RequestMapping("/bf/login")
    public String login(){
        return "jsp/bf/main/login";
    }
    //登录
    @RequestMapping("/bf/loginDo")
    public String loginDo(Map<String,Object> map,Client client,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> m = clientService.login(client,session);
        map.put("message" , m.get("message"));
        return m.get("url").toString();
    }
    //注册
    @RequestMapping("/bf/reg")
    public String reg(Map<String,Object> map){
    	List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        return "jsp/bf/main/reg";
    }
    //注册后台
    @RequestMapping("/bf/regDo")
    public String clientAddDo1(Map<String,Object> map,Client client,String[] fk_clientFac_ids){
    	String fk_clientFac_id = StringUtils.join(fk_clientFac_ids,",");
    	client.setFk_clientFac_id(fk_clientFac_id);
        map = clientService.add(client , map);
        map.put("url" , "bf/login");
        map.put("message" , "注册成功");
        return "jsp/back/main/message";
    }
    //退出
    @RequestMapping("/bf/loginOut")
    public String loginOut(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("client");
        return InternalResourceViewResolver.REDIRECT_URL_PREFIX+"/bf/main";
    }
    //通过id查询一条记录
    @RequestMapping("/bf/clientLoad1")
    public String clientload1(Integer client_id,Map<String,Object> map){
    	List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        Client client = clientService.load(client_id);
        String fk_clientFac_id = client.getFk_clientFac_id();
        String[] facs = fk_clientFac_id.split(",");
        map.put("client" , client);
        map.put("facs", facs);
        return "jsp/bf/client/clientMdi";
    }
    //修改密码后台
    @RequestMapping("/bf/clientPasswordMdiDo")
    public String clientMdi(Client client,Map<String,Object> map,String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        Client c = (Client)session.getAttribute("client");
        String url = "jsp/bf/client/clientPasswordMdi";
        if(c.getClient_password().equals(password)){
            url = "jsp/back/main/message";
            map = clientService.update(client , map);
        }else {
            map.put("message" , "老密码错误");
        }
        return url;
    }
    //修改密码
    @RequestMapping("/bf/clientPasswordMdi")
    public String clientPasswordMdi(){
        return "jsp/bf/client/clientPasswordMdi";
    }
    //修改支付密码
    @RequestMapping("/bf/clientPayPasswordMdi")
    public String clientPayPasswordMdi(){
        return "jsp/bf/client/clientPayPasswordMdi";
    }
    //修改密码后台
    @RequestMapping("/bf/clientPayPasswordMdiDo")
    public String clientPayPasswordMdiDo(Client client,Map<String,Object> map,String password,HttpServletRequest request){
        HttpSession session = request.getSession();
        Client c = (Client)session.getAttribute("client");
        String url = "jsp/bf/client/clientPayPasswordMdi";
        if(c.getClient_paypassword().equals(password)){
            url = "jsp/back/main/message";
            map = clientService.update(client , map);
        }else {
            map.put("message" , "老密码错误");
        }
        return url;
    }
    @RequestMapping("/bf/clientLoad")
    public String ordersList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Orsp orsp,Orte orte,Map<String,Object> map,HttpServletRequest request ){
    	List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
    	HttpSession session = request.getSession();
        Client c = (Client)session.getAttribute("client");
        Client client = clientService.load(c.getClient_id());
        map.put("client" , client);
        return "jsp/bf/client/clientLoad";
    }
    
    

}
