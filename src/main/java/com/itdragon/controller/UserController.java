package com.itdragon.controller;

import com.itdragon.bean.QueryBean;
import com.itdragon.bean.UserBean;
import com.itdragon.pojo.Result;
import com.itdragon.pojo.User;
import com.itdragon.service.UserService;
import com.itdragon.utils.ExcelUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.wuwz.poi.ExcelKit;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.security.InvalidParameterException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @Author: tyk
 * @Date: 2019/5/21 09:53
 * @Description:
 */
@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Autowired
    public UserService userService;

    private static final transient Logger logger = LoggerFactory.getLogger(UserController.class);


    @RequestMapping("")
    public String employee() {
        return "employees/manageEmployees";
    }

    /**
     * 列表展示
     *
     * @param bean
     * @return
     */
    @RequestMapping("/list")
    @ResponseBody
    public Result employeeList(QueryBean bean) {
        logger.info("用户列表查询：controller");
        return userService.getPageUsers(bean);
    }

    @RequestMapping("/delete")
    @RequiresPermissions(value = "user:delete")
    @ResponseBody
    public void deleteEmployee(@RequestParam(value = "ids") String[] ids) {
        if (ObjectUtils.isEmpty(ids)) {
            throw new InvalidParameterException("请选择要删除的行");
        }
        userService.deleteUsers(ids);
    }

    @RequestMapping("/add")
    @RequiresPermissions(value = "user:add")
    @ResponseBody
    public void addEmployee(@RequestBody UserBean userBean) {
        if (userBean.getAccount() == null) {
            return;
        }

        //判断用户是否存在

//        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
//        userBean.setId(user.getId());
        User user = new User();
        BeanUtils.copyProperties(userBean, user);

        String[] roleIds = userBean.getRoleIds();

        userService.addUser(user,roleIds);//添加用户信息
    }

    @RequestMapping("/update")
    @RequiresPermissions(value = "user:update")
    @ResponseBody
    public void updateEmployee(@RequestBody UserBean userBean) {
        if (userBean.getAccount() == null) {
            return;
        }
        User user = new User();
        BeanUtils.copyProperties(userBean, user);

        userService.updateUser(user);
    }

    @RequestMapping("/view/{userId}")
    @ResponseBody
    public User findEmployee(@PathVariable String userId) {
        User user = userService.findById(userId);
        return user;
    }

    public String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        String uuidStr = str.replace("-", "");
        return uuidStr;
    }

    @RequestMapping("/export")
    @ResponseBody
    public String exportExcel(QueryBean bean, HttpServletResponse response) throws IOException {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheet = workbook.createSheet("员工信息表");

//        不分页输出
        List<User> list = userService.getUsers(bean);

        ExcelKit.$Export(User.class, response).toExcel(list, "用户信息表");

//        HSSFRow row0 = sheet.createRow(0);
//        HSSFCell cell = row0.createCell(0);
//
//        //填充表格表头
//        cell.setCellValue("编号");
//
//        //填充表格内容
//
//
//        response.setHeader("Content-Disposition", "attachment;filename=" + new String("用户基本信息1".getBytes("gbk"), "iso8859-1") + ".xls");
//        response.setHeader("Connection", "close");
//        response.setHeader("Content-Type", "application/vnd.ms-excel");
//
////        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
//        OutputStream outputStream = null;
//        try {
////            outputStream = new FileOutputStream("d:\\workbook.xls");
//            outputStream = response.getOutputStream();
//            workbook.write(outputStream);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }finally {
//            outputStream.flush();
//            outputStream.close();
//        }

        return null;
    }

    @PostMapping("/import")
    @ResponseBody
    public String upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) throws Exception {
        User user = (User) SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal();
        try {
            //excel文件内容解析
            List<List<String>> lists = ExcelUtils.getLists(file, 0);

            //内容保存到数据库
            userService.importData(lists,user);
            return "上传成功 ！！！";
        } catch (Exception e) {
            logger.info(e.getMessage());
            return "上传失败 ！！！";
        }

//            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + fileName);
//            if (!saveFile.getParentFile().exists()) {
//                saveFile.getParentFile().mkdirs();
//            }
//            try {
//                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));
//                out.write(file.getBytes());
//                out.flush();
//                out.close();
//                return "上传成功";
////                return ResultUtils.buildResult(saveFile.getName() + " 上传成功");
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
////                return ResultUtils.buildResult("上传失败," + e.getMessage());
//                return "上传失败";
//            } catch (IOException e) {
//                e.printStackTrace();
////                return ResultUtils.buildResult("上传失败," + e.getMessage());
//                return "上传失败";
//            }

    }
}