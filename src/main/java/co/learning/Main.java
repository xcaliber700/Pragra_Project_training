package co.learning;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        // if we only need a name of the string use map and method reference
        List<String> veggieDish = dishes.stream().filter(d->d.getType()==Dish.DishType.VEG).map(Dish::getName).collect(Collectors.toList());
        // multi threading
        List<String> veggieDishes = dishes.parallelStream().filter(d->d.getType()==Dish.DishType.VEG)
                .map( d->{
                    System.out.println(Thread.currentThread().getName());
                    return d.getName();
                }
        ).collect(Collectors.toList());
        // below will return true if all match
        boolean match = dishes.stream().allMatch(d->d.getType()==Dish.DishType.VEG); //anymatch
        System.out.println("match = " + match);
        System.out.println(veggies);
        System.out.println(veggieDish);
        System.out.println(veggieDishes);

        //to count
        System.out.println("dishes.stream().count() = " + dishes.stream().count());

        //limiting to display 2 only
        dishes.stream().limit(2).forEach(System.out::println);

        Stream<Dish> stream = dishes.stream();
        stream.forEach(System.out::println);
        //if we print one more time it will produce error after printing first stream avoiding duplicaion
     //   **** stream.forEach(System.out::println);  ****//

        //chaining
    //    dishes.stream().filter(d->d.getPrice()>2).filter(dish -> dish.getType() == Dish.DishType.VEG).map(Dish::getName).map(String::length);
        // this above code will compile but not run without terminal operation,, collect is a terminal op;

        Double reduce = dishes.stream().map(Dish::getPrice).reduce(0.0, (a, b) -> a + b);
        System.out.println("reduce = " + reduce);

        List<Integer> integers = Arrays.asList(2, 4, 5, 7, 2, 1);
        Integer reduce1 = integers.stream().reduce(1, (a, b) -> a * b);
        System.out.println("reduce1 = " + reduce1);

        IntSummaryStatistics statistics = integers.stream().collect(Collectors.summarizingInt(Integer::intValue)); //summarizingInt(i->i))
        System.out.println("statistics = " + statistics);

        DoubleSummaryStatistics statistics1 = dishes.stream().map(Dish::getPrice).collect(Collectors.summarizingDouble(Double::doubleValue));
        System.out.println("statistics1 = " + statistics1);

        System.out.println(dishes.stream().map(Dish::getName).distinct().sorted().collect(Collectors.toList()));
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
