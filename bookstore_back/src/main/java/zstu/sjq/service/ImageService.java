package zstu.sjq.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public interface ImageService {
	
	public String uploadFile(MultipartFile file);

}
