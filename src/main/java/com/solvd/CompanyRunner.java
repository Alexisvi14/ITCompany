package com.solvd;

import com.solvd.customerRelated.Customer;
import com.solvd.enums.Gender;
import com.solvd.enums.Necessity;
import com.solvd.enums.Speciality;
import com.solvd.exceptions.EmployeeNotFoundException;
import com.solvd.generalPurpose.Address;
import com.solvd.generalPurpose.BankAccount;
import com.solvd.interfaces.Discountable;
import com.solvd.interfaces.ICalculate;
import com.solvd.interfaces.Printable;
import com.solvd.linkedList.LinkedList;
import com.solvd.staff.CleaningStaff;
import com.solvd.staff.Developer;
import com.solvd.staff.Employee;
import com.solvd.staff.TestAutomationEngineer;
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
        Developer devA = new Developer("Micaela", "Feldmann", rd.nextInt(999999),
                Speciality.BEND, Gender.F);
        Address addressA = new Address("Argentina", "Saenz Peña");
        devA.setAddress(addressA);
        LOGGER.info(devA + " is from " + addressA);

        Developer devB = new Developer("Brian", "Villamayor", rd.nextInt(999999),
                Speciality.FEND, Gender.M);
        Address addressB = new Address("Argentina", "Formosa");
        devB.setAddress(addressB);
        LOGGER.info(devB + " is from " + addressB);

        Developer devC = new Developer("Cristian", "Gomez", rd.nextInt(), Speciality.DB,
                Gender.M);
        Address addressC = new Address("Uruguay","Montevideo");
        devC.setAddress(addressC);
        LOGGER.info(devC + " is from " + addressC);

        Developer devD = new Developer("Agustin", "Cabeza", rd.nextInt(), Speciality.DB,
                Gender.M);
        Address addressD = new Address("Brazil", "Rio de Janeiro");
        LOGGER.info(devD + " is from " + addressD);

        Receptionist recs = new Receptionist("Skyler", "White", rd.nextInt());
        Accountant acc = new Accountant("Richard", "Newman", rd.nextInt());

                //Adding developers//
        itComp.addDeveloper(devA);
        itComp.addDeveloper(devB);
        itComp.addDeveloper(devC);
        itComp.addDeveloper(devD);
        itComp.addRecepcionist(recs);
        itComp.addAccountant(acc);

        itComp.addEmployee(10, "Saul Goodman");
        itComp.addEmployee(21, "Hugo Villamayor");
        itComp.updateEmployee(21, "Liliana Santa Cruz");
        itComp.removeEmployee(10);
        itComp.print("Data upload is now complete");


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

        TestAutomationEngineer testAutomationEngineer = new TestAutomationEngineer("Roberto",
                "Fernandez", 12);
        testAutomationEngineer.work();
        LOGGER.info("TA Engineer is active");

        CleaningStaff cleaningStaff = new CleaningStaff("Carla", "Lezcano", 22);
        cleaningStaff.clean();
        LOGGER.info("The cleaning staff is working");

        devB.dev(devB);
        LOGGER.info("Brian Villamayor busy right now");

                // Removing a Developer//
        if (itComp.getDevs().contains(devD)){
            itComp.removeDeveloper(devD);
        } else {
            throw new  EmployeeNotFoundException("This employee does not work for the company");
        }

        Necessity.getRandomNecessity().getCost();
        Necessity.IS.getCost();

        devB.serveCustomer(custC, Necessity.getRandomNecessity());
        devA.serveCustomer(custA, Necessity.getRandomNecessity());
        devC.serveCustomer(custB, Necessity.getRandomNecessity());

        ICalculate calc = (x, y) -> {
            int total = x + y;
            LOGGER.info("The total cost of your attention is:" + "\n" + total);
            if (total >= 500) {
                LOGGER.info("You can access to a discount");
            }
            Discountable disc = (c, p, q) -> {
                int result = ((total * 20) / 100);
                LOGGER.info("You get a " + q + "% off discount" +
                        "\n" + "So the total now is: " + "\n" + result);
            };
            disc.discount('$', (Necessity.getRandomNecessity().getCost() + 150), 20);
        };
        calc.calculate(Necessity.getRandomNecessity().getCost(), 150);


        Printable info = (s) -> LOGGER.info(s + "are working at the moment");
        info.print("All employees ");





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
