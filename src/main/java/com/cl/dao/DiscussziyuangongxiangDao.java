package com.cl.dao;

import com.cl.entity.DiscussziyuangongxiangEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.cl.entity.view.DiscussziyuangongxiangView;


/**
 * 资源共享评论表
 * 
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
public interface DiscussziyuangongxiangDao extends BaseMapper<DiscussziyuangongxiangEntity> {
	
	List<DiscussziyuangongxiangView> selectListView(@Param("ew") Wrapper<DiscussziyuangongxiangEntity> wrapper);

	List<DiscussziyuangongxiangView> selectListView(Pagination page,@Param("ew") Wrapper<DiscussziyuangongxiangEntity> wrapper);
	
	DiscussziyuangongxiangView selectView(@Param("ew") Wrapper<DiscussziyuangongxiangEntity> wrapper);
	

}
