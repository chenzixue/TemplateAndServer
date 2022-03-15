/*
 * Copyright (C) 2020 xuexiangjys(xuexiangjys@163.com)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.xuexiang.server.service.impl;

import com.xuexiang.server.model.User;
import com.xuexiang.server.model.UserDao;
import com.xuexiang.server.service.UserService;
import com.xuexiang.templateandserver.App;

import java.sql.SQLException;
import java.util.List;

/**
 * 用户服务实现类
 *
 * @author xuexiang
 * @since 2020/8/31 12:42 AM
 */
public class UserServiceImpl implements UserService {
    private final UserDao userDao;


    public UserServiceImpl() {
        userDao = App.getDaoSession().getUserDao();
    }

    @Override
    public boolean addUser(User user) {
        userDao.insert(user);
        return true;
    }

    @Override
    public boolean deleteUser(Long userId){
        userDao.deleteByKey(userId);
        return true;
    }

    @Override
    public boolean updateUser(User record) {
        userDao.update(record);
        return true;
    }

    @Override
    public List<User> findAllUser(int pageNum, int pageSize) throws SQLException {
        int offset = (pageNum - 1) * pageSize;
        return userDao.queryBuilder().offset(offset).limit(pageSize).list();
    }

    @Override
    public List<User> findAllUser() throws SQLException {
        return userDao.loadAll();
    }

    @Override
    public User findUserByAccount(String loginName) throws SQLException {
        return userDao.queryBuilder()
                .where(UserDao.Properties.LoginName.eq(loginName))
                .unique();

    }

    @Override
    public User login(String loginName, String password) throws SQLException {
        return userDao.queryBuilder()
                .where(UserDao.Properties.LoginName.eq(loginName), UserDao.Properties.Password.eq(password))
                .unique();
    }
}
