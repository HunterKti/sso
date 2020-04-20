package tk.mybatis.mapper;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 *
 * @author Hunter
 * @date 2020/4/20
 */
public interface MyMapper<T> extends Mapper<T>, MySqlMapper<T> {
}
