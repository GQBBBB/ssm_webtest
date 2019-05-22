package com.gqb.controller;

import com.gqb.pojo.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
//@RestController //等于@Controller + @ResponseBody
@RequestMapping("/web")
public class WebElementController {

    @RequestMapping("request")
    public String request1(HttpServletRequest httpServletRequest){
        httpServletRequest.setAttribute("name", "request_gqb");//存储在request域中
        return "girl";
    }

    @RequestMapping("session")
    public String request2(HttpSession httpSession){
        httpSession.setAttribute("name", "session_gqb");//存储在session域中
        httpSession.getServletContext().setAttribute("name", "context_gqb");//存储在context域中，即使不一个session也可以访问（用另一个浏览器访问index.jsp可显示）
        return "girl";
    }
//    @RequestMapping(value = {"many1", "many2"}, method = RequestMethod.GET)
    @RequestMapping(path = {"many1", "many2"}, method = RequestMethod.GET)//限定get方法，默认全部方法, path作用等同于value
    public String request3(Model model){
        model.addAttribute("name", "many");
        return "girl";
    }

    @RequestMapping(path = {"many"}, params = {"param1", "param2"})//通过../web/many?param1=a&param2=b访问
    public String request4(Model model){
        model.addAttribute("name", "many");
        return "girl";
    }

    /*问号匹配出斜杠问号之外的任意一个字符（英文句号可以匹配多个）*/
//    @RequestMapping(path = {"aa?"})

    /*星号匹配出任意多个字符（斜杠之后如果有字符也不能匹配）*/
//    @RequestMapping(path = {"aa*"})

    /*斜杠加星号匹配出任意多个字符单层路径*/
//    @RequestMapping(path = {"aa/*"})

    /*斜杠加两个星号匹配出任意多个字符多层路径*/
    @RequestMapping(path = {"aa/**"})
    public String request5(Model model){
        model.addAttribute("name", "aa");
        return "girl";
    }

    //只支持get请求
    @GetMapping(path = {"get"})
    public String request6(Model model){
        model.addAttribute("name", "get");
        return "girl";
    }

    //只支持post请求
    @PostMapping(path = {"post"})
    public String request7(Model model){
        model.addAttribute("name", "post");
        return "girl";
    }

    //只支持delete请求
    @DeleteMapping(path = {"delete"})
    public String request8(String in){
        System.out.println("delete " + in + "...");//本语句确实执行了
//        return "form";//跳转失败
        return "redirect:/jsp/form.jsp";//重定向可以成功跳转
    }

    /*斜杠加两个星号匹配出任意多个字符多层路径*/
    @RequestMapping("add/{id}")
    public String request9(@PathVariable("id") int id){
        System.out.println(id);
        return "girl";
    }

    //只支持put请求
    @PutMapping(path = {"put"})
    public String request10(String name, String age){//自动根据form表单名称填充
        System.out.println("put " + name + " " + age + "...");//本语句确实执行了
        return "form";//跳转失败
//        return "redirect:/jsp/form.jsp";//重定向可以成功跳转
    }

    //只支持put请求
    @PutMapping(path = {"put1"})
    public String request11(@RequestParam("name") String name, @RequestParam("age")String age){//自动根据form表单名称填充
        System.out.println("put " + name + " " + age + "...");//本语句确实执行了
        return "form";//跳转失败
//        return "redirect:/jsp/form.jsp";//重定向可以成功跳转
    }

    /*斜杠加两个星号匹配出任意多个字符多层路径*/
    @RequestMapping("post1")
    public String request12(Student student){
        System.out.println(student);
        return "form";
    }

    //该注解作用，在controller的所有具体方法执行之前都会执行该方法
    @ModelAttribute
    public Student init(){
        Student student = new Student();
        student.setName("关清彪");
        return student;
    }

    //该注解作用，在controller的所有具体方法执行之前都会执行该方法，同init
    //@ModelAttribute("student1")中的student1参数在testModelAttribute1传入参数时可用到？？？？
    @ModelAttribute("student1")
    public void init1(Model model){
        Student student = new Student();
        student.setName("关清彪1");
        model.addAttribute("student1", student);
    }
    //测试@ModelAttribute
    @RequestMapping("testModelAttribute")
    public String request13(Model model){
        //init中返回了student
        System.out.println(model.containsAttribute("student"));
        System.out.println(model.containsAttribute("student1"));
        return "student";
    }

    //同testModelAttribute
    //如果传进来的student中无值，则使用@ModelAttribute中的student，否则使用传进来的值
    @RequestMapping("testModelAttribute1")
    public String request14(@ModelAttribute Student student1){
        System.out.println(student1);
        return "student";
    }

//    //绑定事件处理格式 或者在pojo使用 @DateTimeFormat(pattern = "yy-MM-dd HH:mm:ss")
//    @InitBinder
//    public void initBinder(WebDataBinder binder) {
//        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//        dateFormat.setLenient(false);
//        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
//    }
//
//    //时间格式测试
//    @RequestMapping("date")
//    @ResponseBody
//    public String request15(@ModelAttribute Student student){
//        System.out.println(student.getDate());
//        return "OK!!!";
//    }

    //时间格式测试
    @RequestMapping("dateByPOJO")
    @ResponseBody
    public String request15(Student student){
        System.out.println(student.getDate());
        return "OK!!!";
    }
}
