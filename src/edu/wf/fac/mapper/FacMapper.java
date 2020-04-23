package edu.wf.fac.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.fac.model.Fac;

public interface FacMapper {
    int delete(Integer fac_id);
    int add(Fac fac);
    Fac load(Integer fac_id);
    int update(Fac fac);
    int count(Map<String , Object> map);
    List<Fac> facList(Map<String , Object> map);
    List<Fac> facListAll();
}