/**
 * 
 */
package com.dhht.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.dhht.entity.User;


/**
 * web层工具类
 * 
 * 
 */
public class WebUtil {

    private static ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();

    /**
     * 设置登录用户
     * 
     * @param user
     */
    public static void setLoginUser(User user) {
        getSession().setAttribute("loginUser", user);
    }

    /**
     * 获取登录用户
     * 
     * @return
     */
    public static User getLoginUser() {
        return (User) getSession().getAttribute("loginUser");
    }

    /**
     * 获取登录者id
     * 
     * @return
     */
    public static String getLoginUserId() {
        return getLoginUser().getId();
    }

    /**
     * 获取session
     * 
     * @return
     */
    public static HttpSession getSession() {
        return getRequest().getSession();
    }

    /**
     * 获取客户端ip
     * 
     */
    public static String getRemoteIp() {
        return getRequest().getRemoteAddr();
    }

    /**
     * 获取response
     * 
     * @return
     */
    public static HttpServletResponse getResponse() {
        return attributes.getResponse();
    }

    /**
     * 获取request
     * 
     * @return
     */
    public static HttpServletRequest getRequest() {
    	return attributes.getRequest();
    }

    public static void outputStream(InputStream inputStream, String fileName, long length) throws IOException {
        byte[] buffer = new byte[inputStream.available()];
        inputStream.read(buffer);
        inputStream.close();
        // 清空response
        HttpServletResponse response = getResponse();
        response.reset();
        if(StringUtils.isNotBlank(fileName)) {
         // 设置response的Header
            String encodedFileName = new String(fileName.getBytes("GBK"), "ISO-8859-1");
            //由于火狐下 下载有带空格的文件  文件名被截取  删除;filename*=utf-8''" + encodedFileName 就恢复正常
//            response.setHeader("Content-Disposition", "attachment;filename=\"" + encodedFileName + "\";filename*=utf-8''" + encodedFileName);
            response.setHeader("Content-Disposition", "attachment;filename=\"" + encodedFileName + "\"");
        }
        if(length > 0) {
            response.addHeader("Content-Length", "" + length);
        }
        response.setCharacterEncoding("UTF-8");
        OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
        response.setContentType("application/octet-stream;charset=UTF-8");
        toClient.write(buffer);
        toClient.flush();
        toClient.close();
    }

    /**
     * 获取布尔型参数
     * @param name
     * @return 如果对应参数为空串或null返回null
     */
    public static Boolean getBooleanParameter(String name) {
        Boolean b = null;
        String bStr = getRequest().getParameter(name);
        if(StringUtils.isNotBlank(bStr)) {
            b = Boolean.valueOf(bStr);
        }
        return b;
    }
}
