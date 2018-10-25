package br.com.service;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectListing;
import com.amazonaws.services.s3.model.PutObjectRequest;

@Service
public class DocumentoService {

	@Autowired
	private AmazonS3 amazonS3;

	private static final String BUCKET = "xxxxx";
	private static final String SITE = "http://s3.amazonaws.com/";

	public String salvar(String cnpj, MultipartFile arquivo) {
		String url = "";
		try {
			amazonS3.putObject(
					new PutObjectRequest(BUCKET, cnpj+"/"+ arquivo.getOriginalFilename(), arquivo.getInputStream(), null)
							.withCannedAcl(CannedAccessControlList.Private));
			url = SITE + BUCKET +"/"+cnpj+"/"+ arquivo.getOriginalFilename();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return url;
	}
	
	public ObjectListing buscarDocumento(String cnpj) {
		return amazonS3.listObjects(BUCKET, cnpj+"/");
	}
	
	

}
