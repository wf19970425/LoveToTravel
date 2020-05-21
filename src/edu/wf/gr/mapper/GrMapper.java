package edu.wf.gr.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.gr.model.Gr;

public interface GrMapper {
	 int delete(Integer gr_id);
	    int add(Gr gr);
	    Gr load(Integer gr_id);
	    int update(Gr gr);
	    int count(Map<String , Object> map);
	    List<Gr> grList(Map<String , Object> map);
	    List<Gr> grBfList(Map<String , Object> map);
}