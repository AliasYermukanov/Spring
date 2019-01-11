package com.spring.controllers;

import com.spring.beans.UserBean;

import com.spring.dao.History;
import com.spring.dao.Items;
import com.spring.dao.Roles;
import com.spring.dao.Users;
import com.sun.deploy.net.HttpResponse;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

@Controller
public class HomeControler {

    @Autowired
    UserBean userBean;

    @RequestMapping(value = "/")
    public ModelAndView start(HttpServletRequest request){
        if(request.getSession() != null && request.getSession().getAttribute("userData") !=null){
            List<Items> itemsList = userBean.itemsList();

            ModelAndView view = new ModelAndView("index");
            view.addObject("itemsList",itemsList);
            return view;

        }
        return new ModelAndView("log");
    }
    @RequestMapping(value = "/profile")
    public ModelAndView profile(){
        List<Users> usersList = userBean.userList();
        List<History> histories = userBean.histories();

        ModelAndView view = new ModelAndView("profile");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;
    }
    @RequestMapping(value = "/home")
    public ModelAndView home(HttpServletRequest request){
        if(request.getSession() != null && request.getSession().getAttribute("userData") !=null){
            List<Items> itemsList = userBean.itemsList();

            ModelAndView view = new ModelAndView("index");
            view.addObject("itemsList",itemsList);
            return view;

        }
        return new ModelAndView("log");
    }
    @RequestMapping(value = "/reg")
    public ModelAndView reg(){
        return new ModelAndView("reg");
    }
    @RequestMapping(value = "/addItem")
    public ModelAndView addItem(){
        return new ModelAndView("addItem");
    }
    @RequestMapping(value = "/items")
    public ModelAndView items(){
        List<Items> itemsList = userBean.itemsList();

        ModelAndView view = new ModelAndView("items");
        view.addObject("itemsList",itemsList);
        return view;
    }

    @RequestMapping(value = "/auth", method = RequestMethod.POST)
    public ModelAndView login(HttpServletResponse response,HttpSession session,
                              @RequestParam(name = "login") String login,
                              @RequestParam(name = "password") String password) {

        Users users=userBean.getUser(login,password);
        if(users!=null){
            session.setAttribute("userData",users);
            List<Items> itemsList = userBean.itemsList();

            ModelAndView view = new ModelAndView("index");
            view.addObject("itemsList",itemsList);
            return view;
        }
        return new ModelAndView("log");
    }

    @RequestMapping(value = "/registration")
    public ModelAndView registration(HttpServletResponse response,HttpSession session,
                          @RequestParam(name = "login") String login,
                          @RequestParam(name = "password") String password,
                          @RequestParam("role") Long id){

        Roles roles = userBean.getRoleById(id);
        Users users = new Users(login,password,roles);
        userBean.addUser(users);
        return new ModelAndView("/reg");
    }


    @RequestMapping(value = "/updateProfile", method = RequestMethod.GET)
    public ModelAndView updateProfile(HttpSession session){
        ModelAndView view = new ModelAndView("update");
        view.addObject("data",session.getAttribute("userData"));
        return view;
    }

    @RequestMapping(value = "/updatePro", method = RequestMethod.POST)
    public ModelAndView updateProfile(HttpSession session,
                              @RequestParam(name = "login") String login,
                              @RequestParam(name = "password") String password){

        Users users = (Users) session.getAttribute("userData");

            users.setLogin(login);
            users.setPassword(password);

        userBean.addUser(users);
        List<Users> usersList = userBean.userList();
        List<History> histories = userBean.histories();

        ModelAndView view = new ModelAndView("profile");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;
    }

    @RequestMapping(value = "/users")
    public ModelAndView users(){
        List<Users> usersList = userBean.userList();
        List<History> histories = userBean.histories();

        ModelAndView view = new ModelAndView("allUsers");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;
    }
    @RequestMapping(value = "/del")
    public ModelAndView delete(@RequestParam(name = "id") Long userId){

        userBean.deleteUser(userBean.findUserById(userId));
        List<History> histories = userBean.histories();
        List<Users> usersList = userBean.userList();
        ModelAndView view = new ModelAndView("allUsers");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;
    }

    @RequestMapping(value = "/edit")
    public ModelAndView edit(@RequestParam(name = "id") Long userId){


        Users users = userBean.findUserById(userId);

        ModelAndView view = new ModelAndView("update1");
        view.addObject("data",users);
        return view;

    }

