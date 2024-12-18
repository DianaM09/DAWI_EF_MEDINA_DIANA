package pe.edu.i202030258.medina_diana.service;

import pe.edu.i202030258.medina_diana.dto.CarCreateDto;
import pe.edu.i202030258.medina_diana.dto.CarDetailDto;
import pe.edu.i202030258.medina_diana.dto.CarDto;

import java.util.List;
import java.util.Optional;

public interface ManageService {

    List<CarDto> getAllCars() throws Exception;
    Optional<CarDetailDto> getDetailCar(int id) throws Exception;
    boolean updateCar(CarDto carDto) throws Exception;
    boolean deleteCar(int id) throws Exception;
    boolean createCar(CarCreateDto carCreateDto) throws Exception;
}
