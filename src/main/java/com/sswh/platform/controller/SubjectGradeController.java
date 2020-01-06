package com.sswh.platform.controller;

import cn.hutool.json.JSONObject;
import com.sswh.entity.GradeConfig;
import com.sswh.entity.SubjectGrade;
import com.sswh.front.entity.FrontUserEntity;
import com.sswh.platform.service.SubjectGradeService;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.Date;
import java.util.Hashtable;
import java.util.List;

@Controller
@RequestMapping(value="subjectGrade")
public class SubjectGradeController extends HttpServlet {

    @Autowired
    SubjectGradeService gradeService;

    // 保存文件的目录
    private static String PATH_FOLDER = "D:/source/aaa";
    // 存放临时文件的目录
    private static String TEMP_FOLDER = "D:/source/bbb";


    /**
     * Constructor of the object.
     */
    public SubjectGradeController() {
        super();
    }

    /**
     * Destruction of the servlet. <br>
     */
    public void destroy() {
        super.destroy(); // Just puts "destroy" string in log
        // Put your code here
    }



    @RequestMapping(value="/subjectGradeList")
    public ModelAndView gotoGradeList() {

        ModelAndView modelAndView = new ModelAndView("sswh/platform/subjectGrade/subjectGradeList");
        return modelAndView;
    }

    @RequestMapping(value="/uploadPics")
    public ModelAndView uploadPics() {
        System.out.println("hello world");
        ModelAndView modelAndView = new ModelAndView("sswh/platform/subjectGrade/uploadPics");
        return modelAndView;
    }

    @RequestMapping(value="/addStudentGrade")
    public ModelAndView addStudentGrade() {
        System.out.println("hello world");
        ModelAndView modelAndView = new ModelAndView("sswh/platform/subjectGrade/addStudentGrade");
        return modelAndView;
    }

