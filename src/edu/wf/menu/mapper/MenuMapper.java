package edu.wf.menu.mapper;

import java.util.List;

import edu.wf.menu.model.Menu;

public interface MenuMapper {
    int delete(Integer menu_id);
    
    int add(Menu menu);
    
    Menu load(Integer menu_id);
    int update(Menu menu);
    List<Menu> noList(Integer role_id);
    List<Menu> fatherList(List<Integer> menu_ids);
}