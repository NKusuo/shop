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
import java.util.Date;
import java.util.Calendar;

@SpringBootApplication
public class ShopApplication {

	//отмечает конструктор, поле или метод как требующий автозаполнения инъекцией зависимости Spring
	@Autowired
	private ProductsService productsService;
	@Autowired
	private ClientService clientService;
	@Autowired
	private AdminService adminService;
	@Autowired
	private OrderService orderService;

	public static void main(String[] args) {
		SpringApplication.run(ShopApplication.class, args);
	}

	@EventListener(ApplicationReadyEvent.class)
	private void test(){

		//добавление товара
		//Products product = new Products("кварель", "краска, 12 цветов", 1, 5000);
		//productsService.createProduct(product);

		//вывод товара по названию
		//productsService.findTitleProduct("Холст").forEach(it->System.out.println(it.printProduct()));

		//вывод списка товаров
		//productsService.allProducts().forEach(it->System.out.println(it.printProduct()));

		//удаление продукта по id
		//productsService.deleteProduct(3);

		//добавление клиента
		//Client client = new Client("Логинова Н.А.", "natali", "kuku99", "Улица Птушкина", "natali@mail.ru", 89379988902L);
		//clientService.createClient(client);

		//Добавление админа
		//Admin admin = new Admin("Куркунова К.Д.", "kurku", "kerkkk", 88005558886L);
		//adminService.createAdmin(admin);

		//Добавление заказа , new Date()- формирует дату сегодняшнюю
		//Orders order = new Orders(1, 1, "Подтвержден", new Date(), productsService.findAllById(2).getPrice());
		//orderService.createOrder(order);

		//Все заказы клиента
		//orderService.findAllByIdClient(1).forEach(it->System.out.println(productsService.findAllById(it.getIdproduct()).getTitle()+" "+it.printOrder()));


		//Изменение статуса заказа
		//String status="Собран";
        //orderService.updateStatus(21,status);

		//обновление количества товара
		//productsService.updateAmount(2,5);

		//Вывод номеров заказов и их статусы
		//orderService.ordersStatus().forEach(it->System.out.println(it.printOrderStatus()));

		//какой товар приносит больше прибыли(по заказам) ПОКА НЕ РАБОТАЕТ
		//productsService.profit().forEach(it->it.printProfit());


	}
}
