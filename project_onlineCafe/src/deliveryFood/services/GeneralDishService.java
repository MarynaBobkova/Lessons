package deliveryFood.services;

import deliveryFood.domain.interfaces.Dish;
import deliveryFood.repositories.interfaces.DishRepository;
import deliveryFood.services.interfaces.DishService;

import java.util.List;
import java.util.stream.Collectors;

public class GeneralDishService implements DishService {
    private DishRepository repository;
    public GeneralDishService (DishRepository repository) {
        this.repository = repository;
    }


    @Override
    public void addDish(String name, double price) {
        if(name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Наименование блюда не может быть пустым");
        }
        if (price <= 0) {
            throw new IllegalArgumentException("Цена не может быть отрицательной и равняться нулю");
        }
        repository.addDish(name, price);
    }

    @Override
    public List<Dish> getAllAvailableDishes() {
        return repository.getAllDishes()
                .stream()
                .filter(x -> x.isAvailable())
                .collect(Collectors.toList());
    }

    @Override
    public void deleteDishById(int id) {
        Dish dish = repository.getDishById(id);
        if (dish != null){
            dish.setAvailable(false);
        }
    }

    @Override
    public void deleteDishByName(String name) {
        Dish dish = repository.getDishByName(name);
        if (dish != null) {
            dish.setAvailable(false);
        }
    }

    @Override
    public void restoreDishById(int id) {
        Dish dish = repository.getDishById(id);
        if (dish != null){
            dish.setAvailable(true);
        }
    }

    @Override
    public void restoreDishByName(String name) {
        Dish dish = repository.getDishByName(name);
        if (dish != null) {
            dish.setAvailable(true);
        }
    }

    @Override
    public Dish changePrice(int id, double newPrice) {
        return null;
    }

    @Override
    public Dish changeName(int id, String newName) {
        return null;
    }

    @Override
    public int totalDishesQuantity() {
        return 0;
    }
}
