package edu.wf.user.mapper;

import java.util.List;
import java.util.Map;

import edu.wf.user.model.User;

public interface UserMapper {
	//删除员工
	int delete(Integer user_id);
	//添加员工
    int add(User user);
    //通过id查询员工
    User load(Integer user_id);
    //修改员工
    int update(User user);
    //查询员工数量
    int count(Map<String , Object> map);
    //查询员工列表
    List<User> userList(Map<String , Object> map);
    //员工登录
    User login(User user);
}