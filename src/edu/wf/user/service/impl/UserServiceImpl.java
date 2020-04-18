package edu.wf.user.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.wf.main.PageBean;
import edu.wf.menu.mapper.MenuMapper;
import edu.wf.menu.model.Menu;
import edu.wf.rlm.mapper.RlmMapper;
import edu.wf.rlm.model.Rlm;
import edu.wf.user.mapper.UserMapper;
import edu.wf.user.model.User;
import edu.wf.user.service.UserService;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RlmMapper rlmMapper;
    @Autowired
    private MenuMapper menuMapper;
    
    @Override
    public Map<String , Object> add(User user,Map<String , Object> map ) {
        int result = userMapper.add(user);
        if(result>0){
            map.put("message" , "添加员工成功");
        }else {
            map.put("message" , "添加员工失败");
        }
        return map;
    }
    @Override
    public int delete(Integer user_id ) {
        // TODO Auto-generated method stub
        return 0;
    }
    @Override
    public User load(Integer user_id ) {
        return userMapper.load(user_id);
    }
    

    @Override
    public Map<String , Object> userList(Map<String , Object> map ) {
        List<User> userList = userMapper.userList(map);
        Integer count = userMapper.count(map);
        map = PageBean.bfMap(map , count , userList , User.class);
        return map;
    }

    @Override
    public Map<String , Object> login(User user ,HttpSession session,Map<String, Object> map) {

    	User u = userMapper.login(user);
		if(u!=null){
			session.setAttribute("user", u);
			List<Rlm> sonList = rlmMapper.haveList(u.getFk_role_id());
			List<Integer> menu_ids = new ArrayList<Integer>();
			if(sonList.size()>0){
				for (Rlm rlm : sonList) {
					menu_ids.add(rlm.getFk_rlmMenu_id());
				}
				List<Menu> fatherList = menuMapper.fatherList(menu_ids);
				session.setAttribute("fatherList", fatherList);
				session.setAttribute("sonList", sonList);
			}
			map.put("url", "main");
		}else {
			map.put("message", "账号或密码错误");
			map.put("url", "login");
		}
		return map;
    }
    
    @Override
    public Map<String , Object> update(User user , Map<String , Object> map ) {
        int result = userMapper.update(user);
        if(user.getDelete_status()!=null){
            if(result>0){
                map.put("message" , "删除成功");
            }else {
                map.put("message" , "删除失败");
            }
        }else{
            if(result>0){
                map.put("message" , "修改成功");
            }else {
                map.put("message" , "修改失败");
            }
        }
        
        return map;
    }
    

}
