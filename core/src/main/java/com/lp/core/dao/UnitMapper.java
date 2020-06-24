package com.lp.core.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lp.core.cache.RedisCache;
import com.lp.core.entity.Unit;
import org.apache.ibatis.annotations.CacheNamespace;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
@CacheNamespace(implementation = RedisCache.class)
public interface UnitMapper extends BaseMapper<Unit> {
}
