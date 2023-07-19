package shop.mtcoding.mall.model;

import lombok.Getter;

import javax.persistence.*;
@Getter
@Table(name="product_tb")//테이블 이름 바꿔줌
@Entity //테이블 생성해줌 //리플렉션하면서 변수 분석하면서 클래스명으로 테이블 만들어준다
public class Product {
    @Id //프라이머리키
    @GeneratedValue(strategy = GenerationType.IDENTITY)//테이블 오토인크리먼트 달림
    private  Integer id;
    private  String name;
    private  Integer price;
    private  Integer qty;
}
