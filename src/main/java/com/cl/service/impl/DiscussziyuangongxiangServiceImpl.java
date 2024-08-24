package com.cl.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.cl.utils.PageUtils;
import com.cl.utils.Query;


import com.cl.dao.DiscussziyuangongxiangDao;
import com.cl.entity.DiscussziyuangongxiangEntity;
import com.cl.service.DiscussziyuangongxiangService;
import com.cl.entity.view.DiscussziyuangongxiangView;

@Service("discussziyuangongxiangService")
public class DiscussziyuangongxiangServiceImpl extends ServiceImpl<DiscussziyuangongxiangDao, DiscussziyuangongxiangEntity> implements DiscussziyuangongxiangService {
	
	
    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussziyuangongxiangEntity> page = this.selectPage(
                new Query<DiscussziyuangongxiangEntity>(params).getPage(),
                new EntityWrapper<DiscussziyuangongxiangEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussziyuangongxiangEntity> wrapper) {
		  Page<DiscussziyuangongxiangView> page =new Query<DiscussziyuangongxiangView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
	@Override
	public List<DiscussziyuangongxiangView> selectListView(Wrapper<DiscussziyuangongxiangEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussziyuangongxiangView selectView(Wrapper<DiscussziyuangongxiangEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}


}
