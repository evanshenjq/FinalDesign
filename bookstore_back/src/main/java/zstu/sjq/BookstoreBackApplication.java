package zstu.sjq;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(value="zstu.sjq.dao")
public class BookstoreBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookstoreBackApplication.class, args);
	}
}
