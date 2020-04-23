package edu.wf.spot.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
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

import edu.wf.fac.model.Fac;
import edu.wf.fac.service.FacService;
import edu.wf.gr.model.Gr;
import edu.wf.gr.service.GrService;
import edu.wf.main.FilePath;
import edu.wf.main.PageBean;
import edu.wf.spot.model.Spot;
import edu.wf.spot.service.SpotService;

@Controller
public class SpotController {
    @Autowired
    private SpotService spotService;
    @Autowired
    private GrService grService;
    @Autowired
    private FacService facService;
    //查询列表
    @RequestMapping("/back/spotList")
    public String spotList(@RequestParam(required=false,defaultValue="1")int pages,@RequestParam(required=false,defaultValue="5")int num,Spot spot,Map<String,Object> map,HttpServletRequest request ){
        map = PageBean.backMap(map , pages , num,request);
        map = spotService.spotList(map);
        return "jsp/back/spot/spotList";
    }
    //添加页面
    @RequestMapping("/back/spotAdd")
    public String spotAdd(Map<String,Object> map){
    	List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        return "jsp/back/spot/spotAdd";
    }
    //添加后台
    @RequestMapping("/back/spotAddDo")
    public String spotAddDo(Map<String,Object> map,Spot spot,MultipartFile icon) throws IllegalStateException, IOException{
    	if(icon.getOriginalFilename()!=null&&icon.getOriginalFilename()!=""){
    		String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            spot.setSpot_logo(newName);
    	}
        map = spotService.add(spot , map);
        map.put("url" , "back/spotAdd");
        return "jsp/back/main/addMessage";
    }
    //通过id查询一条记录
    @RequestMapping("/back/spotLoad")
    public String spotload(Integer spot_id,Map<String,Object> map){
        Spot spot = spotService.load(spot_id);
        map.put("spot" , spot);
        List<Fac> facListAll = facService.facListAll();
    	map.put("facListAll", facListAll);
        return "jsp/back/spot/spotMdi";
    }
  //通过id查询一条记录
    @RequestMapping("/bf/spotLoad")
    public String spotloadBf(Integer spot_id,Map<String,Object> map){
        Spot spot = spotService.load(spot_id);
        map.put("spot" , spot);
        Gr gr = new Gr();
        gr.setFk_grSpot_id(spot_id);
        map.put("gr", gr);
        List<Gr> grBfList = grService.grBfList(map);
        map.put("grBfList", grBfList);
        return "jsp/bf/spot/spotLoad";
    }
    //修改
    @RequestMapping("/back/spotMdi")
    public String spotMdi(Spot spot,Map<String,Object> map,MultipartFile icon) throws IllegalStateException, IOException{
    	if(icon.getOriginalFilename()!=null&&icon.getOriginalFilename()!=""){
    		String root = FilePath.FILEPATH;
            String real_name = icon.getOriginalFilename();
            String ext = FilenameUtils.getExtension(real_name);
            String newName = UUID.randomUUID().toString().replaceAll("-" , "")+"."+ext;
            //建立一个空文件
            File file = new File(root+"/"+newName);
            //把内容写入空的文件
            icon.transferTo(file);
            spot.setSpot_logo(newName);
    	}
        map = spotService.update(spot , map);
        return "jsp/back/main/message";
    }
    //修改
    @RequestMapping("/back/spotDel")
    public String spotDel(Integer spot_id,Map<String,Object> map){
        map.put("spot_id" , spot_id);
        return "jsp/back/spot/spotDel";
    }
    //删除
    @RequestMapping("/back/spotDelDo")
    public String spotDelDo(Spot spot,Map<String,Object> map){
        map = spotService.delete(spot , map);
        return "jsp/back/main/message";
    }
  //查询列表
    @RequestMapping("/bf/spotList")
    public String spotListBf(Spot spot,Map<String,Object> map){
        map = spotService.spotBfList(map);
        return "jsp/bf/spot/spotList";
    }
    
}
