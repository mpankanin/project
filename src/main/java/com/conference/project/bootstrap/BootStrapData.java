package com.conference.project.bootstrap;


import com.conference.project.model.Customer;
import com.conference.project.model.Lecture;
import com.conference.project.model.ThematicPath;
import com.conference.project.repository.CustomerRepository;
import com.conference.project.repository.LectureRepository;
import com.conference.project.repository.ThematicPathRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


import java.util.Arrays;

@Component
public class BootStrapData implements CommandLineRunner {

    private final CustomerRepository customerRepository;
    private final LectureRepository lectureRepository;
    private final ThematicPathRepository thematicPathRepository;

    public BootStrapData(CustomerRepository customerRepository, LectureRepository lectureRepository, ThematicPathRepository thematicPathRepository) {
        this.customerRepository = customerRepository;
        this.lectureRepository = lectureRepository;
        this.thematicPathRepository = thematicPathRepository;
    }

    @Override
    public void run(String... args) {

        ThematicPath thematicPath1 = new ThematicPath("Artificial intelligence and machine learning");
        ThematicPath thematicPath2 = new ThematicPath("Common mistakes");
        ThematicPath thematicPath3 = new ThematicPath("The brighter future of the it industry");

        thematicPathRepository.saveAll(Arrays.asList(thematicPath1, thematicPath2, thematicPath3));

        Lecture lecture11 = new Lecture("What do we know about ai", "2023-04-26 10:00", "2023-04-26 11:45");
        lecture11.setThematicPath(thematicPath1);
        Lecture lecture12 = new Lecture("The risks", "2023-04-26 12:00", "2023-04-26 13:45");
        lecture12.setThematicPath(thematicPath1);
        Lecture lecture13 = new Lecture("Directions of the development", "2023-04-26 14:00", "2023-04-26 15:45");
        lecture13.setThematicPath(thematicPath1);

        Lecture lecture21 = new Lecture("Common mistakes", "2023-04-26 10:00", "2023-04-26 11:45");
        lecture21.setThematicPath(thematicPath2);
        Lecture lecture22 = new Lecture("How to avoid making mistakes", "2023-04-26 12:00", "2023-04-26 13:45");
        lecture22.setThematicPath(thematicPath2);
        Lecture lecture23 = new Lecture("Exercises that helps to improve our focus", "2023-04-26 14:00", "2023-04-26 15:45");
        lecture23.setThematicPath(thematicPath2);

        Lecture lecture31 = new Lecture("The IT market", "2023-04-26 10:00", "2023-04-26 11:45");
        lecture31.setThematicPath(thematicPath3);
        Lecture lecture32 = new Lecture("New technologies", "2023-04-26 12:00", "2023-04-26 13:45");
        lecture32.setThematicPath(thematicPath3);
        Lecture lecture33 = new Lecture("The groundbreaking tools", "2023-04-26 14:00", "2023-04-26 15:45");
        lecture33.setThematicPath(thematicPath3);

        thematicPath1.getLectures().addAll(Arrays.asList(lecture11, lecture12, lecture13));
        thematicPath2.getLectures().addAll(Arrays.asList(lecture21, lecture22, lecture23));
        thematicPath3.getLectures().addAll(Arrays.asList(lecture31, lecture32, lecture33));

        lectureRepository.saveAll(Arrays.asList(lecture11, lecture12, lecture13, lecture21, lecture22, lecture23, lecture31, lecture32, lecture33));
        thematicPathRepository.saveAll(Arrays.asList(thematicPath1, thematicPath2, thematicPath3));

        Customer customer1 = new Customer("andrzej", "andrzej.martines@gmail.com");
        customerRepository.save(customer1);

    }

}
