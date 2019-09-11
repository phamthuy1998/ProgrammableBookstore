package phamthuy.ptithcm.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("upload")
public class UploadController {

	@RequestMapping("simple")
	public String simple() {
		return "upload";
	}

	private static String upload(String path, MultipartFile part) throws IOException {
		String fileName;
		try (InputStream is = part.getInputStream()) {
			fileName = part.getOriginalFilename().replaceAll("\\s", "_");
			try (OutputStream os = new FileOutputStream(new File(path + fileName))) {
				int len = 0;
				byte[] bytes = new byte[1024];
				while ((len = is.read(bytes, 0, 1024)) > 0) {
					os.write(bytes, 0, len);
				}
			}
		}
		return fileName;
	}

	@RequestMapping(value = "simple", method = RequestMethod.POST)
	public String simple(Model model, @RequestParam("f") MultipartFile part, HttpServletRequest request) {
		try {
			String path = request.getServletContext().getRealPath("/upload/");
			String name = upload(path, part);
			model.addAttribute("name", name);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "upload";
	}

	@RequestMapping("multi")
	public String multi() {
		return "multiupload";
	}

	@RequestMapping(value = "multi", method = RequestMethod.POST)
	public String multi(Model model, @RequestParam("f") MultipartFile[] parts, HttpServletRequest request) {
		String path = request.getServletContext().getRealPath("/upload/");
		try {
			model.addAttribute("list", upload(path, parts));
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "multiupload";
	}

	private static List<String> upload(String path, MultipartFile[] parts) throws IOException {
		List<String> files = new ArrayList<String>(parts.length);
		for (MultipartFile part : parts) {
			String file = upload(path, part);
			files.add(file);
		}
		return files;
	}
}
