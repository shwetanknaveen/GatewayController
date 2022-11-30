package com.exam.architecturefinal.demo.Controller;


import com.exam.architecturefinal.demo.Models.Exam;
import com.exam.architecturefinal.demo.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Date;
import java.util.List;


@RestController
@CrossOrigin("*")
public class GatewayController {

    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(method = RequestMethod.POST, path = "/gateway/user/addUser")
    public void addUser(@RequestBody User user) {
        System.out.println("call came here in eureka controller");
        restTemplate.postForObject("http://user-service/addUser", user, Boolean.class);
    }

    @ResponseBody
    @GetMapping("/gateway/user/getUser")
    User getUser(@RequestParam String email, @RequestParam String password) {
        String url = "http://user-service/getUser?email=" + email + "&password=" + password;
        //User u = restTemplate.exchange(url, HttpMethod.GET, null, User.class).getBody();
        User u = restTemplate.getForObject(url, User.class);
        return u;
    }

    @GetMapping("/gateway/examList/getExams")
    List<Exam> getAllExams() {
        String url;
        url = "http://list-items-service/getExams";
//        ResponseEntity<List<Exam>> responseEntity = restTemplate.exchange(url, HttpMethod.GET, null, new ParameterizedTypeReference<List<Exam>>() {});
        List<Exam> exams;//= responseEntity.getBody();
//        return exams.stream().collect(Collectors.toList());

        Exam[] forNow = restTemplate.getForObject(url, Exam[].class);
        exams = Arrays.asList(forNow);
        return exams;
    }

    @GetMapping("/gateway/examList/getExams/{examCode}")
    List<Exam> getAllExamsByCode(@PathVariable String examCode) {
        String url = "http://list-items-service/getExams/" + examCode;

        List<Exam> exams;
        Exam[] forNow = restTemplate.getForObject(url, Exam[].class);
        exams = Arrays.asList(forNow);
        return exams;
    }

    @GetMapping("/gateway/examList/getExamsInAsc")
    List<Exam> getAllExamsInAsc() {

        String url = "http://list-items-service/getExamsInAsc";

        List<Exam> exams;
        Exam[] forNow = restTemplate.getForObject(url, Exam[].class);
        exams = Arrays.asList(forNow);
        return exams;
    }

    @GetMapping("/gateway/examList/getExamsInDesc")
    List<Exam> getAllExamsInDesc() {

        String url = "http://list-items-service/getExamsInAsc";

        List<Exam> exams;
        Exam[] forNow = restTemplate.getForObject(url, Exam[].class);
        exams = Arrays.asList(forNow);
        return exams;
    }

    @GetMapping("/gateway/examList/getExamsBetween")
    List<Exam> getAllExamsBetweenDate(
            @RequestParam("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,
            @RequestParam("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate
    ) {
        String url = "http://list-items-service/getExamsBetween?startDate=" + startDate + "&endDate=" + endDate;
        List<Exam> exams;
        Exam[] forNow = restTemplate.getForObject(url, Exam[].class);
        exams = Arrays.asList(forNow);
        return exams;
    }

    @PutMapping("/gateway/examUpdate/updateExam")
    public String updateExam(@RequestBody Exam exam) {
        String url = "http://update-items-service/updateExam";
        return restTemplate.postForObject(url, exam, String.class);
    }

    @PostMapping("/gateway/examUpdate/addExam")
    public String addNewExam(@RequestBody Exam exam) {
        String url = "http://update-items-service/addExam";
        return restTemplate.postForObject(url, exam, String.class);
    }


}
