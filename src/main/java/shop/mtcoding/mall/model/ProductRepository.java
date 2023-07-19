package shop.mtcoding.mall.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository // 컴퍼넌트 스캔
public class ProductRepository {

    @Autowired//타입으로 찾아서 넣어줌  , IoC에서 DI
    private EntityManager em;//db연결 해준다

    @Transactional//트랜잭션 알아서 열고 닫고
    public void save(String name, int price, int qty){
        Query query = em.createNativeQuery("insert into product_tb(name, price, qty) values(:name, :price, :qty)");
        query.setParameter("name", name);
        query.setParameter("price", price);
        query.setParameter("qty", qty);
        query.executeUpdate();//전송(write할때)
    }

    public List<Product> findAll() {
       Query query=  em.createNativeQuery("select * from product_tb", Product.class);
       List<Product> productList = query.getResultList();//여러건 받아냄
        return productList;
    }
}