    @RequestMapping(value = "/updateProfile1", method = RequestMethod.POST)
    public ModelAndView uProfile(
                              @RequestParam(name = "login") String login,
                              @RequestParam(name = "password") String password,
                              @RequestParam(name = "id") Long id,
                              @RequestParam(name = "role") Long role){

        Users u=userBean.findUserById(id);
        Roles roles = userBean.getRoleById(role);
        u.setLogin(login);u.setPassword(password);u.setRoles(roles);

        userBean.addUser(u);
        List<Users> usersList = userBean.userList();
        List<History> histories = userBean.histories();
        ModelAndView view = new ModelAndView("allUsers");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;
    }

    @RequestMapping(value = "/logout")
    public String logout(HttpSession session, HttpServletRequest request){
        if(request.getSession() != null && request.getSession().getAttribute("userData") !=null){
            session.removeAttribute("userData");
            return "redirect:/";
        }
        return "redirect:/";
    }
    @RequestMapping(value = "/addI")
    public ModelAndView addI(HttpServletResponse response,HttpSession session,
                                     @RequestParam(name = "name") String name,
                                     @RequestParam(name = "upc") String upc,
                                     @RequestParam(name = "price") int price,
                                     @RequestParam(name = "number") int number){

        Items items = new Items(name,upc,price,number);
        userBean.addItem(items);
        return new ModelAndView("/addItem");
    }
    @RequestMapping(value = "/delI")
    public ModelAndView deleteI(@RequestParam(name = "id") Long Id){

        userBean.deleteItem(userBean.findItemById(Id));

        List<Items> itemsList = userBean.itemsList();

        ModelAndView view = new ModelAndView("items");
        view.addObject("itemsList",itemsList);
        return view;
    }

    @RequestMapping(value = "/editI")
    public ModelAndView editI(@RequestParam(name = "id") Long Id){


        Items items = userBean.findItemById(Id);

        ModelAndView view = new ModelAndView("addItem1");
        view.addObject("data",items);
        return view;

    }
    @RequestMapping(value = "/addI1")
    public ModelAndView addI1(HttpServletResponse response,HttpSession session,
                             @RequestParam(name = "name") String name,
                             @RequestParam(name = "upc") String upc,
                             @RequestParam(name = "price") int price,
                             @RequestParam(name = "number") int number,
                             @RequestParam(name = "ID") Long id){

        Items items = userBean.findItemById(id);
        items.setName(name);
        items.setUpc(upc);
        items.setPrice(price);
        items.setAmounts(number);

        userBean.addItem(items);
        List<Items> itemsList = userBean.itemsList();

        ModelAndView view = new ModelAndView("items");
        view.addObject("itemsList",itemsList);
        return view;
    }

    @RequestMapping(value = "/buy")
    public ModelAndView buy(HttpSession session,
                            @RequestParam(name = "number") int number,
                            @RequestParam(name="id") Long id){
      Items item = userBean.findItemById(id);
//
        Date date = new Date();
        History history = new History(item,(Users)session.getAttribute("userData"),number,date);
        userBean.addHistory(history);
        item.setAmounts(item.getAmounts()-number);
        userBean.addItem(item);

        List<Items> itemsList = userBean.itemsList();

        ModelAndView view = new ModelAndView("index");
        view.addObject("itemsList",itemsList);
        return view;
    }
    @RequestMapping(value = "/sell")
    public ModelAndView sell(){



        List<Items> itemsList = userBean.itemsList();

        ModelAndView view = new ModelAndView("sellSC");
        view.addObject("itemsList",itemsList);
        return view;
    }
    @RequestMapping(value = "/sell1")
    public ModelAndView sell1(HttpSession session,
                              @RequestParam("utc") String utc,
                              @RequestParam("number") int number){
        Items item = userBean.findbyUTC(utc);
        item.setAmounts(item.getAmounts()-number);

        List<Items> itemsList = userBean.itemsList();

        Date date = new Date();
        History history = new History(item,(Users)session.getAttribute("userData"),number,date);
        userBean.addHistory(history);
        item.setAmounts(item.getAmounts()-number);
        userBean.addItem(item);


        List<Users> usersList = userBean.userList();
        List<History> histories = userBean.histories();

        ModelAndView view = new ModelAndView("profile");
        view.addObject("usersList",usersList);
        view.addObject("histories",histories);
        return view;

    }
    @RequestMapping(value = "/addAdmin")
    public ModelAndView addAdmin(HttpServletResponse response,HttpSession session){

        Roles roles = userBean.getRoleById(36L);
        Users users = new Users("admin","admin",roles);
        userBean.addUser(users);
        return new ModelAndView("log");
    }
    @RequestMapping(value = "/addRole")
    public ModelAndView addRole(HttpServletResponse response,HttpSession session){

        Roles roles = new Roles("CASHIER");

        userBean.addRole(roles);
        return new ModelAndView("log");
    }
}
