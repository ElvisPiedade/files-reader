package br.poa.ibm.webapp.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.poa.ibm.webapp.domain.File;
import br.poa.ibm.webapp.repository.FileRepository;

@Service
public class FileService {

	private final FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	public Map<String, List<String>> save(File file, Set<MultipartFile> myFile) throws IOException {
		Map<String, List<String>> values = new HashMap<>();
		List<String> listVendor = new ArrayList<String>();
		List<String> listCustomer = new ArrayList<String>();
		List<String> listSale = new ArrayList<String>();
		values.put("001", listVendor);
		values.put("002", listCustomer);
		values.put("003", listSale);

		Map<String, List<String>> copy = new HashMap<>();

		for (MultipartFile f : myFile) {
			if (f.getOriginalFilename().substring(f.getOriginalFilename().length() - 4).equals(".dat")) {
				file = File.builder().content(f.getBytes()).contentType(f.getContentType()).createdOn(new Date())
						.build();

				fileRepository.save(file);

				copy.putAll(readFile(file));
				listVendor = copy.get("001");
				listCustomer = copy.get("002");
				listSale = copy.get("003");

				values.get("001").addAll(copy.get("001"));
				values.get("002").addAll(copy.get("002"));
				values.get("003").addAll(copy.get("003"));
			}
		}

		return values;

	}

	public Map<String, List<String>> readFile(File file) throws IOException {
		String s = new String(file.getContent(), "ISO-8859-1");
		String lines[] = s.split("\\r?\\n");
		List<String> listVendor = new ArrayList<String>();
		List<String> listCustomer = new ArrayList<String>();
		List<String> listSale = new ArrayList<String>();
		Map<String, List<String>> values = new HashMap<>();

		for (String string : lines) {
			String att[] = string.split("ç");

			if (att.length == 4) {
				switch (att[0]) {
				case "001":
					listVendor.add(string);
					break;
				case "002":
					listCustomer.add(string);
					break;
				case "003":
					listSale.add(string);
					break;
				default:
					System.out.println("printa alguma coisa");
				}

			}

		}
		values.put("001", listVendor);
		values.put("002", listCustomer);
		values.put("003", listSale);

		return values;

	}

}
