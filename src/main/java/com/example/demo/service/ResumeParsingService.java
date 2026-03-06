
package com.example.demo.service;

import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

    @Service
    public class ResumeParsingService {

        public String extractTextFromDocx(MultipartFile file) {

            StringBuilder text = new StringBuilder();

            try {
                InputStream inputStream = file.getInputStream();
                XWPFDocument document = new XWPFDocument(inputStream);

                for (XWPFParagraph paragraph : document.getParagraphs()) {
                    text.append(paragraph.getText()).append("\n");
                }

                document.close();
            } catch (Exception e) {
                throw new RuntimeException("Failed to parse DOCX resume");
            }

            return text.toString();
        }




    }


