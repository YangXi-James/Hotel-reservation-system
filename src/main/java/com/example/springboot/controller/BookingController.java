package com.example.springboot.controller;

import com.example.springboot.model.Hotel;
import com.example.springboot.model.Order;
import com.example.springboot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
public class BookingController {
    public static final String ORDERID = "ORDERID";//放到session中的key

    @Autowired
    OrderService orderService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        dateFormat.setLenient(false);
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
    }

    @RequestMapping("/booking")
    public String sendbooking(Model model,@RequestParam("standard_id") String standard_id, @RequestParam("price") int price,@RequestParam("name") String name, @RequestParam("phone") String phone, @RequestParam("time") Date date, @RequestParam("dating_time") int dating_time,@RequestParam("remark") String remark,Order order, HttpServletRequest request) {
        if (!name.equals("")) {
            if (phone.length() == 11) {
                if (date.getDate() >= new Date().getDate()) {
                    model.addAttribute("name", name);
                    model.addAttribute("phone", phone);
                    int month = date.getMonth() + 1;
                    int year = date.getYear() + 1900;
                    model.addAttribute("date", date.getDate() + "-" + month + "-" + year);
                    model.addAttribute("date_time", dating_time);
                    model.addAttribute("remark", remark);
                    model.addAttribute("pay", false);
                    model.addAttribute("cancel", false);
                    model.addAttribute("checkout", false);
                    Time order_time = new Time(new Date().getTime());
                    order.setOrder_time(order_time);
                    double total_price = dating_time * Double.valueOf(price);
                    order.setTotal_price(total_price);
                    model.addAttribute("totalprice", total_price);
                    orderService.book(order);
                    System.out.println(order);
                    HttpSession session = request.getSession();
                    session.setAttribute(ORDERID, order.getOrder_id());
                    model.addAttribute("orderId", order.getOrder_id());
                    int user_id = (int) session.getAttribute("LOGINPASSWORD");
                    String user_name = orderService.selectName(user_id);
                    model.addAttribute("user_name", user_name);
                    int sid = Integer.parseInt(standard_id);
                    List<Hotel> result = orderService.selectHotelByStandardId(sid);
                    Hotel hotel = result.get(0);
                    model.addAttribute("description",hotel.getDescription());
                    model.addAttribute("hotelname",hotel.getName());
                    model.addAttribute("telephone",hotel.getTelephone());
                    //model.addAttribute("photo",hotel.getRoomphoto_url());
                    model.addAttribute("grade",hotel.getGrade());
                    model.addAttribute("level",hotel.getLevel());
                    model.addAttribute("address",hotel.getAddress());
                    model.addAttribute("standard_id",hotel.getStandard_id());
                    return "bookingDetail";
                } else {
                    String msg = "请填写正确的入住日期！";
                    model.addAttribute("date_err", msg);
                    return "booking";
                }
            } else {
                String msg = "请填写正确的手机号码！";
                model.addAttribute("phone_err", msg);
                return "booking";
            }
        } else {
            String msg = "请填写您的姓名！";
            model.addAttribute("name_err", msg);
            return "booking";
        }
    }

    @RequestMapping("/bookingDetail")
    public String paybooking(Model model, HttpServletRequest request, String input) {
        System.out.println(1);
        HttpSession session = request.getSession();
        int order_id = (int) session.getAttribute("ORDERID");
        session.removeAttribute("ORDERID");
        System.out.println(order_id);
        if (input.equals("支付")) {
            orderService.pay(order_id);
            session.setAttribute(ORDERID, order_id);
        }
        if (input.equals("取消订单")) {
            orderService.cancel(order_id);
        }
        if (input.equals("申请退房")) {
            orderService.checkout(order_id);
        }
        List<Order> order = orderService.selectID(order_id);
        Order order1 = order.get(0);
        model.addAttribute("pay", order1.isWheather_pay());
        model.addAttribute("cancel", order1.isWheather_cancel());
        model.addAttribute("checkout", order1.isWheather_checkout());
        model.addAttribute("orderId", order1.getOrder_id());
        model.addAttribute("name", order1.getId());
        model.addAttribute("phone", order1.getPhone());
        int month = order1.getTime().getMonth() + 1;
        int year = order1.getTime().getYear() + 1900;
        model.addAttribute("date", order1.getTime().getDate() + "-" + month + "-" + year);
        model.addAttribute("date_time", order1.getDating_time());
        model.addAttribute("remark", order1.getRemark());
        model.addAttribute("totalprice", order1.getTotal_price());
        int standard_id = order1.getStandard_id();
        List<Hotel> result = orderService.selectHotelByStandardId(standard_id);
        Hotel hotel = result.get(0);
        System.out.println(hotel);
        model.addAttribute("description",hotel.getDescription());
        model.addAttribute("hotelname",hotel.getName());
        model.addAttribute("telephone",hotel.getTelephone());
        model.addAttribute("grade",hotel.getGrade());
        model.addAttribute("level",hotel.getLevel());
        model.addAttribute("address",hotel.getAddress());
        model.addAttribute("standard_id",hotel.getStandard_id());
        return "/bookingDetail";
    }

    @RequestMapping("/orderList")
    @ResponseBody
    public List<Order> getOrder(int user_id){
        System.out.println("开始查找订单");
        return orderService.findOrderAndPic(user_id);
    }

    @RequestMapping("/Mybooking")
    public String sendid(Model model,HttpServletRequest request){
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("LOGINPASSWORD");
        model.addAttribute("user_id",user_id);
        System.out.println(user_id);
        System.out.println("传入id号");
        return "/myBooking";
    }

    @RequestMapping("/review")
    public String getInReview(HttpServletRequest request,@RequestParam("order_id") String input){
        System.out.println(input);
        HttpSession session = request.getSession();
        int order_id = Integer.parseInt(input);
        session.setAttribute(ORDERID, order_id);
        return "/review";
    }

    @RequestMapping("/Setreview")
    public String setReview(HttpServletRequest request,String review){
        HttpSession session = request.getSession();
        int order_id = (int) session.getAttribute("ORDERID");
        session.removeAttribute("ORDERID");
        orderService.setReview(order_id,review);
        System.out.println(review);
        System.out.println(order_id);
        return "/index";
    }

    @RequestMapping(value = "/Detail")
    public String showDetail(HttpServletRequest request,Model model, @RequestParam("order_id") String input) {
        HttpSession session = request.getSession();
        System.out.println(input);
        int order_id = Integer.parseInt(input);
        session.setAttribute(ORDERID, order_id);
        List<Order> order = orderService.selectID(order_id);
        Order order1 = order.get(0);
        model.addAttribute("pay", order1.isWheather_pay());
        model.addAttribute("cancel", order1.isWheather_cancel());
        model.addAttribute("checkout", order1.isWheather_checkout());
        model.addAttribute("orderId", order1.getOrder_id());
        model.addAttribute("name", order1.getId());
        model.addAttribute("phone", order1.getPhone());
        int month = order1.getTime().getMonth() + 1;
        int year = order1.getTime().getYear() + 1900;
        model.addAttribute("date", order1.getTime().getDate() + "-" + month + "-" + year);
        model.addAttribute("date_time", order1.getDating_time());
        model.addAttribute("remark", order1.getRemark());
        model.addAttribute("totalprice", order1.getTotal_price());
        int standard_id = order1.getStandard_id();
        List<Hotel> result = orderService.selectHotelByStandardId(standard_id);
        Hotel hotel = result.get(0);
        System.out.println(hotel);
        model.addAttribute("description",hotel.getDescription());
        model.addAttribute("hotelname",hotel.getName());
        model.addAttribute("telephone",hotel.getTelephone());
        model.addAttribute("grade",hotel.getGrade());
        model.addAttribute("level",hotel.getLevel());
        model.addAttribute("address",hotel.getAddress());
        model.addAttribute("standard_id",hotel.getStandard_id());
        return "/bookingDetail";
    }

    @RequestMapping("/toBooking")
    public String toBook(Model model,HttpServletRequest request,@RequestParam("standard_id") String standard_id,@RequestParam("price") String price){
        HttpSession session = request.getSession();
        int user_id = (int) session.getAttribute("LOGINPASSWORD");
        model.addAttribute("standard_id", standard_id);
        model.addAttribute("price", price);
        model.addAttribute("name", user_id);//修改为realname
        return "booking";
    }
}

