package com.company.shop;

import com.company.shop.Service.AdminService;
import com.company.shop.Service.ClientService;
import com.company.shop.Service.OrderService;
import com.company.shop.Service.ProductsService;
import com.company.shop.domain.Admin;
import com.company.shop.domain.Client;
import com.company.shop.domain.Orders;
import com.company.shop.domain.Products;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import javax.transaction.Transactional;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.List;

@SpringBootApplication
public class ShopApplication {
	/*
	//отмечает конструктор, поле или метод как требующий автозаполнения инъекцией зависимости Spring
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private OrderService orderService;
*/
	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}
/*
	@EventListener(ApplicationReadyEvent.class)
	private void test(){

		//добавление товара
		//Products product = new Products("Маслянная краска", "синий", 1, 1200);
		//productsService.createProduct(product);
		//Products product1= new Products("Акварель краска", "синий", 1, 1200);
		//productsService.createProduct(product1);
		//Products product2 = new Products("краска", "синий", 1, 1200);
		//productsService.createProduct(product2);

		//вывод товара по названию
		//System.out.println("вывод товара по названию");
		//productsService.findTitleProduct("краска").forEach(it->System.out.println(it.printProduct()));

		//вывод списка товаров
		//System.out.println("вывод списка товаров");
		//productsService.allProducts().forEach(it->System.out.println(it.printProduct()));

		//удаление продукта по id
		//productsService.deleteProduct(2);

		//добавление клиента
		//Client client = new Client("Рыжова Е.В.", "katerina", "katay99", "Улица Колотущкина", "aterina@mail.ru", 89379989475L);
		//clientService.createClient(client);



		//Добавление админа
		//Admin admin = new Admin("Кошелев В.В.", "vladimir", "kekeke@mail.ru", 88006666886L);
		//adminService.createAdmin(admin);

		//Добавление заказа , new Date()- формирует дату сегодняшнюю

		/*ArrayList<Products> orderOne=new ArrayList<Products>();
		orderOne.add(productsService.findAllById(1));
		orderOne.add(productsService.findAllById(3));
		Integer price = orderOne.get(0).getPrice()+orderOne.get(1).getPrice();
		Orders order = new Orders(5,"Принят", new Date(), price,orderOne);
		orderService.createOrder(order);*/

		//Все заказы клиента
		//System.out.println("");
		//orderService.findAllByIdClient(5).forEach(it->System.out.println(it.printAllOrders()));


		//Изменение статуса заказа
		//String status="Собран";
        //orderService.updateStatus(7,status);

		//Вывод номеров заказов и их статусы
		//System.out.println("Номер заказа(id) и статус");
		//orderService.ordersStatus().forEach(it->System.out.println(it.printOrderStatus()));

	//}
}
