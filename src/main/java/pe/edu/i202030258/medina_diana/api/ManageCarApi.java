package pe.edu.i202030258.medina_diana.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pe.edu.i202030258.medina_diana.dto.CarCreateDto;
import pe.edu.i202030258.medina_diana.dto.CarDetailDto;
import pe.edu.i202030258.medina_diana.dto.CarDto;
import pe.edu.i202030258.medina_diana.response.*;
import pe.edu.i202030258.medina_diana.service.ManageService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cars")
public class ManageCarApi {

    @Autowired
    ManageService manageService;

    @GetMapping("/all")
    public GetAllCarResponse getAllUsers() {

        try {
            List<CarDto> users = manageService.getAllCars();
            if (!users.isEmpty())
                return new GetAllCarResponse("01", null, users);
            else
                return new GetAllCarResponse("02", "Cars not found", null);

        } catch (Exception e) {
            e.printStackTrace();
            return new GetAllCarResponse("99", "An error occurred, please try again", null);
        }
    }

    //DETALLE
    @GetMapping("/detail")
    public GetDetailCarResponse getDetailUser(@RequestParam(value = "id", defaultValue = "0") String id) {

        try {
            Optional<CarDetailDto> optional = manageService.getDetailCar(Integer.parseInt(id));
            return optional.map(user ->
                    new GetDetailCarResponse("01", null, user)
            ).orElse(
                    new GetDetailCarResponse("02", "Car not found", null)
            );

        } catch (Exception e) {
            e.printStackTrace();
            return new GetDetailCarResponse("99", "An error occurred, please try again", null);
        }
    }

    //GUARDAR
    @PutMapping("/update")
    public UpdateCarResponse updateUser(@RequestBody CarDto carDto) {

        try {
            if (manageService.updateCar(carDto))
                return new UpdateCarResponse("01", null);
            else
                return new UpdateCarResponse("02", "Update failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new UpdateCarResponse("99", "An error occurred, please try again");
        }
    }

    //ELIMINAR
    @DeleteMapping("/delete/{id}")
    public DeleteCarResponse deleteCar(@PathVariable String id) {

        try {
            if (manageService.deleteCar(Integer.parseInt(id)))
                return new DeleteCarResponse("01", null);
            else
                return new DeleteCarResponse("02", "Delete failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new DeleteCarResponse("99", "An error occurred, please try again");
        }
    }

    //CREAR
    @PostMapping("/create")
    public CreateCarResponse createCar(@RequestBody CarCreateDto carCreateDto) {

        try {
            if (manageService.createCar(carCreateDto))
                return new CreateCarResponse("01", null);
            else
                return new CreateCarResponse("02", "Create failed");

        } catch (Exception e) {
            e.printStackTrace();
            return new CreateCarResponse("99", "An error occurred, please try again");
        }
    }
}
