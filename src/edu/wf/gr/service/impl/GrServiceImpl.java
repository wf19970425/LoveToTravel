package edu.wf.gr.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.gr.mapper.GrMapper;
import edu.wf.gr.model.Gr;
import edu.wf.gr.service.GrService;
import edu.wf.main.PageBean;

@Service
public class GrServiceImpl implements GrService{
    @Autowired
    private GrMapper grMapper;
    @Override
    public Map<String , Object> delete(Gr gr,Map<String , Object> map) {
        int result = grMapper.delete(gr.getGr_id());
        if(result>0){
            map.put("message" , "删除成功");
        }else {
            map.put("message" , "删除失败");
        }
        return map;
    }
    
    @Override
    public Map<String , Object> add(Gr gr,Map<String , Object> map ) {
        int result = grMapper.add(gr);
        if(result>0){
            map.put("message" , "添加成功");
        }else {
            map.put("message" , "添加失败");
        }
        return map;
    }
    
    @Override
    public Gr load(Integer gr_id ) {
        return grMapper.load(gr_id);
    }
    

    @Override
    public Map<String , Object> grList(Map<String , Object> map ) {
        List<Gr> grList = grMapper.grList(map);
        Integer count = grMapper.count(map);
        map = PageBean.bfMap(map , count , grList , Gr.class);
        return map;
    }
    
    @Override
    public Map<String , Object> update(Gr gr , Map<String , Object> map ) {
        int result = grMapper.update(gr);
        if(result>0){
            map.put("message" , "修改成功");
        }else {
            map.put("message" , "修改失败");
        }
        return map;
    }

	@Override
	public List<Gr> grBfList(Map<String, Object> map) {
		return grMapper.grBfList(map);
	}
    


    
    
    
    
}
