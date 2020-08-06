package com.xiaoshu.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.xiaoshu.dao.CategoryMapper;
import com.xiaoshu.dao.ContentMapper;
import com.xiaoshu.dao.UserMapper;
import com.xiaoshu.entity.Category;
import com.xiaoshu.entity.Content;
import com.xiaoshu.entity.ContentVo;

import com.xiaoshu.entity.User;
import com.xiaoshu.entity.UserExample;
import com.xiaoshu.entity.UserExample.Criteria;

@Service
public class ContentService {

	@Autowired
	ContentMapper contentMapper;
	
	@Autowired
	CategoryMapper categoryMapper;
	public List<Category>findCategory(){
		return categoryMapper.selectAll();
	}
	
	public PageInfo<ContentVo> findPage(ContentVo contentVo,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<ContentVo>list = 	contentMapper.findList(contentVo);
		return new PageInfo<>(list);
	}
	
	
	
	
	
	
	
	
	
	
	
	public Content findContenttile(String contenttile){
		Content param = new Content();
		param.setContenttile(contenttile);
		return contentMapper.selectOne(param);
	}
	
	public void addContent(Content content){
		content.setCreatetime(new Date());
		contentMapper.insert(content);
		
	}
	public void updateContent(Content Ccntent){
		contentMapper.updateByPrimaryKeySelective(Ccntent);
	}
	public void deleteContent(Integer contentid){
		contentMapper.deleteByPrimaryKey(contentid);
	}
	
	
	
	
	public void importContent(MultipartFile contentFile) throws InvalidFormatException, IOException{
		//导入业务
		//获取工作对象03  07
		Workbook workbook = WorkbookFactory.create(contentFile.getInputStream());
		//工作对象
		Sheet sheet = workbook.getSheetAt(0);
		
		int rowNum = sheet.getLastRowNum();
		
		for (int i = 0; i < rowNum; i++) {
			Row row = sheet.getRow(i+1);
			
			String contenttile = row.getCell(0).toString();
			String cname = row.getCell(1).toString();
			String contenurl = row.getCell(2).toString();
			String price = row.getCell(3).toString();
			String status = row.getCell(4).toString();
			Date createtime = row.getCell(5).getDateCellValue();
			
			
		if (contenttile.equals("清仓处理") && "品牌广告".equals(cname)) {
			
		
				Content c = new Content();
				c.setContenttile(contenttile);
				c.setContenurl(contenurl);
				c.setPrice(price);
				c.setStatus(status);
				c.setCreatetime(new Date());
				
				
				Category param = new Category();
				param.setCategoryname(cname);
				Category category = categoryMapper.selectOne(param);
				c.setContentcategoryid(category.getContentcategoryid());
				
				contentMapper.insert(c);
			
		}
		}
		
	}

}
