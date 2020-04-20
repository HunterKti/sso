package com.hunter.sso.mapper.origin;

import com.hunter.sso.domain.origin.SpUser;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.MyMapper;

@Repository
public interface SpUserMapper extends MyMapper<SpUser> {
}