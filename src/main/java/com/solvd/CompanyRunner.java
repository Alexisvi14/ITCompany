package com.solvd;

import com.solvd.customerRelated.Appointment;
import com.solvd.customerRelated.Customer;
import com.solvd.enums.Necessity;
import com.solvd.enums.Speciality;
import com.solvd.exceptions.EmployeeNotFoundException;
import com.solvd.generalPurpose.Address;
import com.solvd.generalPurpose.BankAccount;
import com.solvd.interfaces.Discountable;
import com.solvd.interfaces.ICalculate;
import com.solvd.interfaces.Printable;
import com.solvd.linkedList.LinkedList;
import com.solvd.staff.Developer;
import com.solvd.staff.Employee;
import com.solvd.staff.administrative.Accountant;
import com.solvd.staff.administrative.Receptionist;
import com.solvd.threads.Conection;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class CompanyRunner {
    private final static Logger LOGGER = LogManager.getLogger(CompanyRunner.class);

    public static void main(String[] args) throws AccountNotFoundException {
        LOGGER.info("Starting Program");
        Random rd = new Random();

                //initializing company//
        BankAccount compBankAccount = new BankAccount();
        compBankAccount.setBalance(20000000.00);
        ItCompany itComp = new ItCompany("Solvd");
        itComp.setAccount(compBankAccount);


                //initializing employees//
        Developer devA = new Developer("Micaela", "Feldmann", rd.nextInt(999999), Speciality.BEND);
        devA.setAddress(new Address<>());
        LOGGER.info(devA.getAddress());

        Developer devB = new Developer("Brian", "Villamayor", rd.nextInt(999999), Speciality.FEND);
        devB.setAddress(new Address<>());
        LOGGER.info(devB.getAddress());

        Developer devC = new Developer("Cristian", "Gomez", rd.nextInt(), Speciality.DB);
        devC.setAddress(new Address<>());
        LOGGER.info(devC.getAddress());

        Developer devD = new Developer("Agustin", "Cabeza", rd.nextInt(), Speciality.DB);
        devD.setAddress(new Address<>());
        LOGGER.info(devD.getAddress());

        Receptionist recs = new Receptionist("Skyler", "White", rd.nextInt());
        Accountant acc = new Accountant("Richard", "Newman", rd.nextInt());

                //Adding developers//
        itComp.addDeveloper(devA);
        itComp.addDeveloper(devB);
        itComp.addDeveloper(devC);
        itComp.addDeveloper(devD);
        itComp.addRecepcionist(recs);
        itComp.addAccountant(acc);

        Customer custA = new Customer("Carlos", "Mosqueda", 3231231, "asdd");
        BankAccount custaBankAccount = new BankAccount();
        custaBankAccount.setBalance(300.00);
        custA.setAccount(custaBankAccount);

        Customer custB = new Customer("Hugo", "Villamayor", 3123123, "jhgs");
        BankAccount custbBankAccount = new BankAccount();
        custbBankAccount.setBalance(350.00);
        custB.setAccount(custbBankAccount);

        Customer custC = new Customer("Celeste", "Fernandez", 12321334, "dgtu");
        BankAccount custcBankAccount = new BankAccount();
        custcBankAccount.setBalance(300.00);
        custC.setAccount(custcBankAccount);

        Customer custD = new Customer("Facundo", "Vera", 21321455, "dfbbg");
        BankAccount custdBankAccount = new BankAccount();
        custdBankAccount.setBalance(300.00);
        custD.setAccount(custdBankAccount);


        recs.addAppointment(itComp, LocalDate.of(2022, 5, 10), LocalTime.of(9, 30),
                devA, custC, 100);
        recs.addAppointment(itComp, LocalDate.of(2022, 4, 17), LocalTime.of(10, 15),
                devB, custA, 200);
        recs.addAppointment(itComp, LocalDate.of(2022, 4, 13), LocalTime.of(11, 10),
                devC, custD, 220);


        devA.attendAppointment(devA.getAppoints().get(0),custC);
        devB.attendAppointment(devB.getAppoints().get(0), custA);
        devC.attendAppointment(devC.getAppoints().get(0), custD);


                // Removing a Developer//
        if (itComp.getDevs().contains(devD)){
            itComp.removeDeveloper(devD);
        } else {
            throw new  EmployeeNotFoundException("This employee does not work for the company");
        }


        devB.serveCustomer(custC, Necessity.getRandomNecessity());
        devA.serveCustomer(custA, Necessity.getRandomNecessity());
        devC.serveCustomer(custB, Necessity.getRandomNecessity());

        ICalculate calc = (x, y) -> {
            LOGGER.info("The total cost of your attention is:" + "\n" + (x * y));
            if (x * y > 200) {
                LOGGER.info("You can access to a discount");

                Discountable disc = (c, p, q) -> {
                    LOGGER.info("You get a " + q + "% off discount" +
                            "\n" + "So the total now is: " + "\n" + (p * (100 - q) / 100));
                };
                disc.discount('$', (x * y), 20);

            }
            Printable info = info1 -> {
                LOGGER.info("Printing some info here");
            };
        };

        acc.pay(devB, 500);
        acc.pay(devA, 700);
        acc.pay(devC, 600);


        LinkedList<Employee> DevsList = new LinkedList<Employee>();
        DevsList.add(devA);
        DevsList.add(devB);
        DevsList.add(devC);
        LOGGER.info(DevsList);

        //Threads//
        ThreadPoolExecutor tp = (ThreadPoolExecutor) Executors.newFixedThreadPool(5);
        Conection dbConection = new Conection("Info of the data base");
        devA.setConection(dbConection);
        devB.setConection(dbConection);
        devC.setConection(dbConection);
        devD.setConection(dbConection);
        tp.execute(devA);
        tp.execute(devB);
        tp.execute(devC);
        tp.execute(devD);
        tp.shutdown();

        LOGGER.info(custC);
        itComp.getDevs().forEach((developer) -> LOGGER.info(developer.getFirstName()));
    }
}
