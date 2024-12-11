package org.example.lr5corpjava.controller;

import org.example.lr5corpjava.data.Cars;
import org.example.lr5corpjava.data.Trains;
import org.example.lr5corpjava.data.TrainsCars;
import org.example.lr5corpjava.service.CarsService;
import org.example.lr5corpjava.service.TrainsCarsService;
import org.example.lr5corpjava.service.TrainsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/")
public class TrainsCarsController {
    private TrainsCarsService trainsCarsService;
    private TrainsService trainsService;
    private CarsService carsService;

    public TrainsCarsController(TrainsCarsService trainsCarsService, TrainsService trainsService, CarsService carsService) {
        this.trainsCarsService = trainsCarsService;
        this.trainsService = trainsService;
        this.carsService = carsService;
    }

    @GetMapping("/trainsCars")
    public String getAllTrainsCars(Model model) {
        List<TrainsCars> trainsCars=trainsCarsService.getAllTrainsCars();
        List<Trains> trains=trainsService.getAllTrains();
        List<Cars> cars=carsService.getAllCars();
        model.addAttribute("trainsCars", trainsCars);
        model.addAttribute("trains", trains);
        model.addAttribute("cars", cars);
        return "trainsCars";
    }

    @GetMapping("/editTrainsCars")
    public String showEditTrainCarForm(Model model) {
        model.addAttribute("trains", trainsService.getAllTrains());
        model.addAttribute("cars", carsService.getAllCars());
        return "trainsCars";
    }

    @PostMapping("/addTrainsCars")
    public String addTrainCars(@RequestParam(name = "TrainID") int trainsId,
                               @RequestParam(name = "CarsID")int carsId) {
        trainsCarsService.addTrainsCar(trainsId, carsId);
        return "redirect:/trainsCars";
    }
    @PostMapping("/editTrainsCars")
    public String updateTrainCars(@RequestParam(name = "ID") int id,
                              @RequestParam(name = "TrainID") int trainsId,
                              @RequestParam(name = "CarsID")int carsId,
                              @RequestParam(name = "Date_Reception")LocalDate date_reception) {
        trainsCarsService.updateTrainsCar(id, trainsId, carsId, date_reception);
        return "redirect:/trainsCars";
    }
    @GetMapping("/deleteTrainCars")
    public String deleteTrainCars(@RequestParam int id) {
        trainsCarsService.deleteTrainsCar(id);
        return "redirect:/trainsCars";
    }
}
