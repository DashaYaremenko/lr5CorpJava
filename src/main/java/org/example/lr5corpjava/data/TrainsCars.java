package org.example.lr5corpjava.data;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "train_cars")
public class TrainsCars {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private int id;

        @Column(name = "Date_Reception", nullable = false)
        private LocalDate date_reception;

        @ManyToOne
        @JoinColumn(name = "TrainID")
        private Trains trainId;

       @ManyToOne
       @JoinColumn(name = "CarsID")
       private Cars carsId;

        public TrainsCars(Trains trainId, Cars carsId) {
          this.trainId = trainId;
          this.carsId = carsId;
          this.date_reception = LocalDate.now();
        }
        public TrainsCars() {}

    @PrePersist
    protected void onCreate() {
        if (this.date_reception == null) {
            this.date_reception = LocalDate.now(); // Установити поточну дату, якщо вона ще не задана
        }
    }
        public int getId() {return id;}
        public void setId(int id) {this.id = id;}
        public Cars getCarsId() {return carsId;}
        public void setCarsId(Cars carsId) {this.carsId = carsId;}
        public LocalDate getDate_reception() {return date_reception;}
        public void setDate_reception(LocalDate date_reception) {this.date_reception = date_reception;}
        public Trains getTrainId() {return trainId;}
        public void setTrainId(Trains trainId) {this.trainId = trainId;}
}

