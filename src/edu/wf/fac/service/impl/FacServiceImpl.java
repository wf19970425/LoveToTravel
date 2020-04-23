package edu.wf.fac.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.fac.mapper.FacMapper;
import edu.wf.fac.model.Fac;
import edu.wf.fac.service.FacService;
import edu.wf.main.PageBean;

@Service
public class FacServiceImpl implements FacService{
    @Autowired
    private FacMapper facMapper;
    @Override
    public Map<String , Object> delete(Fac fac,Map<String , Object> map) {
        int result = facMapper.delete(fac.getFac_id());
        if(result>0){
            map.put("message" , "删除成功");
        }else {
            map.put("message" , "删除失败");
        }
        return map;
    }

    @Override
    public Map<String , Object> add(Fac fac,Map<String , Object> map ) {
        int result = facMapper.add(fac);
        if(result>0){
            map.put("message" , "添加成功");
        }else {
            map.put("message" , "添加失败");
        }
        return map;
    }

    @Override
    public Fac load(Integer fac_id ) {
        return facMapper.load(fac_id);
    }

    
    @Override
    public Map<String , Object> facList(Map<String , Object> map ) {
        List<Fac> facList = facMapper.facList(map);
        Integer count = facMapper.count(map);
        map = PageBean.bfMap(map , count , facList , Fac.class);
        return map;
    }

    @Override
    public Map<String , Object> update(Fac fac , Map<String , Object> map ) {
        int result = facMapper.update(fac);
        if(result>0){
            map.put("message" , "修改成功");
        }else {
            map.put("message" , "修改失败");
        }
        return map;
    }
    
    @Override
    public List<Fac> facListAll() {
        return facMapper.facListAll();
    }
    
}
