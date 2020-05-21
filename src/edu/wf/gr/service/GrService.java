package edu.wf.gr.service;

import java.util.List;
import java.util.Map;

import edu.wf.gr.model.Gr;

public interface GrService {
    Map<String , Object> delete(Gr gr,Map<String , Object> map);
    Map<String , Object> add(Gr gr,Map<String , Object> map);
    Gr load(Integer gr_id);
    Map<String , Object> update(Gr gr,Map<String , Object> map);
    Map<String , Object> grList(Map<String , Object> map);
    List<Gr> grBfList(Map<String , Object> map);
}
