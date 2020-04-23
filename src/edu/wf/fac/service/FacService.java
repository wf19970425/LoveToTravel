package edu.wf.fac.service;

import java.util.List;
import java.util.Map;

import edu.wf.fac.model.Fac;

public interface FacService {
    Map<String , Object> delete(Fac fac,Map<String , Object> map);
    Map<String , Object> add(Fac fac,Map<String , Object> map);
    Fac load(Integer fac_id);
    Map<String , Object> update(Fac fac,Map<String , Object> map);
    Map<String , Object> facList(Map<String , Object> map);
    List<Fac> facListAll();
}
