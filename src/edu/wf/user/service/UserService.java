package edu.wf.user.service;

import java.util.Map;

import javax.servlet.http.HttpSession;

import edu.wf.user.model.User;

public interface UserService {
    Map<String , Object> add(User user,Map<String , Object> map);
    int delete(Integer user_id);

    User load(Integer user_id);
    Map<String , Object> update(User user,Map<String , Object> map);
    Map<String , Object> userList(Map<String , Object> map);
    Map<String , Object> login(User user,HttpSession session,Map<String , Object> map);
}
