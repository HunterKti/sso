package com.hunter.sso.service.impl;

import com.hunter.sso.domain.origin.SpUser;
import com.hunter.sso.mapper.origin.SpUserMapper;
import com.hunter.sso.service.LoginService;
import com.hunter.sso.utils.MapperUtils;
import com.hunter.sso.utils.RedisUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author Hunter
 * @date 2020/4/20
 */
@Service
public class LoginServiceImpl implements LoginService {

    SpUserMapper spUserMapper;

    RedisUtil redisUtil;

    @Autowired
    public void setSpUserMapper(SpUserMapper spUserMapper) {
        this.spUserMapper = spUserMapper;
    }

    @Autowired
    public void setRedisUtil(RedisUtil redisUtil) {
        this.redisUtil = redisUtil;
    }

    @Override
    public SpUser login(String username, String password) {
        SpUser spUser = null;
        //缓存取用户
        String json = redisUtil.get(username);
        if (StringUtils.isNotBlank(json)) {
            try {
                spUser = MapperUtils.json2pojo(json, SpUser.class);
            } catch (Exception e) {
                e.printStackTrace();
            }
            //数据不一致
            if (null != spUser && !password.equals(spUser.getPassword())) {
                spUser = null;
            }
        } else {
            Example example = new Example(SpUser.class);
            example.createCriteria().andEqualTo("no", username);
            spUser = spUserMapper.selectOneByExample(example);
            if (null != spUser && password.equals(spUser.getPassword())) {
                try {
                    redisUtil.put(username, MapperUtils.obj2json(spUser), 60 * 60 * 24);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return spUser;
    }
}
