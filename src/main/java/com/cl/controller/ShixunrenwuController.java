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

import com.cl.entity.ShixunrenwuEntity;
import com.cl.entity.view.ShixunrenwuView;

import com.cl.service.ShixunrenwuService;
import com.cl.service.TokenService;
import com.cl.utils.PageUtils;
import com.cl.utils.R;
import com.cl.utils.EncryptUtil;
import com.cl.utils.MPUtil;
import com.cl.utils.CommonUtil;
import java.io.IOException;

/**
 * 实训任务
 * 后端接口
 * @author 
 * @email 
 * @date 2024-03-09 23:39:10
 */
@RestController
@RequestMapping("/shixunrenwu")
public class ShixunrenwuController {
    @Autowired
    private ShixunrenwuService shixunrenwuService;



    


    /**
     * 后端列表
     */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params,ShixunrenwuEntity shixunrenwu,
		HttpServletRequest request){
        EntityWrapper<ShixunrenwuEntity> ew = new EntityWrapper<ShixunrenwuEntity>();

		PageUtils page = shixunrenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunrenwu), params), params));

        return R.ok().put("data", page);
    }
    
    /**
     * 前端列表
     */
	@IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params,ShixunrenwuEntity shixunrenwu, 
		HttpServletRequest request){
        EntityWrapper<ShixunrenwuEntity> ew = new EntityWrapper<ShixunrenwuEntity>();

		PageUtils page = shixunrenwuService.queryPage(params, MPUtil.sort(MPUtil.between(MPUtil.likeOrEq(ew, shixunrenwu), params), params));
        return R.ok().put("data", page);
    }

	/**
     * 列表
     */
    @RequestMapping("/lists")
    public R list( ShixunrenwuEntity shixunrenwu){
       	EntityWrapper<ShixunrenwuEntity> ew = new EntityWrapper<ShixunrenwuEntity>();
      	ew.allEq(MPUtil.allEQMapPre( shixunrenwu, "shixunrenwu")); 
        return R.ok().put("data", shixunrenwuService.selectListView(ew));
    }

	 /**
     * 查询
     */
    @RequestMapping("/query")
    public R query(ShixunrenwuEntity shixunrenwu){
        EntityWrapper< ShixunrenwuEntity> ew = new EntityWrapper< ShixunrenwuEntity>();
 		ew.allEq(MPUtil.allEQMapPre( shixunrenwu, "shixunrenwu")); 
		ShixunrenwuView shixunrenwuView =  shixunrenwuService.selectView(ew);
		return R.ok("查询实训任务成功").put("data", shixunrenwuView);
    }
	
    /**
     * 后端详情
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        ShixunrenwuEntity shixunrenwu = shixunrenwuService.selectById(id);
		shixunrenwu = shixunrenwuService.selectView(new EntityWrapper<ShixunrenwuEntity>().eq("id", id));
        return R.ok().put("data", shixunrenwu);
    }

    /**
     * 前端详情
     */
	@IgnoreAuth
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id){
        ShixunrenwuEntity shixunrenwu = shixunrenwuService.selectById(id);
		shixunrenwu = shixunrenwuService.selectView(new EntityWrapper<ShixunrenwuEntity>().eq("id", id));
        return R.ok().put("data", shixunrenwu);
    }
    



    /**
     * 后端保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody ShixunrenwuEntity shixunrenwu, HttpServletRequest request){
    	shixunrenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunrenwu);
        shixunrenwuService.insert(shixunrenwu);
        return R.ok();
    }
    
    /**
     * 前端保存
     */
    @RequestMapping("/add")
    public R add(@RequestBody ShixunrenwuEntity shixunrenwu, HttpServletRequest request){
    	shixunrenwu.setId(new Date().getTime()+new Double(Math.floor(Math.random()*1000)).longValue());
    	//ValidatorUtils.validateEntity(shixunrenwu);
        shixunrenwuService.insert(shixunrenwu);
        return R.ok();
    }



    /**
     * 修改
     */
    @RequestMapping("/update")
    @Transactional
    public R update(@RequestBody ShixunrenwuEntity shixunrenwu, HttpServletRequest request){
        //ValidatorUtils.validateEntity(shixunrenwu);
        shixunrenwuService.updateById(shixunrenwu);//全部更新
        return R.ok();
    }



    

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        shixunrenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
    
	








}
