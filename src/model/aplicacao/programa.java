package model.aplicacao;

import model.entidades.Department;
import model.entidades.Seller;

import java.util.Date;

public class programa {

        public static void main(String[] args) {
            Department obj = new Department(1, "Books");
            Seller seller = new Seller(23, "Pedro", "pedro@gmail.com", new Date(), 3000.0, obj);
            System.out.println(seller);
        }
}
