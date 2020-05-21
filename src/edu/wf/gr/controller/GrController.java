package edu.wf.gr.controller;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import edu.wf.gr.model.Gr;
import edu.wf.gr.service.GrService;
import edu.wf.main.FilePath;
import edu.wf.main.PageBean;

@Controller
public class GrController {
    @Autowired
    private GrService grService;
    //查询列表
    @RequestMapping("/back/grList")
    public String grList( @RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Gr gr,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = grService.grList(map);
        return "jsp/back/gr/grList";
    }
    //添加页面
    @RequestMapping("/bf/grAddSpot")
    public String grAddSpot(Map<String,Object> map,Gr gr,String spot_name,Integer orsp_id,Integer pages){
        map.put("spot_name" , spot_name);
        map.put("orsp_id" , orsp_id);
        map.put("pages" , pages);
        return "jsp/bf/gr/grAddSpot";
    }
  //添加页面
    @RequestMapping("/bf/grAddTeams")
    public String grAddTeams(Map<String,Object> map,Gr gr,String teams_name,Integer orte_id,Integer pages){
        map.put("teams_name" , teams_name);
        map.put("orte_id" , orte_id);
        map.put("pages" , pages);
        return "jsp/bf/gr/grAddTeams";
    }
    //添加后台
    @PostMapping("/bf/grAddDoSpot")
    public String grAddDoSpot(Map<String,Object> map,Gr gr,MultipartFile photo,Integer orsp_id,Integer pages) throws IllegalStateException, IOException{
        if(photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
            String root = FilePath.FILEPATH;
            String real_name = photo.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            photo.transferTo(file);
            System.out.println("1231");
            gr.setGr_pho(newName);
        }

        map.put("gr" , gr);
        map = grService.add(gr , map);
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+ "/bf/orspMdi?orsp_status=6&pages="+pages+"&orsp_id="+orsp_id+"&oper=grAdd";
    }
  //添加后台
    @PostMapping("/bf/grAddDoTeams")
    public String grAddDoTeams(Map<String,Object> map,Gr gr,MultipartFile photo,Integer orte_id,Integer pages) throws IllegalStateException, IOException{
        if(photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
            String root = FilePath.FILEPATH;
            String real_name = photo.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            photo.transferTo(file);
            System.out.println("1231");
            gr.setGr_pho(newName);
        }

        map.put("gr" , gr);
        map = grService.add(gr , map);
        return InternalResourceViewResolver.FORWARD_URL_PREFIX+ "/bf/orteMdi?orte_status=6&pages="+pages+"&orte_id="+orte_id+"&oper=grAdd";
    }
    //删除页面
    @RequestMapping("/back/grDel")
    public String grDel(Integer gr_id,Map<String,Object> map){
        map.put("gr_id" , gr_id);
        return "jsp/back/gr/grDel";
    }
    //删除
    @RequestMapping("/back/grDelDo")
    public String grDelDo(Gr gr,Map<String,Object> map){
        map = grService.delete(gr , map);
        return "jsp/back/main/message";
    }
    //通过id查询一条记录
    @RequestMapping("/back/grLoad")
    public String grload(Integer gr_id,Map<String,Object> map){
        Gr gr = grService.load(gr_id);
        map.put("gr" , gr);
        return "jsp/back/gr/grMdi";
    }
    //修改
    @PostMapping("/back/grMdi")
    public String grMdi(Gr gr,Map<String,Object> map,MultipartFile photo,MultipartFile haibao,MultipartFile video) throws IllegalStateException, IOException{
        System.out.println(photo.getOriginalFilename());
        System.out.println(haibao.getOriginalFilename());
        System.out.println(video.getOriginalFilename());
        if(photo.getOriginalFilename()!=null&&photo.getOriginalFilename()!=""){
            String root = FilePath.FILEPATH;
            String real_name = photo.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            photo.transferTo(file);
            System.out.println("1231");
        }
        if(haibao.getOriginalFilename()!=null&&haibao.getOriginalFilename()!=""){
            String root = FilePath.FILEPATH;
            String real_name = haibao.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            haibao.transferTo(file);
        }
        if(video.getOriginalFilename()!=null&&video.getOriginalFilename()!=""){
            String root = FilePath.FILEPATH;
            String real_name = video.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            video.transferTo(file);
        }
        map.put("gr" , gr);
        map = grService.update(gr , map);
        return "jsp/back/main/message";
    }

    
    

}
