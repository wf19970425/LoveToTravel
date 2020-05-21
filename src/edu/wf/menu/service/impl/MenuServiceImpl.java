package edu.wf.menu.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.menu.mapper.MenuMapper;
import edu.wf.menu.model.Menu;
import edu.wf.menu.service.MenuService;
@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuMapper menuMapper;
    @Override
    public List<Menu> noList(Integer role_id ) {
        return menuMapper.noList(role_id);
    }

}
