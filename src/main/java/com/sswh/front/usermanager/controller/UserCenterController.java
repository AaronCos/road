package com.sswh.front.usermanager.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static org.apache.commons.fileupload.FileUploadBase.CONTENT_TYPE;

/**
 * Created by wangchengcheng on 2019/6/26
 */
@Controller
@RequestMapping("upload")
public class UserCenterController {

    @RequestMapping("showUploadImage")
    public ModelAndView uploadImage(){
        ModelAndView mv = new ModelAndView("front/fileupload");
        return mv;
    }
    @RequestMapping("doUploadImage")
    public void fileDeal(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType(CONTENT_TYPE);
        PrintWriter out = null;
        try {
            out = response.getWriter();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //临时缓冲文件目录,此处系统默认
            File tempfile = new File(System.getProperty("java.io.tmpdir"));
            DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
            // 设置最多只允许在内存中存储的数据,单位:字节
            diskFileItemFactory.setSizeThreshold(4096);
            //设置缓冲区目录,一旦文件大小超过getSizeThreshold()的值时数据存放在硬盘的目录
            diskFileItemFactory.setRepository(tempfile);
            ServletFileUpload upload = new ServletFileUpload(diskFileItemFactory);
            //DiskFileUpload upload = new DiskFileUpload(diskFileItemFactory);
            //设置编码，解决上传文件名乱码
            upload.setHeaderEncoding("UTF-8");
            // 设置允许用户上传文件大小,单位:字节，这里设为2M
            upload.setSizeMax(2 * 1024 * 1024);
            //开始读取上传信息
            List fileItems = upload.parseRequest(request);
            // 依次处理每个上传的文件
            Iterator iter = fileItems.iterator();
            //正则匹配，过滤路径取文件名
            String regExp = ".+(\\..+)$";
            //过滤掉的文件类型
            String[] errorType = {
                    ".exe", ".com", ".cgi", ".asp"};
            Pattern p = Pattern.compile(regExp);
            while (iter.hasNext()) {
                FileItem item = (FileItem) iter.next();
                //忽略其他不是文件域的所有表单信息
                if (!item.isFormField()) {
                    String name = item.getName();
                    long size = item.getSize();
                    if (name.isEmpty() && size == 0) {
                        continue;
                    }
                    Matcher m = p.matcher(name);
                    boolean result = m.find();
                    if (result) {
                        for (int temp = 0; temp < errorType.length; temp++) {
                            if (m.group(1).substring(1).endsWith(errorType[temp])) {
                                throw new IOException(name + ": wrong type");
                            }
                        }
                        //保存上传的文件到指定的目录
                        //在下文中上传文件至数据库时，将对这里改写
                        item.write(new File("d:\\" + m.group(0)));
                        out.print(name + " " + size + "");
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (FileUploadException e) {
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}