    @RequestMapping(value="/upload",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject upload(HttpServletRequest request, HttpServletResponse response) {

        JSONObject jsonobj = new JSONObject();
        int returnTag = -1;
        String saveName=null;
        //上传的文件名
        String filename=null;
        //String id = request.getParameter("ID");
       // System.out.println("id============="+id);
        try {
            System.out.println("==========以下为上传代码============");
            request.setCharacterEncoding("utf-8"); // 设置编码
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            // 获得磁盘文件条目工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();

            // 如果没以下两行设置的话，上传大的 文件 会占用 很多内存，
            // 设置暂时存放的 存储室 , 这个存储室，可以和 最终存储文件 的目录不同
            /**
             * 原理 它是先存到 暂时存储室，然后在真正写到 对应目录的硬盘上， 按理来说 当上传一个文件时，其实是上传了两份，第一个是以
             * .tem 格式的 然后再将其真正写到 对应目录的硬盘上
             */
            factory.setRepository(new File(TEMP_FOLDER));
            // 设置 缓存的大小，当上传文件的容量超过该缓存时，直接放到 暂时存储室
            factory.setSizeThreshold(1024 * 1024);

            // 高水平的API文件上传处理
            ServletFileUpload upload = new ServletFileUpload(factory);

            // 提交上来的信息都在这个list里面
            // 这意味着可以上传多个文件
            // 请自行组织代码
            List<FileItem> list = upload.parseRequest(request);
            System.out.println("size:"+list.size());
            // 获取上传的文件
            for (FileItem file : list) {
                FileItem item = file;
                // 获取文件名
                filename = getUploadFileName(item);
                System.out.println("获取的文件名============================"
                        + filename);
                String suffix = filename
                        .substring(filename.lastIndexOf(".") + 1);
                System.out
                        .println("获取的文件后缀名=========================" + suffix);
                String[] regular = { "JPG", "GIF","PNG","JPEG" ,"BMP"};
                boolean flag = false;
                // 判断文件格式是否合法
                for (String str : regular) {
                    if (suffix.equalsIgnoreCase(str)) {
                        flag = true;
                    }
                }
                if (!flag) {
                    returnTag = 0;
                    throw new Exception("文件格式不合法！");
                }

                // 保存后的文件名
                saveName = new Date().getTime()
                        + filename.substring(filename.lastIndexOf("."));
                // 保存后图片的浏览器访问路径
               // String picUrl = App.UPLOAD_SAVE_IMG_URL+saveName;

                System.out.println("存放目录:=================================="
                        + PATH_FOLDER);
                System.out.println("文件名:===================================="
                        + filename);
                /*System.out.println("浏览器访问路径:============================="
                        + picUrl);*/

                // 真正写到磁盘上
                item.write(new File(PATH_FOLDER, saveName)); // 第三方提供的

            }
            System.out.println("==========以上为上传代码=============");
            if (returnTag != -1) {
                // 请求失败
                jsonobj.put("STATUS", "1");
            } else {
                jsonobj.put("code", 0);
            }

        } catch (Exception e) {
            e.printStackTrace();
            jsonobj.put("errorCode", 0);


        }


        return jsonobj;
    }

    @RequestMapping(value="/findByFrontUsername",method = RequestMethod.POST,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject findByFrontUsername(String username,String month,String grade,int limit,int page) {

        String subjects = "chinese,math,english,physics,chemistry,history,geography,biology,polity";
        if(!"".equals(grade)){
            GradeConfig gradeConfig = gradeService.getGradeConfig(grade);
            subjects = gradeConfig.getSubject();
        }
        List<SubjectGrade> gradeList = gradeService.findByFrontUsername(username,month,grade,subjects,(page-1)*limit,limit);
        int pageCount = gradeService.getStudentScoreCount(username,month,grade,subjects);
        JSONObject json = new JSONObject();
        json.put("code","0");
        json.put("msg","");
        json.put("count",pageCount);
        json.put("data", gradeList);

        return json;
    }

    @RequestMapping(value="/getGradeList",method = RequestMethod.GET,produces = "application/json;charset=utf-8")
    @ResponseBody
    public JSONObject getGradeList() {

        List<GradeConfig> gradeList = gradeService.getGradeList();
        JSONObject json = new JSONObject();
        json.put("data", gradeList);

        return json;
    }

    @RequestMapping(value="/updateSubjectGrade")
    @ResponseBody
    public void updateSubjectGrade(String iid,String subject,String grade) {

        gradeService.updateSubjectGrade(iid,subject,grade);

    }

    @RequestMapping(value="/addSubjectGrade")
    @ResponseBody
    public JSONObject addSubjectGrade(String name,String month,String chinese,String math,String english,String biology,String physics,String chemistry,String history,String geography,String polity,String times,String grade) {

       boolean success =  gradeService.addSubjectGrade(name,month,chinese,math,english,biology,physics,chemistry,history,geography,polity,times,grade);
       JSONObject json = new JSONObject();
        json.put("success",success);
        return json;
    }

    @RequestMapping(value="/deleteSubjectGrade")
    @ResponseBody
    public JSONObject deleteSubjectGrade(String ids) {

        boolean success =  gradeService.deleteSubjectGrade(ids);
        JSONObject json = new JSONObject();
        json.put("success",success);
        return json;
    }

    private String getUploadFileName(FileItem item) {
        // 获取路径名
        String value = item.getName();
        String filename = "";
        System.out.println("item:"+item.getName());
        // 索引到最后一个反斜杠
        if(value==null||value.indexOf("/")==-1){
            filename = value;
        }else{
            int start = value.lastIndexOf("/");
            // 截取 上传文件的 字符串名字，加1是 去掉反斜杠，
            filename = value.substring(start + 1);
        }

        System.out.println("filename:"+filename);
        return filename;
    }

    /**
     * Initialization of the servlet. <br>
     *
     * @throws ServletException if an error occurs
     */
    public void init(ServletConfig config) throws ServletException {
        ServletContext servletCtx = config.getServletContext();
        // 初始化路径
        // 缩略图保存路径
        PATH_FOLDER = "D:/source/aaa";
        System.out.println("保存缩略图的目录===========" + PATH_FOLDER);
        // 存放临时文件的目录,存放xxx.tmp文件的目录
        TEMP_FOLDER = servletCtx.getRealPath("/temp");
        System.out.println("存放临时文件的目录===========" + TEMP_FOLDER);
        File dir = new File(PATH_FOLDER);
        if (!dir.isDirectory()) {
            dir.mkdir();
        }
        File dir2 = new File(TEMP_FOLDER);
        if (!dir2.isDirectory()) {
            dir2.mkdir();
        }
    }


}
