package co.learning;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Dish> dishes = new ArrayList<>();
        dishes.add(Dish.builder()
                .id(1)
                .name("Samosa")
                .price(1)
                .ingredients(Arrays.asList("Potatoes","Peas","Spice"))
                .prepTime(20)
                .type(Dish.DishType.VEG).build());

        dishes.add(Dish.builder()
                .id(2)
                .name("Chicken Dumpling")
                .price(12.50)
                .ingredients(Arrays.asList("Chicken","Spice"))
                .prepTime(30)
                .type(Dish.DishType.NONVEG).build());

        dishes.add(Dish.builder()
                .id(3)
                .name("Butter Chicken")
                .price(16.50)
                .ingredients(Arrays.asList("Chicken","Butter","Tomato","Spice"))
                .prepTime(30)
                .type(Dish.DishType.NONVEG).build());

        dishes.add(Dish.builder().id(1)
                .name("Butter Paneer")
                .price(13.50)
                .ingredients(Arrays.asList("Paneer","Butter","Tomato","Spice"))
                .prepTime(30)
                .type(Dish.DishType.VEG).build());

//        List<Dish> vegDishes = new ArrayList<>(;
//        for (Dish dish:dishes){
//            if(dish.getType()== Dish.DishType.VEG){
//                vegDishes.add(dish);
//            }
//        }

        // ** using Stream** //
        List<Dish> veggies = dishes.stream().filter(d->d.getType()==Dish.DishType.VEG).collect(Collectors.toList());
        // if we only need a name of the string
        List<String> veggieDish = dishes.stream().filter(d->d.getType()==Dish.DishType.VEG).map(Dish::getName).collect(Collectors.toList());
        // multi threading
        List<String> veggieDishes = dishes.parallelStream().filter(d->d.getType()==Dish.DishType.VEG)
                .map( d->{
                    System.out.println(Thread.currentThread().getName());
                    return d.getName();
                }
        ).collect(Collectors.toList());
        System.out.println(veggies);
        System.out.println(veggieDish);
        System.out.println(veggieDishes);
    }

}





















////        System.out.println();
//        List<Employee> employees =new ArrayList<>();
//        employees.add(new Employee(1, "Edward", Employee.Type.CONTRACT, 100000));
//        employees.add(new Employee(2, "Baban", Employee.Type.FULLTIME, 80000));
//        employees.add(new Employee(3, "Siamr", Employee.Type.PARTTIME, 700000));
//        employees.add(new Employee(4, "Prabh", Employee.Type.FULLTIME, 100000));
//
//        List<Employee> moreThan100Thousand = new ArrayList<>();
//
//        for(Employee employee : employees){
//            if(employee.getSalary()>100000){
//                moreThan100Thousand.add(employee);
//            }
//        }
//        System.out.println(moreThan100Thousand);
////        moreThan100Thousand.sort(new Comparator<Employee>() {
////            @Override
////            public int compare(Employee o1, Employee o2) {
////                return o1.getEmployeeId()-o2.getEmployeeId();
////            }
////        });
//
//  //      moreThan100Thousand.sort( (o1, o2)-> o1.getEmployeeId()-o2.getEmployeeId() ); //implementing lambda
//
//        moreThan100Thousand.sort(
//                AwesomeComparator::awesomeCompare //labda reference to method / if static method use class name:: /if non static use object::
//        );
//
//        System.out.println(moreThan100Thousand);
//    }
//
//}
//class AwesomeComparator{
//    public static int awesomeCompare(Employee e1, Employee e2){
//        return e1.getEmployeeId() - e2.getEmployeeId();
//    }
//}
////class EmployeeComparator implements Comparator<Employee> {
////
////
////    @Override
////    public int compare(Employee o1, Employee o2) {
////        return o1.getEmployeeId()- o2.getEmployeeId();
////    }
////
////    @Override
////    public boolean equals(Object obj) {
////        return false;
////    }
////}
