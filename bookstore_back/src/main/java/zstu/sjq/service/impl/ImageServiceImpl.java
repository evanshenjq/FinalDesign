package zstu.sjq.service.impl;


import java.util.Date;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import zstu.sjq.service.ImageService;
import zstu.sjq.utils.FtpUtil;
import zstu.sjq.utils.IDUtils;
@Service
public class ImageServiceImpl implements ImageService {
	
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	@Value("${FTP_USERNAME}")
	private String FTP_USERNAME;
	@Value("${FTP_PASSWORD}")
	private String FTP_PASSWORD;
	@Value("${FTP_BASE_PATH}")
	private String FTP_BASE_PATH;
	@Value("${IMAGE_BASE_URL}")
	private String IMAGE_BASE_URL;

	@Override
	public String uploadFile(MultipartFile file) {
		String url="";
		try {
			//生成一个新的图片名字
			//取原始文件名
			String oldName=file.getOriginalFilename();
			String nameSuffix=oldName.substring(oldName.lastIndexOf("."));
			String newName=IDUtils.genImageName()+nameSuffix;
			
			//图片上传
			String imagePath=new DateTime().toString("/yyyy/MM/dd");
			//String imagePath="/";
			boolean result=FtpUtil.uploadFile(FTP_ADDRESS, FTP_PORT, FTP_USERNAME,
					FTP_PASSWORD, FTP_BASE_PATH, 
					imagePath, newName, file.getInputStream());
			//返回结果
			if(result) {
				url=IMAGE_BASE_URL+imagePath+"/"+newName;
				return url;
			}else {
				return "error";
			}
		} catch (Exception e) {
			return "error";
		}
	}

}
