package com.cl.controller;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletRequest;

import com.cl.utils.ValidatorUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.cl.annotation.IgnoreAuth;

import com.cl.entity.DiscussziyuangongxiangEntity;
import com.cl.entity.view.DiscussziyuangongxiangView;

import com.cl.service.DiscussziyuangongxiangService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 资源共享评论表
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/discussziyuangongxiang")
public class DiscussziyuangongxiangController {
    @Autowired
    private DiscussziyuangongxiangService discussziyuangongxiangService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,DiscussziyuangongxiangEntity discussziyuangongxiang,
		HttpServletRequest request){
        EntityWrapper<DiscussziyuangongxiangEntity> ew = new EntityWrapper<DiscussziyuangongxiangEntity>();

		PageUtils page = discussziyuangongxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuangongxiang), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,DiscussziyuangongxiangEntity discussziyuangongxiang, 
		HttpServletRequest request){
        EntityWrapper<DiscussziyuangongxiangEntity> ew = new EntityWrapper<DiscussziyuangongxiangEntity>();

		PageUtils page = discussziyuangongxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuangongxiang), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( DiscussziyuangongxiangEntity discussziyuangongxiang){
       	EntityWrapper<DiscussziyuangongxiangEntity> ew = new EntityWrapper<DiscussziyuangongxiangEntity>();
      	ew.allEq(MPUtil.allEQMapPre( discussziyuangongxiang, "discussziyuangongxiang")); 
        return R.ok().put("data", discussziyuangongxiangService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(DiscussziyuangongxiangEntity discussziyuangongxiang){
        EntityWrapper< DiscussziyuangongxiangEntity> ew = new EntityWrapper< DiscussziyuangongxiangEntity>();
 		ew.allEq(MPUtil.allEQMapPre( discussziyuangongxiang, "discussziyuangongxiang")); 
		DiscussziyuangongxiangView discussziyuangongxiangView =  discussziyuangongxiangService.selectView(ew);
		return R.ok("查询资源共享评论表成功").put("data", discussziyuangongxiangView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        DiscussziyuangongxiangEntity discussziyuangongxiang = discussziyuangongxiangService.selectById(id);
		discussziyuangongxiang = discussziyuangongxiangService.selectView(new EntityWrapper<DiscussziyuangongxiangEntity>().eq("id", id));
        return R.ok().put("data", discussziyuangongxiang);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        DiscussziyuangongxiangEntity discussziyuangongxiang = discussziyuangongxiangService.selectById(id);
		discussziyuangongxiang = discussziyuangongxiangService.selectView(new EntityWrapper<DiscussziyuangongxiangEntity>().eq("id", id));
        return R.ok().put("data", discussziyuangongxiang);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody DiscussziyuangongxiangEntity discussziyuangongxiang, HttpServletRequest request){
    	discussziyuangongxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussziyuangongxiang);
        discussziyuangongxiangService.insert(discussziyuangongxiang);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody DiscussziyuangongxiangEntity discussziyuangongxiang, HttpServletRequest request){
    	discussziyuangongxiang.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(discussziyuangongxiang);
        discussziyuangongxiangService.insert(discussziyuangongxiang);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    @IgnoreAuth
    public R update(@RequestBody DiscussziyuangongxiangEntity discussziyuangongxiang, HttpServletRequest request){
        //ValidatorUtils.validateEntity(discussziyuangongxiang);
        discussziyuangongxiangService.updateById(discussziyuangongxiang);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        discussziyuangongxiangService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	
	/**
     * 前端智能排序
     */
	@IgnoreAuth
    @RequestMapping("/autoSort")
    public R autoSort(@RequestParam Map<String, Object> params,DiscussziyuangongxiangEntity discussziyuangongxiang, HttpServletRequest request,String pre){
        EntityWrapper<DiscussziyuangongxiangEntity> ew = new EntityWrapper<DiscussziyuangongxiangEntity>();
        Map<String, Object> newMap = new HashMap<String, Object>();
        Map<String, Object> param = new HashMap<String, Object>();
		Iterator<Map.Entry<String, Object>> it = param.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry<String, Object> entry = it.next();
			String key = entry.getKey();
			String newKey = entry.getKey();
			if (pre.endsWith(".")) {
				newMap.put(pre + newKey, entry.getValue());
			} else if (StringUtils.isEmpty(pre)) {
				newMap.put(newKey, entry.getValue());
			} else {
				newMap.put(pre + "." + newKey, entry.getValue());
			}
		}
		params.put("sort", "clicktime");
        params.put("order", "desc");
		PageUtils page = discussziyuangongxiangService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, discussziyuangongxiang), params), params));
        return R.ok().put("data", page);
    }








}
