package edu.wf.main;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.wf.client.model.Client;
import edu.wf.spot.model.Spot;
import edu.wf.spot.service.SpotService;
import edu.wf.teams.model.Teams;
import edu.wf.teams.service.TeamsService;
import edu.wf.user.model.User;
import edu.wf.user.service.UserService;

@Controller
public class MainController {
    @Autowired
    UserService userService;
    @Autowired
    SpotService spotService;
    @Autowired
    TeamsService teamsService;
    @RequestMapping("/back/main")
    public String main(){
        System.out.println("asd");
        return "jsp/back/main/main";
    }
    @RequestMapping("/back/login")
    public String login(){
        return "jsp/back/main/login";
    }
    @RequestMapping("/back/index")
    public String index(){
        return "jsp/back/main/index";
    }
    @RequestMapping("/back/loginDo")
    public String loginDo(Map<String,Object> map,User user,HttpServletRequest request){
        HttpSession session = request.getSession();
        Map<String,Object> m = userService.login(user,session,map);
        map.put("message" , m.get("message"));
        return "jsp/back/main/"+m.get("url");
    }
    @RequestMapping("/bf/main")
    public String mainBf(Map<String, Object> map,HttpServletRequest request){
    	HttpSession session = request.getSession();
    	Object client = session.getAttribute("client");
    	if(client!=null){
    		Client c = (Client)client;
    		List<Spot> tuijianList = spotService.tuijianList(c);
    		map.put("tuijianList", tuijianList);
    	}
        List<Spot> spotNewList = spotService.spotNewList();
        map.put("spotNewList", spotNewList);
        List<Teams> teamsNewList = teamsService.teamsNewList();
        map.put("teamsNewList", teamsNewList);
        return "jsp/bf/main/main";
    }
    @RequestMapping("/bf/mapList")
    public String map(){
    	return "jsp/bf/map/mapList";
    }
}
