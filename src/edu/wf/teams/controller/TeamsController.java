package edu.wf.teams.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import edu.wf.gr.model.Gr;
import edu.wf.gr.service.GrService;
import edu.wf.main.FilePath;
import edu.wf.main.PageBean;
import edu.wf.spot.model.Spot;
import edu.wf.teams.model.Teams;
import edu.wf.teams.service.TeamsService;

@Controller
public class TeamsController {
    @Autowired
    private TeamsService teamsService;
    @Autowired
    private GrService grService;
    //查询列表
    @RequestMapping("/back/teamsList")
    public String teamsList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Teams teams,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = teamsService.teamsList(map);
        return "jsp/back/teams/teamsList";
    }
    //添加页面
    @RequestMapping("/back/teamsAdd")
    public String teamsAdd(Map<String,Object> map){
        return "jsp/back/teams/teamsAdd";
    }
    //添加后台
    @RequestMapping("/back/teamsAddDo")
    public String teamsAddDo(Map<String,Object> map,Teams teams,MultipartFile icon) throws IllegalStateException, IOException{
    	if(icon.getOriginalFilename()!=null&&icon.getOriginalFilename()!=""){
    		String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            teams.setTeams_logo(newName);
    	}
        map = teamsService.add(teams , map);
        map.put("url" , "back/teamsAdd");
        return "jsp/back/main/addMessage";
    }
    //通过id查询一条记录
    @RequestMapping("/bf/teamsLoad")
    public String teamsloadBf(Integer teams_id,Map<String,Object> map){
        Teams teams = teamsService.load(teams_id);
        map.put("teams" , teams);
        Gr gr = new Gr();
        gr.setFk_grTeams_id(teams_id);
        map.put("gr", gr);
        List<Gr> grBfList = grService.grBfList(map);
        map.put("grBfList", grBfList);
        return "jsp/bf/teams/teamsLoad";
    }
  //通过id查询一条记录
    @RequestMapping("/back/teamsLoad")
    public String teamsload(Integer teams_id,Map<String,Object> map){
        Teams teams = teamsService.load(teams_id);
        map.put("teams" , teams);
        return "jsp/back/teams/teamsMdi";
    }
    //修改
    @RequestMapping("/back/teamsMdi")
    public String teamsMdi(Teams teams,Map<String,Object> map,MultipartFile icon) throws IllegalStateException, IOException{
    	if(icon.getOriginalFilename()!=null&&icon.getOriginalFilename()!=""){
    		String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            teams.setTeams_logo(newName);
    	}
        map = teamsService.update(teams , map);
        return "jsp/back/main/message";
    }
    //修改
    @RequestMapping("/back/teamsDel")
    public String teamsDel(Integer teams_id,Map<String,Object> map){
        map.put("teams_id" , teams_id);
        return "jsp/back/teams/teamsDel";
    }
    //删除
    @RequestMapping("/back/teamsDelDo")
    public String teamsDelDo(Teams teams,Map<String,Object> map){
        map = teamsService.delete(teams , map);
        return "jsp/back/main/message";
    }
  //查询列表
    @RequestMapping("/bf/teamsList")
    public String teamsListBf(Teams teams,Map<String,Object> map){
        map = teamsService.teamsBfList(map);
        return "jsp/bf/teams/teamsList";
    }
    
}
