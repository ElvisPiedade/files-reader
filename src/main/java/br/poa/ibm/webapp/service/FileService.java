package br.poa.ibm.webapp.service;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.stereotype.Service;

import br.poa.ibm.webapp.domain.File;
import br.poa.ibm.webapp.domain.Vendor;
import br.poa.ibm.webapp.repository.FileRepository;

@Service
public class FileService {

	private final FileRepository fileRepository;

	public FileService(FileRepository fileRepository) {
		this.fileRepository = fileRepository;
	}

	public void save(File file) {
		fileRepository.save(file);


	}




}
