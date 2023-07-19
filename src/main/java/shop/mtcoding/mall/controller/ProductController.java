package shop.mtcoding.mall.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import shop.mtcoding.mall.model.Product;
import shop.mtcoding.mall.model.ProductRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@Controller//뷰를 찾아서 만들어줌
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    //product repository 쓸수있음


    @GetMapping("/")
    public String home(HttpServletRequest request){
       List<Product> productList =productRepository.findAll();
        //이거를 어떻게 넘기지->
        request.setAttribute("productList",productList);
        return "home";//상품등록페이지
        //home이라는 내용을 줌
    }

    @GetMapping("/write")
    public String writePage(){
        return "write";//상품목록페이지
    }

   @PostMapping("/product")
    public void write (String name, int price, int qty, HttpServletResponse response) throws IOException {
        System.out.println("name:"+name);
        System.out.println("price:"+price);
        System.out.println("qty:"+qty);

        productRepository.save(name, price, qty);
        response.sendRedirect("/");//등록 후에 다시 home으로 화면 전환 해준다
//        return "redirect:/";

    }

}
